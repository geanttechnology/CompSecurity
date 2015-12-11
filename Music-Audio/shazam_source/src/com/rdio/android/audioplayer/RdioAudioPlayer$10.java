// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer;

import com.rdio.android.audioplayer.interfaces.AudioInfo;
import com.rdio.android.audioplayer.interfaces.AudioPlayerListener;

// Referenced classes of package com.rdio.android.audioplayer:
//            RdioAudioPlayer

class o
    implements Runnable
{

    final RdioAudioPlayer this$0;
    final AudioInfo val$info;

    public void run()
    {
        RdioAudioPlayer.access$1900(RdioAudioPlayer.this).onInfo(val$info);
    }

    o()
    {
        this$0 = final_rdioaudioplayer;
        val$info = AudioInfo.this;
        super();
    }
}
