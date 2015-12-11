// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.clickstream;

import com.google.common.base.Preconditions;

// Referenced classes of package com.amazon.avod.clickstream:
//            ClickstreamParam

public final class PageType extends Enum
    implements ClickstreamParam
{

    private static final PageType $VALUES[];
    public static final PageType BROWSE;
    public static final PageType DETAIL;
    public static final PageType DISPATCH;
    public static final PageType FEEDBACK;
    public static final PageType FSK18;
    public static final PageType GEN5_FTUE_TUTORIAL;
    public static final PageType HELP;
    public static final PageType HOME;
    public static final PageType IMDB;
    public static final PageType ITEM_MENU;
    public static final PageType LIBRARY;
    public static final PageType LOGIN;
    public static final PageType PLAYER;
    public static final PageType PRIME_SIGNUP;
    public static final PageType SEARCH;
    public static final PageType SECOND_SCREEN;
    public static final PageType SETTINGS;
    public static final PageType SETUP;
    public static final PageType SWITCH_ACCOUNT;
    public static final PageType WATCHLIST;
    public static final PageType WEBVIEW;
    public static final PageType XRAY;
    private final String mReportableString;

    private PageType(String s, int i, String s1)
    {
        super(s, i);
        boolean flag;
        if (s1.length() <= 17)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "PageType length limit exceeded.");
        mReportableString = s1;
    }

    public static PageType valueOf(String s)
    {
        return (PageType)Enum.valueOf(com/amazon/avod/clickstream/PageType, s);
    }

    public static PageType[] values()
    {
        return (PageType[])$VALUES.clone();
    }

    public String getReportableString()
    {
        return mReportableString;
    }

    static 
    {
        HOME = new PageType("HOME", 0, "Home");
        BROWSE = new PageType("BROWSE", 1, "Browse");
        DETAIL = new PageType("DETAIL", 2, "Detail");
        LIBRARY = new PageType("LIBRARY", 3, "Library");
        WATCHLIST = new PageType("WATCHLIST", 4, "Watchlist");
        SEARCH = new PageType("SEARCH", 5, "Search");
        PLAYER = new PageType("PLAYER", 6, "Player");
        SECOND_SCREEN = new PageType("SECOND_SCREEN", 7, "2ndScreen");
        IMDB = new PageType("IMDB", 8, "Imdb");
        XRAY = new PageType("XRAY", 9, "Xray");
        DISPATCH = new PageType("DISPATCH", 10, "Dispatch");
        SETTINGS = new PageType("SETTINGS", 11, "Settings");
        LOGIN = new PageType("LOGIN", 12, "Login");
        WEBVIEW = new PageType("WEBVIEW", 13, "webview");
        HELP = new PageType("HELP", 14, "Help");
        ITEM_MENU = new PageType("ITEM_MENU", 15, "ItemMenu");
        PRIME_SIGNUP = new PageType("PRIME_SIGNUP", 16, "PrimeSignUp");
        FEEDBACK = new PageType("FEEDBACK", 17, "Feedback");
        GEN5_FTUE_TUTORIAL = new PageType("GEN5_FTUE_TUTORIAL", 18, "Gen5Ftue");
        SWITCH_ACCOUNT = new PageType("SWITCH_ACCOUNT", 19, "SwitchAccount");
        FSK18 = new PageType("FSK18", 20, "FSK18");
        SETUP = new PageType("SETUP", 21, "SETUP");
        $VALUES = (new PageType[] {
            HOME, BROWSE, DETAIL, LIBRARY, WATCHLIST, SEARCH, PLAYER, SECOND_SCREEN, IMDB, XRAY, 
            DISPATCH, SETTINGS, LOGIN, WEBVIEW, HELP, ITEM_MENU, PRIME_SIGNUP, FEEDBACK, GEN5_FTUE_TUTORIAL, SWITCH_ACCOUNT, 
            FSK18, SETUP
        });
    }
}
