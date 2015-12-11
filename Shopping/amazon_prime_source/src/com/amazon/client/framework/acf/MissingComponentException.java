// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf;


// Referenced classes of package com.amazon.client.framework.acf:
//            Components

public class MissingComponentException extends RuntimeException
{

    private static final long serialVersionUID = 0xdb990c1a30d34ef5L;
    private final String mMissingComponentKey;
    private final Class mMissingComponentType;

    public MissingComponentException(Class class1)
    {
        mMissingComponentType = class1;
        mMissingComponentKey = Components.getName(class1);
    }

    public MissingComponentException(Class class1, String s, String s1)
    {
        super(s1);
        mMissingComponentType = class1;
        mMissingComponentKey = s;
    }

    public MissingComponentException(Class class1, String s, String s1, Throwable throwable)
    {
        super(s1, throwable);
        mMissingComponentType = class1;
        mMissingComponentKey = s;
    }

    public MissingComponentException(Class class1, Throwable throwable)
    {
        super(throwable);
        mMissingComponentType = class1;
        mMissingComponentKey = Components.getName(class1);
    }

    public MissingComponentException(String s)
    {
        super(s);
        mMissingComponentType = null;
        mMissingComponentKey = null;
    }

    public MissingComponentException(String s, String s1)
    {
        super(s1);
        mMissingComponentType = null;
        mMissingComponentKey = s;
    }

    public MissingComponentException(String s, String s1, Throwable throwable)
    {
        super(s1, throwable);
        mMissingComponentType = null;
        mMissingComponentKey = s;
    }

    public String getMissingComponentKey()
    {
        return mMissingComponentKey;
    }

    public Class getMissingComponentType()
    {
        return mMissingComponentType;
    }
}
