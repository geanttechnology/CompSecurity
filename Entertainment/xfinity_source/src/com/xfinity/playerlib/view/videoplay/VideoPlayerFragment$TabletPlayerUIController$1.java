// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import android.os.Handler;
import android.widget.LinearLayout;

// Referenced classes of package com.xfinity.playerlib.view.videoplay:
//            VideoPlayerFragment

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        handler.post(new Runnable() {

            final VideoPlayerFragment.TabletPlayerUIController._cls1 this$2;

            public void run()
            {
                VideoPlayerFragment.access$5000(this$0).setVisibility(8);
            }

            
            {
                this$2 = VideoPlayerFragment.TabletPlayerUIController._cls1.this;
                super();
            }
        });
    }

    _cls1.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
    }
}
