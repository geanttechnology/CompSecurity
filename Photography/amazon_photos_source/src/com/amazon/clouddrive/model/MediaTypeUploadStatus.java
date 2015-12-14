// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;


public class MediaTypeUploadStatus
    implements Comparable
{

    private long backlogSize;
    private boolean isAutoSaveActive;
    private long uploadQueueSize;

    public MediaTypeUploadStatus()
    {
    }

    public int compareTo(MediaTypeUploadStatus mediatypeuploadstatus)
    {
        if (mediatypeuploadstatus != null)
        {
            if (mediatypeuploadstatus == this)
            {
                return 0;
            }
            if (getUploadQueueSize() >= mediatypeuploadstatus.getUploadQueueSize())
            {
                if (getUploadQueueSize() > mediatypeuploadstatus.getUploadQueueSize())
                {
                    return 1;
                }
                if (isIsAutoSaveActive() || !mediatypeuploadstatus.isIsAutoSaveActive())
                {
                    if (isIsAutoSaveActive() && !mediatypeuploadstatus.isIsAutoSaveActive())
                    {
                        return 1;
                    }
                    if (getBacklogSize() >= mediatypeuploadstatus.getBacklogSize())
                    {
                        return getBacklogSize() <= mediatypeuploadstatus.getBacklogSize() ? 0 : 1;
                    }
                }
            }
        }
        return -1;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((MediaTypeUploadStatus)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof MediaTypeUploadStatus)
            {
                if (compareTo((MediaTypeUploadStatus)obj) != 0)
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

    public long getBacklogSize()
    {
        return backlogSize;
    }

    public long getUploadQueueSize()
    {
        return uploadQueueSize;
    }

    public int hashCode()
    {
        int j = (int)getUploadQueueSize();
        int i;
        if (isIsAutoSaveActive())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        return 1 + j + i + (int)getBacklogSize();
    }

    public boolean isIsAutoSaveActive()
    {
        return isAutoSaveActive;
    }

    public void setBacklogSize(long l)
    {
        backlogSize = l;
    }

    public void setIsAutoSaveActive(boolean flag)
    {
        isAutoSaveActive = flag;
    }

    public void setUploadQueueSize(long l)
    {
        uploadQueueSize = l;
    }
}
