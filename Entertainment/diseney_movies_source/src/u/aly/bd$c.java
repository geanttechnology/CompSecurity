// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package u.aly:
//            dj, bd, cf, de, 
//            be, ay, aw, cu, 
//            cy, bz

private static class <init> extends dj
{

    public void a(cy cy, bd bd1)
        throws cf
    {
        cy = (de)cy;
        cy.a(bd1.a);
        cy.a(bd1.b);
        cy.a(bd1.c);
        cy.a(bd1.d);
        BitSet bitset = new BitSet();
        if (bd1.t())
        {
            bitset.set(0);
        }
        if (bd1.y())
        {
            bitset.set(1);
        }
        if (bd1.B())
        {
            bitset.set(2);
        }
        cy.a(bitset, 3);
        if (!bd1.t()) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        cy.a(bd1.e.size());
        iterator = bd1.e.iterator();
_L5:
        if (iterator.hasNext()) goto _L3; else goto _L2
_L2:
        if (bd1.y())
        {
            cy.a(bd1.f.size());
            for (iterator = bd1.f.iterator(); iterator.hasNext(); ((aw)iterator.next()).b(cy))
            {
                break MISSING_BLOCK_LABEL_197;
            }

        }
        if (bd1.B())
        {
            bd1.g.b(cy);
        }
        return;
_L3:
        ((ay)iterator.next()).b(cy);
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void a(cy cy, bz bz)
        throws cf
    {
        b(cy, (bd)bz);
    }

    public void b(cy cy, bd bd1)
        throws cf
    {
        BitSet bitset;
        boolean flag;
        flag = false;
        cy = (de)cy;
        bd1.a = cy.z();
        bd1.a(true);
        bd1.b = cy.x();
        bd1.b(true);
        bd1.c = cy.x();
        bd1.c(true);
        bd1.d = cy.x();
        bd1.d(true);
        bitset = cy.b(3);
        if (!bitset.get(0)) goto _L2; else goto _L1
_L1:
        cu cu1;
        int i;
        cu1 = new cu((byte)12, cy.w());
        bd1.e = new ArrayList(cu1.b);
        i = 0;
_L7:
        if (i < cu1.b) goto _L4; else goto _L3
_L3:
        bd1.e(true);
_L2:
        if (!bitset.get(1)) goto _L6; else goto _L5
_L5:
        cu1 = new cu((byte)12, cy.w());
        bd1.f = new ArrayList(cu1.b);
        i = ((flag) ? 1 : 0);
_L8:
        if (i < cu1.b)
        {
            break MISSING_BLOCK_LABEL_250;
        }
        bd1.f(true);
_L6:
        if (bitset.get(2))
        {
            bd1.g = new be();
            bd1.g.a(cy);
            bd1.g(true);
        }
        return;
_L4:
        ay ay1 = new ay();
        ay1.a(cy);
        bd1.e.add(ay1);
        i++;
          goto _L7
        aw aw1 = new aw();
        aw1.a(cy);
        bd1.f.add(aw1);
        i++;
          goto _L8
    }

    public void b(cy cy, bz bz)
        throws cf
    {
        a(cy, (bd)bz);
    }

    private rrayList()
    {
    }

    rrayList(rrayList rraylist)
    {
        this();
    }
}
