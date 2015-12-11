// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.IOException;
import java.lang.reflect.Constructor;

// Referenced classes of package com.fasterxml.jackson.databind.deser.impl:
//            NullProvider

public final class InnerClassProperty extends SettableBeanProperty
{

    protected final Constructor _creator;
    protected final SettableBeanProperty _delegate;

    public InnerClassProperty(SettableBeanProperty settablebeanproperty, Constructor constructor)
    {
        super(settablebeanproperty);
        _delegate = settablebeanproperty;
        _creator = constructor;
    }

    protected InnerClassProperty(InnerClassProperty innerclassproperty, JsonDeserializer jsondeserializer)
    {
        super(innerclassproperty, jsondeserializer);
        _delegate = innerclassproperty._delegate.withValueDeserializer(jsondeserializer);
        _creator = innerclassproperty._creator;
    }

    protected InnerClassProperty(InnerClassProperty innerclassproperty, String s)
    {
        super(innerclassproperty, s);
        _delegate = innerclassproperty._delegate.withName(s);
        _creator = innerclassproperty._creator;
    }

    public void deserializeAndSet(JsonParser jsonparser, DeserializationContext deserializationcontext, Object obj)
        throws IOException, JsonProcessingException
    {
        if (jsonparser.getCurrentToken() == JsonToken.VALUE_NULL)
        {
            if (_nullProvider == null)
            {
                jsonparser = null;
            } else
            {
                jsonparser = ((JsonParser) (_nullProvider.nullValue(deserializationcontext)));
            }
        } else
        if (_valueTypeDeserializer != null)
        {
            jsonparser = ((JsonParser) (_valueDeserializer.deserializeWithType(jsonparser, deserializationcontext, _valueTypeDeserializer)));
        } else
        {
            Object obj1;
            try
            {
                obj1 = _creator.newInstance(new Object[] {
                    obj
                });
            }
            catch (Exception exception)
            {
                ClassUtil.unwrapAndThrowAsIAE(exception, (new StringBuilder()).append("Failed to instantiate class ").append(_creator.getDeclaringClass().getName()).append(", problem: ").append(exception.getMessage()).toString());
                exception = null;
            }
            _valueDeserializer.deserialize(jsonparser, deserializationcontext, obj1);
            jsonparser = ((JsonParser) (obj1));
        }
        set(obj, jsonparser);
    }

    public Object deserializeSetAndReturn(JsonParser jsonparser, DeserializationContext deserializationcontext, Object obj)
        throws IOException, JsonProcessingException
    {
        return setAndReturn(obj, deserialize(jsonparser, deserializationcontext));
    }

    public AnnotatedMember getMember()
    {
        return _delegate.getMember();
    }

    public final void set(Object obj, Object obj1)
        throws IOException
    {
        _delegate.set(obj, obj1);
    }

    public Object setAndReturn(Object obj, Object obj1)
        throws IOException
    {
        return _delegate.setAndReturn(obj, obj1);
    }

    public volatile SettableBeanProperty withName(String s)
    {
        return withName(s);
    }

    public InnerClassProperty withName(String s)
    {
        return new InnerClassProperty(this, s);
    }

    public volatile SettableBeanProperty withValueDeserializer(JsonDeserializer jsondeserializer)
    {
        return withValueDeserializer(jsondeserializer);
    }

    public InnerClassProperty withValueDeserializer(JsonDeserializer jsondeserializer)
    {
        return new InnerClassProperty(this, jsondeserializer);
    }
}
