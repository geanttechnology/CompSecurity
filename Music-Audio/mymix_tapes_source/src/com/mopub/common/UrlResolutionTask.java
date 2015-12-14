// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.net.Uri;
import android.os.AsyncTask;
import com.mopub.common.util.AsyncTasks;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.mopub.common:
//            UrlAction

public class UrlResolutionTask extends AsyncTask
{
    static interface UrlResolutionListener
    {

        public abstract void onFailure(String s, Throwable throwable);

        public abstract void onSuccess(String s);
    }


    private static final int REDIRECT_LIMIT = 10;
    private final UrlResolutionListener mListener;

    UrlResolutionTask(UrlResolutionListener urlresolutionlistener)
    {
        mListener = urlresolutionlistener;
    }

    private String getRedirectLocation(String s)
        throws IOException
    {
        Object obj;
        obj = new URL(s);
        s = null;
        HttpURLConnection httpurlconnection = (HttpURLConnection)((URL) (obj)).openConnection();
        s = httpurlconnection;
        httpurlconnection.setInstanceFollowRedirects(false);
        s = httpurlconnection;
        int i = httpurlconnection.getResponseCode();
        if (i < 300 || i >= 400) goto _L2; else goto _L1
_L1:
        s = httpurlconnection;
        obj = httpurlconnection.getHeaderField("Location");
        s = ((String) (obj));
        obj = s;
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
            obj = s;
        }
_L4:
        return ((String) (obj));
_L2:
        obj = null;
        if (httpurlconnection == null) goto _L4; else goto _L3
_L3:
        httpurlconnection.disconnect();
        return null;
        Exception exception;
        exception;
        if (s != null)
        {
            s.disconnect();
        }
        throw exception;
    }

    public static void getResolvedUrl(String s, UrlResolutionListener urlresolutionlistener)
    {
        UrlResolutionTask urlresolutiontask = new UrlResolutionTask(urlresolutionlistener);
        try
        {
            AsyncTasks.safeExecuteOnExecutor(urlresolutiontask, new String[] {
                s
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            urlresolutionlistener.onFailure("Failed to resolve url", s);
        }
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient String doInBackground(String as[])
    {
        if (as != null && as.length != 0) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L6:
        return ((String) (obj));
_L2:
        int i;
        obj = null;
        as = as[0];
        i = 0;
_L4:
        if (as == null || i >= 10)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        obj = as;
        if (!UrlAction.OPEN_IN_APP_BROWSER.shouldTryHandlingUrl(Uri.parse(as)))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = as;
        try
        {
            as = getRedirectLocation(as);
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            return null;
        }
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L6; else goto _L5
_L5:
        return ((String) (obj));
    }

    protected void onCancelled()
    {
        super.onCancelled();
        mListener.onFailure("Task for resolving url was cancelled", null);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        if (isCancelled() || s == null)
        {
            onCancelled();
            return;
        } else
        {
            mListener.onSuccess(s);
            return;
        }
    }
}
