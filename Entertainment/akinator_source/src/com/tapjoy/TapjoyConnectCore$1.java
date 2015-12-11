// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import com.tapjoy.internal.ey;
import com.tapjoy.internal.fk;

// Referenced classes of package com.tapjoy:
//            TapjoyConnectCore, TapjoyLog

final class a
    implements ey
{

    final TapjoyConnectCore a;

    public final void a()
    {
        if (TapjoyConnectCore.a(a).c() != com.tapjoy.internal.) goto _L2; else goto _L1
_L1:
        TapjoyConnectCore.a(TapjoyConnectCore.a(a).b());
_L4:
        TapjoyConnectCore.a(a).d();
        return;
_L2:
        TapjoyLog.w("TapjoyConnect", "No Threatmetrix session ID");
        if (true) goto _L4; else goto _L3
_L3:
        Object obj;
        obj;
        TapjoyLog.w("TapjoyConnect", (new StringBuilder("Error retrieving Threatmetrix session ID: ")).append(((Exception) (obj)).toString()).toString());
        TapjoyConnectCore.a(a).d();
        return;
        obj;
        TapjoyConnectCore.a(a).d();
        throw obj;
    }

    (TapjoyConnectCore tapjoyconnectcore)
    {
        a = tapjoyconnectcore;
        super();
    }
}
