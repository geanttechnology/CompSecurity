// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

// Referenced classes of package com.tapjoy.internal:
//            aw, as, au

public final class ax extends aw
{

    private final LinkedHashMap a = new LinkedHashMap(0, 0.75F, true);
    private int b;

    public ax()
    {
        b = 10;
    }

    private void a()
    {
        int i = a.size() - b;
        if (i > 0)
        {
            for (Iterator iterator = a.entrySet().iterator(); i > 0 && iterator.hasNext(); iterator.remove())
            {
                i--;
                iterator.next();
            }

        }
    }

    protected final au a(Object obj, boolean flag)
    {
        as as2 = (as)a.get(obj);
        as as1 = as2;
        if (as2 == null)
        {
            as1 = as2;
            if (flag)
            {
                as1 = new as(obj);
                a.put(obj, as1);
                a();
            }
        }
        return as1;
    }

    public final void a(Object obj, Object obj1)
    {
        super.a(obj, obj1);
        a();
    }
}
