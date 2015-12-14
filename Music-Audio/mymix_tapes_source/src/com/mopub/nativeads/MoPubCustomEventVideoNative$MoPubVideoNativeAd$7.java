// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.view.View;

// Referenced classes of package com.mopub.nativeads:
//            MoPubCustomEventVideoNative, NativeVideoController

class this._cls0
    implements android.view.veAd._cls7
{

    final this._cls0 this$0;

    public void onClick(View view)
    {
        cess._mth1200(this._cls0.this);
        cess._mth500(this._cls0.this).triggerImpressionTrackers();
        cess._mth500(this._cls0.this).handleCtaClick(cess._mth200(this._cls0.this));
    }

    ()
    {
        this$0 = this._cls0.this;
        super();
    }
}
