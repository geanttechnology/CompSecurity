// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            CaptionData

public static final class  extends Enum
{

    private static final TEXT $VALUES[];
    public static final TEXT PAINT_ON;
    public static final TEXT POP_ON;
    public static final TEXT ROLL_UP;
    public static final TEXT TEXT;
    public static final TEXT UNKNOWN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new <init>("UNKNOWN", 0);
        POP_ON = new <init>("POP_ON", 1);
        ROLL_UP = new <init>("ROLL_UP", 2);
        PAINT_ON = new <init>("PAINT_ON", 3);
        TEXT = new <init>("TEXT", 4);
        $VALUES = (new .VALUES[] {
            UNKNOWN, POP_ON, ROLL_UP, PAINT_ON, TEXT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
