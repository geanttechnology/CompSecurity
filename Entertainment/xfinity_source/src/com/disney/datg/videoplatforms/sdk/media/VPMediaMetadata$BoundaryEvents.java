// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            VPMediaMetadata

public static final class  extends Enum
{

    private static final PROGRAM_END $VALUES[];
    public static final PROGRAM_END AD_BREAK_END;
    public static final PROGRAM_END AD_BREAK_START;
    public static final PROGRAM_END AD_END;
    public static final PROGRAM_END AD_START;
    public static final PROGRAM_END PROGRAM_END;
    public static final PROGRAM_END PROGRAM_START;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        AD_START = new <init>("AD_START", 0);
        AD_END = new <init>("AD_END", 1);
        AD_BREAK_START = new <init>("AD_BREAK_START", 2);
        AD_BREAK_END = new <init>("AD_BREAK_END", 3);
        PROGRAM_START = new <init>("PROGRAM_START", 4);
        PROGRAM_END = new <init>("PROGRAM_END", 5);
        $VALUES = (new .VALUES[] {
            AD_START, AD_END, AD_BREAK_START, AD_BREAK_END, PROGRAM_START, PROGRAM_END
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
