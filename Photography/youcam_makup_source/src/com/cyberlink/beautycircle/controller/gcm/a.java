// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.gcm;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.activity.BCNotificationActivity;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import java.io.IOException;
import java.util.UUID;

// Referenced classes of package com.cyberlink.beautycircle.controller.gcm:
//            b

public class a
{

    private static int a = 0;

    private static int a()
    {
        return -4;
    }

    public static void a(Context context, long l)
    {
        Globals.d(context).edit().putLong("MessageNId", l).apply();
    }

    public static void a(Context context, String s)
    {
        int i = f(context);
        com.perfectcorp.utility.e.b(new Object[] {
            (new StringBuilder()).append("Saving regId(").append(s).append(") on app version (").append(i).append(")").toString()
        });
        Globals.d(context).edit().putString("registration_id", s).commit();
    }

    private static void a(Context context, String s, String s1, String s2, String s3, String s4, int i, int j)
    {
        NotificationManager notificationmanager = (NotificationManager)context.getSystemService("notification");
        Intent intent = new Intent(context, com/cyberlink/beautycircle/controller/activity/BCNotificationActivity);
        intent.putExtra("DeepLink", s3);
        intent.putExtra("EventType", s4);
        s3 = PendingIntent.getActivity(context, 0, intent, 0x10000000);
        context = (new android.support.v4.app.NotificationCompat.Builder(context)).setSmallIcon(j).setAutoCancel(true).setDefaults(a()).setContentTitle(s).setStyle((new android.support.v4.app.NotificationCompat.BigTextStyle()).bigText(s1)).setContentText(s1).setTicker(s2).setSound(null);
        context.setContentIntent(s3);
        notificationmanager.cancel(a);
        notificationmanager.notify(i, context.build());
        a = i;
    }

    public static boolean a(Context context)
    {
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        if (i != 0)
        {
            if (GooglePlayServicesUtil.isUserRecoverableError(i))
            {
                return false;
            } else
            {
                com.perfectcorp.utility.e.e(new Object[] {
                    "This device is not supported."
                });
                return false;
            }
        } else
        {
            return true;
        }
    }

    public static boolean a(Context context, Intent intent, int i, int j)
    {
        Bundle bundle = intent.getExtras();
        if (bundle == null)
        {
            com.perfectcorp.utility.e.f(new Object[] {
                "The extra is null."
            });
        } else
        {
            com.perfectcorp.utility.e.f(new Object[] {
                bundle.toString()
            });
            if (bundle.containsKey("MsgType"))
            {
                intent = bundle.getString("MsgType", "");
            } else
            {
                intent = null;
            }
            if (intent != null && intent.equals("BC"))
            {
                a(context, bundle.getString("Title", ""), bundle.getString("Msg", ""), bundle.getString("TickerText", ""), bundle.getString("Link", ""), bundle.getString("Ntype", ""), i, j);
                return true;
            }
        }
        return false;
    }

    public static j b(Context context)
    {
        return (new j(context) {

            final Context a;

            protected b a(Void void1)
            {
                b b1 = new b();
                GoogleCloudMessaging googlecloudmessaging;
                try
                {
                    void1 = a.c(a);
                }
                // Misplaced declaration of an exception variable
                catch (Void void1)
                {
                    com.perfectcorp.utility.e.e(new Object[] {
                        "Failed, msg: ", void1
                    });
                    b1.a = 2;
                    return b1;
                }
                if (void1 == null) goto _L2; else goto _L1
_L1:
                if (void1.isEmpty()) goto _L2; else goto _L3
_L3:
                com.perfectcorp.utility.e.b(new Object[] {
                    "Read registration ID: ", void1
                });
_L4:
                b1.a = 1;
                b1.b = void1;
                return b1;
_L2:
                googlecloudmessaging = GoogleCloudMessaging.getInstance(a);
                if (Globals.s().equals("YCP"))
                {
                    void1 = "655894889550";
                } else
                {
                    void1 = "8121036310";
                }
                void1 = googlecloudmessaging.register(new String[] {
                    void1
                });
                com.perfectcorp.utility.e.b(new Object[] {
                    "Device registered, registration ID: ", void1
                });
                a.a(a, void1);
                  goto _L4
            }

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            
            {
                a = context;
                super();
            }
        }).d(null);
    }

    public static String c(Context context)
    {
        context = Globals.d(context).getString("registration_id", "");
        if (context.isEmpty())
        {
            com.perfectcorp.utility.e.b(new Object[] {
                "Registration not found."
            });
            return "";
        } else
        {
            com.perfectcorp.utility.e.b(new Object[] {
                "registrationId=", context
            });
            return context;
        }
    }

    public static String d(Context context)
    {
        context = Globals.d(context);
        if (context.contains("InstallationId"))
        {
            return context.getString("InstallationId", "");
        } else
        {
            String s = UUID.randomUUID().toString();
            context.edit().putString("InstallationId", s).apply();
            return s;
        }
    }

    public static Long e(Context context)
    {
        return Long.valueOf(Globals.d(context).getLong("MessageNId", 0L));
    }

    private static int f(Context context)
    {
        int i;
        try
        {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new RuntimeException((new StringBuilder()).append("Could not get package name: ").append(context).toString());
        }
        return i;
    }

}
