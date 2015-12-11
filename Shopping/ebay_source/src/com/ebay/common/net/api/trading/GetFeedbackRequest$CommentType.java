// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;


// Referenced classes of package com.ebay.common.net.api.trading:
//            GetFeedbackRequest

public static final class name extends Enum
{

    private static final NEGATIVE $VALUES[];
    public static final NEGATIVE ALL;
    public static final NEGATIVE NEGATIVE;
    public static final NEGATIVE NEUTRAL;
    public static final NEGATIVE POSITIVE;
    protected String name;

    public static name valueOf(String s)
    {
        return (name)Enum.valueOf(com/ebay/common/net/api/trading/GetFeedbackRequest$CommentType, s);
    }

    public static name[] values()
    {
        return (name[])$VALUES.clone();
    }

    public String getName()
    {
        return name;
    }

    static 
    {
        ALL = new <init>("ALL", 0, "");
        POSITIVE = new <init>("POSITIVE", 1, "Positive");
        NEUTRAL = new <init>("NEUTRAL", 2, "Neutral");
        NEGATIVE = new <init>("NEGATIVE", 3, "Negative");
        $VALUES = (new .VALUES[] {
            ALL, POSITIVE, NEUTRAL, NEGATIVE
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        name = s1;
    }
}
