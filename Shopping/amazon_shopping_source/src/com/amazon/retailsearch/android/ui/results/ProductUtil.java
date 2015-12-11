// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;

import android.content.res.Resources;
import com.amazon.searchapp.retailsearch.model.EditionsPriceInfo;
import com.amazon.searchapp.retailsearch.model.FKMR;
import com.amazon.searchapp.retailsearch.model.Prices;
import com.amazon.searchapp.retailsearch.model.Product;
import com.amazon.searchapp.retailsearch.model.ProductSection;
import com.amazon.searchapp.retailsearch.model.Shipping;
import com.amazon.searchapp.retailsearch.model.ShippingStatus;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;

public class ProductUtil
{

    public static final int ACTION_ICON_RADIUS = 23;

    public ProductUtil()
    {
    }

    public static String formatNumber(long l)
    {
        return NumberFormat.getInstance().format(l);
    }

    public static String formatReviewCount(int i, Resources resources)
    {
        if (i < 1)
        {
            return "";
        }
        if (i == 1)
        {
            return resources.getString(com.amazon.retailsearch.R.string.product_review_single);
        } else
        {
            return resources.getString(com.amazon.retailsearch.R.string.product_review_count, new Object[] {
                NumberFormat.getInstance().format(i)
            });
        }
    }

    public static int getFkmrProductCount(FKMR fkmr)
    {
        if (fkmr != null && fkmr.getResults() != null && fkmr.getResults().getItems() != null)
        {
            return fkmr.getResults().getItems().size();
        } else
        {
            return 0;
        }
    }

    public static List getImageGallery(Product product)
    {
        if (product == null)
        {
            return null;
        }
        if (product.getImageGallery() != null && product.getImageGallery().size() > 0)
        {
            return product.getImageGallery();
        } else
        {
            return product.getAltImages();
        }
    }

    public static String getPrimeProgramBadgeId(Shipping shipping)
    {
label0:
        {
            if (shipping == null)
            {
                break label0;
            }
            if (shipping.getPrime() != null && shipping.getPrime().getHasBadge())
            {
                return shipping.getPrime().getBadgeAssetId();
            }
            if (shipping.getAdditionalStatus() == null || shipping.getAdditionalStatus().isEmpty())
            {
                break label0;
            }
            shipping = shipping.getAdditionalStatus().iterator();
            ShippingStatus shippingstatus;
            do
            {
                if (!shipping.hasNext())
                {
                    break label0;
                }
                shippingstatus = (ShippingStatus)shipping.next();
            } while (!shippingstatus.getHasBadge());
            return shippingstatus.getBadgeAssetId();
        }
        return null;
    }

    public static Shipping getShipping(Prices prices, Shipping shipping)
    {
        Shipping shipping1 = shipping;
        if (prices != null)
        {
            shipping1 = shipping;
            if (prices.getEditions() != null)
            {
                shipping1 = shipping;
                if (!prices.getEditions().isEmpty())
                {
                    shipping1 = ((EditionsPriceInfo)prices.getEditions().get(0)).getShipping();
                }
            }
        }
        return shipping1;
    }
}
