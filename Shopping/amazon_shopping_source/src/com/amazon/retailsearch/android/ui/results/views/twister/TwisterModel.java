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
            context.editions = new Edition[list.size()];
            context.setEditionsMetadata(editionsmetadata);
            int i = 0;
            do
            {
                s = context;
                if (i >= list.size())
                {
                    continue;
                }
                Object obj = (EditionsPriceInfo)list.get(i);
                if (obj != null && ((EditionsPriceInfo) (obj)).getLink() != null)
                {
                    s = ((EditionsPriceInfo) (obj)).getLink().getText();
                    String s4 = ((EditionsPriceInfo) (obj)).getLink().getUrl();
                    if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s4))
                    {
                        editionsmetadata = ((EditionsPriceInfo) (obj)).getPrice();
                        String s3 = ProductUtil.getPrimeProgramBadgeId(((EditionsPriceInfo) (obj)).getShipping());
                        obj = (new com.amazon.retailsearch.android.api.display.results.item.RetailSearchResultItem.Builder()).build(((EditionsPriceInfo) (obj)).getAsin(), s4, s2, s1);
                        Edition aedition[] = ((TwisterModel) (context)).editions;
                        context.getClass();
                        aedition[i] = context. new Edition(s, editionsmetadata, s3, ((RetailSearchResultItem) (obj)));
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
        protected String text;
        final TwisterModel this$0;

        public Edition(String s, String s1, String s2, RetailSearchResultItem retailsearchresultitem)
        {
            this$0 = TwisterModel.this;
            super();
            text = s;
            price = s1;
            srdsBadgeId = s2;
            resultItem = retailsearchresultitem;
        }
    }


    private Edition editions[];
    private EditionsMetadata editionsMetadata;
    private String editionsType;
    private String productTitle;
    Lazy retailSearchDataProvider;

    protected TwisterModel()
    {
        RetailSearchDaggerGraphController.inject(this);
    }

    public Edition[] getEditions()
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

    public void setEditions(Edition aedition[])
    {
        editions = aedition;
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
    static Edition[] access$002(TwisterModel twistermodel, Edition aedition[])
    {
        twistermodel.editions = aedition;
        return aedition;
    }

*/
}
