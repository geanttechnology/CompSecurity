// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.media;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

// Referenced classes of package com.amazon.now.media:
//            FullScreenGalleryActivity, PinchImageView

class this._cls0
    implements android.view.ivity._cls1
{

    final FullScreenGalleryActivity this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        FullScreenGalleryActivity.access$200(FullScreenGalleryActivity.this).onTouchEvent(motionevent);
        FullScreenGalleryActivity.access$300(FullScreenGalleryActivity.this).onTouchEvent(motionevent);
        if (FullScreenGalleryActivity.access$400(FullScreenGalleryActivity.this).getVisibility() == 4)
        {
            view.onTouchEvent(motionevent);
        }
        return true;
    }

    ()
    {
        this$0 = FullScreenGalleryActivity.this;
        super();
    }
}
