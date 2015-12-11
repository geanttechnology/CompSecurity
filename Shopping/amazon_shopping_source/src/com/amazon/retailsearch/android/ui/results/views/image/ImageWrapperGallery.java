// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.image;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.image:
//            ImageWrapper

public class ImageWrapperGallery extends ImageWrapper
{

    public ImageWrapperGallery(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected void postInflate()
    {
        imageView = (ImageView)findViewById(com.amazon.retailsearch.R.id.rs_results_image);
    }
}
