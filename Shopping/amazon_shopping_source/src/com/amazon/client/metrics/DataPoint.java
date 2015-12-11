// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;


// Referenced classes of package com.amazon.client.metrics:
//            DataPointType

public class DataPoint
{

    private final String mName;
    private final int mSamples;
    private final DataPointType mType;
    private final String mValue;

    public DataPoint(String s, String s1, int i, DataPointType datapointtype)
    {
        validateString(s, "name cannot be null or empty");
        validateString(s1, "value cannot be null or empty");
        if (datapointtype == null)
        {
            throw new IllegalArgumentException("DataPoint type cannot be null");
        } else
        {
            mName = s;
            mValue = s1;
            mSamples = i;
            mType = datapointtype;
            return;
        }
    }

    private void validateString(String s, String s1)
    {
        if (s == null || s.isEmpty())
        {
            throw new IllegalArgumentException(s1);
        } else
        {
            return;
        }
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (getClass() != obj.getClass())
            {
                return false;
            }
            obj = (DataPoint)obj;
            if (!mName.equals(((DataPoint) (obj)).mName))
            {
                return false;
            }
            if (mSamples != ((DataPoint) (obj)).mSamples)
            {
                return false;
            }
            if (!mType.equals(((DataPoint) (obj)).mType))
            {
                return false;
            }
            if (!mValue.equals(((DataPoint) (obj)).mValue))
            {
                return false;
            }
        }
        return true;
    }

    public String getName()
    {
        return mName;
    }

    public int getSamples()
    {
        return mSamples;
    }

    public DataPointType getType()
    {
        return mType;
    }

    public String getValue()
    {
        return mValue;
    }

    public int hashCode()
    {
        int k = 0;
        int i;
        int j;
        int l;
        if (mName == null)
        {
            i = 0;
        } else
        {
            i = mName.hashCode();
        }
        l = mSamples;
        if (mType == null)
        {
            j = 0;
        } else
        {
            j = mType.hashCode();
        }
        if (mValue != null)
        {
            k = mValue.hashCode();
        }
        return (((i + 31) * 31 + l) * 31 + j) * 31 + k;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(" [");
        stringbuilder.append(mName);
        stringbuilder.append(",");
        stringbuilder.append(mValue);
        stringbuilder.append(",");
        stringbuilder.append(mSamples);
        stringbuilder.append("] ");
        return stringbuilder.toString();
    }
}
