// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer;

import com.rdio.android.audioplayer.interfaces.AudioError;
import com.rdio.android.audioplayer.interfaces.AudioPlayerListener;

// Referenced classes of package com.rdio.android.audioplayer:
//            RdioAudioPlayer

class or
    implements Runnable
{

    final RdioAudioPlayer this$0;
    final AudioError val$error;

    public void run()
    {
        RdioAudioPlayer.access$1900(RdioAudioPlayer.this).onError(val$error);
    }

    or()
    {
        this$0 = final_rdioaudioplayer;
        val$error = AudioError.this;
        super();
    }
}
