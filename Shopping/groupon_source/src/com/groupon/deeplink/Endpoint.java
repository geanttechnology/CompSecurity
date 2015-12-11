// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.deeplink;


public final class Endpoint extends Enum
{

    private static final Endpoint $VALUES[];
    public static final Endpoint BUSINESS;
    public static final Endpoint BWF;
    public static final Endpoint CARDSEARCH;
    public static final Endpoint CHANNEL;
    public static final Endpoint DEAL;
    public static final Endpoint FREEBIE;
    public static final Endpoint FREEBIE_CATEGORY;
    public static final Endpoint FREEBIE_MERCHANT;
    public static final Endpoint LIVECHAT;
    public static final Endpoint PROFILE;
    public static final Endpoint PURCHASE;
    public static final Endpoint SEARCH;
    public static final Endpoint SEARCH_RESULTS;
    public static final Endpoint SEARCH_RESULTS_WITH_UI;
    public static final Endpoint SHOPPING_CART;
    public static final Endpoint SIKR3TADMIN;
    public static final Endpoint SURVEY;
    public static final Endpoint WEBVIEW;
    public static final Endpoint WIDGETS;

    private Endpoint(String s, int i)
    {
        super(s, i);
    }

    public static Endpoint valueOf(String s)
    {
        return (Endpoint)Enum.valueOf(com/groupon/deeplink/Endpoint, s);
    }

    public static Endpoint[] values()
    {
        return (Endpoint[])$VALUES.clone();
    }

    static 
    {
        CHANNEL = new Endpoint("CHANNEL", 0);
        DEAL = new Endpoint("DEAL", 1);
        PURCHASE = new Endpoint("PURCHASE", 2);
        PROFILE = new Endpoint("PROFILE", 3);
        SEARCH = new Endpoint("SEARCH", 4);
        SHOPPING_CART = new Endpoint("SHOPPING_CART", 5);
        BWF = new Endpoint("BWF", 6);
        WIDGETS = new Endpoint("WIDGETS", 7);
        BUSINESS = new Endpoint("BUSINESS", 8);
        SEARCH_RESULTS = new Endpoint("SEARCH_RESULTS", 9);
        SEARCH_RESULTS_WITH_UI = new Endpoint("SEARCH_RESULTS_WITH_UI", 10);
        FREEBIE = new Endpoint("FREEBIE", 11);
        FREEBIE_MERCHANT = new Endpoint("FREEBIE_MERCHANT", 12);
        FREEBIE_CATEGORY = new Endpoint("FREEBIE_CATEGORY", 13);
        WEBVIEW = new Endpoint("WEBVIEW", 14);
        SURVEY = new Endpoint("SURVEY", 15);
        LIVECHAT = new Endpoint("LIVECHAT", 16);
        SIKR3TADMIN = new Endpoint("SIKR3TADMIN", 17);
        CARDSEARCH = new Endpoint("CARDSEARCH", 18);
        $VALUES = (new Endpoint[] {
            CHANNEL, DEAL, PURCHASE, PROFILE, SEARCH, SHOPPING_CART, BWF, WIDGETS, BUSINESS, SEARCH_RESULTS, 
            SEARCH_RESULTS_WITH_UI, FREEBIE, FREEBIE_MERCHANT, FREEBIE_CATEGORY, WEBVIEW, SURVEY, LIVECHAT, SIKR3TADMIN, CARDSEARCH
        });
    }
}
