// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonIntegerFormatVisitor;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonNumberFormatVisitor;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

// Referenced classes of package com.fasterxml.jackson.databind.ser.std:
//            NonTypedScalarSerializerBase, StdScalarSerializer

public class NumberSerializers
{
    public static final class DoubleSerializer extends NonTypedScalarSerializerBase
    {

        static final DoubleSerializer instance = new DoubleSerializer();

        public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonformatvisitorwrapper, JavaType javatype)
            throws JsonMappingException
        {
            jsonformatvisitorwrapper = jsonformatvisitorwrapper.expectNumberFormat(javatype);
            if (jsonformatvisitorwrapper != null)
            {
                jsonformatvisitorwrapper.numberType(com.fasterxml.jackson.core.JsonParser.NumberType.DOUBLE);
            }
        }

        public JsonNode getSchema(SerializerProvider serializerprovider, Type type)
        {
            return createSchemaNode("number", true);
        }

        public void serialize(Double double1, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
            throws IOException, JsonGenerationException
        {
            jsongenerator.writeNumber(double1.doubleValue());
        }

        public volatile void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
            throws IOException, JsonGenerationException
        {
            serialize((Double)obj, jsongenerator, serializerprovider);
        }


        public DoubleSerializer()
        {
            super(java/lang/Double);
        }
    }

    public static final class FloatSerializer extends StdScalarSerializer
    {

        static final FloatSerializer instance = new FloatSerializer();

        public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonformatvisitorwrapper, JavaType javatype)
            throws JsonMappingException
        {
            jsonformatvisitorwrapper = jsonformatvisitorwrapper.expectNumberFormat(javatype);
            if (jsonformatvisitorwrapper != null)
            {
                jsonformatvisitorwrapper.numberType(com.fasterxml.jackson.core.JsonParser.NumberType.FLOAT);
            }
        }

        public JsonNode getSchema(SerializerProvider serializerprovider, Type type)
        {
            return createSchemaNode("number", true);
        }

        public void serialize(Float float1, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
            throws IOException, JsonGenerationException
        {
            jsongenerator.writeNumber(float1.floatValue());
        }

        public volatile void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
            throws IOException, JsonGenerationException
        {
            serialize((Float)obj, jsongenerator, serializerprovider);
        }


        public FloatSerializer()
        {
            super(java/lang/Float);
        }
    }

    public static final class IntLikeSerializer extends StdScalarSerializer
    {

        static final IntLikeSerializer instance = new IntLikeSerializer();

        public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonformatvisitorwrapper, JavaType javatype)
            throws JsonMappingException
        {
            jsonformatvisitorwrapper = jsonformatvisitorwrapper.expectIntegerFormat(javatype);
            if (jsonformatvisitorwrapper != null)
            {
                jsonformatvisitorwrapper.numberType(com.fasterxml.jackson.core.JsonParser.NumberType.INT);
            }
        }

        public JsonNode getSchema(SerializerProvider serializerprovider, Type type)
        {
            return createSchemaNode("integer", true);
        }

        public void serialize(Number number, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
            throws IOException, JsonGenerationException
        {
            jsongenerator.writeNumber(number.intValue());
        }

        public volatile void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
            throws IOException, JsonGenerationException
        {
            serialize((Number)obj, jsongenerator, serializerprovider);
        }


        public IntLikeSerializer()
        {
            super(java/lang/Number);
        }
    }

    public static final class IntegerSerializer extends NonTypedScalarSerializerBase
    {

        public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonformatvisitorwrapper, JavaType javatype)
            throws JsonMappingException
        {
            jsonformatvisitorwrapper = jsonformatvisitorwrapper.expectIntegerFormat(javatype);
            if (jsonformatvisitorwrapper != null)
            {
                jsonformatvisitorwrapper.numberType(com.fasterxml.jackson.core.JsonParser.NumberType.INT);
            }
        }

        public JsonNode getSchema(SerializerProvider serializerprovider, Type type)
        {
            return createSchemaNode("integer", true);
        }

        public void serialize(Integer integer, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
            throws IOException, JsonGenerationException
        {
            jsongenerator.writeNumber(integer.intValue());
        }

        public volatile void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
            throws IOException, JsonGenerationException
        {
            serialize((Integer)obj, jsongenerator, serializerprovider);
        }

        public IntegerSerializer()
        {
            super(java/lang/Integer);
        }
    }

    public static final class LongSerializer extends StdScalarSerializer
    {

        static final LongSerializer instance = new LongSerializer();

