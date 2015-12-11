// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.spotify.sdk.android.player;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.util.Locale;

public final class Config
{

    private static final int CACHE_AGE_LIMIT_IN_SECONDS = 0x93a80;
    private static final int CACHE_SIZE_LIMIT_IN_MEGABYTES = 1024;
    private static final char CONFIG_STRING_REPLACEMENT_CHAR = 95;
    private static final String FALLBACK_DISPLAY_NAME;
    public static final String IN_FIELD_SEPARATOR = ",";
    private static final int MAX_BRAND_NAME_LENGTH = 32;
    private static final int MAX_CLIENT_ID_LENGTH = 32;
    private static final int MAX_DISPLAY_NAME_LENGTH = 64;
    private static final int MAX_MODEL_NAME_LENGTH = 30;
    private static final int MAX_OS_VERSION_LENGTH = 30;
    private static final String TAG = com/spotify/sdk/android/player/Config.getName();
    public final String brandName;
    public final int cacheAgeLimitInSeconds;
    public final String cachePath;
    public final int cacheSizeLimitInMegabytes;
    public final String clientId;
    private final int deviceTypeIndex;
    public String displayName;
    private boolean mShouldUseCache;
    public final String modelName;
    public final String oauthToken;
    public final String osVersion;
    public final String uniqueId;

    public Config(Context context, String s, String s1)
    {
    /* block-local class not found */
    class DeviceType {}

        this(context, s, s1, DeviceType.UNKNOWN);
    }

    public Config(Context context, String s, String s1, DeviceType devicetype)
    {
        cacheSizeLimitInMegabytes = 1024;
        cacheAgeLimitInSeconds = 0x93a80;
        mShouldUseCache = true;
        if (context == null)
        {
            throw new IllegalArgumentException("Context can't be null");
        }
        if (!isValidClientId(s1))
        {
            throw new IllegalArgumentException("Invalid client ID passed to Config object");
        }
        if (!internetPermissionGranted(context))
        {
            Log.e(TAG, "Missing INTERNET permission");
        }
        oauthToken = s;
        uniqueId = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        displayName = convertConfigString(getApplicationName(context), 64);
        brandName = convertConfigString(Build.MANUFACTURER, 32).toUpperCase(Locale.US);
        modelName = convertConfigString(Build.MODEL, 30).toLowerCase(Locale.US);
        deviceTypeIndex = devicetype.getTypeIndex();
        cachePath = getWritableCacheDirectory(context);
        clientId = convertConfigString(s1, 32);
        osVersion = createOsVersionString();
    }

    private String convertConfigString(String s, int i)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int j = 0; j < s.length() && j < i; j++)
        {
            char c;
label0:
            {
                char c1 = s.charAt(j);
                c = c1;
                if (c1 == '-')
                {
                    break label0;
                }
                c = c1;
                if (c1 == '_')
                {
                    break label0;
                }
                c = c1;
                if (c1 == '.')
                {
                    break label0;
                }
                c = c1;
                if (c1 == ',')
                {
                    break label0;
                }
                if (c1 >= 'A')
                {
                    c = c1;
                    if (c1 <= 'Z')
                    {
                        break label0;
                    }
                }
                if (c1 >= 'a')
                {
                    c = c1;
                    if (c1 <= 'z')
                    {
                        break label0;
                    }
                }
                if (c1 >= '0')
                {
                    c = c1;
                    if (c1 <= '9')
                    {
                        break label0;
                    }
                }
                c = '_';
            }
            stringbuilder.append(c);
        }

        return stringbuilder.toString();
    }

    private String createOsVersionString()
    {
        StringBuilder stringbuilder = new StringBuilder(android.os.Build.VERSION.RELEASE);
        if (android.os.Build.VERSION.SDK_INT >= 21 && Build.SUPPORTED_ABIS.length > 0)
        {
            stringbuilder.append(",");
            stringbuilder.append(Build.SUPPORTED_ABIS[0]);
        }
        return convertConfigString(stringbuilder.toString(), 30).toLowerCase(Locale.US);
    }

    private String getApplicationName(Context context)
    {
        int i = context.getApplicationInfo().labelRes;
        if (i > 0)
        {
            return context.getString(i);
        } else
        {
            return FALLBACK_DISPLAY_NAME;
        }
    }

    private String getWritableCacheDirectory(Context context)
    {
        for (context = context.getExternalFilesDir(null); context == null || !isExternalStorageWritable() || (!context.isDirectory() || !context.canWrite()) && !context.mkdirs() && (!context.isDirectory() || !context.canWrite());)
        {
            return null;
        }

        return context.getAbsolutePath();
    }

    private boolean internetPermissionGranted(Context context)
    {
        return context.getPackageManager().checkPermission("android.permission.INTERNET", context.getPackageName()) == 0;
    }

    private boolean isExternalStorageWritable()
    {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    private boolean isValidClientId(String s)
    {
        return s != null && s.matches("^[0-9a-fA-F]+$");
    }

    public final boolean shouldUseCache()
    {
        return mShouldUseCache;
    }

    public final void useCache(boolean flag)
    {
        mShouldUseCache = flag;
    }

    static 
    {
        FALLBACK_DISPLAY_NAME = Build.MODEL;
    }
}
