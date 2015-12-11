// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.photo;

import android.view.View;

// Referenced classes of package com.amazon.mShop.photo:
//            PhotoCaptureView

class this._cls0
    implements android.view.r
{

    final PhotoCaptureView this$0;

    public void onClick(View view)
    {
        if (!view.isInTouchMode() && PhotoCaptureView.access$100(PhotoCaptureView.this))
        {
            doAutoFocus(true);
        }
    }

    ()
    {
        this$0 = PhotoCaptureView.this;
        super();
    }
}
