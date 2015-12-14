// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.content.cache;

import android.util.Log;
import com.aviary.android.feather.common.utils.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.aviary.android.feather.library.content.cache:
//            DownloadManager

protected class mId
    implements com.aviary.android.feather.common.threading.dJob
{

    WeakReference mDownloadCallbackRef;
    int mId;
    WeakReference mProgressCallbackRef;
    final DownloadManager this$0;

    protected void copyFile(InputStream inputstream, OutputStream outputstream, String s, int i, ogressListener ogresslistener, int j)
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
            if (i > -1 && ogresslistener != null)
            {
                k += l;
                fireOnDownloadProgress(s, k, i, ogresslistener, j);
            }
        } while (true);
    }

    protected InputStream handleStream(String s, InputStream inputstream, int i, ogressListener ogresslistener, int j)
        throws IOException
    {
        if (i > -1 && ogresslistener != null)
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            copyFile(inputstream, bytearrayoutputstream, s, i, ogresslistener, j);
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

    public transient InputStream run(com.aviary.android.feather.common.threading.dJob djob, String as[])
        throws IOException
    {
        Object obj = as[0];
        Log.i("DownloadManager", (new StringBuilder()).append("run: ").append(((String) (obj))).toString());
        djob = (stener)mDownloadCallbackRef.get();
        if (djob != null)
        {
            fireOnDownloadStarted(((String) (obj)), djob, mId);
        }
        djob = new URL(as[0]);
        Log.i("DownloadManager", (new StringBuilder()).append("downloading remote file: ").append(djob.getPath()).toString());
        djob = openConnection(djob);
        int i = djob.getContentLength();
        ogressListener ogresslistener;
        try
        {
            as = djob.getInputStream();
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            djob.disconnect();
            as.printStackTrace();
            throw as;
        }
        ogresslistener = (ogressListener)mProgressCallbackRef.get();
        obj = handleStream(((String) (obj)), as, i, ogresslistener, mId);
        IOUtils.closeSilently(as);
        djob.disconnect();
        return ((InputStream) (obj));
        Object obj1;
        obj1;
        ((IOException) (obj1)).printStackTrace();
        throw obj1;
        obj1;
        IOUtils.closeSilently(as);
        djob.disconnect();
        throw obj1;
    }

    public volatile Object run(com.aviary.android.feather.common.threading.dJob djob, Object aobj[])
        throws Exception
    {
        return run(djob, (String[])aobj);
    }

    public ogressListener(int i, stener stener, ogressListener ogresslistener)
    {
        this$0 = DownloadManager.this;
        super();
        mDownloadCallbackRef = new WeakReference(stener);
        mProgressCallbackRef = new WeakReference(ogresslistener);
        mId = i;
    }
}
