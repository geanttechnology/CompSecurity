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
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.util.Collection;

// Referenced classes of package com.fasterxml.jackson.databind.deser.std:
//            StdDeserializer

public abstract class DelegatingDeserializer extends StdDeserializer
    implements ContextualDeserializer, ResolvableDeserializer
{

    private static final long serialVersionUID = 1L;
    protected final JsonDeserializer _delegatee;

    public DelegatingDeserializer(JsonDeserializer jsondeserializer)
    {
        super(_figureType(jsondeserializer));
        _delegatee = jsondeserializer;
    }

    private static Class _figureType(JsonDeserializer jsondeserializer)
    {
        jsondeserializer = jsondeserializer.handledType();
        if (jsondeserializer != null)
        {
            return jsondeserializer;
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
        deserializationcontext = deserializationcontext.handleSecondaryContextualization(_delegatee, beanproperty);
        if (deserializationcontext == _delegatee)
        {
            return this;
        } else
        {
            return newDelegatingInstance(deserializationcontext);
        }
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

    public SettableBeanProperty findBackReference(String s)
    {
        return _delegatee.findBackReference(s);
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
        return _delegatee.isCachable();
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
