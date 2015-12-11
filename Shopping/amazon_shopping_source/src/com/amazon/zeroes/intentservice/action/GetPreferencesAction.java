// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.zeroes.intentservice.action;

import android.content.Intent;
import com.amazon.mas.client.deviceservice.MasDsClient;
import com.amazon.mas.client.http.WebResponse;
import com.amazon.zeroes.intentservice.Metrics;
import com.amazon.zeroes.intentservice.ZeroesService;
import com.amazon.zeroes.intentservice.command.CachedCommand;
import com.amazon.zeroes.intentservice.command.MasDsCommand;
import com.amazon.zeroes.intentservice.command.RetryCommand;
import com.amazon.zeroes.intentservice.command.TranslateCommand;
import com.amazon.zeroes.intentservice.command.ZeroesCommand;
import com.amazon.zeroes.intentservice.persistence.ZeroesCache;
import com.amazon.zeroes.intentservice.utils.ZeroesIntentUtils;
import com.amazon.zeroes.intentservice.utils.ZeroesMeasurementUtils;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.zeroes.intentservice.action:
//            ZeroesAction

public class GetPreferencesAction
    implements ZeroesAction, com.amazon.zeroes.intentservice.command.CachedCommand.Converter, com.amazon.zeroes.intentservice.command.RetryCommand.Validator, com.amazon.zeroes.intentservice.command.TranslateCommand.Translator
{

    public static final String ACTION_NAME = com/amazon/zeroes/intentservice/action/GetPreferencesAction.getSimpleName();
    public static final String ACTION_REQUEST;
    public static final String ACTION_RESPONSE;
    private final ZeroesCommand command;
    private final Intent source;

    public GetPreferencesAction(Intent intent, MasDsClient masdsclient, ZeroesCache zeroescache)
    {
        source = intent;
        command = new CachedCommand("preferences", 0x5265c00L, zeroescache, new TranslateCommand(new RetryCommand(ZeroesIntentUtils.getRetryCount(intent), new MasDsCommand("getZeroesPreferences", new JSONObject(), masdsclient), this), this), this);
        if (ZeroesIntentUtils.shouldInvalidateCache(source))
        {
            zeroescache.invalidate("preferences");
        }
    }

    public void act(ZeroesService zeroesservice)
    {
        JSONObject jsonobject = (JSONObject)command.perform();
        if (jsonobject == null)
        {
            zeroesservice.sendBroadcast(ZeroesIntentUtils.createFailureIntent(ACTION_RESPONSE, source));
            Metrics.putMeasurement(ZeroesMeasurementUtils.actionFailedMeasurement(ACTION_NAME));
            return;
        } else
        {
            zeroesservice.sendBroadcast(ZeroesIntentUtils.createSuccessIntent(ACTION_RESPONSE, source, jsonobject));
            return;
        }
    }

    public volatile Object fromString(String s)
        throws com.amazon.zeroes.intentservice.command.CachedCommand.ConversionException
    {
        return fromString(s);
    }

    public JSONObject fromString(String s)
        throws com.amazon.zeroes.intentservice.command.CachedCommand.ConversionException
    {
        try
        {
            s = new JSONObject(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new com.amazon.zeroes.intentservice.command.CachedCommand.ConversionException();
        }
        return s;
    }

    public volatile String toString(Object obj)
    {
        return toString((JSONObject)obj);
    }

    public String toString(JSONObject jsonobject)
    {
        return jsonobject.toString();
    }

    public volatile Object translate(Object obj)
    {
        return translate((WebResponse)obj);
    }

    public JSONObject translate(WebResponse webresponse)
    {
        if (!validate(webresponse))
        {
            Metrics.putMeasurement(ZeroesMeasurementUtils.actionFailedMeasurement(ACTION_NAME, webresponse));
            return null;
        }
        try
        {
            webresponse = (new JSONObject(webresponse.getEntityBody())).getJSONObject("preferences");
        }
        // Misplaced declaration of an exception variable
        catch (WebResponse webresponse)
        {
            Metrics.putMeasurement(ZeroesMeasurementUtils.fromThrowable(webresponse));
            return null;
        }
        return webresponse;
    }

    public boolean validate(WebResponse webresponse)
    {
        if (webresponse.wasSuccessful())
        {
            try
            {
                webresponse = (new JSONObject(webresponse.getEntityBody())).optJSONObject("preferences");
            }
            // Misplaced declaration of an exception variable
            catch (WebResponse webresponse)
            {
                return false;
            }
            if (webresponse != null)
            {
                return true;
            }
        }
        return false;
    }

    public volatile boolean validate(Object obj)
    {
        return validate((WebResponse)obj);
    }

    static 
    {
        ACTION_REQUEST = (new StringBuilder()).append(ZeroesService.BASE_PACKAGE_NAME).append(".GetPreferences").toString();
        ACTION_RESPONSE = (new StringBuilder()).append(ZeroesService.BASE_PACKAGE_NAME).append(".GetPreferencesResponse").toString();
    }
}
