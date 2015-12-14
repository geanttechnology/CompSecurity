// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.sdk;


// Referenced classes of package com.inmobi.sdk:
//            InMobiSdk

public static final class a extends Enum
{

    private static final ABOVE_USD_150K $VALUES[];
    public static final ABOVE_USD_150K ABOVE_USD_150K;
    public static final ABOVE_USD_150K BELOW_USD_5K;
    public static final ABOVE_USD_150K BETWEEN_USD_100K_AND_150K;
    public static final ABOVE_USD_150K BETWEEN_USD_10K_AND_15K;
    public static final ABOVE_USD_150K BETWEEN_USD_15K_AND_20K;
    public static final ABOVE_USD_150K BETWEEN_USD_20K_AND_25K;
    public static final ABOVE_USD_150K BETWEEN_USD_25K_AND_50K;
    public static final ABOVE_USD_150K BETWEEN_USD_50K_AND_75K;
    public static final ABOVE_USD_150K BETWEEN_USD_5K_AND_10K;
    public static final ABOVE_USD_150K BETWEEN_USD_75K_AND_100K;
    private String a;

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/inmobi/sdk/InMobiSdk$HouseHoldIncome, s);
    }

    public static a[] values()
    {
        return (a[])$VALUES.clone();
    }

    public String toString()
    {
        return a;
    }

    static 
    {
        BELOW_USD_5K = new <init>("BELOW_USD_5K", 0, "belowusd5k");
        BETWEEN_USD_5K_AND_10K = new <init>("BETWEEN_USD_5K_AND_10K", 1, "betweenusd5kand10k");
        BETWEEN_USD_10K_AND_15K = new <init>("BETWEEN_USD_10K_AND_15K", 2, "betweenusd10kand15k");
        BETWEEN_USD_15K_AND_20K = new <init>("BETWEEN_USD_15K_AND_20K", 3, "betweenusd15kand20k");
        BETWEEN_USD_20K_AND_25K = new <init>("BETWEEN_USD_20K_AND_25K", 4, "betweenusd20kand25k");
        BETWEEN_USD_25K_AND_50K = new <init>("BETWEEN_USD_25K_AND_50K", 5, "betweenusd25kand50k");
        BETWEEN_USD_50K_AND_75K = new <init>("BETWEEN_USD_50K_AND_75K", 6, "betweenusd50kand75k");
        BETWEEN_USD_75K_AND_100K = new <init>("BETWEEN_USD_75K_AND_100K", 7, "betweenusd75kand100k");
        BETWEEN_USD_100K_AND_150K = new <init>("BETWEEN_USD_100K_AND_150K", 8, "betweenusd100kand150k");
        ABOVE_USD_150K = new <init>("ABOVE_USD_150K", 9, "aboveusd150k");
        $VALUES = (new .VALUES[] {
            BELOW_USD_5K, BETWEEN_USD_5K_AND_10K, BETWEEN_USD_10K_AND_15K, BETWEEN_USD_15K_AND_20K, BETWEEN_USD_20K_AND_25K, BETWEEN_USD_25K_AND_50K, BETWEEN_USD_50K_AND_75K, BETWEEN_USD_75K_AND_100K, BETWEEN_USD_100K_AND_150K, ABOVE_USD_150K
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        a = s1;
    }
}
