// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.ObjectBuffer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.fasterxml.jackson.databind.deser.std:
//            StdDeserializer

public class UntypedObjectDeserializer extends StdDeserializer
    implements ResolvableDeserializer, ContextualDeserializer
{

    private static final Object NO_OBJECTS[] = new Object[0];
    public static final UntypedObjectDeserializer instance = new UntypedObjectDeserializer();
    private static final long serialVersionUID = 1L;
    protected JsonDeserializer _listDeserializer;
    protected JsonDeserializer _mapDeserializer;
    protected JsonDeserializer _numberDeserializer;
    protected JsonDeserializer _stringDeserializer;

    public UntypedObjectDeserializer()
    {
        super(java/lang/Object);
    }

    public UntypedObjectDeserializer(UntypedObjectDeserializer untypedobjectdeserializer, JsonDeserializer jsondeserializer, JsonDeserializer jsondeserializer1, JsonDeserializer jsondeserializer2, JsonDeserializer jsondeserializer3)
    {
        super(java/lang/Object);
        _mapDeserializer = jsondeserializer;
        _listDeserializer = jsondeserializer1;
        _stringDeserializer = jsondeserializer2;
        _numberDeserializer = jsondeserializer3;
    }

    protected JsonDeserializer _findCustomDeser(DeserializationContext deserializationcontext, JavaType javatype)
        throws JsonMappingException
    {
        javatype = deserializationcontext.findRootValueDeserializer(javatype);
        deserializationcontext = javatype;
        if (ClassUtil.isJacksonStdImpl(javatype))
        {
            deserializationcontext = null;
        }
        return deserializationcontext;
    }

    protected JsonDeserializer _withResolved(JsonDeserializer jsondeserializer, JsonDeserializer jsondeserializer1, JsonDeserializer jsondeserializer2, JsonDeserializer jsondeserializer3)
    {
        return new UntypedObjectDeserializer(this, jsondeserializer, jsondeserializer1, jsondeserializer2, jsondeserializer3);
    }

    public JsonDeserializer createContextual(DeserializationContext deserializationcontext, BeanProperty beanproperty)
        throws JsonMappingException
    {
label0:
        {
            JsonDeserializer jsondeserializer = _mapDeserializer;
            if (jsondeserializer instanceof ContextualDeserializer)
            {
                jsondeserializer = ((ContextualDeserializer)jsondeserializer).createContextual(deserializationcontext, beanproperty);
            }
            JsonDeserializer jsondeserializer1 = _listDeserializer;
            if (jsondeserializer1 instanceof ContextualDeserializer)
            {
                jsondeserializer1 = ((ContextualDeserializer)jsondeserializer1).createContextual(deserializationcontext, beanproperty);
            }
            JsonDeserializer jsondeserializer2 = _stringDeserializer;
            if (jsondeserializer2 instanceof ContextualDeserializer)
            {
                jsondeserializer2 = ((ContextualDeserializer)jsondeserializer2).createContextual(deserializationcontext, beanproperty);
            }
            JsonDeserializer jsondeserializer4 = _numberDeserializer;
            JsonDeserializer jsondeserializer3 = jsondeserializer4;
            if (jsondeserializer4 instanceof ContextualDeserializer)
            {
                jsondeserializer3 = ((ContextualDeserializer)jsondeserializer4).createContextual(deserializationcontext, beanproperty);
            }
            if (jsondeserializer == _mapDeserializer && jsondeserializer1 == _listDeserializer && jsondeserializer2 == _stringDeserializer)
            {
                deserializationcontext = this;
                if (jsondeserializer3 == _numberDeserializer)
                {
                    break label0;
                }
            }
            deserializationcontext = _withResolved(jsondeserializer, jsondeserializer1, jsondeserializer2, jsondeserializer3);
        }
        return deserializationcontext;
    }

    public Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        static class _cls1
        {

            static final int $SwitchMap$com$fasterxml$jackson$core$JsonToken[];

            static 
            {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken = new int[JsonToken.values().length];
                try
                {
                    $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.FIELD_NAME.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.START_OBJECT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.START_ARRAY.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_EMBEDDED_OBJECT.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_STRING.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_NUMBER_INT.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_TRUE.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_FALSE.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_NULL.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.END_ARRAY.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.END_OBJECT.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.fasterxml.jackson.core.JsonToken[jsonparser.getCurrentToken().ordinal()])
        {
        default:
            throw deserializationcontext.mappingException(java/lang/Object);

        case 1: // '\001'
        case 2: // '\002'
            if (_mapDeserializer != null)
            {
                return _mapDeserializer.deserialize(jsonparser, deserializationcontext);
            } else
            {
                return mapObject(jsonparser, deserializationcontext);
            }

        case 3: // '\003'
            if (deserializationcontext.isEnabled(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY))
            {
                return ((Object) (mapArrayToArray(jsonparser, deserializationcontext)));
            }
            if (_listDeserializer != null)
            {
                return _listDeserializer.deserialize(jsonparser, deserializationcontext);
            } else
            {
                return mapArray(jsonparser, deserializationcontext);
            }

        case 4: // '\004'
            return jsonparser.getEmbeddedObject();

        case 5: // '\005'
            if (_stringDeserializer != null)
            {
                return _stringDeserializer.deserialize(jsonparser, deserializationcontext);
            } else
            {
                return jsonparser.getText();
            }

        case 6: // '\006'
            if (_numberDeserializer != null)
            {
                return _numberDeserializer.deserialize(jsonparser, deserializationcontext);
            }
            if (deserializationcontext.isEnabled(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS))
            {
                return jsonparser.getBigIntegerValue();
            } else
            {
                return jsonparser.getNumberValue();
            }

        case 7: // '\007'
            if (_numberDeserializer != null)
            {
                return _numberDeserializer.deserialize(jsonparser, deserializationcontext);
            }
            if (deserializationcontext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS))
            {
                return jsonparser.getDecimalValue();
            } else
            {
                return Double.valueOf(jsonparser.getDoubleValue());
            }

        case 8: // '\b'
            return Boolean.TRUE;

        case 9: // '\t'
            return Boolean.FALSE;

        case 10: // '\n'
            return null;
        }
    }

    public Object deserializeWithType(JsonParser jsonparser, DeserializationContext deserializationcontext, TypeDeserializer typedeserializer)
        throws IOException, JsonProcessingException
    {
        JsonToken jsontoken = jsonparser.getCurrentToken();
        switch (_cls1..SwitchMap.com.fasterxml.jackson.core.JsonToken[jsontoken.ordinal()])
        {
        default:
            throw deserializationcontext.mappingException(java/lang/Object);

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            return typedeserializer.deserializeTypedFromAny(jsonparser, deserializationcontext);

        case 5: // '\005'
            if (_stringDeserializer != null)
            {
                return _stringDeserializer.deserialize(jsonparser, deserializationcontext);
            } else
            {
                return jsonparser.getText();
            }

        case 6: // '\006'
            if (_numberDeserializer != null)
            {
                return _numberDeserializer.deserialize(jsonparser, deserializationcontext);
            }
            if (deserializationcontext.isEnabled(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS))
            {
                return jsonparser.getBigIntegerValue();
            } else
            {
                return jsonparser.getNumberValue();
            }

        case 7: // '\007'
            if (_numberDeserializer != null)
            {
                return _numberDeserializer.deserialize(jsonparser, deserializationcontext);
            }
            if (deserializationcontext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS))
            {
                return jsonparser.getDecimalValue();
            } else
            {
                return Double.valueOf(jsonparser.getDoubleValue());
            }

        case 8: // '\b'
            return Boolean.TRUE;

        case 9: // '\t'
            return Boolean.FALSE;

        case 4: // '\004'
            return jsonparser.getEmbeddedObject();

        case 10: // '\n'
            return null;
        }
    }

    protected Object mapArray(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        if (jsonparser.nextToken() == JsonToken.END_ARRAY)
        {
            return new ArrayList(4);
        }
        ObjectBuffer objectbuffer = deserializationcontext.leaseObjectBuffer();
        Object aobj1[] = objectbuffer.resetAndStart();
        int i = 0;
        int j = 0;
        do
        {
            Object obj = deserialize(jsonparser, deserializationcontext);
            int k = j + 1;
            Object aobj[];
            int l;
            if (i >= aobj1.length)
            {
                aobj = objectbuffer.appendCompletedChunk(aobj1);
                i = 0;
            } else
            {
                aobj = aobj1;
            }
            l = i + 1;
            aobj[i] = obj;
            j = k;
            i = l;
            aobj1 = aobj;
        } while (jsonparser.nextToken() != JsonToken.END_ARRAY);
        jsonparser = new ArrayList(k + (k >> 3) + 1);
        objectbuffer.completeAndClearBuffer(aobj, l, jsonparser);
        return jsonparser;
    }

    protected Object[] mapArrayToArray(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        if (jsonparser.nextToken() == JsonToken.END_ARRAY)
        {
            return NO_OBJECTS;
        }
        ObjectBuffer objectbuffer = deserializationcontext.leaseObjectBuffer();
        Object aobj[] = objectbuffer.resetAndStart();
        int i = 0;
        do
        {
            Object obj = deserialize(jsonparser, deserializationcontext);
            Object aobj1[];
            int j;
            if (i >= aobj.length)
            {
                aobj1 = objectbuffer.appendCompletedChunk(aobj);
                i = 0;
            } else
            {
                aobj1 = aobj;
            }
            j = i + 1;
            aobj1[i] = obj;
            i = j;
            aobj = aobj1;
        } while (jsonparser.nextToken() != JsonToken.END_ARRAY);
        return objectbuffer.completeAndClearBuffer(aobj1, j);
    }

    protected Object mapObject(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        Object obj1 = jsonparser.getCurrentToken();
        Object obj = obj1;
        if (obj1 == JsonToken.START_OBJECT)
        {
            obj = jsonparser.nextToken();
        }
        if (obj != JsonToken.FIELD_NAME)
        {
            return new LinkedHashMap(4);
        }
        obj = jsonparser.getText();
        jsonparser.nextToken();
        obj1 = deserialize(jsonparser, deserializationcontext);
        if (jsonparser.nextToken() != JsonToken.FIELD_NAME)
        {
            jsonparser = new LinkedHashMap(4);
            jsonparser.put(obj, obj1);
            return jsonparser;
        }
        String s1 = jsonparser.getText();
        jsonparser.nextToken();
        Object obj2 = deserialize(jsonparser, deserializationcontext);
        if (jsonparser.nextToken() != JsonToken.FIELD_NAME)
        {
            jsonparser = new LinkedHashMap(4);
            jsonparser.put(obj, obj1);
            jsonparser.put(s1, obj2);
            return jsonparser;
        }
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        linkedhashmap.put(obj, obj1);
        linkedhashmap.put(s1, obj2);
        do
        {
            String s = jsonparser.getText();
            jsonparser.nextToken();
            linkedhashmap.put(s, deserialize(jsonparser, deserializationcontext));
        } while (jsonparser.nextToken() != JsonToken.END_OBJECT);
        return linkedhashmap;
    }

    public void resolve(DeserializationContext deserializationcontext)
        throws JsonMappingException
    {
        JavaType javatype = deserializationcontext.constructType(java/lang/Object);
        JavaType javatype1 = deserializationcontext.constructType(java/lang/String);
        TypeFactory typefactory = deserializationcontext.getTypeFactory();
        _mapDeserializer = _findCustomDeser(deserializationcontext, typefactory.constructMapType(java/util/Map, javatype1, javatype));
        _listDeserializer = _findCustomDeser(deserializationcontext, typefactory.constructCollectionType(java/util/List, javatype));
        _stringDeserializer = _findCustomDeser(deserializationcontext, javatype1);
        _numberDeserializer = _findCustomDeser(deserializationcontext, typefactory.constructType(java/lang/Number));
    }

}
