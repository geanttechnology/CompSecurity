// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import android.content.res.Resources;
import android.text.TextUtils;
import com.amazon.searchapp.retailsearch.model.BestSeller;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views:
//            BestSellerModel

public static class 
{

    public BestSellerModel build(BestSeller bestseller, Resources resources)
    {
        BestSellerModel bestsellermodel;
        if (bestseller == null || bestseller.getRank() != 1 || TextUtils.isEmpty(bestseller.getBadgeAssetId()))
        {
            bestsellermodel = null;
        } else
        {
            BestSellerModel bestsellermodel1 = new BestSellerModel();
            BestSellerModel.access$000(bestsellermodel1, bestseller.getBadgeAssetId());
            bestsellermodel = bestsellermodel1;
            if (!TextUtils.isEmpty(bestseller.getNode()))
            {
                BestSellerModel.access$100(bestsellermodel1, resources.getString(com.amazon.retailsearch._seller_department, new Object[] {
                    bestseller.getNode()
                }));
                return bestsellermodel1;
            }
        }
        return bestsellermodel;
    }

    public ()
    {
    }
}
