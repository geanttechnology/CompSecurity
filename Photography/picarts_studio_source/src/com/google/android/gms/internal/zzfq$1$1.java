// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzfq

class zzsk extends WebViewClient
{

    final zzsk zzCv;
    final WebView zzsk;

    public void onPageFinished(WebView webview, String s)
    {
        zzb.zzaF("Loading assets have finished");
        zzCv.Cu.zzCr.remove(zzsk);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        zzb.zzaH("Loading assets have failed.");
        zzCv.Cu.zzCr.remove(zzsk);
    }

    Ct(Ct ct, WebView webview)
    {
        zzCv = ct;
        zzsk = webview;
        super();
    }

    // Unreferenced inner class com/google/android/gms/internal/zzfq$1

/* anonymous class */
    class zzfq._cls1
        implements Runnable
    {

        final String zzCs;
        final String zzCt;
        final zzfq zzCu;

        public void run()
        {
            WebView webview = zzCu.zzfh();
            webview.setWebViewClient(new zzfq._cls1._cls1(this, webview));
            zzCu.zzCr.add(webview);
            webview.loadDataWithBaseURL(zzCs, zzCt, "text/html", "UTF-8", null);
            zzb.zzaF("Fetching assets finished.");
        }

            
            {
                zzCu = zzfq1;
                zzCs = s;
                zzCt = s1;
                super();
            }
    }

}
