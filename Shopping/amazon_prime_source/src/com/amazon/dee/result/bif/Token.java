// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dee.result.bif;

import com.google.common.base.Objects;

public class Token
{

    private double mConfidence;
    private String mValue;

    public Token()
    {
    }

    public Token(String s)
    {
        this(s, 0.0D);
    }

    public Token(String s, double d)
    {
        mValue = s;
        mConfidence = d;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof Token)
        {
            obj = (Token)obj;
            flag = flag1;
            if (Objects.equal(Double.valueOf(mConfidence), Double.valueOf(((Token) (obj)).mConfidence)))
            {
                flag = flag1;
                if (Objects.equal(mValue, ((Token) (obj)).mValue))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public final double getConfidence()
    {
        return mConfidence;
    }

    public final String getValue()
    {
        return mValue;
    }

    public int hashCode()
    {
        return Objects.hashCode(new Object[] {
            Double.valueOf(mConfidence), mValue
        });
    }

    public final void setConfidence(double d)
    {
        mConfidence = d;
    }

    public final void setValue(String s)
    {
        mValue = s;
    }
}