        public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonformatvisitorwrapper, JavaType javatype)
            throws JsonMappingException
        {
            jsonformatvisitorwrapper = jsonformatvisitorwrapper.expectIntegerFormat(javatype);
            if (jsonformatvisitorwrapper != null)
            {
                jsonformatvisitorwrapper.numberType(com.fasterxml.jackson.core.JsonParser.NumberType.LONG);
            }
        }

        public JsonNode getSchema(SerializerProvider serializerprovider, Type type)
        {
            return createSchemaNode("number", true);
        }

        public void serialize(Long long1, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
            throws IOException, JsonGenerationException
        {
            jsongenerator.writeNumber(long1.longValue());
        }

        public volatile void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
            throws IOException, JsonGenerationException
        {
            serialize((Long)obj, jsongenerator, serializerprovider);
        }


        public LongSerializer()
        {
            super(java/lang/Long);
        }
    }

    public static final class NumberSerializer extends StdScalarSerializer
    {

        public static final NumberSerializer instance = new NumberSerializer();

        public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonformatvisitorwrapper, JavaType javatype)
            throws JsonMappingException
        {
            jsonformatvisitorwrapper = jsonformatvisitorwrapper.expectNumberFormat(javatype);
            if (jsonformatvisitorwrapper != null)
            {
                jsonformatvisitorwrapper.numberType(com.fasterxml.jackson.core.JsonParser.NumberType.BIG_DECIMAL);
            }
        }

        public JsonNode getSchema(SerializerProvider serializerprovider, Type type)
        {
            return createSchemaNode("number", true);
        }

        public void serialize(Number number, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
            throws IOException, JsonGenerationException
        {
            if (number instanceof BigDecimal)
            {
                jsongenerator.writeNumber((BigDecimal)number);
                return;
            }
            if (number instanceof BigInteger)
            {
                jsongenerator.writeNumber((BigInteger)number);
                return;
            }
            if (number instanceof Integer)
            {
                jsongenerator.writeNumber(number.intValue());
                return;
            }
            if (number instanceof Long)
            {
                jsongenerator.writeNumber(number.longValue());
                return;
            }
            if (number instanceof Double)
            {
                jsongenerator.writeNumber(number.doubleValue());
                return;
            }
            if (number instanceof Float)
            {
                jsongenerator.writeNumber(number.floatValue());
                return;
            }
            if ((number instanceof Byte) || (number instanceof Short))
            {
                jsongenerator.writeNumber(number.intValue());
                return;
            } else
            {
                jsongenerator.writeNumber(number.toString());
                return;
            }
        }

        public volatile void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
            throws IOException, JsonGenerationException
        {
            serialize((Number)obj, jsongenerator, serializerprovider);
        }


        public NumberSerializer()
        {
            super(java/lang/Number);
        }
    }

    public static final class ShortSerializer extends StdScalarSerializer
    {

        static final ShortSerializer instance = new ShortSerializer();

        public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonformatvisitorwrapper, JavaType javatype)
            throws JsonMappingException
        {
            jsonformatvisitorwrapper = jsonformatvisitorwrapper.expectIntegerFormat(javatype);
            if (jsonformatvisitorwrapper != null)
            {
                jsonformatvisitorwrapper.numberType(com.fasterxml.jackson.core.JsonParser.NumberType.INT);
            }
        }

        public JsonNode getSchema(SerializerProvider serializerprovider, Type type)
        {
            return createSchemaNode("number", true);
        }

        public volatile void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
            throws IOException, JsonGenerationException
        {
            serialize((Short)obj, jsongenerator, serializerprovider);
        }

        public void serialize(Short short1, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
            throws IOException, JsonGenerationException
        {
            jsongenerator.writeNumber(short1.shortValue());
        }


        public ShortSerializer()
        {
            super(java/lang/Short);
        }
    }


    protected NumberSerializers()
    {
    }

    public static void addAll(Map map)
    {
        IntegerSerializer integerserializer = new IntegerSerializer();
        map.put(java/lang/Integer.getName(), integerserializer);
        map.put(Integer.TYPE.getName(), integerserializer);
        map.put(java/lang/Long.getName(), LongSerializer.instance);
        map.put(Long.TYPE.getName(), LongSerializer.instance);
        map.put(java/lang/Byte.getName(), IntLikeSerializer.instance);
        map.put(Byte.TYPE.getName(), IntLikeSerializer.instance);
        map.put(java/lang/Short.getName(), ShortSerializer.instance);
        map.put(Short.TYPE.getName(), ShortSerializer.instance);
        map.put(java/lang/Float.getName(), FloatSerializer.instance);
        map.put(Float.TYPE.getName(), FloatSerializer.instance);
        map.put(java/lang/Double.getName(), DoubleSerializer.instance);
        map.put(Double.TYPE.getName(), DoubleSerializer.instance);
    }
}
