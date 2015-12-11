// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.cos.base;


// Referenced classes of package com.ebay.nautilus.domain.data.cos.base:
//            TimeDuration, TimeDurationUnitEnum

static class tEnum
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
