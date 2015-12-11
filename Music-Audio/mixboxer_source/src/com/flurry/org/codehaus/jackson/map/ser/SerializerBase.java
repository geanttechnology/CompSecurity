// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.ser;

import com.flurry.org.codehaus.jackson.type.JavaType;

public abstract class SerializerBase extends com.flurry.org.codehaus.jackson.map.ser.std.SerializerBase
{

    protected SerializerBase(JavaType javatype)
    {
        super(javatype);
    }

    protected SerializerBase(Class class1)
    {
        super(class1);
    }

    protected SerializerBase(Class class1, boolean flag)
    {
        super(class1, flag);
    }
}
