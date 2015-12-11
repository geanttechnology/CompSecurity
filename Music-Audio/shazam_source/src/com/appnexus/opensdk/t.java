// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.appnexus.opensdk.b.b;
import com.appnexus.opensdk.b.l;
import java.lang.ref.WeakReference;
import java.util.Queue;

// Referenced classes of package com.appnexus.opensdk:
//            v, u, m, AdActivity, 
//            d

final class t
    implements AdActivity.a
{
    static final class a extends Handler
    {

        WeakReference a;

        public final void handleMessage(Message message)
        {
            t t1 = (t)a.get();
            if (message.what == 8000 && t1 != null)
            {
                t1.f();
            }
        }

        public a(t t1)
        {
            a = new WeakReference(t1);
        }
    }


    Activity a;
    v b;
    private m c;
    private FrameLayout d;
    private long e;
    private ImageButton f;

    public t(Activity activity)
    {
        a = activity;
    }

    private void a(v v1)
    {
        b = v1;
        if (b != null)
        {
            b.setAdImplementation(this);
            d.setBackgroundColor(b.getBackgroundColor());
            d.removeAllViews();
            if (b.getParent() != null)
            {
                ((ViewGroup)b.getParent()).removeAllViews();
            }
            do
            {
                v1 = (u)b.getAdQueue().poll();
                if (v1 == null || e - v1.a() <= 0x41eb0L && e - v1.a() >= 0L)
                {
                    break;
                }
                com.appnexus.opensdk.b.b.d(b.b, com.appnexus.opensdk.b.b.a(an.d.too_old));
            } while (true);
            if (v1 != null && (v1.b() instanceof m))
            {
                c = (m)v1.b();
                AdActivity.a(a, c.j);
                d.addView(c);
                return;
            }
        }
    }

    public final void a()
    {
        d = new FrameLayout(a);
        a.setContentView(d);
        e = a.getIntent().getLongExtra("TIME", System.currentTimeMillis());
        a(v.q);
        int i = a.getIntent().getIntExtra("CLOSE_BUTTON_DELAY", 10000);
        (new a(this)).sendEmptyMessageDelayed(8000, i);
    }

    public final void b()
    {
    }

    public final void c()
    {
        if (c != null)
        {
            l.a(c);
            c.destroy();
        }
        if (b != null)
        {
            b.setAdImplementation(null);
        }
    }

    public final void d()
    {
        f();
    }

    public final WebView e()
    {
        return c;
    }

    final void f()
    {
        if (d == null || f != null)
        {
            return;
        } else
        {
            f = l.a(a, false);
            f.setOnClickListener(new android.view.View.OnClickListener() {

                final t a;

                public final void onClick(View view)
                {
                    if (a.a != null)
                    {
                        if (a.b != null && a.b.getAdDispatcher() != null)
                        {
                            a.b.getAdDispatcher().b();
                        }
                        a.a.finish();
                    }
                }

            
            {
                a = t.this;
                super();
            }
            });
            d.addView(f);
            return;
        }
    }
}
