// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.b;

import android.content.Intent;
import java.util.UUID;

public final class a
{

    private static a d;
    public UUID a;
    public Intent b;
    int c;

    public a(int i)
    {
        this(i, UUID.randomUUID());
    }

    private a(int i, UUID uuid)
    {
        a = uuid;
        c = i;
    }

    static boolean a(a a1)
    {
        com/facebook/b/a;
        JVM INSTR monitorenter ;
        a a2;
        a2 = d;
        d = a1;
        boolean flag;
        if (a2 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        com/facebook/b/a;
        JVM INSTR monitorexit ;
        return flag;
        a1;
        throw a1;
    }
}
