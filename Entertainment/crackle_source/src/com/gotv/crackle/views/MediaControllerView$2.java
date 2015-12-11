// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views;

import android.os.Handler;
import com.gotv.crackle.helpers.CrackleVideoHelper;

// Referenced classes of package com.gotv.crackle.views:
//            MediaControllerView

class this._cls0
    implements Runnable
{

    final MediaControllerView this$0;

    public void run()
    {
        if (MediaControllerView.access$300(MediaControllerView.this).isVideoSetup())
        {
            int i = MediaControllerView.access$300(MediaControllerView.this).getCurrentPosition();
            if (MediaControllerView.access$400(MediaControllerView.this) == i && MediaControllerView.access$300(MediaControllerView.this).isPlaying())
            {
                MediaControllerView.access$500(MediaControllerView.this);
                int _tmp = MediaControllerView.access$608(MediaControllerView.this);
                if (MediaControllerView.access$600(MediaControllerView.this) > 200)
                {
                    MediaControllerView.access$100(MediaControllerView.this).onBufferTooLong();
                    MediaControllerView.access$602(MediaControllerView.this, 0);
                }
            } else
            {
                MediaControllerView.access$700(MediaControllerView.this);
                MediaControllerView.access$602(MediaControllerView.this, 0);
            }
            MediaControllerView.access$402(MediaControllerView.this, i);
            if (MediaControllerView.access$800(MediaControllerView.this) > 0)
            {
                MediaControllerView.access$500(MediaControllerView.this);
                if (MediaControllerView.access$300(MediaControllerView.this).getDuration() > 0)
                {
                    MediaControllerView.access$300(MediaControllerView.this).seekTo(MediaControllerView.access$800(MediaControllerView.this));
                    MediaControllerView.access$802(MediaControllerView.this, 0);
                    MediaControllerView.access$902(MediaControllerView.this, true);
                }
            }
        }
        if (MediaControllerView.access$1000(MediaControllerView.this) != null)
        {
            MediaControllerView.access$1100(MediaControllerView.this).postDelayed(MediaControllerView.access$1000(MediaControllerView.this), 600L);
        }
    }

    ntrollerListener()
    {
        this$0 = MediaControllerView.this;
        super();
    }
}
