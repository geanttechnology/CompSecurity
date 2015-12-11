// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.image;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.experiment.FeatureStateUtil;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.image:
//            ImageWrapper, ThumbSwitcher

public class ImageWrapperGallery extends ImageWrapper
{

    FeatureConfiguration featureConfig;

    public ImageWrapperGallery(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        RetailSearchDaggerGraphController.inject(this);
    }

    protected void postInflate()
    {
        imageView = (ImageView)findViewById(com.amazon.retailsearch.R.id.rs_results_image);
        if (!"C".equals(FeatureStateUtil.getThumbSwitcherWeblab(featureConfig)))
        {
            thumbSwitcher = (ThumbSwitcher)findViewById(com.amazon.retailsearch.R.id.rs_results_thumb_switcher);
        }
    }
}
