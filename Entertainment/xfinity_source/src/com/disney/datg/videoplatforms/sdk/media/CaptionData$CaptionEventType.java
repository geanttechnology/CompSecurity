// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            CaptionData

public static final class  extends Enum
{

    private static final LINEBREAK $VALUES[];
    public static final LINEBREAK CLEAR;
    public static final LINEBREAK LINEBREAK;
    public static final LINEBREAK TEXT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TEXT = new <init>("TEXT", 0);
        CLEAR = new <init>("CLEAR", 1);
        LINEBREAK = new <init>("LINEBREAK", 2);
        $VALUES = (new .VALUES[] {
            TEXT, CLEAR, LINEBREAK
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
