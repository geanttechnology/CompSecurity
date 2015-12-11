// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.amazon.identity.platform.setting.PlatformSettings;
import java.security.MessageDigest;
import java.util.concurrent.ConcurrentHashMap;

public final class DebugHelpers
{

    private static final ConcurrentHashMap TRACES_SEEN = new ConcurrentHashMap();
    private static volatile boolean sDebugLogsEnabled = false;

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

    public static void printBinderFromIMP$5ffc00fd(String s)
    {
        if (sDebugLogsEnabled)
        {
            String s1 = calculateHash(Log.getStackTraceString(new Throwable()));
            Boolean boolean1 = (Boolean)TRACES_SEEN.put(s1, Boolean.valueOf(true));
            (new StringBuilder("IMP is calling ")).append(s).append(" with trace with hash ").append(s1);
            if (boolean1 != null)
            {
                boolean1.booleanValue();
                return;
            }
        }
    }

    public static void toggleDebugLogsEnabled(Context context)
    {
        sDebugLogsEnabled = PlatformSettings.getInstance(context).getSettingBoolean("enable.debugging.logs", false);
    }

}
