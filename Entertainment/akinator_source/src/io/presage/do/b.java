// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.do;

import io.presage.utils.m;
import java.util.Map;

public final class b
{

    private String a;

    public b(Map map)
    {
        if (map != null)
        {
            a = m.a(map.get("id"));
        }
    }

    public final String a()
    {
        return a;
    }
}
