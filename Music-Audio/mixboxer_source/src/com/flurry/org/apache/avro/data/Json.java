// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.data;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.io.DatumReader;
import com.flurry.org.apache.avro.io.DatumWriter;
import com.flurry.org.apache.avro.io.Decoder;
import com.flurry.org.apache.avro.io.DecoderFactory;
import com.flurry.org.apache.avro.io.Encoder;
import com.flurry.org.apache.avro.io.ResolvingDecoder;
import com.flurry.org.codehaus.jackson.JsonNode;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.node.ArrayNode;
import com.flurry.org.codehaus.jackson.node.BooleanNode;
import com.flurry.org.codehaus.jackson.node.DoubleNode;
import com.flurry.org.codehaus.jackson.node.JsonNodeFactory;
import com.flurry.org.codehaus.jackson.node.LongNode;
import com.flurry.org.codehaus.jackson.node.NullNode;
import com.flurry.org.codehaus.jackson.node.ObjectNode;
import com.flurry.org.codehaus.jackson.node.TextNode;
import java.io.IOException;
import java.util.Iterator;

public class Json
{
    private static final class JsonType extends Enum
    {

        private static final JsonType $VALUES[];
        public static final JsonType ARRAY;
        public static final JsonType BOOLEAN;
        public static final JsonType DOUBLE;
        public static final JsonType LONG;
        public static final JsonType NULL;
        public static final JsonType OBJECT;
        public static final JsonType STRING;

        public static JsonType valueOf(String s)
        {
            return (JsonType)Enum.valueOf(com/flurry/org/apache/avro/data/Json$JsonType, s);
        }

        public static JsonType[] values()
        {
            return (JsonType[])$VALUES.clone();
        }

        static 
        {
            LONG = new JsonType("LONG", 0);
            DOUBLE = new JsonType("DOUBLE", 1);
            STRING = new JsonType("STRING", 2);
            BOOLEAN = new JsonType("BOOLEAN", 3);
            NULL = new JsonType("NULL", 4);
            ARRAY = new JsonType("ARRAY", 5);
            OBJECT = new JsonType("OBJECT", 6);
            $VALUES = (new JsonType[] {
                LONG, DOUBLE, STRING, BOOLEAN, NULL, ARRAY, OBJECT
            });
        }

        private JsonType(String s, int i)
        {
            super(s, i);
        }
    }

    public static class Reader
        implements DatumReader
    {

        private ResolvingDecoder resolver;
        private Schema written;

        public JsonNode read(JsonNode jsonnode, Decoder decoder)
            throws IOException
        {
            if (written == null)
            {
                return Json.read(decoder);
            }
            if (resolver == null)
            {
                resolver = DecoderFactory.get().resolvingDecoder(written, Json.SCHEMA, null);
            }
            resolver.configure(decoder);
            jsonnode = Json.read(resolver);
            resolver.drain();
            return jsonnode;
        }

        public volatile Object read(Object obj, Decoder decoder)
            throws IOException
        {
            return read((JsonNode)obj, decoder);
        }

        public void setSchema(Schema schema)
        {
            if (Json.SCHEMA.equals(written))
            {
                schema = null;
            }
            written = schema;
        }

        public Reader()
        {
        }
    }

    public static class Writer
        implements DatumWriter
    {

        public void setSchema(Schema schema)
        {
            if (!Json.SCHEMA.equals(schema))
            {
                throw new RuntimeException((new StringBuilder()).append("Not the Json schema: ").append(schema).toString());
            } else
            {
                return;
            }
        }

        public void write(JsonNode jsonnode, Encoder encoder)
            throws IOException
        {
            Json.write(jsonnode, encoder);
        }

        public volatile void write(Object obj, Encoder encoder)
            throws IOException
        {
            write((JsonNode)obj, encoder);
        }

        public Writer()
        {
        }
    }


    public static final Schema SCHEMA;

    private Json()
    {
    }

