// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;

import java.util.Map;

// Referenced classes of package com.amazon.clouddrive.model:
//            SourceStatus

public class BaseSourceInfo
    implements Comparable
{

    private String creationTime;
    private String lastModifiedTime;
    private String lastSeenTime;
    private String sourceApplicationName;
    private String sourceId;
    private SourceStatus sourceStatus;
    private Map sourceVersionHistory;

    public BaseSourceInfo()
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
        if (basesourceinfo == this)
        {
            return 0;
        }
        obj = getSourceStatus();
        obj1 = basesourceinfo.getSourceStatus();
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
        obj = getLastModifiedTime();
        obj1 = basesourceinfo.getLastModifiedTime();
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
        obj = getSourceApplicationName();
        obj1 = basesourceinfo.getSourceApplicationName();
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
        obj = getCreationTime();
        obj1 = basesourceinfo.getCreationTime();
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
        obj = getSourceId();
        obj1 = basesourceinfo.getSourceId();
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
        obj = getSourceVersionHistory();
        obj1 = basesourceinfo.getSourceVersionHistory();
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
        obj = getLastSeenTime();
        basesourceinfo = basesourceinfo.getLastSeenTime();
        if (obj == basesourceinfo)
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
        if (basesourceinfo == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L29; else goto _L28
_L28:
        k = ((Comparable)obj).compareTo(basesourceinfo);
        i = k;
        if (k != 0) goto _L6; else goto _L30
_L30:
        return 0;
_L29:
        if (!obj.equals(basesourceinfo))
        {
            int j = obj.hashCode();
            int l = basesourceinfo.hashCode();
            if (j < l)
            {
                return -1;
            }
            if (j > l)
            {
                return 1;
            }
        }
        if (true) goto _L30; else goto _L31
_L31:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((BaseSourceInfo)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof BaseSourceInfo)
            {
                if (compareTo((BaseSourceInfo)obj) != 0)
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

    public String getLastModifiedTime()
    {
        return lastModifiedTime;
    }

    public String getLastSeenTime()
    {
        return lastSeenTime;
    }

    public String getSourceApplicationName()
    {
        return sourceApplicationName;
    }

    public String getSourceId()
    {
        return sourceId;
    }

    public SourceStatus getSourceStatus()
    {
        return sourceStatus;
    }

    public Map getSourceVersionHistory()
    {
        return sourceVersionHistory;
    }

    public int hashCode()
    {
        int k1 = 0;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        if (getSourceStatus() == null)
        {
            i = 0;
        } else
        {
            i = getSourceStatus().hashCode();
        }
        if (getLastModifiedTime() == null)
        {
            j = 0;
        } else
        {
            j = getLastModifiedTime().hashCode();
        }
        if (getSourceApplicationName() == null)
        {
            k = 0;
        } else
        {
            k = getSourceApplicationName().hashCode();
        }
        if (getCreationTime() == null)
        {
            l = 0;
        } else
        {
            l = getCreationTime().hashCode();
        }
        if (getSourceId() == null)
        {
            i1 = 0;
        } else
        {
            i1 = getSourceId().hashCode();
        }
        if (getSourceVersionHistory() == null)
        {
            j1 = 0;
        } else
        {
            j1 = getSourceVersionHistory().hashCode();
        }
        if (getLastSeenTime() != null)
        {
            k1 = getLastSeenTime().hashCode();
        }
        return 1 + i + j + k + l + i1 + j1 + k1;
    }

    public void setCreationTime(String s)
    {
        creationTime = s;
    }

    public void setLastModifiedTime(String s)
    {
        lastModifiedTime = s;
    }

    public void setLastSeenTime(String s)
    {
        lastSeenTime = s;
    }

    public void setSourceApplicationName(String s)
    {
        sourceApplicationName = s;
    }

    public void setSourceId(String s)
    {
        sourceId = s;
    }

    public void setSourceStatus(SourceStatus sourcestatus)
    {
        sourceStatus = sourcestatus;
    }

    public void setSourceVersionHistory(Map map)
    {
        sourceVersionHistory = map;
    }
}
