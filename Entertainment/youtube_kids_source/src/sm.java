// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class sm
{

    final rx a;
    final bje b;
    final cuu c;
    boolean d;
    private final Resources e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private bwv k[];
    private Map l;

    public sm(Resources resources, rx rx, bje bje1, cuu cuu1)
    {
        a = rx;
        b = (bje)b.a(bje1);
        c = (cuu)b.a(cuu1);
        e = resources;
        cuu1.a(new sn(this));
    }

    private void handleSubtitleTrackChangedEvent(csz csz1)
    {
        if (csz1.a == null || TextUtils.isEmpty(csz1.a.a))
        {
            c.g(false);
            return;
        } else
        {
            c.g(true);
            return;
        }
    }

    private void handleTimelineMarkerChangeEvent(cvh cvh1)
    {
        if (l == null)
        {
            l = new HashMap();
        }
        l.put(cvh1.a, cvh1.b);
        c.a(l);
    }

    public final void handleAdClickThroughChangedEvent(bfd bfd1)
    {
        c.i(bfd1.a);
    }

    public final void handleFormatStreamChangeEvent(cjq cjq1)
    {
        int k1 = -1;
        c.d(cjq1.a());
        if (cjq1.a())
        {
            bwv abwv[] = cjq1.d;
            Object aobj[] = new bwv[abwv.length + 1];
            aobj[0] = new bwv(-2, e.getString(0x7f0b0126), false);
            System.arraycopy(abwv, 0, ((Object) (aobj)), 1, abwv.length);
            k = ((bwv []) (aobj));
            int j1;
            if (cjq1.a != null)
            {
                j1 = cjq1.a.c();
            } else
            {
                j1 = -1;
            }
            aobj = new String[k.length];
            for (int i1 = 0; i1 < k.length; i1++)
            {
                bwv bwv1 = k[i1];
                String s = bwv1.b;
                cjq1 = s;
                if (bwv1.c)
                {
                    cjq1 = String.format(e.getString(0x7f0b0125), new Object[] {
                        s
                    });
                }
                aobj[i1] = cjq1;
                if (bwv1.a == j1)
                {
                    k1 = i1;
                }
            }

            c.a(((String []) (aobj)), k1);
        }
    }

    public final void handlePlaybackServiceException(cse cse1)
    {
        if (cse1.a.a(new csf[] {
    csf.a, csf.b, csf.c, csf.d, csf.e, csf.f, csf.g, csf.h, csf.i, csf.k
}))
        {
            c.a(cse1.c, cse1.b);
        }
    }

    public final void handlePlayerGeometryEvent(csg csg1)
    {
        boolean flag1 = true;
        boolean flag;
        if (csg1.b == ctr.c)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (g != flag)
        {
            g = flag;
            c.e(g);
        }
        if (csg1.a == ctr.e)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (d != flag)
        {
            d = flag;
            c.h(d);
            if (c instanceof so)
            {
                so so1 = (so)c;
                so1.a = d;
                so1.k(d);
            }
        }
        if (csg1.a == ctr.f)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        f = flag;
    }

    public final void handleSequencerHasPreviousNextEvent(csx csx1)
    {
        c.b(csx1.a);
        c.a(csx1.b);
    }

    public final void handleSubtitleTracksAvailabilityEvent(cta cta1)
    {
        c.f(cta1.a);
    }

    public final void handleVideoStageEvent(ctd ctd1)
    {
        boolean flag2 = true;
        boolean flag = true;
        ctt ctt1 = ctd1.b;
        j = ctt1.a(ctt.b);
        if (ctt1 == ctt.a)
        {
            h = false;
            i = false;
            j = false;
            c.a();
            c.a(cux.a);
            c.a(cuv.a);
            c.i(false);
            k = null;
        } else
        if (!j || ctt1.b())
        {
            c.a(cuv.d);
        } else
        if (ctt1.a(new ctt[] {
    ctt.d, ctt.g
}))
        {
            c.a(cuv.c);
        } else
        if (ctt1 == ctt.j)
        {
            i = true;
            c.a(cuv.g);
        }
        if (ctt1.a())
        {
            if (f && ctd1.d == null)
            {
                c.a(cux.e);
            } else
            {
                c.a(cux.c);
                cuu cuu1 = c;
                if (ctd1.d == null || ctd1.d.L == null)
                {
                    flag = false;
                }
                cuu1.j(flag);
            }
        } else
        if (ctt1.a(ctt.g))
        {
            cuu cuu2;
            boolean flag1;
            if (!f)
            {
                if (ctd1.e)
                {
                    c.a(cux.d);
                } else
                {
                    c.a(cux.a);
                }
            } else
            {
                c.a(cux.b);
            }
            cuu2 = c;
            if (ctd1.c != null && ctd1.c.i() != null)
            {
                flag1 = flag2;
            } else
            {
                flag1 = false;
            }
            cuu2.j(flag1);
        }
        if (c instanceof so)
        {
            ((so)c).k(f);
        }
        flag = ctt1.a(ctt.g);
        c.c(flag);
    }

    public final void handleVideoTimeEvent(cte cte1)
    {
        c.a((int)cte1.a, (int)cte1.b, (int)cte1.c);
    }

    public final void handleYouTubePlayerStateEvent(ctf ctf1)
    {
        if (j) goto _L2; else goto _L1
_L1:
        return;
_L2:
        ctf1.a;
        JVM INSTR tableswitch 2 10: default 64
    //                   2 65
    //                   3 87
    //                   4 87
    //                   5 106
    //                   6 123
    //                   7 64
    //                   8 64
    //                   9 64
    //                   10 159;
           goto _L3 _L4 _L5 _L5 _L6 _L7 _L3 _L3 _L3 _L8
_L8:
        continue; /* Loop/switch isn't completed */
_L3:
        return;
_L4:
        cuu cuu1;
        i = false;
        cuu1 = c;
        ctf1 = cuv.b;
_L10:
        cuu1.a(ctf1);
        return;
_L5:
        if (i) goto _L1; else goto _L9
_L9:
        cuu1 = c;
_L13:
        ctf1 = cuv.c;
          goto _L10
_L6:
        h = true;
        cuu1 = c;
        ctf1 = cuv.d;
          goto _L10
_L7:
        h = false;
        cuu1 = c;
        if (ctf1.b)
        {
            ctf1 = cuv.b;
        } else
        {
            ctf1 = cuv.c;
        }
        cuu1.a(ctf1);
        return;
        if (h) goto _L1; else goto _L11
_L11:
        cuu cuu2;
        cuu2 = c;
        cuu1 = cuu2;
        if (!ctf1.b) goto _L13; else goto _L12
_L12:
        ctf1 = cuv.b;
        cuu1 = cuu2;
          goto _L10
    }
}
