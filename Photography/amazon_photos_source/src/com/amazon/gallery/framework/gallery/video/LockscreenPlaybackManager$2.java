// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.video;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.amazon.gallery.foundation.utils.log.GLogger;

// Referenced classes of package com.amazon.gallery.framework.gallery.video:
//            LockscreenPlaybackManager

class this._cls0 extends BroadcastReceiver
{

    final LockscreenPlaybackManager this$0;

    public void onReceive(Context context, Intent intent)
    {
        GLogger.i(LockscreenPlaybackManager.access$200(), "Screen is turned off", new Object[0]);
        LockscreenPlaybackManager.access$302(LockscreenPlaybackManager.this, true);
        LockscreenPlaybackManager.access$400(LockscreenPlaybackManager.this);
    }

    ()
    {
        this$0 = LockscreenPlaybackManager.this;
        super();
    }
}
