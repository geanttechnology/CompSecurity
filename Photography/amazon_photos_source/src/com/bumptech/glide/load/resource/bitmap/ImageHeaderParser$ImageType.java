// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;


// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            ImageHeaderParser

public static final class hasAlpha extends Enum
{

    private static final UNKNOWN $VALUES[];
    public static final UNKNOWN GIF;
    public static final UNKNOWN JPEG;
    public static final UNKNOWN PNG;
    public static final UNKNOWN PNG_A;
    public static final UNKNOWN UNKNOWN;
    private final boolean hasAlpha;

    public static hasAlpha valueOf(String s)
    {
        return (hasAlpha)Enum.valueOf(com/bumptech/glide/load/resource/bitmap/ImageHeaderParser$ImageType, s);
    }

    public static hasAlpha[] values()
    {
        return (hasAlpha[])$VALUES.clone();
    }

    public boolean hasAlpha()
    {
        return hasAlpha;
    }

    static 
    {
        GIF = new <init>("GIF", 0, true);
        JPEG = new <init>("JPEG", 1, false);
        PNG_A = new <init>("PNG_A", 2, true);
        PNG = new <init>("PNG", 3, false);
        UNKNOWN = new <init>("UNKNOWN", 4, false);
        $VALUES = (new .VALUES[] {
            GIF, JPEG, PNG_A, PNG, UNKNOWN
        });
    }

    private I(String s, int i, boolean flag)
    {
        super(s, i);
        hasAlpha = flag;
    }
}
