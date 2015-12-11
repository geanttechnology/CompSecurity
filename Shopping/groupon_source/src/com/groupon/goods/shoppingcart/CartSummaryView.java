// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart;

import java.util.List;

public interface CartSummaryView
{

    public abstract void confirmDeleteItem(String s, int i);

    public abstract void enableCheckoutButton(boolean flag);

    public abstract void enableContinueShoppingButton(boolean flag);

    public abstract void finishView();

    public abstract int getProgressViewId();

    public abstract void notifyItemUpdated(int i);

    public abstract void setItems(List list);

    public abstract void setSubTotal(String s);

    public abstract void showEmptyView(boolean flag, boolean flag1);

    public abstract void startCarousel();

    public abstract void startCheckout(int i, String s, String s1);
}
