// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            rd

class b
    implements Runnable
{

    final String a;
    final String b;
    final rd c;

    public void run()
    {
        WebView webview = c.a();
        webview.setWebViewClient(new WebViewClient(webview) {

            final WebView a;
            final rd._cls1 b;

            public void onPageFinished(WebView webview1, String s)
            {
                zzb.zzaC("Loading assets have finished");
                b.c.a.remove(a);
            }

            public void onReceivedError(WebView webview1, int i, String s, String s1)
            {
                zzb.zzaE("Loading assets have failed.");
                b.c.a.remove(a);
            }

            
            {
                b = rd._cls1.this;
                a = webview;
                super();
            }
        });
        c.a.add(webview);
        webview.loadDataWithBaseURL(a, b, "text/html", "UTF-8", null);
        zzb.zzaC("Fetching assets finished.");
    }

    ient(rd rd1, String s, String s1)
    {
        c = rd1;
        a = s;
        b = s1;
        super();
    }
}
