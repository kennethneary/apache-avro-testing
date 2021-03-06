/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package example.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class Object extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -119284985648421247L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Object\",\"namespace\":\"example.avro\",\"fields\":[]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Object> ENCODER =
      new BinaryMessageEncoder<Object>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Object> DECODER =
      new BinaryMessageDecoder<Object>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Object> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Object> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Object> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Object>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Object to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Object from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Object instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Object fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }


  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Creates a new Object RecordBuilder.
   * @return A new Object RecordBuilder
   */
  public static example.avro.Object.Builder newBuilder() {
    return new example.avro.Object.Builder();
  }

  /**
   * Creates a new Object RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Object RecordBuilder
   */
  public static example.avro.Object.Builder newBuilder(example.avro.Object.Builder other) {
    if (other == null) {
      return new example.avro.Object.Builder();
    } else {
      return new example.avro.Object.Builder(other);
    }
  }

  /**
   * Creates a new Object RecordBuilder by copying an existing Object instance.
   * @param other The existing instance to copy.
   * @return A new Object RecordBuilder
   */
  public static example.avro.Object.Builder newBuilder(example.avro.Object other) {
    if (other == null) {
      return new example.avro.Object.Builder();
    } else {
      return new example.avro.Object.Builder(other);
    }
  }

  /**
   * RecordBuilder for Object instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Object>
    implements org.apache.avro.data.RecordBuilder<Object> {


    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(example.avro.Object.Builder other) {
      super(other);
    }

    /**
     * Creates a Builder by copying an existing Object instance
     * @param other The existing instance to copy.
     */
    private Builder(example.avro.Object other) {
      super(SCHEMA$);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object build() {
      try {
        Object record = new Object();
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Object>
    WRITER$ = (org.apache.avro.io.DatumWriter<Object>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Object>
    READER$ = (org.apache.avro.io.DatumReader<Object>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
    } else {
      for (int i = 0; i < 0; i++) {
        switch (fieldOrder[i].pos()) {
        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










