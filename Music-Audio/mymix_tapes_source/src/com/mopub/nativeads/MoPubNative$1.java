// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;


// Referenced classes of package com.mopub.nativeads:
//            MoPubNative, NativeAd, NativeErrorCode

static final class e
    implements PubNativeNetworkListener
{

    public void onNativeFail(NativeErrorCode nativeerrorcode)
    {
    }

    public void onNativeLoad(NativeAd nativead)
    {
        nativead.destroy();
    }

    e()
    {
    }
}
