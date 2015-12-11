// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class cii
    implements ann, ckk
{

    private final bjp a;
    private final ckv b;
    private final ckl c;
    private bwb d;
    private aqr e;
    private anl f;
    private aou g;
    private boolean h;
    private float i;
    private bwp j;
    private ass k;
    private bjp l;

    public cii(bjp bjp1, ckv ckv1, bmi bmi, ass ass, bjp bjp2)
    {
        a = (bjp)b.a(bjp1);
        b = (ckv)b.a(ckv1);
        c = new cjd(bmi);
        i = 1.0F;
        k = ass;
        l = bjp2;
    }

    private cku a(bww bww1, bwp bwp1)
    {
        if (bww1 == null) goto _L2; else goto _L1
_L1:
        Iterator iterator = bwd.k().iterator();
_L10:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        Iterator iterator1;
        int i1;
        i1 = ((Integer)iterator.next()).intValue();
        iterator1 = bww1.a.iterator();
_L8:
        if (!iterator1.hasNext()) goto _L6; else goto _L5
_L5:
        bwb bwb1 = (bwb)iterator1.next();
        if (bwb1.a.b != i1) goto _L8; else goto _L7
_L7:
        if (bwb1 != null)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (!i1) goto _L10; else goto _L9
_L9:
        i1 = 1;
_L11:
        if (i1 && !bww1.g)
        {
            break MISSING_BLOCK_LABEL_137;
        }
_L2:
        throw new ckm("No streaming data available for background playback.");
_L6:
        bwb1 = null;
          goto _L7
_L4:
        i1 = 0;
          goto _L11
        return b.a(bwp1, bww1.c, Collections.emptySet(), bwd.i(), false, false, true, false);
          goto _L7
    }

    private void a(aqr aqr1, int i1)
    {
        if (f != null)
        {
            f.f();
        }
        f = a.a(1, j.h(), 2000);
        f.a(this);
        f.a(i1);
        ArrayList arraylist = new ArrayList();
        if (l != null)
        {
            arraylist.addAll((Collection)l.b_());
        }
        if (k != null)
        {
            arraylist.add(k);
        }
        bjp bjp1 = a;
        bwp bwp1 = j;
        anh anh1 = new anh(new arq(40960), null, null, bwp1.a(), bwp1.b(), bwp1.c(), bwp1.d());
        g = new cil(new apd(new cmc((art)bjp1.b_(), new apu(), arraylist, new atf(), bwp1.i(), false, new aqr[] {
            aqr1
        }), anh1, 0x500000, false));
        f.a(new aou[] {
            g
        });
        a(i);
        c.a(1);
        d();
    }

    public final cku a(bww bww1, bwp bwp1, boolean flag)
    {
        return a(bww1, bwp1);
    }

    public final void a()
    {
    }

    public final void a(float f1)
    {
        i = f1;
        if (f != null)
        {
            f.a(g, 1, Float.valueOf(f1));
        }
    }

    public final void a(int i1)
    {
        i1;
        JVM INSTR tableswitch 3 5: default 28
    //                   3 29
    //                   4 45
    //                   5 69;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        h = true;
        c.a(5);
        return;
_L3:
        if (h)
        {
            h = false;
            c.a(6);
            return;
        }
          goto _L1
_L4:
        c.a(7);
        return;
    }

    public final void a(Handler handler)
    {
        c.a(handler);
    }

    public final void a(ank ank)
    {
        c.a(cjh.a(ank, h()));
    }

    public final void a(bww bww1, int i1, String s, bwp bwp1)
    {
        try
        {
            bww1 = a(bww1, bwp1);
        }
        // Misplaced declaration of an exception variable
        catch (bww bww1)
        {
            bmo.b(bww1.getMessage());
            d = null;
            e = null;
            c.a(new cnd("fmt.noneavailable", 0));
            return;
        }
        j = (bwp)b.a(bwp1);
        bwp1 = ((cku) (bww1)).b[0];
        s = bwp1.b(s);
        if (f == null || e == null || !e.e.equals(((aqr) (s)).e))
        {
            c.a();
            d = bwp1;
            e = s;
            c.a(0);
            c.a(null, bwp1, null, ((cku) (bww1)).d, ((cku) (bww1)).e, 0);
            a(e, i1);
        } else
        {
            b(i1);
        }
        d();
    }

    public final void a(cke cke)
    {
    }

    public final void a(String s, Uri uri)
    {
    }

    public final bwb b()
    {
        return null;
    }

    public final void b(int i1)
    {
        if (f != null)
        {
            c.b(i1);
            f.a(i1);
            c.c(i1);
        }
    }

    public final bwb c()
    {
        return d;
    }

    public final void d()
    {
        if (e != null)
        {
            if (f == null)
            {
                a(e, 0);
            } else
            {
                if (f.b() == 5)
                {
                    f.a(0L);
                }
                f.a(true);
            }
            c.a(2);
        }
    }

    public final void e()
    {
        if (f != null)
        {
            f.a(false);
            c.a(3);
        }
    }

    public final void f()
    {
        g();
    }

    public final void g()
    {
        if (f != null)
        {
            if (f != null)
            {
                f.f();
                f = null;
                g = null;
            }
            c.a(4);
        }
    }

    public final int h()
    {
        if (f != null)
        {
            return (int)f.h();
        } else
        {
            return 0;
        }
    }

    public final int i()
    {
        if (f != null)
        {
            return (int)f.g();
        } else
        {
            return 0;
        }
    }

    public final int j()
    {
        if (f != null)
        {
            return (int)f.i();
        } else
        {
            return 0;
        }
    }

    public final boolean k()
    {
        return f != null && f.b() == 3;
    }

    public final boolean l()
    {
        return f != null && f.b() == 4 && f.c();
    }

    public final void m()
    {
    }

    public final void n()
    {
    }
}
