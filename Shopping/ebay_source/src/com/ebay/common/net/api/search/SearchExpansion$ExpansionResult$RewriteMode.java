// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;


// Referenced classes of package com.ebay.common.net.api.search:
//            SearchExpansion

public static final class  extends Enum
{

    private static final AUTORUN $VALUES[];
    public static final AUTORUN AUTORUN;
    public static final AUTORUN RECOMMENDATION;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/common/net/api/search/SearchExpansion$ExpansionResult$RewriteMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        RECOMMENDATION = new <init>("RECOMMENDATION", 0);
        AUTORUN = new <init>("AUTORUN", 1);
        $VALUES = (new .VALUES[] {
            RECOMMENDATION, AUTORUN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
