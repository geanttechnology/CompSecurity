// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

// Referenced classes of package com.fasterxml.jackson.databind.deser.impl:
//            NullProvider

public final class InnerClassProperty extends SettableBeanProperty
{

    private static final long serialVersionUID = 1L;
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

    protected InnerClassProperty(InnerClassProperty innerclassproperty, PropertyName propertyname)
    {
        super(innerclassproperty, propertyname);
        _delegate = innerclassproperty._delegate.withName(propertyname);
        _creator = innerclassproperty._creator;
    }

    public void deserializeAndSet(JsonParser jsonparser, DeserializationContext deserializationcontext, Object obj)
        throws IOException, JsonProcessingException
    {
        Object obj1;
        Object obj2;
        obj1 = null;
        obj2 = null;
        if (jsonparser.getCurrentToken() != JsonToken.VALUE_NULL) goto _L2; else goto _L1
_L1:
        if (_nullProvider == null)
        {
            jsonparser = ((JsonParser) (obj2));
        } else
        {
            jsonparser = ((JsonParser) (_nullProvider.nullValue(deserializationcontext)));
        }
_L4:
        set(obj, jsonparser);
        return;
_L2:
        if (_valueTypeDeserializer != null)
        {
            jsonparser = ((JsonParser) (_valueDeserializer.deserializeWithType(jsonparser, deserializationcontext, _valueTypeDeserializer)));
            continue; /* Loop/switch isn't completed */
        }
        obj2 = _creator.newInstance(new Object[] {
            obj
        });
        obj1 = obj2;
_L5:
        _valueDeserializer.deserialize(jsonparser, deserializationcontext, obj1);
        jsonparser = ((JsonParser) (obj1));
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        ClassUtil.unwrapAndThrowAsIAE(exception, (new StringBuilder()).append("Failed to instantiate class ").append(_creator.getDeclaringClass().getName()).append(", problem: ").append(exception.getMessage()).toString());
          goto _L5
    }

    public Object deserializeSetAndReturn(JsonParser jsonparser, DeserializationContext deserializationcontext, Object obj)
        throws IOException, JsonProcessingException
    {
        return setAndReturn(obj, deserialize(jsonparser, deserializationcontext));
    }

    public Annotation getAnnotation(Class class1)
    {
        return _delegate.getAnnotation(class1);
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

    public volatile SettableBeanProperty withName(PropertyName propertyname)
    {
        return withName(propertyname);
    }

    public InnerClassProperty withName(PropertyName propertyname)
    {
        return new InnerClassProperty(this, propertyname);
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
