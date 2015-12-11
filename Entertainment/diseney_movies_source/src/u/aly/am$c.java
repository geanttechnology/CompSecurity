// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.util.BitSet;

// Referenced classes of package u.aly:
//            dj, am, cf, de, 
//            an, cy, bz

private static class <init> extends dj
{

    public void a(cy cy, am am1)
        throws cf
    {
        cy = (de)cy;
        cy.a(am1.a);
        cy.a(am1.b);
        BitSet bitset = new BitSet();
        if (am1.l())
        {
            bitset.set(0);
        }
        cy.a(bitset, 1);
        if (am1.l())
        {
            cy.a(am1.c.a());
        }
    }

    public void a(cy cy, bz bz)
        throws cf
    {
        b(cy, (am)bz);
    }

    public void b(cy cy, am am1)
        throws cf
    {
        cy = (de)cy;
        am1.a = cy.x();
        am1.b(true);
        am1.b = cy.z();
        am1.c(true);
        if (cy.b(1).get(0))
        {
            am1.c = an.a(cy.w());
            am1.d(true);
        }
    }

    public void b(cy cy, bz bz)
        throws cf
    {
        a(cy, (am)bz);
    }

    private itSet()
    {
    }

    itSet(itSet itset)
    {
        this();
    }
}
