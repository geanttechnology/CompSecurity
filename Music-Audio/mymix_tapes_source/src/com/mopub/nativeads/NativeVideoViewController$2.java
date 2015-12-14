// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.view.View;

// Referenced classes of package com.mopub.nativeads:
//            NativeVideoViewController

class this._cls0
    implements android.view.ller._cls2
{

    final NativeVideoViewController this$0;

    public void onClick(View view)
    {
        applyState(deoState.PAUSED, true);
        NativeVideoViewController.access$300(NativeVideoViewController.this).onFinish();
    }

    VideoViewControllerListener()
    {
        this$0 = NativeVideoViewController.this;
        super();
    }
}
