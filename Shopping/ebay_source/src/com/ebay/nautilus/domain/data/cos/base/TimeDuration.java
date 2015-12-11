// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.cos.base;

import android.content.res.Resources;

// Referenced classes of package com.ebay.nautilus.domain.data.cos.base:
//            TimeDurationUnitEnum

public final class TimeDuration
{

    public TimeDurationUnitEnum unit;
    public long value;

    public TimeDuration(TimeDurationUnitEnum timedurationunitenum, long l)
    {
        value = l;
        unit = timedurationunitenum;
    }

    public String toIso8601()
    {
        String s;
        String s1;
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder();
        s1 = null;
        s = null;
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$nautilus$domain$data$cos$base$TimeDurationUnitEnum[];

            static 
            {
                $SwitchMap$com$ebay$nautilus$domain$data$cos$base$TimeDurationUnitEnum = new int[TimeDurationUnitEnum.values().length];
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$cos$base$TimeDurationUnitEnum[TimeDurationUnitEnum.YEAR.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$cos$base$TimeDurationUnitEnum[TimeDurationUnitEnum.MONTH.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$cos$base$TimeDurationUnitEnum[TimeDurationUnitEnum.DAY.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$cos$base$TimeDurationUnitEnum[TimeDurationUnitEnum.CALENDAR_DAY.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$cos$base$TimeDurationUnitEnum[TimeDurationUnitEnum.BUSINESS_DAY.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$cos$base$TimeDurationUnitEnum[TimeDurationUnitEnum.HOUR.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$cos$base$TimeDurationUnitEnum[TimeDurationUnitEnum.MINUTE.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$cos$base$TimeDurationUnitEnum[TimeDurationUnitEnum.SECOND.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$cos$base$TimeDurationUnitEnum[TimeDurationUnitEnum.MILLISECOND.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.ebay.nautilus.domain.data.cos.base.TimeDurationUnitEnum[unit.ordinal()];
        JVM INSTR tableswitch 1 9: default 72
    //                   1 113
    //                   2 119
    //                   3 125
    //                   4 125
    //                   5 125
    //                   6 131
    //                   7 140
    //                   8 149
    //                   9 158;
           goto _L1 _L2 _L3 _L4 _L4 _L4 _L5 _L6 _L7 _L8
_L1:
        stringbuilder.append('P');
        if (s1 != null)
        {
            stringbuilder.append(s1);
        }
        stringbuilder.append(value);
        if (s != null)
        {
            stringbuilder.append(s);
        }
        return stringbuilder.toString();
_L2:
        s = "Y";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "M";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "D";
        continue; /* Loop/switch isn't completed */
_L5:
        s1 = "T";
        s = "H";
        continue; /* Loop/switch isn't completed */
_L6:
        s1 = "T";
        s = "M";
        continue; /* Loop/switch isn't completed */
_L7:
        s1 = "T";
        s = "S";
        continue; /* Loop/switch isn't completed */
_L8:
        s1 = "T";
        s = "S";
        value = value / 1000L;
        if (true) goto _L1; else goto _L9
_L9:
    }

    public String toString(Resources resources)
    {
        Object obj;
        long l;
        l = value;
        obj = null;
        _cls1..SwitchMap.com.ebay.nautilus.domain.data.cos.base.TimeDurationUnitEnum[unit.ordinal()];
        JVM INSTR tableswitch 1 8: default 64
    //                   1 119
    //                   2 127
    //                   3 135
    //                   4 135
    //                   5 143
    //                   6 151
    //                   7 159
    //                   8 167;
           goto _L1 _L2 _L3 _L4 _L4 _L5 _L6 _L7 _L8
_L1:
        int i;
        i = com.ebay.nautilus.domain.R.plurals.time_duration_seconds;
        l /= 1000L;
_L10:
        String s = obj;
        if (resources != null)
        {
            s = obj;
            if (l <= 0x7fffffffL)
            {
                s = resources.getQuantityString(i, (int)l, new Object[] {
                    Integer.valueOf((int)l)
                });
            }
        }
        return s;
_L2:
        i = com.ebay.nautilus.domain.R.plurals.time_duration_years;
        continue; /* Loop/switch isn't completed */
_L3:
        i = com.ebay.nautilus.domain.R.plurals.time_duration_months;
        continue; /* Loop/switch isn't completed */
_L4:
        i = com.ebay.nautilus.domain.R.plurals.time_duration_calendar_days;
        continue; /* Loop/switch isn't completed */
_L5:
        i = com.ebay.nautilus.domain.R.plurals.time_duration_business_days;
        continue; /* Loop/switch isn't completed */
_L6:
        i = com.ebay.nautilus.domain.R.plurals.time_duration_hours;
        continue; /* Loop/switch isn't completed */
_L7:
        i = com.ebay.nautilus.domain.R.plurals.time_duration_minutes;
        continue; /* Loop/switch isn't completed */
_L8:
        i = com.ebay.nautilus.domain.R.plurals.time_duration_seconds;
        if (true) goto _L10; else goto _L9
_L9:
    }
}
