// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wishlist;

import com.amazon.rio.j2me.client.services.mShop.ListList;

public interface WishListChooserSubscriber
{

    public abstract void onListSelected(ListList listlist, int i);
}
