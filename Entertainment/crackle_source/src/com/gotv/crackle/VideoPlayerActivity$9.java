// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.view.MotionEvent;
import android.view.View;
import com.google.util.SystemUiHider;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivity

class this._cls0
    implements android.view.y._cls9
{

    final VideoPlayerActivity this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        VideoPlayerActivity.access$900(VideoPlayerActivity.this).show();
        return false;
    }

    ()
    {
        this$0 = VideoPlayerActivity.this;
        super();
    }
}
