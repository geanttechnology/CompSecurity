// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.mybby;


public final class AddressType extends Enum
{

    private static final AddressType $VALUES[];
    public static final AddressType rzEmail;
    public static final AddressType rzPhone;
    public static final AddressType rzPostal;
    public static final AddressType rzUnknown;

    private AddressType(String s, int i)
    {
        super(s, i);
    }

    public static AddressType valueOf(String s)
    {
        return (AddressType)Enum.valueOf(com/bestbuy/android/api/lib/models/mybby/AddressType, s);
    }

    public static AddressType[] values()
    {
        return (AddressType[])$VALUES.clone();
    }

    static 
    {
        rzUnknown = new AddressType("rzUnknown", 0);
        rzPostal = new AddressType("rzPostal", 1);
        rzEmail = new AddressType("rzEmail", 2);
        rzPhone = new AddressType("rzPhone", 3);
        $VALUES = (new AddressType[] {
            rzUnknown, rzPostal, rzEmail, rzPhone
        });
    }
}
