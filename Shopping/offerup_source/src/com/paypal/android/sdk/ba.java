// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;

public final class ba
{

    private String a;
    private String b;
    private Map c;

    public ba(String s, String s1)
    {
        c = new HashMap();
        a = s;
        b = s1;
    }

    public final String a()
    {
        return a;
    }

    public final String b()
    {
        return b;
    }

    public final Map c()
    {
        return c;
    }

    public final String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append("(").append(a).append(",mEndpoints=").append(c).append(")").toString();
    }
}
