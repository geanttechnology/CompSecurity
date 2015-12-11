// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.Application;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.iovation.mobile.android.DevicePrint;
import java.util.Arrays;
import java.util.List;

public class IovationBlackboxUtil
{

    private Application appContext;
    private CurrentCountryManager currentCountryManager;

    public IovationBlackboxUtil()
    {
    }

    public void addIovationParameterIfNeeded(List list)
    {
        if (currentCountryManager.getCurrentCountry().isUSACompatible() || currentCountryManager.getCurrentCountry().isEuCompatible())
        {
            list.addAll(Arrays.asList(new String[] {
                "iovation_blackbox", DevicePrint.ioBegin(appContext)
            }));
        }
    }
}
