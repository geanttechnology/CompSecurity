// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream;


public final class e extends Enum
{

    private static final e $VALUES[];
    public static final e DEV_TEST_CARD;
    public static final e MOBILE_COUPONS;
    public static final e REQUEST_A_TEAM_MEMBER;
    public static final e SHOPPING_LIST;
    public static final e SHOPPING_LIST_ENGAGEMENT;
    public static final e SHOW_STORE_MAP_VIEW;
    public static final e WEEKLY_AD;
    public static final e WELCOME;

    private e(String s, int i)
    {
        super(s, i);
    }

    public static e valueOf(String s)
    {
        return (e)Enum.valueOf(com/target/ui/fragment/cardstream/e, s);
    }

    public static e[] values()
    {
        return (e[])$VALUES.clone();
    }

    static 
    {
        DEV_TEST_CARD = new e("DEV_TEST_CARD", 0);
        WELCOME = new e("WELCOME", 1);
        SHOW_STORE_MAP_VIEW = new e("SHOW_STORE_MAP_VIEW", 2);
        SHOPPING_LIST_ENGAGEMENT = new e("SHOPPING_LIST_ENGAGEMENT", 3);
        SHOPPING_LIST = new e("SHOPPING_LIST", 4);
        REQUEST_A_TEAM_MEMBER = new e("REQUEST_A_TEAM_MEMBER", 5);
        MOBILE_COUPONS = new e("MOBILE_COUPONS", 6);
        WEEKLY_AD = new e("WEEKLY_AD", 7);
        $VALUES = (new e[] {
            DEV_TEST_CARD, WELCOME, SHOW_STORE_MAP_VIEW, SHOPPING_LIST_ENGAGEMENT, SHOPPING_LIST, REQUEST_A_TEAM_MEMBER, MOBILE_COUPONS, WEEKLY_AD
        });
    }
}
