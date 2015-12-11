// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.zeroes.intentservice.action;

import android.content.Intent;
import com.amazon.sdk.availability.Measurement;
import com.amazon.zeroes.intentservice.Metrics;
import com.amazon.zeroes.intentservice.ZeroesService;
import com.amazon.zeroes.intentservice.utils.ZeroesMeasurementUtils;

// Referenced classes of package com.amazon.zeroes.intentservice.action:
//            ZeroesAction

public class SubmitMetricAction
    implements ZeroesAction
{

    public static final String ACTION_REQUEST;
    private final Measurement measurement;

    public SubmitMetricAction(Intent intent)
    {
        measurement = ZeroesMeasurementUtils.fromIntent(intent);
    }

    public void act(ZeroesService zeroesservice)
    {
        Metrics.putMeasurement(measurement);
    }

    static 
    {
        ACTION_REQUEST = (new StringBuilder()).append(ZeroesService.BASE_PACKAGE_NAME).append(".SubmitMetric").toString();
    }
}
