// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.analytics;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.ConnectionResult;
import java.io.PrintStream;

// Referenced classes of package com.socialin.android.analytics:
//            PAInstallReferrerReceiver

final class b
    implements com.google.android.gms.common.api.FailedListener
{

    private Context a;
    private Intent b;
    private PAInstallReferrerReceiver c;

    public final void onConnectionFailed(ConnectionResult connectionresult)
    {
        System.out.println((new StringBuilder()).append(PAInstallReferrerReceiver.a()).append(":  onReceive: isFromGoogleInvite: registerConnectionFailedListener !!").toString());
        PAInstallReferrerReceiver.a(c, a, b);
    }

    ionFailedListener(PAInstallReferrerReceiver painstallreferrerreceiver, Context context, Intent intent)
    {
        c = painstallreferrerreceiver;
        a = context;
        b = intent;
        super();
    }
}
