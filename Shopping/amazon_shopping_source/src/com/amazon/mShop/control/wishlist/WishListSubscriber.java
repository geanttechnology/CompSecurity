// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.wishlist;

import com.amazon.mShop.model.auth.UserSubscriber;
import java.util.List;

public interface WishListSubscriber
    extends UserSubscriber
{

    public abstract void onListLists(List list);

    public abstract void onWishListItemAdded();
}
