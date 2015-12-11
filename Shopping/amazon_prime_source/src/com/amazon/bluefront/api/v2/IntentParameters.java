// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.bluefront.api.v2;


public class IntentParameters
    implements Comparable
{

    private int mMaxNBest;

    public IntentParameters()
    {
    }

    public int compareTo(IntentParameters intentparameters)
    {
        if (intentparameters != null)
        {
            if (intentparameters == this)
            {
                return 0;
            }
            if (getMaxNBest() >= intentparameters.getMaxNBest())
            {
                return getMaxNBest() <= intentparameters.getMaxNBest() ? 0 : 1;
            }
        }
        return -1;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((IntentParameters)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof IntentParameters)
            {
                if (compareTo((IntentParameters)obj) != 0)
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public int getMaxNBest()
    {
        return mMaxNBest;
    }

    public int hashCode()
    {
        return 1 + getMaxNBest();
    }

    public void setMaxNBest(int i)
    {
        mMaxNBest = i;
    }
}
