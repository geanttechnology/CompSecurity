// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import java.util.Collections;
import java.util.Map;

// Referenced classes of package com.google.android.gms.d:
//            kf

public static final class <init>
{

    public final Map a;
    public final ng b;

    public final String toString()
    {
        return (new StringBuilder("Properties: ")).append(Collections.unmodifiableMap(a)).append(" pushAfterEvaluate: ").append(b).toString();
    }

    private (Map map,  )
    {
        a = map;
        b = ;
    }

    b(Map map, b b1, byte byte0)
    {
        this(map, b1);
    }
}
