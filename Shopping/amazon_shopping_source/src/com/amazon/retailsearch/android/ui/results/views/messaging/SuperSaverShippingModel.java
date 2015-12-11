// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import com.amazon.searchapp.retailsearch.model.Shipping;
import java.util.List;

public class SuperSaverShippingModel
{
    public static class Builder
    {

        public SuperSaverShippingModel build(Shipping shipping)
        {
            if (shipping == null || shipping.getSss() == null || shipping.getSss().size() == 0)
            {
                return null;
            } else
            {
                SuperSaverShippingModel supersavershippingmodel = new SuperSaverShippingModel();
                supersavershippingmodel.setSuperSaverShippingStyledText(shipping.getSss());
                return supersavershippingmodel;
            }
        }

        public Builder()
        {
        }
    }


    private List superSaverShippingStyledText;

    public SuperSaverShippingModel()
    {
    }

    public List getSuperSaverShippingStyledText()
    {
        return superSaverShippingStyledText;
    }

    public void setSuperSaverShippingStyledText(List list)
    {
        superSaverShippingStyledText = list;
    }
}
