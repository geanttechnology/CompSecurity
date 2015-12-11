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
        a a1;
        for (Iterator iterator = a.iterator(); iterator.hasNext(); r.a(b, a1))
        {
            a1 = (b)iterator.next();
        }

        a.clear();
        r.b(b).remove(a);
    }

    (r r1, ArrayList arraylist)
    {
        b = r1;
        a = arraylist;
        super();
    }
}
