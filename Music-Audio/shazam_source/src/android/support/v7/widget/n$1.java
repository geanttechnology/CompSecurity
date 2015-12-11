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
        n n1;
        clerView.u u;
        Object obj;
        int i;
        int k;
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((ad) (obj)).a(((clerView.e) (n1)).k).a(new <init>(n1, u, k, i, ((ad) (obj)))).b())
        {
            obj = (clerView.u)iterator.next();
            n1 = b;
            u = ((b) (obj)).a;
            k = ((a) (obj)).b;
            i = ((b) (obj)).c;
            int l = ((c) (obj)).d;
            int j = ((d) (obj)).e;
            obj = u.a;
            k = l - k;
            i = j - i;
            if (k != 0)
            {
                w.n(((android.view.View) (obj))).b(0.0F);
            }
            if (i != 0)
            {
                w.n(((android.view.View) (obj))).c(0.0F);
            }
            obj = w.n(((android.view.View) (obj)));
            n1.e.add(u);
        }

        a.clear();
        b.b.remove(a);
    }

    clerView.e(n n1, ArrayList arraylist)
    {
        b = n1;
        a = arraylist;
        super();
    }
}
