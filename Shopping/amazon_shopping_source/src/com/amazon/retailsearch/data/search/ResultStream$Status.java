// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data.search;


// Referenced classes of package com.amazon.retailsearch.data.search:
//            ResultStream

public static final class  extends Enum
{

    private static final Error $VALUES[];
    public static final Error Done;
    public static final Error Error;
    public static final Error None;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/retailsearch/data/search/ResultStream$Status, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        None = new <init>("None", 0);
        Done = new <init>("Done", 1);
        Error = new <init>("Error", 2);
        $VALUES = (new .VALUES[] {
            None, Done, Error
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
