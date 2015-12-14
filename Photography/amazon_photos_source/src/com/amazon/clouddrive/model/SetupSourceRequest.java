// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;


// Referenced classes of package com.amazon.clouddrive.model:
//            PaginatedCloudDriveRequest, CloudDriveRequest

public class SetupSourceRequest extends PaginatedCloudDriveRequest
{

    private String deviceClass;
    private String deviceFriendlyName;
    private String deviceModel;
    private String devicePlatform;
    private String deviceSerialNumber;
    private String osVersion;
    private String sourceApplicationName;
    private String sourceVersion;

    public SetupSourceRequest(String s, String s1, String s2, String s3)
    {
        sourceApplicationName = s;
        sourceVersion = s1;
        deviceClass = s2;
        devicePlatform = s3;
    }

    public int compareTo(CloudDriveRequest clouddriverequest)
    {
        if (clouddriverequest != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        Object obj;
        String s;
        String s1;
        if (clouddriverequest == this)
        {
            return 0;
        }
        if (!(clouddriverequest instanceof SetupSourceRequest))
        {
            return 1;
        }
        obj = (SetupSourceRequest)clouddriverequest;
        s = getSourceVersion();
        s1 = ((SetupSourceRequest) (obj)).getSourceVersion();
        if (s == s1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s == null)
        {
            return -1;
        }
        if (s1 == null)
        {
            return 1;
        }
        if (!(s instanceof Comparable)) goto _L4; else goto _L3
_L3:
        int k;
        k = ((Comparable)s).compareTo(s1);
        i = k;
        if (k != 0) goto _L6; else goto _L5
_L5:
        s = getDeviceFriendlyName();
        s1 = ((SetupSourceRequest) (obj)).getDeviceFriendlyName();
        if (s == s1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (!s.equals(s1))
        {
            i = s.hashCode();
            k = s1.hashCode();
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
        if (s1 == null)
        {
            return 1;
        }
        if (!(s instanceof Comparable)) goto _L9; else goto _L8
_L8:
        k = ((Comparable)s).compareTo(s1);
        i = k;
        if (k != 0) goto _L6; else goto _L10
_L10:
        s = getDeviceSerialNumber();
        s1 = ((SetupSourceRequest) (obj)).getDeviceSerialNumber();
        if (s == s1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L9:
        if (!s.equals(s1))
        {
            i = s.hashCode();
            k = s1.hashCode();
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
        if (s1 == null)
        {
            return 1;
        }
        if (!(s instanceof Comparable)) goto _L13; else goto _L12
_L12:
        k = ((Comparable)s).compareTo(s1);
        i = k;
        if (k != 0) goto _L6; else goto _L14
_L14:
        s = getOsVersion();
        s1 = ((SetupSourceRequest) (obj)).getOsVersion();
        if (s == s1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L13:
        if (!s.equals(s1))
        {
            i = s.hashCode();
            k = s1.hashCode();
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
        if (s1 == null)
        {
            return 1;
        }
        if (!(s instanceof Comparable)) goto _L17; else goto _L16
_L16:
        k = ((Comparable)s).compareTo(s1);
        i = k;
        if (k != 0) goto _L6; else goto _L18
_L18:
        s = getDeviceModel();
        s1 = ((SetupSourceRequest) (obj)).getDeviceModel();
        if (s == s1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L17:
        if (!s.equals(s1))
        {
            i = s.hashCode();
            k = s1.hashCode();
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
        if (s1 == null)
        {
            return 1;
        }
        if (!(s instanceof Comparable)) goto _L21; else goto _L20
_L20:
        k = ((Comparable)s).compareTo(s1);
        i = k;
        if (k != 0) goto _L6; else goto _L22
_L22:
        s = getDeviceClass();
        s1 = ((SetupSourceRequest) (obj)).getDeviceClass();
        if (s == s1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L21:
        if (!s.equals(s1))
        {
            i = s.hashCode();
            k = s1.hashCode();
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
        if (s1 == null)
        {
            return 1;
        }
        if (!(s instanceof Comparable)) goto _L25; else goto _L24
_L24:
        k = ((Comparable)s).compareTo(s1);
        i = k;
        if (k != 0) goto _L6; else goto _L26
_L26:
        s = getDevicePlatform();
        s1 = ((SetupSourceRequest) (obj)).getDevicePlatform();
        if (s == s1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L25:
        if (!s.equals(s1))
        {
            i = s.hashCode();
            k = s1.hashCode();
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
        if (s1 == null)
        {
            return 1;
        }
        if (!(s instanceof Comparable)) goto _L29; else goto _L28
_L28:
        k = ((Comparable)s).compareTo(s1);
        i = k;
        if (k != 0) goto _L6; else goto _L30
_L30:
        s = getSourceApplicationName();
        obj = ((SetupSourceRequest) (obj)).getSourceApplicationName();
        if (s == obj)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L29:
        if (!s.equals(s1))
        {
            i = s.hashCode();
            k = s1.hashCode();
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
        if (obj == null)
        {
            return 1;
        }
        if (!(s instanceof Comparable)) goto _L33; else goto _L32
_L32:
        k = ((Comparable)s).compareTo(obj);
        i = k;
        if (k != 0) goto _L6; else goto _L34
_L34:
        return super.compareTo(clouddriverequest);
_L33:
        if (!s.equals(obj))
        {
            int j = s.hashCode();
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
        if (true) goto _L34; else goto _L35
_L35:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((CloudDriveRequest)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof SetupSourceRequest)
            {
                if (compareTo((SetupSourceRequest)obj) != 0)
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

    public String getDeviceClass()
    {
        return deviceClass;
    }

    public String getDeviceFriendlyName()
    {
        return deviceFriendlyName;
    }

    public String getDeviceModel()
    {
        return deviceModel;
    }

    public String getDevicePlatform()
    {
        return devicePlatform;
    }

    public String getDeviceSerialNumber()
    {
        return deviceSerialNumber;
    }

    public String getOsVersion()
    {
        return osVersion;
    }

    public String getSourceApplicationName()
    {
        return sourceApplicationName;
    }

    public String getSourceVersion()
    {
        return sourceVersion;
    }

    public int hashCode()
    {
        int l1 = 0;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        if (getSourceVersion() == null)
        {
            i = 0;
        } else
        {
            i = getSourceVersion().hashCode();
        }
        if (getDeviceFriendlyName() == null)
        {
            j = 0;
        } else
        {
            j = getDeviceFriendlyName().hashCode();
        }
        if (getDeviceSerialNumber() == null)
        {
            k = 0;
        } else
        {
            k = getDeviceSerialNumber().hashCode();
        }
        if (getOsVersion() == null)
        {
            l = 0;
        } else
        {
            l = getOsVersion().hashCode();
        }
        if (getDeviceModel() == null)
        {
            i1 = 0;
        } else
        {
            i1 = getDeviceModel().hashCode();
        }
        if (getDeviceClass() == null)
        {
            j1 = 0;
        } else
        {
            j1 = getDeviceClass().hashCode();
        }
        if (getDevicePlatform() == null)
        {
            k1 = 0;
        } else
        {
            k1 = getDevicePlatform().hashCode();
        }
        if (getSourceApplicationName() != null)
        {
            l1 = getSourceApplicationName().hashCode();
        }
        return (1 + i + j + k + l + i1 + j1 + k1 + l1) * 31 + super.hashCode();
    }

    public void setDeviceFriendlyName(String s)
    {
        deviceFriendlyName = s;
    }

    public void setDeviceModel(String s)
    {
        deviceModel = s;
    }

    public void setDeviceSerialNumber(String s)
    {
        deviceSerialNumber = s;
    }

    public void setOsVersion(String s)
    {
        osVersion = s;
    }
}
