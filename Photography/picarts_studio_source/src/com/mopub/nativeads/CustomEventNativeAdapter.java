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
        String s = adresponse.getCustomEventClassName();
        CustomEventNative customeventnative;
        try
        {
            customeventnative = CustomEventNativeFactory.create(s);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MoPubLog.w((new StringBuilder("Failed to load Custom Event Native class: ")).append(s).toString());
            customeventnativelistener.onNativeAdFailed(NativeErrorCode.NATIVE_ADAPTER_NOT_FOUND);
            return;
        }
        if (adresponse.hasJson())
        {
            map.put("com_mopub_native_json", adresponse.getJsonBody());
        }
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
