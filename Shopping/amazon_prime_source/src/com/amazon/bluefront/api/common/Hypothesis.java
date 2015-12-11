// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.bluefront.api.common;


public class Hypothesis
    implements Comparable
{

    private int mConfidence;
    private String mUtterance;

    public Hypothesis()
    {
    }

    public int compareTo(Hypothesis hypothesis)
    {
        int j = -1;
        if (hypothesis != null) goto _L2; else goto _L1
_L1:
        int i = j;
_L6:
        return i;
_L2:
        String s;
        if (hypothesis == this)
        {
            return 0;
        }
        i = j;
        if (getConfidence() < hypothesis.getConfidence())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (getConfidence() > hypothesis.getConfidence())
        {
            return 1;
        }
        s = getUtterance();
        hypothesis = hypothesis.getUtterance();
        if (s == hypothesis)
        {
            break; /* Loop/switch isn't completed */
        }
        i = j;
        if (s == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (hypothesis == null)
        {
            return 1;
        }
        if (!(s instanceof Comparable)) goto _L4; else goto _L3
_L3:
        j = ((Comparable)s).compareTo(hypothesis);
        i = j;
        if (j != 0) goto _L6; else goto _L5
_L5:
        return 0;
_L4:
        if (!s.equals(hypothesis))
        {
            int k = s.hashCode();
            int l = hypothesis.hashCode();
            i = j;
            if (k < l)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (k > l)
            {
                return 1;
            }
        }
        if (true) goto _L5; else goto _L7
_L7:
        if (true) goto _L6; else goto _L8
_L8:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((Hypothesis)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof Hypothesis)
            {
                if (compareTo((Hypothesis)obj) != 0)
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

    public int getConfidence()
    {
        return mConfidence;
    }

    public String getUtterance()
    {
        return mUtterance;
    }

    public int hashCode()
    {
        int j = getConfidence();
        int i;
        if (getUtterance() == null)
        {
            i = 0;
        } else
        {
            i = getUtterance().hashCode();
        }
        return 1 + j + i;
    }

    public void setConfidence(int i)
    {
        mConfidence = i;
    }

    public void setUtterance(String s)
    {
        mUtterance = s;
    }
}
