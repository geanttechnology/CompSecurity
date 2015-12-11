// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package u.aly:
//            di, bf, cf, cy, 
//            ct, db, aj, ai, 
//            ak, ax, ah, cu, 
//            av, bd, at, as, 
//            bz

private static class <init> extends di
{

    public void a(cy cy1, bf bf1)
        throws cf
    {
        cy1.j();
_L12:
        Object obj;
        obj = cy1.l();
        if (((ct) (obj)).b == 0)
        {
            cy1.k();
            bf1.I();
            return;
        }
        ((ct) (obj)).c;
        JVM INSTR tableswitch 1 9: default 80
    //                   1 95
    //                   2 142
    //                   3 189
    //                   4 236
    //                   5 283
    //                   6 330
    //                   7 430
    //                   8 530
    //                   9 577;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L2:
        break; /* Loop/switch isn't completed */
_L10:
        break MISSING_BLOCK_LABEL_577;
_L1:
        db.a(cy1, ((ct) (obj)).b);
_L13:
        cy1.m();
        if (true) goto _L12; else goto _L11
_L11:
        if (((ct) (obj)).b == 12)
        {
            bf1.a = new aj();
            bf1.a.a(cy1);
            bf1.a(true);
        } else
        {
            db.a(cy1, ((ct) (obj)).b);
        }
          goto _L13
_L3:
        if (((ct) (obj)).b == 12)
        {
            bf1.b = new ai();
            bf1.b.a(cy1);
            bf1.b(true);
        } else
        {
            db.a(cy1, ((ct) (obj)).b);
        }
          goto _L13
_L4:
        if (((ct) (obj)).b == 12)
        {
            bf1.c = new ak();
            bf1.c.a(cy1);
            bf1.c(true);
        } else
        {
            db.a(cy1, ((ct) (obj)).b);
        }
          goto _L13
_L5:
        if (((ct) (obj)).b == 12)
        {
            bf1.d = new ax();
            bf1.d.a(cy1);
            bf1.d(true);
        } else
        {
            db.a(cy1, ((ct) (obj)).b);
        }
          goto _L13
_L6:
        if (((ct) (obj)).b == 12)
        {
            bf1.e = new ah();
            bf1.e.a(cy1);
            bf1.e(true);
        } else
        {
            db.a(cy1, ((ct) (obj)).b);
        }
          goto _L13
_L7:
        int i;
        if (((ct) (obj)).b != 15)
        {
            break MISSING_BLOCK_LABEL_419;
        }
        obj = cy1.p();
        bf1.f = new ArrayList(((cu) (obj)).b);
        i = 0;
_L14:
label0:
        {
            if (i < ((cu) (obj)).b)
            {
                break label0;
            }
            cy1.q();
            bf1.f(true);
        }
          goto _L13
        av av1 = new av();
        av1.a(cy1);
        bf1.f.add(av1);
        i++;
          goto _L14
        db.a(cy1, ((ct) (obj)).b);
          goto _L13
_L8:
        if (((ct) (obj)).b != 15)
        {
            break MISSING_BLOCK_LABEL_519;
        }
        obj = cy1.p();
        bf1.g = new ArrayList(((cu) (obj)).b);
        i = 0;
_L15:
label1:
        {
            if (i < ((cu) (obj)).b)
            {
                break label1;
            }
            cy1.q();
            bf1.g(true);
        }
          goto _L13
        bd bd1 = new bd();
        bd1.a(cy1);
        bf1.g.add(bd1);
        i++;
          goto _L15
        db.a(cy1, ((ct) (obj)).b);
          goto _L13
_L9:
        if (((ct) (obj)).b == 12)
        {
            bf1.h = new at();
            bf1.h.a(cy1);
            bf1.h(true);
        } else
        {
            db.a(cy1, ((ct) (obj)).b);
        }
          goto _L13
        if (((ct) (obj)).b == 12)
        {
            bf1.i = new as();
            bf1.i.a(cy1);
            bf1.i(true);
        } else
        {
            db.a(cy1, ((ct) (obj)).b);
        }
          goto _L13
    }

    public volatile void a(cy cy1, bz bz)
        throws cf
    {
        a(cy1, (bf)bz);
    }

    public void b(cy cy1, bf bf1)
        throws cf
    {
        bf1.I();
        cy1.a(bf.J());
        if (bf1.a != null)
        {
            cy1.a(bf.K());
            bf1.a.b(cy1);
            cy1.c();
        }
        if (bf1.b != null)
        {
            cy1.a(bf.L());
            bf1.b.b(cy1);
            cy1.c();
        }
        if (bf1.c != null)
        {
            cy1.a(bf.M());
            bf1.c.b(cy1);
            cy1.c();
        }
        if (bf1.d != null)
        {
            cy1.a(bf.N());
            bf1.d.b(cy1);
            cy1.c();
        }
        if (bf1.e != null && bf1.r())
        {
            cy1.a(bf.O());
            bf1.e.b(cy1);
            cy1.c();
        }
        if (bf1.f == null || !bf1.w()) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        cy1.a(bf.P());
        cy1.a(new cu((byte)12, bf1.f.size()));
        iterator = bf1.f.iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        cy1.f();
        cy1.c();
_L2:
        if (bf1.g != null && bf1.B())
        {
            cy1.a(bf.Q());
            cy1.a(new cu((byte)12, bf1.g.size()));
            for (iterator = bf1.g.iterator(); iterator.hasNext(); ((bd)iterator.next()).b(cy1))
            {
                break MISSING_BLOCK_LABEL_379;
            }

            cy1.f();
            cy1.c();
        }
        if (bf1.h != null && bf1.E())
        {
            cy1.a(bf.R());
            bf1.h.b(cy1);
            cy1.c();
        }
        if (bf1.i != null && bf1.H())
        {
            cy1.a(bf.S());
            bf1.i.b(cy1);
            cy1.c();
        }
        cy1.d();
        cy1.b();
        return;
_L4:
        ((av)iterator.next()).b(cy1);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public volatile void b(cy cy1, bz bz)
        throws cf
    {
        b(cy1, (bf)bz);
    }

    private terator()
    {
    }

    terator(terator terator)
    {
        this();
    }
}
