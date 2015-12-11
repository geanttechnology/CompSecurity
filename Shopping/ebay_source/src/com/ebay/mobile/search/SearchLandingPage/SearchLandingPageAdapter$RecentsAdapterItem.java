// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.SearchLandingPage;

import android.text.TextUtils;

// Referenced classes of package com.ebay.mobile.search.SearchLandingPage:
//            SearchLandingPageAdapter, SearchPrefixType

static class Config.profileImgUrl
{
    static class Config
    {

        long categoryId;
        String categoryName;
        boolean isNewItem;
        String name;
        String profileImgUrl;
        String searchId;

        Config()
        {
            name = "";
            searchId = "";
            categoryName = "";
            categoryId = 0L;
            profileImgUrl = "";
        }
    }

    public static final class ItemType extends Enum
    {

        private static final ItemType $VALUES[];
        public static final ItemType FOLLOWED_MEMBER;
        public static final ItemType FOLLOWED_SEARCH;
        public static final ItemType RECENT_SEARCH;

        public static ItemType valueOf(String s)
        {
            return (ItemType)Enum.valueOf(com/ebay/mobile/search/SearchLandingPage/SearchLandingPageAdapter$RecentsAdapterItem$ItemType, s);
        }

        public static ItemType[] values()
        {
            return (ItemType[])$VALUES.clone();
        }

        static 
        {
            RECENT_SEARCH = new ItemType("RECENT_SEARCH", 0);
            FOLLOWED_SEARCH = new ItemType("FOLLOWED_SEARCH", 1);
            FOLLOWED_MEMBER = new ItemType("FOLLOWED_MEMBER", 2);
            $VALUES = (new ItemType[] {
                RECENT_SEARCH, FOLLOWED_SEARCH, FOLLOWED_MEMBER
            });
        }

        private ItemType(String s, int i)
        {
            super(s, i);
        }
    }


    final long categoryId;
    final String categoryName;
    final boolean isNewItem;
    final String keywords;
    final String name;
    final String profileImgUrl;
    final String searchId;
    final SearchPrefixType searchtype;
    final ItemType type;

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        ay.mobile.search.SearchLandingPage.SearchPrefixType[searchtype.ordinal()];
        JVM INSTR tableswitch 1 3: default 44
    //                   1 70
    //                   2 70
    //                   3 85;
           goto _L1 _L2 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_85;
_L4:
        String s;
        if (!TextUtils.isEmpty(name))
        {
            s = name;
        } else
        {
            s = keywords;
        }
        stringbuilder.append(s);
        return stringbuilder.toString();
_L2:
        stringbuilder.append(searchtype.getName());
          goto _L4
        if (type == ItemType.RECENT_SEARCH)
        {
            stringbuilder.append(searchtype.getName());
        }
          goto _L4
    }

    Config(Config config, String s)
    {
        keywords = config.keywords;
        type = config.type;
        searchtype = config.searchtype;
        isNewItem = config.isNewItem;
        name = config.name;
        searchId = config.searchId;
        categoryName = config.categoryName;
        categoryId = config.categoryId;
        profileImgUrl = s;
    }

    ItemType(String s, ItemType itemtype, SearchPrefixType searchprefixtype)
    {
        keywords = s;
        type = itemtype;
        s = searchprefixtype;
        if (searchprefixtype == null)
        {
            s = SearchPrefixType.NORMAL;
        }
        searchtype = s;
        isNewItem = false;
        categoryName = "";
        categoryId = 0L;
        name = "";
        searchId = "";
        profileImgUrl = "";
    }

    Config(String s, ItemType itemtype, SearchPrefixType searchprefixtype, Config config)
    {
        keywords = s;
        type = itemtype;
        s = searchprefixtype;
        if (searchprefixtype == null)
        {
            s = SearchPrefixType.NORMAL;
        }
        searchtype = s;
        isNewItem = config.isNewItem;
        name = config.name;
        searchId = config.searchId;
        categoryName = config.categoryName;
        categoryId = config.categoryId;
        profileImgUrl = config.profileImgUrl;
    }
}
