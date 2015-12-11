// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            VPCaptionStyle

public static final class size extends Enum
{

    private static final TEXT_SIZE_XLARGE $VALUES[];
    public static final TEXT_SIZE_XLARGE TEXT_SIZE_LARGE;
    public static final TEXT_SIZE_XLARGE TEXT_SIZE_NORMAL;
    public static final TEXT_SIZE_XLARGE TEXT_SIZE_SMALL;
    public static final TEXT_SIZE_XLARGE TEXT_SIZE_XLARGE;
    public static final TEXT_SIZE_XLARGE TEXT_SIZE_XSMALL;
    private int size;

    public static size valueOf(String s)
    {
        return (size)Enum.valueOf(com/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize, s);
    }

    public static size[] values()
    {
        return (size[])$VALUES.clone();
    }

    static 
    {
        TEXT_SIZE_XSMALL = new <init>("TEXT_SIZE_XSMALL", 0, 50);
        TEXT_SIZE_SMALL = new <init>("TEXT_SIZE_SMALL", 1, 75);
        TEXT_SIZE_NORMAL = new <init>("TEXT_SIZE_NORMAL", 2, 100);
        TEXT_SIZE_LARGE = new <init>("TEXT_SIZE_LARGE", 3, 150);
        TEXT_SIZE_XLARGE = new <init>("TEXT_SIZE_XLARGE", 4, 200);
        $VALUES = (new .VALUES[] {
            TEXT_SIZE_XSMALL, TEXT_SIZE_SMALL, TEXT_SIZE_NORMAL, TEXT_SIZE_LARGE, TEXT_SIZE_XLARGE
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        size = j;
    }
}
