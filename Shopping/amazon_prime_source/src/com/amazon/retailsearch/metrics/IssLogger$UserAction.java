// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics;


// Referenced classes of package com.amazon.retailsearch.metrics:
//            IssLogger

public static final class  extends Enum
{

    private static final zero_impression $VALUES[];
    public static final zero_impression explicit_acceptance;
    public static final zero_impression implicit_acceptance;
    public static final zero_impression mismatch;
    public static final zero_impression rejection;
    public static final zero_impression zero_impression;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/retailsearch/metrics/IssLogger$UserAction, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        explicit_acceptance = new <init>("explicit_acceptance", 0);
        implicit_acceptance = new <init>("implicit_acceptance", 1);
        rejection = new <init>("rejection", 2);
        mismatch = new <init>("mismatch", 3);
        zero_impression = new <init>("zero_impression", 4);
        $VALUES = (new .VALUES[] {
            explicit_acceptance, implicit_acceptance, rejection, mismatch, zero_impression
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
