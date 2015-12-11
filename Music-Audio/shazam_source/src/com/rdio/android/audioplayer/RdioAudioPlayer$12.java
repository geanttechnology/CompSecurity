// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer;

import com.rdio.android.audioplayer.sources.MediaSource;

// Referenced classes of package com.rdio.android.audioplayer:
//            RdioAudioPlayer

class this._cls0
    implements Runnable
{

    final RdioAudioPlayer this$0;

    public void run()
    {
        if (getCurrentSource() != null)
        {
            getCurrentSource().removeCallbacksListener(RdioAudioPlayer.access$600(RdioAudioPlayer.this));
        }
    }

    ()
    {
        this$0 = RdioAudioPlayer.this;
        super();
    }
}
