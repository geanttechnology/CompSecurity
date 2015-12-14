// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.photoview;

import android.view.MotionEvent;

// Referenced classes of package uk.co.senab.photoview:
//            PhotoViewAttacher

class reListener extends android.view.leOnGestureListener
{

    final PhotoViewAttacher this$0;

    public void onLongPress(MotionEvent motionevent)
    {
        if (PhotoViewAttacher.access$000(PhotoViewAttacher.this) != null)
        {
            PhotoViewAttacher.access$000(PhotoViewAttacher.this).onLongClick(getImageView());
        }
    }

    reListener()
    {
        this$0 = PhotoViewAttacher.this;
        super();
    }
}
