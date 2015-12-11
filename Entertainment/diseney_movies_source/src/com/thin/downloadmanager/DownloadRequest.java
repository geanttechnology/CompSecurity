// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.thin.downloadmanager;

import android.net.Uri;

// Referenced classes of package com.thin.downloadmanager:
//            DownloadRequestQueue, DownloadStatusListener

public class DownloadRequest
    implements Comparable
{
    public static final class Priority extends Enum
    {

        private static final Priority $VALUES[];
        public static final Priority HIGH;
        public static final Priority IMMEDIATE;
        public static final Priority LOW;
        public static final Priority NORMAL;

        public static Priority valueOf(String s)
        {
            return (Priority)Enum.valueOf(com/thin/downloadmanager/DownloadRequest$Priority, s);
        }

        public static Priority[] values()
        {
            return (Priority[])$VALUES.clone();
        }

        static 
        {
            LOW = new Priority("LOW", 0);
            NORMAL = new Priority("NORMAL", 1);
            HIGH = new Priority("HIGH", 2);
            IMMEDIATE = new Priority("IMMEDIATE", 3);
            $VALUES = (new Priority[] {
                LOW, NORMAL, HIGH, IMMEDIATE
            });
        }

        private Priority(String s, int i)
        {
            super(s, i);
        }
    }


    private boolean mCanceled;
    private Uri mDestinationURI;
    private int mDownloadId;
    private DownloadStatusListener mDownloadListener;
    private int mDownloadState;
    private Priority mPriority;
    private DownloadRequestQueue mRequestQueue;
    private Uri mUri;

    public DownloadRequest(Uri uri)
    {
        mCanceled = false;
        mPriority = Priority.NORMAL;
        if (uri == null)
        {
            throw new NullPointerException();
        }
        String s = uri.getScheme();
        if (s == null || !s.equals("http") && !s.equals("https"))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Can only download HTTP/HTTPS URIs: ").append(uri).toString());
        } else
        {
            mDownloadState = 1;
            mUri = uri;
            return;
        }
    }

    public void cancel()
    {
        mCanceled = true;
    }

    public int compareTo(DownloadRequest downloadrequest)
    {
        Priority priority = getPriority();
        Priority priority1 = downloadrequest.getPriority();
        if (priority == priority1)
        {
            return mDownloadId - downloadrequest.mDownloadId;
        } else
        {
            return priority1.ordinal() - priority.ordinal();
        }
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((DownloadRequest)obj);
    }

    void finish()
    {
        mRequestQueue.finish(this);
    }

    public Uri getDestinationURI()
    {
        return mDestinationURI;
    }

    final int getDownloadId()
    {
        return mDownloadId;
    }

    DownloadStatusListener getDownloadListener()
    {
        return mDownloadListener;
    }

    int getDownloadState()
    {
        return mDownloadState;
    }

    public Priority getPriority()
    {
        return mPriority;
    }

    public Uri getUri()
    {
        return mUri;
    }

    public boolean isCanceled()
    {
        return mCanceled;
    }

    public DownloadRequest setDestinationURI(Uri uri)
    {
        mDestinationURI = uri;
        return this;
    }

    final void setDownloadId(int i)
    {
        mDownloadId = i;
    }

    public DownloadRequest setDownloadListener(DownloadStatusListener downloadstatuslistener)
    {
        mDownloadListener = downloadstatuslistener;
        return this;
    }

    void setDownloadRequestQueue(DownloadRequestQueue downloadrequestqueue)
    {
        mRequestQueue = downloadrequestqueue;
    }

    void setDownloadState(int i)
    {
        mDownloadState = i;
    }

    public DownloadRequest setPriority(Priority priority)
    {
        mPriority = priority;
        return this;
    }

    public DownloadRequest setUri(Uri uri)
    {
        mUri = uri;
        return this;
    }
}
