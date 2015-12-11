// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.w;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class t
{

    final long a = 0L;
    final String b;
    final String c;
    final boolean d;
    long e;
    final Map f;

    public t(String s, String s1, boolean flag, long l, Map map)
    {
        w.a(s);
        w.a(s1);
        b = s;
        c = s1;
        d = flag;
        e = l;
        if (map != null)
        {
            f = new HashMap(map);
            return;
        } else
        {
            f = Collections.emptyMap();
            return;
        }
    }
}
