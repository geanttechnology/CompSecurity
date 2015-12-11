// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.net.Uri;
import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.controllers.GlobalDbController;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiRequest;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;

// Referenced classes of package com.poshmark.ui.customviews:
//            BrandFollowButtonLayout

class this._cls0
    implements android.view.ButtonLayout._cls1
{

    final BrandFollowButtonLayout this$0;

    public void onClick(View view)
    {
        BrandFollowButtonLayout.access$000(BrandFollowButtonLayout.this, false);
        if (!isFollowing)
        {
            if (screenNameForAnalytics != null)
            {
                Analytics.getInstance().trackEvent(screenNameForAnalytics, "brand", "brand_followed", null);
            }
            PMApi.followBrand(brandName, new PMApiResponseHandler() {

                final BrandFollowButtonLayout._cls1 this$1;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (!pmapiresponse.hasError())
                    {
                        String s = brandName.replace("/", "%2F");
                        if (pmapiresponse.apiRequest.url.contains(Uri.encode(s)))
                        {
                            isFollowing = true;
                            BrandFollowButtonLayout.access$100(this$0);
                            GlobalDbController.getGlobalDbController().followBrand(brandName);
                            BrandFollowButtonLayout.access$200(this$0);
                        }
                    } else
                    {
                        BrandFollowButtonLayout.access$300(this$0);
                    }
                    BrandFollowButtonLayout.access$000(this$0, true);
                }

            
            {
                this$1 = BrandFollowButtonLayout._cls1.this;
                super();
            }
            });
            return;
        }
        if (screenNameForAnalytics != null)
        {
            Analytics.getInstance().trackEvent(screenNameForAnalytics, "brand", "brand_unfollowed", null);
        }
        PMApi.unFollowBrand(brandName, new PMApiResponseHandler() {

            final BrandFollowButtonLayout._cls1 this$1;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                if (!pmapiresponse.hasError())
                {
                    String s = brandName.replace("/", "%2F");
                    if (pmapiresponse.apiRequest.url.contains(Uri.encode(s)))
                    {
                        isFollowing = false;
                        BrandFollowButtonLayout.access$300(this$0);
                        GlobalDbController.getGlobalDbController().unFollowBrand(brandName);
                        BrandFollowButtonLayout.access$200(this$0);
                    }
                } else
                {
                    BrandFollowButtonLayout.access$100(this$0);
                }
                BrandFollowButtonLayout.access$000(this$0, true);
            }

            
            {
                this$1 = BrandFollowButtonLayout._cls1.this;
                super();
            }
        });
    }

    _cls2.this._cls1()
    {
        this$0 = BrandFollowButtonLayout.this;
        super();
    }
}
