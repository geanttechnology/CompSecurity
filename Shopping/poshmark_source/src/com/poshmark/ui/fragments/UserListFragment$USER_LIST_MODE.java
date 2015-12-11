// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;


// Referenced classes of package com.poshmark.ui.fragments:
//            UserListFragment

public static final class  extends Enum
{

    private static final LIKES_MODE $VALUES[];
    public static final LIKES_MODE CLOSETS_SHARED_FIRST;
    public static final LIKES_MODE FB_FRIENDS_MODE;
    public static final LIKES_MODE LIKES_MODE;
    public static final LIKES_MODE NEWLY_JOINED_CLOSETS;
    public static final LIKES_MODE NEWLY_OPENED_CLOSETS;
    public static final LIKES_MODE PM_FOLLOWERS_MODE;
    public static final LIKES_MODE PM_FOLLOWING_MODE;
    public static final LIKES_MODE SEARCH_PEOPLE_MODE;
    public static final LIKES_MODE SECONDARY_SUGGESTED_USERS_MODE;
    public static final LIKES_MODE SUGGESTED_USERS_MODE;
    public static final LIKES_MODE TWITTER_FRIENDS_MODE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SUGGESTED_USERS_MODE = new <init>("SUGGESTED_USERS_MODE", 0);
        SECONDARY_SUGGESTED_USERS_MODE = new <init>("SECONDARY_SUGGESTED_USERS_MODE", 1);
        FB_FRIENDS_MODE = new <init>("FB_FRIENDS_MODE", 2);
        TWITTER_FRIENDS_MODE = new <init>("TWITTER_FRIENDS_MODE", 3);
        PM_FOLLOWERS_MODE = new <init>("PM_FOLLOWERS_MODE", 4);
        PM_FOLLOWING_MODE = new <init>("PM_FOLLOWING_MODE", 5);
        SEARCH_PEOPLE_MODE = new <init>("SEARCH_PEOPLE_MODE", 6);
        CLOSETS_SHARED_FIRST = new <init>("CLOSETS_SHARED_FIRST", 7);
        NEWLY_OPENED_CLOSETS = new <init>("NEWLY_OPENED_CLOSETS", 8);
        NEWLY_JOINED_CLOSETS = new <init>("NEWLY_JOINED_CLOSETS", 9);
        LIKES_MODE = new <init>("LIKES_MODE", 10);
        $VALUES = (new .VALUES[] {
            SUGGESTED_USERS_MODE, SECONDARY_SUGGESTED_USERS_MODE, FB_FRIENDS_MODE, TWITTER_FRIENDS_MODE, PM_FOLLOWERS_MODE, PM_FOLLOWING_MODE, SEARCH_PEOPLE_MODE, CLOSETS_SHARED_FIRST, NEWLY_OPENED_CLOSETS, NEWLY_JOINED_CLOSETS, 
            LIKES_MODE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
