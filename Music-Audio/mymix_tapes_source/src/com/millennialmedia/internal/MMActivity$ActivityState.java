// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.millennialmedia.internal:
//            MMActivity

private static class ig
{

    ener activityListener;
    ig configuration;
    CountDownLatch onCreateLatch;

    private ig(ener ener, ig ig)
    {
        onCreateLatch = new CountDownLatch(1);
        activityListener = ener;
        configuration = ig;
    }

    ig(ener ener, ig ig, ig ig1)
    {
        this(ener, ig);
    }
}
