// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.dcs;

import com.ebay.nautilus.domain.dcs.DcsPropLong;
import com.ebay.nautilus.domain.dcs.DcsState;

public final class DcsLong extends Enum
    implements DcsPropLong
{

    private static final DcsLong $VALUES[];
    public static final DcsLong GoogleNowCardAuthMaxRefreshFrequency;
    public static final DcsLong TrafficMonitorSendInterval;
    public static final DcsLong sellerPaymentReminderActivationTime;
    private final Object defaultValue;

    private DcsLong(String s, int i)
    {
        super(s, i);
        defaultValue = Long.valueOf(0L);
    }

    private DcsLong(String s, int i, long l)
    {
        super(s, i);
        defaultValue = Long.valueOf(l);
    }

    private DcsLong(String s, int i, String s1)
    {
        super(s, i);
        defaultValue = s1;
    }

    public static DcsLong valueOf(String s)
    {
        return (DcsLong)Enum.valueOf(com/ebay/mobile/dcs/DcsLong, s);
    }

    public static DcsLong[] values()
    {
        return (DcsLong[])$VALUES.clone();
    }

    public Object defaultValue(DcsState dcsstate)
    {
        return defaultValue;
    }

    public String key()
    {
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$mobile$dcs$DcsLong[];

            static 
            {
                $SwitchMap$com$ebay$mobile$dcs$DcsLong = new int[DcsLong.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsLong[DcsLong.TrafficMonitorSendInterval.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (_cls1..SwitchMap.com.ebay.mobile.dcs.DcsLong[ordinal()])
        {
        default:
            return name();

        case 1: // '\001'
            return "TrafficMonitor.sendInterval";
        }
    }

    static 
    {
        TrafficMonitorSendInterval = new DcsLong("TrafficMonitorSendInterval", 0, 300L);
        GoogleNowCardAuthMaxRefreshFrequency = new DcsLong("GoogleNowCardAuthMaxRefreshFrequency", 1, 0x5265c00L);
        sellerPaymentReminderActivationTime = new DcsLong("sellerPaymentReminderActivationTime", 2, 0xf731400L);
        $VALUES = (new DcsLong[] {
            TrafficMonitorSendInterval, GoogleNowCardAuthMaxRefreshFrequency, sellerPaymentReminderActivationTime
        });
    }
}
