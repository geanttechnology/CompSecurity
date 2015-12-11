// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

public abstract class TypeSerializerBase extends TypeSerializer
{

    protected final TypeIdResolver _idResolver;
    protected final BeanProperty _property;

    protected TypeSerializerBase(TypeIdResolver typeidresolver, BeanProperty beanproperty)
    {
        _idResolver = typeidresolver;
        _property = beanproperty;
    }

    public String getPropertyName()
    {
        return null;
    }

    public TypeIdResolver getTypeIdResolver()
    {
        return _idResolver;
    }

    public abstract com.fasterxml.jackson.annotation.JsonTypeInfo.As getTypeInclusion();

    protected String idFromValue(Object obj)
    {
        String s = _idResolver.idFromValue(obj);
        if (s == null)
        {
            if (obj == null)
            {
                obj = "NULL";
            } else
            {
                obj = obj.getClass().getName();
            }
            throw new IllegalArgumentException((new StringBuilder()).append("Can not resolve type id for ").append(((String) (obj))).append(" (using ").append(_idResolver.getClass().getName()).append(")").toString());
        } else
        {
            return s;
        }
    }

    protected String idFromValueAndType(Object obj, Class class1)
    {
        class1 = _idResolver.idFromValueAndType(obj, class1);
        if (class1 == null)
        {
            if (obj == null)
            {
                obj = "NULL";
            } else
            {
                obj = obj.getClass().getName();
            }
            throw new IllegalArgumentException((new StringBuilder()).append("Can not resolve type id for ").append(((String) (obj))).append(" (using ").append(_idResolver.getClass().getName()).append(")").toString());
        } else
        {
            return class1;
        }
    }
}
