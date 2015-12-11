// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.media;

import android.view.MotionEvent;

// Referenced classes of package com.amazon.now.media:
//            FullScreenGalleryActivity, Gallery, PinchImageView

private class <init> extends android.view.istener
{

    final FullScreenGalleryActivity this$0;

    public boolean onDoubleTap(MotionEvent motionevent)
    {
        if (FullScreenGalleryActivity.access$500(FullScreenGalleryActivity.this).getVisibility() == 0)
        {
            FullScreenGalleryActivity.access$500(FullScreenGalleryActivity.this).setVisibility(4);
            FullScreenGalleryActivity.access$400(FullScreenGalleryActivity.this).setVisibility(0);
        }
        FullScreenGalleryActivity.access$400(FullScreenGalleryActivity.this).doubleTapScale(motionevent.getX(), motionevent.getY());
        return true;
    }

    private ()
    {
        this$0 = FullScreenGalleryActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
