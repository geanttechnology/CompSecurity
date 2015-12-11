// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.a;

import e.c.d;
import e.c.e;
import e.c.f;
import e.c.g;
import e.j;

// Referenced classes of package e.d.a:
//            ae, ag, ah

public final class ad
    implements d
{

    private f a;

    public ad(e e)
    {
        a = g.a(e);
    }

    public final Object a(Object obj)
    {
        obj = (j)obj;
        ae ae1 = new ae(((j) (obj)), a);
        ag ag1 = new ag(ae1);
        ((j) (obj)).a(ag1);
        return new ah(this, ((j) (obj)), ae1, ag1);
    }
}
