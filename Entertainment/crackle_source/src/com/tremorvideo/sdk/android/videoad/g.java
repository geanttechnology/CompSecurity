// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Process;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tremorvideo.sdk.android.e.a;
import com.tremorvideo.sdk.android.e.d;
import com.tremorvideo.sdk.android.e.p;
import com.tremorvideo.sdk.android.richmedia.m;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            a, ax, r, ad, 
//            aw, ab

public class g extends com.tremorvideo.sdk.android.videoad.a
    implements com.tremorvideo.sdk.android.richmedia.n.a, ax.c
{

    ax a;
    int b;
    int e;
    boolean f;
    private r g;
    private p h;
    private ImageView i;
    private RelativeLayout j;

    public g(a.a a1, Activity activity, r r1)
    {
        super(a1, activity);
        b = 0;
        e = -1;
        f = false;
        g = r1;
        a = new ax(activity, a1, g.q());
        a.a(this);
        g.G().a(a);
        a1 = g.B();
        if (a1 != null)
        {
            a.a(a1);
            a.b(a1);
        }
        if (!r1.H())
        {
            a(((m) (null)), true);
            return;
        } else
        {
            c.requestWindowFeature(1);
            c.getWindow().setFlags(1024, 1024);
            com.tremorvideo.sdk.android.videoad.ad.a(c.getWindow());
            h = b(this);
            j = new RelativeLayout(c);
            a1 = new android.widget.RelativeLayout.LayoutParams(-1, -2);
            a1.addRule(13);
            j.addView(h, a1);
            c.setContentView(j);
            return;
        }
    }

    static p a(g g1)
    {
        return g1.h;
    }

    private p b(g g1)
    {
        h = new p(c, com.tremorvideo.sdk.android.e.p.a.a, com.tremorvideo.sdk.android.e.p.e.c, com.tremorvideo.sdk.android.e.p.k.b, g.F(), g);
        h.a(g1);
        h.a(new com.tremorvideo.sdk.android.e.p.j() {

            final g a;

            public void a(p p1)
            {
                a.i();
            }

            
            {
                a = g.this;
                super();
            }
        });
        h.a(new com.tremorvideo.sdk.android.e.p.f() {

            final g a;

            public void a(p p1, boolean flag)
            {
                if (flag)
                {
                    a.i();
                    return;
                } else
                {
                    a.p();
                    return;
                }
            }

            
            {
                a = g.this;
                super();
            }
        });
        h.a(new com.tremorvideo.sdk.android.e.p.g() {

            final g a;

            public void a(p p1, com.tremorvideo.sdk.android.e.p.l l)
            {
                a.a(null, false);
            }

            
            {
                a = g.this;
                super();
            }
        });
        g1 = new File((new StringBuilder()).append(g.F()).append(g.s).toString());
        h.a(g1);
        if (g.t == 1)
        {
            e = 0;
            com.tremorvideo.sdk.android.videoad.ad.d(c);
            d.b(e);
        } else
        if (g.t == 2)
        {
            e = 1;
            ad.c(c);
            d.b(e);
        } else
        {
            e = -1;
            c.setRequestedOrientation(-1);
            d.b(e);
        }
        return h;
    }

    public void a()
    {
        if (a.b())
        {
            a.e();
            a.b(null);
        }
    }

    public void a(Configuration configuration)
    {
    }

    public void a(m m1, boolean flag)
    {
        a.a();
        g.G().a(null);
        f = flag;
        if (!f)
        {
            m1 = g.C();
            if (m1 != null)
            {
                a.a(m1);
                a.b(m1);
            }
        }
        d.a(this);
    }

    public void a(aw aw1)
    {
        if (aw1 != null)
        {
            if (aw1.a() == aw.b.w)
            {
                b = b + 1;
            } else
            if (aw1.a() == aw.b.v)
            {
                d.a(this);
                return;
            }
        }
    }

    public void a(aw aw1, int k)
    {
        a(aw1, k, null);
    }

    public void a(aw aw1, int k, String s)
    {
label0:
        {
            if (aw1 != null)
            {
                if (!aw1.m())
                {
                    break label0;
                }
                a.a(aw1, k, null);
            }
            return;
        }
        aw1 = new ab(c, g.q(), com.tremorvideo.sdk.android.videoad.ab.a.a, new ab.b() {

            final g a;

            public void a(boolean flag)
            {
            }

            
            {
                a = g.this;
                super();
            }
        });
        aw1.setCanceledOnTouchOutside(false);
        aw1.setTitle("Unsupported Feature");
        aw1.a("Sorry, that feature is not supported on your device.");
        aw1.a("OK", "");
        aw1.show();
    }

    public void a(String s, int k)
    {
        if (s == "adchoices")
        {
            s = g.a(aw.b.H);
        } else
        {
            s = g.c(s);
        }
        if (s != null)
        {
            a(((aw) (s)), k);
        }
    }

    public void a(String s, aw.b b1, int k, String s1)
    {
    }

    public boolean a(int k, KeyEvent keyevent)
    {
        if (k == 4)
        {
            if (!h.b())
            {
                keyevent = g.n();
                if (keyevent == null)
                {
                    d.a(this);
                } else
                {
                    a.a(keyevent);
                    a.b(keyevent);
                    d.a(this);
                }
            }
            return true;
        } else
        {
            return super.a(k, keyevent);
        }
    }

    public void b()
    {
        if (h != null)
        {
            h.onPause();
        }
        super.b();
    }

    public void b(aw aw1)
    {
    }

    public void c()
    {
        super.c();
        KeyguardManager keyguardmanager = (KeyguardManager)c.getSystemService("keyguard");
        if (h != null && !keyguardmanager.inKeyguardRestrictedInputMode())
        {
            h.onResume();
        }
    }

    public void d()
    {
        super.d();
        Iterator iterator = ((ActivityManager)c.getSystemService("activity")).getRunningAppProcesses().iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)iterator.next();
        if (runningappprocessinfo.pid != Process.myPid()) goto _L4; else goto _L3
_L3:
        int k = runningappprocessinfo.importance;
        if (k != 100) goto _L2; else goto _L5
_L5:
        boolean flag = true;
_L7:
        if (flag)
        {
            h.onResume();
        }
        return;
        Exception exception;
        exception;
        com.tremorvideo.sdk.android.videoad.ad.a(exception);
_L2:
        flag = false;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void e()
    {
        c.setContentView(j);
    }

    public void f()
    {
        if (g.t == 2)
        {
            ad.c(c);
            return;
        } else
        {
            com.tremorvideo.sdk.android.videoad.ad.d(c);
            return;
        }
    }

    public o.a g()
    {
        aw aw1 = g.a(aw.b.H);
        if (aw1 == null)
        {
            return o.a.f;
        }
        int k = aw1.a("location", -1);
        if (k == -1)
        {
            return o.a.f;
        } else
        {
            return com.tremorvideo.sdk.android.videoad.o.a.values()[k];
        }
    }

    public void h()
    {
        com.tremorvideo.sdk.android.videoad.ad.a(c, e);
    }

    protected void i()
    {
        float f1 = 1.0F;
        if (i == null)
        {
            Drawable drawable = Drawable.createFromStream(new ByteArrayInputStream(d.a), "closeImage");
            StateListDrawable statelistdrawable = new StateListDrawable();
            statelistdrawable.addState(new int[] {
                0xfefeff59
            }, drawable);
            statelistdrawable.addState(new int[] {
                0x10100a7
            }, drawable);
            i = new ImageButton(c);
            i.setImageDrawable(statelistdrawable);
            i.setBackgroundDrawable(null);
            i.setOnClickListener(new android.view.View.OnClickListener() {

                final g a;

                public void onClick(View view)
                {
                    com.tremorvideo.sdk.android.videoad.g.a(a).q();
                }

            
            {
                a = g.this;
                super();
            }
            });
        }
        float f2 = c.getResources().getDisplayMetrics().density;
        android.widget.RelativeLayout.LayoutParams layoutparams;
        int k;
        int l;
        if (f2 >= 1.0F)
        {
            f1 = f2;
        }
        k = (int)(32F * f1);
        l = (int)(f1 * 2.0F + 0.5F);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(k, k);
        layoutparams.addRule(11);
        layoutparams.setMargins(l, l, l, l);
        j.removeView(i);
        j.addView(i, layoutparams);
    }

    public boolean m()
    {
        return !a.d();
    }

    public a.b n()
    {
        if (f)
        {
            return com.tremorvideo.sdk.android.videoad.a.b.d;
        } else
        {
            return com.tremorvideo.sdk.android.videoad.a.b.d;
        }
    }

    public void o()
    {
        if (h != null)
        {
            h.destroyDrawingCache();
            h.e();
            h = null;
        }
        if (g != null)
        {
            g.E();
        }
    }

    protected void p()
    {
        j.removeView(i);
    }
}
