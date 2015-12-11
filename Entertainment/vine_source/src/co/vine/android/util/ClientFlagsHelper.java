// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import co.vine.android.api.VineClientFlags;

// Referenced classes of package co.vine.android.util:
//            Util

public class ClientFlagsHelper
{

    public static final long CLIENTFLAGS_THROTTLE = 0x493e0L;
    public static final String PREF_API_HOST = "client_flags_api_host";
    public static final String PREF_CLIENT_FLAGS_LAST_CHANGED = "client_flags_last_changed_millis";
    public static final String PREF_CLIENT_FLAGS_LAST_CHECKED = "client_flags_last_checked_millis";
    public static final String PREF_CLIENT_FLAGS_TTL = "client_flags_ttl";
    public static final String PREF_EXPLORE_HOST = "client_flags_explore_host";
    public static final String PREF_MEDIA_HOST = "client_flags_media_host";
    public static final String PREF_MESSAGE_TEXT = "client_flags_message_text";
    public static final String PREF_MESSAGE_TITLE = "client_flags_message_title";
    public static final String PREF_RTC_HOST = "client_flags_rtc_host";

    public ClientFlagsHelper()
    {
    }

    public static long getLastCheckMillis(Context context)
    {
        return Util.getDefaultSharedPrefs(context).getLong("client_flags_last_checked_millis", 0L);
    }

    public static boolean hostsDidChange(Context context, VineClientFlags vineclientflags)
    {
        String s;
        String s1;
        Object obj;
        obj = Util.getDefaultSharedPrefs(context);
        context = ((SharedPreferences) (obj)).getString("client_flags_api_host", null);
        s = ((SharedPreferences) (obj)).getString("client_flags_rtc_host", null);
        s1 = ((SharedPreferences) (obj)).getString("client_flags_media_host", null);
        obj = ((SharedPreferences) (obj)).getString("client_flags_explore_host", null);
        if (context == null ? vineclientflags.apiHost != null : !context.equals(vineclientflags.apiHost)) goto _L2; else goto _L1
_L2:
        return true;
_L1:
        if (s == null) goto _L4; else goto _L3
_L3:
        if (!s.equals(vineclientflags.rtcHost)) goto _L2; else goto _L5
_L5:
        if (s1 == null) goto _L7; else goto _L6
_L6:
        if (!s1.equals(vineclientflags.mediaHost)) goto _L2; else goto _L8
_L8:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        if (!((String) (obj)).equals(vineclientflags.exploreHost)) goto _L2; else goto _L9
_L9:
        return false;
_L4:
        if (vineclientflags.rtcHost != null)
        {
            return true;
        }
          goto _L5
_L7:
        if (vineclientflags.mediaHost != null)
        {
            return true;
        }
          goto _L8
        if (vineclientflags.exploreHost != null)
        {
            return true;
        }
          goto _L9
    }

    public static boolean isClientFlagsTtlInRange(Context context)
    {
        context = Util.getDefaultSharedPrefs(context);
        long l = context.getLong("client_flags_last_changed_millis", 0L);
        long l1 = context.getLong("client_flags_ttl", 0L);
        return System.currentTimeMillis() - l < l1;
    }

    public static void setLastCheckMillis(Context context)
    {
        Util.getDefaultSharedPrefs(context).edit().putLong("client_flags_last_checked_millis", System.currentTimeMillis()).apply();
    }

    public static boolean shouldShowClientFlagsBanner(Context context)
    {
        Object obj = Util.getDefaultSharedPrefs(context);
        context = ((SharedPreferences) (obj)).getString("client_flags_message_title", null);
        obj = ((SharedPreferences) (obj)).getString("client_flags_message_text", null);
        return !TextUtils.isEmpty(context) || !TextUtils.isEmpty(((CharSequence) (obj)));
    }

    public static void updateClientFlags(Context context, VineClientFlags vineclientflags)
    {
        context = Util.getDefaultSharedPrefs(context).edit();
        context.putLong("client_flags_ttl", vineclientflags.ttlSeconds * 1000L);
        context.putLong("client_flags_last_changed_millis", System.currentTimeMillis());
        context.putString("client_flags_message_title", vineclientflags.messageTitle);
        context.putString("client_flags_message_text", vineclientflags.messageText);
        context.putString("client_flags_api_host", vineclientflags.apiHost);
        context.putString("client_flags_rtc_host", vineclientflags.rtcHost);
        context.putString("client_flags_media_host", vineclientflags.mediaHost);
        context.putString("client_flags_explore_host", vineclientflags.exploreHost);
        context.apply();
    }

    public static boolean zeroRatingIsEnabled(Context context)
    {
        return !TextUtils.isEmpty(Util.getDefaultSharedPrefs(context).getString("client_flags_api_host", null));
    }
}
