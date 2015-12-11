// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;

import com.disney.datg.videoplatforms.sdk.common.AsyncHandler;
import com.disney.datg.videoplatforms.sdk.utils.LogUtils;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            LiveMediaPlayer

class this._cls0
    implements AsyncHandler
{

    final LiveMediaPlayer this$0;

    public void onAsyncTask()
    {
    }

    public void onError(Exception exception)
    {
        stop();
        LiveMediaPlayer.access$102(LiveMediaPlayer.this, false);
        getOnErrorListener().onError(LiveMediaPlayer.this, 1, LiveMediaPlayer.STREAM_AUTHORIZATION_ERROR);
    }

    public volatile void onSuccess(Object obj)
    {
        onSuccess((String)obj);
    }

    public void onSuccess(String s)
    {
        LiveMediaPlayer.access$102(LiveMediaPlayer.this, false);
        LiveMediaPlayer.access$202(LiveMediaPlayer.this, false);
        LogUtils.LOGD(LiveMediaPlayer.access$300(), "AUTHZ Success --restarting interval");
        LiveMediaPlayer.access$400(LiveMediaPlayer.this);
    }

    ()
    {
        this$0 = LiveMediaPlayer.this;
        super();
    }
}
