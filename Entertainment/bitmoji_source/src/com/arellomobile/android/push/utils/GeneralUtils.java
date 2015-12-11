// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.telephony.TelephonyManager;
import android.util.TypedValue;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class GeneralUtils
{

    private static final String SHARED_KEY = "deviceid";
    private static final String SHARED_PREF_NAME = "com.arellomobile.android.push.deviceid";
    public static final String SUPPORTED_AUDIO_FORMATS[] = {
        ".mp3", ".3gp", ".mp4", ".m4a", ".aac", ".flac", ".ogg", ".wav"
    };
    private static List sWrongAndroidDevices;

    public GeneralUtils()
    {
    }

    public static void checkNotNull(Object obj, String s)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException(String.format("Please set the %1$s constant and recompile the app.", new Object[] {
                s
            }));
        } else
        {
            return;
        }
    }

    public static void checkNotNullOrEmpty(String s, String s1)
    {
        checkNotNull(s, s1);
        if (s.length() == 0)
        {
            throw new IllegalArgumentException(String.format("Please set the %1$s constant and recompile the app.", new Object[] {
                s1
            }));
        } else
        {
            return;
        }
    }

    public static boolean checkStickyBroadcastPermissions(Context context)
    {
        return context.getPackageManager().checkPermission("android.permission.BROADCAST_STICKY", context.getPackageName()) == 0;
    }

    public static String getDeviceUUID(Context context)
    {
        Object obj = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (obj == null || sWrongAndroidDevices.contains(obj)) goto _L2; else goto _L1
_L1:
        return ((String) (obj));
_L2:
        String s = ((TelephonyManager)context.getSystemService("phone")).getDeviceId();
        obj = s;
        if (s != null)
        {
            continue; /* Loop/switch isn't completed */
        }
_L4:
        SharedPreferences sharedpreferences = context.getSharedPreferences("com.arellomobile.android.push.deviceid", 2);
        context = sharedpreferences.getString("deviceid", null);
        obj = context;
        if (context == null)
        {
            context = UUID.randomUUID().toString();
            android.content.SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString("deviceid", context);
            editor.commit();
            return context;
        }
        if (true) goto _L1; else goto _L3
_L3:
        RuntimeException runtimeexception;
        runtimeexception;
          goto _L4
    }

    public static ArrayList getRawResourses(Context context)
    {
        ArrayList arraylist = new ArrayList();
        Field afield[];
        String s;
        TypedValue typedvalue;
        int i;
        int j;
        try
        {
            afield = Class.forName((new StringBuilder()).append(context.getPackageName()).append(".R$raw").toString()).getFields();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            break; /* Loop/switch isn't completed */
        }
        i = 0;
_L2:
        if (i >= afield.length)
        {
            break; /* Loop/switch isn't completed */
        }
        s = afield[i].getName();
        j = context.getResources().getIdentifier(s, "raw", context.getPackageName());
        typedvalue = new TypedValue();
        context.getResources().getValue(j, typedvalue, true);
        if (isSound(typedvalue.string.toString()))
        {
            arraylist.add(s);
        }
        i++;
        continue; /* Loop/switch isn't completed */
        if (true) goto _L2; else goto _L1
_L1:
        return arraylist;
    }

    public static boolean isAmazonDevice()
    {
        try
        {
            Class.forName("com.amazon.device.messaging.ADM");
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            return false;
        }
        return true;
    }

    public static boolean isAppOnForeground(Context context)
    {
        Object obj = ((ActivityManager)context.getSystemService("activity")).getRunningAppProcesses();
        if (obj == null)
        {
            return false;
        }
        context = context.getPackageName();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)((Iterator) (obj)).next();
            if (runningappprocessinfo.importance == 100 && runningappprocessinfo.processName.equals(context))
            {
                return true;
            }
        }

        return false;
    }

    protected static boolean isSound(String s)
    {
        boolean flag1 = false;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < SUPPORTED_AUDIO_FORMATS.length)
                {
                    String s1 = SUPPORTED_AUDIO_FORMATS[i];
                    if (!s.toLowerCase(Locale.US).endsWith(s1))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i++;
        } while (true);
    }

    public static boolean isTablet(Context context)
    {
        return (context.getResources().getConfiguration().screenLayout & 4) == 4;
    }

    static 
    {
        sWrongAndroidDevices = new ArrayList();
        sWrongAndroidDevices.add("9774d56d682e549c");
    }
}
