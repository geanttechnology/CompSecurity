// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.internal.utils;

import android.content.Context;
import android.os.Build;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Referenced classes of package com.pointinside.internal.utils:
//            LogUtils, BuildUtils, StringUtils

public class DevIdUtils
{

    private static final String TAG = com/pointinside/internal/utils/DevIdUtils.getSimpleName();
    private static String sHashedAndroidUUID;

    public DevIdUtils()
    {
    }

    private static byte[] decodeHexString(String s)
    {
        int j = s.length();
        int i = j;
        String s1 = s;
        if ((j & 1) == 1)
        {
            s1 = (new StringBuilder()).append("0").append(s).toString();
            i = s1.length();
        }
        s = new byte[i / 2];
        for (int k = 0; k < i; k += 2)
        {
            int l = Character.digit(s1.charAt(k), 16);
            int i1 = Character.digit(s1.charAt(k + 1), 16);
            s[k / 2] = (byte)(l << 4 | i1);
        }

        return s;
    }

    private static String getAndroidID(Context context)
    {
        return android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static String getHashedUUID(Context context)
    {
        if (sHashedAndroidUUID == null)
        {
            context = makeHashedUUID(context);
            if (context == null)
            {
                context = "";
            }
            sHashedAndroidUUID = context;
        }
        return sHashedAndroidUUID;
    }

    public static String getUUID(Context context)
    {
        String s = getAndroidID(context);
        if (s != null)
        {
            return s;
        }
        if (!isEmulator(context))
        {
            LogUtils.logW(TAG, (new StringBuilder()).append("ANDROID_ID is null however this is not the emulator? Build fingerprint: ").append(Build.FINGERPRINT).toString());
        }
        return "emulator";
    }

    public static boolean isEmulator(Context context)
    {
        return BuildUtils.isEmulatorBuild();
    }

    private static String makeHashedUUID(Context context)
    {
        context = getAndroidID(context);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        context = StringUtils.encodeHexString(MessageDigest.getInstance("MD5").digest(decodeHexString(context)));
        return context;
        context;
        LogUtils.logW(TAG, "Cannot hash device uuid", context);
        return null;
    }

}
