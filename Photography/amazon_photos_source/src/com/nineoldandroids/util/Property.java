// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.util;


public abstract class Property
{

    private final String mName;
    private final Class mType;

    public Property(Class class1, String s)
    {
        mName = s;
        mType = class1;
    }

    public abstract Object get(Object obj);

    public String getName()
    {
        return mName;
    }

    public void set(Object obj, Object obj1)
    {
        throw new UnsupportedOperationException((new StringBuilder()).append("Property ").append(getName()).append(" is read-only").toString());
    }
}
