// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.app.activity;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import com.amazon.gallery.thor.widget.RangeSeekBar;

// Referenced classes of package com.amazon.gallery.app.activity:
//            VideoTrimmerActivity

class this._cls0
    implements android.view.oTrimmerActivity._cls5
{

    final VideoTrimmerActivity this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 0: default 24
    //                   0 26;
           goto _L1 _L2
_L1:
        return false;
_L2:
        VideoTrimmerActivity.access$100(VideoTrimmerActivity.this);
        VideoTrimmerActivity.access$400(VideoTrimmerActivity.this).hideProgressMarker();
        VideoTrimmerActivity.access$1102(VideoTrimmerActivity.this, true);
        VideoTrimmerActivity.access$1700(VideoTrimmerActivity.this).removeCallbacks(VideoTrimmerActivity.access$1600(VideoTrimmerActivity.this));
        if (true) goto _L1; else goto _L3
_L3:
    }

    ()
    {
        this$0 = VideoTrimmerActivity.this;
        super();
    }
}
