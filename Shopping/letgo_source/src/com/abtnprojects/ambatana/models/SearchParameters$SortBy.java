// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models;


// Referenced classes of package com.abtnprojects.ambatana.models:
//            SearchParameters

public static final class  extends Enum
{

    private static final PUBLISH_DATE $VALUES[];
    public static final PUBLISH_DATE PRICE_ASC;
    public static final PUBLISH_DATE PRICE_DESC;
    public static final PUBLISH_DATE PROXIMITY;
    public static final PUBLISH_DATE PUBLISH_DATE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/abtnprojects/ambatana/models/SearchParameters$SortBy, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    public String getStringEnumForRequest()
    {
        switch (chMap.com.abtnprojects.ambatana.models.SearchParameters.SortBy[ordinal()])
        {
        default:
            return "recent";

        case 1: // '\001'
            return "distance";

        case 2: // '\002'
            return "price_desc";

        case 3: // '\003'
            return "price_asc";
        }
    }

    public int getStringResourceId()
    {
        switch (chMap.com.abtnprojects.ambatana.models.SearchParameters.SortBy[ordinal()])
        {
        default:
            return 0x7f090179;

        case 1: // '\001'
            return 0x7f09017a;

        case 2: // '\002'
            return 0x7f090178;

        case 3: // '\003'
            return 0x7f090177;
        }
    }

    static 
    {
        PROXIMITY = new <init>("PROXIMITY", 0);
        PRICE_DESC = new <init>("PRICE_DESC", 1);
        PRICE_ASC = new <init>("PRICE_ASC", 2);
        PUBLISH_DATE = new <init>("PUBLISH_DATE", 3);
        $VALUES = (new .VALUES[] {
            PROXIMITY, PRICE_DESC, PRICE_ASC, PUBLISH_DATE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
