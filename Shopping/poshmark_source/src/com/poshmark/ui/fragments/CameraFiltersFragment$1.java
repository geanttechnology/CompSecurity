// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.ui.customviews.PMListingImageView;
import com.poshmark.utils.ImageUtils;

// Referenced classes of package com.poshmark.ui.fragments:
//            CameraFiltersFragment

class this._cls0
    implements android.view.rsFragment._cls1
{

    final CameraFiltersFragment this$0;

    public void onClick(View view)
    {
        view = new Intent();
        Bundle bundle = new Bundle();
        bundle.putParcelable("ORIGINALFILE", fileName);
        if (currentFilter != null)
        {
            bundle.putParcelable("FILTEREDFILE", ImageUtils.saveDrawableToDisk(imageView.getDrawable()));
            String s = CameraFiltersFragment.access$000(CameraFiltersFragment.this, currentFilter);
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "image_filter_selected", s);
        } else
        {
            bundle.putParcelable("FILTEREDFILE", fileName);
        }
        view.putExtras(bundle);
        finishActivityWithResult(-1, view);
    }

    ()
    {
        this$0 = CameraFiltersFragment.this;
        super();
    }
}
