// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.price;

import android.content.res.Resources;
import android.text.TextUtils;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.PriceInfo;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.price:
//            SubscribeAndSaveModel

public static class 
{

    public SubscribeAndSaveModel build(PriceInfo priceinfo, boolean flag, ResultLayoutType resultlayouttype, Resources resources)
    {
        if (priceinfo == null || resultlayouttype == null || resources == null)
        {
            priceinfo = null;
        } else
        {
            resultlayouttype = new SubscribeAndSaveModel();
            if (TextUtils.isEmpty(priceinfo.getPrice()))
            {
                return null;
            }
            SubscribeAndSaveModel.access$000(resultlayouttype, priceinfo.getPrice());
            if (priceinfo.getLink() == null || TextUtils.isEmpty(priceinfo.getLink().getText()))
            {
                return null;
            }
            SubscribeAndSaveModel.access$100(resultlayouttype, priceinfo.getLink().getText());
            priceinfo = resultlayouttype;
            if (flag)
            {
                SubscribeAndSaveModel.access$200(resultlayouttype, resources.getString(com.amazon.retailsearch..SubscribeAndSaveModel));
                return resultlayouttype;
            }
        }
        return priceinfo;
    }

    public ()
    {
    }
}
