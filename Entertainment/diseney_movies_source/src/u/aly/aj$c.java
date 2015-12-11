// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.util.BitSet;

// Referenced classes of package u.aly:
//            dj, aj, cf, de, 
//            cy, bz

private static class <init> extends dj
{

    public void a(cy cy, aj aj1)
        throws cf
    {
        cy = (de)cy;
        cy.a(aj1.a);
        cy.a(aj1.b);
        BitSet bitset = new BitSet();
        if (aj1.l())
        {
            bitset.set(0);
        }
        cy.a(bitset, 1);
        if (aj1.l())
        {
            cy.a(aj1.c);
        }
    }

    public void a(cy cy, bz bz)
        throws cf
    {
        b(cy, (aj)bz);
    }

    public void b(cy cy, aj aj1)
        throws cf
    {
        cy = (de)cy;
        aj1.a = cy.w();
        aj1.a(true);
        aj1.b = cy.w();
        aj1.b(true);
        if (cy.b(1).get(0))
        {
            aj1.c = cy.w();
            aj1.c(true);
        }
    }

    public void b(cy cy, bz bz)
        throws cf
    {
        a(cy, (aj)bz);
    }

    private itSet()
    {
    }

    itSet(itSet itset)
    {
        this();
    }
}
