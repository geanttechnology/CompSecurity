// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.zeroes.intentservice.action;

import android.content.Intent;
import com.amazon.mas.client.http.WebHttpClient;
import com.amazon.mas.client.http.WebResponse;
import com.amazon.zeroes.intentservice.Metrics;
import com.amazon.zeroes.intentservice.ZeroesService;
import com.amazon.zeroes.intentservice.command.HttpGetCommand;
import com.amazon.zeroes.intentservice.command.RetryCommand;
import com.amazon.zeroes.intentservice.command.ZeroesCommand;
import com.amazon.zeroes.intentservice.utils.ZeroesIntentUtils;
import com.amazon.zeroes.intentservice.utils.ZeroesMeasurementUtils;

// Referenced classes of package com.amazon.zeroes.intentservice.action:
//            ZeroesAction

public class HttpGetAction
    implements ZeroesAction, com.amazon.zeroes.intentservice.command.RetryCommand.Validator
{

    public static final String ACTION_NAME = com/amazon/zeroes/intentservice/action/HttpGetAction.getSimpleName();
    public static final String ACTION_REQUEST;
    public static final String ACTION_RESPONSE;
    public static final String EXTRA_URL;
    private final ZeroesCommand retryingHttpGetCommand;
    private final Intent source;

    public HttpGetAction(Intent intent, WebHttpClient webhttpclient)
    {
        source = intent;
        webhttpclient = new HttpGetCommand(intent.getStringExtra(EXTRA_URL), webhttpclient);
        retryingHttpGetCommand = new RetryCommand(ZeroesIntentUtils.getRetryCount(intent), webhttpclient, this);
    }

    public void act(ZeroesService zeroesservice)
    {
        WebResponse webresponse = (WebResponse)retryingHttpGetCommand.perform();
        if (webresponse == null || !validate(webresponse))
        {
            zeroesservice.sendBroadcast(ZeroesIntentUtils.createFailureIntent(ACTION_RESPONSE, source));
            if (webresponse == null)
            {
                Metrics.putMeasurement(ZeroesMeasurementUtils.actionFailedMeasurement(ACTION_NAME));
                return;
            } else
            {
                Metrics.putMeasurement(ZeroesMeasurementUtils.actionFailedMeasurement(ACTION_NAME, webresponse));
                return;
            }
        } else
        {
            zeroesservice.sendBroadcast(ZeroesIntentUtils.createSuccessIntent(ACTION_RESPONSE, source, webresponse.getEntityBody()));
            return;
        }
    }

    public boolean validate(WebResponse webresponse)
    {
        return webresponse.wasSuccessful();
    }

    public volatile boolean validate(Object obj)
    {
        return validate((WebResponse)obj);
    }

    static 
    {
        ACTION_REQUEST = (new StringBuilder()).append(ZeroesService.BASE_PACKAGE_NAME).append(".HttpGet").toString();
        ACTION_RESPONSE = (new StringBuilder()).append(ZeroesService.BASE_PACKAGE_NAME).append(".HttpGetResponse").toString();
        EXTRA_URL = (new StringBuilder()).append(ZeroesService.BASE_PACKAGE_NAME).append(".url").toString();
    }
}
