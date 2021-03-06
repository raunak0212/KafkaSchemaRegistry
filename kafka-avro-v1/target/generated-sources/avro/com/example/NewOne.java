/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.example;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class NewOne extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 8041847562014699561L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"NewOne\",\"namespace\":\"com.example\",\"fields\":[{\"name\":\"name\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"email\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"default\":\"NA\"},{\"name\":\"last\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"default\":\"NA\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<NewOne> ENCODER =
      new BinaryMessageEncoder<NewOne>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<NewOne> DECODER =
      new BinaryMessageDecoder<NewOne>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<NewOne> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<NewOne> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<NewOne>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this NewOne to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a NewOne from a ByteBuffer. */
  public static NewOne fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.String name;
   private java.lang.String email;
   private java.lang.String last;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public NewOne() {}

  /**
   * All-args constructor.
   * @param name The new value for name
   * @param email The new value for email
   * @param last The new value for last
   */
  public NewOne(java.lang.String name, java.lang.String email, java.lang.String last) {
    this.name = name;
    this.email = email;
    this.last = last;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return name;
    case 1: return email;
    case 2: return last;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: name = (java.lang.String)value$; break;
    case 1: email = (java.lang.String)value$; break;
    case 2: last = (java.lang.String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.String getName() {
    return name;
  }


  /**
   * Gets the value of the 'email' field.
   * @return The value of the 'email' field.
   */
  public java.lang.String getEmail() {
    return email;
  }


  /**
   * Gets the value of the 'last' field.
   * @return The value of the 'last' field.
   */
  public java.lang.String getLast() {
    return last;
  }


  /**
   * Creates a new NewOne RecordBuilder.
   * @return A new NewOne RecordBuilder
   */
  public static com.example.NewOne.Builder newBuilder() {
    return new com.example.NewOne.Builder();
  }

  /**
   * Creates a new NewOne RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new NewOne RecordBuilder
   */
  public static com.example.NewOne.Builder newBuilder(com.example.NewOne.Builder other) {
    return new com.example.NewOne.Builder(other);
  }

  /**
   * Creates a new NewOne RecordBuilder by copying an existing NewOne instance.
   * @param other The existing instance to copy.
   * @return A new NewOne RecordBuilder
   */
  public static com.example.NewOne.Builder newBuilder(com.example.NewOne other) {
    return new com.example.NewOne.Builder(other);
  }

  /**
   * RecordBuilder for NewOne instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<NewOne>
    implements org.apache.avro.data.RecordBuilder<NewOne> {

    private java.lang.String name;
    private java.lang.String email;
    private java.lang.String last;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.example.NewOne.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.email)) {
        this.email = data().deepCopy(fields()[1].schema(), other.email);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.last)) {
        this.last = data().deepCopy(fields()[2].schema(), other.last);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing NewOne instance
     * @param other The existing instance to copy.
     */
    private Builder(com.example.NewOne other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.email)) {
        this.email = data().deepCopy(fields()[1].schema(), other.email);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.last)) {
        this.last = data().deepCopy(fields()[2].schema(), other.last);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.String getName() {
      return name;
    }

    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public com.example.NewOne.Builder setName(java.lang.String value) {
      validate(fields()[0], value);
      this.name = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public com.example.NewOne.Builder clearName() {
      name = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'email' field.
      * @return The value.
      */
    public java.lang.String getEmail() {
      return email;
    }

    /**
      * Sets the value of the 'email' field.
      * @param value The value of 'email'.
      * @return This builder.
      */
    public com.example.NewOne.Builder setEmail(java.lang.String value) {
      validate(fields()[1], value);
      this.email = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'email' field has been set.
      * @return True if the 'email' field has been set, false otherwise.
      */
    public boolean hasEmail() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'email' field.
      * @return This builder.
      */
    public com.example.NewOne.Builder clearEmail() {
      email = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'last' field.
      * @return The value.
      */
    public java.lang.String getLast() {
      return last;
    }

    /**
      * Sets the value of the 'last' field.
      * @param value The value of 'last'.
      * @return This builder.
      */
    public com.example.NewOne.Builder setLast(java.lang.String value) {
      validate(fields()[2], value);
      this.last = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'last' field has been set.
      * @return True if the 'last' field has been set, false otherwise.
      */
    public boolean hasLast() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'last' field.
      * @return This builder.
      */
    public com.example.NewOne.Builder clearLast() {
      last = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public NewOne build() {
      try {
        NewOne record = new NewOne();
        record.name = fieldSetFlags()[0] ? this.name : (java.lang.String) defaultValue(fields()[0]);
        record.email = fieldSetFlags()[1] ? this.email : (java.lang.String) defaultValue(fields()[1]);
        record.last = fieldSetFlags()[2] ? this.last : (java.lang.String) defaultValue(fields()[2]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<NewOne>
    WRITER$ = (org.apache.avro.io.DatumWriter<NewOne>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<NewOne>
    READER$ = (org.apache.avro.io.DatumReader<NewOne>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
