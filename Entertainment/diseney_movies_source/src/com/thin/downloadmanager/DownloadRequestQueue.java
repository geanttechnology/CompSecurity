// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.thin.downloadmanager;

import android.os.Handler;
import android.os.Looper;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.thin.downloadmanager:
//            DownloadDispatcher, DownloadRequest, DownloadStatusListener

public class DownloadRequestQueue
{
    class CallBackDelivery
    {

        private final Executor mCallBackExecutor;
        final DownloadRequestQueue this$0;

        public void postDownloadComplete(DownloadRequest downloadrequest)
        {
            mCallBackExecutor.execute(downloadrequest. new Runnable() {

                final CallBackDelivery this$1;
                final DownloadRequest val$request;

                public void run()
                {
                    request.getDownloadListener().onDownloadComplete(request.getDownloadId());
                }

            
            {
                this$1 = final_callbackdelivery;
                request = DownloadRequest.this;
                super();
            }
            });
        }

        public void postDownloadFailed(final DownloadRequest request, final int errorCode, String s)
        {
            mCallBackExecutor.execute(s. new Runnable() {

                final CallBackDelivery this$1;
                final int val$errorCode;
                final String val$errorMsg;
                final DownloadRequest val$request;

                public void run()
                {
                    request.getDownloadListener().onDownloadFailed(request.getDownloadId(), errorCode, errorMsg);
                }

            
            {
                this$1 = final_callbackdelivery;
                request = downloadrequest;
                errorCode = i;
                errorMsg = String.this;
                super();
            }
            });
        }

        public void postProgressUpdate(final DownloadRequest request, final long totalBytes, final long downloadedBytes, int i)
        {
            mCallBackExecutor.execute(i. new Runnable() {

                final CallBackDelivery this$1;
                final long val$downloadedBytes;
                final int val$progress;
                final DownloadRequest val$request;
                final long val$totalBytes;

                public void run()
                {
                    request.getDownloadListener().onProgress(request.getDownloadId(), totalBytes, downloadedBytes, progress);
                }

            
            {
                this$1 = final_callbackdelivery;
                request = downloadrequest;
                totalBytes = l;
                downloadedBytes = l1;
                progress = I.this;
                super();
            }
            });
        }

        public CallBackDelivery(Handler handler)
        {
            this.this$0 = DownloadRequestQueue.this;
            super();
            mCallBackExecutor = handler. new _cls1();
        }
    }


    private static final int DEFAULT_DOWNLOAD_THREAD_POOL_SIZE = 1;
    private Set mCurrentRequests;
    private CallBackDelivery mDelivery;
    private DownloadDispatcher mDownloadDispatchers[];
    private PriorityBlockingQueue mDownloadQueue;
    private AtomicInteger mSequenceGenerator;

    public DownloadRequestQueue()
    {
        mCurrentRequests = new HashSet();
        mDownloadQueue = new PriorityBlockingQueue();
        mSequenceGenerator = new AtomicInteger();
        mDownloadDispatchers = new DownloadDispatcher[1];
        mDelivery = new CallBackDelivery(new Handler(Looper.getMainLooper()));
    }

    public DownloadRequestQueue(int i)
    {
        mCurrentRequests = new HashSet();
        mDownloadQueue = new PriorityBlockingQueue();
        mSequenceGenerator = new AtomicInteger();
        mDelivery = new CallBackDelivery(new Handler(Looper.getMainLooper()));
        if (i > 0 && i <= 4)
        {
            mDownloadDispatchers = new DownloadDispatcher[i];
            return;
        } else
        {
            mDownloadDispatchers = new DownloadDispatcher[1];
            return;
        }
    }

    private int getDownloadId()
    {
        return mSequenceGenerator.incrementAndGet();
    }

    private void stop()
    {
        for (int i = 0; i < mDownloadDispatchers.length; i++)
        {
            if (mDownloadDispatchers[i] != null)
            {
                mDownloadDispatchers[i].quit();
            }
        }

    }

    int add(DownloadRequest downloadrequest)
    {
        int i = getDownloadId();
        downloadrequest.setDownloadRequestQueue(this);
        synchronized (mCurrentRequests)
        {
            mCurrentRequests.add(downloadrequest);
        }
        downloadrequest.setDownloadId(i);
        mDownloadQueue.add(downloadrequest);
        return i;
        downloadrequest;
        set;
        JVM INSTR monitorexit ;
        throw downloadrequest;
    }

    int cancel(int i)
    {
label0:
        {
            synchronized (mCurrentRequests)
            {
                Iterator iterator = mCurrentRequests.iterator();
                DownloadRequest downloadrequest;
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    downloadrequest = (DownloadRequest)iterator.next();
                } while (downloadrequest.getDownloadId() != i);
                downloadrequest.cancel();
            }
            return 1;
        }
        set;
        JVM INSTR monitorexit ;
        return 0;
        exception;
        set;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void cancelAll()
    {
        Set set = mCurrentRequests;
        set;
        JVM INSTR monitorenter ;
        for (Iterator iterator = mCurrentRequests.iterator(); iterator.hasNext(); ((DownloadRequest)iterator.next()).cancel()) { }
        break MISSING_BLOCK_LABEL_46;
        Exception exception;
        exception;
        set;
        JVM INSTR monitorexit ;
        throw exception;
        mCurrentRequests.clear();
        set;
        JVM INSTR monitorexit ;
    }

    void finish(DownloadRequest downloadrequest)
    {
        if (mCurrentRequests != null)
        {
            synchronized (mCurrentRequests)
            {
                mCurrentRequests.remove(downloadrequest);
            }
            return;
        } else
        {
            return;
        }
        downloadrequest;
        set;
        JVM INSTR monitorexit ;
        throw downloadrequest;
    }

    int query(int i)
    {
label0:
        {
            synchronized (mCurrentRequests)
            {
                Iterator iterator = mCurrentRequests.iterator();
                DownloadRequest downloadrequest;
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    downloadrequest = (DownloadRequest)iterator.next();
                } while (downloadrequest.getDownloadId() != i);
                i = downloadrequest.getDownloadState();
            }
            return i;
        }
        set;
        JVM INSTR monitorexit ;
        return 32;
        exception;
        set;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void release()
    {
        if (mCurrentRequests != null)
        {
            synchronized (mCurrentRequests)
            {
                mCurrentRequests.clear();
                mCurrentRequests = null;
            }
        }
        if (mDownloadQueue != null)
        {
            mDownloadQueue = null;
        }
        if (mDownloadDispatchers == null)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        stop();
        for (int i = 0; i < mDownloadDispatchers.length; i++)
        {
            mDownloadDispatchers[i] = null;
        }

        break MISSING_BLOCK_LABEL_83;
        exception;
        set;
        JVM INSTR monitorexit ;
        throw exception;
        mDownloadDispatchers = null;
    }

    public void start()
    {
        stop();
        for (int i = 0; i < mDownloadDispatchers.length; i++)
        {
            DownloadDispatcher downloaddispatcher = new DownloadDispatcher(mDownloadQueue, mDelivery);
            mDownloadDispatchers[i] = downloaddispatcher;
            downloaddispatcher.start();
        }

    }

    // Unreferenced inner class com/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$1

/* anonymous class */
    class CallBackDelivery._cls1
        implements Executor
    {

        final CallBackDelivery this$1;
        final Handler val$handler;
        final DownloadRequestQueue val$this$0;

        public void execute(Runnable runnable)
        {
            handler.post(runnable);
        }

            
            {
                this$1 = final_callbackdelivery;
                this$0 = downloadrequestqueue;
                handler = Handler.this;
                super();
            }
    }

}
