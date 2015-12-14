// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;


// Referenced classes of package com.mopub.nativeads:
//            NativeErrorCode

class this._cls0
    implements this._cls0
{

    final ner.onNativeAdFailed this$0;

    public void onImagesCached()
    {
        cess._mth000(this._cls0.this).onNativeAdLoaded(this._cls0.this);
    }

    public void onImagesFailedToCache(NativeErrorCode nativeerrorcode)
    {
        cess._mth000(this._cls0.this).onNativeAdFailed(nativeerrorcode);
    }

    ner()
    {
        this$0 = this._cls0.this;
        super();
    }
}
