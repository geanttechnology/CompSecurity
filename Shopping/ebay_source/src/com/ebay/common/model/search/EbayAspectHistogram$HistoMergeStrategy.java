// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.search;


// Referenced classes of package com.ebay.common.model.search:
//            EbayAspectHistogram

public static final class I extends Enum
{

    private static final MERGE_SUPPRESS $VALUES[];
    public static final MERGE_SUPPRESS MERGE_ALL;
    public static final MERGE_SUPPRESS MERGE_SUPPRESS;
    public static final MERGE_SUPPRESS RETAIN;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/ebay/common/model/search/EbayAspectHistogram$HistoMergeStrategy, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        RETAIN = new <init>("RETAIN", 0);
        MERGE_ALL = new <init>("MERGE_ALL", 1);
        MERGE_SUPPRESS = new <init>("MERGE_SUPPRESS", 2);
        $VALUES = (new .VALUES[] {
            RETAIN, MERGE_ALL, MERGE_SUPPRESS
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
