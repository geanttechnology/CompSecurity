// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.os.Handler;

// Referenced classes of package com.mopub.nativeads:
//            PositioningSource, MoPubNativeAdPositioning

class ClientPositioningSource
    implements PositioningSource
{

    private final Handler mHandler = new Handler();
    private final MoPubNativeAdPositioning.MoPubClientPositioning mPositioning;

    ClientPositioningSource(MoPubNativeAdPositioning.MoPubClientPositioning mopubclientpositioning)
    {
        mPositioning = MoPubNativeAdPositioning.clone(mopubclientpositioning);
    }

    public void loadPositions(String s, final PositioningSource.PositioningListener listener)
    {
        mHandler.post(new Runnable() {

            final ClientPositioningSource this$0;
            final PositioningSource.PositioningListener val$listener;

            public void run()
            {
                listener.onLoad(mPositioning);
            }

            
            {
                this$0 = ClientPositioningSource.this;
                listener = positioninglistener;
                super();
            }
        });
    }

}
