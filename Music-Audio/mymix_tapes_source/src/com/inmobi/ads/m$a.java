// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.inmobi.ads:
//            m, s, o

class nit>
    implements Runnable
{

    final m a;
    private final ArrayList b = new ArrayList();

    public void run()
    {
        Iterator iterator = m.b(a).entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (java.util.Entry)iterator.next();
            View view = (View)((java.util.Entry) (obj)).getKey();
            obj = (s)((java.util.Entry) (obj)).getValue();
            if (m.d(a).a(((s) (obj)).b, m.c(a).b()))
            {
                ((o)((s) (obj)).a).A();
                b.add(view);
            }
        } while (true);
        View view1;
        for (Iterator iterator1 = b.iterator(); iterator1.hasNext(); a.a(view1))
        {
            view1 = (View)iterator1.next();
        }

        b.clear();
        if (!m.b(a).isEmpty())
        {
            a.c();
        }
    }

    (m m1)
    {
        a = m1;
        super();
    }
}
