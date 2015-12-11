// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v4.view.ap;
import android.support.v4.view.cj;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package android.support.v7.widget:
//            q, bi, g, aq, 
//            m

final class h
    implements Runnable
{

    final ArrayList a;
    final g b;

    h(g g1, ArrayList arraylist)
    {
        b = g1;
        a = arraylist;
        super();
    }

    public final void run()
    {
        g g1;
        bi bi1;
        Object obj;
        int i;
        int k;
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((cj) (obj)).a(((aq) (g1)).k).a(new m(g1, bi1, k, i, ((cj) (obj)))).b())
        {
            obj = (q)iterator.next();
            g1 = b;
            bi1 = ((q) (obj)).a;
            k = ((q) (obj)).b;
            i = ((q) (obj)).c;
            int l = ((q) (obj)).d;
            int j = ((q) (obj)).e;
            obj = bi1.a;
            k = l - k;
            i = j - i;
            if (k != 0)
            {
                ap.o(((android.view.View) (obj))).b(0.0F);
            }
            if (i != 0)
            {
                ap.o(((android.view.View) (obj))).c(0.0F);
            }
            g1.e.add(bi1);
            obj = ap.o(((android.view.View) (obj)));
        }

        a.clear();
        b.b.remove(a);
    }
}
