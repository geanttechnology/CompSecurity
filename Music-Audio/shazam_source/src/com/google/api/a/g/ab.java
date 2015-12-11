// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.g;

import com.google.api.a.f.a.a.a.a.c;
import com.google.api.a.f.a.a.a.a.d;

public final class ab
{

    public static RuntimeException a(Throwable throwable)
    {
        Throwable throwable1 = (Throwable)c.a(throwable);
        d.a(throwable1, java/lang/Error);
        d.a(throwable1, java/lang/RuntimeException);
        throw new RuntimeException(throwable);
    }
}
