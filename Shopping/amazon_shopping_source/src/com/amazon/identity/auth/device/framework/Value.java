// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import com.amazon.identity.auth.device.utils.GenericUtils;
import com.amazon.identity.auth.device.utils.PublicCloneable;

public class Value
    implements PublicCloneable
{

    private final Object mValue;

    public Value(Object obj)
    {
        mValue = obj;
    }

    public Value cloneObject()
    {
        Value value;
        try
        {
            value = new Value(GenericUtils.typeSafeClone(mValue));
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            throw new RuntimeException(clonenotsupportedexception);
        }
        return value;
    }

    public volatile PublicCloneable cloneObject()
    {
        return cloneObject();
    }

    public Object getValue()
    {
        return mValue;
    }
}