    public static JsonNode read(Decoder decoder)
        throws IOException
    {
        static class _cls1
        {

            static final int $SwitchMap$org$apache$avro$data$Json$JsonType[];
            static final int $SwitchMap$org$codehaus$jackson$JsonToken[];

            static 
            {
                $SwitchMap$org$apache$avro$data$Json$JsonType = new int[JsonType.values().length];
                try
                {
                    $SwitchMap$org$apache$avro$data$Json$JsonType[JsonType.LONG.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$org$apache$avro$data$Json$JsonType[JsonType.DOUBLE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$org$apache$avro$data$Json$JsonType[JsonType.STRING.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$org$apache$avro$data$Json$JsonType[JsonType.BOOLEAN.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$org$apache$avro$data$Json$JsonType[JsonType.NULL.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$org$apache$avro$data$Json$JsonType[JsonType.ARRAY.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$org$apache$avro$data$Json$JsonType[JsonType.OBJECT.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                $SwitchMap$org$codehaus$jackson$JsonToken = new int[JsonToken.values().length];
                try
                {
                    $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.VALUE_NUMBER_INT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.VALUE_STRING.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.VALUE_TRUE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.VALUE_FALSE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.VALUE_NULL.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.START_ARRAY.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.START_OBJECT.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        ObjectNode objectnode;
        long l1;
        switch (_cls1..SwitchMap.org.apache.avro.data.Json.JsonType[JsonType.values()[decoder.readIndex()].ordinal()])
        {
        default:
            throw new AvroRuntimeException("Unexpected Json node type");

        case 1: // '\001'
            return new LongNode(decoder.readLong());

        case 2: // '\002'
            return new DoubleNode(decoder.readDouble());

        case 3: // '\003'
            return new TextNode(decoder.readString());

        case 4: // '\004'
            if (decoder.readBoolean())
            {
                return BooleanNode.TRUE;
            } else
            {
                return BooleanNode.FALSE;
            }

        case 5: // '\005'
            decoder.readNull();
            return NullNode.getInstance();

        case 6: // '\006'
            ArrayNode arraynode = JsonNodeFactory.instance.arrayNode();
            for (long l = decoder.readArrayStart(); l > 0L; l = decoder.arrayNext())
            {
                for (long l2 = 0L; l2 < l; l2++)
                {
                    arraynode.add(read(decoder));
                }

            }

            return arraynode;

        case 7: // '\007'
            objectnode = JsonNodeFactory.instance.objectNode();
            l1 = decoder.readMapStart();
            break;
        }
        for (; l1 > 0L; l1 = decoder.mapNext())
        {
            for (long l3 = 0L; l3 < l1; l3++)
            {
                objectnode.put(decoder.readString(), read(decoder));
            }

        }

        return objectnode;
    }

    public static void write(JsonNode jsonnode, Encoder encoder)
        throws IOException
    {
        Iterator iterator;
        switch (_cls1..SwitchMap.org.codehaus.jackson.JsonToken[jsonnode.asToken().ordinal()])
        {
        default:
            throw new AvroRuntimeException((new StringBuilder()).append(jsonnode.asToken()).append(" unexpected: ").append(jsonnode).toString());

        case 1: // '\001'
            encoder.writeIndex(JsonType.LONG.ordinal());
            encoder.writeLong(jsonnode.getLongValue());
            return;

        case 2: // '\002'
            encoder.writeIndex(JsonType.DOUBLE.ordinal());
            encoder.writeDouble(jsonnode.getDoubleValue());
            return;

        case 3: // '\003'
            encoder.writeIndex(JsonType.STRING.ordinal());
            encoder.writeString(jsonnode.getTextValue());
            return;

        case 4: // '\004'
            encoder.writeIndex(JsonType.BOOLEAN.ordinal());
            encoder.writeBoolean(true);
            return;

        case 5: // '\005'
            encoder.writeIndex(JsonType.BOOLEAN.ordinal());
            encoder.writeBoolean(false);
            return;

        case 6: // '\006'
            encoder.writeIndex(JsonType.NULL.ordinal());
            encoder.writeNull();
            return;

        case 7: // '\007'
            encoder.writeIndex(JsonType.ARRAY.ordinal());
            encoder.writeArrayStart();
            encoder.setItemCount(jsonnode.size());
            JsonNode jsonnode1;
            for (jsonnode = jsonnode.iterator(); jsonnode.hasNext(); write(jsonnode1, encoder))
            {
                jsonnode1 = (JsonNode)jsonnode.next();
                encoder.startItem();
            }

            encoder.writeArrayEnd();
            return;

        case 8: // '\b'
            encoder.writeIndex(JsonType.OBJECT.ordinal());
            encoder.writeMapStart();
            encoder.setItemCount(jsonnode.size());
            iterator = jsonnode.getFieldNames();
            break;
        }
        String s;
        for (; iterator.hasNext(); write(jsonnode.get(s), encoder))
        {
            encoder.startItem();
            s = (String)iterator.next();
            encoder.writeString(s);
        }

        encoder.writeMapEnd();
    }

    static 
    {
        try
        {
            SCHEMA = Schema.parse(com/flurry/org/apache/avro/data/Json.getResourceAsStream("/com/flurry/org/apache/avro/data/Json.avsc"));
        }
        catch (IOException ioexception)
        {
            throw new AvroRuntimeException(ioexception);
        }
    }
}
