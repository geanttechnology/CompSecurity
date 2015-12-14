// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.a;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.inmobi.ads.b;
import com.inmobi.commons.core.configs.a;
import com.inmobi.commons.core.network.NetworkError;
import com.inmobi.commons.core.network.NetworkRequest;
import com.inmobi.commons.core.network.e;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.rendering.a:
//            b, a

public final class com.inmobi.rendering.a.c
    implements com.inmobi.commons.core.configs.b.b
{
    final class a extends Handler
    {

        final com.inmobi.rendering.a.c a;

        private void a(com.inmobi.rendering.a.a a1)
        {
            Message message = Message.obtain();
            int i1;
            if (a1.f)
            {
                i1 = 3;
            } else
            {
                i1 = 2;
            }
            message.what = i1;
            message.obj = a1;
            sendMessage(message);
        }

        static void a(a a1, com.inmobi.rendering.a.a a2)
        {
            a1.c(a2);
        }

        private void b(com.inmobi.rendering.a.a a1)
        {
            Message message = Message.obtain();
            message.what = 5;
            message.obj = a1;
            sendMessage(message);
        }

        static void b(a a1, com.inmobi.rendering.a.a a2)
        {
            a1.d(a2);
        }

        private void c(com.inmobi.rendering.a.a a1)
        {
            Message message = Message.obtain();
            message.what = 4;
            message.obj = a1;
            sendMessage(message);
        }

        private void d(com.inmobi.rendering.a.a a1)
        {
            int i1 = com.inmobi.rendering.a.c.g().indexOf(a1);
            Message message;
            if (i1 == com.inmobi.rendering.a.c.g().size() - 1)
            {
                i1 = 0;
            } else
            {
                i1++;
            }
            a1 = (com.inmobi.rendering.a.a)com.inmobi.rendering.a.c.g().get(i1);
            message = Message.obtain();
            if (a1.f)
            {
                i1 = 3;
            } else
            {
                i1 = 2;
            }
            message.what = i1;
            message.obj = a1;
            if (System.currentTimeMillis() - a1.c < (long)(com.inmobi.rendering.a.c.f().b() * 1000))
            {
                sendMessageDelayed(message, com.inmobi.rendering.a.c.f().b() * 1000);
                return;
            } else
            {
                sendMessage(message);
                return;
            }
        }

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                return;

            case 1: // '\001'
                com.inmobi.rendering.a.c.a(com.inmobi.rendering.a.c.e().a(com.inmobi.rendering.a.c.f().e(), com.inmobi.rendering.a.c.f().b()));
                if (com.inmobi.rendering.a.c.g().isEmpty())
                {
                    if (com.inmobi.rendering.a.c.e().a())
                    {
                        com.inmobi.rendering.a.c.h().set(false);
                        return;
                    } else
                    {
                        message = Message.obtain();
                        message.what = 1;
                        sendMessageDelayed(message, com.inmobi.rendering.a.c.f().b() * 1000);
                        return;
                    }
                }
                message = (com.inmobi.rendering.a.a)com.inmobi.rendering.a.c.g().get(0);
                Message message1 = Message.obtain();
                int i1;
                long l1;
                if (((com.inmobi.rendering.a.a) (message)).f)
                {
                    i1 = 3;
                } else
                {
                    i1 = 2;
                }
                message1.what = i1;
                message1.obj = message;
                l1 = System.currentTimeMillis() - ((com.inmobi.rendering.a.a) (message)).c;
                if (l1 < (long)(com.inmobi.rendering.a.c.f().b() * 1000))
                {
                    sendMessageDelayed(message1, (long)(com.inmobi.rendering.a.c.f().b() * 1000) - l1);
                    return;
                } else
                {
                    sendMessage(message1);
                    return;
                }

            case 2: // '\002'
                if (!com.inmobi.commons.core.utilities.d.a())
                {
                    com.inmobi.rendering.a.c.h().set(false);
                    a.c();
                    return;
                }
                message = (com.inmobi.rendering.a.a)message.obj;
                if (((com.inmobi.rendering.a.a) (message)).d == 0)
                {
                    b(message);
                    return;
                }
                int j1 = (com.inmobi.rendering.a.c.f().a() - ((com.inmobi.rendering.a.a) (message)).d) + 1;
                if (j1 == 0)
                {
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.rendering.a.c.d(), (new StringBuilder()).append("Pinging click (").append(((com.inmobi.rendering.a.a) (message)).a).append(") over HTTP").toString());
                } else
                {
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.rendering.a.c.d(), (new StringBuilder()).append("Retry attempt #").append(j1).append(" for click (").append(((com.inmobi.rendering.a.a) (message)).a).append(") over HTTP").toString());
                }
                (new c(new d(this) {

                    final a a;

                    public void a(com.inmobi.rendering.a.a a1)
                    {
                        com.inmobi.rendering.a.a.a(a, a1);
                    }

                    public void a(com.inmobi.rendering.a.a a1, com.inmobi.commons.core.network.NetworkError.ErrorCode errorcode)
                    {
                        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.rendering.a.c.d(), (new StringBuilder()).append("Pinging click (").append(a1.a).append(") via HTTP failed ...").toString());
                        com.inmobi.rendering.a.c.a(a.a, a1);
                        com.inmobi.rendering.a.a.b(a, a1);
                    }

            
            {
                a = a1;
                super();
            }
                })).a(message);
                return;

            case 3: // '\003'
                if (!com.inmobi.commons.core.utilities.d.a())
                {
                    com.inmobi.rendering.a.c.h().set(false);
                    a.c();
                    return;
                }
                message = (com.inmobi.rendering.a.a)message.obj;
                if (((com.inmobi.rendering.a.a) (message)).d == 0)
                {
                    b(message);
                    return;
                }
                int k1 = (com.inmobi.rendering.a.c.f().a() - ((com.inmobi.rendering.a.a) (message)).d) + 1;
                if (k1 == 0)
                {
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.rendering.a.c.d(), (new StringBuilder()).append("Pinging click (").append(((com.inmobi.rendering.a.a) (message)).a).append(") in WebView").toString());
                } else
                {
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.rendering.a.c.d(), (new StringBuilder()).append("Retry attempt #").append(k1).append(" for click (").append(((com.inmobi.rendering.a.a) (message)).a).append(") using WebView").toString());
                }
                (new b(new d(this) {

                    final a a;

                    public void a(com.inmobi.rendering.a.a a1)
                    {
                        com.inmobi.rendering.a.a.a(a, a1);
                    }

                    public void a(com.inmobi.rendering.a.a a1, com.inmobi.commons.core.network.NetworkError.ErrorCode errorcode)
                    {
                        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.rendering.a.c.d(), (new StringBuilder()).append("Pinging click (").append(a1.a).append(") via WebView failed ...").toString());
                        com.inmobi.rendering.a.c.a(a.a, a1);
                        com.inmobi.rendering.a.a.b(a, a1);
                    }

            
            {
                a = a1;
                super();
            }
                })).a(message);
                return;

            case 5: // '\005'
                com.inmobi.rendering.a.a a1 = (com.inmobi.rendering.a.a)message.obj;
                HashMap hashmap = new HashMap();
                hashmap.put("pingUrl", a1.b);
                hashmap.put("errorCode", "MaxRetryCountReached");
                com.inmobi.commons.core.c.a.a().a("ads", "PingDiscarded", hashmap);
                // fall through

            case 4: // '\004'
                message = (com.inmobi.rendering.a.a)message.obj;
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.rendering.a.c.d(), (new StringBuilder()).append("Processing click (").append(((com.inmobi.rendering.a.a) (message)).a).append(") completed").toString());
                com.inmobi.rendering.a.c.e().b(message);
                com.inmobi.rendering.a.c.g().remove(message);
                break;
            }
            if (com.inmobi.rendering.a.c.g().isEmpty())
            {
                if (com.inmobi.rendering.a.c.e().a())
                {
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.rendering.a.c.d(), "Done processing all clicks!");
                    com.inmobi.rendering.a.c.h().set(false);
                    return;
                } else
                {
                    message = Message.obtain();
                    message.what = 1;
                    sendMessage(message);
                    return;
                }
            } else
            {
                a((com.inmobi.rendering.a.a)com.inmobi.rendering.a.c.g().get(0));
                return;
            }
        }

        public a(Looper looper)
        {
            a = com.inmobi.rendering.a.c.this;
            super(looper);
        }
    }

    static final class b
    {

        private d a;

        static d a(b b1)
        {
            return b1.a;
        }

        public void a(com.inmobi.rendering.a.a a1)
        {
            a1.e.set(false);
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable(this, a1, handler) {

                final com.inmobi.rendering.a.a a;
                final Handler b;
                final b c;

                public void run()
                {
                    (new e(new NetworkRequest(com.inmobi.commons.core.network.NetworkRequest.RequestType.GET, a.b, false, null), new WebViewClient(this) {

                        AtomicBoolean a;
                        boolean b;
                        final b._cls1 c;

                        public void onPageFinished(WebView webview, String s)
                        {
                            a.set(true);
                            if (!b && !c.a.e.get())
                            {
                                com.inmobi.rendering.a.b.a(c.c).a(c.a);
                            }
                        }

                        public void onPageStarted(WebView webview, String s, Bitmap bitmap)
                        {
                            a = new AtomicBoolean(false);
                            b = false;
                            (new Thread(new Runnable(this, webview) {

                                final WebView a;
                                final b._cls1._cls1 b;

                                public void run()
                                {
                                    try
                                    {
                                        Thread.sleep(com.inmobi.rendering.a.c.f().c() * 1000);
                                    }
                                    catch (InterruptedException interruptedexception) { }
                                    if (!b.a.get())
                                    {
                                        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.rendering.a.c.d(), (new StringBuilder()).append("Pinging click (").append(b.c.a.a).append(") via WebView timed out!").toString());
                                        b.c.a.e.set(true);
                                        b.c.b.post(new Runnable(this) {

                                            final b._cls1._cls1._cls1 a;

                                            public void run()
                                            {
                                                a.a.stopLoading();
                                            }

            
            {
                a = _pcls1;
                super();
            }
                                        });
                                        com.inmobi.rendering.a.b.a(b.c.c).a(b.c.a, null);
                                    }
                                }

            
            {
                b = _pcls1;
                a = webview;
                super();
            }
                            })).start();
                        }

                        public void onReceivedError(WebView webview, int i1, String s, String s1)
                        {
                            b = true;
                            com.inmobi.rendering.a.b.a(c.c).a(c.a, null);
                        }

                        public void onReceivedError(WebView webview, WebResourceRequest webresourcerequest, WebResourceError webresourceerror)
                        {
                            b = true;
                            com.inmobi.rendering.a.b.a(c.c).a(c.a, null);
                        }

                        public void onReceivedHttpError(WebView webview, WebResourceRequest webresourcerequest, WebResourceResponse webresourceresponse)
                        {
                            b = true;
                            com.inmobi.rendering.a.b.a(c.c).a(c.a, null);
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
                c = b1;
                a = a1;
                b = handler;
                super();
            }
            });
        }

        public b(d d1)
        {
            a = d1;
        }
    }

    static final class c
    {

        private d a;

        public void a(com.inmobi.rendering.a.a a1)
        {
            Object obj = new NetworkRequest(com.inmobi.commons.core.network.NetworkRequest.RequestType.GET, a1.b, false, null);
            ((NetworkRequest) (obj)).a(false);
            ((NetworkRequest) (obj)).b(a1.g);
            ((NetworkRequest) (obj)).b(com.inmobi.rendering.a.c.f().c() * 1000);
            ((NetworkRequest) (obj)).c(com.inmobi.rendering.a.c.f().c() * 1000);
            obj = (new com.inmobi.commons.core.network.d(((NetworkRequest) (obj)))).a();
            if (((com.inmobi.commons.core.network.c) (obj)).a())
            {
                com.inmobi.commons.core.network.NetworkError.ErrorCode errorcode = ((com.inmobi.commons.core.network.c) (obj)).c().a();
                if (!a1.g && (com.inmobi.commons.core.network.NetworkError.ErrorCode.HTTP_SEE_OTHER == errorcode || com.inmobi.commons.core.network.NetworkError.ErrorCode.HTTP_MOVED_TEMP == errorcode))
                {
                    a.a(a1);
                    return;
                } else
                {
                    a.a(a1, ((com.inmobi.commons.core.network.c) (obj)).c().a());
                    return;
                }
            } else
            {
                a.a(a1);
                return;
            }
        }

        public c(d d1)
        {
            a = d1;
        }
    }

    static interface d
    {

        public abstract void a(com.inmobi.rendering.a.a a1);

        public abstract void a(com.inmobi.rendering.a.a a1, com.inmobi.commons.core.network.NetworkError.ErrorCode errorcode);
    }


    private static final String a = com/inmobi/rendering/a/c.getSimpleName();
    private static com.inmobi.rendering.a.c b;
    private static final Object c = new Object();
    private static ExecutorService d;
    private static a e;
    private static HandlerThread f;
    private static List g = new ArrayList();
    private static com.inmobi.rendering.a.b h;
    private static AtomicBoolean i = new AtomicBoolean(false);
    private static com.inmobi.ads.b.b j;
    private static final Object k = new Object();
    private final d l = new d() {

        final com.inmobi.rendering.a.c a;

        public void a(com.inmobi.rendering.a.a a1)
        {
            if (a1 != null)
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.rendering.a.c.d(), (new StringBuilder()).append("Processing click (").append(a1.a).append(") completed").toString());
                com.inmobi.rendering.a.c.e().b(a1);
            }
        }

        public void a(com.inmobi.rendering.a.a a1, com.inmobi.commons.core.network.NetworkError.ErrorCode errorcode)
        {
            if (a1 != null)
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.rendering.a.c.d(), (new StringBuilder()).append("Pinging click (").append(a1.a).append(") failed! Updating retry counts and timestamps ...").toString());
                com.inmobi.rendering.a.c.a(a, a1);
                a.b();
            }
        }

            
            {
                a = com.inmobi.rendering.a.c.this;
                super();
            }
    };

    private com.inmobi.rendering.a.c()
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Creating a new instance ...");
        d = Executors.newFixedThreadPool(5);
        f = new HandlerThread("pingHandlerThread");
        f.start();
        e = new a(f.getLooper());
        com.inmobi.ads.b b1 = new com.inmobi.ads.b();
        com.inmobi.commons.core.configs.b.a().a(b1, this);
        j = b1.i();
        h = new com.inmobi.rendering.a.b();
        com.inmobi.commons.core.utilities.c.a().a(new com.inmobi.commons.core.utilities.a() {

            final com.inmobi.rendering.a.c a;

            public void a(boolean flag)
            {
                if (flag)
                {
                    a.b();
                }
            }

            
            {
                a = com.inmobi.rendering.a.c.this;
                super();
            }
        });
    }

    static d a(com.inmobi.rendering.a.c c1)
    {
        return c1.l;
    }

    public static com.inmobi.rendering.a.c a()
    {
        Object obj;
        obj = b;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        Object obj1 = c;
        obj1;
        JVM INSTR monitorenter ;
        com.inmobi.rendering.a.c c1 = b;
        obj = c1;
        if (c1 != null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        obj = new com.inmobi.rendering.a.c();
        b = ((com.inmobi.rendering.a.c) (obj));
        obj1;
        JVM INSTR monitorexit ;
        return ((com.inmobi.rendering.a.c) (obj));
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        return ((com.inmobi.rendering.a.c) (obj));
    }

    static List a(List list)
    {
        g = list;
        return list;
    }

    private void a(com.inmobi.rendering.a.a a1)
    {
        if (a1.d > 0)
        {
            a1.d = a1.d - 1;
            a1.c = System.currentTimeMillis();
            h.a(a1);
        }
    }

    static void a(com.inmobi.rendering.a.c c1, com.inmobi.rendering.a.a a1)
    {
        c1.a(a1);
    }

    private void b(com.inmobi.rendering.a.a a1)
    {
        h.a(a1, j.d());
        if (!com.inmobi.commons.core.utilities.d.a())
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "No network available. Saving click for later processing ...");
            i.set(false);
            c();
            return;
        } else
        {
            d.submit(new Runnable(a1) {

                final com.inmobi.rendering.a.a a;
                final com.inmobi.rendering.a.c b;

                public void run()
                {
                    if (a.f)
                    {
                        (new b(com.inmobi.rendering.a.c.a(b))).a(a);
                        return;
                    } else
                    {
                        (new c(com.inmobi.rendering.a.c.a(b))).a(a);
                        return;
                    }
                }

            
            {
                b = com.inmobi.rendering.a.c.this;
                a = a1;
                super();
            }
            });
            return;
        }
    }

    static String d()
    {
        return a;
    }

    static com.inmobi.rendering.a.b e()
    {
        return h;
    }

    static com.inmobi.ads.b.b f()
    {
        return j;
    }

    static List g()
    {
        return g;
    }

    static AtomicBoolean h()
    {
        return i;
    }

    public void a(com.inmobi.commons.core.configs.a a1)
    {
        j = ((com.inmobi.ads.b)a1).i();
    }

    public void a(String s, boolean flag)
    {
        s = new com.inmobi.rendering.a.a(s, flag, false, j.a() + 1);
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Received click (").append(((com.inmobi.rendering.a.a) (s)).a).append(") for pinging over HTTP").toString());
        b(s);
    }

    public void b()
    {
        if (!com.inmobi.commons.core.utilities.d.a())
        {
            return;
        }
        Object obj = k;
        obj;
        JVM INSTR monitorenter ;
        if (i.compareAndSet(false, true))
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Resume processing clicks ...");
            if (f == null)
            {
                f = new HandlerThread("pingHandlerThread");
                f.start();
            }
            if (e == null)
            {
                e = new a(f.getLooper());
            }
            if (!h.a())
            {
                break MISSING_BLOCK_LABEL_122;
            }
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Done processing all clicks!");
            i.set(false);
            c();
        }
_L1:
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        Message message = Message.obtain();
        message.what = 1;
        e.sendMessage(message);
          goto _L1
    }

    public void b(String s, boolean flag)
    {
        s = new com.inmobi.rendering.a.a(s, flag, true, j.a() + 1);
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Received click (").append(((com.inmobi.rendering.a.a) (s)).a).append(") for pinging in WebView").toString());
        b(((com.inmobi.rendering.a.a) (s)));
    }

    public void c()
    {
        i.set(false);
        synchronized (k)
        {
            if (!i.get())
            {
                if (f != null)
                {
                    f.getLooper().quit();
                    f.interrupt();
                    f = null;
                    e = null;
                }
                g.clear();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
