// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.zeroes.intentservice.utils;

import android.content.Intent;
import android.text.TextUtils;
import com.amazon.mas.client.http.WebResponse;
import com.amazon.sdk.availability.Measurement;
import com.amazon.zeroes.intentservice.ZeroesService;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONException;
import org.json.JSONObject;

public final class ZeroesMeasurementUtils
{

    public static final String EXTRA_MEASUREMENT;

    private ZeroesMeasurementUtils()
    {
    }

    public static Measurement actionFailedMeasurement(String s)
    {
        return (new Measurement()).setMeasurementName("actionFailed").setMeasurementTimestamp(System.currentTimeMillis()).setMeasurementValueNumber(Integer.valueOf(1)).setMetadata("action", s).setMetadata("reason", "unknown").setMetadata("protocolVersion", "2").setMetadata("source", "failure");
    }

    public static Measurement actionFailedMeasurement(String s, WebResponse webresponse)
    {
        StatusLine statusline = webresponse.getResponse().getStatusLine();
        Object obj = webresponse.getResponse().getFirstHeader("x-amzn-RequestId");
        if (obj == null)
        {
            obj = "";
        } else
        {
            obj = ((Header) (obj)).getValue();
        }
        return actionFailedMeasurement(s).setMetadata("reason", "invalidResponse").setMetadata("statusCode", Integer.toString(statusline.getStatusCode())).setMetadata("body", webresponse.getEntityBody()).setMetadata("requestId", ((String) (obj)));
    }

    public static Measurement fromIntent(Intent intent)
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject(intent.getStringExtra(EXTRA_MEASUREMENT));
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            throw new UnsupportedOperationException("The measurement isn't valid JSON");
        }
        intent = jsonobject.optString("name");
        if (TextUtils.isEmpty(intent))
        {
            throw new UnsupportedOperationException("measurementName can't be empty");
        }
        double d = jsonobject.optDouble("value", 0.0D);
        intent = (new Measurement()).setMeasurementName(intent).setMeasurementTimestamp(System.currentTimeMillis()).setMeasurementValueNumber(Double.valueOf(d)).setMetadata("protocolVersion", "2").setMetadata("source", "ui");
        jsonobject = jsonobject.optJSONObject("metadata");
        if (jsonobject != null)
        {
            String s;
            for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); intent.setMetadata(s, jsonobject.optString(s)))
            {
                s = (String)iterator.next();
            }

        }
        return intent;
    }

    public static Measurement fromThrowable(Throwable throwable)
    {
        StringWriter stringwriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringwriter));
        return (new Measurement()).setMeasurementName("exception").setMeasurementTimestamp(System.currentTimeMillis()).setMeasurementValueNumber(Integer.valueOf(1)).setMetadata("trace", stringwriter.toString()).setMetadata("protocolVersion", "2").setMetadata("source", "exception");
    }

    static 
    {
        EXTRA_MEASUREMENT = (new StringBuilder()).append(ZeroesService.BASE_PACKAGE_NAME).append(".measurement").toString();
    }
}
