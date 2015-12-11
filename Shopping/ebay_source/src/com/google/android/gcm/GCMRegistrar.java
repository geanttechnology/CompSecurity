// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

// Referenced classes of package com.google.android.gcm:
//            GCMBroadcastReceiver

public final class GCMRegistrar
{

    private static GCMBroadcastReceiver sRetryReceiver;

    public static void checkDevice(Context context)
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i < 8)
        {
            throw new UnsupportedOperationException((new StringBuilder()).append("Device must be at least API Level 8 (instead of ").append(i).append(")").toString());
        }
        context = context.getPackageManager();
        try
        {
            context.getPackageInfo("com.google.android.gsf", 0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new UnsupportedOperationException("Device does not have package com.google.android.gsf");
        }
    }

    static String clearRegistrationId(Context context)
    {
        return setRegistrationId(context, "");
    }

    private static int getAppVersion(Context context)
    {
        int i;
        try
        {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new RuntimeException((new StringBuilder()).append("Coult not get package name: ").append(context).toString());
        }
        return i;
    }

    static int getBackoff(Context context)
    {
        return getGCMPreferences(context).getInt("backoff_ms", 3000);
    }

    private static SharedPreferences getGCMPreferences(Context context)
    {
        return context.getSharedPreferences("com.google.android.gcm", 0);
    }

    public static String getRegistrationId(Context context)
    {
        Object obj = getGCMPreferences(context);
        String s = ((SharedPreferences) (obj)).getString("regId", "");
        int i = ((SharedPreferences) (obj)).getInt("appVersion", 0x80000000);
        int j = getAppVersion(context);
        obj = s;
        if (i != 0x80000000)
        {
            obj = s;
            if (i != j)
            {
                Log.v("GCMRegistrar", (new StringBuilder()).append("App version changed from ").append(i).append(" to ").append(j).append("; resetting registration id").toString());
                clearRegistrationId(context);
                obj = "";
            }
        }
        return ((String) (obj));
    }

    static transient void internalRegister(Context context, String as[])
    {
        if (as == null || as.length == 0)
        {
            throw new IllegalArgumentException("No senderIds");
        }
        Object obj = new StringBuilder(as[0]);
        for (int i = 1; i < as.length; i++)
        {
            ((StringBuilder) (obj)).append(',').append(as[i]);
        }

        as = ((StringBuilder) (obj)).toString();
        Log.v("GCMRegistrar", (new StringBuilder()).append("Registering app ").append(context.getPackageName()).append(" of senders ").append(as).toString());
        obj = new Intent("com.google.android.c2dm.intent.REGISTER");
        ((Intent) (obj)).setPackage("com.google.android.gsf");
        ((Intent) (obj)).putExtra("app", PendingIntent.getBroadcast(context, 0, new Intent(), 0));
        ((Intent) (obj)).putExtra("sender", as);
        context.startService(((Intent) (obj)));
    }

    static void internalUnregister(Context context)
    {
        Log.v("GCMRegistrar", (new StringBuilder()).append("Unregistering app ").append(context.getPackageName()).toString());
        Intent intent = new Intent("com.google.android.c2dm.intent.UNREGISTER");
        intent.setPackage("com.google.android.gsf");
        intent.putExtra("app", PendingIntent.getBroadcast(context, 0, new Intent(), 0));
        context.startService(intent);
    }

    public static boolean isRegistered(Context context)
    {
        return getRegistrationId(context).length() > 0;
    }

    public static transient void register(Context context, String as[])
    {
        setRetryBroadcastReceiver(context);
        resetBackoff(context);
        internalRegister(context, as);
    }

    static void resetBackoff(Context context)
    {
        Log.d("GCMRegistrar", (new StringBuilder()).append("resetting backoff for ").append(context.getPackageName()).toString());
        setBackoff(context, 3000);
    }

    static void setBackoff(Context context, int i)
    {
        context = getGCMPreferences(context).edit();
        context.putInt("backoff_ms", i);
        context.commit();
    }

    static String setRegistrationId(Context context, String s)
    {
        SharedPreferences sharedpreferences = getGCMPreferences(context);
        String s1 = sharedpreferences.getString("regId", "");
        int i = getAppVersion(context);
        Log.v("GCMRegistrar", (new StringBuilder()).append("Saving regId on app version ").append(i).toString());
        context = sharedpreferences.edit();
        context.putString("regId", s);
        context.putInt("appVersion", i);
        context.commit();
        return s1;
    }

    private static void setRetryBroadcastReceiver(Context context)
    {
        com/google/android/gcm/GCMRegistrar;
        JVM INSTR monitorenter ;
        if (sRetryReceiver == null)
        {
            sRetryReceiver = new GCMBroadcastReceiver();
            String s = context.getPackageName();
            IntentFilter intentfilter = new IntentFilter("com.google.android.gcm.intent.RETRY");
            intentfilter.addCategory(s);
            s = (new StringBuilder()).append(s).append(".permission.C2D_MESSAGE").toString();
            Log.v("GCMRegistrar", "Registering receiver");
            context.registerReceiver(sRetryReceiver, intentfilter, s, null);
        }
        com/google/android/gcm/GCMRegistrar;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    public static void unregister(Context context)
    {
        setRetryBroadcastReceiver(context);
        resetBackoff(context);
        internalUnregister(context);
    }
}
