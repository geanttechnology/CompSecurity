// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.thin.downloadmanager;


// Referenced classes of package com.thin.downloadmanager:
//            DownloadManager, DownloadRequestQueue, DownloadRequest

public class ThinDownloadManager
    implements DownloadManager
{

    private DownloadRequestQueue mRequestQueue;

    public ThinDownloadManager()
    {
        mRequestQueue = new DownloadRequestQueue();
        mRequestQueue.start();
    }

    public ThinDownloadManager(int i)
    {
        mRequestQueue = new DownloadRequestQueue(i);
        mRequestQueue.start();
    }

    public int add(DownloadRequest downloadrequest)
        throws IllegalArgumentException
    {
        if (downloadrequest == null)
        {
            throw new IllegalArgumentException("DownloadRequest cannot be null");
        } else
        {
            return mRequestQueue.add(downloadrequest);
        }
    }

    public int cancel(int i)
    {
        return mRequestQueue.cancel(i);
    }

    public void cancelAll()
    {
        mRequestQueue.cancelAll();
    }

    public int query(int i)
    {
        return mRequestQueue.query(i);
    }

    public void release()
    {
        if (mRequestQueue != null)
        {
            mRequestQueue.release();
            mRequestQueue = null;
        }
    }
}
