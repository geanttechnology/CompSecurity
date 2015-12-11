// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;


// Referenced classes of package com.google.analytics.tracking.android:
//            ae, aw

final class ah
    implements Runnable
{

    final ae a;

    ah(ae ae1)
    {
        a = ae1;
        super();
    }

    public final void run()
    {
        ae.f(a).d();
    }
}
