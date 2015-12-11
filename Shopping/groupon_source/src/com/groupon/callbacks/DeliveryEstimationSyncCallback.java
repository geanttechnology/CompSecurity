// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.callbacks;

import android.content.Context;
import com.groupon.activity.IntentFactory;
import com.groupon.db.models.DeliveryEstimation;
import com.groupon.manager.DeliveryEstimationSyncManager;
import com.groupon.network.HttpResponseException;
import com.groupon.service.LoginService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.CountryUtil;
import com.groupon.util.LoaderCallbacksUtil;

public abstract class DeliveryEstimationSyncCallback
    implements commonlib.manager.SyncManager.SyncUiCallbacks
{

    private Context context;
    private CountryUtil countryUtil;
    private CurrentCountryManager currentCountryManager;
    protected IntentFactory intentFactory;
    protected LoginService loginService;
    private DeliveryEstimationSyncManager syncManager;

    public DeliveryEstimationSyncCallback(Context context1, DeliveryEstimationSyncManager deliveryestimationsyncmanager)
    {
        context = context1;
        syncManager = deliveryestimationsyncmanager;
    }

    protected abstract void addDeliveryEstimationWidget(DeliveryEstimation deliveryestimation);

    public void enableSyncProgressIndicator(boolean flag)
    {
    }

    public void handleSyncError(Runnable runnable, Exception exception)
    {
        if ((exception instanceof HttpResponseException) && ((HttpResponseException)exception).getStatusCode() == 401)
        {
            LoaderCallbacksUtil.handleSyncError(runnable, exception, context, loginService, countryUtil, currentCountryManager.getCurrentCountry(), syncManager, intentFactory, null);
        }
        addDeliveryEstimationWidget(null);
    }
}
