// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;


// Referenced classes of package com.poshmark.data_model.models.inner_models:
//            Inventory

public static final class I extends Enum
{

    private static final NOT_FOR_SALE $VALUES[];
    public static final NOT_FOR_SALE AVAILABLE;
    public static final NOT_FOR_SALE NOT_FOR_SALE;
    public static final NOT_FOR_SALE RESERVED;
    public static final NOT_FOR_SALE SOLD;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/poshmark/data_model/models/inner_models/Inventory$ListingStatus, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        AVAILABLE = new <init>("AVAILABLE", 0);
        SOLD = new <init>("SOLD", 1);
        RESERVED = new <init>("RESERVED", 2);
        NOT_FOR_SALE = new <init>("NOT_FOR_SALE", 3);
        $VALUES = (new .VALUES[] {
            AVAILABLE, SOLD, RESERVED, NOT_FOR_SALE
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
