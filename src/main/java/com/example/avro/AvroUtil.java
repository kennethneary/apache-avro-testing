package com.example.avro;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.file.SeekableByteArrayInput;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.*;
import org.apache.avro.reflect.ReflectData;
import org.apache.avro.reflect.ReflectDatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.ByteArrayOutputStream;
import java.io.File;

public class AvroUtil {
    public static <T> void serializeBinaryFile(T obj, Schema schema, File file) throws Exception {
        DatumWriter<T> writer = new SpecificDatumWriter<>(schema);
        DataFileWriter<T> fileWriter = new DataFileWriter<>(writer);
        fileWriter.create(schema, file);
        fileWriter.append(obj);
        fileWriter.close();
    }

    public static <T> T deserializeBinaryFile(File file, Class<T> c) throws Exception {
        DatumReader<T> reader = new SpecificDatumReader<>(c);
        DataFileReader<T> fileReader = new DataFileReader<>(file, reader);
        return fileReader.next(null);
    }


    public static <T> byte[] serializeAvroJSON(T obj, Schema schema) throws Exception {
        DatumWriter<T> writer = new SpecificDatumWriter<T>(schema);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Encoder jsonEncoder = EncoderFactory.get().jsonEncoder(schema, stream);
        writer.write(obj, jsonEncoder);
        jsonEncoder.flush();
        return stream.toByteArray();
    }

    public static <T> T deSerializeAvroJSON(byte[] data, Schema schema) throws Exception {
        DatumReader<T> reader = new SpecificDatumReader<>(schema);
        Decoder decoder = DecoderFactory.get().jsonDecoder(schema, new String(data));
        T read = reader.read(null, decoder);
        return read;
    }


    public static void serializeGeneric(GenericRecord obj, File file, Schema schema) throws Exception {
        DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<>(schema);
        DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<>(datumWriter);
        dataFileWriter.create(schema, file);
        dataFileWriter.append(obj);
        dataFileWriter.close();
    }

    public static GenericRecord deserializeGeneric(File file, Schema schema) throws Exception {
        DatumReader<GenericRecord> datumReader = new GenericDatumReader<>(schema);
        DataFileReader<GenericRecord> dataFileReader = new DataFileReader<>(file, datumReader);
        return dataFileReader.next(null);
    }


    public static byte[] serializeGenericObject(Object obj, Schema schema) throws Exception {
        ReflectDatumWriter<Object> datumWriter = new ReflectDatumWriter<>(schema);
        ByteArrayOutputStream dataStream = new ByteArrayOutputStream();
        DataFileWriter<Object> dataFileWriter = new DataFileWriter<>(datumWriter);
        dataFileWriter.create(schema, dataStream);
        dataFileWriter.append(obj);
        dataFileWriter.close();
        return dataStream.toByteArray();
    }

    public static GenericRecord deserializeBinaryGeneric(byte[] serialisedData, Schema schema) throws Exception {
//        DatumReader<GenericRecord> datumReader = new GenericDatumReader<>(schema);
        DatumReader<GenericRecord> datumReader = new GenericDatumReader<>();
        SeekableByteArrayInput sin = new SeekableByteArrayInput(serialisedData);
        DataFileReader<GenericRecord> dataFileReader = new DataFileReader<>(sin, datumReader);
        return dataFileReader.next(null);
    }


    public static Schema getSchema(Object obj) {
        ReflectData reflectData = new ReflectData.AllowNull();
        Schema schema = reflectData.getSchema(obj.getClass());
        String json = schema.toString(true);
        System.out.println("-----------------------------");
        System.out.println("getSchema - json: " + json);
        System.out.println("-----------------------------");
        return schema;
    }
}
