// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;

import com.disney.datg.videoplatforms.sdk.common.AsyncHandler;

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
        getOnErrorListener().onError(LiveMediaPlayer.this, 1, LiveMediaPlayer.STREAM_AUTHORIZATION_ERROR);
    }

    public volatile void onSuccess(Object obj)
    {
        onSuccess((String)obj);
    }

    public void onSuccess(String s)
    {
        prepareAsync();
    }

    ()
    {
        this$0 = LiveMediaPlayer.this;
        super();
    }
}
