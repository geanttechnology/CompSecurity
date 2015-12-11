// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.b;

import c.a.a.a.e;
import c.a.a.a.q;

// Referenced classes of package c.a.a.a.a.b:
//            k, c, b

final class d extends k
{

    private b a;
    private c b;

    d(c c1, b b1)
    {
        b = c1;
        a = b1;
        super();
    }

    public final void onRun()
    {
        b b1 = c.a(b);
        if (!a.equals(b1))
        {
            e.d().a("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
            c.a(b, b1);
        }
    }
}
