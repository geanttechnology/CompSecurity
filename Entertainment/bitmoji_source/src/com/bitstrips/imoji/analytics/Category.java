// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.analytics;


public final class Category extends Enum
{

    private static final Category $VALUES[];
    public static final Category ANALYTICS;
    public static final Category AUTH;
    public static final Category AVATAR;
    public static final Category AVATAR_UX;
    public static final Category BITSHOP;
    public static final Category CUSTOM_SHARE;
    public static final Category DOWNLOAD_FACEBOOK_MESSENGER;
    public static final Category FLOATER;
    public static final Category FROWNY;
    public static final Category INITIAL_LAUNCH;
    public static final Category INVITE;
    public static final Category LOVE;
    public static final Category NUANCED;
    public static final Category POPULAR;
    public static final Category PURCHASED;
    public static final Category RATING;
    public static final Category RECENT;
    public static final Category SHARE_COUNT;
    public static final Category SHARE_FIRST_DAY;
    public static final Category SIGN_UP;
    public static final Category SMILEY;
    public static final Category UNKNOWN;
    public static final Category WACKY;
    private final String name;

    private Category(String s, int i, String s1)
    {
        super(s, i);
        name = s1;
    }

    public static Category getCategoryFromString(String s)
    {
        if (!s.equals("#popmoji")) goto _L2; else goto _L1
_L1:
        Category category = POPULAR;
_L4:
        return category;
_L2:
        Category acategory[] = values();
        int j = acategory.length;
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= j)
                {
                    break label1;
                }
                Category category1 = acategory[i];
                category = category1;
                if (s.equalsIgnoreCase(category1.toString()))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        return UNKNOWN;
    }

    public static Category valueOf(String s)
    {
        return (Category)Enum.valueOf(com/bitstrips/imoji/analytics/Category, s);
    }

    public static Category[] values()
    {
        return (Category[])$VALUES.clone();
    }

    public String toString()
    {
        return name;
    }

    static 
    {
        ANALYTICS = new Category("ANALYTICS", 0, "Analytics");
        AUTH = new Category("AUTH", 1, "Authentication");
        SIGN_UP = new Category("SIGN_UP", 2, "Registration");
        INITIAL_LAUNCH = new Category("INITIAL_LAUNCH", 3, "Initial Launch");
        INVITE = new Category("INVITE", 4, "Invite");
        RATING = new Category("RATING", 5, "Rating");
        DOWNLOAD_FACEBOOK_MESSENGER = new Category("DOWNLOAD_FACEBOOK_MESSENGER", 6, "Download Facebook Messenger");
        SHARE_COUNT = new Category("SHARE_COUNT", 7, "Share Count");
        SHARE_FIRST_DAY = new Category("SHARE_FIRST_DAY", 8, "Shared on First Day");
        FLOATER = new Category("FLOATER", 9, "Floater");
        CUSTOM_SHARE = new Category("CUSTOM_SHARE", 10, "Custom Share");
        AVATAR = new Category("AVATAR", 11, "Avatar Builder");
        AVATAR_UX = new Category("AVATAR_UX", 12, "Avatar Builder UX");
        RECENT = new Category("RECENT", 13, "#recent");
        POPULAR = new Category("POPULAR", 14, "#popular");
        PURCHASED = new Category("PURCHASED", 15, "#purchased");
        SMILEY = new Category("SMILEY", 16, "#ismiley");
        FROWNY = new Category("FROWNY", 17, "#ifrowny");
        LOVE = new Category("LOVE", 18, "#ilove");
        NUANCED = new Category("NUANCED", 19, "#inuanced");
        WACKY = new Category("WACKY", 20, "#iwacky");
        BITSHOP = new Category("BITSHOP", 21, "Bitshop");
        UNKNOWN = new Category("UNKNOWN", 22, "unknown");
        $VALUES = (new Category[] {
            ANALYTICS, AUTH, SIGN_UP, INITIAL_LAUNCH, INVITE, RATING, DOWNLOAD_FACEBOOK_MESSENGER, SHARE_COUNT, SHARE_FIRST_DAY, FLOATER, 
            CUSTOM_SHARE, AVATAR, AVATAR_UX, RECENT, POPULAR, PURCHASED, SMILEY, FROWNY, LOVE, NUANCED, 
            WACKY, BITSHOP, UNKNOWN
        });
    }
}
