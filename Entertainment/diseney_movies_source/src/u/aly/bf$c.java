// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package u.aly:
//            dj, bf, cf, de, 
//            aj, ai, ak, ax, 
//            ah, at, as, av, 
//            bd, cu, cy, bz

private static class <init> extends dj
{

    public void a(cy cy, bf bf1)
        throws cf
    {
        cy = (de)cy;
        bf1.a.b(cy);
        bf1.b.b(cy);
        bf1.c.b(cy);
        bf1.d.b(cy);
        BitSet bitset = new BitSet();
        if (bf1.r())
        {
            bitset.set(0);
        }
        if (bf1.w())
        {
            bitset.set(1);
        }
        if (bf1.B())
        {
            bitset.set(2);
        }
        if (bf1.E())
        {
            bitset.set(3);
        }
        if (bf1.H())
        {
            bitset.set(4);
        }
        cy.a(bitset, 5);
        if (bf1.r())
        {
            bf1.e.b(cy);
        }
        if (!bf1.w()) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        cy.a(bf1.f.size());
        iterator = bf1.f.iterator();
_L5:
        if (iterator.hasNext()) goto _L3; else goto _L2
_L2:
        if (bf1.B())
        {
            cy.a(bf1.g.size());
            for (iterator = bf1.g.iterator(); iterator.hasNext(); ((bd)iterator.next()).b(cy))
            {
                break MISSING_BLOCK_LABEL_251;
            }

        }
        if (bf1.E())
        {
            bf1.h.b(cy);
        }
        if (bf1.H())
        {
            bf1.i.b(cy);
        }
        return;
_L3:
        ((av)iterator.next()).b(cy);
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void a(cy cy, bz bz)
        throws cf
    {
        b(cy, (bf)bz);
    }

    public void b(cy cy, bf bf1)
        throws cf
    {
        BitSet bitset;
        boolean flag;
        flag = false;
        cy = (de)cy;
        bf1.a = new aj();
        bf1.a.a(cy);
        bf1.a(true);
        bf1.b = new ai();
        bf1.b.a(cy);
        bf1.b(true);
        bf1.c = new ak();
        bf1.c.a(cy);
        bf1.c(true);
        bf1.d = new ax();
        bf1.d.a(cy);
        bf1.d(true);
        bitset = cy.b(5);
        if (bitset.get(0))
        {
            bf1.e = new ah();
            bf1.e.a(cy);
            bf1.e(true);
        }
        if (!bitset.get(1)) goto _L2; else goto _L1
_L1:
        cu cu1;
        int i;
        cu1 = new cu((byte)12, cy.w());
        bf1.f = new ArrayList(cu1.b);
        i = 0;
_L7:
        if (i < cu1.b) goto _L4; else goto _L3
_L3:
        bf1.f(true);
_L2:
        if (!bitset.get(2)) goto _L6; else goto _L5
_L5:
        cu1 = new cu((byte)12, cy.w());
        bf1.g = new ArrayList(cu1.b);
        i = ((flag) ? 1 : 0);
_L8:
        if (i < cu1.b)
        {
            break MISSING_BLOCK_LABEL_358;
        }
        bf1.g(true);
_L6:
        if (bitset.get(3))
        {
            bf1.h = new at();
            bf1.h.a(cy);
            bf1.h(true);
        }
        if (bitset.get(4))
        {
            bf1.i = new as();
            bf1.i.a(cy);
            bf1.i(true);
        }
        return;
_L4:
        av av1 = new av();
        av1.a(cy);
        bf1.f.add(av1);
        i++;
          goto _L7
        bd bd1 = new bd();
        bd1.a(cy);
        bf1.g.add(bd1);
        i++;
          goto _L8
    }

    public void b(cy cy, bz bz)
        throws cf
    {
        a(cy, (bf)bz);
    }

    private rrayList()
    {
    }

    rrayList(rrayList rraylist)
    {
        this();
    }
}
