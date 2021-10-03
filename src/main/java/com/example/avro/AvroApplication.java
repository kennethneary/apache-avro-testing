package com.example.avro;

import com.example.avro.made.EmployeeReal;
import example.avro.Employee;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;

import java.io.File;

public class AvroApplication {

    public static final Schema EMPLOYEE_REAL_SCHEMA = new Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Employee\",\"namespace\":\"example.avro\",\"fields\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"id\",\"type\":\"int\"},{\"name\":\"salary\",\"type\":\"int\"},{\"name\":\"age\",\"type\":\"int\"},{\"name\":\"address\",\"type\":\"string\"},{\"name\":\"any\",\"type\":{\"type\":\"record\",\"name\":\"Object\",\"fields\":[]}}]}");

//    public static final Schema EMPLOYEE_REAL_SCHEMA = new Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Employee\",\"namespace\":\"example.avro\",\"fields\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"id\",\"type\":\"int\"},{\"name\":\"salary\",\"type\":\"int\"},{\"name\":\"age\",\"type\":\"int\"},{\"name\":\"address\",\"type\":\"string\"}]}");

//    public static final Schema EMPLOYEE_REAL_SCHEMA = new Schema.Parser().parse("{\n" +
//        "  \"type\" : \"record\",\n" +
//        "  \"name\" : \"EmployeeReal\",\n" +
//        "  \"namespace\" : \"com.example.avro.made\",\n" +
//        "  \"fields\" : [ {\n" +
//        "    \"name\" : \"address\",\n" +
//        "    \"type\" : [ \"null\", \"string\" ],\n" +
//        "    \"default\" : null\n" +
//        "  }, {\n" +
//        "    \"name\" : \"age\",\n" +
//        "    \"type\" : \"int\"\n" +
//        "  }, {\n" +
//        "    \"name\" : \"any\",\n" +
//        "    \"type\" : [ \"null\", {\n" +
//        "      \"type\" : \"record\",\n" +
//        "      \"name\" : \"Sample\",\n" +
//        "      \"fields\" : [ {\n" +
//        "        \"name\" : \"id\",\n" +
//        "        \"type\" : \"int\"\n" +
//        "      }, {\n" +
//        "        \"name\" : \"name\",\n" +
//        "        \"type\" : [ \"null\", \"string\" ],\n" +
//        "        \"default\" : null\n" +
//        "      } ]\n" +
//        "    } ],\n" +
//        "    \"default\" : null\n" +
//        "  }, {\n" +
//        "    \"name\" : \"id\",\n" +
//        "    \"type\" : \"int\"\n" +
//        "  }, {\n" +
//        "    \"name\" : \"name\",\n" +
//        "    \"type\" : [ \"null\", \"string\" ],\n" +
//        "    \"default\" : null\n" +
//        "  }, {\n" +
//        "    \"name\" : \"salary\",\n" +
//        "    \"type\" : \"int\"\n" +
//        "  } ]\n" +
//        "}");

//    public static final Schema EMPLOYEE_REAL_SCHEMA = new Schema.Parser().parse("{\n" +
//            "   \"namespace\": \"example.avro\",\n" +
//            "   \"type\": \"record\",\n" +
//            "   \"name\": \"Employee\",\n" +
//            "   \"fields\": [\n" +
//            "      {\"name\": \"name\", \"type\": \"string\"},\n" +
//            "      {\"name\": \"id\", \"type\": \"int\"},\n" +
//            "      {\"name\": \"salary\", \"type\": \"int\"},\n" +
//            "      {\"name\": \"age\", \"type\": \"int\"},\n" +
//            "      {\"name\": \"address\", \"type\": \"string\"},\n" +
//            "      {\"name\": \"any\", \"type\": {\"type\": \"record\", \"name\": \"Object\", \"fields\": []}}\n" +
//            "   ]\n" +
//            "}");


    public static void main(String[] args) throws Exception {
        Employee e1 = new Employee();
        e1.setName("omar");
        e1.setAge(21);
        e1.setSalary(30000);
        e1.setAddress("Hyderabad");
        e1.setId(001);
        e1.setAny(new example.avro.Object());

        EmployeeReal e2 = new EmployeeReal();
        e2.setName("omar");
        e2.setAge(21);
        e2.setSalary(30000);
        e2.setAddress("Hyderabad");
        e2.setId(001);
//        e2.setAny(e1);
//        e2.setAny(new Integer(987));
        e2.setAny("jfdshjkshfsdjfjsdfhjkfsdhkjfsdhkfsdhjkdsfhjkfdshjkfdshjkfdshjkdfsjhkdfsjhk");
//        e2.setAny(new Object());
//        e2.setAny(Sample.builder().id(4).name("ffff").build());
//
        AvroApplication avroApplication = new AvroApplication();

        Employee employee = null;
        byte[] data = null;
        GenericRecord genericRecord = null;

        AvroUtil.getSchema(e1);
        AvroUtil.getSchema(e2);

        // 1 BinaryFile
        File file = new File("src/main/avro/employee.avro");
        AvroUtil.serializeBinaryFile(e1, e1.getSchema(), file);
        employee = AvroUtil.deserializeBinaryFile(file, Employee.class);
        System.out.println("BinaryFile - employee: " + employee);

        // 2 AvroJSON
        data = AvroUtil.serializeAvroJSON(e1, e1.getSchema());
        System.out.println("AvroJSON - text: " + new String(data));
        employee = AvroUtil.deSerializeAvroJSON(data, e1.getSchema());
        System.out.println("AvroJSON - employee: " + employee);

        // 3 Generic - generated class
        File fileGeneric = new File("src/main/avro/employee_generic.avro");
        AvroUtil.serializeGeneric(e1, fileGeneric, e1.getSchema());
        genericRecord = AvroUtil.deserializeGeneric(fileGeneric, e1.getSchema());
        System.out.println("Generic - employee: " + genericRecord);

//        File fileGeneric2 = new File("src/main/avro/employee_generic_2.avro");
//        AvroUtil.serializeGeneric(e2, fileGeneric2, EMPLOYEE_REAL_SCHEMA);
//        genericRecord = AvroUtil.deserializeGeneric(fileGeneric2, EMPLOYEE_REAL_SCHEMA);
//        System.out.println("Generic - employeeReal: " + genericRecord);


        // 4 Generic
        data = AvroUtil.serializeGenericObject(e1, e1.getSchema());
        System.out.println("Generic - genericRecord - employee - size : " + data.length);
        genericRecord = AvroUtil.deserializeBinaryGeneric(data, e1.getSchema());
        System.out.println("Generic - genericRecord - employee: " + genericRecord);

        data = AvroUtil.serializeGenericObject(e2, EMPLOYEE_REAL_SCHEMA);
        System.out.println("Generic - genericRecord - employeeReal - size : " + data.length);
        genericRecord = AvroUtil.deserializeBinaryGeneric(data, EMPLOYEE_REAL_SCHEMA);
        System.out.println("Generic - genericRecord - employeeReal: " + genericRecord);
    }
}
