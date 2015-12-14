// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.metrics;

import java.util.HashMap;
import java.util.Map;

public abstract class MetricsHelper
{

    public MetricsHelper()
    {
    }

    public static Map createMetricsExtra(String s, String s1, String s2)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("eventName", s);
        if (s1 != null)
        {
            hashmap.put("tag", s1);
        }
        if (s2 != null)
        {
            hashmap.put("pageName", s2);
        }
        return hashmap;
    }
}
