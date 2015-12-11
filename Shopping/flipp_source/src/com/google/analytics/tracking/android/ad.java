// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import java.util.TimerTask;

// Referenced classes of package com.google.analytics.tracking.android:
//            v

final class ad extends TimerTask
{

    final v a;

    private ad(v v1)
    {
        a = v1;
        super();
    }

    ad(v v1, byte byte0)
    {
        this(v1);
    }

    public final void run()
    {
        a.h();
    }
}
