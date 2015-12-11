// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.deser.std;

import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import com.flurry.org.codehaus.jackson.map.JsonDeserializer;
import com.flurry.org.codehaus.jackson.map.TypeDeserializer;
import com.flurry.org.codehaus.jackson.map.util.EnumResolver;
import java.io.IOException;
import java.util.EnumMap;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.deser.std:
//            StdDeserializer, EnumDeserializer

public class EnumMapDeserializer extends StdDeserializer
{

    protected final Class _enumClass;
    protected final JsonDeserializer _keyDeserializer;
    protected final JsonDeserializer _valueDeserializer;

    public EnumMapDeserializer(EnumResolver enumresolver, JsonDeserializer jsondeserializer)
    {
        this(enumresolver.getEnumClass(), ((JsonDeserializer) (new EnumDeserializer(enumresolver))), jsondeserializer);
    }

    public EnumMapDeserializer(Class class1, JsonDeserializer jsondeserializer, JsonDeserializer jsondeserializer1)
    {
        super(java/util/EnumMap);
        _enumClass = class1;
        _keyDeserializer = jsondeserializer;
        _valueDeserializer = jsondeserializer1;
    }

    private EnumMap constructMap()
    {
        return new EnumMap(_enumClass);
    }

    public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        return deserialize(jsonparser, deserializationcontext);
    }

    public EnumMap deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        if (jsonparser.getCurrentToken() != JsonToken.START_OBJECT)
        {
            throw deserializationcontext.mappingException(java/util/EnumMap);
        }
        EnumMap enummap = constructMap();
        while (jsonparser.nextToken() != JsonToken.END_OBJECT) 
        {
            Enum enum = (Enum)_keyDeserializer.deserialize(jsonparser, deserializationcontext);
            if (enum == null)
            {
                throw deserializationcontext.weirdStringException(_enumClass, "value not one of declared Enum instance names");
            }
            Object obj;
            if (jsonparser.nextToken() == JsonToken.VALUE_NULL)
            {
                obj = null;
            } else
            {
                obj = _valueDeserializer.deserialize(jsonparser, deserializationcontext);
            }
            enummap.put(enum, obj);
        }
        return enummap;
    }

    public Object deserializeWithType(JsonParser jsonparser, DeserializationContext deserializationcontext, TypeDeserializer typedeserializer)
        throws IOException, JsonProcessingException
    {
        return typedeserializer.deserializeTypedFromObject(jsonparser, deserializationcontext);
    }
}
