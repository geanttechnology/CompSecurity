// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.search;


// Referenced classes of package com.target.ui.model.search:
//            c

public static final class  extends Enum
{

    private static final UNKNOWN $VALUES[];
    public static final UNKNOWN ENTERPRISE_SEARCH_SUGGESTION;
    public static final UNKNOWN PI_SEARCH_SUGGESTION;
    public static final UNKNOWN UNKNOWN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/model/search/c$a, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PI_SEARCH_SUGGESTION = new <init>("PI_SEARCH_SUGGESTION", 0);
        ENTERPRISE_SEARCH_SUGGESTION = new <init>("ENTERPRISE_SEARCH_SUGGESTION", 1);
        UNKNOWN = new <init>("UNKNOWN", 2);
        $VALUES = (new .VALUES[] {
            PI_SEARCH_SUGGESTION, ENTERPRISE_SEARCH_SUGGESTION, UNKNOWN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
