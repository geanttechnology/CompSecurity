// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.d;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.smule.android.d:
//            r, p, k, j, 
//            i, l

class a
    implements Runnable
{

    final List a;
    final a b;

    public void run()
    {
        b.b.a((r)b.b.get(0), (p)a.get(0));
    }

    a(a a1, List list)
    {
        b = a1;
        a = list;
        super();
    }

    // Unreferenced inner class com/smule/android/d/j$4

/* anonymous class */
    class j._cls4
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
                catch (i l)
                {
                    arraylist.add(l.a());
                }
            }

            e.c();
            if (!e.d && b != null)
            {
                c.post(new j._cls4._cls1(this, arraylist));
            }
            if (!e.d && d != null)
            {
                c.post(new j._cls4._cls2(arraylist));
            }
        }

            
            {
                e = j1;
                a = list;
                b = k1;
                c = handler;
                d = l;
                super();
            }

        // Unreferenced inner class com/smule/android/d/j$4$2

/* anonymous class */
        class j._cls4._cls2
            implements Runnable
        {

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
        }

    }

}
