// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzfo, zzid

public class zzfq
    implements zzfo
{

    private final Context mContext;
    final Set zzCr = Collections.synchronizedSet(new HashSet());

    public zzfq(Context context)
    {
        mContext = context;
    }

    public void zza(String s, String s1, String s2)
    {
        zzb.zzaF("Fetching assets for the given html");
        zzid.zzIE.post(new Runnable(s1, s2) {

            final String zzCs;
            final String zzCt;
            final zzfq zzCu;

            public void run()
            {
                WebView webview = zzCu.zzfh();
                webview.setWebViewClient(new WebViewClient(this, webview) {

                    final _cls1 zzCv;
                    final WebView zzsk;

                    public void onPageFinished(WebView webview, String s)
                    {
                        zzb.zzaF("Loading assets have finished");
                        zzCv.zzCu.zzCr.remove(zzsk);
                    }

                    public void onReceivedError(WebView webview, int i, String s, String s1)
                    {
                        zzb.zzaH("Loading assets have failed.");
                        zzCv.zzCu.zzCr.remove(zzsk);
                    }

            
            {
                zzCv = _pcls1;
                zzsk = webview;
                super();
            }
                });
                zzCu.zzCr.add(webview);
                webview.loadDataWithBaseURL(zzCs, zzCt, "text/html", "UTF-8", null);
                zzb.zzaF("Fetching assets finished.");
            }

            
            {
                zzCu = zzfq.this;
                zzCs = s;
                zzCt = s1;
                super();
            }
        });
    }

    public WebView zzfh()
    {
        WebView webview = new WebView(mContext);
        webview.getSettings().setJavaScriptEnabled(true);
        return webview;
    }
}
