// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import com.mopub.common.logging.MoPubLog;
import java.net.URI;
import org.apache.http.client.methods.HttpUriRequest;

// Referenced classes of package com.mopub.common:
//            HttpClient, DownloadResponse

public class DownloadTask extends AsyncTask
{
    public static interface DownloadTaskListener
    {

        public abstract void onComplete(String s, DownloadResponse downloadresponse);
    }


    private final DownloadTaskListener mDownloadTaskListener;
    private String mUrl;

    public DownloadTask(DownloadTaskListener downloadtasklistener)
        throws IllegalArgumentException
    {
        if (downloadtasklistener == null)
        {
            throw new IllegalArgumentException("DownloadTaskListener must not be null.");
        } else
        {
            mDownloadTaskListener = downloadtasklistener;
            return;
        }
    }

    protected transient DownloadResponse doInBackground(HttpUriRequest ahttpurirequest[])
    {
        if (ahttpurirequest != null && ahttpurirequest.length != 0 && ahttpurirequest[0] != null) goto _L2; else goto _L1
_L1:
        MoPubLog.d("Download task tried to execute null or empty url");
        ahttpurirequest = null;
_L4:
        return ahttpurirequest;
_L2:
        Object obj;
        Object obj1;
        obj1 = ahttpurirequest[0];
        mUrl = ((HttpUriRequest) (obj1)).getURI().toString();
        obj = null;
        ahttpurirequest = null;
        AndroidHttpClient androidhttpclient = HttpClient.getHttpClient();
        ahttpurirequest = androidhttpclient;
        obj = androidhttpclient;
        obj1 = new DownloadResponse(androidhttpclient.execute(((HttpUriRequest) (obj1))));
        ahttpurirequest = ((HttpUriRequest []) (obj1));
        if (androidhttpclient != null)
        {
            androidhttpclient.close();
            return ((DownloadResponse) (obj1));
        }
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        obj = ahttpurirequest;
        MoPubLog.d("Download task threw an internal exception", exception);
        if (ahttpurirequest != null)
        {
            ahttpurirequest.close();
        }
        return null;
        ahttpurirequest;
        if (obj != null)
        {
            ((AndroidHttpClient) (obj)).close();
        }
        throw ahttpurirequest;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((HttpUriRequest[])aobj);
    }

    protected void onCancelled()
    {
        MoPubLog.d("DownloadTask was cancelled.");
    }

    protected void onPostExecute(DownloadResponse downloadresponse)
    {
        if (isCancelled())
        {
            onCancelled();
            return;
        } else
        {
            mDownloadTaskListener.onComplete(mUrl, downloadresponse);
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((DownloadResponse)obj);
    }
}
