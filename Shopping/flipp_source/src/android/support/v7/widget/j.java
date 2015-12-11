// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v4.view.ap;
import android.support.v4.view.cj;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package android.support.v7.widget:
//            bi, g, aq, l

final class j
    implements Runnable
{

    final ArrayList a;
    final g b;

    j(g g1, ArrayList arraylist)
    {
        b = g1;
        a = arraylist;
        super();
    }

    public final void run()
    {
        bi bi1;
        g g1;
        Object obj;
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((cj) (obj)).a(1.0F).a(((aq) (g1)).i).a(new l(g1, bi1, ((cj) (obj)))).b())
        {
            bi1 = (bi)iterator.next();
            g1 = b;
            obj = bi1.a;
            g1.d.add(bi1);
            obj = ap.o(((android.view.View) (obj)));
        }

        a.clear();
        b.a.remove(a);
    }
}
