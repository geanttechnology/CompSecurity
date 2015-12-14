// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;

import java.util.Map;

public class SourceStatus
    implements Comparable
{

    private long cacheSize;
    private boolean isDownloading;
    private boolean isUploading;
    private Map uploadStatus;

    public SourceStatus()
    {
    }

    public int compareTo(SourceStatus sourcestatus)
    {
        if (sourcestatus != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        Map map;
        Map map1;
        if (sourcestatus == this)
        {
            return 0;
        }
        map = getUploadStatus();
        map1 = sourcestatus.getUploadStatus();
        if (map == map1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (map == null)
        {
            return -1;
        }
        if (map1 == null)
        {
            return 1;
        }
        if (!(map instanceof Comparable)) goto _L4; else goto _L3
_L3:
        int k;
        k = ((Comparable)map).compareTo(map1);
        i = k;
        if (k != 0) goto _L6; else goto _L5
_L5:
        if (!isIsUploading() && sourcestatus.isIsUploading())
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (!map.equals(map1))
        {
            int j = map.hashCode();
            int l = map1.hashCode();
            if (j < l)
            {
                return -1;
            }
            if (j > l)
            {
                return 1;
            }
        }
        if (true) goto _L5; else goto _L7
_L7:
        if (isIsUploading() && !sourcestatus.isIsUploading())
        {
            return 1;
        }
        if (getCacheSize() < sourcestatus.getCacheSize())
        {
            return -1;
        }
        if (getCacheSize() > sourcestatus.getCacheSize())
        {
            return 1;
        }
        if (!isIsDownloading() && sourcestatus.isIsDownloading())
        {
            return -1;
        }
        return !isIsDownloading() || sourcestatus.isIsDownloading() ? 0 : 1;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((SourceStatus)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof SourceStatus)
            {
                if (compareTo((SourceStatus)obj) != 0)
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

    public long getCacheSize()
    {
        return cacheSize;
    }

    public Map getUploadStatus()
    {
        return uploadStatus;
    }

    public int hashCode()
    {
        int k = 1;
        int i;
        int j;
        int l;
        if (getUploadStatus() == null)
        {
            i = 0;
        } else
        {
            i = getUploadStatus().hashCode();
        }
        if (isIsUploading())
        {
            j = 1;
        } else
        {
            j = 0;
        }
        l = (int)getCacheSize();
        if (!isIsDownloading())
        {
            k = 0;
        }
        return 1 + i + j + l + k;
    }

    public boolean isIsDownloading()
    {
        return isDownloading;
    }

    public boolean isIsUploading()
    {
        return isUploading;
    }

    public void setCacheSize(long l)
    {
        cacheSize = l;
    }

    public void setIsDownloading(boolean flag)
    {
        isDownloading = flag;
    }

    public void setIsUploading(boolean flag)
    {
        isUploading = flag;
    }

    public void setUploadStatus(Map map)
    {
        uploadStatus = map;
    }
}
