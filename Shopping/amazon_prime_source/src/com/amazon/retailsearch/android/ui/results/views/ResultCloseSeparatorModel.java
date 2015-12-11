// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import android.view.View;
import com.amazon.retailsearch.android.ui.results.ContentSwitcherModel;
import com.amazon.retailsearch.android.ui.results.ProductView;
import com.amazon.retailsearch.android.ui.results.ProductViewModel;

public class ResultCloseSeparatorModel
{
    public static class Builder
    {

        public ResultCloseSeparatorModel build(ProductView productview, int i, Class class1, Object obj)
        {
            class1 = new ContentSwitcherModel(i, class1, obj);
            if (productview == null || !class1.isValid())
            {
                return null;
            } else
            {
                return new ResultCloseSeparatorModel(new ResultCloseSeparatorListener(productview, class1));
            }
        }

        public Builder()
        {
        }
    }

    public static class ResultCloseSeparatorListener
        implements android.view.View.OnClickListener
    {

        private final ContentSwitcherModel contentSwitcherModel;
        private final ProductView productView;

        public void onClick(View view)
        {
            productView.getModel().setActiveOffer(null);
            productView.switchViewTypes(contentSwitcherModel);
        }

        public ResultCloseSeparatorListener(ProductView productview, ContentSwitcherModel contentswitchermodel)
        {
            productView = productview;
            contentSwitcherModel = contentswitchermodel;
        }
    }


    private final android.view.View.OnClickListener listener;

    private ResultCloseSeparatorModel(android.view.View.OnClickListener onclicklistener)
    {
        listener = onclicklistener;
    }


    public android.view.View.OnClickListener getListener()
    {
        return listener;
    }
}
