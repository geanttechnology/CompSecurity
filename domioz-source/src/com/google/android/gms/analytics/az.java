// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;


// Referenced classes of package com.google.android.gms.analytics:
//            ay, n

final class az
    implements Runnable
{

    final ay a;

    private az(ay ay1)
    {
        a = ay1;
        super();
    }

    az(ay ay1, byte byte0)
    {
        this(ay1);
    }

    public final void run()
    {
        ay.a(a).b();
    }
}
