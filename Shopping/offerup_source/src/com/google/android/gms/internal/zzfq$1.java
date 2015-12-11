// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.webkit.WebView;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzfq

class zzCt
    implements Runnable
{

    final String zzCs;
    final String zzCt;
    final zzfq zzCu;

    public void run()
    {
        WebView webview = zzCu.zzfh();
        class _cls1 extends WebViewClient
        {

            final zzfq._cls1 zzCv;
            final WebView zzsk;

            public void onPageFinished(WebView webview1, String s)
            {
                zzb.zzaF("Loading assets have finished");
                zzCv.zzCu.zzCr.remove(zzsk);
            }

            public void onReceivedError(WebView webview1, int i, String s, String s1)
            {
                zzb.zzaH("Loading assets have failed.");
                zzCv.zzCu.zzCr.remove(zzsk);
            }

            _cls1(WebView webview)
            {
                zzCv = zzfq._cls1.this;
                zzsk = webview;
                super();
            }
        }

        webview.setWebViewClient(new _cls1(webview));
        zzCu.zzCr.add(webview);
        webview.loadDataWithBaseURL(zzCs, zzCt, "text/html", "UTF-8", null);
        zzb.zzaF("Fetching assets finished.");
    }

    l.client.zzb(zzfq zzfq1, String s, String s1)
    {
        zzCu = zzfq1;
        zzCs = s;
        zzCt = s1;
        super();
    }
}
