// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import java.util.List;

public class CouponModel
{
    public static class Builder
    {

        private List badgeText;
        private List label;

        public CouponModel build()
        {
            CouponModel couponmodel = new CouponModel();
            couponmodel.setBadgeText(badgeText);
            couponmodel.setLabel(label);
            return couponmodel;
        }

        public Builder setBadgeText(List list)
        {
            badgeText = list;
            return this;
        }

        public Builder setLabel(List list)
        {
            label = list;
            return this;
        }

        public Builder()
        {
        }
    }


    private List badgeText;
    private List label;

    public CouponModel()
    {
    }

    private void setBadgeText(List list)
    {
        badgeText = list;
    }

    private void setLabel(List list)
    {
        label = list;
    }

    public List getBadgeText()
    {
        return badgeText;
    }

    public List getLabel()
    {
        return label;
    }


}
