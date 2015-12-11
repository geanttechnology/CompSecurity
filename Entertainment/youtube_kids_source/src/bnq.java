// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collections;
import java.util.Map;

public final class bnq
{

    private Map a;

    bnq(Map map)
    {
        a = Collections.unmodifiableMap(map);
    }

    public final bnw a(String s)
    {
        return (bnw)a.get(s);
    }
}
