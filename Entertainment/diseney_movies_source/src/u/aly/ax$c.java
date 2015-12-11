// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.util.BitSet;

// Referenced classes of package u.aly:
//            dj, ax, cf, de, 
//            ag, bg, cy, bz

private static class <init> extends dj
{

    public void a(cy cy, ax ax1)
        throws cf
    {
        cy = (de)cy;
        BitSet bitset = new BitSet();
        if (ax1.e())
        {
            bitset.set(0);
        }
        if (ax1.i())
        {
            bitset.set(1);
        }
        if (ax1.l())
        {
            bitset.set(2);
        }
        if (ax1.o())
        {
            bitset.set(3);
        }
        if (ax1.r())
        {
            bitset.set(4);
        }
        if (ax1.u())
        {
            bitset.set(5);
        }
        if (ax1.x())
        {
            bitset.set(6);
        }
        if (ax1.A())
        {
            bitset.set(7);
        }
        if (ax1.D())
        {
            bitset.set(8);
        }
        if (ax1.G())
        {
            bitset.set(9);
        }
        if (ax1.J())
        {
            bitset.set(10);
        }
        cy.a(bitset, 11);
        if (ax1.e())
        {
            cy.a(ax1.a);
        }
        if (ax1.i())
        {
            cy.a(ax1.b);
        }
        if (ax1.l())
        {
            cy.a(ax1.c);
        }
        if (ax1.o())
        {
            cy.a(ax1.d);
        }
        if (ax1.r())
        {
            cy.a(ax1.e);
        }
        if (ax1.u())
        {
            cy.a(ax1.f);
        }
        if (ax1.x())
        {
            cy.a(ax1.g);
        }
        if (ax1.A())
        {
            cy.a(ax1.h);
        }
        if (ax1.D())
        {
            cy.a(ax1.i.a());
        }
        if (ax1.G())
        {
            cy.a(ax1.j);
        }
        if (ax1.J())
        {
            ax1.k.b(cy);
        }
    }

    public void a(cy cy, bz bz)
        throws cf
    {
        b(cy, (ax)bz);
    }

    public void b(cy cy, ax ax1)
        throws cf
    {
        cy = (de)cy;
        BitSet bitset = cy.b(11);
        if (bitset.get(0))
        {
            ax1.a = cy.w();
            ax1.a(true);
        }
        if (bitset.get(1))
        {
            ax1.b = cy.z();
            ax1.b(true);
        }
        if (bitset.get(2))
        {
            ax1.c = cy.z();
            ax1.c(true);
        }
        if (bitset.get(3))
        {
            ax1.d = cy.y();
            ax1.d(true);
        }
        if (bitset.get(4))
        {
            ax1.e = cy.y();
            ax1.e(true);
        }
        if (bitset.get(5))
        {
            ax1.f = cy.z();
            ax1.f(true);
        }
        if (bitset.get(6))
        {
            ax1.g = cy.w();
            ax1.g(true);
        }
        if (bitset.get(7))
        {
            ax1.h = cy.z();
            ax1.h(true);
        }
        if (bitset.get(8))
        {
            ax1.i = ag.a(cy.w());
            ax1.i(true);
        }
        if (bitset.get(9))
        {
            ax1.j = cy.z();
            ax1.j(true);
        }
        if (bitset.get(10))
        {
            ax1.k = new bg();
            ax1.k.a(cy);
            ax1.k(true);
        }
    }

    public void b(cy cy, bz bz)
        throws cf
    {
        a(cy, (ax)bz);
    }

    private itSet()
    {
    }

    itSet(itSet itset)
    {
        this();
    }
}
