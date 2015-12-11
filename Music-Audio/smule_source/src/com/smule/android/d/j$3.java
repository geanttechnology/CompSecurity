// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.d;

import android.os.Handler;
import java.util.List;

// Referenced classes of package com.smule.android.d:
//            j, i, p, o, 
//            q

class d
    implements Runnable
{

    final boolean a;
    final List b;
    final o c;
    final Handler d;
    final j e;

    public void run()
    {
        q q;
        p p1;
        p1 = new p(0, "Inventory refresh successful.");
        q = null;
        q q1 = e.a(a, b);
        q = q1;
_L2:
        e.c();
        if (!e.d && c != null)
        {
            d.post(new Runnable(p1, q) {

                final p a;
                final q b;
                final j._cls3 c;

                public void run()
                {
                    c.c.a(a, b);
                }

            
            {
                c = j._cls3.this;
                a = p1;
                b = q;
                super();
            }
            });
        }
        return;
        i k;
        k;
        k = k.a();
        if (true) goto _L2; else goto _L1
_L1:
    }

    _cls1.b(j j1, boolean flag, List list, o o, Handler handler)
    {
        e = j1;
        a = flag;
        b = list;
        c = o;
        d = handler;
        super();
    }
}
