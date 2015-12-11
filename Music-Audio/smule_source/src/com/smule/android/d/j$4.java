// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.d;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.smule.android.d:
//            j, i, r, p, 
//            k, l

class d
    implements Runnable
{

    final List a;
    final k b;
    final Handler c;
    final l d;
    final j e;

    public void run()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = a.iterator(); iterator.hasNext();)
        {
            r r1 = (r)iterator.next();
            try
            {
                e.a(r1);
                arraylist.add(new p(0, (new StringBuilder()).append("Successful consume of sku ").append(r1.c()).toString()));
            }
            catch (i k)
            {
                arraylist.add(k.a());
            }
        }

        e.c();
        if (!e.d && b != null)
        {
            c.post(new Runnable(arraylist) {

                final List a;
                final j._cls4 b;

                public void run()
                {
                    b.b.a((r)b.a.get(0), (p)a.get(0));
                }

            
            {
                b = j._cls4.this;
                a = list;
                super();
            }
            });
        }
        if (!e.d && d != null)
        {
            c.post(new Runnable(arraylist) {

                final List a;
                final j._cls4 b;

                public void run()
                {
                    b.d.a(b.a, a);
                }

            
            {
                b = j._cls4.this;
                a = list;
                super();
            }
            });
        }
    }

    _cls2.a(j j1, List list, k k, Handler handler, l l)
    {
        e = j1;
        a = list;
        b = k;
        c = handler;
        d = l;
        super();
    }
}
