// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.arellomobile.android.push.utils.GeneralUtils;
import java.io.PrintStream;
import java.lang.reflect.Method;

// Referenced classes of package com.arellomobile.android.push:
//            MessageActivity

public class PushEventsTransmitter
{

    public PushEventsTransmitter()
    {
    }

    private static boolean getUseBroadcast(Context context)
    {
label0:
        {
            boolean flag;
            try
            {
                context = context.getPackageManager().getApplicationInfo(context.getApplicationContext().getPackageName(), 128);
                if (((ApplicationInfo) (context)).metaData == null)
                {
                    break label0;
                }
                flag = ((ApplicationInfo) (context)).metaData.getBoolean("PW_BROADCAST_REGISTRATION", true);
                System.out.println((new StringBuilder()).append("Using broadcast registration: ").append(flag).toString());
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
                return true;
            }
            return flag;
        }
        return true;
    }

    static void onMessageReceive(Context context, String s)
    {
        onMessageReceive(context, s, null);
    }

    static void onMessageReceive(Context context, String s, Bundle bundle)
    {
        transmit(context, s, "PUSH_RECEIVE_EVENT", bundle);
    }

    static void onRegisterError(Context context, String s)
    {
        if (getUseBroadcast(context))
        {
            transmitBroadcast(context, s, "REGISTER_ERROR_EVENT");
            return;
        } else
        {
            transmit(context, s, "REGISTER_ERROR_EVENT");
            return;
        }
    }

    static void onRegistered(Context context, String s)
    {
        if (getUseBroadcast(context))
        {
            transmitBroadcast(context, s, "REGISTER_EVENT");
            return;
        } else
        {
            transmit(context, s, "REGISTER_EVENT");
            return;
        }
    }

    static void onUnregistered(Context context, String s)
    {
        if (getUseBroadcast(context))
        {
            transmitBroadcast(context, s, "UNREGISTER_EVENT");
            return;
        } else
        {
            transmit(context, s, "UNREGISTER_EVENT");
            return;
        }
    }

    static void onUnregisteredError(Context context, String s)
    {
        if (getUseBroadcast(context))
        {
            transmitBroadcast(context, s, "UNREGISTER_ERROR_EVENT");
            return;
        } else
        {
            transmit(context, s, "UNREGISTER_ERROR_EVENT");
            return;
        }
    }

    private static void transmit(Context context, String s, String s1)
    {
        transmit(context, s, s1, null);
    }

    private static void transmit(Context context, String s, String s1, Bundle bundle)
    {
        Intent intent;
        intent = new Intent(context, com/arellomobile/android/push/MessageActivity);
        if (bundle != null)
        {
            intent.putExtras(bundle);
        }
        intent.putExtra(s1, s);
        intent.setFlags(0x10000000);
        s = Class.forName("com.arellomobile.android.push.PushwooshProxy");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        s1 = ((String) (s.getMethod("getInstanceOrNull", new Class[0]).invoke(null, (Object[])null)));
        if (s1 != null)
        {
            try
            {
                s.getMethod("checkMessage", new Class[] {
                    android/content/Intent
                }).invoke(s1, new Object[] {
                    intent
                });
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        context.startActivity(intent);
        return;
    }

    private static void transmitBroadcast(Context context, String s, String s1)
    {
        String s2 = context.getPackageName();
        Intent intent = new Intent((new StringBuilder()).append(s2).append(".").append("com.arellomobile.android.push.REGISTER_BROAD_CAST_ACTION").toString());
        intent.putExtra(s1, s);
        intent.setPackage(s2);
        if (GeneralUtils.checkStickyBroadcastPermissions(context))
        {
            context.sendStickyBroadcast(intent);
            return;
        } else
        {
            Log.w(com/arellomobile/android/push/PushEventsTransmitter.getSimpleName(), "No android.permission.BROADCAST_STICKY. Reverting to simple broadcast");
            context.sendBroadcast(intent);
            return;
        }
    }
}
