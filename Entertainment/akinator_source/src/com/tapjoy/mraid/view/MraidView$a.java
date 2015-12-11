// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.view;

import android.os.AsyncTask;
import com.tapjoy.TapjoyHttpURLResponse;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyURLConnection;
import com.tapjoy.mraid.listener.MraidViewListener;

// Referenced classes of package com.tapjoy.mraid.view:
//            MraidView

final class <init> extends AsyncTask
{

    TapjoyHttpURLResponse a;
    TapjoyURLConnection b;
    String c;
    final MraidView d;

    private transient Void a(String as[])
    {
        c = as[0];
        try
        {
            b = new TapjoyURLConnection();
            a = b.getResponseFromURL(c);
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            as.printStackTrace();
        }
        return null;
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected final void onPostExecute(Object obj)
    {
        if (a.statusCode == 0 || a.response == null)
        {
            TapjoyLog.e("MRAIDView", "Connection not properly established");
            if (MraidView.a(d) != null)
            {
                MraidView.a(d).onReceivedError(d, 0, "Connection not properly established", c);
                return;
            }
            break MISSING_BLOCK_LABEL_192;
        }
        try
        {
            if (a.statusCode == 302 && a.redirectURL != null && a.redirectURL.length() > 0)
            {
                TapjoyLog.i("MRAIDView", (new StringBuilder("302 redirectURL detected: ")).append(a.redirectURL).toString());
                d.loadUrlStandard(a.redirectURL);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            TapjoyLog.w("MRAIDView", (new StringBuilder("error in loadURL ")).append(obj).toString());
            ((Exception) (obj)).printStackTrace();
            return;
        }
        d.loadDataWithBaseURL(c, a.response, "text/html", "utf-8", c);
    }

    private wListener(MraidView mraidview)
    {
        d = mraidview;
        super();
    }

    d(MraidView mraidview, byte byte0)
    {
        this(mraidview);
    }
}
