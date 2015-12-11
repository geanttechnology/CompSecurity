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
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.util.Collection;

// Referenced classes of package com.fasterxml.jackson.databind.deser.std:
//            ContainerDeserializerBase

public class CollectionDeserializer extends ContainerDeserializerBase
    implements ContextualDeserializer
{

    protected final JavaType _collectionType;
    protected final JsonDeserializer _delegateDeserializer;
    protected final JsonDeserializer _valueDeserializer;
    protected final ValueInstantiator _valueInstantiator;
    protected final TypeDeserializer _valueTypeDeserializer;

    public CollectionDeserializer(JavaType javatype, JsonDeserializer jsondeserializer, TypeDeserializer typedeserializer, ValueInstantiator valueinstantiator)
    {
        this(javatype, jsondeserializer, typedeserializer, valueinstantiator, null);
    }

    protected CollectionDeserializer(JavaType javatype, JsonDeserializer jsondeserializer, TypeDeserializer typedeserializer, ValueInstantiator valueinstantiator, JsonDeserializer jsondeserializer1)
    {
        super(javatype.getRawClass());
        _collectionType = javatype;
        _valueDeserializer = jsondeserializer;
        _valueTypeDeserializer = typedeserializer;
        _valueInstantiator = valueinstantiator;
        _delegateDeserializer = jsondeserializer1;
    }

    protected CollectionDeserializer(CollectionDeserializer collectiondeserializer)
    {
        super(collectiondeserializer._valueClass);
        _collectionType = collectiondeserializer._collectionType;
        _valueDeserializer = collectiondeserializer._valueDeserializer;
        _valueTypeDeserializer = collectiondeserializer._valueTypeDeserializer;
        _valueInstantiator = collectiondeserializer._valueInstantiator;
        _delegateDeserializer = collectiondeserializer._delegateDeserializer;
    }

    private final Collection handleNonArray(JsonParser jsonparser, DeserializationContext deserializationcontext, Collection collection)
        throws IOException, JsonProcessingException
    {
        if (!deserializationcontext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY))
        {
            throw deserializationcontext.mappingException(_collectionType.getRawClass());
        }
        JsonDeserializer jsondeserializer = _valueDeserializer;
        TypeDeserializer typedeserializer = _valueTypeDeserializer;
        if (jsonparser.getCurrentToken() == JsonToken.VALUE_NULL)
        {
            jsonparser = null;
        } else
        if (typedeserializer == null)
        {
            jsonparser = ((JsonParser) (jsondeserializer.deserialize(jsonparser, deserializationcontext)));
        } else
        {
            jsonparser = ((JsonParser) (jsondeserializer.deserializeWithType(jsonparser, deserializationcontext, typedeserializer)));
        }
        collection.add(jsonparser);
        return collection;
    }

    public volatile JsonDeserializer createContextual(DeserializationContext deserializationcontext, BeanProperty beanproperty)
        throws JsonMappingException
    {
        return createContextual(deserializationcontext, beanproperty);
    }

    public CollectionDeserializer createContextual(DeserializationContext deserializationcontext, BeanProperty beanproperty)
        throws JsonMappingException
    {
        JsonDeserializer jsondeserializer;
        Object obj2;
        Object obj = null;
        jsondeserializer = obj;
        if (_valueInstantiator != null)
        {
            jsondeserializer = obj;
            if (_valueInstantiator.canCreateUsingDelegate())
            {
                JavaType javatype = _valueInstantiator.getDelegateType(deserializationcontext.getConfig());
                if (javatype == null)
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("Invalid delegate-creator definition for ").append(_collectionType).append(": value instantiator (").append(_valueInstantiator.getClass().getName()).append(") returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'").toString());
                }
                jsondeserializer = findDeserializer(deserializationcontext, javatype, beanproperty);
            }
        }
        obj2 = _valueDeserializer;
        if (obj2 != null) goto _L2; else goto _L1
_L1:
        Object obj1 = deserializationcontext.findContextualValueDeserializer(_collectionType.getContentType(), beanproperty);
_L4:
        obj2 = _valueTypeDeserializer;
        deserializationcontext = ((DeserializationContext) (obj2));
        if (obj2 != null)
        {
            deserializationcontext = ((TypeDeserializer) (obj2)).forProperty(beanproperty);
        }
        return withResolved(jsondeserializer, ((JsonDeserializer) (obj1)), deserializationcontext);
_L2:
        obj1 = obj2;
        if (obj2 instanceof ContextualDeserializer)
        {
            obj1 = ((ContextualDeserializer)obj2).createContextual(deserializationcontext, beanproperty);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        return deserialize(jsonparser, deserializationcontext);
    }

    public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext, Object obj)
        throws IOException, JsonProcessingException
    {
        return deserialize(jsonparser, deserializationcontext, (Collection)obj);
    }

    public Collection deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        if (_delegateDeserializer != null)
        {
            return (Collection)_valueInstantiator.createUsingDelegate(deserializationcontext, _delegateDeserializer.deserialize(jsonparser, deserializationcontext));
        }
        if (jsonparser.getCurrentToken() == JsonToken.VALUE_STRING)
        {
            String s = jsonparser.getText();
            if (s.length() == 0)
            {
                return (Collection)_valueInstantiator.createFromString(deserializationcontext, s);
            }
        }
        return deserialize(jsonparser, deserializationcontext, (Collection)_valueInstantiator.createUsingDefault(deserializationcontext));
    }

    public Collection deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext, Collection collection)
        throws IOException, JsonProcessingException
    {
        if (jsonparser.isExpectedStartArrayToken()) goto _L2; else goto _L1
_L1:
        Object obj = handleNonArray(jsonparser, deserializationcontext, collection);
_L4:
        return ((Collection) (obj));
_L2:
        JsonDeserializer jsondeserializer = _valueDeserializer;
        TypeDeserializer typedeserializer = _valueTypeDeserializer;
        do
        {
            JsonToken jsontoken = jsonparser.nextToken();
            obj = collection;
            if (jsontoken == JsonToken.END_ARRAY)
            {
                continue;
            }
            if (jsontoken == JsonToken.VALUE_NULL)
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
            collection.add(obj);
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public Object deserializeWithType(JsonParser jsonparser, DeserializationContext deserializationcontext, TypeDeserializer typedeserializer)
        throws IOException, JsonProcessingException
    {
        return typedeserializer.deserializeTypedFromArray(jsonparser, deserializationcontext);
    }

    public JsonDeserializer getContentDeserializer()
    {
        return _valueDeserializer;
    }

    public JavaType getContentType()
    {
        return _collectionType.getContentType();
    }

    protected CollectionDeserializer withResolved(JsonDeserializer jsondeserializer, JsonDeserializer jsondeserializer1, TypeDeserializer typedeserializer)
    {
        if (jsondeserializer == _delegateDeserializer && jsondeserializer1 == _valueDeserializer && typedeserializer == _valueTypeDeserializer)
        {
            return this;
        } else
        {
            return new CollectionDeserializer(_collectionType, jsondeserializer1, typedeserializer, _valueInstantiator, jsondeserializer);
        }
    }
}
