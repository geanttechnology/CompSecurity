// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import com.mopub.common.logging.MoPubLog;

// Referenced classes of package com.mopub.nativeads:
//            MoPubStreamAdPlacer

class this._cls0
    implements tioningListener
{

    final MoPubStreamAdPlacer this$0;

    public void onFailed()
    {
        MoPubLog.d("Unable to show ads because ad positions could not be loaded from the MoPub ad server.");
    }

    public void onLoad(ng.MoPubClientPositioning mopubclientpositioning)
    {
        MoPubStreamAdPlacer.access$202(MoPubStreamAdPlacer.this, true);
        handlePositioningLoad(mopubclientpositioning);
    }

    ng.MoPubClientPositioning()
    {
        this$0 = MoPubStreamAdPlacer.this;
        super();
    }
}
