// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.deser.std;

import com.flurry.org.codehaus.jackson.JsonNode;
import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import com.flurry.org.codehaus.jackson.map.JsonDeserializer;
import com.flurry.org.codehaus.jackson.map.TypeDeserializer;
import com.flurry.org.codehaus.jackson.node.ArrayNode;
import com.flurry.org.codehaus.jackson.node.ObjectNode;
import java.io.IOException;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.deser.std:
//            BaseNodeDeserializer

public class JsonNodeDeserializer extends BaseNodeDeserializer
{
    static final class ArrayDeserializer extends BaseNodeDeserializer
    {

        protected static final ArrayDeserializer _instance = new ArrayDeserializer();

        public static ArrayDeserializer getInstance()
        {
            return _instance;
        }

        public ArrayNode deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException, JsonProcessingException
        {
            if (jsonparser.isExpectedStartArrayToken())
            {
                return deserializeArray(jsonparser, deserializationcontext, deserializationcontext.getNodeFactory());
            } else
            {
                throw deserializationcontext.mappingException(com/flurry/org/codehaus/jackson/node/ArrayNode);
            }
        }

        public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException, JsonProcessingException
        {
            return deserialize(jsonparser, deserializationcontext);
        }


        protected ArrayDeserializer()
        {
            super(com/flurry/org/codehaus/jackson/node/ArrayNode);
        }
    }

    static final class ObjectDeserializer extends BaseNodeDeserializer
    {

        protected static final ObjectDeserializer _instance = new ObjectDeserializer();

        public static ObjectDeserializer getInstance()
        {
            return _instance;
        }

        public ObjectNode deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException, JsonProcessingException
        {
            if (jsonparser.getCurrentToken() == JsonToken.START_OBJECT)
            {
                jsonparser.nextToken();
                return deserializeObject(jsonparser, deserializationcontext, deserializationcontext.getNodeFactory());
            }
            if (jsonparser.getCurrentToken() == JsonToken.FIELD_NAME)
            {
                return deserializeObject(jsonparser, deserializationcontext, deserializationcontext.getNodeFactory());
            } else
            {
                throw deserializationcontext.mappingException(com/flurry/org/codehaus/jackson/node/ObjectNode);
            }
        }

        public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException, JsonProcessingException
        {
            return deserialize(jsonparser, deserializationcontext);
        }


        protected ObjectDeserializer()
        {
            super(com/flurry/org/codehaus/jackson/node/ObjectNode);
        }
    }


    private static final JsonNodeDeserializer instance = new JsonNodeDeserializer();

    protected JsonNodeDeserializer()
    {
        super(com/flurry/org/codehaus/jackson/JsonNode);
    }

    public static JsonDeserializer getDeserializer(Class class1)
    {
        if (class1 == com/flurry/org/codehaus/jackson/node/ObjectNode)
        {
            return ObjectDeserializer.getInstance();
        }
        if (class1 == com/flurry/org/codehaus/jackson/node/ArrayNode)
        {
            return ArrayDeserializer.getInstance();
        } else
        {
            return instance;
        }
    }

    public JsonNode deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        static class _cls1
        {

            static final int $SwitchMap$org$codehaus$jackson$JsonToken[];

            static 
            {
                $SwitchMap$org$codehaus$jackson$JsonToken = new int[JsonToken.values().length];
                try
                {
                    $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.START_OBJECT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.START_ARRAY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.org.codehaus.jackson.JsonToken[jsonparser.getCurrentToken().ordinal()])
        {
        default:
            return deserializeAny(jsonparser, deserializationcontext, deserializationcontext.getNodeFactory());

        case 1: // '\001'
            return deserializeObject(jsonparser, deserializationcontext, deserializationcontext.getNodeFactory());

        case 2: // '\002'
            return deserializeArray(jsonparser, deserializationcontext, deserializationcontext.getNodeFactory());
        }
    }

    public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        return deserialize(jsonparser, deserializationcontext);
    }

    public volatile Object deserializeWithType(JsonParser jsonparser, DeserializationContext deserializationcontext, TypeDeserializer typedeserializer)
        throws IOException, JsonProcessingException
    {
        return super.deserializeWithType(jsonparser, deserializationcontext, typedeserializer);
    }

}
