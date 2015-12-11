// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.rest;

import com.gimbal.a.a;
import com.gimbal.internal.persistance.b;

public class c
{

    private final a a = com.gimbal.internal.c.c.e(com/gimbal/internal/rest/c.getSimpleName());
    private b b;

    public c(b b1)
    {
        b = b1;
    }

    public final String a(String s)
    {
        return String.format("%s%s%s", new Object[] {
            b.c(), "", s
        });
    }
}
