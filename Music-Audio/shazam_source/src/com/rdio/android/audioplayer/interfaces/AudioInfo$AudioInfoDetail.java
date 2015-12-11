// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.interfaces;


// Referenced classes of package com.rdio.android.audioplayer.interfaces:
//            AudioInfo

public static final class  extends Enum
{

    private static final AudioStart $VALUES[];
    public static final AudioStart AudioStart;
    public static final AudioStart BufferingEnd;
    public static final AudioStart BufferingStart;
    public static final AudioStart None;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/rdio/android/audioplayer/interfaces/AudioInfo$AudioInfoDetail, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        None = new <init>("None", 0);
        BufferingStart = new <init>("BufferingStart", 1);
        BufferingEnd = new <init>("BufferingEnd", 2);
        AudioStart = new <init>("AudioStart", 3);
        $VALUES = (new .VALUES[] {
            None, BufferingStart, BufferingEnd, AudioStart
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
