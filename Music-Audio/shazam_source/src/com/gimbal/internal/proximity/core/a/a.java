// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.a;

import android.content.Context;

public final class a
{

    public static a b;
    public Context a;

    private a(Context context)
    {
        a = context;
    }

    public static a a(Context context)
    {
        com/gimbal/internal/proximity/core/a/a;
        JVM INSTR monitorenter ;
        if (b == null)
        {
            b = new a(context);
        }
        context = b;
        com/gimbal/internal/proximity/core/a/a;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }
}
