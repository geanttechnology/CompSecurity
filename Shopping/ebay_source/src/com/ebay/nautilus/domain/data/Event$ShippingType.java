// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            Event

public static final class  extends Enum
{

    private static final CalculatedDomestic $VALUES[];
    public static final CalculatedDomestic Calculated;
    public static final CalculatedDomestic CalculatedDomestic;
    public static final CalculatedDomestic CalculatedIntl;
    public static final CalculatedDomestic ContactSeller;
    public static final CalculatedDomestic DigitalDelivery;
    public static final CalculatedDomestic Free;
    public static final CalculatedDomestic Freight;
    public static final CalculatedDomestic LocalDelivery;
    public static final CalculatedDomestic NotSpecified;
    public static final CalculatedDomestic SeeDescription;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/data/Event$ShippingType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NotSpecified = new <init>("NotSpecified", 0);
        ContactSeller = new <init>("ContactSeller", 1);
        SeeDescription = new <init>("SeeDescription", 2);
        LocalDelivery = new <init>("LocalDelivery", 3);
        DigitalDelivery = new <init>("DigitalDelivery", 4);
        Free = new <init>("Free", 5);
        Freight = new <init>("Freight", 6);
        Calculated = new <init>("Calculated", 7);
        CalculatedIntl = new <init>("CalculatedIntl", 8);
        CalculatedDomestic = new <init>("CalculatedDomestic", 9);
        $VALUES = (new .VALUES[] {
            NotSpecified, ContactSeller, SeeDescription, LocalDelivery, DigitalDelivery, Free, Freight, Calculated, CalculatedIntl, CalculatedDomestic
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
