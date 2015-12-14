// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.analytics;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.appinvite.AppInvite;
import com.google.android.gms.appinvite.AppInviteApi;
import com.google.android.gms.appinvite.AppInviteReferral;
import com.google.android.gms.common.api.GoogleApiClient;
import java.io.PrintStream;

// Referenced classes of package com.socialin.android.analytics:
//            PAInstallReferrerReceiver

final class c
    implements com.google.android.gms.common.api.llbacks
{

    private Intent a;
    private GoogleApiClient b;
    private Context c;
    private PAInstallReferrerReceiver d;

    public final void onConnected(Bundle bundle)
    {
        bundle = AppInviteReferral.getInvitationId(a);
        if (AppInviteReferral.isOpenedFromPlayStore(a))
        {
            AppInvite.AppInviteApi.updateInvitationOnInstall(b, bundle);
        }
        AppInvite.AppInviteApi.convertInvitation(b, bundle);
        System.out.println((new StringBuilder()).append(PAInstallReferrerReceiver.a()).append(":  onReceive: isFromGoogleInvite: onConnected !!").toString());
        PAInstallReferrerReceiver.a(c, a, "google_invite");
        b.disconnect();
    }

    public final void onConnectionSuspended(int i)
    {
        System.out.println((new StringBuilder()).append(PAInstallReferrerReceiver.a()).append(":  onReceive: isFromGoogleInvite: onConnectionSuspended !!").toString());
        PAInstallReferrerReceiver.a(d, c, a);
    }

    nCallbacks(PAInstallReferrerReceiver painstallreferrerreceiver, Intent intent, GoogleApiClient googleapiclient, Context context)
    {
        d = painstallreferrerreceiver;
        a = intent;
        b = googleapiclient;
        c = context;
        super();
    }
}
