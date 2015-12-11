// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import java.util.List;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            u, ay, v, aw, 
//            ad, n, au, a

public class AdViewManager
{
    public static interface Listener
    {

        public abstract void onAdComplete(AdViewManager adviewmanager);
    }

    class a
        implements a.a
    {

        final AdViewManager a;
        private Context b;

        public int a(aw aw1)
        {
            return a(aw1, -1);
        }

        public int a(aw aw1, int k)
        {
            return a(aw1, k, null);
        }

        public int a(aw aw1, int k, List list)
        {
            int l = -1;
            if (aw1 != null)
            {
                ad.d((new StringBuilder()).append("Starting Event: ").append(ad.D()).append("ms ").append(aw1.a().toString()).append(" ").append(aw1.h()).append(" ").append(aw1.c()).toString());
                k = AdViewManager.b(a).a(aw1, k, null, null);
                l = k;
                if (aw1.g())
                {
                    AdViewManager.a(a, k);
                    l = k;
                }
            }
            return l;
        }

        public void a(int k)
        {
            if (k != -1)
            {
                AdViewManager.b(a).a(k);
                ay.a a1 = AdViewManager.b(a).b(k);
                aw aw1 = a1.c;
                ad.d((new StringBuilder()).append("Ending Event: ").append(a1.e).append("ms ").append(aw1.a().toString()).append(" ").append(aw1.h()).append(" ").append(aw1.c()).toString());
                if (!aw1.g())
                {
                    AdViewManager.a(a, k);
                }
            }
        }

        public void a(com.tremorvideo.sdk.android.videoad.a a1)
        {
            ad.d(" ");
            ad.d("<<< Ad End");
            ad.d(" ");
            ad.A().h();
            AdViewManager.a(a);
        }

        public void b(int k)
        {
        }

        public n g()
        {
            return a.c;
        }

        public Context h()
        {
            return b;
        }

        public int i()
        {
            return 0;
        }

        public int j()
        {
            return -1;
        }

        public a(Context context, ay ay1)
        {
            a = AdViewManager.this;
            super();
            b = context;
            AdViewManager.a(AdViewManager.this, ay1);
        }
    }


    public static final int ACTIVITY_REQUEST_CODE = 11;
    ViewGroup a;
    v b;
    u c;
    Activity d;
    a.a e;
    Listener f;
    private ay g;

    public AdViewManager(Activity activity, ViewGroup viewgroup, n n)
    {
        c = null;
        if (n != null)
        {
            c = (u)n;
        }
        g = new ay();
        d = activity;
        a = viewgroup;
        e = new a(activity, g);
        b = new v(activity, e, c, viewgroup.getWidth());
        b.a();
        viewgroup.addView(b);
    }

    static ay a(AdViewManager adviewmanager, ay ay1)
    {
        adviewmanager.g = ay1;
        return ay1;
    }

    private void a()
    {
        a.removeView(b);
        b = null;
        e = null;
        if (f != null)
        {
            d.runOnUiThread(new Runnable() {

                final AdViewManager a;

                public void run()
                {
                    a.f.onAdComplete(a);
                }

            
            {
                a = AdViewManager.this;
                super();
            }
            });
        }
    }

    private void a(int i)
    {
label0:
        {
            ay.a a1 = g.b(i);
            if (a1 != null)
            {
                if (a1.c.c().equals("-1"))
                {
                    break label0;
                }
                a1.c.a(a1);
            }
            return;
        }
        ad.d("Event had ID of -1: not fired");
    }

    static void a(AdViewManager adviewmanager)
    {
        adviewmanager.a();
    }

    static void a(AdViewManager adviewmanager, int i)
    {
        adviewmanager.a(i);
    }

    static ay b(AdViewManager adviewmanager)
    {
        return adviewmanager.g;
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 11)
        {
            b.a(i);
        }
    }

    public void onResume()
    {
        b.d();
    }

    public void onScreenOff()
    {
        b.e();
    }

    public void onScreenOn()
    {
        b.f();
    }

    public void onStop()
    {
        b.c();
    }

    public void setListener(Listener listener)
    {
        f = listener;
    }
}
