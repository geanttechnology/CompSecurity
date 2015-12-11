// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.util.BitSet;

// Referenced classes of package u.aly:
//            dj, bb, cf, de, 
//            at, cy, bz

private static class <init> extends dj
{

    public void a(cy cy, bb bb1)
        throws cf
    {
        cy = (de)cy;
        cy.a(bb1.a);
        BitSet bitset = new BitSet();
        if (bb1.i())
        {
            bitset.set(0);
        }
        if (bb1.l())
        {
            bitset.set(1);
        }
        cy.a(bitset, 2);
        if (bb1.i())
        {
            cy.a(bb1.b);
        }
        if (bb1.l())
        {
            bb1.c.b(cy);
        }
    }

    public void a(cy cy, bz bz)
        throws cf
    {
        b(cy, (bb)bz);
    }

    public void b(cy cy, bb bb1)
        throws cf
    {
        cy = (de)cy;
        bb1.a = cy.w();
        bb1.a(true);
        BitSet bitset = cy.b(2);
        if (bitset.get(0))
        {
            bb1.b = cy.z();
            bb1.b(true);
        }
        if (bitset.get(1))
        {
            bb1.c = new at();
            bb1.c.a(cy);
            bb1.c(true);
        }
    }

    public void b(cy cy, bz bz)
        throws cf
    {
        a(cy, (bb)bz);
    }

    private itSet()
    {
    }

    itSet(itSet itset)
    {
        this();
    }
}
