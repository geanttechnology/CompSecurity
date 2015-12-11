// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.HashMap;

public final class bnr
{

    private final HashMap a = new HashMap();

    public bnr()
    {
    }

    public final bnq a()
    {
        return new bnq(a);
    }

    public final bnr a(String s, bnw bnw)
    {
        a.put(s, bnw);
        return this;
    }
}
