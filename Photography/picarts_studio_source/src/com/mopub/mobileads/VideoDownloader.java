// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class VideoDownloader
{

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
        if (weakreference == null)
        {
            return false;
        }
        weakreference = (VideoDownloaderTask)weakreference.get();
        if (weakreference == null)
        {
            return false;
        } else
        {
            return weakreference.cancel(true);
        }
    }

    public static void clearDownloaderTasks()
    {
        sDownloaderTasks.clear();
    }

    public static Deque getDownloaderTasks()
    {
        return sDownloaderTasks;
    }



    private class VideoDownloaderListener
    {

        public abstract void onComplete(boolean flag);
    }


    private class VideoDownloaderTask extends AsyncTask
    {

        private final VideoDownloaderListener mListener;
        private final WeakReference mWeakSelf = new WeakReference(this);

        protected transient Boolean doInBackground(String as[])
        {
            String as1[] = null;
            if (as != null && as.length != 0 && as[0] != null) goto _L2; else goto _L1
_L1:
            MoPubLog.d("VideoDownloader task tried to execute null or empty url.");
            as = Boolean.valueOf(false);
_L4:
            return as;
_L2:
            Object obj = as[0];
            as = MoPubHttpUrlConnection.getHttpUrlConnection(((String) (obj)));
            as1 = as;
            as = new BufferedInputStream(as1.getInputStream());
            int i = as1.getResponseCode();
            if (i >= 200 && i < 300)
            {
                break MISSING_BLOCK_LABEL_115;
            }
            MoPubLog.d((new StringBuilder("VideoDownloader encountered unexpected statusCode: ")).append(i).toString());
            obj = Boolean.valueOf(false);
            Streams.closeStream(as);
            as = ((String []) (obj));
            if (as1 != null)
            {
                as1.disconnect();
                return ((Boolean) (obj));
            }
            continue; /* Loop/switch isn't completed */
            i = as1.getContentLength();
            if (i <= 0x1900000)
            {
                break MISSING_BLOCK_LABEL_177;
            }
            MoPubLog.d(String.format("VideoDownloader encountered video larger than disk cap. (%d bytes / %d maximum).", new Object[] {
                Integer.valueOf(i), Integer.valueOf(0x1900000)
            }));
            obj = Boolean.valueOf(false);
            Streams.closeStream(as);
            as = ((String []) (obj));
            if (as1 != null)
            {
                as1.disconnect();
                return ((Boolean) (obj));
            }
            continue; /* Loop/switch isn't completed */
            boolean flag = CacheService.putToDiskCache(((String) (obj)), as);
            obj = Boolean.valueOf(flag);
            Streams.closeStream(as);
            as = ((String []) (obj));
            if (as1 != null)
            {
                as1.disconnect();
                return ((Boolean) (obj));
            }
            if (true) goto _L4; else goto _L3
_L3:
            Object obj1;
            obj1;
            as = null;
_L8:
            MoPubLog.d("VideoDownloader task threw an internal exception.", ((Throwable) (obj1)));
            obj1 = Boolean.valueOf(false);
            Streams.closeStream(as);
            as = ((String []) (obj1));
            if (as1 == null) goto _L4; else goto _L5
_L5:
            as1.disconnect();
            return ((Boolean) (obj1));
            obj1;
            as = null;
            as1 = null;
_L7:
            Streams.closeStream(as);
            if (as1 != null)
            {
                as1.disconnect();
            }
            throw obj1;
            obj1;
            as = null;
            continue; /* Loop/switch isn't completed */
            obj1;
            continue; /* Loop/switch isn't completed */
            obj1;
            if (true) goto _L7; else goto _L6
_L6:
            obj1;
            as = null;
              goto _L8
            obj1;
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

}
