// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dee.result.bif;

import com.google.common.base.Objects;

public class Value
{

    private Object mValue;

    public Value()
    {
        this(null);
    }

    public Value(Object obj)
    {
        mValue = obj;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Value)
        {
            obj = (Value)obj;
            return Objects.equal(mValue, ((Value) (obj)).mValue);
        } else
        {
            return false;
        }
    }

    public Object getValue()
    {
        return mValue;
    }

    public Object getValueAsType(Class class1)
    {
        try
        {
            class1 = ((Class) (class1.cast(mValue)));
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return null;
        }
        return class1;
    }

    public int hashCode()
    {
        return Objects.hashCode(new Object[] {
            mValue
        });
    }

    public boolean isValueNull()
    {
        return mValue == null;
    }

    public void setValue(Object obj)
    {
        mValue = obj;
    }

    public String toString()
    {
        if (isValueNull())
        {
            return "null";
        } else
        {
            return mValue.toString();
        }
    }
}
