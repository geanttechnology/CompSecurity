// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.meta_data;


// Referenced classes of package com.poshmark.utils.meta_data:
//            AvailabilityMetaData

public static final class I extends Enum
{

    private static final SOLD $VALUES[];
    public static final SOLD ALL;
    public static final SOLD SOLD;
    public static final SOLD UNSOLD;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        ALL = new <init>("ALL", 0);
        UNSOLD = new <init>("UNSOLD", 1);
        SOLD = new <init>("SOLD", 2);
        $VALUES = (new .VALUES[] {
            ALL, UNSOLD, SOLD
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
