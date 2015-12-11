// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.util.Collection;

// Referenced classes of package com.fasterxml.jackson.databind.deser.std:
//            StdDeserializer

public abstract class DelegatingDeserializer extends StdDeserializer
    implements ContextualDeserializer, ResolvableDeserializer
{

    protected final JsonDeserializer _delegatee;

    public DelegatingDeserializer(JsonDeserializer jsondeserializer)
    {
        super(_figureType(jsondeserializer));
        _delegatee = jsondeserializer;
    }

    private static Class _figureType(JsonDeserializer jsondeserializer)
    {
        if (jsondeserializer instanceof StdDeserializer)
        {
            return ((StdDeserializer)jsondeserializer).getValueClass();
        } else
        {
            return java/lang/Object;
        }
    }

    protected JsonDeserializer _createContextual(DeserializationContext deserializationcontext, BeanProperty beanproperty, JsonDeserializer jsondeserializer)
    {
        if (jsondeserializer == _delegatee)
        {
            return this;
        } else
        {
            return newDelegatingInstance(jsondeserializer);
        }
    }

    public JsonDeserializer createContextual(DeserializationContext deserializationcontext, BeanProperty beanproperty)
        throws JsonMappingException
    {
        JsonDeserializer jsondeserializer1 = _delegatee;
        JsonDeserializer jsondeserializer = jsondeserializer1;
        if (jsondeserializer1 instanceof ContextualDeserializer)
        {
            jsondeserializer = ((ContextualDeserializer)jsondeserializer1).createContextual(deserializationcontext, beanproperty);
        }
        return _createContextual(deserializationcontext, beanproperty, jsondeserializer);
    }

    public Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        return _delegatee.deserialize(jsonparser, deserializationcontext);
    }

    public Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext, Object obj)
        throws IOException, JsonProcessingException
    {
        return _delegatee.deserialize(jsonparser, deserializationcontext, obj);
    }

    public Object deserializeWithType(JsonParser jsonparser, DeserializationContext deserializationcontext, TypeDeserializer typedeserializer)
        throws IOException, JsonProcessingException
    {
        return _delegatee.deserializeWithType(jsonparser, deserializationcontext, typedeserializer);
    }

    public JsonDeserializer getDelegatee()
    {
        return _delegatee;
    }

    public Object getEmptyValue()
    {
        return _delegatee.getEmptyValue();
    }

    public Collection getKnownPropertyNames()
    {
        return _delegatee.getKnownPropertyNames();
    }

    public Object getNullValue()
    {
        return _delegatee.getNullValue();
    }

    public ObjectIdReader getObjectIdReader()
    {
        return _delegatee.getObjectIdReader();
    }

    public boolean isCachable()
    {
        return false;
    }

    protected abstract JsonDeserializer newDelegatingInstance(JsonDeserializer jsondeserializer);

    public JsonDeserializer replaceDelegatee(JsonDeserializer jsondeserializer)
    {
        if (jsondeserializer == _delegatee)
        {
            return this;
        } else
        {
            return newDelegatingInstance(jsondeserializer);
        }
    }

    public void resolve(DeserializationContext deserializationcontext)
        throws JsonMappingException
    {
        if (_delegatee instanceof ResolvableDeserializer)
        {
            ((ResolvableDeserializer)_delegatee).resolve(deserializationcontext);
        }
    }
}
