// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.shippinglabel;


// Referenced classes of package com.ebay.mobile.sell.shippinglabel:
//            ShippingLabelFragment

private static final class displayString extends Enum
{

    private static final SIG_CONFIRMATION $VALUES[];
    public static final SIG_CONFIRMATION DEL_CONFIRMATION;
    public static final SIG_CONFIRMATION EBAY_DIS;
    public static final SIG_CONFIRMATION FUEL_SURCHARGE;
    public static final SIG_CONFIRMATION INSURANCE_COST;
    public static final SIG_CONFIRMATION NONMAC_SRCHRG;
    public static final SIG_CONFIRMATION OTHER_SURCHARGES;
    public static final SIG_CONFIRMATION POSTAGE_COST;
    public static final SIG_CONFIRMATION RESI_SURCHARGE;
    public static final SIG_CONFIRMATION RETAIL_RATE;
    public static final SIG_CONFIRMATION SIG_CONFIRMATION;
    public int displayString;

    public static displayString valueOf(String s)
    {
        return (displayString)Enum.valueOf(com/ebay/mobile/sell/shippinglabel/ShippingLabelFragment$CostLineItemValues, s);
    }

    public static displayString[] values()
    {
        return (displayString[])$VALUES.clone();
    }

    static 
    {
        EBAY_DIS = new <init>("EBAY_DIS", 0, 0x7f070832);
        RETAIL_RATE = new <init>("RETAIL_RATE", 1, 0x7f07086c);
        POSTAGE_COST = new <init>("POSTAGE_COST", 2, 0x7f07085a);
        INSURANCE_COST = new <init>("INSURANCE_COST", 3, 0x7f070846);
        FUEL_SURCHARGE = new <init>("FUEL_SURCHARGE", 4, 0x7f070840);
        OTHER_SURCHARGES = new <init>("OTHER_SURCHARGES", 5, 0x7f070855);
        NONMAC_SRCHRG = new <init>("NONMAC_SRCHRG", 6, 0x7f070850);
        RESI_SURCHARGE = new <init>("RESI_SURCHARGE", 7, 0x7f07086a);
        DEL_CONFIRMATION = new <init>("DEL_CONFIRMATION", 8, 0x7f07082f);
        SIG_CONFIRMATION = new <init>("SIG_CONFIRMATION", 9, 0x7f070875);
        $VALUES = (new .VALUES[] {
            EBAY_DIS, RETAIL_RATE, POSTAGE_COST, INSURANCE_COST, FUEL_SURCHARGE, OTHER_SURCHARGES, NONMAC_SRCHRG, RESI_SURCHARGE, DEL_CONFIRMATION, SIG_CONFIRMATION
        });
    }

    private Q(String s, int i, int j)
    {
        super(s, i);
        displayString = j;
    }
}
