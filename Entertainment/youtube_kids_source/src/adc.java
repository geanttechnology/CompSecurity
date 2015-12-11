// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.google.android.apps.youtube.kids.ui.TimeBar;

public final class adc
    implements ada
{

    public final act a;
    public bsc b;
    public boolean c;
    private final rx d;
    private final Activity e;
    private final bqe f;
    private boolean g;
    private boolean h;

    public adc(Activity activity, act act1, rx rx1, bqe bqe1)
    {
        c = false;
        e = activity;
        a = act1;
        d = rx1;
        f = bqe1;
        act1.g = this;
    }

    public final void a()
    {
        Object obj1 = d;
        Object obj = new add(this);
        obj1 = ((rx) (obj1)).e;
        if (((cxf) (obj1)).e == null)
        {
            obj1.e = ((bhv) (obj));
            obj = ((cxf) (obj1)).b;
            if (!TextUtils.isEmpty(((cxl) (obj)).b))
            {
                obj.a = true;
                ((cxl) (obj)).a();
            }
        }
    }

    public final void a(int i)
    {
        d.a(i);
    }

    public final void a(cxu cxu)
    {
        d.a(cxu);
    }

    public final void a(boolean flag)
    {
        if (c && flag)
        {
            return;
        } else
        {
            d.d(flag);
            return;
        }
    }

    public final void b()
    {
        d.g();
        a.b(false);
    }

    public final void c()
    {
        d.i();
        a.b(true);
    }

    public final void d()
    {
        a.b.a();
        d.h();
    }

    public final void e()
    {
        if (d.d() == null)
        {
            bmo.c("Flag without action target.");
            return;
        }
        Object obj = d.d();
        act act1 = a;
        Activity activity = e;
        obj = new acx(act1, ((String) (obj)));
        if (((acx) (obj)).b == null)
        {
            obj.a = LayoutInflater.from(activity).inflate(0x7f04002e, null, false);
            acy acy1 = new acy(((acx) (obj)));
            obj.b = (new android.app.AlertDialog.Builder(new ContextThemeWrapper(activity, 0x7f0c0121))).setView(((acx) (obj)).a).setCancelable(true).setPositiveButton(0x7f0b01db, acy1).setNegativeButton(0x7f0b01dc, acy1).create();
        }
        ((acx) (obj)).b.show();
    }

    public final void f()
    {
        if (a.e)
        {
            f.a(b.c(), null);
        }
    }

    public final void g()
    {
        if (d.m())
        {
            d.o();
            return;
        } else
        {
            d.b(true);
            d.o();
            d.b(false);
            return;
        }
    }

    public final void handlePlayerGeometryEvent(csg csg1)
    {
        boolean flag;
        if (csg1.a == ctr.f)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c = flag;
    }

    public final void handleSubtitleTracksAvailabilityEvent(cta cta1)
    {
        act act1 = a;
        boolean flag = cta1.a;
        act1.h.a(flag);
    }

    public final void handleVideoStageEvent(ctd ctd1)
    {
        ctd1 = ctd1.b;
        act act1 = a;
        byte byte0;
        if (ctd1.a())
        {
            byte0 = 2;
        } else
        {
            byte0 = 1;
        }
        act1.b.a(byte0);
        g = ctd1.a(ctt.b);
        if (ctd1 == ctt.a)
        {
            g = false;
            a.a(cuv.a);
        } else
        {
            if (!g || ctd1.b())
            {
                a.a(cuv.d);
                return;
            }
            if (ctd1.a(new ctt[] {
    ctt.d, ctt.g
}))
            {
                a.a(cuv.b);
                return;
            }
            if (ctd1 == ctt.j)
            {
                a.a(cuv.g);
                if (a.d)
                {
                    a(false);
                    return;
                }
            }
        }
    }

    public final void handleVideoTimeEvent(cte cte1)
    {
        act act1 = a;
        int i = (int)cte1.a;
        int j = (int)cte1.b;
        int k = (int)cte1.c;
        act1.b.a(i, j, k);
    }

    public final void handleYouTubePlayerStateEvent(ctf ctf1)
    {
        if (g) goto _L2; else goto _L1
_L1:
        return;
_L2:
        ctf1.a;
        JVM INSTR tableswitch 2 10: default 64
    //                   2 65
    //                   3 80
    //                   4 80
    //                   5 92
    //                   6 109
    //                   7 64
    //                   8 64
    //                   9 64
    //                   10 143;
           goto _L3 _L4 _L5 _L5 _L6 _L7 _L3 _L3 _L3 _L8
_L8:
        continue; /* Loop/switch isn't completed */
_L3:
        return;
_L4:
        act act1;
        act1 = a;
        ctf1 = cuv.b;
_L9:
        act1.a(ctf1);
        return;
_L5:
        act1 = a;
_L12:
        ctf1 = cuv.c;
          goto _L9
_L6:
        h = true;
        act1 = a;
        ctf1 = cuv.d;
          goto _L9
_L7:
        h = false;
        act1 = a;
        if (ctf1.b)
        {
            ctf1 = cuv.b;
        } else
        {
            ctf1 = cuv.c;
        }
        act1.a(ctf1);
        return;
        if (h) goto _L1; else goto _L10
_L10:
        act act2;
        act2 = a;
        act1 = act2;
        if (!ctf1.b) goto _L12; else goto _L11
_L11:
        ctf1 = cuv.b;
        act1 = act2;
          goto _L9
    }
}
