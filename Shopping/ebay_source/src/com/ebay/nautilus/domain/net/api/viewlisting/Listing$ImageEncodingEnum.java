// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class  extends Enum
{

    private static final WEBP $VALUES[];
    public static final WEBP GIF;
    public static final WEBP GMP;
    public static final WEBP JPEG;
    public static final WEBP PNG;
    public static final WEBP WEBP;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$ImageEncodingEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        JPEG = new <init>("JPEG", 0);
        GIF = new <init>("GIF", 1);
        PNG = new <init>("PNG", 2);
        GMP = new <init>("GMP", 3);
        WEBP = new <init>("WEBP", 4);
        $VALUES = (new .VALUES[] {
            JPEG, GIF, PNG, GMP, WEBP
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
