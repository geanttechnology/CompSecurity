// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.buttons;

import android.text.TextUtils;
import com.amazon.retailsearch.android.ui.results.ContentSwitcherModel;
import com.amazon.retailsearch.android.ui.results.ProductView;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;
import com.amazon.retailsearch.util.UrlUtils;
import com.amazon.searchapp.retailsearch.model.ActionButton;
import com.amazon.searchapp.retailsearch.model.EditionsPriceInfo;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.Merchant;
import com.amazon.searchapp.retailsearch.model.Prices;
import com.amazon.searchapp.retailsearch.model.Product;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.buttons:
//            InlineActionsButtonModel, InlineActionsButtonStyle, InlineActionsListener, AddToCartState

public static class isViewOptionsEnabled
{

    private static final String QID_PARAMETER = "qid";
    private static final String SR_PARAMETER = "sr";
    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/android/ui/buttons/InlineActionsButtonModel$Builder);
    private String asin;
    private ContentSwitcherModel contentSwitcherModel;
    private String detailPageUrl;
    private String group;
    private boolean hasMultipleOffers;
    private InlineActionsListener inlineActionsListener;
    private boolean isEnabledForButtonType;
    private boolean isEnabledForStore;
    private boolean isQuantitySwitcherEnabled;
    private boolean isTwisted;
    private boolean isViewOptionsEnabled;
    private String merchantId;
    private EditionsPriceInfo offer;
    private String offerId;
    private ProductView productView;
    private InlineActionsButtonStyle style;
    private boolean useLongText;

    public InlineActionsButtonModel build(Product product, AddToCartState addtocartstate)
    {
        if (product == null || !isEnabledForStore || !isEnabledForButtonType)
        {
            return null;
        }
        asin = product.getAsin();
        offerId = product.getOfferId();
        String s;
        boolean flag;
        if (product.getLink() == null)
        {
            s = "";
        } else
        {
            s = product.getLink().getUrl();
        }
        detailPageUrl = s;
        group = product.getGroup();
        if (product.getMerchant() == null)
        {
            s = "";
        } else
        {
            s = product.getMerchant().getId();
        }
        merchantId = s;
        if (!TextUtils.isEmpty(detailPageUrl) && (product.getPrices() != null && product.getPrices().getEditions() != null && product.getPrices().getEditions().size() > 1 || product.getVariations() != null))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isTwisted = flag;
        if (offer != null)
        {
            merchantId = offer.getMerchantId();
            offerId = offer.getOfferId();
            if (offer.getGroup() != null)
            {
                group = offer.getGroup();
            }
            if (offer.getLink() == null)
            {
                product = "";
            } else
            {
                product = offer.getLink().getUrl();
            }
            if (detailPageUrl == null || !TextUtils.isEmpty(product))
            {
                detailPageUrl = product;
            }
        }
        product = UrlUtils.getParameterValue(detailPageUrl, "qid");
        s = UrlUtils.getParameterValue(detailPageUrl, "sr");
        return new InlineActionsButtonModel(addtocartstate, offer, asin, offerId, merchantId, detailPageUrl, group, product, s, productView, contentSwitcherModel, isTwisted, hasMultipleOffers, useLongText, inlineActionsListener, isQuantitySwitcherEnabled, style, isViewOptionsEnabled, null);
    }

    public isViewOptionsEnabled setHasMultipleOffers(boolean flag)
    {
        hasMultipleOffers = flag;
        return this;
    }

    public hasMultipleOffers setInlineActionsListener(InlineActionsListener inlineactionslistener)
    {
        inlineActionsListener = inlineactionslistener;
        return this;
    }

    public inlineActionsListener setIsEnabledForButtonType(String s, List list)
    {
        if (s == null)
        {
            isEnabledForButtonType = true;
            return this;
        }
        if (list == null)
        {
            isEnabledForButtonType = false;
            return this;
        }
        for (list = list.iterator(); list.hasNext();)
        {
            ActionButton actionbutton = (ActionButton)list.next();
            if (actionbutton != null && s.equals(actionbutton.getType()))
            {
                isEnabledForButtonType = true;
                return this;
            }
        }

        isEnabledForButtonType = false;
        return this;
    }

    public isEnabledForButtonType setIsEnabledForStore(String s, String s1)
    {
        boolean flag;
        if (s != null)
        {
            flag = s.equals(s1);
        } else
        {
            flag = true;
        }
        isEnabledForStore = flag;
        return this;
    }

    public isEnabledForStore setIsQuantitySwitcherEnabled(boolean flag)
    {
        isQuantitySwitcherEnabled = flag;
        return this;
    }

    public isQuantitySwitcherEnabled setIsViewOptionsEnabled(boolean flag)
    {
        isViewOptionsEnabled = flag;
        return this;
    }

    public isViewOptionsEnabled setOffer(EditionsPriceInfo editionspriceinfo)
    {
        offer = editionspriceinfo;
        return this;
    }

    public offer setStyle(InlineActionsButtonStyle inlineactionsbuttonstyle)
    {
        if (inlineactionsbuttonstyle != null)
        {
            style = inlineactionsbuttonstyle;
        }
        return this;
    }

    public style setUseLongText(boolean flag)
    {
        useLongText = flag;
        return this;
    }

    public useLongText setViewSwitching(ProductView productview, ContentSwitcherModel contentswitchermodel)
    {
        productView = productview;
        contentSwitcherModel = contentswitchermodel;
        return this;
    }


    public Q()
    {
        isQuantitySwitcherEnabled = true;
        style = InlineActionsButtonStyle.DEFAULT;
        isEnabledForStore = true;
        isEnabledForButtonType = true;
        isViewOptionsEnabled = true;
    }
}
