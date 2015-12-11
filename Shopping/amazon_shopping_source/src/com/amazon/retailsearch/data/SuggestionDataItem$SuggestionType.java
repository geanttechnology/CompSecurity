// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data;


// Referenced classes of package com.amazon.retailsearch.data:
//            SuggestionDataItem

public static final class  extends Enum
{

    private static final MERGED $VALUES[];
    public static final MERGED A9_SUGGESTION;
    public static final MERGED MERGED;
    public static final MERGED PAST_SEARCHES;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/retailsearch/data/SuggestionDataItem$SuggestionType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        A9_SUGGESTION = new <init>("A9_SUGGESTION", 0);
        PAST_SEARCHES = new <init>("PAST_SEARCHES", 1);
        MERGED = new <init>("MERGED", 2);
        $VALUES = (new .VALUES[] {
            A9_SUGGESTION, PAST_SEARCHES, MERGED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
