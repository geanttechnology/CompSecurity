// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.bluefront.api.common;


public class Device
    implements Comparable
{

    private String mDeviceSerialNumber;

    public Device()
    {
    }

    public int compareTo(Device device)
    {
        int j = -1;
        if (device != null) goto _L2; else goto _L1
_L1:
        int i = j;
_L6:
        return i;
_L2:
        String s;
        if (device == this)
        {
            return 0;
        }
        s = getDeviceSerialNumber();
        device = device.getDeviceSerialNumber();
        if (s == device)
        {
            break; /* Loop/switch isn't completed */
        }
        i = j;
        if (s == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (device == null)
        {
            return 1;
        }
        if (!(s instanceof Comparable)) goto _L4; else goto _L3
_L3:
        j = ((Comparable)s).compareTo(device);
        i = j;
        if (j != 0) goto _L6; else goto _L5
_L5:
        return 0;
_L4:
        if (!s.equals(device))
        {
            int k = s.hashCode();
            int l = device.hashCode();
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
        return compareTo((Device)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof Device)
            {
                if (compareTo((Device)obj) != 0)
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

    public String getDeviceSerialNumber()
    {
        return mDeviceSerialNumber;
    }

    public int hashCode()
    {
        int i;
        if (getDeviceSerialNumber() == null)
        {
            i = 0;
        } else
        {
            i = getDeviceSerialNumber().hashCode();
        }
        return 1 + i;
    }

    public void setDeviceSerialNumber(String s)
    {
        mDeviceSerialNumber = s;
    }
}
