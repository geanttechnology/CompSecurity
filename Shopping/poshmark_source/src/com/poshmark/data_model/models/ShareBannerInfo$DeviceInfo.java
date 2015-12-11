// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.poshmark.utils.ViewUtils;

// Referenced classes of package com.poshmark.data_model.models:
//            ShareBannerInfo

class width
{

    float height;
    final ShareBannerInfo this$0;
    float width;

    public (Activity activity)
    {
        this$0 = ShareBannerInfo.this;
        super();
        float f = activity.getResources().getDisplayMetrics().widthPixels;
        height = ViewUtils.dipToPixels(activity, 200F);
        width = f;
    }
}
