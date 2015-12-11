// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.b;

import android.os.SystemClock;

public final class c
{

    public static int b = 89;
    public static int c = 1;
    public static int d = 2;
    public static int e;
    public long a;

    public c()
    {
        int i = b;
        switch ((i * (c + i)) % d)
        {
        default:
            b = 10;
            c = 87;
            break;

        case 0: // '\0'
            break;
        }
        try
        {
            super();
            return;
        }
        catch (Exception exception)
        {
            throw exception;
        }
    }

    public final void a()
    {
        if (((b + c) * b) % d != e)
        {
            b = 81;
            e = 31;
        }
        a = SystemClock.elapsedRealtime();
    }
}
