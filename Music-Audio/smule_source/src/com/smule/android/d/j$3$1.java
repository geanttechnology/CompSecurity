// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.d;

import android.os.Handler;
import java.util.List;

// Referenced classes of package com.smule.android.d:
//            o, p, q, j, 
//            i

class b
    implements Runnable
{

    final p a;
    final q b;
    final b c;

    public void run()
    {
        c.c.a(a, b);
    }

    ( , p p, q q)
    {
        c = ;
        a = p;
        b = q;
        super();
    }

    // Unreferenced inner class com/smule/android/d/j$3

/* anonymous class */
    class j._cls3
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
                d.post(new j._cls3._cls1(this, p1, q));
            }
            return;
            i k;
            k;
            k = k.a();
            if (true) goto _L2; else goto _L1
_L1:
        }

            
            {
                e = j1;
                a = flag;
                b = list;
                c = o1;
                d = handler;
                super();
            }
    }

}
