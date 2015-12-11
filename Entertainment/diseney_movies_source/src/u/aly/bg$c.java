// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.util.BitSet;

// Referenced classes of package u.aly:
//            dj, bg, cf, de, 
//            ap, cy, bz

private static class <init> extends dj
{

    public void a(cy cy, bg bg1)
        throws cf
    {
        cy = (de)cy;
        BitSet bitset = new BitSet();
        if (bg1.e())
        {
            bitset.set(0);
        }
        if (bg1.i())
        {
            bitset.set(1);
        }
        if (bg1.l())
        {
            bitset.set(2);
        }
        if (bg1.o())
        {
            bitset.set(3);
        }
        cy.a(bitset, 4);
        if (bg1.e())
        {
            cy.a(bg1.a.a());
        }
        if (bg1.i())
        {
            cy.a(bg1.b);
        }
        if (bg1.l())
        {
            cy.a(bg1.c);
        }
        if (bg1.o())
        {
            cy.a(bg1.d);
        }
    }

    public void a(cy cy, bz bz)
        throws cf
    {
        b(cy, (bg)bz);
    }

    public void b(cy cy, bg bg1)
        throws cf
    {
        cy = (de)cy;
        BitSet bitset = cy.b(4);
        if (bitset.get(0))
        {
            bg1.a = ap.a(cy.w());
            bg1.a(true);
        }
        if (bitset.get(1))
        {
            bg1.b = cy.w();
            bg1.b(true);
        }
        if (bitset.get(2))
        {
            bg1.c = cy.z();
            bg1.c(true);
        }
        if (bitset.get(3))
        {
            bg1.d = cy.z();
            bg1.d(true);
        }
    }

    public void b(cy cy, bz bz)
        throws cf
    {
        a(cy, (bg)bz);
    }

    private itSet()
    {
    }

    itSet(itSet itset)
    {
        this();
    }
}
