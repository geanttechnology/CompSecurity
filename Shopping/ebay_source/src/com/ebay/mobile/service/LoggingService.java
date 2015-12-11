// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.service;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.ebay.common.net.api.cal.LogMessage;
import com.ebay.common.net.api.cal.LogMessageData;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.shell.app.BaseIntentService;

public final class LoggingService extends BaseIntentService
{

    private static final String EXTRA_LOG_MESSAGE_DATA = "LogMessageData";
    private static final String EXTRA_SITE = "Site";
    private static final String TAG = com/ebay/mobile/service/LoggingService.getSimpleName();

    public LoggingService()
    {
        super(com/ebay/mobile/service/LoggingService.getSimpleName());
    }

    public static final void invoke(Context context, LogMessageData logmessagedata, EbaySite ebaysite)
    {
        Intent intent = new Intent(context, com/ebay/mobile/service/LoggingService);
        intent.putExtra("LogMessageData", logmessagedata.toQueryString());
        intent.putExtra("Site", ebaysite);
        context.startService(intent);
    }

    protected void onHandleIntent(Intent intent)
    {
        if (!NautilusKernel.isQaMode())
        {
            getApplicationContext();
            String s = intent.getStringExtra("LogMessageData");
            intent = (EbaySite)intent.getParcelableExtra("Site");
            try
            {
                LogMessage.execute(getEbayContext(), s, intent);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                Log.e(TAG, (new StringBuilder()).append("execute log message request failed, ").append(intent.getMessage()).toString(), intent);
            }
            return;
        } else
        {
            Log.d(TAG, "QA configuration enabled, discarded log message");
            return;
        }
    }

}
