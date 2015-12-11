// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.zeroes.intentservice.command;

import android.text.TextUtils;
import com.amazon.mas.client.deviceservice.MasDsClient;
import com.amazon.mas.client.deviceservice.MasDsException;
import com.amazon.mas.client.http.WebResponse;
import com.amazon.zeroes.intentservice.Metrics;
import com.amazon.zeroes.intentservice.utils.ZeroesMeasurementUtils;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.zeroes.intentservice.command:
//            ZeroesCommand

public class MasDsCommand
    implements ZeroesCommand
{

    private final MasDsClient client;
    private final String operationName;
    private final JSONObject requestBody;

    public MasDsCommand(String s, JSONObject jsonobject, MasDsClient masdsclient)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new UnsupportedOperationException("operationName must not be empty");
        }
        if (masdsclient == null)
        {
            throw new NullPointerException("client must not be null");
        }
        operationName = s;
        requestBody = jsonobject;
        client = masdsclient;
        try
        {
            requestBody.put("retries", 0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Metrics.putMeasurement(ZeroesMeasurementUtils.fromThrowable(s));
        }
    }

    public WebResponse perform()
    {
        WebResponse webresponse;
        try
        {
            webresponse = client.invoke(operationName, requestBody);
        }
        catch (MasDsException masdsexception)
        {
            Metrics.putMeasurement(ZeroesMeasurementUtils.fromThrowable(masdsexception));
            return null;
        }
        return webresponse;
    }

    public volatile Object perform()
    {
        return perform();
    }
}
