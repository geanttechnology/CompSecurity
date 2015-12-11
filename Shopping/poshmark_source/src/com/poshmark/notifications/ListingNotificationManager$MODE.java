// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.notifications;


// Referenced classes of package com.poshmark.notifications:
//            ListingNotificationManager

public static final class  extends Enum
{

    private static final LISTING_COMMENT_ADDED $VALUES[];
    public static final LISTING_COMMENT_ADDED LISTING_COMMENT_ADDED;
    public static final LISTING_COMMENT_ADDED LISTING_EDITED;
    public static final LISTING_COMMENT_ADDED LISTING_LIKED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/notifications/ListingNotificationManager$MODE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LISTING_EDITED = new <init>("LISTING_EDITED", 0);
        LISTING_LIKED = new <init>("LISTING_LIKED", 1);
        LISTING_COMMENT_ADDED = new <init>("LISTING_COMMENT_ADDED", 2);
        $VALUES = (new .VALUES[] {
            LISTING_EDITED, LISTING_LIKED, LISTING_COMMENT_ADDED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
