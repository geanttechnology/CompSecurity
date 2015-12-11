// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import com.amazon.client.metrics.codec.EncodedMetricEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetricBatch
{

    private long mBatchSizeInBytes;
    private boolean mContainsUserMetrics;
    private final Map mDeviceInfoMap;
    private String mDeviceSerialNumber;
    private String mDeviceType;
    private final List mSerializedMetricEntryList;

    public MetricBatch()
    {
        mSerializedMetricEntryList = new ArrayList();
        mDeviceInfoMap = new HashMap();
    }

    public MetricBatch(Map map)
    {
        mSerializedMetricEntryList = new ArrayList();
        mDeviceInfoMap = new HashMap();
        putMetricsDeviceInfo(map);
    }

    public void addEntry(EncodedMetricEntry encodedmetricentry)
    {
        this;
        JVM INSTR monitorenter ;
        mSerializedMetricEntryList.add(encodedmetricentry);
        mBatchSizeInBytes = mBatchSizeInBytes + (long)encodedmetricentry.getEncodedSize();
        this;
        JVM INSTR monitorexit ;
        return;
        encodedmetricentry;
        throw encodedmetricentry;
    }

    public boolean containsUserMetrics()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mContainsUserMetrics;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
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
            obj = (MetricBatch)obj;
            if (getMetricEntryCount() != ((MetricBatch) (obj)).getMetricEntryCount())
            {
                return false;
            }
            int i = 0;
            while (i < getMetricEntryCount()) 
            {
                if (!getMetricEntry(i).equals(((MetricBatch) (obj)).getMetricEntry(i)))
                {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public long getBatchSizeInBytes()
    {
        this;
        JVM INSTR monitorenter ;
        long l = mBatchSizeInBytes;
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public Map getDeviceInfoMap()
    {
        return mDeviceInfoMap;
    }

    public String getDeviceSerialNumber()
    {
        return mDeviceSerialNumber;
    }

    public String getDeviceType()
    {
        return mDeviceType;
    }

    public EncodedMetricEntry getMetricEntry(int i)
    {
        this;
        JVM INSTR monitorenter ;
        EncodedMetricEntry encodedmetricentry = (EncodedMetricEntry)mSerializedMetricEntryList.get(i);
        this;
        JVM INSTR monitorexit ;
        return encodedmetricentry;
        Exception exception;
        exception;
        throw exception;
    }

    public int getMetricEntryCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = mSerializedMetricEntryList.size();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public int hashCode()
    {
        int j = 1;
        for (int i = 0; i < getMetricEntryCount(); i++)
        {
            j = j * 31 + getMetricEntry(i).hashCode();
        }

        return j;
    }

    public void putMetricsDeviceInfo(Map map)
    {
        if (map == null)
        {
            throw new IllegalArgumentException("Device Info Map is null");
        }
        mDeviceInfoMap.putAll(map);
        mDeviceSerialNumber = (String)mDeviceInfoMap.remove("deviceId");
        mDeviceType = (String)mDeviceInfoMap.remove("deviceType");
        if (mDeviceSerialNumber == null || mDeviceSerialNumber.trim().isEmpty())
        {
            throw new IllegalArgumentException("Device Info Map missing device ID");
        } else
        {
            return;
        }
    }

    public void setContainsUserMetrics(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        mContainsUserMetrics = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(mDeviceSerialNumber);
        stringbuilder.append("\n");
        stringbuilder.append(mDeviceType);
        stringbuilder.append("\n");
        stringbuilder.append(mDeviceInfoMap.toString());
        stringbuilder.append("\n");
        stringbuilder.append(mBatchSizeInBytes);
        stringbuilder.append("\n");
        for (int i = 0; i < mSerializedMetricEntryList.size(); i++)
        {
            stringbuilder.append(((EncodedMetricEntry)mSerializedMetricEntryList.get(i)).toString());
        }

        stringbuilder.append("\n");
        return stringbuilder.toString();
    }
}
