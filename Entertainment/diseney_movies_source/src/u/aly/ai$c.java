// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.util.BitSet;

// Referenced classes of package u.aly:
//            dj, ai, cf, de, 
//            bc, cy, bz

private static class <init> extends dj
{

    public void a(cy cy, ai ai1)
        throws cf
    {
        cy = (de)cy;
        cy.a(ai1.a);
        cy.a(ai1.e.a());
        cy.a(ai1.f);
        cy.a(ai1.g);
        BitSet bitset = new BitSet();
        if (ai1.i())
        {
            bitset.set(0);
        }
        if (ai1.l())
        {
            bitset.set(1);
        }
        if (ai1.o())
        {
            bitset.set(2);
        }
        if (ai1.A())
        {
            bitset.set(3);
        }
        if (ai1.D())
        {
            bitset.set(4);
        }
        if (ai1.G())
        {
            bitset.set(5);
        }
        cy.a(bitset, 6);
        if (ai1.i())
        {
            cy.a(ai1.b);
        }
        if (ai1.l())
        {
            cy.a(ai1.c);
        }
        if (ai1.o())
        {
            cy.a(ai1.d);
        }
        if (ai1.A())
        {
            cy.a(ai1.h);
        }
        if (ai1.D())
        {
            cy.a(ai1.i);
        }
        if (ai1.G())
        {
            cy.a(ai1.j);
        }
    }

    public void a(cy cy, bz bz)
        throws cf
    {
        b(cy, (ai)bz);
    }

    public void b(cy cy, ai ai1)
        throws cf
    {
        cy = (de)cy;
        ai1.a = cy.z();
        ai1.a(true);
        ai1.e = bc.a(cy.w());
        ai1.e(true);
        ai1.f = cy.z();
        ai1.f(true);
        ai1.g = cy.z();
        ai1.g(true);
        BitSet bitset = cy.b(6);
        if (bitset.get(0))
        {
            ai1.b = cy.z();
            ai1.b(true);
        }
        if (bitset.get(1))
        {
            ai1.c = cy.w();
            ai1.c(true);
        }
        if (bitset.get(2))
        {
            ai1.d = cy.z();
            ai1.d(true);
        }
        if (bitset.get(3))
        {
            ai1.h = cy.z();
            ai1.h(true);
        }
        if (bitset.get(4))
        {
            ai1.i = cy.z();
            ai1.i(true);
        }
        if (bitset.get(5))
        {
            ai1.j = cy.w();
            ai1.j(true);
        }
    }

    public void b(cy cy, bz bz)
        throws cf
    {
        a(cy, (ai)bz);
    }

    private itSet()
    {
    }

    itSet(itSet itset)
    {
        this();
    }
}
