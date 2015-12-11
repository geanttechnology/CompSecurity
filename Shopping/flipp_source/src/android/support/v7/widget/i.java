// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v4.view.ap;
import android.support.v4.view.cj;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package android.support.v7.widget:
//            p, bi, g, aq, 
//            n, o

final class i
    implements Runnable
{

    final ArrayList a;
    final g b;

    i(g g1, ArrayList arraylist)
    {
        b = g1;
        a = arraylist;
        super();
    }

    public final void run()
    {
        Iterator iterator = a.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            p p1 = (p)iterator.next();
            g g1 = b;
            Object obj = p1.a;
            Object obj1;
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = ((bi) (obj)).a;
            }
            obj1 = p1.b;
            if (obj1 != null)
            {
                obj1 = ((bi) (obj1)).a;
            } else
            {
                obj1 = null;
            }
            if (obj != null)
            {
                g1.g.add(p1.a);
                obj = ap.o(((android.view.View) (obj))).a(((aq) (g1)).l);
                ((cj) (obj)).b(p1.e - p1.c);
                ((cj) (obj)).c(p1.f - p1.d);
                ((cj) (obj)).a(0.0F).a(new n(g1, p1, ((cj) (obj)))).b();
            }
            if (obj1 != null)
            {
                g1.g.add(p1.b);
                obj = ap.o(((android.view.View) (obj1)));
                ((cj) (obj)).b(0.0F).c(0.0F).a(((aq) (g1)).l).a(1.0F).a(new o(g1, p1, ((cj) (obj)), ((android.view.View) (obj1)))).b();
            }
        } while (true);
        a.clear();
        b.c.remove(a);
    }
}
