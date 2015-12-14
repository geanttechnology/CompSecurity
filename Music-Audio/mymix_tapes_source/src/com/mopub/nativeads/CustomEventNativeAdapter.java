// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.factories.CustomEventNativeFactory;
import com.mopub.network.AdResponse;
import java.util.Map;

// Referenced classes of package com.mopub.nativeads:
//            CustomEventNative, NativeErrorCode

final class CustomEventNativeAdapter
{

    private CustomEventNativeAdapter()
    {
    }

    public static void loadNativeAd(Context context, Map map, AdResponse adresponse, CustomEventNative.CustomEventNativeListener customeventnativelistener)
    {
        Object obj = adresponse.getCustomEventClassName();
        CustomEventNative customeventnative;
        try
        {
            customeventnative = CustomEventNativeFactory.create(((String) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MoPubLog.w((new StringBuilder()).append("Failed to load Custom Event Native class: ").append(((String) (obj))).toString());
            customeventnativelistener.onNativeAdFailed(NativeErrorCode.NATIVE_ADAPTER_NOT_FOUND);
            return;
        }
        if (adresponse.hasJson())
        {
            map.put("com_mopub_native_json", adresponse.getJsonBody());
        }
        obj = adresponse.getEventDetails();
        if (obj != null)
        {
            map.put("Event-Details", obj);
        }
        map.put("Click-Tracking-Url", adresponse.getClickTrackingUrl());
        try
        {
            customeventnative.loadNativeAd(context, customeventnativelistener, map, adresponse.getServerExtras());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MoPubLog.w("Loading custom event native threw an error.", context);
        }
        customeventnativelistener.onNativeAdFailed(NativeErrorCode.NATIVE_ADAPTER_NOT_FOUND);
    }
}
