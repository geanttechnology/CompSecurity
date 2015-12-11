// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopcase.models;


// Referenced classes of package com.ebay.nautilus.domain.net.api.shopcase.models:
//            ShopCart

public static final class Q extends Enum
{

    private static final NOT_OFFERED_ON_SITE $VALUES[];
    public static final NOT_OFFERED_ON_SITE INCLUDED_IN_SHIPPING_HANDLING;
    public static final NOT_OFFERED_ON_SITE NOT_OFFERED;
    public static final NOT_OFFERED_ON_SITE NOT_OFFERED_ON_SITE;
    public static final NOT_OFFERED_ON_SITE OPTIONAL;
    public static final NOT_OFFERED_ON_SITE REQUIRED;

    public static Q valueOf(String s)
    {
        return (Q)Enum.valueOf(com/ebay/nautilus/domain/net/api/shopcase/models/ShopCart$InsuranceCostType, s);
    }

    public static Q[] values()
    {
        return (Q[])$VALUES.clone();
    }

    static 
    {
        OPTIONAL = new <init>("OPTIONAL", 0);
        REQUIRED = new <init>("REQUIRED", 1);
        NOT_OFFERED = new <init>("NOT_OFFERED", 2);
        INCLUDED_IN_SHIPPING_HANDLING = new <init>("INCLUDED_IN_SHIPPING_HANDLING", 3);
        NOT_OFFERED_ON_SITE = new <init>("NOT_OFFERED_ON_SITE", 4);
        $VALUES = (new .VALUES[] {
            OPTIONAL, REQUIRED, NOT_OFFERED, INCLUDED_IN_SHIPPING_HANDLING, NOT_OFFERED_ON_SITE
        });
    }

    private Q(String s, int i)
    {
        super(s, i);
    }
}
