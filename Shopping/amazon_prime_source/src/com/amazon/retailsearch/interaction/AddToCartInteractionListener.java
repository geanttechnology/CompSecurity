// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.interaction;

import com.amazon.retailsearch.android.ui.buttons.AddToCartState;

public interface AddToCartInteractionListener
{
    public static interface SearchCartCallback
    {

        public abstract void error();

        public abstract void error(int i, String s, int j);

        public abstract void success();

        public abstract void success(int i, String s, int j);
    }


    public abstract void addToCart(String s, String s1, String s2, String s3, String s4, int i, SearchCartCallback searchcartcallback);

    public abstract void updateCartState(String s, String s1, String s2, AddToCartState addtocartstate);

    public abstract void updateQuantity(String s, String s1, String s2, String s3, int i, SearchCartCallback searchcartcallback);
}
