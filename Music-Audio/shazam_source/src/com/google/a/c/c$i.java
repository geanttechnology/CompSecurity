// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import java.util.Collection;
import java.util.Set;

// Referenced classes of package com.google.a.c:
//            c, be

private final class n extends n
    implements Set
{

    final c a;

    public final boolean removeAll(Collection collection)
    {
        boolean flag;
        if (collection.isEmpty())
        {
            flag = false;
        } else
        {
            int j = size();
            boolean flag1 = be.a((Set)c, collection);
            flag = flag1;
            if (flag1)
            {
                int k = c.size();
                c.a(a, k - j);
                b();
                return flag1;
            }
        }
        return flag;
    }

    n(c c1, Object obj, Set set)
    {
        a = c1;
        super(c1, obj, set, null);
    }
}
