// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.android.gms.d:
//            kf

public static final class <init>
{

    public final List a;
    public final Map b;
    public final String c;
    private final int d;

    public final String toString()
    {
        return (new StringBuilder("Rules: ")).append(a).append("  Macros: ").append(b).toString();
    }

    private (List list, Map map, String s, int i)
    {
        a = Collections.unmodifiableList(list);
        b = Collections.unmodifiableMap(map);
        c = s;
        d = i;
    }

    d(List list, Map map, String s, int i, byte byte0)
    {
        this(list, map, s, i);
    }
}
