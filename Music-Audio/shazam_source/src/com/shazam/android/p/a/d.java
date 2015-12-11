// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.p.a;

import java.util.Map;

// Referenced classes of package com.shazam.android.p.a:
//            c

public final class d
    implements c
{

    private final Map a;
    private final c b;

    public d(Map map, c c1)
    {
        a = map;
        b = c1;
    }

    public final boolean a(String s)
    {
        Boolean boolean2 = (Boolean)a.get(s);
        Boolean boolean1 = boolean2;
        if (boolean2 == null)
        {
            boolean1 = Boolean.valueOf(b.a(s));
            a.put(s, boolean1);
        }
        return boolean1.booleanValue();
    }
}
