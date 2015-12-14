// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;

import java.util.Map;

public class BaseDeviceInfo
    implements Comparable
{

    private String creationTime;
    private String deviceClass;
    private String deviceFriendlyName;
    private String deviceId;
    private String deviceModel;
    private String devicePlatform;
    private String deviceStatus;
    private String lastModifiedTime;
    private Map osVersionHistory;

    public BaseDeviceInfo()
    {
    }

    public int compareTo(BaseDeviceInfo basedeviceinfo)
    {
        if (basedeviceinfo != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        Object obj;
        Object obj1;
        if (basedeviceinfo == this)
        {
            return 0;
        }
        obj = getDeviceModel();
        obj1 = basedeviceinfo.getDeviceModel();
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
        obj = getCreationTime();
        obj1 = basedeviceinfo.getCreationTime();
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
        obj = getDeviceId();
        obj1 = basedeviceinfo.getDeviceId();
        if (obj == obj1)
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
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L13; else goto _L12
_L12:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L14
_L14:
        obj = getDeviceStatus();
        obj1 = basedeviceinfo.getDeviceStatus();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L13:
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
        if (true) goto _L14; else goto _L15
_L15:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L17; else goto _L16
_L16:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L18
_L18:
        obj = getDevicePlatform();
        obj1 = basedeviceinfo.getDevicePlatform();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L17:
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
        if (true) goto _L18; else goto _L19
_L19:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L21; else goto _L20
_L20:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L22
_L22:
        obj = getDeviceClass();
        obj1 = basedeviceinfo.getDeviceClass();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L21:
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
        if (true) goto _L22; else goto _L23
_L23:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L25; else goto _L24
_L24:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L26
_L26:
        obj = getOsVersionHistory();
        obj1 = basedeviceinfo.getOsVersionHistory();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L25:
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
        if (true) goto _L26; else goto _L27
_L27:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L29; else goto _L28
_L28:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L30
_L30:
        obj = getDeviceFriendlyName();
        obj1 = basedeviceinfo.getDeviceFriendlyName();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L29:
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
        if (true) goto _L30; else goto _L31
_L31:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L33; else goto _L32
_L32:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L34
_L34:
        obj = getLastModifiedTime();
        basedeviceinfo = basedeviceinfo.getLastModifiedTime();
        if (obj == basedeviceinfo)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L33:
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
        if (true) goto _L34; else goto _L35
_L35:
        if (basedeviceinfo == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L37; else goto _L36
_L36:
        k = ((Comparable)obj).compareTo(basedeviceinfo);
        i = k;
        if (k != 0) goto _L6; else goto _L38
_L38:
        return 0;
_L37:
        if (!obj.equals(basedeviceinfo))
        {
            int j = obj.hashCode();
            int l = basedeviceinfo.hashCode();
            if (j < l)
            {
                return -1;
            }
            if (j > l)
            {
                return 1;
            }
        }
        if (true) goto _L38; else goto _L39
_L39:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((BaseDeviceInfo)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof BaseDeviceInfo)
            {
                if (compareTo((BaseDeviceInfo)obj) != 0)
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

    public String getCreationTime()
    {
        return creationTime;
    }

    public String getDeviceClass()
    {
        return deviceClass;
    }

    public String getDeviceFriendlyName()
    {
        return deviceFriendlyName;
    }

    public String getDeviceId()
    {
        return deviceId;
    }

    public String getDeviceModel()
    {
        return deviceModel;
    }

    public String getDevicePlatform()
    {
        return devicePlatform;
    }

    public String getDeviceStatus()
    {
        return deviceStatus;
    }

    public String getLastModifiedTime()
    {
        return lastModifiedTime;
    }

    public Map getOsVersionHistory()
    {
        return osVersionHistory;
    }

    public int hashCode()
    {
        int i2 = 0;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        if (getDeviceModel() == null)
        {
            i = 0;
        } else
        {
            i = getDeviceModel().hashCode();
        }
        if (getCreationTime() == null)
        {
            j = 0;
        } else
        {
            j = getCreationTime().hashCode();
        }
        if (getDeviceId() == null)
        {
            k = 0;
        } else
        {
            k = getDeviceId().hashCode();
        }
        if (getDeviceStatus() == null)
        {
            l = 0;
        } else
        {
            l = getDeviceStatus().hashCode();
        }
        if (getDevicePlatform() == null)
        {
            i1 = 0;
        } else
        {
            i1 = getDevicePlatform().hashCode();
        }
        if (getDeviceClass() == null)
        {
            j1 = 0;
        } else
        {
            j1 = getDeviceClass().hashCode();
        }
        if (getOsVersionHistory() == null)
        {
            k1 = 0;
        } else
        {
            k1 = getOsVersionHistory().hashCode();
        }
        if (getDeviceFriendlyName() == null)
        {
            l1 = 0;
        } else
        {
            l1 = getDeviceFriendlyName().hashCode();
        }
        if (getLastModifiedTime() != null)
        {
            i2 = getLastModifiedTime().hashCode();
        }
        return 1 + i + j + k + l + i1 + j1 + k1 + l1 + i2;
    }

    public void setCreationTime(String s)
    {
        creationTime = s;
    }

    public void setDeviceClass(String s)
    {
        deviceClass = s;
    }

    public void setDeviceFriendlyName(String s)
    {
        deviceFriendlyName = s;
    }

    public void setDeviceId(String s)
    {
        deviceId = s;
    }

    public void setDeviceModel(String s)
    {
        deviceModel = s;
    }

    public void setDevicePlatform(String s)
    {
        devicePlatform = s;
    }

    public void setDeviceStatus(String s)
    {
        deviceStatus = s;
    }

    public void setLastModifiedTime(String s)
    {
        lastModifiedTime = s;
    }

    public void setOsVersionHistory(Map map)
    {
        osVersionHistory = map;
    }
}
