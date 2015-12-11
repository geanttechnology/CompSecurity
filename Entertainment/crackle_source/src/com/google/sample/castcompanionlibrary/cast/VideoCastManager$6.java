// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.cast;

import com.google.sample.castcompanionlibrary.utils.LogUtils;

// Referenced classes of package com.google.sample.castcompanionlibrary.cast:
//            VideoCastManager

class this._cls0
    implements com.google.android.gms.cast.nStatusUpdatedListener
{

    final VideoCastManager this$0;

    public void onStatusUpdated()
    {
        LogUtils.LOGD(VideoCastManager.access$000(), "RemoteMediaPlayer::onStatusUpdated() is reached");
        VideoCastManager.access$100(VideoCastManager.this);
    }

    stener()
    {
        this$0 = VideoCastManager.this;
        super();
    }
}
