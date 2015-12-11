// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.zeroes.intentservice.action;

import android.content.Intent;
import com.amazon.mas.client.deviceservice.MasDsClient;
import com.amazon.mas.client.http.WebResponse;
import com.amazon.zeroes.intentservice.Metrics;
import com.amazon.zeroes.intentservice.ZeroesService;
import com.amazon.zeroes.intentservice.command.MasDsCommand;
import com.amazon.zeroes.intentservice.command.RetryCommand;
import com.amazon.zeroes.intentservice.command.ZeroesCommand;
import com.amazon.zeroes.intentservice.utils.ZeroesIntentUtils;
import com.amazon.zeroes.intentservice.utils.ZeroesMeasurementUtils;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.zeroes.intentservice.action:
//            ZeroesAction

public class GetTaxPreviewAction
    implements ZeroesAction, com.amazon.zeroes.intentservice.command.RetryCommand.Validator
{

    public static final String ACTION_NAME = com/amazon/zeroes/intentservice/action/GetTaxPreviewAction.getSimpleName();
    public static final String ACTION_REQUEST;
    public static final String ACTION_RESPONSE;
    public static final String EXTRA_ASIN;
    public static final String EXTRA_CURRENCY_CODE;
    public static final String EXTRA_PRICE;
    private final ZeroesCommand retryingMasDsCommand;
    private final Intent source;

    public GetTaxPreviewAction(Intent intent, MasDsClient masdsclient)
        throws JSONException
    {
        source = intent;
        masdsclient = new MasDsCommand("getZeroesPreviewTax", getRequestFromIntent(intent), masdsclient);
        retryingMasDsCommand = new RetryCommand(ZeroesIntentUtils.getRetryCount(intent), masdsclient, this);
    }

    private static JSONObject getRequestFromIntent(Intent intent)
        throws JSONException
    {
        String s = intent.getStringExtra(EXTRA_ASIN);
        double d = intent.getDoubleExtra(EXTRA_PRICE, 0.0D);
        Object obj = intent.getStringExtra(EXTRA_CURRENCY_CODE);
        intent = new JSONObject();
        intent.put("amount", Double.toString(d));
        intent.put("unit", obj);
        obj = new JSONObject();
        ((JSONObject) (obj)).put("asin", s);
        ((JSONObject) (obj)).put("price", intent);
        return ((JSONObject) (obj));
    }

    public void act(ZeroesService zeroesservice)
    {
        Object obj = (WebResponse)retryingMasDsCommand.perform();
        if (obj == null || !validate(((WebResponse) (obj))))
        {
            zeroesservice.sendBroadcast(ZeroesIntentUtils.createFailureIntent(ACTION_RESPONSE, source));
            if (obj == null)
            {
                Metrics.putMeasurement(ZeroesMeasurementUtils.actionFailedMeasurement(ACTION_NAME));
                return;
            } else
            {
                Metrics.putMeasurement(ZeroesMeasurementUtils.actionFailedMeasurement(ACTION_NAME, ((WebResponse) (obj))));
                return;
            }
        }
        try
        {
            obj = new JSONObject(((WebResponse) (obj)).getEntityBody());
            zeroesservice.sendBroadcast(ZeroesIntentUtils.createSuccessIntent(ACTION_RESPONSE, source, obj));
            return;
        }
        catch (JSONException jsonexception)
        {
            zeroesservice.sendBroadcast(ZeroesIntentUtils.createFailureIntent(ACTION_RESPONSE, source));
            Metrics.putMeasurement(ZeroesMeasurementUtils.fromThrowable(jsonexception));
            return;
        }
    }

    public boolean validate(WebResponse webresponse)
    {
        if (webresponse.wasSuccessful()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        boolean flag;
        if (!(webresponse = new JSONObject(webresponse.getEntityBody())).optBoolean("success") || !webresponse.has("zeroesTotalPrice") || !(flag = webresponse.has("zeroesTaxAmount"))) goto _L1; else goto _L3
_L3:
        return true;
        webresponse;
        return false;
    }

    public volatile boolean validate(Object obj)
    {
        return validate((WebResponse)obj);
    }

    static 
    {
        ACTION_REQUEST = (new StringBuilder()).append(ZeroesService.BASE_PACKAGE_NAME).append(".GetTaxPreview").toString();
        ACTION_RESPONSE = (new StringBuilder()).append(ZeroesService.BASE_PACKAGE_NAME).append(".GetTaxPreviewResponse").toString();
        EXTRA_ASIN = (new StringBuilder()).append(ZeroesService.BASE_PACKAGE_NAME).append(".asin").toString();
        EXTRA_PRICE = (new StringBuilder()).append(ZeroesService.BASE_PACKAGE_NAME).append(".price").toString();
        EXTRA_CURRENCY_CODE = (new StringBuilder()).append(ZeroesService.BASE_PACKAGE_NAME).append(".currencyCode").toString();
    }
}
