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
import com.amazon.zeroes.intentservice.persistence.ZeroesCache;
import com.amazon.zeroes.intentservice.utils.ZeroesIntentUtils;
import com.amazon.zeroes.intentservice.utils.ZeroesMeasurementUtils;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.zeroes.intentservice.action:
//            ZeroesAction

public class SetPreferencesAction
    implements ZeroesAction, com.amazon.zeroes.intentservice.command.RetryCommand.Validator
{

    public static final String ACTION_NAME = com/amazon/zeroes/intentservice/action/SetPreferencesAction.getSimpleName();
    public static final String ACTION_REQUEST;
    public static final String ACTION_RESPONSE;
    public static final String EXTRA_PREFERENCES;
    private final ZeroesCache cache;
    private final ZeroesCommand retryingMasDsCommand;
    private final Intent source;

    public SetPreferencesAction(Intent intent, MasDsClient masdsclient, ZeroesCache zeroescache)
        throws JSONException
    {
        source = intent;
        cache = zeroescache;
        masdsclient = new MasDsCommand("setZeroesPreferences", getRequestFromIntent(intent), masdsclient);
        retryingMasDsCommand = new RetryCommand(ZeroesIntentUtils.getRetryCount(intent), masdsclient, this);
    }

    private static JSONObject getRequestFromIntent(Intent intent)
        throws JSONException
    {
        intent = new JSONObject(intent.getStringExtra(EXTRA_PREFERENCES));
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("preferences", intent);
        return jsonobject;
    }

    public void act(ZeroesService zeroesservice)
    {
        WebResponse webresponse = (WebResponse)retryingMasDsCommand.perform();
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
            cache.invalidate("preferences");
            zeroesservice.sendBroadcast(ZeroesIntentUtils.createSuccessIntent(ACTION_RESPONSE, source));
            return;
        }
    }

    public boolean validate(WebResponse webresponse)
    {
        if (!webresponse.wasSuccessful())
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = (new JSONObject(webresponse.getEntityBody())).optBoolean("success");
        }
        // Misplaced declaration of an exception variable
        catch (WebResponse webresponse)
        {
            return false;
        }
        return flag;
    }

    public volatile boolean validate(Object obj)
    {
        return validate((WebResponse)obj);
    }

    static 
    {
        ACTION_REQUEST = (new StringBuilder()).append(ZeroesService.BASE_PACKAGE_NAME).append(".SetPreferences").toString();
        ACTION_RESPONSE = (new StringBuilder()).append(ZeroesService.BASE_PACKAGE_NAME).append(".SetPreferencesResponse").toString();
        EXTRA_PREFERENCES = (new StringBuilder()).append(ZeroesService.BASE_PACKAGE_NAME).append(".preferences").toString();
    }
}
