// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.zeroes.intentservice.action;

import android.content.Intent;
import com.amazon.mas.client.deviceservice.MasDsClient;
import com.amazon.mas.client.http.WebResponse;
import com.amazon.zeroes.intentservice.Metrics;
import com.amazon.zeroes.intentservice.ZeroesPurchaseRequestDecorator;
import com.amazon.zeroes.intentservice.ZeroesService;
import com.amazon.zeroes.intentservice.command.MasDsCommand;
import com.amazon.zeroes.intentservice.command.ZeroesCommand;
import com.amazon.zeroes.intentservice.persistence.ZeroesCache;
import com.amazon.zeroes.intentservice.utils.ZeroesErrorUtils;
import com.amazon.zeroes.intentservice.utils.ZeroesIntentUtils;
import com.amazon.zeroes.intentservice.utils.ZeroesMeasurementUtils;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.zeroes.intentservice.action:
//            ZeroesAction

public class PurchaseBundleAction
    implements ZeroesAction
{

    public static final String ACTION_NAME = com/amazon/zeroes/intentservice/action/PurchaseBundleAction.getSimpleName();
    public static final String ACTION_REQUEST;
    public static final String ACTION_RESPONSE;
    public static final String EXTRA_BUNDLE_ASIN;
    public static final String EXTRA_BUNDLE_PRICE_AMOUNT;
    public static final String EXTRA_BUNDLE_PRICE_UNIT;
    private final ZeroesCache cache;
    private final ZeroesPurchaseRequestDecorator decorator;
    private final ZeroesCommand masDsCommand;
    private final Intent source;

    public PurchaseBundleAction(Intent intent, MasDsClient masdsclient, ZeroesCache zeroescache, ZeroesPurchaseRequestDecorator zeroespurchaserequestdecorator)
        throws JSONException
    {
        source = intent;
        cache = zeroescache;
        decorator = zeroespurchaserequestdecorator;
        masDsCommand = new MasDsCommand("purchaseItem", zeroespurchaserequestdecorator.decorateZeroesPurchaseRequest(getRequestFromIntent(intent)), masdsclient);
    }

    private static JSONObject getPriceFromIntent(Intent intent)
        throws JSONException
    {
        if (!intent.hasExtra(EXTRA_BUNDLE_PRICE_AMOUNT) || !intent.hasExtra(EXTRA_BUNDLE_PRICE_UNIT))
        {
            return null;
        } else
        {
            String s = intent.getStringExtra(EXTRA_BUNDLE_PRICE_AMOUNT);
            intent = intent.getStringExtra(EXTRA_BUNDLE_PRICE_UNIT);
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("amount", s);
            jsonobject.put("unit", intent);
            return jsonobject;
        }
    }

    private static JSONObject getRequestFromIntent(Intent intent)
        throws JSONException
    {
        String s = intent.getStringExtra(EXTRA_BUNDLE_ASIN);
        intent = getPriceFromIntent(intent);
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("asin", s);
        jsonobject.put("isZeroesBundlePurchase", true);
        jsonobject.put("currentPrice", intent);
        return jsonobject;
    }

    public void act(ZeroesService zeroesservice)
    {
        Object obj = (WebResponse)masDsCommand.perform();
        if (obj == null || !((WebResponse) (obj)).wasSuccessful())
        {
            zeroesservice.sendBroadcast(ZeroesIntentUtils.createFailureIntent(ACTION_RESPONSE, source, "generic_purchase_error"));
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
        String s;
        Object obj1;
        try
        {
            obj1 = new JSONObject(((WebResponse) (obj)).getEntityBody());
            s = ((JSONObject) (obj1)).getString("purchaseErrors");
            obj1 = ((JSONObject) (obj1)).optString("displayMessageKey");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            zeroesservice.sendBroadcast(ZeroesIntentUtils.createFailureIntent(ACTION_RESPONSE, source, "generic_purchase_error"));
            Metrics.putMeasurement(ZeroesMeasurementUtils.fromThrowable(((Throwable) (obj))));
            return;
        }
        if ("NoError".equals(s))
        {
            cache.invalidate("balance");
            zeroesservice.sendBroadcast(ZeroesIntentUtils.createSuccessIntent(ACTION_RESPONSE, source));
            return;
        } else
        {
            String s1 = ZeroesErrorUtils.getPurchaseErrorCode(((String) (obj1)));
            zeroesservice.sendBroadcast(ZeroesIntentUtils.createFailureIntent(ACTION_RESPONSE, source, s1));
            Metrics.putMeasurement(ZeroesMeasurementUtils.actionFailedMeasurement(ACTION_NAME, ((WebResponse) (obj))));
            return;
        }
    }

    static 
    {
        ACTION_REQUEST = (new StringBuilder()).append(ZeroesService.BASE_PACKAGE_NAME).append(".PurchaseBundle").toString();
        ACTION_RESPONSE = (new StringBuilder()).append(ZeroesService.BASE_PACKAGE_NAME).append(".PurchaseBundleResponse").toString();
        EXTRA_BUNDLE_ASIN = (new StringBuilder()).append(ZeroesService.BASE_PACKAGE_NAME).append(".bundleAsin").toString();
        EXTRA_BUNDLE_PRICE_AMOUNT = (new StringBuilder()).append(ZeroesService.BASE_PACKAGE_NAME).append(".bundlePriceAmount").toString();
        EXTRA_BUNDLE_PRICE_UNIT = (new StringBuilder()).append(ZeroesService.BASE_PACKAGE_NAME).append(".bundlePriceUnit").toString();
    }
}
