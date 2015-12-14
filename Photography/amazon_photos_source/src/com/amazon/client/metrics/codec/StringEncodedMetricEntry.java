// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.codec;


// Referenced classes of package com.amazon.client.metrics.codec:
//            EncodedMetricEntry

public class StringEncodedMetricEntry
    implements EncodedMetricEntry
{

    private String mEncodedMetricEntry;

    public StringEncodedMetricEntry(String s)
    {
        mEncodedMetricEntry = s;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag;
        if (this == obj)
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (obj != null)
            {
                flag = flag1;
                if (getClass() == obj.getClass())
                {
                    obj = (StringEncodedMetricEntry)obj;
                    return mEncodedMetricEntry.equals(((StringEncodedMetricEntry) (obj)).getEncodedMetricEntry());
                }
            }
        }
        return flag;
    }

    public volatile Object getEncodedMetricEntry()
    {
        return getEncodedMetricEntry();
    }

    public String getEncodedMetricEntry()
    {
        return mEncodedMetricEntry;
    }

    public int getEncodedSize()
    {
        return mEncodedMetricEntry.getBytes().length;
    }

    public int hashCode()
    {
        return mEncodedMetricEntry.hashCode();
    }

    public String toString()
    {
        return mEncodedMetricEntry;
    }
}
