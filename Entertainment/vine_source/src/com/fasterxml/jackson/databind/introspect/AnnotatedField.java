// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

// Referenced classes of package com.fasterxml.jackson.databind.introspect:
//            AnnotatedMember, AnnotationMap, Annotated

public final class AnnotatedField extends AnnotatedMember
    implements Serializable
{
    private static final class Serialization
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        protected Class clazz;
        protected String name;

        public Serialization(Field field)
        {
            clazz = field.getDeclaringClass();
            name = field.getName();
        }
    }


    private static final long serialVersionUID = 0x6633b4850c53b6dfL;
    protected final transient Field _field;
    protected Serialization _serialization;

    protected AnnotatedField(Serialization serialization)
    {
        super(null);
        _field = null;
        _serialization = serialization;
    }

    public AnnotatedField(Field field, AnnotationMap annotationmap)
    {
        super(annotationmap);
        _field = field;
    }

    public volatile AnnotatedElement getAnnotated()
    {
        return getAnnotated();
    }

    public Field getAnnotated()
    {
        return _field;
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

    public int getAnnotationCount()
    {
        return _annotations.size();
    }

    public Class getDeclaringClass()
    {
        return _field.getDeclaringClass();
    }

    public String getFullName()
    {
        return (new StringBuilder()).append(getDeclaringClass().getName()).append("#").append(getName()).toString();
    }

    public Type getGenericType()
    {
        return _field.getGenericType();
    }

    public Member getMember()
    {
        return _field;
    }

    public int getModifiers()
    {
        return _field.getModifiers();
    }

    public String getName()
    {
        return _field.getName();
    }

    public Class getRawType()
    {
        return _field.getType();
    }

    public Object getValue(Object obj)
        throws IllegalArgumentException
    {
        try
        {
            obj = _field.get(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Failed to getValue() for field ").append(getFullName()).append(": ").append(((IllegalAccessException) (obj)).getMessage()).toString(), ((Throwable) (obj)));
        }
        return obj;
    }

    Object readResolve()
    {
        Class class1 = _serialization.clazz;
        Object obj;
        try
        {
            obj = class1.getDeclaredField(_serialization.name);
            if (!((Field) (obj)).isAccessible())
            {
                ClassUtil.checkAndFixAccess(((Member) (obj)));
            }
            obj = new AnnotatedField(((Field) (obj)), null);
        }
        catch (Exception exception)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Could not find method '").append(_serialization.name).append("' from Class '").append(class1.getName()).toString());
        }
        return obj;
    }

    public void setValue(Object obj, Object obj1)
        throws IllegalArgumentException
    {
        try
        {
            _field.set(obj, obj1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Failed to setValue() for field ").append(getFullName()).append(": ").append(((IllegalAccessException) (obj)).getMessage()).toString(), ((Throwable) (obj)));
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("[field ").append(getFullName()).append("]").toString();
    }

    public volatile Annotated withAnnotations(AnnotationMap annotationmap)
    {
        return withAnnotations(annotationmap);
    }

    public AnnotatedField withAnnotations(AnnotationMap annotationmap)
    {
        return new AnnotatedField(_field, annotationmap);
    }

    Object writeReplace()
    {
        return new AnnotatedField(new Serialization(_field));
    }
}
