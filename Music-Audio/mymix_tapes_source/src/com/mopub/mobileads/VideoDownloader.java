// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.os.AsyncTask;
import com.mopub.common.CacheService;
import com.mopub.common.MoPubHttpUrlConnection;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.Streams;
import java.io.BufferedInputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class VideoDownloader
{
    static interface VideoDownloaderListener
    {

        public abstract void onComplete(boolean flag);
    }

    static class VideoDownloaderTask extends AsyncTask
    {

        private final VideoDownloaderListener mListener;
        private final WeakReference mWeakSelf = new WeakReference(this);

        protected transient Boolean doInBackground(String as[])
        {
            if (as != null && as.length != 0 && as[0] != null) goto _L2; else goto _L1
_L1:
            MoPubLog.d("VideoDownloader task tried to execute null or empty url.");
            as = Boolean.valueOf(false);
_L4:
            return as;
_L2:
            Object obj1;
            Object obj2;
            Object obj3;
            Object obj4;
            String s;
            s = as[0];
            as = null;
            obj2 = null;
            obj3 = null;
            obj4 = null;
            obj1 = obj3;
            Object obj = MoPubHttpUrlConnection.getHttpUrlConnection(s);
            obj2 = obj;
            obj1 = obj3;
            as = ((String []) (obj));
            obj3 = new BufferedInputStream(((HttpURLConnection) (obj)).getInputStream());
            int i = ((HttpURLConnection) (obj)).getResponseCode();
            if (i >= 200 && i < 300)
            {
                break MISSING_BLOCK_LABEL_140;
            }
            MoPubLog.d((new StringBuilder()).append("VideoDownloader encountered unexpected statusCode: ").append(i).toString());
            obj1 = Boolean.valueOf(false);
            Streams.closeStream(((java.io.Closeable) (obj3)));
            as = ((String []) (obj1));
            if (obj != null)
            {
                ((HttpURLConnection) (obj)).disconnect();
                return ((Boolean) (obj1));
            }
            continue; /* Loop/switch isn't completed */
            i = ((HttpURLConnection) (obj)).getContentLength();
            if (i <= 0x1900000)
            {
                break MISSING_BLOCK_LABEL_203;
            }
            MoPubLog.d(String.format("VideoDownloader encountered video larger than disk cap. (%d bytes / %d maximum).", new Object[] {
                Integer.valueOf(i), Integer.valueOf(0x1900000)
            }));
            obj1 = Boolean.valueOf(false);
            Streams.closeStream(((java.io.Closeable) (obj3)));
            as = ((String []) (obj1));
            if (obj != null)
            {
                ((HttpURLConnection) (obj)).disconnect();
                return ((Boolean) (obj1));
            }
            continue; /* Loop/switch isn't completed */
            boolean flag = CacheService.putToDiskCache(s, ((java.io.InputStream) (obj3)));
            obj1 = Boolean.valueOf(flag);
            Streams.closeStream(((java.io.Closeable) (obj3)));
            as = ((String []) (obj1));
            if (obj != null)
            {
                ((HttpURLConnection) (obj)).disconnect();
                return ((Boolean) (obj1));
            }
            if (true) goto _L4; else goto _L3
_L3:
            obj3;
            obj = obj2;
            obj2 = obj4;
_L8:
            obj1 = obj2;
            as = ((String []) (obj));
            MoPubLog.d("VideoDownloader task threw an internal exception.", ((Throwable) (obj3)));
            obj1 = Boolean.valueOf(false);
            Streams.closeStream(((java.io.Closeable) (obj2)));
            as = ((String []) (obj1));
            if (obj == null) goto _L4; else goto _L5
_L5:
            ((HttpURLConnection) (obj)).disconnect();
            return ((Boolean) (obj1));
            obj;
_L7:
            Streams.closeStream(((java.io.Closeable) (obj1)));
            if (as != null)
            {
                as.disconnect();
            }
            throw obj;
            obj2;
            obj1 = obj3;
            as = ((String []) (obj));
            obj = obj2;
            if (true) goto _L7; else goto _L6
_L6:
            as;
            obj2 = obj3;
            obj3 = as;
              goto _L8
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected void onCancelled()
        {
            MoPubLog.d("VideoDownloader task was cancelled.");
            VideoDownloader.sDownloaderTasks.remove(mWeakSelf);
            mListener.onComplete(false);
        }

        protected void onPostExecute(Boolean boolean1)
        {
            if (isCancelled())
            {
                onCancelled();
                return;
            }
            VideoDownloader.sDownloaderTasks.remove(mWeakSelf);
            if (boolean1 == null)
            {
                mListener.onComplete(false);
                return;
            } else
            {
                mListener.onComplete(boolean1.booleanValue());
                return;
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Boolean)obj);
        }

        VideoDownloaderTask(VideoDownloaderListener videodownloaderlistener)
        {
            mListener = videodownloaderlistener;
            VideoDownloader.sDownloaderTasks.add(mWeakSelf);
        }
    }


    private static final int MAX_VIDEO_SIZE = 0x1900000;
    private static final Deque sDownloaderTasks = new ArrayDeque();

    private VideoDownloader()
    {
    }

    public static void cache(String s, VideoDownloaderListener videodownloaderlistener)
    {
        Preconditions.checkNotNull(videodownloaderlistener);
        if (s == null)
        {
            MoPubLog.d("VideoDownloader attempted to cache video with null url.");
            videodownloaderlistener.onComplete(false);
            return;
        }
        VideoDownloaderTask videodownloadertask = new VideoDownloaderTask(videodownloaderlistener);
        try
        {
            AsyncTasks.safeExecuteOnExecutor(videodownloadertask, new String[] {
                s
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            videodownloaderlistener.onComplete(false);
        }
    }

    public static void cancelAllDownloaderTasks()
    {
        for (Iterator iterator = sDownloaderTasks.iterator(); iterator.hasNext(); cancelOneTask((WeakReference)iterator.next())) { }
        sDownloaderTasks.clear();
    }

    public static void cancelLastDownloadTask()
    {
        if (sDownloaderTasks.isEmpty())
        {
            return;
        } else
        {
            cancelOneTask((WeakReference)sDownloaderTasks.peekLast());
            sDownloaderTasks.removeLast();
            return;
        }
    }

    private static boolean cancelOneTask(WeakReference weakreference)
    {
        if (weakreference != null)
        {
            if ((weakreference = (VideoDownloaderTask)weakreference.get()) != null)
            {
                return weakreference.cancel(true);
            }
        }
        return false;
    }

    public static void clearDownloaderTasks()
    {
        sDownloaderTasks.clear();
    }

    public static Deque getDownloaderTasks()
    {
        return sDownloaderTasks;
    }


}
