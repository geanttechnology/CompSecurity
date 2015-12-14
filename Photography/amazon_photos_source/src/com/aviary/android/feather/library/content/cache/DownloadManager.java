// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.content.cache;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.aviary.android.feather.common.threading.Future;
import com.aviary.android.feather.common.threading.FutureListener;
import com.aviary.android.feather.common.threading.ThreadPool;
import com.aviary.android.feather.common.utils.IDisposable;
import com.aviary.android.feather.common.utils.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class DownloadManager
    implements IDisposable
{
    protected class DownloadJob
        implements com.aviary.android.feather.common.threading.ThreadPool.Job
    {

        WeakReference mDownloadCallbackRef;
        int mId;
        WeakReference mProgressCallbackRef;
        final DownloadManager this$0;

        protected void copyFile(InputStream inputstream, OutputStream outputstream, String s, int i, OnDownloadProgressListener ondownloadprogresslistener, int j)
            throws IOException
        {
            byte abyte0[] = new byte[4096];
            int k = 0;
            do
            {
                int l = inputstream.read(abyte0);
                if (l == -1)
                {
                    break;
                }
                outputstream.write(abyte0, 0, l);
                if (i > -1 && ondownloadprogresslistener != null)
                {
                    k += l;
                    fireOnDownloadProgress(s, k, i, ondownloadprogresslistener, j);
                }
            } while (true);
        }

        protected InputStream handleStream(String s, InputStream inputstream, int i, OnDownloadProgressListener ondownloadprogresslistener, int j)
            throws IOException
        {
            if (i > -1 && ondownloadprogresslistener != null)
            {
                ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
                copyFile(inputstream, bytearrayoutputstream, s, i, ondownloadprogresslistener, j);
                bytearrayoutputstream.flush();
                return new ByteArrayInputStream(bytearrayoutputstream.toByteArray());
            } else
            {
                return IOUtils.fromStream(inputstream);
            }
        }

        protected HttpURLConnection openConnection(URL url)
            throws IOException
        {
            url = (HttpURLConnection)url.openConnection();
            url.setDoInput(true);
            url.setUseCaches(false);
            url.setDefaultUseCaches(false);
            url.setConnectTimeout(2000);
            return url;
        }

        public transient InputStream run(com.aviary.android.feather.common.threading.ThreadPool.Worker worker, String as[])
            throws IOException
        {
            Object obj = as[0];
            Log.i("DownloadManager", (new StringBuilder()).append("run: ").append(((String) (obj))).toString());
            worker = (OnDownloadListener)mDownloadCallbackRef.get();
            if (worker != null)
            {
                fireOnDownloadStarted(((String) (obj)), worker, mId);
            }
            worker = new URL(as[0]);
            Log.i("DownloadManager", (new StringBuilder()).append("downloading remote file: ").append(worker.getPath()).toString());
            worker = openConnection(worker);
            int i = worker.getContentLength();
            OnDownloadProgressListener ondownloadprogresslistener;
            try
            {
                as = worker.getInputStream();
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                worker.disconnect();
                as.printStackTrace();
                throw as;
            }
            ondownloadprogresslistener = (OnDownloadProgressListener)mProgressCallbackRef.get();
            obj = handleStream(((String) (obj)), as, i, ondownloadprogresslistener, mId);
            IOUtils.closeSilently(as);
            worker.disconnect();
            return ((InputStream) (obj));
            Object obj1;
            obj1;
            ((IOException) (obj1)).printStackTrace();
            throw obj1;
            obj1;
            IOUtils.closeSilently(as);
            worker.disconnect();
            throw obj1;
        }

        public volatile Object run(com.aviary.android.feather.common.threading.ThreadPool.Worker worker, Object aobj[])
            throws Exception
        {
            return run(worker, (String[])aobj);
        }

        public DownloadJob(int i, OnDownloadListener ondownloadlistener, OnDownloadProgressListener ondownloadprogresslistener)
        {
            this$0 = DownloadManager.this;
            super();
            mDownloadCallbackRef = new WeakReference(ondownloadlistener);
            mProgressCallbackRef = new WeakReference(ondownloadprogresslistener);
            mId = i;
        }
    }

    public static interface OnDownloadListener
    {

        public abstract void onDownloadComplete(String s, int i, InputStream inputstream);

        public abstract void onDownloadError(String s, int i, Throwable throwable);

        public abstract void onDownloadStarted(String s, int i);
    }

    public static interface OnDownloadProgressListener
    {

        public abstract void onDownloadProgress(String s, int i, int j, int k);
    }


    protected static final String LOG_TAG = "DownloadManager";
    Context context;
    boolean disposed;
    protected final Handler handler;
    ThreadPool threadPool;

    public DownloadManager(Context context1, int i)
    {
        context = context1;
        handler = new Handler(context1.getMainLooper());
        threadPool = new ThreadPool(3, 10);
    }

    public static InputStream download(String s, List list)
        throws IOException
    {
        DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
        s = new HttpPost(s);
        if (list != null)
        {
            s.setEntity(new UrlEncodedFormEntity(list));
        }
        byte abyte0[];
        try
        {
            list = defaulthttpclient.execute(s).getEntity();
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            list.printStackTrace();
            s.abort();
            throw list;
        }
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        abyte0 = EntityUtils.toByteArray(list);
        list.consumeContent();
        return new ByteArrayInputStream(abyte0);
        throw new IOException("null response");
    }

    protected transient DownloadJob createDownloadJob(int i, OnDownloadListener ondownloadlistener, OnDownloadProgressListener ondownloadprogresslistener, long al[])
    {
        return new DownloadJob(i, ondownloadlistener, ondownloadprogresslistener);
    }

    public void dispose()
    {
        Log.i("DownloadManager", "dispose");
        if (!disposed)
        {
            threadPool.dispose();
        }
        disposed = true;
    }

    public transient void download(final String file, final int id, final OnDownloadListener downloadCallback, OnDownloadProgressListener ondownloadprogresslistener, long al[])
    {
        if (disposed)
        {
            return;
        } else
        {
            FutureListener futurelistener = new FutureListener() {

                final DownloadManager this$0;
                final OnDownloadListener val$downloadCallback;
                final String val$file;
                final int val$id;

                public void onFutureDone(Future future)
                {
                    handleResult(future, file, downloadCallback, id);
                }

            
            {
                this$0 = DownloadManager.this;
                file = s;
                downloadCallback = ondownloadlistener;
                id = i;
                super();
            }
            };
            threadPool.submit(createDownloadJob(id, downloadCallback, ondownloadprogresslistener, al), futurelistener, new String[] {
                file
            });
            return;
        }
    }

    protected void fireOnDownloadCompleted(String s, InputStream inputstream, OnDownloadListener ondownloadlistener, int i)
    {
        if (!disposed)
        {
            Log.i("DownloadManager", (new StringBuilder()).append("fireOnDownloadCompleted: ").append(s).toString());
            ondownloadlistener.onDownloadComplete(s, i, inputstream);
        }
    }

    protected void fireOnDownloadError(String s, Throwable throwable, OnDownloadListener ondownloadlistener, int i)
    {
        if (!disposed)
        {
            ondownloadlistener.onDownloadError(s, i, throwable);
        }
    }

    protected void fireOnDownloadProgress(String s, int i, int j, OnDownloadProgressListener ondownloadprogresslistener, int k)
    {
        if (!disposed)
        {
            ondownloadprogresslistener.onDownloadProgress(s, k, i, j);
        }
    }

    protected void fireOnDownloadStarted(String s, OnDownloadListener ondownloadlistener, int i)
    {
        if (!disposed)
        {
            ondownloadlistener.onDownloadStarted(s, i);
        }
    }

    protected void handleResult(Future future, String s, OnDownloadListener ondownloadlistener, int i)
    {
        if (future == null) goto _L2; else goto _L1
_L1:
        if (!future.hasException()) goto _L4; else goto _L3
_L3:
        if (ondownloadlistener != null)
        {
            fireOnDownloadError(s, future.getException(), ondownloadlistener, i);
        }
_L6:
        return;
_L4:
        future = (InputStream)future.get();
        if (future != null)
        {
            if (ondownloadlistener != null)
            {
                fireOnDownloadCompleted(s, future, ondownloadlistener, i);
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
_L2:
        if (ondownloadlistener != null)
        {
            fireOnDownloadError(s, null, ondownloadlistener, i);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }
}
