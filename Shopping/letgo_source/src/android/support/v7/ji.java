// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Intent;
import java.util.UUID;

public class ji
{

    private static ji a;
    private UUID b;
    private Intent c;
    private int d;

    public ji(int i)
    {
        this(i, UUID.randomUUID());
    }

    public ji(int i, UUID uuid)
    {
        b = uuid;
        d = i;
    }

    public static ji a()
    {
        return a;
    }

    public static ji a(UUID uuid, int i)
    {
        android/support/v7/ji;
        JVM INSTR monitorenter ;
        ji ji1 = a();
        if (ji1 == null) goto _L2; else goto _L1
_L1:
        if (!ji1.c().equals(uuid)) goto _L2; else goto _L3
_L3:
        int j = ji1.d();
        if (j == i) goto _L4; else goto _L2
_L2:
        uuid = null;
_L6:
        android/support/v7/ji;
        JVM INSTR monitorexit ;
        return uuid;
_L4:
        a(((ji) (null)));
        uuid = ji1;
        if (true) goto _L6; else goto _L5
_L5:
        uuid;
        throw uuid;
    }

    private static boolean a(ji ji1)
    {
        android/support/v7/ji;
        JVM INSTR monitorenter ;
        ji ji2;
        ji2 = a();
        a = ji1;
        boolean flag;
        if (ji2 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        android/support/v7/ji;
        JVM INSTR monitorexit ;
        return flag;
        ji1;
        throw ji1;
    }

    public void a(Intent intent)
    {
        c = intent;
    }

    public Intent b()
    {
        return c;
    }

    public UUID c()
    {
        return b;
    }

    public int d()
    {
        return d;
    }

    public boolean e()
    {
        return a(this);
    }
}
