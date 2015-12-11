// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library.f;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.liverail.library.a.c;
import com.liverail.library.a.d;
import com.liverail.library.a.e;
import com.liverail.library.g.b;

// Referenced classes of package com.liverail.library.f:
//            b, c, d, e, 
//            f, g, j, i, 
//            h

public class a extends RelativeLayout
{

    private static final int c = 250;
    public int a;
    public int b;
    private d d;
    private VideoView e;
    private TextView f;
    private j g;
    private i h;
    private com.liverail.library.g.a i;
    private int j;
    private int k;
    private String l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private final android.media.MediaPlayer.OnCompletionListener u;
    private final android.media.MediaPlayer.OnErrorListener v;
    private final android.media.MediaPlayer.OnPreparedListener w;
    private final android.view.View.OnClickListener x;
    private Runnable y;
    private Runnable z;

    public a(Context context)
    {
        super(context);
        a = 0;
        b = 0;
        u = new com.liverail.library.f.b(this);
        v = new com.liverail.library.f.c(this);
        w = new com.liverail.library.f.d(this);
        x = new com.liverail.library.f.e(this);
        y = new f(this);
        z = new g(this);
    }

    public a(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = 0;
        b = 0;
        u = new com.liverail.library.f.b(this);
        v = new com.liverail.library.f.c(this);
        w = new com.liverail.library.f.d(this);
        x = new com.liverail.library.f.e(this);
        y = new f(this);
        z = new g(this);
    }

    public a(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        a = 0;
        b = 0;
        u = new com.liverail.library.f.b(this);
        v = new com.liverail.library.f.c(this);
        w = new com.liverail.library.f.d(this);
        x = new com.liverail.library.f.e(this);
        y = new f(this);
        z = new g(this);
    }

