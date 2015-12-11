// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;


public final class y extends Enum
{

    private static final y $VALUES[];
    public static final y AccountCreate;
    public static final y AccountLogin;
    public static final y AccountLogout;
    public static final y AddToCart;
    public static final y AddToCartFromSaveForLater;
    public static final y AddToList;
    public static final y AddToSaveForLaterFromCart;
    public static final y Checkout;
    public static final y DealsCartwheel;
    public static final y DealsMapProduct;
    public static final y DealsMobileCoupons;
    public static final y EditList;
    public static final y ExpressCheckout;
    public static final y FeaturedCartwheelOffer;
    public static final y FeaturedClearance;
    public static final y FeaturedInternalPromo;
    public static final y FeaturedMiscDialog;
    public static final y FeaturedProduct;
    public static final y FindAisle;
    public static final y FindInAnotherStore;
    public static final y FormInteraction;
    public static final y InStoreCard;
    public static final y LeftNavAccount;
    public static final y LeftNavList;
    public static final y LeftNavMain;
    public static final y LeftNavShop;
    public static final y ListInteraction;
    public static final y ListPromo;
    public static final y MapInteraction;
    public static final y PickUpInStore;
    public static final y PickUpInStoreExpress;
    public static final y PushMessage;
    public static final y RemoveFromCart;
    public static final y RemoveFromCartFromSaveForLater;
    public static final y SearchProduct;
    public static final y SearchRefine;
    public static final y SearchRefineFilter;
    public static final y SearchRefineSort;
    public static final y ShipToMe;
    public static final y TypeAheadRow;
    public static final y Unknown;
    public static final y ViewOnMap;

    private y(String s, int i)
    {
        super(s, i);
    }

    public static y valueOf(String s)
    {
        return (y)Enum.valueOf(com/target/ui/analytics/a/y, s);
    }

    public static y[] values()
    {
        return (y[])$VALUES.clone();
    }

    static 
    {
        AccountCreate = new y("AccountCreate", 0);
        AccountLogin = new y("AccountLogin", 1);
        AccountLogout = new y("AccountLogout", 2);
        AddToCart = new y("AddToCart", 3);
        AddToCartFromSaveForLater = new y("AddToCartFromSaveForLater", 4);
        AddToList = new y("AddToList", 5);
        AddToSaveForLaterFromCart = new y("AddToSaveForLaterFromCart", 6);
        Checkout = new y("Checkout", 7);
        DealsCartwheel = new y("DealsCartwheel", 8);
        DealsMobileCoupons = new y("DealsMobileCoupons", 9);
        DealsMapProduct = new y("DealsMapProduct", 10);
        EditList = new y("EditList", 11);
        ExpressCheckout = new y("ExpressCheckout", 12);
        FeaturedCartwheelOffer = new y("FeaturedCartwheelOffer", 13);
        FeaturedClearance = new y("FeaturedClearance", 14);
        FeaturedProduct = new y("FeaturedProduct", 15);
        FeaturedInternalPromo = new y("FeaturedInternalPromo", 16);
        FeaturedMiscDialog = new y("FeaturedMiscDialog", 17);
        FindAisle = new y("FindAisle", 18);
        FindInAnotherStore = new y("FindInAnotherStore", 19);
        FormInteraction = new y("FormInteraction", 20);
        InStoreCard = new y("InStoreCard", 21);
        ListInteraction = new y("ListInteraction", 22);
        ListPromo = new y("ListPromo", 23);
        MapInteraction = new y("MapInteraction", 24);
        PickUpInStore = new y("PickUpInStore", 25);
        PickUpInStoreExpress = new y("PickUpInStoreExpress", 26);
        RemoveFromCart = new y("RemoveFromCart", 27);
        RemoveFromCartFromSaveForLater = new y("RemoveFromCartFromSaveForLater", 28);
        SearchProduct = new y("SearchProduct", 29);
        SearchRefine = new y("SearchRefine", 30);
        SearchRefineFilter = new y("SearchRefineFilter", 31);
        SearchRefineSort = new y("SearchRefineSort", 32);
        ShipToMe = new y("ShipToMe", 33);
        LeftNavMain = new y("LeftNavMain", 34);
        LeftNavList = new y("LeftNavList", 35);
        LeftNavAccount = new y("LeftNavAccount", 36);
        LeftNavShop = new y("LeftNavShop", 37);
        TypeAheadRow = new y("TypeAheadRow", 38);
        ViewOnMap = new y("ViewOnMap", 39);
        PushMessage = new y("PushMessage", 40);
        Unknown = new y("Unknown", 41);
        $VALUES = (new y[] {
            AccountCreate, AccountLogin, AccountLogout, AddToCart, AddToCartFromSaveForLater, AddToList, AddToSaveForLaterFromCart, Checkout, DealsCartwheel, DealsMobileCoupons, 
            DealsMapProduct, EditList, ExpressCheckout, FeaturedCartwheelOffer, FeaturedClearance, FeaturedProduct, FeaturedInternalPromo, FeaturedMiscDialog, FindAisle, FindInAnotherStore, 
            FormInteraction, InStoreCard, ListInteraction, ListPromo, MapInteraction, PickUpInStore, PickUpInStoreExpress, RemoveFromCart, RemoveFromCartFromSaveForLater, SearchProduct, 
            SearchRefine, SearchRefineFilter, SearchRefineSort, ShipToMe, LeftNavMain, LeftNavList, LeftNavAccount, LeftNavShop, TypeAheadRow, ViewOnMap, 
            PushMessage, Unknown
        });
    }
}
