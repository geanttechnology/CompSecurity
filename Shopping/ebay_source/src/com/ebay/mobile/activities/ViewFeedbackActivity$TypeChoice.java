// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;


// Referenced classes of package com.ebay.mobile.activities:
//            ViewFeedbackActivity

public static final class value extends Enum
{

    private static final NEGATIVE $VALUES[];
    public static final NEGATIVE ALL;
    public static final NEGATIVE NEGATIVE;
    public static final NEGATIVE NEUTRAL;
    public static final NEGATIVE POSITIVE;
    public int value;

    public static value getByValue(int i)
    {
        value avalue[] = values();
        int k = avalue.length;
        for (int j = 0; j < k; j++)
        {
            value value1 = avalue[j];
            if (value1.value == i)
            {
                return value1;
            }
        }

        return ALL;
    }

    public static ALL valueOf(String s)
    {
        return (ALL)Enum.valueOf(com/ebay/mobile/activities/ViewFeedbackActivity$TypeChoice, s);
    }

    public static ALL[] values()
    {
        return (ALL[])$VALUES.clone();
    }

    static 
    {
        ALL = new <init>("ALL", 0, 0);
        POSITIVE = new <init>("POSITIVE", 1, 1);
        NEUTRAL = new <init>("NEUTRAL", 2, 2);
        NEGATIVE = new <init>("NEGATIVE", 3, 3);
        $VALUES = (new .VALUES[] {
            ALL, POSITIVE, NEUTRAL, NEGATIVE
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        value = j;
    }
}