    private void a(int i1, int j1)
    {
        if (e == null || !e.isPlaying())
        {
            g();
            return;
        }
        if (i1 == n)
        {
            com.liverail.library.b.a.d((new StringBuilder("onMediaPlayProgress() called with no progress ")).append(n).append(" / ").append(j1).toString());
            return;
        }
        if (j1 != m)
        {
            com.liverail.library.b.a.d((new StringBuilder("Ad video duration has changed from ")).append(m).append(" to ").append(j1).toString());
            m = j1;
        }
        boolean flag;
        boolean flag1;
        if (k > 1 && d.i.f != null && d.i.f.length() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (d.i.e != null && d.i.e.length() > 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (f != null && (flag1 || flag))
        {
            if (f.getVisibility() != 0)
            {
                f.setVisibility(0);
            }
            j1 = (int)Math.ceil((double)(j1 - i1) / 1000D);
            String s1;
            StringBuilder stringbuilder;
            if (flag)
            {
                s1 = d.i.f;
            } else
            {
                s1 = "";
            }
            stringbuilder = new StringBuilder(String.valueOf(s1));
            if (flag && flag1)
            {
                s1 = " ";
            } else
            {
                s1 = "";
            }
            stringbuilder = stringbuilder.append(s1);
            if (flag1)
            {
                s1 = d.i.e;
            } else
            {
                s1 = "";
            }
            s1 = stringbuilder.append(s1).toString().replace("{COUNTDOWN}", String.valueOf(j1)).replace("{ADINDEX}", String.valueOf(j + 1)).replace("{ADSTOTAL}", String.valueOf(k));
            f.setText(s1);
        }
        if (!d.i.i || i.i.c <= 0) goto _L2; else goto _L1
_L1:
        if (i.i.d)
        {
            j1 = m * i.i.c;
        } else
        {
            j1 = i.i.c * 1000;
        }
        if (i1 < j1 || n >= j1) goto _L4; else goto _L3
_L3:
        com.liverail.library.b.a.b((new StringBuilder("Ad becomes skippable at ")).append(i1).append(" / ").append(m).toString());
        g.setText(d.i.j);
_L2:
        if (m > 0 && i1 > 0 && !p)
        {
            com.liverail.library.b.a.a((new StringBuilder("impression reached at ms ")).append(i1).append("/").append(m).toString());
            p = true;
            setOnClickListener(x);
            removeCallbacks(z);
            if (h != null)
            {
                h.b();
            }
        }
        if ((double)i1 >= (double)m * 0.25D && !q)
        {
            q = true;
            if (h != null)
            {
                h.e();
            }
        }
        if ((double)i1 >= (double)m * 0.5D && !r)
        {
            r = true;
            if (h != null)
            {
                h.f();
            }
        }
        if ((double)i1 >= (double)m * 0.75D && !s)
        {
            s = true;
            if (h != null)
            {
                h.g();
            }
        }
        n = i1;
        return;
_L4:
        if (i1 < j1)
        {
            j1 = (int)Math.ceil((double)(j1 - i1) / 1000D);
            String s2 = d.i.k.replace("{COUNTDOWN}", String.valueOf(j1));
            g.setText(s2);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    private void a(com.liverail.library.a.b b1)
    {
        if (i != null)
        {
            d();
            if (h != null)
            {
                h.a(b1);
            }
        }
    }

    static void a(a a1)
    {
        a1.g();
    }

    static void a(a a1, int i1)
    {
        a1.m = i1;
    }

    static void a(a a1, int i1, int j1)
    {
        a1.a(i1, j1);
    }

    static void a(a a1, com.liverail.library.a.b b1)
    {
        a1.a(b1);
    }

    static void a(a a1, boolean flag)
    {
        a1.t = flag;
    }

    static void b(a a1, boolean flag)
    {
        a1.o = flag;
    }

    static boolean b(a a1)
    {
        return a1.t;
    }

    static i c(a a1)
    {
        return a1.h;
    }

    static com.liverail.library.g.a d(a a1)
    {
        return a1.i;
    }

    static String e(a a1)
    {
        return a1.l;
    }

    private void e()
    {
        com.liverail.library.b.a.a("LinearRenderer build UI elements.");
        Object obj = getContext();
        setBackgroundColor(0xff000000);
        e = new VideoView(((Context) (obj)));
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutparams.addRule(13);
        addView(e, layoutparams);
        f = new TextView(((Context) (obj)));
        f.setBackgroundColor(0x99000000);
        f.setTextColor(-1);
        f.setTextSize(14F);
        f.setText("");
        f.setVisibility(8);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        layoutparams.addRule(10);
        layoutparams.addRule(9);
        addView(f, layoutparams);
        g = new j(((Context) (obj)));
        g.setVisibility(8);
        g.setOnClickListener(new h(this));
        obj = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(12);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).setMargins(0, 0, 10, 10);
        addView(g, ((android.view.ViewGroup.LayoutParams) (obj)));
    }

    static VideoView f(a a1)
    {
        return a1.e;
    }

    private void f()
    {
        com.liverail.library.b.a.b("Start video progress task");
        postDelayed(y, 250L);
    }

    static int g(a a1)
    {
        return a1.m;
    }

    private void g()
    {
        com.liverail.library.b.a.b("Stop video progress task");
        removeCallbacks(y);
    }

    static int h(a a1)
    {
        return a1.n;
    }

    static boolean i(a a1)
    {
        return a1.o;
    }

    static void j(a a1)
    {
        a1.f();
    }

    static d k(a a1)
    {
        return a1.d;
    }

    static Runnable l(a a1)
    {
        return a1.y;
    }

    static boolean m(a a1)
    {
        return a1.p;
    }

    public void a()
    {
        if (e.isPlaying())
        {
            e.pause();
            g();
            if (h != null)
            {
                h.c();
            }
        }
    }

    public void a(com.liverail.library.g.a a1)
    {
        a(a1, 0, 1);
    }

    public void a(com.liverail.library.g.a a1, int i1, int j1)
    {
        com.liverail.library.b.a.a("LinearRenderer startAd()");
        d();
        i = a1;
        j = i1;
        k = j1;
        if (a1.i == null)
        {
            a(new com.liverail.library.a.b(c.a, (new StringBuilder("linear==null for ")).append(a1.toString()).toString()));
            return;
        }
        com.liverail.library.g.c c1 = a1.i.a(d.j);
        if (c1 == null)
        {
            com.liverail.library.b.a.e("Failed to retrieve linear creative.");
            a(new com.liverail.library.a.b(c.a, (new StringBuilder("Failed to retrieve linear creative ")).append(a1.toString()).append(" ").append(a1.i.toString()).toString()));
            return;
        }
        com.liverail.library.b.a.b((new StringBuilder("Found creative for desiredBitrate=")).append(d.j).toString());
        com.liverail.library.b.a.a(c1.toString());
        f.setText("");
        f.setVisibility(8);
        if (d.i.i && i.i.c > 0)
        {
            StringBuilder stringbuilder = (new StringBuilder("Linear skipp offset=")).append(i.i.c);
            if (i.i.d)
            {
                a1 = "%";
            } else
            {
                a1 = "s";
            }
            com.liverail.library.b.a.b(stringbuilder.append(a1).toString());
            g.setText("");
            g.setVisibility(0);
        } else
        {
            g.setVisibility(8);
        }
        e.setOnCompletionListener(u);
        e.setOnErrorListener(v);
        e.setOnPreparedListener(w);
        l = c1.e;
        com.liverail.library.b.a.b((new StringBuilder("Setting video url=")).append(l).toString());
        e.setVideoURI(Uri.parse(l));
        e.requestFocus();
        if (d.h > 0)
        {
            com.liverail.library.b.a.a((new StringBuilder("Impression timeout ")).append(d.h).append("ms").toString());
            postDelayed(z, d.h);
        }
        com.liverail.library.b.a.a("videoView.start()");
        e.start();
    }

    public void b()
    {
        if (!e.isPlaying())
        {
            e.seekTo(n);
            e.start();
            f();
            if (h != null)
            {
                h.d();
            }
        }
    }

    public void c()
    {
        d();
        if (h != null)
        {
            h.j();
        }
    }

    public void d()
    {
        com.liverail.library.b.a.a("LinearRenderer clean up");
        if (e != null && e.isPlaying())
        {
            e.stopPlayback();
        }
        o = false;
        p = false;
        q = false;
        r = false;
        s = false;
        t = false;
        n = 0;
        m = 0;
        i = null;
        l = null;
        removeCallbacks(z);
        e.setOnCompletionListener(null);
        e.setOnErrorListener(null);
        e.setOnPreparedListener(null);
        setOnClickListener(null);
        g();
    }

    public int getVideoDuration()
    {
        return m;
    }

    public int getVideoProgress()
    {
        return n;
    }

    public void setListener(i i1)
    {
        h = i1;
    }

    public void setPublisherData(d d1)
    {
        d = d1;
        if (e == null)
        {
            e();
        }
    }
}
