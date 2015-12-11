// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;


// Referenced classes of package u.aly:
//            di, cj, cf, cy, 
//            ct, cz, bz

private static class <init> extends di
{

    public volatile void a(cy cy1, bz bz)
        throws cf
    {
        a(cy1, (cj)bz);
    }

    public void a(cy cy1, cj cj1)
        throws cf
    {
        cj1.c = null;
        cj1.b = null;
        cy1.j();
        ct ct1 = cy1.l();
        cj1.b = cj1.a(cy1, ct1);
        if (cj1.b != null)
        {
            cj1.c = cj1.b(ct1.c);
        }
        cy1.m();
        cy1.l();
        cy1.k();
    }

    public volatile void b(cy cy1, bz bz)
        throws cf
    {
        b(cy1, (cj)bz);
    }

    public void b(cy cy1, cj cj1)
        throws cf
    {
        if (cj1.j() == null || cj1.k() == null)
        {
            throw new cz("Cannot write a TUnion with no set value!");
        } else
        {
            cy1.a(cj1.c());
            cy1.a(cj1.a(cj1.c));
            cj1.c(cy1);
            cy1.c();
            cy1.d();
            cy1.b();
            return;
        }
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
