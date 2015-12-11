// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.util.Base64;
import android.util.Log;
import com.amazon.identity.platform.setting.PlatformSettings;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

public final class DebugHelpers
{

    private static final ConcurrentHashMap TRACES_SEEN = new ConcurrentHashMap();
    private static volatile boolean sDebugLogsEnabled = false;

    private DebugHelpers()
    {
    }

    private static String calculateHash(String s)
    {
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(s.getBytes());
            s = Base64.encodeToString(messagedigest.digest(), 0);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        return s;
    }

    public static void printBinderFromIMP(Context context, String s)
    {
        if (sDebugLogsEnabled)
        {
            context = calculateHash(Log.getStackTraceString(new Throwable()));
            Boolean boolean1 = (Boolean)TRACES_SEEN.put(context, Boolean.valueOf(true));
            (new StringBuilder("IMP is calling ")).append(s).append(" with trace with hash ").append(context).toString();
            if (boolean1 == null || !boolean1.booleanValue())
            {
                (new StringBuilder("Stack trace hash with ")).append(context).toString();
                return;
            }
        }
    }

    public static void printCallingPackage(Context context, String s, String s1)
    {
        if (!sDebugLogsEnabled)
        {
            return;
        }
        context = context.getPackageManager().getPackagesForUid(Binder.getCallingUid());
        if (context == null)
        {
            context = "Unknown";
        } else
        {
            context = Arrays.asList(context).toString();
        }
        if (s1 == null)
        {
            context = "";
        } else
        {
            context = (new StringBuilder(" for key ")).append(s1).toString();
        }
    }

    public static void toggleDebugLogsEnabled(Context context)
    {
        sDebugLogsEnabled = PlatformSettings.getInstance(context).getSettingBoolean("enable.debugging.logs", false);
    }

}
