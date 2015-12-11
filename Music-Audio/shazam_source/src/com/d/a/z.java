// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.d.a;

import java.util.LinkedHashMap;

// Referenced classes of package com.d.a:
//            m

final class z extends LinkedHashMap
{

    private m a;

    z(m m1, int i)
    {
        a = m1;
        super(i, 0.75F, true);
    }

    protected final boolean removeEldestEntry(java.util.Map.Entry entry)
    {
        return size() > a.a;
    }
}
