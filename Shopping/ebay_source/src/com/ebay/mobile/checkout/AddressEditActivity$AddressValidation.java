// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;


// Referenced classes of package com.ebay.mobile.checkout:
//            AddressEditActivity

public static final class  extends Enum
{

    private static final PHONE_NUMBER_REQUIRED $VALUES[];
    public static final PHONE_NUMBER_REQUIRED BAD_CITY;
    public static final PHONE_NUMBER_REQUIRED BAD_COUNTRY_CODE;
    public static final PHONE_NUMBER_REQUIRED BAD_NAME;
    public static final PHONE_NUMBER_REQUIRED BAD_PHONE;
    public static final PHONE_NUMBER_REQUIRED BAD_POSTAL_CODE;
    public static final PHONE_NUMBER_REQUIRED BAD_STATE_OR_PROVINCE;
    public static final PHONE_NUMBER_REQUIRED BAD_STREET1;
    public static final PHONE_NUMBER_REQUIRED PHONE_NUMBER_REQUIRED;
    public static final PHONE_NUMBER_REQUIRED VALID;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/checkout/AddressEditActivity$AddressValidation, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        VALID = new <init>("VALID", 0);
        BAD_NAME = new <init>("BAD_NAME", 1);
        BAD_STREET1 = new <init>("BAD_STREET1", 2);
        BAD_CITY = new <init>("BAD_CITY", 3);
        BAD_STATE_OR_PROVINCE = new <init>("BAD_STATE_OR_PROVINCE", 4);
        BAD_COUNTRY_CODE = new <init>("BAD_COUNTRY_CODE", 5);
        BAD_POSTAL_CODE = new <init>("BAD_POSTAL_CODE", 6);
        BAD_PHONE = new <init>("BAD_PHONE", 7);
        PHONE_NUMBER_REQUIRED = new <init>("PHONE_NUMBER_REQUIRED", 8);
        $VALUES = (new .VALUES[] {
            VALID, BAD_NAME, BAD_STREET1, BAD_CITY, BAD_STATE_OR_PROVINCE, BAD_COUNTRY_CODE, BAD_POSTAL_CODE, BAD_PHONE, PHONE_NUMBER_REQUIRED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
