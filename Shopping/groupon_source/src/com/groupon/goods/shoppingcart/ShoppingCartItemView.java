// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart;

import java.util.List;

public interface ShoppingCartItemView
{

    public abstract void setImage(String s);

    public abstract void setPrices(String s, String s1);

    public abstract void setQuantity(int i, List list);

    public abstract void setTimeLeft(String s);

    public abstract void setTitle(String s);

    public abstract void showQuantity(boolean flag);

    public abstract void showRemove(boolean flag);

    public abstract void showSoldOut();

    public abstract void showTimeLeft(boolean flag);
}
