// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.feeds;


// Referenced classes of package com.pointinside.feeds:
//            PlaceEntity

public static final class  extends Enum
{

    private static final Product $VALUES[];
    public static final Product Place;
    public static final Product Product;
    public static final Product Service;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/pointinside/feeds/PlaceEntity$PlaceType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Place = new <init>("Place", 0);
        Service = new <init>("Service", 1);
        Product = new <init>("Product", 2);
        $VALUES = (new .VALUES[] {
            Place, Service, Product
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
