// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.app.activity;

import android.view.ViewPropertyAnimator;
import com.amazon.gallery.thor.widget.RangeSeekBar;

// Referenced classes of package com.amazon.gallery.app.activity:
//            VideoTrimmerActivity

class this._cls0
    implements Runnable
{

    final VideoTrimmerActivity this$0;

    public void run()
    {
        VideoTrimmerActivity.access$400(VideoTrimmerActivity.this).setVisibility(0);
        VideoTrimmerActivity.access$400(VideoTrimmerActivity.this).animate().translationY(0.0F).setStartDelay(1500L).setDuration(400L);
    }

    ()
    {
        this$0 = VideoTrimmerActivity.this;
        super();
    }
}
