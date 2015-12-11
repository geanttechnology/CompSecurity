// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util.imageservice;


// Referenced classes of package com.groupon.util.imageservice:
//            ImageCdnUrlBuilder

public static final class extension extends Enum
{

    private static final PNG $VALUES[];
    public static final PNG GIF;
    public static final PNG JPG;
    public static final PNG PNG;
    private String extension;

    public static extension valueOf(String s)
    {
        return (extension)Enum.valueOf(com/groupon/util/imageservice/ImageCdnUrlBuilder$Format, s);
    }

    public static extension[] values()
    {
        return (extension[])$VALUES.clone();
    }

    static 
    {
        GIF = new <init>("GIF", 0, ".gif");
        JPG = new <init>("JPG", 1, ".jpg");
        PNG = new <init>("PNG", 2, ".png");
        $VALUES = (new .VALUES[] {
            GIF, JPG, PNG
        });
    }


    private (String s, int i, String s1)
    {
        super(s, i);
        extension = s1;
    }
}
