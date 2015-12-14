// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.app.activity;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.amazon.gallery.app.activity:
//            VideoTrimmerActivity

class this._cls0
    implements android.view.TrimmerActivity._cls10
{

    final VideoTrimmerActivity this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 1)
        {
            VideoTrimmerActivity.access$2200(VideoTrimmerActivity.this);
        }
        return true;
    }

    ()
    {
        this$0 = VideoTrimmerActivity.this;
        super();
    }
}
