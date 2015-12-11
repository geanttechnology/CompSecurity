// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.bluefront.api.v2;


public class RecognitionParameters
    implements Comparable
{

    private int mMaxNBest;
    private String mOutputFormat;

    public RecognitionParameters()
    {
    }

    public int compareTo(RecognitionParameters recognitionparameters)
    {
        int j = -1;
        if (recognitionparameters != null) goto _L2; else goto _L1
_L1:
        int i = j;
_L6:
        return i;
_L2:
        String s;
        if (recognitionparameters == this)
        {
            return 0;
        }
        i = j;
        if (getMaxNBest() < recognitionparameters.getMaxNBest())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (getMaxNBest() > recognitionparameters.getMaxNBest())
        {
            return 1;
        }
        s = getOutputFormat();
        recognitionparameters = recognitionparameters.getOutputFormat();
        if (s == recognitionparameters)
        {
            break; /* Loop/switch isn't completed */
        }
        i = j;
        if (s == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (recognitionparameters == null)
        {
            return 1;
        }
        if (!(s instanceof Comparable)) goto _L4; else goto _L3
_L3:
        j = ((Comparable)s).compareTo(recognitionparameters);
        i = j;
        if (j != 0) goto _L6; else goto _L5
_L5:
        return 0;
_L4:
        if (!s.equals(recognitionparameters))
        {
            int k = s.hashCode();
            int l = recognitionparameters.hashCode();
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
        return compareTo((RecognitionParameters)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof RecognitionParameters)
            {
                if (compareTo((RecognitionParameters)obj) != 0)
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

    public String getOutputFormat()
    {
        return mOutputFormat;
    }

    public int hashCode()
    {
        int j = getMaxNBest();
        int i;
        if (getOutputFormat() == null)
        {
            i = 0;
        } else
        {
            i = getOutputFormat().hashCode();
        }
        return 1 + j + i;
    }

    public void setMaxNBest(int i)
    {
        mMaxNBest = i;
    }

    public void setOutputFormat(String s)
    {
        mOutputFormat = s;
    }
}
