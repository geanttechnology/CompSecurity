// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import android.widget.LinearLayout;
import org.slf4j.Logger;

// Referenced classes of package com.xfinity.playerlib.view.videoplay:
//            VideoPlayerFragment

class this._cls1
    implements Runnable
{

    final this._cls1 this$1;

    public void run()
    {
        VideoPlayerFragment.access$400().debug("Calling hide volume from runnable");
        volumeSliderLayout.setVisibility(4);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
