// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import com.mopub.common.CacheService;
import com.mopub.common.HttpClient;
import com.mopub.common.logging.MoPubLog;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

public class VastVideoDownloadTask extends AsyncTask
{
    public static interface VastVideoDownloadTaskListener
    {

        public abstract void onComplete(boolean flag);
    }


    private static final int MAX_VIDEO_SIZE = 0x1900000;
    private final VastVideoDownloadTaskListener mVastVideoDownloadTaskListener;

    public VastVideoDownloadTask(VastVideoDownloadTaskListener vastvideodownloadtasklistener)
    {
        mVastVideoDownloadTaskListener = vastvideodownloadtasklistener;
    }

    protected transient Boolean doInBackground(String as[])
    {
        if (as != null && as.length != 0 && as[0] != null) goto _L2; else goto _L1
_L1:
        Object obj = Boolean.valueOf(false);
_L4:
        return ((Boolean) (obj));
_L2:
        String s;
        s = as[0];
        obj = null;
        as = null;
        Object obj1 = HttpClient.getHttpClient();
        as = ((String []) (obj1));
        obj = obj1;
        Object obj2 = ((AndroidHttpClient) (obj1)).execute(HttpClient.initializeHttpGet(s));
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        as = ((String []) (obj1));
        obj = obj1;
        if (((HttpResponse) (obj2)).getEntity() != null)
        {
            break; /* Loop/switch isn't completed */
        }
        as = ((String []) (obj1));
        obj = obj1;
        try
        {
            throw new IOException((new StringBuilder()).append("Obtained null response from video url: ").append(s).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            obj = as;
        }
        finally
        {
            if (obj == null) goto _L0; else goto _L0
        }
        MoPubLog.d((new StringBuilder()).append("Failed to download video: ").append(((Exception) (obj1)).getMessage()).toString());
        obj1 = Boolean.valueOf(false);
        obj = obj1;
        if (as != null)
        {
            as.close();
            return ((Boolean) (obj1));
        }
        if (true) goto _L4; else goto _L3
_L3:
        as = ((String []) (obj1));
        obj = obj1;
        if (((HttpResponse) (obj2)).getEntity().getContentLength() <= 0x1900000L)
        {
            break MISSING_BLOCK_LABEL_194;
        }
        as = ((String []) (obj1));
        obj = obj1;
        throw new IOException("Video exceeded max download size");
        ((AndroidHttpClient) (obj)).close();
        throw as;
        as = ((String []) (obj1));
        obj = obj1;
        obj2 = new BufferedInputStream(((HttpResponse) (obj2)).getEntity().getContent());
        as = ((String []) (obj1));
        obj = obj1;
        boolean flag = CacheService.putToDiskCache(s, ((InputStream) (obj2)));
        as = ((String []) (obj1));
        obj = obj1;
        ((InputStream) (obj2)).close();
        as = Boolean.valueOf(flag);
        obj = as;
        if (obj1 != null)
        {
            ((AndroidHttpClient) (obj1)).close();
            return as;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected void onCancelled()
    {
        onPostExecute(Boolean.valueOf(false));
    }

    protected void onPostExecute(Boolean boolean1)
    {
        if (mVastVideoDownloadTaskListener != null)
        {
            mVastVideoDownloadTaskListener.onComplete(boolean1.booleanValue());
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Boolean)obj);
    }
}
