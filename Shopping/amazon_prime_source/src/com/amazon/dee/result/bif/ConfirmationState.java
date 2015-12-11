// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dee.result.bif;

import com.google.common.base.Objects;

public class ConfirmationState
{

    private double mScore;
    private boolean mValue;

    public ConfirmationState()
    {
        mScore = 0.0D;
        mValue = false;
    }

    public ConfirmationState(boolean flag, double d)
    {
        mScore = d;
        mValue = flag;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof ConfirmationState)
        {
            obj = (ConfirmationState)obj;
            flag = flag1;
            if (Objects.equal(Double.valueOf(mScore), Double.valueOf(((ConfirmationState) (obj)).mScore)))
            {
                flag = flag1;
                if (Objects.equal(Boolean.valueOf(mValue), Boolean.valueOf(((ConfirmationState) (obj)).mValue)))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public double getScore()
    {
        return mScore;
    }

    public boolean getValue()
    {
        return mValue;
    }

    public int hashCode()
    {
        return Objects.hashCode(new Object[] {
            Double.valueOf(mScore), Boolean.valueOf(mValue)
        });
    }

    public void setScore(double d)
    {
        mScore = d;
    }

    public void setValue(boolean flag)
    {
        mValue = flag;
    }
}
