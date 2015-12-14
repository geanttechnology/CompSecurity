// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.service;


// Referenced classes of package com.amazon.mixtape.service:
//            MetadataFetcher

private static final class sizeMetricName extends Enum
{

    private static final INCREMENTAL $VALUES[];
    public static final INCREMENTAL COLD_BOOT;
    public static final INCREMENTAL INCREMENTAL;
    public static final INCREMENTAL UPGRADE;
    final String sizeMetricName;
    final String timingMetricName;

    public static sizeMetricName getKindFromState(sizeMetricName sizemetricname)
    {
        if ("READY".equals(sizemetricname.entState))
        {
            if (sizemetricname.sUpgrade)
            {
                return UPGRADE;
            } else
            {
                return INCREMENTAL;
            }
        } else
        {
            return COLD_BOOT;
        }
    }

    public static COLD_BOOT valueOf(String s)
    {
        return (COLD_BOOT)Enum.valueOf(com/amazon/mixtape/service/MetadataFetcher$FetchKind, s);
    }

    public static COLD_BOOT[] values()
    {
        return (COLD_BOOT[])$VALUES.clone();
    }

    static 
    {
        COLD_BOOT = new <init>("COLD_BOOT", 0, "ColdBoot", "DBSizeColdBoot");
        UPGRADE = new <init>("UPGRADE", 1, "Upgrade", "DBSizeUpgrade");
        INCREMENTAL = new <init>("INCREMENTAL", 2, "Incremental", "DBSize");
        $VALUES = (new .VALUES[] {
            COLD_BOOT, UPGRADE, INCREMENTAL
        });
    }

    private (String s, int i, String s1, String s2)
    {
        super(s, i);
        timingMetricName = s1;
        sizeMetricName = s2;
    }
}
