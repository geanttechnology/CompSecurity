// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.util.BitSet;

// Referenced classes of package u.aly:
//            dj, aq, cf, de, 
//            cy, bz

private static class <init> extends dj
{

    public void a(cy cy, aq aq1)
        throws cf
    {
        cy = (de)cy;
        cy.a(aq1.a);
        cy.a(aq1.c);
        cy.a(aq1.d);
        BitSet bitset = new BitSet();
        if (aq1.i())
        {
            bitset.set(0);
        }
        cy.a(bitset, 1);
        if (aq1.i())
        {
            cy.a(aq1.b);
        }
    }

    public void a(cy cy, bz bz)
        throws cf
    {
        b(cy, (aq)bz);
    }

    public void b(cy cy, aq aq1)
        throws cf
    {
        cy = (de)cy;
        aq1.a = cy.z();
        aq1.a(true);
        aq1.c = cy.z();
        aq1.c(true);
        aq1.d = cy.x();
        aq1.d(true);
        if (cy.b(1).get(0))
        {
            aq1.b = cy.z();
            aq1.b(true);
        }
    }

    public void b(cy cy, bz bz)
        throws cf
    {
        a(cy, (aq)bz);
    }

    private itSet()
    {
    }

    itSet(itSet itset)
    {
        this();
    }
}
