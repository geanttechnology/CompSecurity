// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.provider;

import android.content.Context;
import android.hardware.Camera;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.groupon.component.creditcardscanner.CreditCardScanner;
import com.groupon.component.creditcardscanner.CreditCardScannerEmpty;
import com.groupon.component.creditcardscanner.JumioCreditCardScanner;
import com.groupon.models.country.Country;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.DeviceInfoUtil;
import roboguice.RoboGuice;

public class CreditCardScannerProvider
    implements Provider
{

    private AbTestService abTestService;
    private Context context;
    private CurrentCountryManager currentCountryManager;
    private DeviceInfoUtil deviceInfoUtil;

    public CreditCardScannerProvider()
    {
    }

    private boolean canCameraOpen()
    {
        try
        {
            Camera.open().release();
        }
        catch (Throwable throwable)
        {
            return false;
        }
        return true;
    }

    public CreditCardScanner get()
    {
        roboguice.inject.ContextScopedRoboInjector contextscopedroboinjector = RoboGuice.getInjector(context);
        abTestService = (AbTestService)contextscopedroboinjector.getInstance(com/groupon/service/core/AbTestService);
        boolean flag1 = abTestService.isVariantEnabled("cardScan1508", "cardIO");
        boolean flag2 = abTestService.isVariantEnabled("cardScan1508", "jumio");
        boolean flag;
        if (deviceInfoUtil.hasCameraFeature() && canCameraOpen() && !currentCountryManager.getCurrentCountry().isJapan())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if ((flag2 || flag1) && flag && !System.getProperty("os.arch").contains("64"))
        {
            return (CreditCardScanner)contextscopedroboinjector.getInstance(com/groupon/component/creditcardscanner/JumioCreditCardScanner);
        } else
        {
            return (CreditCardScanner)contextscopedroboinjector.getInstance(com/groupon/component/creditcardscanner/CreditCardScannerEmpty);
        }
    }

    public volatile Object get()
    {
        return get();
    }
}
