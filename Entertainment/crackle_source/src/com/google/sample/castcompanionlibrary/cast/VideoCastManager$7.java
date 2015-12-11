// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.cast;

import com.google.sample.castcompanionlibrary.utils.LogUtils;

// Referenced classes of package com.google.sample.castcompanionlibrary.cast:
//            VideoCastManager

class this._cls0
    implements com.google.android.gms.cast.nMetadataUpdatedListener
{

    final VideoCastManager this$0;

    public void onMetadataUpdated()
    {
        LogUtils.LOGD(VideoCastManager.access$000(), "RemoteMediaPlayer::onMetadataUpdated() is reached");
        onRemoteMediaPlayerMetadataUpdated();
    }

    Listener()
    {
        this$0 = VideoCastManager.this;
        super();
    }
}
