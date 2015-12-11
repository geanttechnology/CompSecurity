// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.formats.multiwebviews;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import io.presage.ads.NewAd;
import io.presage.for.l;
import io.presage.try.b;
import io.presage.try.d;
import io.presage.try.h;
import io.presage.utils.e;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package io.presage.formats.multiwebviews:
//            e, f, b, c, 
//            d

public class io.presage.formats.multiwebviews.a
    implements android.view.ViewGroup.OnHierarchyChangeListener, io.presage.ads.NewAd.e, io.presage.formats.multiwebviews.do.a, io.presage.formats.multiwebviews.do.b, io.presage.try.a, io.presage.try.d.a, io.presage.try.d.b, io.presage.try.d.c
{
    private static interface a
    {

        public abstract void a();
    }

    private static interface b
    {

        public abstract void a(String s);
    }

    private final class c
    {

        public String a;
        public boolean b;
        public boolean c;
        final io.presage.formats.multiwebviews.a d;

        private c()
        {
            d = io.presage.formats.multiwebviews.a.this;
            super();
            b = false;
            c = false;
        }

        c(byte byte0)
        {
            this();
        }
    }


    private h a;
    private NewAd b;
    private ProgressBar c;
    private boolean d;
    private Map e;
    private BroadcastReceiver f;
    private BroadcastReceiver g;
    private a h;
    private b i;
    private int j;

    public io.presage.formats.multiwebviews.a(NewAd newad, h h1)
    {
        d = false;
        e = new HashMap();
        a = h1;
        b = newad;
        b.setVideoCompletionCallback(this);
        j = h1.getContext().getResources().getConfiguration().orientation;
    }

    static int a(io.presage.formats.multiwebviews.a a1, int k)
    {
        a1.j = k;
        return k;
    }

    static NewAd a(io.presage.formats.multiwebviews.a a1)
    {
        return a1.b;
    }

    static void a(io.presage.formats.multiwebviews.a a1, String s, Object obj)
    {
        a1.a(s, obj);
    }

    private void a(String s, Object obj)
    {
        for (Iterator iterator = (new HashSet(e.keySet())).iterator(); iterator.hasNext(); ((d)iterator.next()).a(s, obj)) { }
    }

    static a b(io.presage.formats.multiwebviews.a a1)
    {
        return a1.h;
    }

    static h c(io.presage.formats.multiwebviews.a a1)
    {
        return a1.a;
    }

    static int d(io.presage.formats.multiwebviews.a a1)
    {
        return a1.j;
    }

    static b e(io.presage.formats.multiwebviews.a a1)
    {
        return a1.i;
    }

    public final String a()
    {
label0:
        {
            if (a == null)
            {
                break label0;
            }
            Iterator iterator = a.b().iterator();
            Object obj;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                obj = (String)iterator.next();
                obj = a.a(((String) (obj)));
            } while (!(obj instanceof io.presage.try.b));
            return ((io.presage.try.b)obj).b().g();
        }
        return null;
    }

    public final void a(WebView webview, String s)
    {
label0:
        {
            if (webview instanceof d)
            {
                io.presage.utils.e.b(new String[] {
                    "URL overrided for webview", ((d)webview).a(), s
                });
                if (e.containsKey(webview))
                {
                    break label0;
                }
                io.presage.utils.e.c(new String[] {
                    "View has been removed. onOverrideUrl skipped.", s
                });
            }
            return;
        }
        c c1 = (c)e.get(webview);
        c1.b = false;
        c1.a = s;
        a("page_load", ((d)webview).a());
    }

    public final void a(io.presage.try.a a1)
    {
        io.presage.utils.e.b(new String[] {
            io/presage/formats/multiwebviews/a.getSimpleName(), "click"
        });
        a("click", a1.a());
    }

    public final void a(d d1, String s)
    {
        if (!e.containsKey(d1))
        {
            io.presage.utils.e.c(new String[] {
                "View has been removed. onLoadUrl skipped.", s
            });
            return;
        } else
        {
            c c1 = (c)e.get(d1);
            c1.b = false;
            c1.a = s;
            a("page_load", d1.a());
            return;
        }
    }

    public final void a(String s)
    {
        if (b != null)
        {
            b.onVideoError(s);
        }
    }

    final String b()
    {
        switch (j)
        {
        default:
            return "unknown";

        case 2: // '\002'
            return "landscape";

        case 1: // '\001'
            return "portrait";
        }
    }

    public final void b(d d1, String s)
    {
        boolean flag1 = false;
        io.presage.utils.e.b(new String[] {
            "Page finished to be loaded.", s
        });
        if (!e.containsKey(d1))
        {
            io.presage.utils.e.c(new String[] {
                "View has been removed. OnPageFinished skipped.", s
            });
            return;
        }
        c c1 = (c)e.get(d1);
        if (!c1.b || c1.b && !c1.a.equals(s))
        {
            c1.b = true;
            c1.a = s;
            if (d1.d())
            {
                if (d)
                {
                    d = false;
                    a.removeView(c);
                }
                boolean flag = flag1;
                if (d1.e())
                {
                    flag = flag1;
                    if (!c1.c)
                    {
                        flag = true;
                    }
                }
                b.onPageFinished(s, flag);
            }
            a("page_finished", d1.a());
        }
        c1.c = true;
    }

    public final void b(String s)
    {
        a("video_prepared", s);
    }

    public final void c()
    {
        if (f == null)
        {
            f = new io.presage.formats.multiwebviews.e(this);
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            intentfilter.addAction("android.intent.action.SCREEN_OFF");
            a.getContext().registerReceiver(f, intentfilter);
        }
        if (g == null)
        {
            g = new f(this);
            a.getContext().registerReceiver(g, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
        }
        a.setOnHierarchyChangeListener(this);
        c = new ProgressBar(a.getContext());
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-2, -2);
        layoutparams.gravity = 17;
        a.addView(c, layoutparams);
        d = true;
        i = new io.presage.formats.multiwebviews.b(this);
        h = new io.presage.formats.multiwebviews.c(this);
        a.a(new io.presage.formats.multiwebviews.d(this));
    }

    public final void c(String s)
    {
        a("video_completed", s);
    }

    public final void d()
    {
        if (f != null)
        {
            try
            {
                a.getContext().unregisterReceiver(f);
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                io.presage.utils.e.c(new String[] {
                    "Broadcast receiver for", "android.intent.action.CLOSE_SYSTEM_DIALOGS", "already unregistered."
                });
            }
            f = null;
        }
        if (g != null)
        {
            try
            {
                a.getContext().unregisterReceiver(g);
            }
            catch (IllegalArgumentException illegalargumentexception1)
            {
                io.presage.utils.e.c(new String[] {
                    "Broadcast closeReceiver for", "android.intent.action.CONFIGURATION_CHANGED", "already unregistered."
                });
            }
            g = null;
        }
        i = null;
        h = null;
        a.a(null);
        if (d)
        {
            d = false;
            a.removeView(c);
        }
        e.clear();
    }

    public void onChildViewAdded(View view, View view1)
    {
        if (a.equals(view))
        {
            if (view1 instanceof d)
            {
                view = (d)view1;
                io.presage.utils.e.b(new String[] {
                    io/presage/formats/multiwebviews/a.getSimpleName(), "ManagedView added", view.a()
                });
                view.a(this);
                view.a(this);
                view.a(this);
                view.a(this);
                e.put(view, new c((byte)0));
                view.addJavascriptInterface(new io.presage.for.b(a), "layout");
                view.addJavascriptInterface(new io.presage.for.a(b), "ad");
                view.addJavascriptInterface(new l(a.getContext()), "sdk");
                return;
            }
            if (view1 instanceof io.presage.try.b)
            {
                view = (io.presage.try.b)view1;
                io.presage.utils.e.b(new String[] {
                    io/presage/formats/multiwebviews/a.getSimpleName(), "ManagedView added", view.a()
                });
                view.b().a(this);
                view.b().a(this);
                view.a(this);
                return;
            }
        }
    }

    public void onChildViewRemoved(View view, View view1)
    {
        if (a.equals(view))
        {
            if (view1 instanceof d)
            {
                view = (d)view1;
                io.presage.utils.e.b(new String[] {
                    io/presage/formats/multiwebviews/a.getSimpleName(), "ManagedView removed", view.a()
                });
                view.a(null);
                view.a(null);
                view.a(null);
                view.a(null);
                e.remove(view);
                return;
            }
            if (view1 instanceof io.presage.try.b)
            {
                view = (io.presage.try.b)view1;
                view.b().a(null);
                view.b().a(null);
                view.a(null);
                return;
            }
        }
    }
}
