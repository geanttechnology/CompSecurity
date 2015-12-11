// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.f;

import java.util.LinkedHashMap;
import java.util.Map;

// Referenced classes of package com.gimbal.internal.proximity.core.f:
//            e

public final class a
    implements e
{

    private Map a;

    public a()
    {
        a = new LinkedHashMap();
    }

    public final Object a(String s, Class class1)
    {
        return a.get(s);
    }

    public final void a()
    {
        a.clear();
    }

    public final void a(String s)
    {
        a.remove(s);
    }

    public final void a(String s, Object obj)
    {
        a.put(s, obj);
    }

    public final int b()
    {
        return a.size();
    }
}
