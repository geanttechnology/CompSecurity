// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.zeroes.intentservice;

import android.app.IntentService;
import android.content.Intent;
import com.amazon.android.dagger.DaggerAndroid;
import com.amazon.logging.Logger;
import com.amazon.mas.client.account.summary.AccountSummaryProvider;
import com.amazon.mas.client.device.DeviceInspector;
import com.amazon.profiling.Profiler;
import com.amazon.sdk.availability.MeasurementManagerFactory;
import com.amazon.zeroes.intentservice.action.ActionFactory;
import com.amazon.zeroes.intentservice.action.ZeroesAction;
import com.amazon.zeroes.intentservice.utils.ZeroesMeasurementUtils;

// Referenced classes of package com.amazon.zeroes.intentservice:
//            Metrics

public class ZeroesService extends IntentService
{

    public static final String BASE_PACKAGE_NAME = com/amazon/zeroes/intentservice/ZeroesService.getPackage().getName();
    public static final String EXTRA_OUTPUT_RESULT = (new StringBuilder()).append(BASE_PACKAGE_NAME).append(".result").toString();
    private static final Logger LOG = Logger.getLogger(com/amazon/zeroes/intentservice/ZeroesService);
    AccountSummaryProvider accountSummaryProvider;
    ActionFactory actionFactory;
    DeviceInspector deviceInspector;

    public ZeroesService()
    {
        super(com/amazon/zeroes/intentservice/ZeroesService.getSimpleName());
        DaggerAndroid.inject(this);
        Metrics.setContext(this);
        Metrics.setMeasurementManager(MeasurementManagerFactory.getMeasurementManager());
        Metrics.setMeasurementDefaults(deviceInspector, accountSummaryProvider);
    }

    private ZeroesAction getActionFromIntent(Intent intent)
    {
        try
        {
            intent = actionFactory.getActionFromIntent(intent);
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            LOG.e("Failed to perform the action due to a malformed request");
            Metrics.putMeasurement(ZeroesMeasurementUtils.fromThrowable(intent));
            return null;
        }
        return intent;
    }

    protected void onHandleIntent(Intent intent)
    {
        com.amazon.profiling.ProfilerScope profilerscope = Profiler.methodScopeStart(com/amazon/zeroes/intentservice/ZeroesService, "onHandleIntent");
        LOG.i((new StringBuilder()).append("Received a request (").append(intent.getAction()).append(")").toString());
        intent = getActionFromIntent(intent);
        if (intent != null)
        {
            intent.act(this);
        }
        Profiler.scopeEnd(profilerscope);
    }

}
