// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;

import java.util.TimerTask;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            VPMediaPlayer

class this._cls0 extends TimerTask
{

    final VPMediaPlayer this$0;

    public void run()
    {
        if (isPlaying())
        {
            sendTrackable(ING);
        }
    }

    ()
    {
        this$0 = VPMediaPlayer.this;
        super();
    }
}
