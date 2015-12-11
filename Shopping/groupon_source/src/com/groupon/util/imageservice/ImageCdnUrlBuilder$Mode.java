// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util.imageservice;


// Referenced classes of package com.groupon.util.imageservice:
//            ImageCdnUrlBuilder

public static final class prefix extends Enum
{

    private static final CROP $VALUES[];
    public static final CROP CROP;
    public static final CROP THUMBNAIL;
    private String prefix;

    public static prefix valueOf(String s)
    {
        return (prefix)Enum.valueOf(com/groupon/util/imageservice/ImageCdnUrlBuilder$Mode, s);
    }

    public static prefix[] values()
    {
        return (prefix[])$VALUES.clone();
    }

    static 
    {
        THUMBNAIL = new <init>("THUMBNAIL", 0, "t");
        CROP = new <init>("CROP", 1, "c");
        $VALUES = (new .VALUES[] {
            THUMBNAIL, CROP
        });
    }


    private (String s, int i, String s1)
    {
        super(s, i);
        prefix = s1;
    }
}
