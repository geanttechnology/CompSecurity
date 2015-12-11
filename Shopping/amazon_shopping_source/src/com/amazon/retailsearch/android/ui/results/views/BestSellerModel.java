// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import android.content.res.Resources;
import android.text.TextUtils;
import com.amazon.searchapp.retailsearch.model.BestSeller;

public class BestSellerModel
{
    public static class Builder
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
                bestsellermodel1.setBadgeId(bestseller.getBadgeAssetId());
                bestsellermodel = bestsellermodel1;
                if (!TextUtils.isEmpty(bestseller.getNode()))
                {
                    bestsellermodel1.setDepartmentLabel(resources.getString(com.amazon.retailsearch.R.string.rs_results_best_seller_department, new Object[] {
                        bestseller.getNode()
                    }));
                    return bestsellermodel1;
                }
            }
            return bestsellermodel;
        }

        public Builder()
        {
        }
    }


    private String badgeId;
    private String departmentLabel;

    public BestSellerModel()
    {
    }

    private void setBadgeId(String s)
    {
        badgeId = s;
    }

    private void setDepartmentLabel(String s)
    {
        departmentLabel = s;
    }

    public String getBadgeId()
    {
        return badgeId;
    }

    public String getDepartmentLabel()
    {
        return departmentLabel;
    }


}
