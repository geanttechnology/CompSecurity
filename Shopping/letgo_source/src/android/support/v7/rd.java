// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            rb, tp

public class rd
    implements rb
{

    final Set a = Collections.synchronizedSet(new HashSet());
    private final Context b;

    public rd(Context context)
    {
        b = context;
    }

    public WebView a()
    {
        WebView webview = new WebView(b);
        webview.getSettings().setJavaScriptEnabled(true);
        return webview;
    }

    public void a(String s, String s1, String s2)
    {
        zzb.zzaC("Fetching assets for the given html");
        tp.a.post(new Runnable(s1, s2) {

            final String a;
            final String b;
            final rd c;

            public void run()
            {
                WebView webview = c.a();
                webview.setWebViewClient(new WebViewClient(this, webview) {

                    final WebView a;
                    final _cls1 b;

                    public void onPageFinished(WebView webview, String s)
                    {
                        zzb.zzaC("Loading assets have finished");
                        b.c.a.remove(a);
                    }

                    public void onReceivedError(WebView webview, int i, String s, String s1)
                    {
                        zzb.zzaE("Loading assets have failed.");
                        b.c.a.remove(a);
                    }

            
            {
                b = _pcls1;
                a = webview;
                super();
            }
                });
                c.a.add(webview);
                webview.loadDataWithBaseURL(a, b, "text/html", "UTF-8", null);
                zzb.zzaC("Fetching assets finished.");
            }

            
            {
                c = rd.this;
                a = s;
                b = s1;
                super();
            }
        });
    }
}
