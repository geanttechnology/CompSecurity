// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.d;

import com.smule.android.f.q;
import com.smule.android.network.core.b;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.smule.android.d:
//            o, g, p, q, 
//            f, c, r, e, 
//            t

class a
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
                q q2 = new q(((List) (obj)).size(), new Runnable() {

                    final g._cls5 a;

                    public void run()
                    {
                        g.a(a.a, Boolean.valueOf(true));
                    }

            
            {
                a = g._cls5.this;
                super();
            }
                });
                obj = ((List) (obj)).iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    b.a(new Runnable(q1.a((String)((Iterator) (obj)).next()), q2) {

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
                    });
                }
            }
        }
        if (com.smule.android.d.g.b(a) != null)
        {
            com.smule.android.d.g.b(a).b(f.a(p1.a()));
        }
    }

    _cls2.b(g g1)
    {
        a = g1;
        super();
    }
}
