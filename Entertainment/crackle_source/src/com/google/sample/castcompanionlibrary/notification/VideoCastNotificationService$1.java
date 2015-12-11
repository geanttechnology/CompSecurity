// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.notification;

import com.google.sample.castcompanionlibrary.cast.VideoCastManager;
import com.google.sample.castcompanionlibrary.cast.callbacks.VideoCastConsumerImpl;
import com.google.sample.castcompanionlibrary.utils.LogUtils;

// Referenced classes of package com.google.sample.castcompanionlibrary.notification:
//            VideoCastNotificationService

class this._cls0 extends VideoCastConsumerImpl
{

    final VideoCastNotificationService this$0;

    public void onApplicationDisconnected(int i)
    {
        LogUtils.LOGD(VideoCastNotificationService.access$000(), "onApplicationDisconnected() was reached");
        stopSelf();
    }

    public void onRemoteMediaPlayerStatusUpdated()
    {
        int i = VideoCastNotificationService.access$100(VideoCastNotificationService.this).getPlaybackStatus();
        VideoCastNotificationService.access$200(VideoCastNotificationService.this, i);
    }

    ()
    {
        this$0 = VideoCastNotificationService.this;
        super();
    }
}
