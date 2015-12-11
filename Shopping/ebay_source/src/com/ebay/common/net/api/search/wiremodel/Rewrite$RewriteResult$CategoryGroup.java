// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search.wiremodel;


// Referenced classes of package com.ebay.common.net.api.search.wiremodel:
//            Rewrite

public static final class  extends Enum
{

    private static final OTHER $VALUES[];
    public static final OTHER OTHER;
    public static final OTHER PRIMARY;
    public static final OTHER SECONDARY;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/common/net/api/search/wiremodel/Rewrite$RewriteResult$CategoryGroup, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PRIMARY = new <init>("PRIMARY", 0);
        SECONDARY = new <init>("SECONDARY", 1);
        OTHER = new <init>("OTHER", 2);
        $VALUES = (new .VALUES[] {
            PRIMARY, SECONDARY, OTHER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
