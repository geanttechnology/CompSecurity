// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.capi.lookup;


public final class LookupType extends Enum
{

    private static final LookupType $VALUES[];
    public static final LookupType CAPIOrderLookupBBY;
    public static final LookupType CAPIOrderLookupCustomer;

    private LookupType(String s, int i)
    {
        super(s, i);
    }

    public static LookupType valueOf(String s)
    {
        return (LookupType)Enum.valueOf(com/bestbuy/android/api/lib/models/capi/lookup/LookupType, s);
    }

    public static LookupType[] values()
    {
        return (LookupType[])$VALUES.clone();
    }

    static 
    {
        CAPIOrderLookupCustomer = new LookupType("CAPIOrderLookupCustomer", 0);
        CAPIOrderLookupBBY = new LookupType("CAPIOrderLookupBBY", 1);
        $VALUES = (new LookupType[] {
            CAPIOrderLookupCustomer, CAPIOrderLookupBBY
        });
    }
}
