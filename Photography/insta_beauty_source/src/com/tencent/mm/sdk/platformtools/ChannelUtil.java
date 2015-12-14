// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.util.Log;
import java.util.Map;

// Referenced classes of package com.tencent.mm.sdk.platformtools:
//            MMApplicationContext, Log, Util, KVConfig

public final class ChannelUtil
{

    public static final int FLAG_NULL = 0;
    public static final int FLAG_UPDATE_EXTERNAL = 1;
    public static final int FLAG_UPDATE_NOTIP = 2;
    public static int buildRev = 0;
    public static int channelId = 0;
    public static boolean fullVersionInfo = false;
    public static String marketURL = (new StringBuilder("market://details?id=")).append(MMApplicationContext.getPackageName()).toString();
    public static String profileDeviceType;
    public static int updateMode = 0;

    private ChannelUtil()
    {
    }

    public static String formatVersion(Context context, int i)
    {
        String s;
        String s1;
        int j;
        s1 = (new StringBuilder()).append(i >> 24 & 0xf).append(".").append(i >> 16 & 0xff).toString();
        j = 0xffff & i;
        s = s1;
        i = j;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        i = j;
        context = context.getPackageManager().getPackageInfo(context.getPackageName(), 128);
        s = s1;
        i = j;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        i = j;
        j = ((PackageInfo) (context)).versionCode;
        i = j;
        s = ((PackageInfo) (context)).versionName;
        i = j;
_L2:
        context = s;
        if (fullVersionInfo)
        {
            context = (new StringBuilder()).append(s).append(" r").append(i).append("(build.").append(buildRev).append(")").toString();
            Log.d("MicroMsg.SDK.ChannelUtil", (new StringBuilder("full version: ")).append(context).toString());
        }
        return context;
        context;
        context.printStackTrace();
        s = s1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static void loadProfile(Context context)
    {
        try
        {
            context = KVConfig.parseIni(Util.convertStreamToString(context.getAssets().open("profile.ini")));
            String s = Util.nullAsNil((String)context.get("PROFILE_DEVICE_TYPE"));
            profileDeviceType = s;
            if (s.length() <= 0)
            {
                profileDeviceType = (new StringBuilder()).append(android.os.Build.VERSION.SDK_INT).toString();
            }
            updateMode = Integer.parseInt((String)context.get("UPDATE_MODE"));
            buildRev = Integer.parseInt((String)context.get("BUILD_REVISION"));
            Log.w("MicroMsg.SDK.ChannelUtil", (new StringBuilder("profileDeviceType=")).append(profileDeviceType).toString());
            Log.w("MicroMsg.SDK.ChannelUtil", (new StringBuilder("updateMode=")).append(updateMode).toString());
            context = (String)context.get("MARKET_URL");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("MicroMsg.SDK.ChannelUtil", "setup profile from profile.ini failed");
            context.printStackTrace();
            return;
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_180;
        }
        if (context.trim().length() != 0 && Uri.parse(context) != null)
        {
            marketURL = context;
        }
        Log.w("MicroMsg.SDK.ChannelUtil", (new StringBuilder("marketURL=")).append(marketURL).toString());
        return;
    }

    public static void setupChannelId(Context context)
    {
        try
        {
            channelId = Integer.parseInt((String)KVConfig.parseIni(Util.convertStreamToString(context.getAssets().open("channel.ini"))).get("CHANNEL"));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("MicroMsg.SDK.ChannelUtil", "setup channel id from channel.ini failed");
        }
        context.printStackTrace();
    }

    static 
    {
        profileDeviceType = (new StringBuilder()).append(android.os.Build.VERSION.SDK_INT).toString();
    }
}
