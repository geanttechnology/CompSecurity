// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.common;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.ebay.mobile.common:
//            PhotoGalleryWidget

class this._cls0
    implements android.view.yWidget._cls1
{

    final PhotoGalleryWidget this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (PhotoGalleryWidget.access$100(PhotoGalleryWidget.this).booleanValue())
        {
            return onTouchEvent(motionevent);
        } else
        {
            return view.onTouchEvent(motionevent);
        }
    }

    ()
    {
        this$0 = PhotoGalleryWidget.this;
        super();
    }
}
