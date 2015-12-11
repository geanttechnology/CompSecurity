// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.bluefront.api.v1;


public class ResultFormat
    implements Comparable
{

    private int mMaxNBest;
    private String mType;

    public ResultFormat()
    {
    }

    public int compareTo(ResultFormat resultformat)
    {
        if (resultformat != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        String s;
        String s1;
        if (resultformat == this)
        {
            return 0;
        }
        s = getType();
        s1 = resultformat.getType();
        if (s == s1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s == null)
        {
            return -1;
        }
        if (s1 == null)
        {
            return 1;
        }
        if (!(s instanceof Comparable)) goto _L4; else goto _L3
_L3:
        int k;
        k = ((Comparable)s).compareTo(s1);
        i = k;
        if (k != 0) goto _L6; else goto _L5
_L5:
        if (getMaxNBest() < resultformat.getMaxNBest())
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (!s.equals(s1))
        {
            int j = s.hashCode();
            int l = s1.hashCode();
            if (j < l)
            {
                return -1;
            }
            if (j > l)
            {
                return 1;
            }
        }
        if (true) goto _L5; else goto _L7
_L7:
        return getMaxNBest() <= resultformat.getMaxNBest() ? 0 : 1;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((ResultFormat)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof ResultFormat)
            {
                if (compareTo((ResultFormat)obj) != 0)
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

    public String getType()
    {
        return mType;
    }

    public int hashCode()
    {
        int i;
        if (getType() == null)
        {
            i = 0;
        } else
        {
            i = getType().hashCode();
        }
        return 1 + i + getMaxNBest();
    }

    public void setMaxNBest(int i)
    {
        mMaxNBest = i;
    }

    public void setType(String s)
    {
        mType = s;
    }
}
