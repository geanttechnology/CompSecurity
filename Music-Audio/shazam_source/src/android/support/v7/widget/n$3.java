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
        clerView.u u;
        n n1;
        ad ad1;
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ad1.a(1.0F).a(((clerView.e) (n1)).i).a(new <init>(n1, u, ad1)).b())
        {
            u = (clerView.u)iterator.next();
            n1 = b;
            ad1 = w.n(u.a);
            n1.d.add(u);
        }

        a.clear();
        b.a.remove(a);
    }

    clerView.e(n n1, ArrayList arraylist)
    {
        b = n1;
        a = arraylist;
        super();
    }
}
