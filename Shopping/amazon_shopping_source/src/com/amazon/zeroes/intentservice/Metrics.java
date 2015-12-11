// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.zeroes.intentservice;

import android.content.Context;
import com.amazon.mas.client.account.summary.AccountSummary;
import com.amazon.mas.client.account.summary.AccountSummaryProvider;
import com.amazon.mas.client.device.DeviceInspector;
import com.amazon.sdk.availability.Measurement;
import com.amazon.sdk.availability.MeasurementManager;
import java.util.Map;

public final class Metrics
{

    private static Context context;
    private static MeasurementManager measurementManager;

    private Metrics()
    {
    }

    public static void putMeasurement(Measurement measurement)
    {
        measurement.setClientId("zeroes");
        measurementManager.putMeasurement(context, measurement);
    }

    public static void setContext(Context context1)
    {
        context = context1;
    }

    public static void setMeasurementDefaults(DeviceInspector deviceinspector, AccountSummaryProvider accountsummaryprovider)
    {
        deviceinspector = deviceinspector.getDeviceInfo();
        if (accountsummaryprovider.isAccountPrepared(null))
        {
            Measurement.setGlobalMetadata("ecid", accountsummaryprovider.getAccountSummary().getAmznCustomerId());
        }
        Measurement.setGlobalMetadata("deviceModel", (String)deviceinspector.get("model"));
        Measurement.setGlobalMetadata("deviceType", (String)deviceinspector.get("deviceType"));
    }

    public static void setMeasurementManager(MeasurementManager measurementmanager)
    {
        measurementManager = measurementmanager;
    }
}
