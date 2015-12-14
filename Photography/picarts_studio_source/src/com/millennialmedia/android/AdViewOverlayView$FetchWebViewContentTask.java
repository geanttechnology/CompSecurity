// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.os.AsyncTask;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

// Referenced classes of package com.millennialmedia.android:
//            HttpGetRequest, MMLog, AdViewOverlayView, AdViewOverlayActivity, 
//            MMAdImpl, MMAdImplController

class c extends AsyncTask
{

    private String a;
    private boolean b;
    private WeakReference c;

    private transient String a()
    {
        b = true;
        if (TextUtils.isEmpty(a))
        {
            break MISSING_BLOCK_LABEL_98;
        }
        Object obj = (new HttpGetRequest()).a(a);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        StatusLine statusline = ((HttpResponse) (obj)).getStatusLine();
        if (obj == null || statusline == null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        if (statusline.getStatusCode() == 404)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        obj = ((HttpResponse) (obj)).getEntity();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        obj = HttpGetRequest.a(((HttpEntity) (obj)).getContent());
        b = false;
        return ((String) (obj));
        Exception exception;
        exception;
        MMLog.a("AdViewOverlayView", "Unable to get weboverlay", exception);
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected void onPostExecute(Object obj)
    {
        obj = (String)obj;
        AdViewOverlayView adviewoverlayview = (AdViewOverlayView)c.get();
        if (adviewoverlayview != null)
        {
            if (b)
            {
                AdViewOverlayActivity adviewoverlayactivity = (AdViewOverlayActivity)adviewoverlayview.c.get();
                if (adviewoverlayactivity != null)
                {
                    adviewoverlayactivity.finish();
                } else
                {
                    AdViewOverlayView.a(adviewoverlayview);
                }
            }
            if (obj != null && adviewoverlayview.e != null && adviewoverlayview.e.h != null)
            {
                adviewoverlayview.e.h.a(((String) (obj)), a);
            }
        }
    }

    protected void onPreExecute()
    {
        AdViewOverlayView adviewoverlayview = (AdViewOverlayView)c.get();
        if (adviewoverlayview != null && AdViewOverlayView.c(adviewoverlayview) == null)
        {
            AdViewOverlayView.d(adviewoverlayview);
        }
        super.onPreExecute();
    }

    public (AdViewOverlayView adviewoverlayview, String s)
    {
        a = s;
        c = new WeakReference(adviewoverlayview);
    }
}
