// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.common;


// Referenced classes of package com.xfinity.playerlib.view.common:
//            UpsellDialog

public static final class descriptionResId extends Enum
{

    private static final PLAY_FROM_PLAYER $VALUES[];
    public static final PLAY_FROM_PLAYER DOWNLOAD;
    public static final PLAY_FROM_PLAYER PLAYBACK;
    public static final PLAY_FROM_PLAYER PLAY_DOWNLOADED;
    public static final PLAY_FROM_PLAYER PLAY_FROM_HISTORY;
    public static final PLAY_FROM_PLAYER PLAY_FROM_PLAYER;
    private int descriptionResId;

    public static descriptionResId valueOf(String s)
    {
        return (descriptionResId)Enum.valueOf(com/xfinity/playerlib/view/common/UpsellDialog$UpsellType, s);
    }

    public static descriptionResId[] values()
    {
        return (descriptionResId[])$VALUES.clone();
    }

    public int getDescriptionResId()
    {
        return descriptionResId;
    }

    static 
    {
        PLAYBACK = new <init>("PLAYBACK", 0, com.xfinity.playerlib.quired_playback);
        DOWNLOAD = new <init>("DOWNLOAD", 1, com.xfinity.playerlib.quired_download);
        PLAY_DOWNLOADED = new <init>("PLAY_DOWNLOADED", 2, com.xfinity.playerlib.valid_msg);
        PLAY_FROM_HISTORY = new <init>("PLAY_FROM_HISTORY", 3, com.xfinity.playerlib.valid_msg);
        PLAY_FROM_PLAYER = new <init>("PLAY_FROM_PLAYER", 4, com.xfinity.playerlib._error_msg_subscription_required);
        $VALUES = (new .VALUES[] {
            PLAYBACK, DOWNLOAD, PLAY_DOWNLOADED, PLAY_FROM_HISTORY, PLAY_FROM_PLAYER
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        descriptionResId = j;
    }
}
