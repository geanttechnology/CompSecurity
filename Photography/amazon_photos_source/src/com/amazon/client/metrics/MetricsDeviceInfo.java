// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import java.util.HashMap;
import java.util.Map;

public class MetricsDeviceInfo
{

    private final Map mDeviceInfo = new HashMap();

    public MetricsDeviceInfo()
    {
    }

    public void addDeviceInfoData(String s, String s1)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("device info key cannot be null");
        } else
        {
            mDeviceInfo.put(s, s1);
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
            obj = (MetricsDeviceInfo)obj;
            if (!mDeviceInfo.equals(((MetricsDeviceInfo) (obj)).mDeviceInfo))
            {
                return false;
            }
        }
        return true;
    }

    public String getDeviceInfo(String s)
    {
        return (String)mDeviceInfo.get(s);
    }

    public Map getDeviceInfo()
    {
        return mDeviceInfo;
    }

    public int hashCode()
    {
        return mDeviceInfo.hashCode() + 31;
    }

    public String toString()
    {
        return (new StringBuilder()).append("MetricsDeviceInfo [mDeviceInfo=").append(mDeviceInfo).append("]").toString();
    }
}
