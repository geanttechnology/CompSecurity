// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import android.text.TextUtils;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.PriceInfo;

public class EditionLineModel
{
    public static class Builder
    {

        public EditionLineModel build(PriceInfo priceinfo, boolean flag, String s, boolean flag1)
        {
            EditionLineModel editionlinemodel = new EditionLineModel();
            if (flag && !TextUtils.isEmpty(s))
            {
                editionlinemodel.setEditionText(s);
                return editionlinemodel;
            }
            if (!flag && !flag1 && priceinfo != null && priceinfo.getLink() != null && !TextUtils.isEmpty(priceinfo.getLink().getText()))
            {
                editionlinemodel.setEditionText(priceinfo.getLink().getText());
                return editionlinemodel;
            } else
            {
                return null;
            }
        }

        public Builder()
        {
        }
    }


    private String editionText;

    public EditionLineModel()
    {
    }

    public String getEditionText()
    {
        return editionText;
    }

    public void setEditionText(String s)
    {
        editionText = s;
    }
}
