// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.view.View;

// Referenced classes of package com.mopub.nativeads:
//            NativeVideoViewController, NativeFullScreenVideoView, NativeVideoController

class this._cls0
    implements android.view.ller._cls1
{

    final NativeVideoViewController this$0;

    public void onClick(View view)
    {
        if (NativeVideoViewController.access$000(NativeVideoViewController.this))
        {
            NativeVideoViewController.access$002(NativeVideoViewController.this, false);
            NativeVideoViewController.access$100(NativeVideoViewController.this).resetProgress();
            NativeVideoViewController.access$200(NativeVideoViewController.this).seekTo(0L);
        }
        applyState(deoState.PLAYING);
    }

    deoState()
    {
        this$0 = NativeVideoViewController.this;
        super();
    }
}
