// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.image;

import com.amazon.mShop.photo.PhotoCaptureActivity;
import com.amazon.mShop.photo.PhotoCaptureView;

// Referenced classes of package com.amazon.mShop.search.image:
//            SnapItPhotoCaptureView, SnapItActivity

public class SnapItPhotoCaptureActivity extends PhotoCaptureActivity
{

    public SnapItPhotoCaptureActivity()
    {
    }

    protected PhotoCaptureView createPhotoCaptureView()
    {
        return new SnapItPhotoCaptureView(this);
    }

    public void handlePhotoTaken(byte abyte0[], int i)
    {
        super.handlePhotoTaken(abyte0, i);
        SnapItActivity.setLastPhotoCaptured(abyte0, i);
        setResult(1001);
        finish();
    }
}
