// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search.idealmodel;


// Referenced classes of package com.ebay.common.net.api.search.idealmodel:
//            SrpListItem

public static final class  extends Enum
{

    private static final ADS $VALUES[];
    public static final ADS ADS;
    public static final ADS LABELED_ANSWER;
    public static final ADS REGULAR;
    public static final ADS REWRITE_END;
    public static final ADS REWRITE_START;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/common/net/api/search/idealmodel/SrpListItem$SrpListItemType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        REGULAR = new <init>("REGULAR", 0);
        LABELED_ANSWER = new <init>("LABELED_ANSWER", 1);
        REWRITE_START = new <init>("REWRITE_START", 2);
        REWRITE_END = new <init>("REWRITE_END", 3);
        ADS = new <init>("ADS", 4);
        $VALUES = (new .VALUES[] {
            REGULAR, LABELED_ANSWER, REWRITE_START, REWRITE_END, ADS
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
