// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import android.view.View;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.inmobi.ads:
//            m, o, s

class nit>
    implements nit>
{

    final m a;

    public void a(List list, List list1)
    {
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            View view = (View)list.next();
            o o1 = (o)m.a(a).get(view);
            if (o1 == null)
            {
                a.a(view);
            } else
            {
                s s1 = (s)m.b(a).get(view);
                if (s1 == null || !o1.equals(s1.a))
                {
                    m.b(a).put(view, new s(o1));
                }
            }
        } while (true);
        for (list = list1.iterator(); list.hasNext(); m.b(a).remove(list1))
        {
            list1 = (View)list.next();
        }

        a.c();
    }

    (m m1)
    {
        a = m1;
        super();
    }
}
