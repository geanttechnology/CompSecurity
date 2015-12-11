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
//            e, w, al, d, 
//            ab, ac

private static final class t> extends AsyncTask
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
        Object obj = (new w()).a(a);
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
        obj = w.a(((HttpEntity) (obj)).getContent());
        b = false;
        return ((String) (obj));
        Exception exception;
        exception;
        al.a("AdViewOverlayView", "Unable to get weboverlay", exception);
        return null;
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (String)obj;
        e e1 = (e)c.get();
        if (e1 != null)
        {
            if (b)
            {
                d d1 = (d)e1.c.get();
                if (d1 != null)
                {
                    d1.a();
                } else
                {
                    com.millennialmedia.android.e.a(e1);
                }
            }
            if (obj != null && e1.h != null && e1.h.l != null)
            {
                e1.h.l.a(((String) (obj)), a);
            }
        }
    }

    protected final void onPreExecute()
    {
        e e1 = (e)c.get();
        if (e1 != null && com.millennialmedia.android.e.c(e1) == null)
        {
            com.millennialmedia.android.e.d(e1);
        }
        super.onPreExecute();
    }

    public (e e1, String s)
    {
        a = s;
        c = new WeakReference(e1);
    }
}
