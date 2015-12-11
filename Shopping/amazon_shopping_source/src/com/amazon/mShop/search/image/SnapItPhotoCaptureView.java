// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.image;

import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import com.amazon.mShop.photo.PhotoCaptureView;

// Referenced classes of package com.amazon.mShop.search.image:
//            SnapItPhotoCaptureActivity

public class SnapItPhotoCaptureView extends PhotoCaptureView
{

    public SnapItPhotoCaptureView(SnapItPhotoCaptureActivity snapitphotocaptureactivity)
    {
        super(snapitphotocaptureactivity);
    }

    public volatile CharSequence getTitle()
    {
        return getTitle();
    }

    public String getTitle()
    {
        return getResources().getString(com.amazon.mShop.android.lib.R.string.snapit_photo_capture_view_title);
    }

    protected View inflateMoreView(FrameLayout framelayout)
    {
        return inflate(getContext(), com.amazon.mShop.android.lib.R.layout.snap_it_more_view, framelayout);
    }
}
