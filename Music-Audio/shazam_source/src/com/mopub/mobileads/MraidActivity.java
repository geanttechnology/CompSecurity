// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.mopub.b.c;
import com.mopub.b.i;
import com.mopub.b.j;
import com.mopub.common.c.a;
import com.mopub.common.d.o;
import com.mopub.common.g;
import com.mopub.common.m;

// Referenced classes of package com.mopub.mobileads:
//            g, o

public class MraidActivity extends com.mopub.mobileads.g
{

    private c d;
    private i e;

    public MraidActivity()
    {
    }

    static c a(MraidActivity mraidactivity)
    {
        return mraidactivity.d;
    }

    public final View a()
    {
        String s = getIntent().getStringExtra("Html-Response-Body");
        if (s == null)
        {
            com.mopub.common.c.a.d("MraidActivity received a null HTML body. Finishing the activity.");
            finish();
            return new View(this);
        }
        d = new c(this, a, j.b);
        d.j = e;
        d.h = new com.mopub.b.c.a() {

            final MraidActivity a;

            public final void a()
            {
                com.mopub.mobileads.MraidActivity.a(a).b(com.mopub.mobileads.g.a.a.c);
            }

            public final void b()
            {
                com.mopub.common.c.a.b("MraidActivity failed to load. Finishing the activity");
                com.mopub.mobileads.o.a(a, ((com.mopub.mobileads.g) (a)).c.longValue(), "com.mopub.action.interstitial.fail");
                a.finish();
            }

            public final void c()
            {
                com.mopub.mobileads.MraidActivity.a(a).b(g.a.b.c);
                a.finish();
            }

            public final void d()
            {
                com.mopub.mobileads.o.a(a, ((com.mopub.mobileads.g) (a)).c.longValue(), "com.mopub.action.interstitial.click");
            }

            
            {
                a = MraidActivity.this;
                super();
            }
        };
        d.i = new com.mopub.b.c.d() {

            final MraidActivity a;

            public final void a(boolean flag1)
            {
                if (flag1)
                {
                    ((com.mopub.mobileads.g) (a)).b.setCloseVisible(false);
                    return;
                } else
                {
                    ((com.mopub.mobileads.g) (a)).b.setCloseVisible(true);
                    return;
                }
            }

            
            {
                a = MraidActivity.this;
                super();
            }
        };
        Object obj = d;
        boolean flag;
        if (((c) (obj)).k == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        m.a(flag, "loadContent should only be called once", new Object[] {
            ""
        });
        obj.k = new com.mopub.b.a.b(((c) (obj)).a);
        ((c) (obj)).m.a(((c) (obj)).k);
        ((c) (obj)).c.addView(((c) (obj)).k, new android.widget.FrameLayout.LayoutParams(-1, -1));
        obj = ((c) (obj)).m;
        if (((com.mopub.b.a) (obj)).b == null)
        {
            com.mopub.common.c.a.b("MRAID bridge called setContentHtml before WebView was attached");
        } else
        {
            obj.d = false;
            ((com.mopub.b.a) (obj)).b.loadDataWithBaseURL("http://ads.mopub.com/", s, "text/html", "UTF-8", null);
        }
        return d.c;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        com.mopub.mobileads.o.a(this, super.c.longValue(), "com.mopub.action.interstitial.show");
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            getWindow().setFlags(0x1000000, 0x1000000);
        }
    }

    protected void onDestroy()
    {
        if (d != null)
        {
            c c1 = d;
            c1.e.a();
            try
            {
                com.mopub.b.c.b b = c1.o;
                if (b.a != null)
                {
                    b.a.unregisterReceiver(b);
                    b.a = null;
                }
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                if (!illegalargumentexception.getMessage().contains("Receiver not registered"))
                {
                    throw illegalargumentexception;
                }
            }
            if (!c1.p)
            {
                c1.a(true);
            }
            o.a(c1.d);
            c1.m.b = null;
            if (c1.k != null)
            {
                c1.k.destroy();
                c1.k = null;
            }
            c1.n.b = null;
            if (c1.l != null)
            {
                c1.l.destroy();
                c1.l = null;
            }
        }
        com.mopub.mobileads.o.a(this, super.c.longValue(), "com.mopub.action.interstitial.dismiss");
        super.onDestroy();
    }

    protected void onPause()
    {
        if (d != null)
        {
            d.a(isFinishing());
        }
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        if (d != null)
        {
            c c1 = d;
            c1.p = false;
            if (c1.k != null)
            {
                com.mopub.mobileads.c.a.a(c1.k);
            }
            if (c1.l != null)
            {
                com.mopub.mobileads.c.a.a(c1.l);
            }
        }
    }
}
