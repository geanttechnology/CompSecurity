// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.search;


// Referenced classes of package com.groupon.getaways.search:
//            GetawaysSearchViewPresenter

private static final class  extends Enum
{

    private static final BY_CURRENT_LOCATION $VALUES[];
    public static final BY_CURRENT_LOCATION BY_CURRENT_LOCATION;
    public static final BY_CURRENT_LOCATION BY_DESTINATION;
    public static final BY_CURRENT_LOCATION BY_QUERY;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/groupon/getaways/search/GetawaysSearchViewPresenter$SearchType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        BY_DESTINATION = new <init>("BY_DESTINATION", 0);
        BY_QUERY = new <init>("BY_QUERY", 1);
        BY_CURRENT_LOCATION = new <init>("BY_CURRENT_LOCATION", 2);
        $VALUES = (new .VALUES[] {
            BY_DESTINATION, BY_QUERY, BY_CURRENT_LOCATION
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
