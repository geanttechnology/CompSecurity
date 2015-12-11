// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.bluefront.api.v2;

import com.amazon.bluefront.api.common.Customer;
import com.amazon.bluefront.api.common.Device;
import java.util.Map;

public class ServiceParameters
    implements Comparable
{

    private Customer mCustomer;
    private Device mDevice;
    private Map mMetadata;
    private String mRequestId;

    public ServiceParameters()
    {
    }

    private static int compareObjects(Object obj, Object obj1)
    {
        int i = -1;
        if (obj == obj1) goto _L2; else goto _L1
_L1:
        if (obj != null) goto _L4; else goto _L3
_L3:
        return i;
_L4:
        if (obj1 == null)
        {
            return 1;
        }
        if (obj instanceof Comparable)
        {
            int j = ((Comparable)obj).compareTo(obj1);
            i = j;
            if (j != 0)
            {
                continue; /* Loop/switch isn't completed */
            }
        } else
        if (!obj.equals(obj1))
        {
            int k = obj.hashCode();
            int l = obj1.hashCode();
            if (k < l)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (k > l)
            {
                return 1;
            }
        }
_L2:
        return 0;
        if (true) goto _L3; else goto _L5
_L5:
    }

    public int compareTo(ServiceParameters serviceparameters)
    {
        int i;
        if (serviceparameters == null)
        {
            i = -1;
        } else
        {
            if (serviceparameters == this)
            {
                return 0;
            }
            int j = compareObjects(getRequestId(), serviceparameters.getRequestId());
            i = j;
            if (j == 0)
            {
                int k = compareObjects(getMetadata(), serviceparameters.getMetadata());
                i = k;
                if (k == 0)
                {
                    int l = compareObjects(getDevice(), serviceparameters.getDevice());
                    i = l;
                    if (l == 0)
                    {
                        int i1 = compareObjects(getCustomer(), serviceparameters.getCustomer());
                        i = i1;
                        if (i1 == 0)
                        {
                            return 0;
                        }
                    }
                }
            }
        }
        return i;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((ServiceParameters)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof ServiceParameters)
            {
                if (compareTo((ServiceParameters)obj) != 0)
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

    public Customer getCustomer()
    {
        return mCustomer;
    }

    public Device getDevice()
    {
        return mDevice;
    }

    public Map getMetadata()
    {
        return mMetadata;
    }

    public String getRequestId()
    {
        return mRequestId;
    }

    public int hashCode()
    {
        int l = 0;
        int i;
        int j;
        int k;
        if (getRequestId() == null)
        {
            i = 0;
        } else
        {
            i = getRequestId().hashCode();
        }
        if (getMetadata() == null)
        {
            j = 0;
        } else
        {
            j = getMetadata().hashCode();
        }
        if (getDevice() == null)
        {
            k = 0;
        } else
        {
            k = getDevice().hashCode();
        }
        if (getCustomer() != null)
        {
            l = getCustomer().hashCode();
        }
        return 1 + i + j + k + l;
    }

    public void setCustomer(Customer customer)
    {
        mCustomer = customer;
    }

    public void setDevice(Device device)
    {
        mDevice = device;
    }

    public void setMetadata(Map map)
    {
        mMetadata = map;
    }

    public void setRequestId(String s)
    {
        mRequestId = s;
    }
}
