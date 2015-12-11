// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sns;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.details.BuyButtonView;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.Util;
import com.amazon.mobile.mash.constants.WebConstants;
import com.amazon.rio.j2me.client.persistence.DataStore;

// Referenced classes of package com.amazon.mShop.sns:
//            SnsWebViewActivity

public class SnsAction
    implements android.view.View.OnClickListener
{

    private final Context mContext;
    private final ProductController mProductController;

    public SnsAction(Context context, ProductController productcontroller)
    {
        mContext = context;
        mProductController = productcontroller;
    }

    public void onClick(View view)
    {
        String s2;
        Resources resources;
        resources = mContext.getResources();
        s2 = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("currentSnsDetail");
        String s = s2;
        if (Util.isEmpty(s2))
        {
            s = resources.getString(com.amazon.mShop.android.lib.R.string.sns_detail_webpage);
        }
        s2 = (new StringBuilder()).append(s).append(mProductController.getAsin()).toString();
        if (!(view instanceof BuyButtonView)) goto _L2; else goto _L1
_L1:
        String s1 = resources.getString(com.amazon.mShop.android.lib.R.string.sns_url_with_refmarker, new Object[] {
            s2, "rcxsubs_ap_am_native_buybox"
        });
_L4:
        view = new Intent(mContext, com/amazon/mShop/sns/SnsWebViewActivity);
        view.putExtra(WebConstants.getWebViewUrlKey(), s1);
        mContext.startActivity(view);
        return;
_L2:
        s1 = s2;
        if (view instanceof LinearLayout)
        {
            s1 = resources.getString(com.amazon.mShop.android.lib.R.string.sns_url_with_refmarker, new Object[] {
                s2, "rcxsubs_ap_am_native_priceblock"
            });
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
