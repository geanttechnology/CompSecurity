// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.sources;

import com.rdio.android.audioplayer.interfaces.AudioError;

// Referenced classes of package com.rdio.android.audioplayer.sources:
//            MediaSourceCallbacks, RdioMediaSource, MediaSource

class this._cls0
    implements MediaSourceCallbacks
{

    final RdioMediaSource this$0;

    public void onError(MediaSource mediasource, AudioError audioerror)
    {
        if (audioerror.getType() == com.rdio.android.audioplayer.interfaces.pe.NetworkStreamReadTimeout)
        {
            if (!RdioMediaSource.access$200(RdioMediaSource.this))
            {
                if (audioerror instanceof com.rdio.android.audioplayer.io.AudioStreamAudioError)
                {
                    mediasource = (com.rdio.android.audioplayer.io.AudioStreamAudioError)audioerror;
                    RdioMediaSource.access$302(RdioMediaSource.this, mediasource.getRestartByteOffset());
                    RdioMediaSource.access$322(RdioMediaSource.this, 1024L);
                }
                RdioMediaSource.access$400(RdioMediaSource.this);
            }
            return;
        } else
        {
            raiseOnError(audioerror);
            return;
        }
    }

    public void onProgress(MediaSource mediasource)
    {
        RdioMediaSource.access$100(RdioMediaSource.this);
    }

    public void onReady(MediaSource mediasource)
    {
        RdioMediaSource.access$000(RdioMediaSource.this);
    }

    public void shouldGetAd(MediaSource mediasource)
    {
        raiseShouldGetAd();
    }

    StreamAudioError()
    {
        this$0 = RdioMediaSource.this;
        super();
    }
}
