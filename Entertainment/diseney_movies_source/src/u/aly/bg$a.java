// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;


// Referenced classes of package u.aly:
//            di, bg, cf, cy, 
//            ct, db, ap, bz

private static class <init> extends di
{

    public void a(cy cy1, bg bg1)
        throws cf
    {
        cy1.j();
_L7:
        ct ct1;
        ct1 = cy1.l();
        if (ct1.b == 0)
        {
            cy1.k();
            bg1.p();
            return;
        }
        ct1.c;
        JVM INSTR tableswitch 1 4: default 60
    //                   1 75
    //                   2 114
    //                   3 150
    //                   4 186;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_186;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        db.a(cy1, ct1.b);
_L8:
        cy1.m();
        if (true) goto _L7; else goto _L6
_L6:
        if (ct1.b == 8)
        {
            bg1.a = ap.a(cy1.w());
            bg1.a(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L8
_L3:
        if (ct1.b == 8)
        {
            bg1.b = cy1.w();
            bg1.b(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L8
_L4:
        if (ct1.b == 11)
        {
            bg1.c = cy1.z();
            bg1.c(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L8
        if (ct1.b == 11)
        {
            bg1.d = cy1.z();
            bg1.d(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L8
    }

    public volatile void a(cy cy1, bz bz)
        throws cf
    {
        a(cy1, (bg)bz);
    }

    public void b(cy cy1, bg bg1)
        throws cf
    {
        bg1.p();
        cy1.a(bg.q());
        if (bg1.a != null && bg1.e())
        {
            cy1.a(bg.r());
            cy1.a(bg1.a.a());
            cy1.c();
        }
        if (bg1.i())
        {
            cy1.a(bg.s());
            cy1.a(bg1.b);
            cy1.c();
        }
        if (bg1.c != null && bg1.l())
        {
            cy1.a(bg.t());
            cy1.a(bg1.c);
            cy1.c();
        }
        if (bg1.d != null && bg1.o())
        {
            cy1.a(bg.u());
            cy1.a(bg1.d);
            cy1.c();
        }
        cy1.d();
        cy1.b();
    }

    public volatile void b(cy cy1, bz bz)
        throws cf
    {
        b(cy1, (bg)bz);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
