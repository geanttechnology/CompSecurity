// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import com.tapjoy.TJConnectListener;

// Referenced classes of package com.tapjoy.internal:
//            TapjoyConnectAutoRetry

final class a
    implements TJConnectListener
{

    final TapjoyConnectAutoRetry a;

    public final void onConnectFailure()
    {
        TapjoyConnectAutoRetry.a(a, new <init>(a, (byte)0));
        TapjoyConnectAutoRetry.a(a).f();
        TapjoyConnectAutoRetry.a(a, false);
    }

    public final void onConnectSuccess()
    {
        TapjoyConnectAutoRetry tapjoyconnectautoretry = a;
        a a1 = e;
        a a2 = b;
        TapjoyConnectAutoRetry.a(tapjoyconnectautoretry, a1);
        TapjoyConnectAutoRetry.a(a, true);
    }

    (TapjoyConnectAutoRetry tapjoyconnectautoretry)
    {
        a = tapjoyconnectautoretry;
        super();
    }
}
