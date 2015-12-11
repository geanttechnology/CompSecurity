// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.widget.FrameLayout;
import com.poshmark.analytics.Analytics;
import com.poshmark.controllers.GlobalDbController;
import com.poshmark.data_model.models.Brand;
import com.poshmark.db.AllBrandsModel;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.customviews.PMImageView;
import com.poshmark.ui.customviews.PMImageViewOnClickListener;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            SuggestedBrandsPickerFragment

class this._cls0
    implements PMImageViewOnClickListener
{

    final SuggestedBrandsPickerFragment this$0;

    public void onClick(final PMImageView parent, final Bundle brand)
    {
        parent = (FrameLayout)parent.getParent();
        int i = brand.getInt("POSITION");
        brand = (Brand)allBrandsModel.data.get(i);
        if (GlobalDbController.getGlobalDbController().isFollowingBrand(((Brand) (brand)).canonical_name))
        {
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "brand", "onramp_brand_unfollowed", null);
            PMApi.unFollowBrand(((Brand) (brand)).canonical_name, new PMApiResponseHandler() {

                final SuggestedBrandsPickerFragment._cls5 this$1;
                final Brand val$brand;
                final FrameLayout val$parent;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (!pmapiresponse.hasError())
                    {
                        GlobalDbController.getGlobalDbController().unFollowBrand(brand.canonical_name);
                        return;
                    } else
                    {
                        SuggestedBrandsPickerFragment.access$300(this$0, parent, 0);
                        showAutoHideProgressDialogWithMessage("Oops!");
                        return;
                    }
                }

            
            {
                this$1 = SuggestedBrandsPickerFragment._cls5.this;
                brand = brand1;
                parent = framelayout;
                super();
            }
            });
            SuggestedBrandsPickerFragment.access$300(SuggestedBrandsPickerFragment.this, parent, 4);
            return;
        } else
        {
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "brand", "onramp_brand_followed", null);
            PMApi.followBrand(((Brand) (brand)).canonical_name, new PMApiResponseHandler() {

                final SuggestedBrandsPickerFragment._cls5 this$1;
                final Brand val$brand;
                final FrameLayout val$parent;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (!pmapiresponse.hasError())
                    {
                        GlobalDbController.getGlobalDbController().followBrand(brand.canonical_name);
                        return;
                    } else
                    {
                        SuggestedBrandsPickerFragment.access$300(this$0, parent, 4);
                        showAutoHideProgressDialogWithMessage("Oops!");
                        return;
                    }
                }

            
            {
                this$1 = SuggestedBrandsPickerFragment._cls5.this;
                brand = brand1;
                parent = framelayout;
                super();
            }
            });
            SuggestedBrandsPickerFragment.access$300(SuggestedBrandsPickerFragment.this, parent, 0);
            return;
        }
    }

    _cls2.val.parent()
    {
        this$0 = SuggestedBrandsPickerFragment.this;
        super();
    }
}
