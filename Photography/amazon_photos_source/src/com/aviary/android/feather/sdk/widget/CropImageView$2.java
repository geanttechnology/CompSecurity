// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;


// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            CropImageView

class this._cls0
    implements Runnable
{

    final CropImageView this$0;

    public void run()
    {
        setAspectRatio(mAspectRatio, getAspectRatioIsFixed());
    }

    ()
    {
        this$0 = CropImageView.this;
        super();
    }
}
