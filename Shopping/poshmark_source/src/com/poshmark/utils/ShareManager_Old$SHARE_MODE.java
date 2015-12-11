// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;


// Referenced classes of package com.poshmark.utils:
//            ShareManager_Old

public static final class  extends Enum
{

    private static final SHARE_MODE_BRAND_JUSTIN $VALUES[];
    public static final SHARE_MODE_BRAND_JUSTIN SHARE_MODE_BRAND;
    public static final SHARE_MODE_BRAND_JUSTIN SHARE_MODE_BRAND_JUSTIN;
    public static final SHARE_MODE_BRAND_JUSTIN SHARE_MODE_CLOSET;
    public static final SHARE_MODE_BRAND_JUSTIN SHARE_MODE_INVITE_FRIENDS;
    public static final SHARE_MODE_BRAND_JUSTIN SHARE_MODE_LISTING;
    public static final SHARE_MODE_BRAND_JUSTIN SHARE_MODE_PARTY;
    public static final SHARE_MODE_BRAND_JUSTIN SHARE_MODE_SHOWROOM;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/utils/ShareManager_Old$SHARE_MODE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SHARE_MODE_LISTING = new <init>("SHARE_MODE_LISTING", 0);
        SHARE_MODE_INVITE_FRIENDS = new <init>("SHARE_MODE_INVITE_FRIENDS", 1);
        SHARE_MODE_PARTY = new <init>("SHARE_MODE_PARTY", 2);
        SHARE_MODE_CLOSET = new <init>("SHARE_MODE_CLOSET", 3);
        SHARE_MODE_SHOWROOM = new <init>("SHARE_MODE_SHOWROOM", 4);
        SHARE_MODE_BRAND = new <init>("SHARE_MODE_BRAND", 5);
        SHARE_MODE_BRAND_JUSTIN = new <init>("SHARE_MODE_BRAND_JUSTIN", 6);
        $VALUES = (new .VALUES[] {
            SHARE_MODE_LISTING, SHARE_MODE_INVITE_FRIENDS, SHARE_MODE_PARTY, SHARE_MODE_CLOSET, SHARE_MODE_SHOWROOM, SHARE_MODE_BRAND, SHARE_MODE_BRAND_JUSTIN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
