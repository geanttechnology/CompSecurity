// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import java.util.Map;

// Referenced classes of package com.mopub.nativeads:
//            NativeErrorCode, NativeAdInterface

public abstract class CustomEventNative
{
    public static interface CustomEventNativeListener
    {

        public abstract void onNativeAdFailed(NativeErrorCode nativeerrorcode);

        public abstract void onNativeAdLoaded(NativeAdInterface nativeadinterface);
    }

    public static interface ImageListener
    {

        public abstract void onImagesCached();

        public abstract void onImagesFailedToCache(NativeErrorCode nativeerrorcode);
    }


    public CustomEventNative()
    {
    }

    protected abstract void loadNativeAd(Context context, CustomEventNativeListener customeventnativelistener, Map map, Map map1);
}
