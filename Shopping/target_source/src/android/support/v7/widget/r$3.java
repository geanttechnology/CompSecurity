// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package android.support.v7.widget:
//            r

class a
    implements Runnable
{

    final ArrayList a;
    final r b;

    public void run()
    {
        clerView.t t;
        for (Iterator iterator = a.iterator(); iterator.hasNext(); r.a(b, t))
        {
            t = (clerView.t)iterator.next();
        }

        a.clear();
        r.c(b).remove(a);
    }

    clerView.t(r r1, ArrayList arraylist)
    {
        b = r1;
        a = arraylist;
        super();
    }
}
