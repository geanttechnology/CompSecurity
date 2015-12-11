// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            ah, ac, aj, q, 
//            as, s

final class nit> extends ah
{

    final ac a;

    final void a()
    {
        as as1 = n.e;
        aj.b.b("AdColony suspending");
        q.i = true;
        if (!as1.b)
        {
            aj.d.b("AdColony.onPause() called without initial call to onResume().");
        }
        as1.b = false;
        as1.c = true;
        as1.g = s.b();
        as1.a();
    }

    (ac ac1, ac ac2)
    {
        a = ac1;
        super(ac2);
    }
}
