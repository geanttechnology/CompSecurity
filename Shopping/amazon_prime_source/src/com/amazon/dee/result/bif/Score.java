// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dee.result.bif;

import com.google.common.base.Objects;

// Referenced classes of package com.amazon.dee.result.bif:
//            ConfidenceBin

public class Score
{

    public static final Score ZERO = new Score(0.0D);
    private ConfidenceBin mBin;
    private double mValue;

    private Score()
    {
    }

    public Score(double d)
    {
        mValue = d;
        mBin = null;
    }

    public Score(double d, ConfidenceBin confidencebin)
    {
        mValue = d;
        mBin = confidencebin;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof Score)
        {
            obj = (Score)obj;
            flag = flag1;
            if (Objects.equal(Double.valueOf(mValue), Double.valueOf(((Score) (obj)).mValue)))
            {
                flag = flag1;
                if (Objects.equal(mBin, ((Score) (obj)).mBin))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public ConfidenceBin getBin()
    {
        return mBin;
    }

    public double getValue()
    {
        return mValue;
    }

    public int hashCode()
    {
        return Objects.hashCode(new Object[] {
            Double.valueOf(mValue), mBin
        });
    }

    public void setBin(ConfidenceBin confidencebin)
    {
        mBin = confidencebin;
    }

    public void setValue(double d)
    {
        mValue = d;
    }

}
