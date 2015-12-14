// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import com.mopub.mobileads.VastManager;

// Referenced classes of package com.mopub.nativeads:
//            MoPubCustomEventVideoNative, NativeErrorCode

class this._cls0
    implements this._cls0
{

    final iveAdFailed this$0;

    public void onImagesCached()
    {
        cess._mth300(this._cls0.this).prepareVastVideoConfiguration(tVastVideo(), this._cls0.this, cess._mth200(this._cls0.this));
    }

    public void onImagesFailedToCache(NativeErrorCode nativeerrorcode)
    {
        cess._mth400(this._cls0.this).iveAdFailed(nativeerrorcode);
    }

    ()
    {
        this$0 = this._cls0.this;
        super();
    }
}
