// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.image;


// Referenced classes of package com.ebay.nautilus.domain.net.image:
//            ZoomUriBuilder

public static final class extension extends Enum
{

    private static final WEBP $VALUES[];
    public static final WEBP BMP;
    public static final WEBP GIF;
    public static final WEBP JPEG;
    public static final WEBP PNG;
    public static final WEBP WEBP;
    protected final String extension;

    public static extension valueOf(String s)
    {
        return (extension)Enum.valueOf(com/ebay/nautilus/domain/net/image/ZoomUriBuilder$ImageFormat, s);
    }

    public static extension[] values()
    {
        return (extension[])$VALUES.clone();
    }

    static 
    {
        JPEG = new <init>("JPEG", 0, ".jpg");
        GIF = new <init>("GIF", 1, ".gif");
        PNG = new <init>("PNG", 2, ".png");
        BMP = new <init>("BMP", 3, ".bmp");
        WEBP = new <init>("WEBP", 4, ".webp");
        $VALUES = (new .VALUES[] {
            JPEG, GIF, PNG, BMP, WEBP
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        extension = s1;
    }
}
