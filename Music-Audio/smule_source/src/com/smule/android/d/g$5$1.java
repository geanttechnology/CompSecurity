// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.d;

import com.smule.android.f.q;
import com.smule.android.network.core.b;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.smule.android.d:
//            g, o, p, q, 
//            f, c, r, e, 
//            t

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        g.a(a.a, Boolean.valueOf(true));
    }

    b(b b)
    {
        a = b;
        super();
    }

    // Unreferenced inner class com/smule/android/d/g$5

/* anonymous class */
    class g._cls5
        implements o
    {

        final g a;

        public void a(p p1, com.smule.android.d.q q1)
        {
            if (p1.c())
            {
                Object obj = q1.b("subs");
                if (((List) (obj)).size() == 0)
                {
                    g.a(a, Boolean.valueOf(false));
                } else
                {
                    q q2 = new q(((List) (obj)).size(), new g._cls5._cls1(this));
                    obj = ((List) (obj)).iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        b.a(new g._cls5._cls2(q1.a((String)((Iterator) (obj)).next()), q2));
                    }
                }
            }
            if (com.smule.android.d.g.b(a) != null)
            {
                com.smule.android.d.g.b(a).b(f.a(p1.a()));
            }
        }

            
            {
                a = g1;
                super();
            }

        // Unreferenced inner class com/smule/android/d/g$5$2

/* anonymous class */
        class g._cls5._cls2
            implements Runnable
        {

            final r a;
            final q b;
            final g._cls5 c;

            public void run()
            {
                t.a(e.a(a.e()), a.c(), a.b(), a.d(), a.h(), a.i());
                b.a();
                return;
                Exception exception;
                exception;
                b.a();
                throw exception;
            }

                    
                    {
                        c = g._cls5.this;
                        a = r1;
                        b = q1;
                        super();
                    }
        }

    }

}
