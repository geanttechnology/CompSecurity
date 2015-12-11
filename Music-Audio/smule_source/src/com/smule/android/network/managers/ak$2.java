// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.smule.android.f.j;
import com.smule.android.f.k;
import com.smule.android.network.core.b;

// Referenced classes of package com.smule.android.network.managers:
//            ak, am, al

class c extends k
{

    final boolean a;
    final am b;
    final al c;
    final ak d;

    static k a(c c1)
    {
        return c1.h;
    }

    public void a(j j)
    {
        (new Thread(new Runnable(j) {

            final j a;
            final ak._cls2 b;

            public void run()
            {
                ak.a().a(com.smule.android.network.core.b.d().e(), b.a, b.b, b.c);
                a.b(ak._cls2.a(b));
            }

            
            {
                b = ak._cls2.this;
                a = j1;
                super();
            }
        })).start();
    }

    _cls1.a(ak ak1, boolean flag, am am, al al)
    {
        d = ak1;
        a = flag;
        b = am;
        c = al;
        super();
    }
}
