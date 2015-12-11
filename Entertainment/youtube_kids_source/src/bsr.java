// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.TimeUnit;

public final class bsr
    implements coi
{

    private final dsx a;

    public bsr(dsx dsx1)
    {
        a = dsx1;
    }

    public final int a()
    {
        if (a == null)
        {
            return 60;
        } else
        {
            return a.a;
        }
    }

    public final boolean b()
    {
        if (a == null)
        {
            return true;
        } else
        {
            return a.b;
        }
    }

    static 
    {
        TimeUnit.DAYS.toHours(30L);
    }
}
