// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer;

import android.util.Log;
import com.rdio.android.audioplayer.interfaces.AudioError;
import com.rdio.android.audioplayer.sources.MediaSource;
import com.rdio.android.audioplayer.sources.MediaSourceCallbacks;

// Referenced classes of package com.rdio.android.audioplayer:
//            RdioAudioPlayer

class this._cls0
    implements MediaSourceCallbacks
{

    final RdioAudioPlayer this$0;

    public void onError(MediaSource mediasource, AudioError audioerror)
    {
        if (mediasource == null || mediasource != getCurrentSource())
        {
            Log.e("RdioAudioPlayer", "Source raised an error, but is not the current source");
            return;
        } else
        {
            RdioAudioPlayer.this.onError(new ioAudioError(audioerror.getDescription(), audioerror.getType(), audioerror.shouldStopPlayback()));
            return;
        }
    }

    public void onProgress(MediaSource mediasource)
    {
    }

    public void onReady(MediaSource mediasource)
    {
    }

    public void shouldGetAd(MediaSource mediasource)
    {
    }

    e()
    {
        this$0 = RdioAudioPlayer.this;
        super();
    }
}
