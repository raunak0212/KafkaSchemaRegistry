package com.github.simplesteph.kafka.apps.v1;

import com.example.Customer;
import com.example.Customer2;
import com.example.Customer3;
import com.example.Employee;
import com.example.NewOne;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
//import com.httpClient.response.Employee;

import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.commons.codec.binary.Base64;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class KafkaAvroJavaStreamsV1Demo {
	
	public Properties buildStreamsProperties() {
	    Properties props = new Properties();

	    props.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-wordcount");
	    props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
	    props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
	    props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
	    props.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://127.0.0.1:8081");
	    props.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, 0);

	    return props;
	  }
	
	 @SuppressWarnings("unused")
		private SpecificAvroSerde<Employee> EmployeeSerde() {
			    final SpecificAvroSerde<Employee> serde = new SpecificAvroSerde<>();
			    Map<String, String> config = new HashMap<>();
			    config.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://127.0.0.1:8081");
			    serde.configure(config, false);
			    return serde;
			  }
	
	
	 @SuppressWarnings("unused")
	private SpecificAvroSerde<Customer> customerSerdeoriginal() {
		    final SpecificAvroSerde<Customer> serde = new SpecificAvroSerde<>();
		    Map<String, String> config = new HashMap<>();
		    config.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://127.0.0.1:8081");
		    serde.configure(config, false);
		    return serde;
		  }
	
	 private SpecificAvroSerde<Customer3> customerSerde() {
		    final SpecificAvroSerde<Customer3> serde = new SpecificAvroSerde<>();
		    Map<String, String> config = new HashMap<>();
		    config.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://127.0.0.1:8081");
		    serde.configure(config, false);
		    return serde;
		  }
	 

	 private SpecificAvroSerde<Customer2> customerSerde2() {
		    final SpecificAvroSerde<Customer2> serde = new SpecificAvroSerde<>();
		    Map<String, String> config = new HashMap<>();
		    config.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://127.0.0.1:8081");
		    serde.configure(config, false);
		    return serde;
		  }
	 
	 public Topology buildTopology(
             final SpecificAvroSerde<Customer3> specificAvroSerde) {
                   final StreamsBuilder builder = new StreamsBuilder();

                  final String inputTopic = "customer-avro1";
                  final String outputTopic = "output.test1.topic.name";

                  /*builder.stream(inputTopic, Consumed.with(Serdes.String(), customerSerde))
                  .filter((name, customer) -> "Johny".equals(customer.getFirstName()))
                  
                  .to(outputTopic, Produced.with(Serdes.String(), customerSerde));*/

                  
                  KStream<String, Customer> rawMovies = builder.stream(inputTopic,Consumed.with(Serdes.String()
                		  , customerSerdeoriginal()));
                  KStream<String, Customer3> movies = rawMovies.filter((name, customer) -> "Johny".equals(customer.getLastName()))
                          .map((key, rawMovie) ->
                          new KeyValue<String, Customer3>(key, convertRawMovie(rawMovie)));

                  movies
                  
                  .to(outputTopic,Produced.with(Serdes.String(), customerSerde()) );
                  
                  
                  
                  KStream<String, Customer2> movies2 = rawMovies.filter((name, customer) -> "Rama".equals(customer.getLastName()))
                          .map((key, rawMovie) ->
                          new KeyValue<String, Customer2>(key, convertRawMovie2(rawMovie)));

                  movies2
                  
                  .to("output.test2.topic.name",Produced.with(Serdes.String(), customerSerde2()) );
                  
                  return builder.build();
}
	 
	 
	 public static Customer3 convertRawMovie(Customer customer) {
	        
	        String name = customer.getFirstName();
	        System.out.println(name);
	        
	        
	        Gson g = new Gson();
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		
			
			
		    String a=name;
		    		//"eyJuYW1lIjoiUmFtIiwgImVtYWlsIjoiUmFtQGdtYWlsLmNvbSJ9";

			String jsonString	="{\"name\":\"abcddddd\",\"deviceName\":\"def\",\"dateTime\":\"\",\"transactionId\":\"ghi\",\"protocol\":\"\",\"protocolMethod\":\"\",\"Uri\":\"xyz1\",\"requestContentType\":\"\",\"txnRuleType\":\"\",\"clientIP\":\"\",\"errorHeaders\":\"\",\"statusMessage\":\"\",\"b64_body\":\"eyJjb29yZCI6eyJsb24iOjc5LjEsImxhdCI6MjEuMTV9LCJ3ZWF0aGVyIjpbeyJpZCI6NzIxLCJtYWluIjoiSGF6ZSIsImRlc2NyaXB0aW9uIjoiaGF6ZSIsImljb24iOiI1MG4ifV0sImJhc2UiOiJzdGF0aW9ucyIsIm1haW4iOnsidGVtcCI6MjkxLjE1LCJmZWVsc19saWtlIjoyODkuODQsInRlbXBfbWluIjoyOTEuMTUsInRlbXBfbWF4IjoyOTEuMTUsInByZXNzdXJlIjoxMDE0LCJodW1pZGl0eSI6NTV9LCJ2aXNpYmlsaXR5Ijo0MDAwLCJ3aW5kIjp7InNwZWVkIjoxLjUsImRlZyI6OTB9LCJjbG91ZHMiOnsiYWxsIjowfSwiZHQiOjE1Nzg5MzE0OTYsInN5cyI6eyJ0eXBlIjoxLCJpZCI6OTA2OSwiY291bnRyeSI6IklOIiwic3VucmlzZSI6MTU3ODg3ODU4Nywic3Vuc2V0IjoxNTc4OTE4MDIyfSwidGltZXpvbmUiOjE5ODAwLCJpZCI6MTI2MjE4MCwibmFtZSI6Ik5hZ3B1ciIsImNvZCI6MjAwfQ\u003d\u003d\",\"soapaction\":\"\"}";
			byte[] byteArray = Base64.decodeBase64(a.getBytes());
			String decodedString = new String(byteArray);
			System.out.println(decodedString);
			
			
			decodedString = decodedString.replaceAll("^\"|\"$", "");

			NewOne p = g.fromJson(decodedString, NewOne.class);
		
			System.out.println(p.getEmail());
			
	        
	        
	        
	        
	        return new Customer3(p.getName(),p.getEmail(),p.getLast());
	    }

	 
	 public static Customer2 convertRawMovie2(Customer customer) {
	        
	        String name = customer.getFirstName();
	        System.out.println(name);
	        
	        
	        Gson g = new Gson();
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		
			
			
		    String a=name;
		    		//"eyJuYW1lIjoiUmFtIiwgImVtYWlsIjoiUmFtQGdtYWlsLmNvbSJ9";

			String jsonString	="{\"name\":\"abcddddd\",\"deviceName\":\"def\",\"dateTime\":\"\",\"transactionId\":\"ghi\",\"protocol\":\"\",\"protocolMethod\":\"\",\"Uri\":\"xyz1\",\"requestContentType\":\"\",\"txnRuleType\":\"\",\"clientIP\":\"\",\"errorHeaders\":\"\",\"statusMessage\":\"\",\"b64_body\":\"eyJjb29yZCI6eyJsb24iOjc5LjEsImxhdCI6MjEuMTV9LCJ3ZWF0aGVyIjpbeyJpZCI6NzIxLCJtYWluIjoiSGF6ZSIsImRlc2NyaXB0aW9uIjoiaGF6ZSIsImljb24iOiI1MG4ifV0sImJhc2UiOiJzdGF0aW9ucyIsIm1haW4iOnsidGVtcCI6MjkxLjE1LCJmZWVsc19saWtlIjoyODkuODQsInRlbXBfbWluIjoyOTEuMTUsInRlbXBfbWF4IjoyOTEuMTUsInByZXNzdXJlIjoxMDE0LCJodW1pZGl0eSI6NTV9LCJ2aXNpYmlsaXR5Ijo0MDAwLCJ3aW5kIjp7InNwZWVkIjoxLjUsImRlZyI6OTB9LCJjbG91ZHMiOnsiYWxsIjowfSwiZHQiOjE1Nzg5MzE0OTYsInN5cyI6eyJ0eXBlIjoxLCJpZCI6OTA2OSwiY291bnRyeSI6IklOIiwic3VucmlzZSI6MTU3ODg3ODU4Nywic3Vuc2V0IjoxNTc4OTE4MDIyfSwidGltZXpvbmUiOjE5ODAwLCJpZCI6MTI2MjE4MCwibmFtZSI6Ik5hZ3B1ciIsImNvZCI6MjAwfQ\u003d\u003d\",\"soapaction\":\"\"}";
			byte[] byteArray = Base64.decodeBase64(a.getBytes());
			String decodedString = new String(byteArray);
			System.out.println(decodedString);
			
			
			decodedString = decodedString.replaceAll("^\"|\"$", "");

			NewOne p = g.fromJson(decodedString, NewOne.class);
		
			System.out.println(p.getEmail());
			
	        
	        
	        
	        
	        return new Customer2(p.getName());
	    }

	 
	 
	 @SuppressWarnings("unused")
	private void runRecipe() throws IOException {
		   // Properties envProps = this.loadEnvProperties(configPath);
		   Properties streamProps = this.buildStreamsProperties();

		    Topology topology = this.buildTopology( this.customerSerde());
		   // this.createTopics(envProps);

		    final KafkaStreams streams = new KafkaStreams(topology, streamProps);
		    final CountDownLatch latch = new CountDownLatch(1);

		    // Attach shutdown handler to catch Control-C.
		    Runtime.getRuntime().addShutdownHook(new Thread("streams-shutdown-hook") {
		      @Override
		      public void run() {
		        streams.close();
		        latch.countDown();
		      }
		    });

		    try {
		      streams.start();
		      latch.await();
		    } catch (Throwable e) {
		      System.exit(1);
		    }
		    System.exit(0);

		  }
		
	
    public static void main(String[] args) throws IOException {/*
        Properties properties = new Properties();
        // normal consumer
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-wordcount");
        properties.setProperty("bootstrap.servers","127.0.0.1:9092");
        properties.put("group.id", "customer-consumer-group-v1");
        properties.put("auto.commit.enable", "false");
        properties.put("auto.offset.reset", "earliest");

        // avro part (deserializer)
        properties.setProperty("key.deserializer", Serdes.String().getClass().getName());
        properties.setProperty("value.deserializer", Serdes.String().getClass().getName());
        properties.setProperty("schema.registry.url", "http://127.0.0.1:8081");
        properties.setProperty("specific.avro.reader", "true");

        
        String topic = "customer-avro";
        
        KStreamBuilder builder = new KStreamBuilder();
        KStream<String, Customer> source = builder.<String, Customer>stream(topic);
        source.filter((name, publication) -> publication.getFirstName().contains("John"))
        .to("output.test1.topic.name");
        
        
        final KafkaStreams streams = new KafkaStreams(builder, properties);
        final CountDownLatch latch = new CountDownLatch(1);
        // attach shutdown handler to catch control-c
        Runtime.getRuntime().addShutdownHook(new Thread("streams-shutdown-hook") {
            @Override
            public void run() {
                streams.close();
                latch.countDown();
            }
        });
 
        try {
            streams.start();
            latch.await();
        } catch (Throwable e) {
            System.exit(1);
        }
        System.exit(0);
    */
    	
    
    
    
    	new KafkaAvroJavaStreamsV1Demo().runRecipe();
    
    
    
    
    }
        
       
    }

