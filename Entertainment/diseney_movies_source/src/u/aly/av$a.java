// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package u.aly:
//            di, av, cf, cy, 
//            ct, db, cu, am, 
//            ao, bz

private static class <init> extends di
{

    public void a(cy cy1, av av1)
        throws cf
    {
        cy1.j();
_L7:
        Object obj;
        obj = cy1.l();
        if (((ct) (obj)).b == 0)
        {
            cy1.k();
            av1.v();
            return;
        }
        ((ct) (obj)).c;
        JVM INSTR tableswitch 1 4: default 60
    //                   1 75
    //                   2 111
    //                   3 211
    //                   4 311;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        db.a(cy1, ((ct) (obj)).b);
_L8:
        cy1.m();
        if (true) goto _L7; else goto _L6
_L6:
        if (((ct) (obj)).b == 11)
        {
            av1.a = cy1.z();
            av1.a(true);
        } else
        {
            db.a(cy1, ((ct) (obj)).b);
        }
          goto _L8
_L3:
        int i;
        if (((ct) (obj)).b != 15)
        {
            break MISSING_BLOCK_LABEL_200;
        }
        obj = cy1.p();
        av1.b = new ArrayList(((cu) (obj)).b);
        i = 0;
_L9:
label0:
        {
            if (i < ((cu) (obj)).b)
            {
                break label0;
            }
            cy1.q();
            av1.b(true);
        }
          goto _L8
        am am1 = new am();
        am1.a(cy1);
        av1.b.add(am1);
        i++;
          goto _L9
        db.a(cy1, ((ct) (obj)).b);
          goto _L8
_L4:
        if (((ct) (obj)).b != 15)
        {
            break MISSING_BLOCK_LABEL_300;
        }
        obj = cy1.p();
        av1.c = new ArrayList(((cu) (obj)).b);
        i = 0;
_L10:
label1:
        {
            if (i < ((cu) (obj)).b)
            {
                break label1;
            }
            cy1.q();
            av1.c(true);
        }
          goto _L8
        ao ao1 = new ao();
        ao1.a(cy1);
        av1.c.add(ao1);
        i++;
          goto _L10
        db.a(cy1, ((ct) (obj)).b);
          goto _L8
_L5:
        if (((ct) (obj)).b != 15)
        {
            break MISSING_BLOCK_LABEL_400;
        }
        obj = cy1.p();
        av1.d = new ArrayList(((cu) (obj)).b);
        i = 0;
_L11:
label2:
        {
            if (i < ((cu) (obj)).b)
            {
                break label2;
            }
            cy1.q();
            av1.d(true);
        }
          goto _L8
        ao ao2 = new ao();
        ao2.a(cy1);
        av1.d.add(ao2);
        i++;
          goto _L11
        db.a(cy1, ((ct) (obj)).b);
          goto _L8
    }

    public volatile void a(cy cy1, bz bz)
        throws cf
    {
        a(cy1, (av)bz);
    }

    public void b(cy cy1, av av1)
        throws cf
    {
        av1.v();
        cy1.a(av.w());
        if (av1.a != null)
        {
            cy1.a(av.x());
            cy1.a(av1.a);
            cy1.c();
        }
        if (av1.b == null || !av1.k()) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        cy1.a(av.y());
        cy1.a(new cu((byte)12, av1.b.size()));
        iterator = av1.b.iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        cy1.f();
        cy1.c();
_L2:
        if (av1.c != null && av1.p())
        {
            cy1.a(av.z());
            cy1.a(new cu((byte)12, av1.c.size()));
            for (iterator = av1.c.iterator(); iterator.hasNext(); ((ao)iterator.next()).b(cy1))
            {
                break MISSING_BLOCK_LABEL_272;
            }

            cy1.f();
            cy1.c();
        }
        if (av1.d != null && av1.u())
        {
            cy1.a(av.A());
            cy1.a(new cu((byte)12, av1.d.size()));
            for (av1 = av1.d.iterator(); av1.hasNext(); ((ao)av1.next()).b(cy1))
            {
                break MISSING_BLOCK_LABEL_288;
            }

            cy1.f();
            cy1.c();
        }
        cy1.d();
        cy1.b();
        return;
_L4:
        ((am)iterator.next()).b(cy1);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public volatile void b(cy cy1, bz bz)
        throws cf
    {
        b(cy1, (av)bz);
    }

    private terator()
    {
    }

    terator(terator terator)
    {
        this();
    }
}
