// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart;


public interface ShoppingCartControllerListener
{

    public abstract void onCartCancel();

    public abstract void onCartException(Exception exception, boolean flag);

    public abstract void onCartReady();

    public abstract void onItemAdded();
}
