// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.cos.base;


public final class AddressTypeEnum extends Enum
{

    private static final AddressTypeEnum $VALUES[];
    public static final AddressTypeEnum BUSINESS;
    public static final AddressTypeEnum PO_BOX;
    public static final AddressTypeEnum RESIDENCE;
    public static final AddressTypeEnum UNKNOWN;

    private AddressTypeEnum(String s, int i)
    {
        super(s, i);
    }

    public static AddressTypeEnum valueOf(String s)
    {
        return (AddressTypeEnum)Enum.valueOf(com/ebay/nautilus/domain/data/cos/base/AddressTypeEnum, s);
    }

    public static AddressTypeEnum[] values()
    {
        return (AddressTypeEnum[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new AddressTypeEnum("UNKNOWN", 0);
        PO_BOX = new AddressTypeEnum("PO_BOX", 1);
        RESIDENCE = new AddressTypeEnum("RESIDENCE", 2);
        BUSINESS = new AddressTypeEnum("BUSINESS", 3);
        $VALUES = (new AddressTypeEnum[] {
            UNKNOWN, PO_BOX, RESIDENCE, BUSINESS
        });
    }
}
