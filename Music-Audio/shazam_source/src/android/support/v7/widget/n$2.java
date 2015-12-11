// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v4.view.ad;
import android.support.v4.view.w;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package android.support.v7.widget:
//            n

final class a
    implements Runnable
{

    final ArrayList a;
    final n b;

    public final void run()
    {
        Iterator iterator = a.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            a a1 = (a)iterator.next();
            n n1 = b;
            Object obj = a1.a;
            Object obj1;
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = ((clerView.u) (obj)).a;
            }
            obj1 = a1.b;
            if (obj1 != null)
            {
                obj1 = ((clerView.u) (obj1)).a;
            } else
            {
                obj1 = null;
            }
            if (obj != null)
            {
                obj = w.n(((android.view.View) (obj))).a(((clerView.e) (n1)).l);
                n1.g.add(a1.a);
                ((ad) (obj)).b(a1.e - a1.c);
                ((ad) (obj)).c(a1.f - a1.d);
                ((ad) (obj)).a(0.0F).a(new <init>(n1, a1, ((ad) (obj)))).b();
            }
            if (obj1 != null)
            {
                obj = w.n(((android.view.View) (obj1)));
                n1.g.add(a1.b);
                ((ad) (obj)).b(0.0F).c(0.0F).a(((clerView.e) (n1)).l).a(1.0F).a(new <init>(n1, a1, ((ad) (obj)), ((android.view.View) (obj1)))).b();
            }
        } while (true);
        a.clear();
        b.c.remove(a);
    }

    clerView.e(n n1, ArrayList arraylist)
    {
        b = n1;
        a = arraylist;
        super();
    }
}
