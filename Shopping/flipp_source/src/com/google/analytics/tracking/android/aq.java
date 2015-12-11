// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.analytics.tracking.android:
//            ai, aj

public final class aq
{

    private Map a;

    public aq()
    {
        a = new HashMap();
    }

    public final aq a(String s, String s1)
    {
        ai.a().a(aj.a);
        a.put(s, s1);
        return this;
    }

    public final Map a()
    {
        return new HashMap(a);
    }
}
