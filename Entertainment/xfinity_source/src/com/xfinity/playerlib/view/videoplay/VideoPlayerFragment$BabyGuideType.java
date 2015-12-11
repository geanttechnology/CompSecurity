// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;


// Referenced classes of package com.xfinity.playerlib.view.videoplay:
//            VideoPlayerFragment

private static final class resStringCaptionId extends Enum
{

    private static final BOOKMARKS $VALUES[];
    public static final BOOKMARKS BOOKMARKS;
    public static final BOOKMARKS HISTORY;
    public static final BOOKMARKS INFO;
    private final int resStringCaptionId;

    public static resStringCaptionId valueOf(String s)
    {
        return (resStringCaptionId)Enum.valueOf(com/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType, s);
    }

    public static resStringCaptionId[] values()
    {
        return (resStringCaptionId[])$VALUES.clone();
    }

    public int getCaptionResId()
    {
        return resStringCaptionId;
    }

    static 
    {
        INFO = new <init>("INFO", 0, com.xfinity.playerlib..BabyGuideType);
        HISTORY = new <init>("HISTORY", 1, com.xfinity.playerlib..BabyGuideType);
        BOOKMARKS = new <init>("BOOKMARKS", 2, com.xfinity.playerlib..BabyGuideType);
        $VALUES = (new .VALUES[] {
            INFO, HISTORY, BOOKMARKS
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        resStringCaptionId = j;
    }
}
