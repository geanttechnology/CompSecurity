// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models;


// Referenced classes of package com.abtnprojects.ambatana.models:
//            SearchParameters

public static final class  extends Enum
{

    private static final FAR $VALUES[];
    public static final int DEFAULT_FAR = 30000;
    public static final FAR FAR;
    public static final FAR MY_AREA;
    public static final FAR MY_CITY;
    public static final FAR NEARBY;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/abtnprojects/ambatana/models/SearchParameters$Distance, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    public int getQueryValue()
    {
        switch (Map.com.abtnprojects.ambatana.models.SearchParameters.Distance[ordinal()])
        {
        default:
            return 30000;

        case 1: // '\001'
            return 1;

        case 2: // '\002'
            return 5;

        case 3: // '\003'
            return 10;
        }
    }

    public int getStringResourceId()
    {
        switch (Map.com.abtnprojects.ambatana.models.SearchParameters.Distance[ordinal()])
        {
        default:
            return 0x7f09015f;

        case 1: // '\001'
            return 0x7f090168;

        case 2: // '\002'
            return 0x7f090162;

        case 3: // '\003'
            return 0x7f090165;
        }
    }

    static 
    {
        NEARBY = new <init>("NEARBY", 0);
        MY_AREA = new <init>("MY_AREA", 1);
        MY_CITY = new <init>("MY_CITY", 2);
        FAR = new <init>("FAR", 3);
        $VALUES = (new .VALUES[] {
            NEARBY, MY_AREA, MY_CITY, FAR
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
