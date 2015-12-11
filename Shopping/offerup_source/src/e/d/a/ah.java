// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.a;

import e.j;

// Referenced classes of package e.d.a:
//            ae, ag, ad

final class ah extends j
{

    private j a;
    private ae b;
    private ag c;
    private boolean d;

    public ah(ad ad, j j1, ae ae1, ag ag)
    {
        super(j1);
        d = false;
        a = j1;
        b = ae1;
        c = ag;
    }

    public final void a()
    {
        if (!d)
        {
            a.a();
        }
    }

    public final volatile void a(Object obj)
    {
        obj = (e.a[])obj;
        if (obj == null || obj.length == 0)
        {
            a.a();
            return;
        } else
        {
            d = true;
            b.a(((e.a []) (obj)), c);
            return;
        }
    }

    public final void a(Throwable throwable)
    {
        a.a(throwable);
    }
}
