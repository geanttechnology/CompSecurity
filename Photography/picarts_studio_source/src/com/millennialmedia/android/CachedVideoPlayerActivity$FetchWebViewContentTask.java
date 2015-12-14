// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.os.AsyncTask;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

// Referenced classes of package com.millennialmedia.android:
//            HttpGetRequest, MMLog, CachedVideoPlayerActivity, MMWebView, 
//            MRaid, MMSDK

class a extends AsyncTask
{

    private String a;
    private boolean b;
    private CachedVideoPlayerActivity c;

    private transient String a()
    {
        Object obj;
        StatusLine statusline;
        obj = (new HttpGetRequest()).a(a);
        statusline = ((HttpResponse) (obj)).getStatusLine();
        if (obj == null || statusline == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        if (statusline.getStatusCode() == 404)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        obj = ((HttpResponse) (obj)).getEntity();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        return HttpGetRequest.a(((HttpEntity) (obj)).getContent());
        b = true;
_L2:
        return null;
        Exception exception;
        exception;
        MMLog.a("CachedVideoPlayerActivity", "Error with http web overlay", exception);
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected void onPostExecute(Object obj)
    {
        String s = (String)obj;
        if (b)
        {
            c.l();
        }
        if (s != null && CachedVideoPlayerActivity.a(c) != null)
        {
            MMWebView mmwebview = CachedVideoPlayerActivity.a(c);
            String s1 = a;
            obj = c.b;
            if (s != null && s1 != null)
            {
                String s2 = s1.substring(0, s1.lastIndexOf("/") + 1);
                mmwebview.d();
                if (MRaid.a(((android.content.Context) (obj))))
                {
                    obj = MRaid.a(((android.content.Context) (obj)), s);
                } else
                {
                    MMLog.e("MMWebView", "MMJS is not downloaded");
                    obj = s;
                }
                if (MMSDK.a >= 5)
                {
                    MMLog.a("MMWebView", String.format("Received ad with base url %s.", new Object[] {
                        s1
                    }));
                    MMLog.a("MMWebView", s);
                }
                MMSDK.a(new c(mmwebview, s2, ((String) (obj))));
            }
            c.a = true;
        }
    }

    public (CachedVideoPlayerActivity cachedvideoplayeractivity, String s)
    {
        c = cachedvideoplayeractivity;
        super();
        a = s;
    }
}
