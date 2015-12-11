// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;


// Referenced classes of package com.ebay.common.net.api.search:
//            SearchParameters

public static final class A extends Enum
{

    private static final CountOnly $VALUES[];
    public static final CountOnly CountOnly;
    public static final CountOnly Normal;

    public static A valueOf(String s)
    {
        return (A)Enum.valueOf(com/ebay/common/net/api/search/SearchParameters$QueryIntent, s);
    }

    public static A[] values()
    {
        return (A[])$VALUES.clone();
    }

    static 
    {
        Normal = new <init>("Normal", 0);
        CountOnly = new <init>("CountOnly", 1);
        $VALUES = (new .VALUES[] {
            Normal, CountOnly
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
