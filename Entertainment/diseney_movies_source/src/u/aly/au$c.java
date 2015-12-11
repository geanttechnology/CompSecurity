// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.util.BitSet;

// Referenced classes of package u.aly:
//            dj, au, cf, de, 
//            cy, bz

private static class <init> extends dj
{

    public void a(cy cy, au au1)
        throws cf
    {
        cy = (de)cy;
        cy.a(au1.b);
        cy.a(au1.c);
        BitSet bitset = new BitSet();
        if (au1.e())
        {
            bitset.set(0);
        }
        cy.a(bitset, 1);
        if (au1.e())
        {
            cy.a(au1.a);
        }
    }

    public void a(cy cy, bz bz)
        throws cf
    {
        b(cy, (au)bz);
    }

    public void b(cy cy, au au1)
        throws cf
    {
        cy = (de)cy;
        au1.b = cy.x();
        au1.b(true);
        au1.c = cy.z();
        au1.c(true);
        if (cy.b(1).get(0))
        {
            au1.a = cy.z();
            au1.a(true);
        }
    }

    public void b(cy cy, bz bz)
        throws cf
    {
        a(cy, (au)bz);
    }

    private itSet()
    {
    }

    itSet(itSet itset)
    {
        this();
    }
}
