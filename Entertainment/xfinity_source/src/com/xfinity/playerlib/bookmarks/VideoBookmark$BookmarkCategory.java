// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.bookmarks;


// Referenced classes of package com.xfinity.playerlib.bookmarks:
//            VideoBookmark

public static final class  extends Enum
{

    private static final CATEGORY_RECENT $VALUES[];
    public static final CATEGORY_RECENT CATEGORY_RECENT;
    public static final CATEGORY_RECENT CATEGORY_RESUMEPOINT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        CATEGORY_RESUMEPOINT = new <init>("CATEGORY_RESUMEPOINT", 0);
        CATEGORY_RECENT = new <init>("CATEGORY_RECENT", 1);
        $VALUES = (new .VALUES[] {
            CATEGORY_RESUMEPOINT, CATEGORY_RECENT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
