// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;

import java.util.Map;

// Referenced classes of package com.amazon.clouddrive.model:
//            BaseSourceInfo, BaseDeviceInfo

public class SourceInfo extends BaseSourceInfo
{

    private BaseDeviceInfo device;
    private Map sourceUsage;

    public SourceInfo()
    {
    }

    public int compareTo(BaseSourceInfo basesourceinfo)
    {
        if (basesourceinfo != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        Object obj;
        Object obj1;
        Map map;
        if (basesourceinfo == this)
        {
            return 0;
        }
        if (!(basesourceinfo instanceof SourceInfo))
        {
            return 1;
        }
        obj = (SourceInfo)basesourceinfo;
        obj1 = getSourceUsage();
        map = ((SourceInfo) (obj)).getSourceUsage();
        if (obj1 == map)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj1 == null)
        {
            return -1;
        }
        if (map == null)
        {
            return 1;
        }
        if (!(obj1 instanceof Comparable)) goto _L4; else goto _L3
_L3:
        int k;
        k = ((Comparable)obj1).compareTo(map);
        i = k;
        if (k != 0) goto _L6; else goto _L5
_L5:
        obj1 = getDevice();
        obj = ((SourceInfo) (obj)).getDevice();
        if (obj1 == obj)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj1 == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (!obj1.equals(map))
        {
            i = obj1.hashCode();
            k = map.hashCode();
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
        if (obj == null)
        {
            return 1;
        }
        if (!(obj1 instanceof Comparable)) goto _L9; else goto _L8
_L8:
        k = ((Comparable)obj1).compareTo(obj);
        i = k;
        if (k != 0) goto _L6; else goto _L10
_L10:
        return super.compareTo(basesourceinfo);
_L9:
        if (!obj1.equals(obj))
        {
            int j = obj1.hashCode();
            int l = obj.hashCode();
            if (j < l)
            {
                return -1;
            }
            if (j > l)
            {
                return 1;
            }
        }
        if (true) goto _L10; else goto _L11
_L11:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((BaseSourceInfo)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof SourceInfo)
            {
                if (compareTo((SourceInfo)obj) != 0)
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

    public BaseDeviceInfo getDevice()
    {
        return device;
    }

    public Map getSourceUsage()
    {
        return sourceUsage;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (getSourceUsage() == null)
        {
            i = 0;
        } else
        {
            i = getSourceUsage().hashCode();
        }
        if (getDevice() != null)
        {
            j = getDevice().hashCode();
        }
        return (1 + i + j) * 31 + super.hashCode();
    }

    public void setDevice(BaseDeviceInfo basedeviceinfo)
    {
        device = basedeviceinfo;
    }

    public void setSourceUsage(Map map)
    {
        sourceUsage = map;
    }
}
