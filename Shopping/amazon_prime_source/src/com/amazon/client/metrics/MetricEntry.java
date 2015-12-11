// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import java.util.List;

// Referenced classes of package com.amazon.client.metrics:
//            DataPoint

public class MetricEntry
{

    private final List mDatapoints;
    private final String mProgram;
    private final String mSource;
    private final long mTimestamp;

    public MetricEntry(long l, String s, String s1, List list)
    {
        if (s == null || s.isEmpty())
        {
            throw new IllegalArgumentException("program cannot be empty or null");
        }
        if (s1 == null || s1.isEmpty())
        {
            throw new IllegalArgumentException("source cannot be empty or null");
        }
        if (list == null)
        {
            throw new IllegalArgumentException("data points cannot be null");
        } else
        {
            mTimestamp = l;
            mProgram = s;
            mSource = s1;
            mDatapoints = list;
            return;
        }
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            obj = (MetricEntry)obj;
            if (!mDatapoints.equals(((MetricEntry) (obj)).mDatapoints))
            {
                return false;
            }
            if (!mProgram.equals(((MetricEntry) (obj)).mProgram))
            {
                return false;
            }
            if (!mSource.equals(((MetricEntry) (obj)).mSource))
            {
                return false;
            }
            if (mTimestamp != ((MetricEntry) (obj)).mTimestamp)
            {
                return false;
            }
        }
        return true;
    }

    public List getDatapoints()
    {
        return mDatapoints;
    }

    public String getProgram()
    {
        return mProgram;
    }

    public String getSource()
    {
        return mSource;
    }

    public long getTimestamp()
    {
        return mTimestamp;
    }

    public int hashCode()
    {
        return (((mDatapoints.hashCode() + 31) * 31 + mProgram.hashCode()) * 31 + mSource.hashCode()) * 31 + (int)(mTimestamp ^ mTimestamp >>> 32);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(mTimestamp);
        stringbuilder.append(" ");
        stringbuilder.append(mProgram);
        stringbuilder.append(" ");
        stringbuilder.append(mSource);
        stringbuilder.append(" ");
        for (int i = 0; i < mDatapoints.size(); i++)
        {
            stringbuilder.append(((DataPoint)mDatapoints.get(i)).toString());
        }

        return stringbuilder.toString();
    }
}
