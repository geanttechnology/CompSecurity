// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.googledrive;

import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.socialin.android.googledrive:
//            a

final class a
    implements com.google.android.gms.common.api.leApiClient.OnConnectionFailedListener
{

    private CountDownLatch a;

    public final void onConnectionFailed(ConnectionResult connectionresult)
    {
        a.countDown();
    }

    ionResult(CountDownLatch countdownlatch)
    {
        a = countdownlatch;
        super();
    }
}
