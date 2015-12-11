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
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.util.EnumMap;

// Referenced classes of package com.fasterxml.jackson.databind.deser.std:
//            StdDeserializer

public class EnumMapDeserializer extends StdDeserializer
    implements ContextualDeserializer
{

    private static final long serialVersionUID = 0x1513c456622f2ab4L;
    protected final Class _enumClass;
    protected JsonDeserializer _keyDeserializer;
    protected final JavaType _mapType;
    protected JsonDeserializer _valueDeserializer;
    protected final TypeDeserializer _valueTypeDeserializer;

    public EnumMapDeserializer(JavaType javatype, JsonDeserializer jsondeserializer, JsonDeserializer jsondeserializer1)
    {
        this(javatype, jsondeserializer, jsondeserializer1, null);
    }

    public EnumMapDeserializer(JavaType javatype, JsonDeserializer jsondeserializer, JsonDeserializer jsondeserializer1, TypeDeserializer typedeserializer)
    {
        super(java/util/EnumMap);
        _mapType = javatype;
        _enumClass = javatype.getKeyType().getRawClass();
        _keyDeserializer = jsondeserializer;
        _valueDeserializer = jsondeserializer1;
        _valueTypeDeserializer = typedeserializer;
    }

    private EnumMap constructMap()
    {
        return new EnumMap(_enumClass);
    }

    public JsonDeserializer createContextual(DeserializationContext deserializationcontext, BeanProperty beanproperty)
        throws JsonMappingException
    {
        Object obj = _keyDeserializer;
        JsonDeserializer jsondeserializer = ((JsonDeserializer) (obj));
        if (obj == null)
        {
            jsondeserializer = deserializationcontext.findContextualValueDeserializer(_mapType.getKeyType(), beanproperty);
        }
        obj = _valueDeserializer;
        TypeDeserializer typedeserializer;
        if (obj == null)
        {
            deserializationcontext = deserializationcontext.findContextualValueDeserializer(_mapType.getContentType(), beanproperty);
        } else
        {
            deserializationcontext = deserializationcontext.handleSecondaryContextualization(((JsonDeserializer) (obj)), beanproperty);
        }
        typedeserializer = _valueTypeDeserializer;
        obj = typedeserializer;
        if (typedeserializer != null)
        {
            obj = typedeserializer.forProperty(beanproperty);
        }
        return withResolved(jsondeserializer, deserializationcontext, ((TypeDeserializer) (obj)));
    }

    public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        return deserialize(jsonparser, deserializationcontext);
    }

    public EnumMap deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        EnumMap enummap;
        JsonDeserializer jsondeserializer;
        TypeDeserializer typedeserializer;
        if (jsonparser.getCurrentToken() != JsonToken.START_OBJECT)
        {
            throw deserializationcontext.mappingException(java/util/EnumMap);
        }
        enummap = constructMap();
        jsondeserializer = _valueDeserializer;
        typedeserializer = _valueTypeDeserializer;
_L7:
        if (jsonparser.nextToken() == JsonToken.END_OBJECT) goto _L2; else goto _L1
_L1:
        Enum enum = (Enum)_keyDeserializer.deserialize(jsonparser, deserializationcontext);
        if (enum != null) goto _L4; else goto _L3
_L3:
        if (deserializationcontext.isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) goto _L6; else goto _L5
_L5:
        try
        {
            if (!jsonparser.hasCurrentToken())
            {
                break MISSING_BLOCK_LABEL_173;
            }
            jsonparser = jsonparser.getText();
        }
        // Misplaced declaration of an exception variable
        catch (JsonParser jsonparser)
        {
            jsonparser = null;
        }
_L8:
        throw deserializationcontext.weirdStringException(jsonparser, _enumClass, "value not one of declared Enum instance names");
_L6:
        jsonparser.nextToken();
        jsonparser.skipChildren();
          goto _L7
_L4:
        Object obj;
        if (jsonparser.nextToken() == JsonToken.VALUE_NULL)
        {
            obj = null;
        } else
        if (typedeserializer == null)
        {
            obj = jsondeserializer.deserialize(jsonparser, deserializationcontext);
        } else
        {
            obj = jsondeserializer.deserializeWithType(jsonparser, deserializationcontext, typedeserializer);
        }
        enummap.put(enum, obj);
          goto _L7
_L2:
        return enummap;
        jsonparser = null;
          goto _L8
    }

    public Object deserializeWithType(JsonParser jsonparser, DeserializationContext deserializationcontext, TypeDeserializer typedeserializer)
        throws IOException, JsonProcessingException
    {
        return typedeserializer.deserializeTypedFromObject(jsonparser, deserializationcontext);
    }

    public boolean isCachable()
    {
        return true;
    }

    public EnumMapDeserializer withResolved(JsonDeserializer jsondeserializer, JsonDeserializer jsondeserializer1)
    {
        return withResolved(jsondeserializer, jsondeserializer1, null);
    }

    public EnumMapDeserializer withResolved(JsonDeserializer jsondeserializer, JsonDeserializer jsondeserializer1, TypeDeserializer typedeserializer)
    {
        if (jsondeserializer == _keyDeserializer && jsondeserializer1 == _valueDeserializer && typedeserializer == _valueTypeDeserializer)
        {
            return this;
        } else
        {
            return new EnumMapDeserializer(_mapType, jsondeserializer, jsondeserializer1, _valueTypeDeserializer);
        }
    }
}
