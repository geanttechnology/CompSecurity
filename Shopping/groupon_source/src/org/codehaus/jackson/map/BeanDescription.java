// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map;

import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.type.JavaType;

public abstract class BeanDescription
{

    protected final JavaType _type;

    protected BeanDescription(JavaType javatype)
    {
        _type = javatype;
    }

    public Class getBeanClass()
    {
        return _type.getRawClass();
    }

    public abstract AnnotatedClass getClassInfo();

    public JavaType getType()
    {
        return _type;
    }
}
