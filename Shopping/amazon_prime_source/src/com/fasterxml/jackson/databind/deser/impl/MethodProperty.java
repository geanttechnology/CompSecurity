// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.Annotations;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public final class MethodProperty extends SettableBeanProperty
{

    private static final long serialVersionUID = 1L;
    protected final AnnotatedMethod _annotated;
    protected final transient Method _setter;

    protected MethodProperty(MethodProperty methodproperty, JsonDeserializer jsondeserializer)
    {
        super(methodproperty, jsondeserializer);
        _annotated = methodproperty._annotated;
        _setter = methodproperty._setter;
    }

    protected MethodProperty(MethodProperty methodproperty, String s)
    {
        super(methodproperty, s);
        _annotated = methodproperty._annotated;
        _setter = methodproperty._setter;
    }

    protected MethodProperty(MethodProperty methodproperty, Method method)
    {
        super(methodproperty);
        _annotated = methodproperty._annotated;
        _setter = method;
    }

    public MethodProperty(BeanPropertyDefinition beanpropertydefinition, JavaType javatype, TypeDeserializer typedeserializer, Annotations annotations, AnnotatedMethod annotatedmethod)
    {
        super(beanpropertydefinition, javatype, typedeserializer, annotations);
        _annotated = annotatedmethod;
        _setter = annotatedmethod.getAnnotated();
    }

    public void deserializeAndSet(JsonParser jsonparser, DeserializationContext deserializationcontext, Object obj)
        throws IOException, JsonProcessingException
    {
        set(obj, deserialize(jsonparser, deserializationcontext));
    }

    public Object deserializeSetAndReturn(JsonParser jsonparser, DeserializationContext deserializationcontext, Object obj)
        throws IOException, JsonProcessingException
    {
        return setAndReturn(obj, deserialize(jsonparser, deserializationcontext));
    }

    public Annotation getAnnotation(Class class1)
    {
        return _annotated.getAnnotation(class1);
    }

    public AnnotatedMember getMember()
    {
        return _annotated;
    }

    Object readResolve()
    {
        return new MethodProperty(this, _annotated.getAnnotated());
    }

    public final void set(Object obj, Object obj1)
        throws IOException
    {
        try
        {
            _setter.invoke(obj, new Object[] {
                obj1
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            _throwAsIOE(((Exception) (obj)), obj1);
        }
    }

    public Object setAndReturn(Object obj, Object obj1)
        throws IOException
    {
        Object obj2;
        try
        {
            obj2 = _setter.invoke(obj, new Object[] {
                obj1
            });
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            _throwAsIOE(((Exception) (obj)), obj1);
            return null;
        }
        if (obj2 == null)
        {
            return obj;
        } else
        {
            return obj2;
        }
    }

    public volatile SettableBeanProperty withName(String s)
    {
        return withName(s);
    }

    public MethodProperty withName(String s)
    {
        return new MethodProperty(this, s);
    }

    public volatile SettableBeanProperty withValueDeserializer(JsonDeserializer jsondeserializer)
    {
        return withValueDeserializer(jsondeserializer);
    }

    public MethodProperty withValueDeserializer(JsonDeserializer jsondeserializer)
    {
        return new MethodProperty(this, jsondeserializer);
    }
}
