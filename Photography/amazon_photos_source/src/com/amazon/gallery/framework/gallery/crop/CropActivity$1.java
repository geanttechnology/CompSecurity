// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.crop;

import uk.co.senab.photoview.PhotoViewAttacher;

// Referenced classes of package com.amazon.gallery.framework.gallery.crop:
//            CropActivity, OverlayView

class this._cls0
    implements eChangedListener
{

    final CropActivity this$0;

    public void sizeChanged(int i, int j, int k, int l)
    {
        if (CropActivity.access$000(CropActivity.this) != null)
        {
            CropActivity.access$000(CropActivity.this).setCustomBounds(CropActivity.access$100(CropActivity.this).getCropRect());
        }
    }

    eChangedListener()
    {
        this$0 = CropActivity.this;
        super();
    }
}
