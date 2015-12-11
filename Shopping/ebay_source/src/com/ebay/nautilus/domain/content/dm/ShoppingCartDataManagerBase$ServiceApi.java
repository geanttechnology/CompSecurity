// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;


// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            ShoppingCartDataManagerBase

public static final class  extends Enum
{

    private static final SHOPCASE $VALUES[];
    public static final SHOPCASE ECAS;
    public static final SHOPCASE SHOPCASE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/content/dm/ShoppingCartDataManagerBase$ServiceApi, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ECAS = new <init>("ECAS", 0);
        SHOPCASE = new <init>("SHOPCASE", 1);
        $VALUES = (new .VALUES[] {
            ECAS, SHOPCASE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
