// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.SearchLandingPage;


// Referenced classes of package com.ebay.mobile.search.SearchLandingPage:
//            SearchLandingPageAdapter

public static final class  extends Enum
{

    private static final FOLLOWED_MEMBER $VALUES[];
    public static final FOLLOWED_MEMBER FOLLOWED_MEMBER;
    public static final FOLLOWED_MEMBER FOLLOWED_SEARCH;
    public static final FOLLOWED_MEMBER RECENT_SEARCH;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/search/SearchLandingPage/SearchLandingPageAdapter$RecentsAdapterItem$ItemType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        RECENT_SEARCH = new <init>("RECENT_SEARCH", 0);
        FOLLOWED_SEARCH = new <init>("FOLLOWED_SEARCH", 1);
        FOLLOWED_MEMBER = new <init>("FOLLOWED_MEMBER", 2);
        $VALUES = (new .VALUES[] {
            RECENT_SEARCH, FOLLOWED_SEARCH, FOLLOWED_MEMBER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
