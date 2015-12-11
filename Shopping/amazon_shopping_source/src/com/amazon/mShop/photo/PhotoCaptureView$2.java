// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.photo;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.amazon.mShop.photo:
//            PhotoCaptureView

class this._cls0
    implements android.view.r
{

    final PhotoCaptureView this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 1)
        {
            PhotoCaptureView.access$000(PhotoCaptureView.this);
        }
        return false;
    }

    ()
    {
        this$0 = PhotoCaptureView.this;
        super();
    }
}
