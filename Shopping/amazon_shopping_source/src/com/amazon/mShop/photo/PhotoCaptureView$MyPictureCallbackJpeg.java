// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.photo;

import android.hardware.Camera;

// Referenced classes of package com.amazon.mShop.photo:
//            PhotoCaptureView, PhotoCaptureActivity

private class <init>
    implements android.hardware.kJpeg
{

    final PhotoCaptureView this$0;

    public void onPictureTaken(byte abyte0[], Camera camera)
    {
        PhotoCaptureView.access$500(PhotoCaptureView.this).handlePhotoTaken(abyte0, PhotoCaptureView.access$400(PhotoCaptureView.this));
    }

    private ()
    {
        this$0 = PhotoCaptureView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
