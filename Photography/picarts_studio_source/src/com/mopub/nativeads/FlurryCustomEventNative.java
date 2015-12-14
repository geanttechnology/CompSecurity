// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.flurry.android.ads.FlurryAdNative;
import com.mopub.mobileads.FlurryAgentWrapper;
import java.util.Map;

// Referenced classes of package com.mopub.nativeads:
//            CustomEventNative, NativeErrorCode, FlurryForwardingNativeAd

public class FlurryCustomEventNative extends CustomEventNative
{

    private static final String FLURRY_ADSPACE = "adSpaceName";
    private static final String FLURRY_APIKEY = "apiKey";
    private static final String kLogTag = com/mopub/nativeads/FlurryCustomEventNative.getSimpleName();

    public FlurryCustomEventNative()
    {
    }

    private boolean validateExtras(Map map)
    {
        String s = (String)map.get("apiKey");
        map = (String)map.get("adSpaceName");
        Log.i(kLogTag, (new StringBuilder("ServerInfo fetched from Mopub apiKey : ")).append(s).append(" and adSpaceName :").append(map).toString());
        return s != null && s.length() > 0 && map != null && map.length() > 0;
    }

    protected void loadNativeAd(Context context, CustomEventNative.CustomEventNativeListener customeventnativelistener, Map map, Map map1)
    {
        if (context == null)
        {
            Log.e(kLogTag, "Context cannot be null.");
            customeventnativelistener.onNativeAdFailed(NativeErrorCode.NATIVE_ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        if (customeventnativelistener == null)
        {
            Log.e(kLogTag, "CustomEventNativeListener cannot be null.");
            customeventnativelistener.onNativeAdFailed(NativeErrorCode.NATIVE_ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        if (!(context instanceof Activity))
        {
            Log.e(kLogTag, "Ad can be rendered only in Activity context.");
            customeventnativelistener.onNativeAdFailed(NativeErrorCode.NATIVE_ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        if (validateExtras(map1))
        {
            map = (String)map1.get("apiKey");
            map1 = (String)map1.get("adSpaceName");
            FlurryAgentWrapper.getInstance().onStartSession(context, map);
            (new FlurryForwardingNativeAd(context, new FlurryAdNative(context, map1), customeventnativelistener)).fetchAd();
            return;
        } else
        {
            customeventnativelistener.onNativeAdFailed(NativeErrorCode.NATIVE_ADAPTER_CONFIGURATION_ERROR);
            Log.i(kLogTag, "Failed Native AdFetch: Missing required server extras [FLURRY_APIKEY and/or FLURRY_ADSPACE].");
            return;
        }
    }

}
