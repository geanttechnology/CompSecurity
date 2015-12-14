// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.appinvite.AppInvite;
import com.google.android.gms.appinvite.AppInviteApi;
import com.google.android.gms.appinvite.AppInviteReferral;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.socialin.android.apiv3.util.AnalyticUtils;
import io.branch.referral.InstallListener;
import java.io.PrintStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class PAInstallReferrerReceiver extends BroadcastReceiver
{

    private static final String a = com/socialin/android/analytics/PAInstallReferrerReceiver.getSimpleName();

    public PAInstallReferrerReceiver()
    {
    }

    static String a()
    {
        return a;
    }

    static void a(Context context, Intent intent, String s)
    {
        b(context, intent, s);
    }

    static void a(PAInstallReferrerReceiver painstallreferrerreceiver, Context context, Intent intent)
    {
        b(context, intent, "");
    }

    private static void b(Context context, Intent intent, String s)
    {
        String s1 = s;
        if (s.isEmpty())
        {
            s1 = intent.getStringExtra("referrer");
        }
        System.out.println((new StringBuilder()).append(a).append(": sendInstallEventToAnalytics:   referrer= ").append(s1).toString());
        AnalyticUtils.getInstance(context).track(new com.socialin.android.apiv3.events.EventsFactory.AppInstallEvent(s1));
    }

    public void onReceive(Context context, Intent intent)
    {
        Object obj;
        Object obj1 = System.out;
        StringBuilder stringbuilder = (new StringBuilder()).append(a).append(" onReceive  ACTION= ");
        String as[];
        String as1[];
        int i;
        int j;
        if (intent != null)
        {
            obj = intent.getAction();
        } else
        {
            obj = "NULL";
        }
        ((PrintStream) (obj1)).println(stringbuilder.append(((String) (obj))).toString());
        obj = new HashMap();
        obj1 = intent.getExtras();
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        obj1 = ((Bundle) (obj1)).getString("referrer");
        System.out.println((new StringBuilder()).append(a).append("  --- referrerString = ").append(((String) (obj1))).append("----------------").toString());
        if (obj1 == null || !((String) (obj1)).contains("&")) goto _L2; else goto _L3
_L3:
        as = URLDecoder.decode(((String) (obj1)), "UTF-8").split("&");
        j = as.length;
        i = 0;
_L4:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        as1 = as[i].split("=");
        if (as1.length > 1)
        {
            ((Map) (obj)).put(URLDecoder.decode(as1[0], "UTF-8"), URLDecoder.decode(as1[1], "UTF-8"));
            System.out.println((new StringBuilder()).append(a).append("  --- Referrer  ").append(as1[0]).append(" = ").append(as1[1]).append("----------------").toString());
        }
        i++;
        if (true) goto _L4; else goto _L2
        Exception exception1;
        exception1;
        System.out.println((new StringBuilder()).append(a).append(" fail to parse referrerString \n").append(exception1.getLocalizedMessage()).toString());
_L2:
        (new InstallListener()).onReceive(context, intent);
        boolean flag;
        try
        {
            if (!((Map) (obj)).isEmpty())
            {
                System.out.println((new StringBuilder()).append(a).append("  --- call processInstallParams").toString());
                AnalyticUtils.getInstance(context).processInstallParams(null, ((Map) (obj)));
            }
        }
        catch (Exception exception)
        {
            System.out.println((new StringBuilder()).append(a).append(" fail to initBranch \n").append(exception.getLocalizedMessage()).toString());
        }
        if (AppInviteReferral.hasReferral(intent))
        {
            System.out.println((new StringBuilder()).append(a).append(": onReceive: isFromGoogleInvite (has 'com.google.android.gms.appinvite.REFERRAL_BUNDLE' ) ").toString());
            GoogleApiClient googleapiclient = (new com.google.android.gms.common.api.GoogleApiClient.Builder(context)).addApi(Drive.API).addScope(Drive.SCOPE_FILE).build();
            googleapiclient.registerConnectionCallbacks(new com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks(intent, googleapiclient, context) {

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

                public final void onConnectionSuspended(int k)
                {
                    System.out.println((new StringBuilder()).append(PAInstallReferrerReceiver.a()).append(":  onReceive: isFromGoogleInvite: onConnectionSuspended !!").toString());
                    PAInstallReferrerReceiver.a(d, c, a);
                }

            
            {
                d = PAInstallReferrerReceiver.this;
                a = intent;
                b = googleapiclient;
                c = context;
                super();
            }
            });
            googleapiclient.registerConnectionFailedListener(new com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener(context, intent) {

                private Context a;
                private Intent b;
                private PAInstallReferrerReceiver c;

                public final void onConnectionFailed(ConnectionResult connectionresult)
                {
                    System.out.println((new StringBuilder()).append(PAInstallReferrerReceiver.a()).append(":  onReceive: isFromGoogleInvite: registerConnectionFailedListener !!").toString());
                    PAInstallReferrerReceiver.a(c, a, b);
                }

            
            {
                c = PAInstallReferrerReceiver.this;
                a = context;
                b = intent;
                super();
            }
            });
            googleapiclient.connect();
            flag = true;
        } else
        {
            System.out.println((new StringBuilder()).append(a).append(":  AppInviteReferral.hasReferral false !!").toString());
            flag = false;
        }
        if (!flag && "com.android.vending.INSTALL_REFERRER".equals(intent.getAction()))
        {
            System.out.println((new StringBuilder()).append(a).append(": onReceive: action= com.android.vending.INSTALL_REFERRER").toString());
            b(context, intent, "");
        }
        return;
    }

}
