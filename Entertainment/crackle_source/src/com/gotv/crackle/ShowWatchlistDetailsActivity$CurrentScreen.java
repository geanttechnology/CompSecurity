// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;


// Referenced classes of package com.gotv.crackle:
//            ShowWatchlistDetailsActivity

private static final class A extends Enum
{

    private static final MEDIA $VALUES[];
    public static final MEDIA CHANNEL;
    public static final MEDIA MEDIA;
    public static final MEDIA PLAYLIST;

    public static A valueOf(String s)
    {
        return (A)Enum.valueOf(com/gotv/crackle/ShowWatchlistDetailsActivity$CurrentScreen, s);
    }

    public static A[] values()
    {
        return (A[])$VALUES.clone();
    }

    static 
    {
        CHANNEL = new <init>("CHANNEL", 0);
        PLAYLIST = new <init>("PLAYLIST", 1);
        MEDIA = new <init>("MEDIA", 2);
        $VALUES = (new .VALUES[] {
            CHANNEL, PLAYLIST, MEDIA
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
