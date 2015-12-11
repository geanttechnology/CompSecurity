// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import com.amazon.device.messaging.ADM;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class ADMRegistrar
{

    public static final String INTENT_FROM_ADM_MESSAGE = "com.amazon.device.messaging.intent.RECEIVE";
    public static final String INTENT_FROM_ADM_REGISTRATION_CALLBACK = "com.amazon.device.messaging.intent.REGISTRATION";
    public static final String PERMISSION_ADM_INTENTS = "com.amazon.device.messaging.permission.SEND";
    private static final String TAG = "ADMRegistrar";

    public ADMRegistrar()
    {
    }

    public static void checkDevice(ADM adm)
    {
        if (!adm.isSupported())
        {
            throw new UnsupportedOperationException("ADM is not supported on the current device");
        } else
        {
            return;
        }
    }

    public static void checkManifest(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        Object obj = context.getPackageName();
        Object obj1 = (new StringBuilder()).append(((String) (obj))).append(".permission.RECEIVE_ADM_MESSAGE").toString();
        try
        {
            packagemanager.getPermissionInfo(((String) (obj1)), 4096);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IllegalStateException((new StringBuilder()).append("Application does not define permission ").append(((String) (obj1))).toString());
        }
        try
        {
            obj1 = packagemanager.getPackageInfo(((String) (obj)), 2);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IllegalStateException((new StringBuilder()).append("Could not get receivers for package ").append(((String) (obj))).toString());
        }
        obj1 = ((PackageInfo) (obj1)).receivers;
        if (obj1 == null || obj1.length == 0)
        {
            throw new IllegalStateException((new StringBuilder()).append("No receiver for package ").append(((String) (obj))).toString());
        }
        if (Log.isLoggable("ADMRegistrar", 2))
        {
            Log.v("ADMRegistrar", (new StringBuilder()).append("number of receivers for ").append(((String) (obj))).append(": ").append(obj1.length).toString());
        }
        obj = new HashSet();
        int j = obj1.length;
        for (int i = 0; i < j; i++)
        {
            Object obj2 = obj1[i];
            if ("com.amazon.device.messaging.permission.SEND".equals(((ActivityInfo) (obj2)).permission))
            {
                ((Set) (obj)).add(((ActivityInfo) (obj2)).name);
            }
        }

        if (((Set) (obj)).isEmpty())
        {
            throw new IllegalStateException("No receiver allowed to receive com.amazon.device.messaging.permission.SEND");
        } else
        {
            checkReceiver(context, ((Set) (obj)), "com.amazon.device.messaging.intent.REGISTRATION");
            checkReceiver(context, ((Set) (obj)), "com.amazon.device.messaging.intent.RECEIVE");
            return;
        }
    }

    private static void checkReceiver(Context context, Set set, String s)
    {
        PackageManager packagemanager = context.getPackageManager();
        context = context.getPackageName();
        Intent intent = new Intent(s);
        intent.setPackage(context);
        context = packagemanager.queryBroadcastReceivers(intent, 32);
        if (context.isEmpty())
        {
            throw new IllegalStateException((new StringBuilder()).append("No receivers for action ").append(s).toString());
        }
        if (Log.isLoggable("ADMRegistrar", 2))
        {
            Log.v("ADMRegistrar", (new StringBuilder()).append("Found ").append(context.size()).append(" receivers for action ").append(s).toString());
        }
        for (context = context.iterator(); context.hasNext();)
        {
            s = ((ResolveInfo)context.next()).activityInfo.name;
            if (!set.contains(s))
            {
                throw new IllegalStateException((new StringBuilder()).append("Receiver ").append(s).append(" is not set with permission ").append("com.amazon.device.messaging.permission.SEND").toString());
            }
        }

    }
}
