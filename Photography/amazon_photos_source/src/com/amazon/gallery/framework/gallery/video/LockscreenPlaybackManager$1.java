// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.video;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.amazon.gallery.framework.gallery.video:
//            LockscreenPlaybackManager, GalleryVideoViewer

class this._cls0 extends BroadcastReceiver
{

    final LockscreenPlaybackManager this$0;

    public void onReceive(Context context, Intent intent)
    {
        LockscreenPlaybackManager.access$000(LockscreenPlaybackManager.this).stopVideoPlayer();
        LockscreenPlaybackManager.access$100(LockscreenPlaybackManager.this);
    }

    ()
    {
        this$0 = LockscreenPlaybackManager.this;
        super();
    }
}
