// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.f;

import com.google.a.c.aw;
import java.util.Comparator;
import java.util.Map;

// Referenced classes of package com.google.a.f:
//            c

static final class it> extends aw
{

    final Comparator a;
    final Map b;

    public final int compare(Object obj, Object obj1)
    {
        return a.compare(b.get(obj), b.get(obj1));
    }

    (Comparator comparator, Map map)
    {
        a = comparator;
        b = map;
        super();
    }
}
