// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.d.bd;
import com.google.android.gms.d.be;
import com.google.android.gms.d.he;
import java.util.HashMap;

// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            h, j, q, i

public final class k extends FrameLayout
    implements h
{

    public final FrameLayout a;
    final q b = new q(this);
    public i c;
    TextView d;
    long e;
    public String f;
    private final he g;
    private boolean h;
    private boolean i;
    private long j;
    private String k;

    public k(Context context, he he1, be be, bd bd)
    {
        super(context);
        g = he1;
        a = new FrameLayout(context);
        addView(a);
        com.google.android.gms.common.internal.d.a(he1.e());
        c = he1.e().b.a(context, he1, be, bd);
        a.addView(c, new android.widget.FrameLayout.LayoutParams(-1, -1, 17));
        d = new TextView(context);
        d.setBackgroundColor(0xff000000);
        i();
        b.a();
        c.a(this);
    }

    public static void a(he he1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("event", "no_video_view");
        he1.a("onVideoEvent", hashmap);
    }

    private void i()
    {
        if (!g())
        {
            a.addView(d, new android.widget.FrameLayout.LayoutParams(-1, -1));
            a.bringChildToFront(d);
        }
    }

    public final void a()
    {
        if (j == 0L)
        {
            a("canplaythrough", new String[] {
                "duration", String.valueOf((float)c.getDuration() / 1000F), "videoWidth", String.valueOf(c.getVideoWidth()), "videoHeight", String.valueOf(c.getVideoHeight())
            });
        }
    }

    public final void a(int l, int i1, int j1, int k1)
    {
        if (j1 == 0 || k1 == 0)
        {
            return;
        } else
        {
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(j1 + 2, k1 + 2);
            layoutparams.setMargins(l - 1, i1 - 1, 0, 0);
            a.setLayoutParams(layoutparams);
            requestLayout();
            return;
        }
    }

    public final void a(String s, String s1)
    {
        a("error", new String[] {
            "what", s, "extra", s1
        });
    }

    final transient void a(String s, String as[])
    {
        HashMap hashmap = new HashMap();
        hashmap.put("event", s);
        int i1 = as.length;
        int l = 0;
        s = null;
        while (l < i1) 
        {
            String s1 = as[l];
            if (s == null)
            {
                s = s1;
            } else
            {
                hashmap.put(s, s1);
                s = null;
            }
            l++;
        }
        g.a("onVideoEvent", hashmap);
    }

    public final void b()
    {
        if (g.c() != null && !h)
        {
            boolean flag;
            if ((g.c().getWindow().getAttributes().flags & 0x80) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            i = flag;
            if (!i)
            {
                g.c().getWindow().addFlags(128);
                h = true;
            }
        }
    }

    public final void c()
    {
        a("pause", new String[0]);
        h();
    }

    public final void d()
    {
        a("ended", new String[0]);
        h();
    }

    public final void e()
    {
        i();
        j = e;
    }

    public final void f()
    {
        if (!TextUtils.isEmpty(f))
        {
            c.setMimeType(k);
            c.setVideoPath(f);
            return;
        } else
        {
            a("no_src", new String[0]);
            return;
        }
    }

    final boolean g()
    {
        return d.getParent() != null;
    }

    final void h()
    {
        while (g.c() == null || !h || i) 
        {
            return;
        }
        g.c().getWindow().clearFlags(128);
        h = false;
    }

    public final void setMimeType(String s)
    {
        k = s;
    }
}
