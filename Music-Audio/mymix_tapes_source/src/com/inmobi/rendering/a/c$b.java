// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.a;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.inmobi.commons.core.network.NetworkRequest;
import com.inmobi.commons.core.network.e;
import com.inmobi.commons.core.utilities.Logger;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.rendering.a:
//            c, a

static final class a
{

    private work.e.a a;

    static a a(a a1)
    {
        return a1.a;
    }

    public void a(a a1)
    {
        a1.e.set(false);
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable(a1, handler) {

            final a a;
            final Handler b;
            final c.b c;

            public void run()
            {
                (new e(new NetworkRequest(com.inmobi.commons.core.network.NetworkRequest.RequestType.GET, a.b, false, null), new WebViewClient(this) {

                    AtomicBoolean a;
                    boolean b;
                    final _cls1 c;

                    public void onPageFinished(WebView webview, String s)
                    {
                        a.set(true);
                        if (!b && !c.a.e.get())
                        {
                            c.b.a(c.c).a(c.a);
                        }
                    }

                    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
                    {
                        a = new AtomicBoolean(false);
                        b = false;
                        (new Thread(new Runnable(this, webview) {

                            final WebView a;
                            final _cls1 b;

                            public void run()
                            {
                                try
                                {
                                    Thread.sleep(c.f().c() * 1000);
                                }
                                catch (InterruptedException interruptedexception) { }
                                if (!b.a.get())
                                {
                                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, c.d(), (new StringBuilder()).append("Pinging click (").append(b.c.a.a).append(") via WebView timed out!").toString());
                                    b.c.a.e.set(true);
                                    b.c.b.post(new Runnable(this) {

                                        final _cls1 a;

                                        public void run()
                                        {
                                            a.a.stopLoading();
                                        }

            
            {
                a = _pcls1;
                super();
            }
                                    });
                                    c.b.a(b.c.c).a(b.c.a, null);
                                }
                            }

            
            {
                b = _pcls1;
                a = webview;
                super();
            }
                        })).start();
                    }

                    public void onReceivedError(WebView webview, int i, String s, String s1)
                    {
                        b = true;
                        c.b.a(c.c).a(c.a, null);
                    }

                    public void onReceivedError(WebView webview, WebResourceRequest webresourcerequest, WebResourceError webresourceerror)
                    {
                        b = true;
                        c.b.a(c.c).a(c.a, null);
                    }

                    public void onReceivedHttpError(WebView webview, WebResourceRequest webresourcerequest, WebResourceResponse webresourceresponse)
                    {
                        b = true;
                        c.b.a(c.c).a(c.a, null);
                    }

                    public boolean shouldOverrideUrlLoading(WebView webview, String s)
                    {
                        return !c.a.g && !s.equals(c.a.b);
                    }

            
            {
                c = _pcls1;
                super();
            }
                })).a();
            }

            
            {
                c = c.b.this;
                a = a1;
                b = handler;
                super();
            }
        });
    }

    public _cls1.b(_cls1.b b1)
    {
        a = b1;
    }
}
