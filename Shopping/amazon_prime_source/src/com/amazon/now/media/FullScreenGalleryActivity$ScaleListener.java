// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.media;

import android.view.ScaleGestureDetector;

// Referenced classes of package com.amazon.now.media:
//            FullScreenGalleryActivity, Gallery, PinchImageView

private class <init> extends android.view.eListener
{

    final FullScreenGalleryActivity this$0;

    public boolean onScale(ScaleGestureDetector scalegesturedetector)
    {
        if (scalegesturedetector.getScaleFactor() <= 1.0F)
        {
            return false;
        }
        if (FullScreenGalleryActivity.access$500(FullScreenGalleryActivity.this).getVisibility() == 0)
        {
            FullScreenGalleryActivity.access$500(FullScreenGalleryActivity.this).setVisibility(4);
            FullScreenGalleryActivity.access$400(FullScreenGalleryActivity.this).setVisibility(0);
        }
        FullScreenGalleryActivity.access$400(FullScreenGalleryActivity.this).updateScale(scalegesturedetector);
        return true;
    }

    private r()
    {
        this$0 = FullScreenGalleryActivity.this;
        super();
    }

    r(r r)
    {
        this();
    }
}
