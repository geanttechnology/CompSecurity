// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.bluefront.api.v1;

import com.amazon.bluefront.api.common.Customer;
import com.amazon.bluefront.api.common.Device;

// Referenced classes of package com.amazon.bluefront.api.v1:
//            ResultFormat

public class RecognitionParameters
    implements Comparable
{

    private Customer mCustomer;
    private Device mDevice;
    private ResultFormat mResultFormat;

    public RecognitionParameters()
    {
    }

    public int compareTo(RecognitionParameters recognitionparameters)
    {
        if (recognitionparameters != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        Object obj;
        Object obj1;
        if (recognitionparameters == this)
        {
            return 0;
        }
        obj = getDevice();
        obj1 = recognitionparameters.getDevice();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L4; else goto _L3
_L3:
        int k;
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L5
_L5:
        obj = getCustomer();
        obj1 = recognitionparameters.getCustomer();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L5; else goto _L7
_L7:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L9; else goto _L8
_L8:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L10
_L10:
        obj = getResultFormat();
        recognitionparameters = recognitionparameters.getResultFormat();
        if (obj == recognitionparameters)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L9:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L10; else goto _L11
_L11:
        if (recognitionparameters == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L13; else goto _L12
_L12:
        k = ((Comparable)obj).compareTo(recognitionparameters);
        i = k;
        if (k != 0) goto _L6; else goto _L14
_L14:
        return 0;
_L13:
        if (!obj.equals(recognitionparameters))
        {
            int j = obj.hashCode();
            int l = recognitionparameters.hashCode();
            if (j < l)
            {
                return -1;
            }
            if (j > l)
            {
                return 1;
            }
        }
        if (true) goto _L14; else goto _L15
_L15:
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

    public Customer getCustomer()
    {
        return mCustomer;
    }

    public Device getDevice()
    {
        return mDevice;
    }

    public ResultFormat getResultFormat()
    {
        return mResultFormat;
    }

    public int hashCode()
    {
        int k = 0;
        int i;
        int j;
        if (getDevice() == null)
        {
            i = 0;
        } else
        {
            i = getDevice().hashCode();
        }
        if (getCustomer() == null)
        {
            j = 0;
        } else
        {
            j = getCustomer().hashCode();
        }
        if (getResultFormat() != null)
        {
            k = getResultFormat().hashCode();
        }
        return 1 + i + j + k;
    }

    public void setCustomer(Customer customer)
    {
        mCustomer = customer;
    }

    public void setDevice(Device device)
    {
        mDevice = device;
    }

    public void setResultFormat(ResultFormat resultformat)
    {
        mResultFormat = resultformat;
    }
}
