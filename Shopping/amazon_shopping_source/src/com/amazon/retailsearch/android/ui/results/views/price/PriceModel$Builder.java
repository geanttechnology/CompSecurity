// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.price;

import android.text.TextUtils;
import com.amazon.retailsearch.android.ui.results.ProductUtil;
import com.amazon.searchapp.retailsearch.model.EditionsPriceInfo;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.PriceInfo;
import com.amazon.searchapp.retailsearch.model.Prices;
import com.amazon.searchapp.retailsearch.model.Shipping;
import com.amazon.searchapp.retailsearch.model.ShippingStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.price:
//            PriceModel

public static class nfo
{

    private PriceInfo mainPrice;
    private Shipping shippingInfo;

    private String buildSponsoredPriceMsg()
    {
        String s = "";
        boolean flag;
        if (mainPrice.getLink() != null && !TextUtils.isEmpty(mainPrice.getLink().getText()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!TextUtils.isEmpty(mainPrice.getPreLinkText()))
        {
            String s1;
            int i;
            if (flag)
            {
                i = mainPrice.getPreLinkText().length();
            } else
            {
                i = mainPrice.getPreLinkText().lastIndexOf(':');
            }
            s = (new StringBuilder()).append("").append(mainPrice.getPreLinkText().substring(0, i)).toString();
        }
        s1 = s;
        if (flag)
        {
            s1 = s;
            if (!TextUtils.isEmpty(s))
            {
                s1 = (new StringBuilder()).append(s).append(" ").toString();
            }
            s1 = (new StringBuilder()).append(s1).append(mainPrice.getLink().getText()).toString();
        }
        return s1;
    }

    private String getAddonBadgeAssetId()
    {
        if (shippingInfo != null && shippingInfo.getAddOn() != null)
        {
            return shippingInfo.getAddOn().getBadgeAssetId();
        }
        if (mainPrice != null && mainPrice.getShipping() != null && mainPrice.getShipping().getAddOn() != null)
        {
            return mainPrice.getShipping().getAddOn().getBadgeAssetId();
        } else
        {
            return null;
        }
    }

    public PriceModel build(Prices prices, PriceInfo priceinfo, Shipping shipping, boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        mainPrice = priceinfo;
        shippingInfo = shipping;
        if (priceinfo == null)
        {
            prices = null;
        } else
        {
            PriceModel pricemodel = new PriceModel();
            if (flag2)
            {
                pricemodel.setListPrice(priceinfo.getListPrice());
            }
            Object obj;
            if (flag1)
            {
                obj = priceinfo.getPostLinkText();
            } else
            {
                obj = priceinfo.getPrice();
            }
            pricemodel.setPrice(((String) (obj)));
            if (priceinfo.getMap() != null)
            {
                pricemodel.setMapTextId(Integer.valueOf(com.amazon.retailsearch.nstructions));
            }
            if (!TextUtils.isEmpty(priceinfo.getUnitPrice()))
            {
                pricemodel.setUnitOrIssuePrice(priceinfo.getUnitPrice());
            } else
            if (!TextUtils.isEmpty(priceinfo.getIssuePrice()))
            {
                pricemodel.setUnitOrIssuePrice(priceinfo.getIssuePrice());
            }
            priceinfo = ProductUtil.getPrimeProgramBadgeId(ProductUtil.getShipping(prices, shipping));
            obj = getAddonBadgeAssetId();
            if (obj != null)
            {
                pricemodel.setBadgeId(((String) (obj)));
            } else
            if (priceinfo != null)
            {
                pricemodel.setBadgeId(priceinfo);
            }
            pricemodel.setUseEditions(flag);
            if (prices != null && prices.getEditions() != null)
            {
                priceinfo = prices.getEditions();
                prices = new ArrayList(priceinfo.size());
                for (priceinfo = priceinfo.iterator(); priceinfo.hasNext();)
                {
                    obj = (EditionsPriceInfo)priceinfo.next();
                    if (!TextUtils.isEmpty(((EditionsPriceInfo) (obj)).getPrice()))
                    {
                        nfo nfo = new nfo();
                        nfo.setPrice(((EditionsPriceInfo) (obj)).getPrice());
                        nfo.setLabel(((EditionsPriceInfo) (obj)).getLink().getText());
                        prices.add(nfo);
                    }
                }

                pricemodel.setEditions(prices);
            }
            if (flag3 && shipping != null && shipping.getPrime() != null)
            {
                pricemodel.setSomePrimeMsg(shipping.getPrime().getMessage());
            }
            prices = pricemodel;
            if (flag1)
            {
                pricemodel.setSponsoredPriceMsg(buildSponsoredPriceMsg());
                return pricemodel;
            }
        }
        return prices;
    }

    public nfo()
    {
    }
}
