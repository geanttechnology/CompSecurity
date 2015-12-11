// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.data;


// Referenced classes of package com.supersonicads.sdk.data:
//            SSAEnums

public static final class  extends Enum
{

    private static final OfferWallCredits $VALUES[];
    public static final OfferWallCredits BrandConnect;
    public static final OfferWallCredits Interstitial;
    public static final OfferWallCredits OfferWall;
    public static final OfferWallCredits OfferWallCredits;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/supersonicads/sdk/data/SSAEnums$ProductType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        BrandConnect = new <init>("BrandConnect", 0);
        OfferWall = new <init>("OfferWall", 1);
        Interstitial = new <init>("Interstitial", 2);
        OfferWallCredits = new <init>("OfferWallCredits", 3);
        $VALUES = (new .VALUES[] {
            BrandConnect, OfferWall, Interstitial, OfferWallCredits
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
