// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.d.a;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

// Referenced classes of package com.mopub.d.a:
//            g

final class init>
    implements Runnable
{

    final g a;

    public final void run()
    {
        for (Iterator iterator = a.c.values().iterator(); iterator.hasNext();)
        {
              = (.hasNext)iterator.next();
            Iterator iterator1 = .c.iterator();
            while (iterator1.hasNext()) 
            {
                 1 = (.hasNext)iterator1.next();
                if (1.b != null)
                {
                    if (.b == null)
                    {
                        1.a = .a;
                        1.b.a(1);
                    } else
                    {
                        1.b.a(.b);
                    }
                }
            }
        }

        a.c.clear();
        a.d = null;
    }

    st(g g1)
    {
        a = g1;
        super();
    }
}
