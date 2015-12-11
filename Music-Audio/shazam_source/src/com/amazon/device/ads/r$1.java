// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.ArrayList;

// Referenced classes of package com.amazon.device.ads:
//            dp, r, cm, di, 
//            af, dn, ba, k

final class init> extends dp
{

    final int a;
    final af b;
    final ArrayList c;
    final r d;

    protected final void a()
    {
        cm cm1 = r.a(d);
        di di1 = cm1.d;
          = new (di1);
        di1.a.a();
        cm1.e = true;
        r.a(d, a, b, c);
    }

    protected final void b()
    {
        r.b(d).a(new Runnable() {

            final r._cls1 a;

            public final void run()
            {
                k k1 = new k(k.a.a, "The configuration was unable to be loaded");
                r.a(a.d, k1, a.c);
            }

            
            {
                a = r._cls1.this;
                super();
            }
        }, .a, .a);
    }

    _cls1.a(r r1, dn dn, ba ba, int i, af af, ArrayList arraylist)
    {
        d = r1;
        a = i;
        b = af;
        c = arraylist;
        super(dn, ba);
    }
}
