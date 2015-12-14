// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;


// Referenced classes of package com.mopub.nativeads:
//            MoPubCustomEventVideoNative

static class PubVideoNativeAd.Parameter
{

    static final int $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$Parameter[];
    static final int $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$VideoState[];

    static 
    {
        $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$VideoState = new int[PubVideoNativeAd.VideoState.values().length];
        try
        {
            $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$VideoState[PubVideoNativeAd.VideoState.FAILED_LOAD.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror15) { }
        try
        {
            $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$VideoState[PubVideoNativeAd.VideoState.CREATED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror14) { }
        try
        {
            $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$VideoState[PubVideoNativeAd.VideoState.LOADING.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$VideoState[PubVideoNativeAd.VideoState.BUFFERING.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$VideoState[PubVideoNativeAd.VideoState.PAUSED.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$VideoState[PubVideoNativeAd.VideoState.PLAYING.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$VideoState[PubVideoNativeAd.VideoState.PLAYING_MUTED.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$VideoState[PubVideoNativeAd.VideoState.ENDED.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$Parameter = new int[PubVideoNativeAd.Parameter.values().length];
        try
        {
            $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$Parameter[PubVideoNativeAd.Parameter.IMPRESSION_TRACKER.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$Parameter[PubVideoNativeAd.Parameter.TITLE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$Parameter[PubVideoNativeAd.Parameter.TEXT.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$Parameter[PubVideoNativeAd.Parameter.IMAGE_URL.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$Parameter[PubVideoNativeAd.Parameter.ICON_URL.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$Parameter[PubVideoNativeAd.Parameter.CLICK_DESTINATION.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$Parameter[PubVideoNativeAd.Parameter.CALL_TO_ACTION.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$Parameter[PubVideoNativeAd.Parameter.VAST_VIDEO.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
