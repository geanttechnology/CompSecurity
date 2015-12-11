// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.home;

import android.view.View;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.mash.nav.AmazonNavManager;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.DataUtil;
import com.amazon.mShop.util.Util;
import com.amazon.mShop.util.WebUtils;
import com.amazon.rio.j2me.client.services.mShop.HomeShoveler;
import com.amazon.rio.j2me.client.services.mShop.UniversalLink;

// Referenced classes of package com.amazon.mShop.home:
//            HomeShovelerView

class this._cls0
    implements android.view.r
{

    final HomeShovelerView this$0;

    public void onClick(View view)
    {
        if (HomeShovelerView.access$000(HomeShovelerView.this) != null && HomeShovelerView.access$000(HomeShovelerView.this).getMoreLink() != null)
        {
            if (!Util.isEmpty(HomeShovelerView.access$100(HomeShovelerView.this)))
            {
                RefMarkerObserver.logRefMarker(HomeShovelerView.access$100(HomeShovelerView.this));
            }
            view = (AmazonActivity)getContext();
            String s = HomeShovelerView.access$000(HomeShovelerView.this).getMoreLink().getUri();
            if (Util.isEmpty(s) || !(new AmazonNavManager()).navigate(s, view))
            {
                String s1 = HomeShovelerView.access$000(HomeShovelerView.this).getMoreLink().getUrl();
                if (!Util.isEmpty(s1))
                {
                    if (DataUtil.isEqual(HomeShovelerView.access$000(HomeShovelerView.this).getDisplayType(), 1))
                    {
                        ActivityUtils.startAIVWebActivity(view, s1, false);
                        return;
                    } else
                    {
                        WebUtils.openWebview(view, s1);
                        return;
                    }
                }
            }
        }
    }

    r()
    {
        this$0 = HomeShovelerView.this;
        super();
    }
}
