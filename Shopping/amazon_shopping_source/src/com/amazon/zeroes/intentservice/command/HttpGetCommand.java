// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.zeroes.intentservice.command;

import android.text.TextUtils;
import com.amazon.mas.client.http.AbstractWebRequest;
import com.amazon.mas.client.http.DefaultWebRequestFactory;
import com.amazon.mas.client.http.WebHttpClient;
import com.amazon.mas.client.http.WebHttpException;
import com.amazon.mas.client.http.WebResponse;
import com.amazon.zeroes.intentservice.Metrics;
import com.amazon.zeroes.intentservice.utils.ZeroesMeasurementUtils;

// Referenced classes of package com.amazon.zeroes.intentservice.command:
//            ZeroesCommand

public class HttpGetCommand
    implements ZeroesCommand
{

    private final WebHttpClient client;
    private final AbstractWebRequest request;

    public HttpGetCommand(String s, WebHttpClient webhttpclient)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new UnsupportedOperationException("url must not be empty");
        }
        if (webhttpclient == null)
        {
            throw new NullPointerException("client must not be null");
        } else
        {
            client = webhttpclient;
            request = (new DefaultWebRequestFactory()).fromMethodUrlRetries("GET", s, 0);
            return;
        }
    }

    public WebResponse perform()
    {
        WebResponse webresponse;
        try
        {
            webresponse = client.invoke(request);
        }
        catch (WebHttpException webhttpexception)
        {
            Metrics.putMeasurement(ZeroesMeasurementUtils.fromThrowable(webhttpexception));
            return null;
        }
        return webresponse;
    }

    public volatile Object perform()
    {
        return perform();
    }
}
