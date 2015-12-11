// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import co.vine.android.player.SdkVideoView;

// Referenced classes of package co.vine.android.widget:
//            FeedAdapter

class this._cls0
    implements co.vine.android.player.urfaceReadyListener
{

    final FeedAdapter this$0;

    public void onSurfaceTextureAvailable(SdkVideoView sdkvideoview)
    {
        if (FeedAdapter.access$700(FeedAdapter.this) && sdkvideoview == FeedAdapter.access$800(FeedAdapter.this))
        {
            sdkvideoview.startOpenVideo();
        }
    }

    urfaceReadyListener()
    {
        this$0 = FeedAdapter.this;
        super();
    }
}
