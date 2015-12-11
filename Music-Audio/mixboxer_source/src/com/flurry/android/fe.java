// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


// Referenced classes of package com.flurry.android:
//            ay

final class fe
    implements Thread.UncaughtExceptionHandler
{

    private ay gN;

    fe(ay ay1)
    {
        this(ay1, (byte)0);
    }

    private fe(ay ay1, byte byte0)
    {
        gN = ay1;
        super();
    }

    public final void uncaughtException(Thread thread, Throwable throwable)
    {
        if (gN.isEnabled())
        {
            ay.a(gN, thread, throwable);
        }
        ay.b(gN, thread, throwable);
    }
}
