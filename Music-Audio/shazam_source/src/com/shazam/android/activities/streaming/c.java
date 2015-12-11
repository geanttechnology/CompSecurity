// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.streaming;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.facebook.c.e;
import com.facebook.c.h;
import com.shazam.android.an.a.r;
import com.shazam.android.an.m;
import com.shazam.android.an.n;
import com.shazam.android.an.o;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.factory.StreamingEventFactory;
import com.shazam.android.analytics.session.SessionConfigurable;
import com.shazam.android.analytics.session.page.Page;
import com.shazam.android.analytics.session.page.SimplePageWithName;
import com.shazam.android.base.activities.BaseAppCompatActivity;
import com.shazam.android.fragment.streaming.b;
import com.shazam.android.k.f.ab;
import com.shazam.android.preference.i;
import com.shazam.android.util.s;
import com.shazam.android.widget.c.f;
import com.shazam.i.b.au.d;
import com.shazam.i.b.g.b.a;
import com.shazam.model.analytics.ScreenOrigin;

// Referenced classes of package com.shazam.android.activities.streaming:
//            b, e

public abstract class c extends BaseAppCompatActivity
    implements com.shazam.android.activities.c, r, n, SessionConfigurable
{
    private final class a extends com.facebook.c.c
    {

        final c a;

        private static void a(float f1, View view)
        {
            view.setScaleX(f1);
            view.setScaleY(f1);
        }

        public final void a(com.facebook.c.d d1)
        {
            super.a(d1);
            float f1 = (float)d1.d.a;
            a(f1, a.findViewById(0x7f110112));
            a(f1, a.findViewById(0x7f110116));
        }

        private a()
        {
            a = c.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }


    protected final b a = new com.shazam.android.fragment.streaming.c();
    private final com.shazam.android.an.d c;
    private final s d = com.shazam.i.b.au.d.a();
    private final EventAnalytics e = com.shazam.i.b.g.b.a.a();
    private final h f = com.facebook.c.h.b();
    private final com.facebook.c.d g;
    private final com.shazam.android.activities.streaming.e h = com.shazam.i.b.b.a.a.a();
    private final m i;
    private final f j = com.shazam.i.b.ay.a.a.b();
    private final ab k = com.shazam.i.b.o.c.d.b();
    private final i l = new com.shazam.android.preference.h(com.shazam.i.b.c.a().getResources());
    private com.shazam.android.activities.streaming.b m;
    private String n;
    private ScreenOrigin o;

    protected c(m m1, com.shazam.android.an.d d1)
    {
        g = f.a();
        i = m1;
        c = d1;
    }

    public static Intent a(com.shazam.android.activities.streaming.b b1, Context context, ScreenOrigin screenorigin)
    {
        context = new Intent(context, b1.h);
        context.putExtra("param_streaming_provider", b1);
        context.putExtra("param_screen_origin", screenorigin.value);
        return context;
    }

    public static Intent a(com.shazam.android.activities.streaming.b b1, Context context, ScreenOrigin screenorigin, Uri uri)
    {
        b1 = a(b1, context, screenorigin);
        b1.putExtra("param_post_finish_launching_uri", uri);
        return b1;
    }

    static com.shazam.android.activities.streaming.b a(c c1)
    {
        return c1.m;
    }

    private void a(Uri uri)
    {
        j.a(this, uri);
    }

    static s b(c c1)
    {
        return c1.d;
    }

    private Uri j()
    {
        android.os.Parcelable parcelable = getIntent().getParcelableExtra("param_post_finish_launching_uri");
        if (parcelable != null)
        {
            return (Uri)parcelable;
        } else
        {
            return null;
        }
    }

    private ScreenOrigin k()
    {
        if (o == null)
        {
            o = ScreenOrigin.a(getIntent().getStringExtra("param_screen_origin"));
        }
        return o;
    }

    private void l()
    {
        a(com.shazam.android.k.f.a.a(com.shazam.android.k.f.a.c, new Object[] {
            m.c, k()
        }));
    }

    protected void a()
    {
        runOnUiThread(new Runnable() {

            final c a;

            public final void run()
            {
                String s1 = a.getString(0x7f09012c, new Object[] {
                    a.getString(com.shazam.android.activities.streaming.c.a(a).d)
                });
                s s2 = com.shazam.android.activities.streaming.c.b(a);
                com.shazam.android.util.q.a a1 = new com.shazam.android.util.q.a();
                a1.b = s1;
                a1.c = 1;
                s2.a(a1.a());
            }

            
            {
                a = c.this;
                super();
            }
        });
        finish();
    }

    protected final void a(android.view.View.OnClickListener onclicklistener)
    {
        findViewById(0x7f110114).setOnClickListener(onclicklistener);
    }

    public void b()
    {
        a(com.shazam.android.k.f.a.a(com.shazam.android.k.f.a.b, new Object[] {
            m.c, k()
        }));
    }

    public final void c()
    {
        ScreenOrigin screenorigin = k();
        e.logEvent(StreamingEventFactory.createStreamingLoginEvent(m, com.shazam.android.analytics.event.factory.StreamingEventFactory.StreamingEventAction.SUCCESS, screenorigin, screenorigin, n));
        a.b();
        i.a(this);
        k.a();
    }

    public void configureWith(Page page)
    {
        n = ((SimplePageWithName)page).getPageName();
    }

    public final void d()
    {
        ScreenOrigin screenorigin = k();
        e.logEvent(StreamingEventFactory.createStreamingLoginEvent(m, com.shazam.android.analytics.event.factory.StreamingEventFactory.StreamingEventAction.ERROR, screenorigin, screenorigin, n));
        a();
    }

    public final void e()
    {
        ScreenOrigin screenorigin = k();
        e.logEvent(StreamingEventFactory.createStreamingLoginEvent(m, com.shazam.android.analytics.event.factory.StreamingEventFactory.StreamingEventAction.CANCEL, screenorigin, screenorigin, n));
        finish();
    }

    public final void f()
    {
        c.a(new o(m));
        l();
        finish();
    }

    public void finish()
    {
        if (j() != null)
        {
            j.a(this, j());
        }
        super.finish();
    }

    public final void g()
    {
        l();
        finish();
    }

    public final void h()
    {
        a();
    }

    protected final void i()
    {
        ScreenOrigin screenorigin = k();
        e.logEvent(StreamingEventFactory.createStreamingLoginEvent(m, a.c().c, screenorigin, screenorigin, n));
    }

    public void onBackPressed()
    {
        ScreenOrigin screenorigin = k();
        e.logEvent(StreamingEventFactory.createStreamingLoginEvent(m, com.shazam.android.analytics.event.factory.StreamingEventFactory.StreamingEventAction.BACK, screenorigin, screenorigin, n));
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        com.shazam.android.activities.c.a.a(this);
        setContentView(0x7f03002f);
        bundle = (com.shazam.android.activities.streaming.b)getIntent().getSerializableExtra("param_streaming_provider");
        m = bundle;
        boolean flag;
        if (bundle != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            finish();
        } else
        {
            bundle = h.a();
            a.a(findViewById(0x7f11010e), m);
            g.a(new a((byte)0));
            g.a(new e(100D, 8D));
            g.b(1.0D);
            boolean flag1;
            if (bundle != null && bundle != m)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                l.a(this, bundle, m).show();
                e.logEvent(StreamingEventFactory.createStreamingServicesSwitchImpressionEvent());
                return;
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            onBackPressed();
            break;
        }
        return true;
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        bundle = (com.shazam.android.fragment.streaming.b.a)bundle.getSerializable("indicatorState");
        static final class _cls2
        {

            static final int a[];

            static 
            {
                a = new int[com.shazam.android.fragment.streaming.b.a.values().length];
                try
                {
                    a[com.shazam.android.fragment.streaming.b.a.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (com.shazam.android.activities.streaming._cls2.a[bundle.ordinal()])
        {
        default:
            a.b();
            return;

        case 1: // '\001'
            a.a();
            break;
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("indicatorState", a.c());
    }
}
