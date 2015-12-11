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

public class GetBalanceAction
    implements ZeroesAction, com.amazon.zeroes.intentservice.command.CachedCommand.Converter, com.amazon.zeroes.intentservice.command.RetryCommand.Validator, com.amazon.zeroes.intentservice.command.TranslateCommand.Translator
{

    public static final String ACTION_NAME = com/amazon/zeroes/intentservice/action/GetBalanceAction.getSimpleName();
    public static final String ACTION_REQUEST;
    public static final String ACTION_RESPONSE;
    private final ZeroesCommand command;
    private final Intent source;

    public GetBalanceAction(Intent intent, MasDsClient masdsclient, ZeroesCache zeroescache)
    {
        source = intent;
        command = new CachedCommand("balance", 0x1b7740L, zeroescache, new TranslateCommand(new RetryCommand(ZeroesIntentUtils.getRetryCount(intent), new MasDsCommand("getZeroesBalance", new JSONObject(), masdsclient), this), this), this);
        if (ZeroesIntentUtils.shouldInvalidateCache(source))
        {
            zeroescache.invalidate("balance");
        }
    }

    public void act(ZeroesService zeroesservice)
    {
        Long long1 = (Long)command.perform();
        if (long1 == null)
        {
            zeroesservice.sendBroadcast(ZeroesIntentUtils.createFailureIntent(ACTION_RESPONSE, source));
            Metrics.putMeasurement(ZeroesMeasurementUtils.actionFailedMeasurement(ACTION_NAME));
            return;
        } else
        {
            zeroesservice.sendBroadcast(ZeroesIntentUtils.createSuccessIntent(ACTION_RESPONSE, source, long1));
            return;
        }
    }

    public Long fromString(String s)
        throws com.amazon.zeroes.intentservice.command.CachedCommand.ConversionException
    {
        long l;
        try
        {
            l = Long.parseLong(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new com.amazon.zeroes.intentservice.command.CachedCommand.ConversionException();
        }
        return Long.valueOf(l);
    }

    public volatile Object fromString(String s)
        throws com.amazon.zeroes.intentservice.command.CachedCommand.ConversionException
    {
        return fromString(s);
    }

    public String toString(Long long1)
    {
        return Long.toString(long1.longValue());
    }

    public volatile String toString(Object obj)
    {
        return toString((Long)obj);
    }

    public Long translate(WebResponse webresponse)
    {
        if (!validate(webresponse))
        {
            Metrics.putMeasurement(ZeroesMeasurementUtils.actionFailedMeasurement(ACTION_NAME, webresponse));
            return null;
        }
        long l;
        try
        {
            l = (new JSONObject(webresponse.getEntityBody())).getLong("balance");
        }
        // Misplaced declaration of an exception variable
        catch (WebResponse webresponse)
        {
            Metrics.putMeasurement(ZeroesMeasurementUtils.fromThrowable(webresponse));
            return null;
        }
        return Long.valueOf(l);
    }

    public volatile Object translate(Object obj)
    {
        return translate((WebResponse)obj);
    }

    public boolean validate(WebResponse webresponse)
    {
        if (webresponse.wasSuccessful())
        {
            long l;
            try
            {
                l = (new JSONObject(webresponse.getEntityBody())).optLong("balance", 0x8000000000000000L);
            }
            // Misplaced declaration of an exception variable
            catch (WebResponse webresponse)
            {
                return false;
            }
            if (l != 0x8000000000000000L)
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
        ACTION_REQUEST = (new StringBuilder()).append(ZeroesService.BASE_PACKAGE_NAME).append(".GetBalance").toString();
        ACTION_RESPONSE = (new StringBuilder()).append(ZeroesService.BASE_PACKAGE_NAME).append(".GetBalanceResponse").toString();
    }
}
