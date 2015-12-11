// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer;

import com.rdio.android.audioplayer.extractors.MediaExtractor;
import com.rdio.android.audioplayer.sources.MediaSource;
import java.io.IOException;

// Referenced classes of package com.rdio.android.audioplayer:
//            RdioAudioPlayer

class this._cls0
    implements Runnable
{

    final RdioAudioPlayer this$0;

    public void run()
    {
        RdioAudioPlayer.access$1000(RdioAudioPlayer.this).selectTrack(0);
        if (!RdioAudioPlayer.access$1100(RdioAudioPlayer.this, new com.rdio.android.audioplayer.interfaces.layerState[] {
    com.rdio.android.audioplayer.interfaces.layerState.Prepared
}))
        {
            (new StringBuilder("Process audio interrupted, state is now: ")).append(RdioAudioPlayer.access$200(RdioAudioPlayer.this));
            return;
        }
        try
        {
            if (RdioAudioPlayer.access$1200(RdioAudioPlayer.this) && !RdioAudioPlayer.access$1300(RdioAudioPlayer.this, getCurrentSource().getMediaType()))
            {
                onError(new ioAudioError("performStart() - Could not initialize or configure decoder!", com.rdio.android.audioplayer.interfaces.pe.DecoderError, true));
                RdioAudioPlayer.access$1402(RdioAudioPlayer.this, false);
                return;
            }
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
        onInfo(RdioAudioPlayer.access$1500(RdioAudioPlayer.this));
        RdioAudioPlayer.access$1600(RdioAudioPlayer.this);
    }

    ror.ErrorType()
    {
        this$0 = RdioAudioPlayer.this;
        super();
    }
}
