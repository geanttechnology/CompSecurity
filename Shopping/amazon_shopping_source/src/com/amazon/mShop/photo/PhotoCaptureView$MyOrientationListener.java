// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.photo;

import android.view.OrientationEventListener;

// Referenced classes of package com.amazon.mShop.photo:
//            PhotoCaptureView, PhotoCaptureActivity

private class this._cls0 extends OrientationEventListener
{

    final PhotoCaptureView this$0;

    public void onOrientationChanged(int i)
    {
        if (i != -1)
        {
            PhotoCaptureView.access$402(PhotoCaptureView.this, i);
        }
    }

    public (PhotoCaptureActivity photocaptureactivity)
    {
        this$0 = PhotoCaptureView.this;
        super(photocaptureactivity);
    }
}
