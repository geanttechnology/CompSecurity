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
//            t

class nit>
    implements Runnable
{

    final t a;
    private final ArrayList b = new ArrayList();
    private final ArrayList c = new ArrayList();

    public void run()
    {
        t.a(a, false);
        for (Iterator iterator = t.a(a).entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Entry entry = (java.util.Entry)iterator.next();
            View view = (View)entry.getKey();
            int i = ((Key)entry.getValue()).a;
            if (t.b(a).a(view, i))
            {
                b.add(view);
            } else
            {
                c.add(view);
            }
        }

        if (t.c(a) != null)
        {
            t.c(a).a(b, c);
        }
        b.clear();
        c.clear();
        a.c();
    }

    (t t1)
    {
        a = t1;
        super();
    }
}
