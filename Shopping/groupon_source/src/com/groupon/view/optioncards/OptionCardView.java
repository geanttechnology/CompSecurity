// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.optioncards;


interface OptionCardView
{

    public abstract void alignViewsRtl();

    public abstract void setBought(String s);

    public abstract void setBoughtVisibility(boolean flag);

    public abstract void setDiscount(String s);

    public abstract void setDiscountVisibility(boolean flag);

    public abstract void setPriceColor(int i);

    public abstract void setPriceEnabled(boolean flag);

    public abstract void setPriceText(String s);

    public abstract void setSoldOutOrExpiredOverlayVisibility(boolean flag);

    public abstract void setTitleText(String s);

    public abstract void setUrgencyPricingLabel(String s);

    public abstract void setUrgencyPricingLabelVisibility(boolean flag);
}
