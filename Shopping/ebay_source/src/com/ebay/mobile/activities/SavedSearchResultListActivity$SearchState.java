// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;


// Referenced classes of package com.ebay.mobile.activities:
//            SavedSearchResultListActivity

private static final class  extends Enum
{

    private static final PRIMARY_SEARCH $VALUES[];
    public static final PRIMARY_SEARCH PRIMARY_SEARCH;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/activities/SavedSearchResultListActivity$SearchState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PRIMARY_SEARCH = new <init>("PRIMARY_SEARCH", 0);
        $VALUES = (new .VALUES[] {
            PRIMARY_SEARCH
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
