// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.deser;

import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import com.flurry.org.codehaus.jackson.map.JsonDeserializer;
import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedMember;
import com.flurry.org.codehaus.jackson.map.util.ClassUtil;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.deser:
//            SettableBeanProperty

public static final class _creator extends SettableBeanProperty
{

    protected final Constructor _creator;
    protected final SettableBeanProperty _delegate;

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
                jsonparser = ((JsonParser) (_nullProvider.lue(deserializationcontext)));
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

    public _delegate withValueDeserializer(JsonDeserializer jsondeserializer)
    {
        return new <init>(this, jsondeserializer);
    }

    public volatile SettableBeanProperty withValueDeserializer(JsonDeserializer jsondeserializer)
    {
        return withValueDeserializer(jsondeserializer);
    }

    protected ( , JsonDeserializer jsondeserializer)
    {
        super(, jsondeserializer);
        _delegate = ._delegate.withValueDeserializer(jsondeserializer);
        _creator = ._creator;
    }

    public _creator(SettableBeanProperty settablebeanproperty, Constructor constructor)
    {
        super(settablebeanproperty);
        _delegate = settablebeanproperty;
        _creator = constructor;
    }
}
