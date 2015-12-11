// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import java.util.Collections;
import java.util.List;

public class ta
    implements bhv, cyn
{

    public final sy a;
    public final cxn b;
    public final cym c;
    public final Handler d;
    public final sz e;
    public cyg f;
    public List g;
    public int h;
    public bhx i;
    public boolean j;
    public boolean k;
    public int l;

    public ta(sy sy1, cxn cxn1, SharedPreferences sharedpreferences, boolean flag, Context context, bje bje)
    {
        a = (sy)b.a(sy1);
        b = (cxn)b.a(cxn1);
        b.a(bje);
        c = new cym(this, new bmi(), new Handler(context.getMainLooper()));
        d = new Handler(context.getMainLooper());
        e = new sz(context, sharedpreferences, false, sz.a);
        e.e = this;
        sy1.a(e.c());
        sy1.a(e.b());
    }

    public int a(int i1)
    {
        if (f != null)
        {
            a.a(f.a(i1));
        }
        if (f != null)
        {
            h = h + 1;
            if (h < g.size())
            {
                return ((Integer)g.get(h)).intValue();
            }
        }
        return -1;
    }

    public void a()
    {
        d();
        if (i != null)
        {
            i.a = true;
            i = null;
        }
    }

    public void a(float f1)
    {
        a.a(f1);
    }

    public void a(cxu cxu1)
    {
        if (i != null)
        {
            i.a = true;
        }
        if (cxu1 == null || TextUtils.isEmpty(cxu1.a))
        {
            d();
            return;
        } else
        {
            i = bhx.a(this);
            b.a(cxu1, bhy.a(d, i));
            return;
        }
    }

    public void a(cyg cyg1)
    {
        f = cyg1;
        g = cyg1.a;
        e();
    }

    public void a(cyi cyi)
    {
        a.a(cyi);
    }

    public void a(Exception exception)
    {
        bmo.a("error retrieving subtitle", exception);
        d();
    }

    public volatile void a(Object obj, Exception exception)
    {
        a(exception);
    }

    public volatile void a(Object obj, Object obj1)
    {
        a((cyg)obj1);
    }

    public void b()
    {
        c.a();
    }

    public void b(int i1)
    {
label0:
        {
            if (f != null && j && k)
            {
                a.a(f.a(i1));
                int j1 = Collections.binarySearch(g, Integer.valueOf(i1));
                cym cym1;
                if (j1 >= 0)
                {
                    j1++;
                } else
                {
                    j1 = ~j1;
                }
                h = j1;
                if (h >= g.size())
                {
                    break label0;
                }
                cym1 = c;
                j1 = ((Integer)g.get(h)).intValue();
                cym1.c = (int)(cym1.b.b() - (long)i1);
                cym1.a(j1);
            }
            return;
        }
        c();
    }

    public void c()
    {
        c.a();
        a.a();
        a.b();
    }

    public void d()
    {
        c();
        if (f != null)
        {
            f = null;
        }
    }

    public void e()
    {
        b(l);
    }

    public void f()
    {
        a.a(e.c());
        a.a(e.b());
    }

    public void handleSubtitleTrackChangedEvent(csz csz1)
    {
        a(csz1.a);
    }

    public void handleVideoStageEvent(ctd ctd1)
    {
        k = ctd1.b.e();
        if (ctd1.b == ctt.a)
        {
            a();
        } else
        if (ctd1.b == ctt.b || ctd1.b == ctt.i)
        {
            f();
            return;
        }
    }

    public void handleVideoTimeEvent(cte cte1)
    {
        l = (int)cte1.a;
        b(l);
    }

    public void handleYouTubePlayerStateEvent(ctf ctf1)
    {
        boolean flag;
        if (ctf1.a != 7 && ctf1.a != 8 && ctf1.a != 4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        j = flag;
        switch (ctf1.a)
        {
        case 6: // '\006'
        default:
            return;

        case 4: // '\004'
            c();
            return;

        case 3: // '\003'
            b();
            return;

        case 5: // '\005'
            b();
            return;

        case 7: // '\007'
            c();
            return;

        case 8: // '\b'
            c();
            return;

        case 9: // '\t'
            c();
            break;
        }
    }
}
