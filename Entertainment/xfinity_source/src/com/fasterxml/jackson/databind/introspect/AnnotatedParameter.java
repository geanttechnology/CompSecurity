// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

// Referenced classes of package com.fasterxml.jackson.databind.introspect:
//            AnnotatedMember, AnnotationMap, AnnotatedWithParams, Annotated

public final class AnnotatedParameter extends AnnotatedMember
{

    protected final int _index;
    protected final AnnotatedWithParams _owner;
    protected final Type _type;

    public AnnotatedParameter(AnnotatedWithParams annotatedwithparams, Type type, AnnotationMap annotationmap, int i)
    {
        super(annotationmap);
        _owner = annotatedwithparams;
        _type = type;
        _index = i;
    }

    public AnnotatedElement getAnnotated()
    {
        return null;
    }

    public Annotation getAnnotation(Class class1)
    {
        if (_annotations == null)
        {
            return null;
        } else
        {
            return _annotations.get(class1);
        }
    }

    public Class getDeclaringClass()
    {
        return _owner.getDeclaringClass();
    }

    public Type getGenericType()
    {
        return _type;
    }

    public int getIndex()
    {
        return _index;
    }

    public Member getMember()
    {
        return _owner.getMember();
    }

    public int getModifiers()
    {
        return _owner.getModifiers();
    }

    public String getName()
    {
        return "";
    }

    public AnnotatedWithParams getOwner()
    {
        return _owner;
    }

    public Type getParameterType()
    {
        return _type;
    }

    public Class getRawType()
    {
        if (_type instanceof Class)
        {
            return (Class)_type;
        } else
        {
            return TypeFactory.defaultInstance().constructType(_type).getRawClass();
        }
    }

    public Object getValue(Object obj)
        throws UnsupportedOperationException
    {
        throw new UnsupportedOperationException((new StringBuilder()).append("Cannot call getValue() on constructor parameter of ").append(getDeclaringClass().getName()).toString());
    }

    public void setValue(Object obj, Object obj1)
        throws UnsupportedOperationException
    {
        throw new UnsupportedOperationException((new StringBuilder()).append("Cannot call setValue() on constructor parameter of ").append(getDeclaringClass().getName()).toString());
    }

    public String toString()
    {
        return (new StringBuilder()).append("[parameter #").append(getIndex()).append(", annotations: ").append(_annotations).append("]").toString();
    }

    public volatile Annotated withAnnotations(AnnotationMap annotationmap)
    {
        return withAnnotations(annotationmap);
    }

    public AnnotatedParameter withAnnotations(AnnotationMap annotationmap)
    {
        if (annotationmap == _annotations)
        {
            return this;
        } else
        {
            return _owner.replaceParameterAnnotations(_index, annotationmap);
        }
    }
}
