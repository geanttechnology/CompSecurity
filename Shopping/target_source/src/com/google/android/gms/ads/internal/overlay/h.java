// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.b.cj;
import java.util.HashMap;

// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            g, i, m

public class h extends FrameLayout
    implements g
{

    private final cj a;
    private final FrameLayout b;
    private final i c;
    private final m d = new m(this);
    private TextView e;
    private long f;
    private long g;
    private String h;

    public h(Context context, cj cj1)
    {
        super(context);
        a = cj1;
        b = new FrameLayout(context);
        addView(b);
        c = new i(context);
        b.addView(c, new android.widget.FrameLayout.LayoutParams(-1, -1, 17));
        e = new TextView(context);
        e.setBackgroundColor(0xff000000);
        n();
        d.b();
        c.a(this);
    }

    public static void a(cj cj1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("event", "no_video_view");
        cj1.a("onVideoEvent", hashmap);
    }

    private transient void a(String s, String as[])
    {
        HashMap hashmap = new HashMap();
        hashmap.put("event", s);
        int j1 = as.length;
        int i1 = 0;
        s = null;
        while (i1 < j1) 
        {
            String s1 = as[i1];
            if (s == null)
            {
                s = s1;
            } else
            {
                hashmap.put(s, s1);
                s = null;
            }
            i1++;
        }
        a.a("onVideoEvent", hashmap);
    }

    private void n()
    {
        if (!p())
        {
            b.addView(e, new android.widget.FrameLayout.LayoutParams(-1, -1));
            b.bringChildToFront(e);
        }
    }

    private void o()
    {
        if (p())
        {
            b.removeView(e);
        }
    }

    private boolean p()
    {
        return e.getParent() != null;
    }

    public void a()
    {
    }

    public void a(float f1)
    {
        c.a(f1);
    }

    public void a(int i1)
    {
        c.a(i1);
    }

    public void a(int i1, int j1, int k1, int l1)
    {
        if (k1 == 0 || l1 == 0)
        {
            return;
        } else
        {
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(k1 + 2, l1 + 2);
            layoutparams.setMargins(i1 - 1, j1 - 1, 0, 0);
            b.setLayoutParams(layoutparams);
            requestLayout();
            return;
        }
    }

    public void a(MediaPlayer mediaplayer)
    {
        if (g == 0L)
        {
            a("canplaythrough", new String[] {
                "duration", String.valueOf((float)mediaplayer.getDuration() / 1000F), "videoWidth", String.valueOf(mediaplayer.getVideoWidth()), "videoHeight", String.valueOf(mediaplayer.getVideoHeight())
            });
        }
    }

    public void a(MotionEvent motionevent)
    {
        c.dispatchTouchEvent(motionevent);
    }

    public void a(String s)
    {
        h = s;
    }

    public void a(String s, String s1)
    {
        a("error", new String[] {
            "what", s, "extra", s1
        });
    }

    public void b()
    {
    }

    public void c()
    {
        a("pause", new String[0]);
    }

    public void d()
    {
        a("ended", new String[0]);
    }

    public void e()
    {
        n();
        g = f;
    }

    public void f()
    {
        if (!TextUtils.isEmpty(h))
        {
            c.setVideoPath(h);
            return;
        } else
        {
            a("no_src", new String[0]);
            return;
        }
    }

    public void g()
    {
        c.c();
    }

    public void h()
    {
        c.b();
    }

    public void i()
    {
        c.d();
    }

    public void j()
    {
        c.e();
    }

    public void k()
    {
        TextView textview = new TextView(c.getContext());
        textview.setText("AdMob");
        textview.setTextColor(0xffff0000);
        textview.setBackgroundColor(-256);
        b.addView(textview, new android.widget.FrameLayout.LayoutParams(-2, -2, 17));
        b.bringChildToFront(textview);
    }

    public void l()
    {
        d.a();
        c.a();
    }

    void m()
    {
        long l1 = c.getCurrentPosition();
        if (f != l1 && l1 > 0L)
        {
            o();
            a("timeupdate", new String[] {
                "time", String.valueOf((float)l1 / 1000F)
            });
            f = l1;
        }
    }
}
