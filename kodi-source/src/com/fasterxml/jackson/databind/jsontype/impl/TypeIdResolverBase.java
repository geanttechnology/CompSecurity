// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.type.TypeFactory;

public abstract class TypeIdResolverBase
    implements TypeIdResolver
{

    protected final JavaType _baseType;
    protected final TypeFactory _typeFactory;

    protected TypeIdResolverBase()
    {
        this(null, null);
    }

    protected TypeIdResolverBase(JavaType javatype, TypeFactory typefactory)
    {
        _baseType = javatype;
        _typeFactory = typefactory;
    }

    public String getDescForKnownTypeIds()
    {
        return null;
    }

    public String idFromBaseType()
    {
        return idFromValueAndType(null, _baseType.getRawClass());
    }

    public void init(JavaType javatype)
    {
    }

    public JavaType typeFromId(DatabindContext databindcontext, String s)
    {
        return typeFromId(s);
    }

    public JavaType typeFromId(String s)
    {
        return typeFromId(null, s);
    }
}
