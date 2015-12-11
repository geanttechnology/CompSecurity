// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


// Referenced classes of package com.flurry.android:
//            cy

abstract class fp
    implements Runnable
{

    public fp()
    {
    }

    public abstract void c();

    public final void run()
    {
        try
        {
            c();
            return;
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            cy.b("FlurryAgent", "", throwable);
            return;
        }
    }
}
