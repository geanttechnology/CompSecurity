// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import com.tapjoy.TJConnectListener;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.tapjoy.internal:
//            TapjoyConnectAutoRetry

final class a
    implements TJConnectListener
{

    final CountDownLatch a;
    final a b;

    public final void onConnectFailure()
    {
        a.countDown();
    }

    public final void onConnectSuccess()
    {
        a(b);
        a.countDown();
    }

    ( , CountDownLatch countdownlatch)
    {
        b = ;
        a = countdownlatch;
        super();
    }
}
