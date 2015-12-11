// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.twister;

import android.content.Context;
import android.text.TextUtils;
import com.amazon.retailsearch.android.api.display.results.item.RetailSearchResultItem;
import com.amazon.retailsearch.android.ui.results.ProductUtil;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.searchapp.retailsearch.model.EditionsMetadata;
import com.amazon.searchapp.retailsearch.model.EditionsPriceInfo;
import com.amazon.searchapp.retailsearch.model.Link;
import dagger.Lazy;
import java.util.ArrayList;
import java.util.List;

public class TwisterModel
{
    public static class Builder
    {

        private static final String AIV_EDITION_TYPE = "digital_video";

        public TwisterModel build(String s, String s1, EditionsMetadata editionsmetadata, List list, String s2, Context context)
        {
            if (s1 != null && list != null && list.size() > 1 && !"digital_video".equals(s1)) goto _L2; else goto _L1
_L1:
            s = null;
_L4:
            return s;
_L2:
            context = new TwisterModel();
            context.setProductTitle(s);
            context.setEditionType(s1);
            context.editions = new ArrayList(list.size());
            context.setEditionsMetadata(editionsmetadata);
            int i = 0;
            do
            {
                s = context;
                if (i >= list.size())
                {
                    continue;
                }
                s = (EditionsPriceInfo)list.get(i);
                if (s != null && s.getLink() != null)
                {
                    editionsmetadata = s.getLink().getText();
                    Object obj = s.getLink().getUrl();
                    if (!TextUtils.isEmpty(((CharSequence) (obj))))
                    {
                        String s3 = s.getPrice();
                        String s4 = ProductUtil.getPrimeProgramBadgeId(s.getShipping());
                        obj = (new com.amazon.retailsearch.android.api.display.results.item.RetailSearchResultItem.Builder()).build(s.getAsin(), ((String) (obj)), s2, s1);
                        List list1 = ((TwisterModel) (context)).editions;
                        context.getClass();
                        list1.add(context. new Edition(editionsmetadata, s3, s4, ((RetailSearchResultItem) (obj)), s.getStyledPrice(), s.getStyledRentalPrice()));
                    }
                }
                i++;
            } while (true);
            if (true) goto _L4; else goto _L3
_L3:
        }

        public Builder()
        {
        }
    }

    protected class Edition
    {

        public String asin;
        protected String price;
        protected RetailSearchResultItem resultItem;
        protected String srdsBadgeId;
        protected List styledPrice;
        protected List styledRentalPrices;
        protected String text;
        final TwisterModel this$0;

        public Edition(String s, String s1, String s2, RetailSearchResultItem retailsearchresultitem, List list, List list1)
        {
            this$0 = TwisterModel.this;
            super();
            text = s;
            price = s1;
            srdsBadgeId = s2;
            resultItem = retailsearchresultitem;
            styledPrice = list;
            styledRentalPrices = list1;
        }
    }


    private List editions;
    private EditionsMetadata editionsMetadata;
    private String editionsType;
    private String productTitle;
    Lazy retailSearchDataProvider;

    protected TwisterModel()
    {
        RetailSearchDaggerGraphController.inject(this);
    }

    public List getEditions()
    {
        return editions;
    }

    public EditionsMetadata getEditionsMetadata()
    {
        return editionsMetadata;
    }

    public String getEditionsType()
    {
        return editionsType;
    }

    public String getProductTitle()
    {
        return productTitle;
    }

    public void setEditionType(String s)
    {
        editionsType = s;
    }

    public void setEditions(List list)
    {
        editions = list;
    }

    public void setEditionsMetadata(EditionsMetadata editionsmetadata)
    {
        editionsMetadata = editionsmetadata;
    }

    public void setProductTitle(String s)
    {
        productTitle = s;
    }



/*
    static List access$002(TwisterModel twistermodel, List list)
    {
        twistermodel.editions = list;
        return list;
    }

*/
}
