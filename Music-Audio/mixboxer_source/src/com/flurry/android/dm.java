// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


// Referenced classes of package com.flurry.android:
//            FlurryAgent, cy

final class dm
    implements Thread.UncaughtExceptionHandler
{

    dm()
    {
        this((byte)0);
    }

    private dm(byte byte0)
    {
    }

    public final void uncaughtException(Thread thread, Throwable throwable)
    {
        try
        {
            FlurryAgent.an.a(throwable);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Thread thread)
        {
            cy.b("FlurryAgent", "Failed to handle uncaught exception", thread);
        }
    }
}
