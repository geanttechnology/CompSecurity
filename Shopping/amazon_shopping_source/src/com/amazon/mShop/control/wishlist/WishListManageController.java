// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.wishlist;

import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.model.auth.UserListener;
import com.amazon.rio.j2me.client.services.mShop.ListList;

public class WishListManageController
    implements UserListener
{

    private static WishListManageController sInstance;
    private ListList mCurrentList;

    private WishListManageController()
    {
        User.addUserListener(this);
    }

    public static WishListManageController getInstance()
    {
        com/amazon/mShop/control/wishlist/WishListManageController;
        JVM INSTR monitorenter ;
        WishListManageController wishlistmanagecontroller;
        if (sInstance == null)
        {
            sInstance = new WishListManageController();
        }
        wishlistmanagecontroller = sInstance;
        com/amazon/mShop/control/wishlist/WishListManageController;
        JVM INSTR monitorexit ;
        return wishlistmanagecontroller;
        Exception exception;
        exception;
        throw exception;
    }

    public static void setInstance(WishListManageController wishlistmanagecontroller)
    {
        com/amazon/mShop/control/wishlist/WishListManageController;
        JVM INSTR monitorenter ;
        sInstance = wishlistmanagecontroller;
        com/amazon/mShop/control/wishlist/WishListManageController;
        JVM INSTR monitorexit ;
        return;
        wishlistmanagecontroller;
        throw wishlistmanagecontroller;
    }

    public ListList getCurrentList()
    {
        return mCurrentList;
    }

    public void setCurrentList(ListList listlist)
    {
        mCurrentList = listlist;
    }

    public void userSignedIn(User user)
    {
    }

    public void userSignedOut()
    {
        setCurrentList(null);
    }

    public void userUpdated(User user)
    {
    }
}
