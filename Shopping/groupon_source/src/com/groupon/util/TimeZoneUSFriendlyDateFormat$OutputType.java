// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;


// Referenced classes of package com.groupon.util:
//            TimeZoneUSFriendlyDateFormat

public static final class  extends Enum
{

    private static final shortDate $VALUES[];
    public static final shortDate longDate;
    public static final shortDate shortDate;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/groupon/util/TimeZoneUSFriendlyDateFormat$OutputType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        longDate = new <init>("longDate", 0);
        shortDate = new <init>("shortDate", 1);
        $VALUES = (new .VALUES[] {
            longDate, shortDate
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
