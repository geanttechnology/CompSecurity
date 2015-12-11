// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.g;

import com.google.api.a.f.a.a.a.a.a;

public final class n
{

    private final a a;

    private n(a a1)
    {
        a = a1;
    }

    public static n a()
    {
        return new n(new a(" "));
    }

    public final String a(Iterable iterable)
    {
        a a1 = a;
        iterable = iterable.iterator();
        return a1.a(new StringBuilder(), iterable).toString();
    }
}
