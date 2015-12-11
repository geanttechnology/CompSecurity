// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;

import android.widget.RelativeLayout;
import com.uplynk.media.MediaPlayer;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            VPMediaPlayer

class val.ccContainer
    implements Runnable
{

    final VPMediaPlayer this$0;
    final RelativeLayout val$ccContainer;

    public void run()
    {
        uplynkMediaPlayer.setCaptionLayoutContainer(val$ccContainer);
    }

    ()
    {
        this$0 = final_vpmediaplayer;
        val$ccContainer = RelativeLayout.this;
        super();
    }
}
