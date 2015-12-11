// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import android.os.Handler;
import com.comcast.cim.android.accessibility.AlternateInterfaceListener;
import com.comcast.cim.android.accessibility.DefaultSpeechListener;
import com.comcast.cim.android.accessibility.TalkDelegate;

// Referenced classes of package com.xfinity.playerlib.view.videoplay:
//            VideoPlayerFragment

private class <init> extends DefaultSpeechListener
{

    final VideoPlayerFragment this$0;

    public boolean onSpeechResponsePause()
    {
        handler.postDelayed(new <init>(VideoPlayerFragment.this, null), 200L);
        return true;
    }

    public boolean onSpeechResponsePlay(String as[])
    {
        if (as.length == 0)
        {
            if (!VideoPlayerFragment.access$5500(VideoPlayerFragment.this))
            {
                handler.postDelayed(new this._cls0(VideoPlayerFragment.this, null), 200L);
            } else
            {
                VideoPlayerFragment.access$1100(VideoPlayerFragment.this).getTalkDelegate().speak(com.xfinity.playerlib.gate);
            }
            return true;
        } else
        {
            return false;
        }
    }

    public boolean onSpeechResponseSeek(String as[])
    {
        seek(0x1b7740);
        return true;
    }

    private ()
    {
        this$0 = VideoPlayerFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
