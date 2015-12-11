// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import android.os.Handler;
import android.widget.LinearLayout;

// Referenced classes of package com.xfinity.playerlib.view.videoplay:
//            VideoPlayerFragment

class this._cls2
    implements Runnable
{

    final ._cls0 this$2;

    public void run()
    {
        VideoPlayerFragment.access$5000(_fld0).setVisibility(8);
    }

    is._cls1()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController$1

/* anonymous class */
    class VideoPlayerFragment.TabletPlayerUIController._cls1
        implements Runnable
    {

        final VideoPlayerFragment.TabletPlayerUIController this$1;

        public void run()
        {
            handler.post(new VideoPlayerFragment.TabletPlayerUIController._cls1._cls1());
        }

            
            {
                this$1 = VideoPlayerFragment.TabletPlayerUIController.this;
                super();
            }
    }

}
