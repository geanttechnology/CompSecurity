// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.service;


public final class r
{

    private static r a = null;
    private android.os.PowerManager.WakeLock b;

    private r()
    {
        b = null;
    }

    public static r a()
    {
        if (a == null)
        {
            a = new r();
        }
        return a;
    }

    public final void a(android.os.PowerManager.WakeLock wakelock)
    {
        b = wakelock;
    }

    public final android.os.PowerManager.WakeLock b()
    {
        return b;
    }

}
