// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.delivery;

import com.amazon.insights.InsightsCredentials;
import com.amazon.insights.core.InsightsContext;
import com.amazon.insights.core.configuration.Configuration;
import com.amazon.insights.core.http.HttpClient;
import com.amazon.insights.core.idresolver.Id;
import com.amazon.insights.core.log.Logger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;

public class ERSRequestBuilder
{

    private static final Logger logger = Logger.getLogger(com/amazon/insights/delivery/ERSRequestBuilder);
    private final String applicationKey;
    private final Configuration configuration;
    private final HttpClient httpClient;
    private final String uniqueId;

    public ERSRequestBuilder(HttpClient httpclient, String s, String s1, Configuration configuration1)
    {
        httpClient = httpclient;
        uniqueId = s;
        applicationKey = s1;
        configuration = configuration1;
    }

    private String getEndpointUrl()
    {
        return configuration.optString("eventRecorderEndpoint", "https://applab-sdk.amazon.com/1.0");
    }

    public static ERSRequestBuilder newBuilder(InsightsContext insightscontext)
    {
        return new ERSRequestBuilder(insightscontext.getHttpClient(), insightscontext.getUniqueId().getValue(), insightscontext.getCredentials().getApplicationKey(), insightscontext.getConfiguration());
    }

    public com.amazon.insights.core.http.HttpClient.Request createHttpRequest(JSONArray jsonarray)
    {
        Object obj2;
        com.amazon.insights.core.http.HttpClient.Request request = httpClient.newRequest().setUrl(String.format("%s/applications/%s/events", new Object[] {
            getEndpointUrl(), applicationKey
        })).addHeader("x-amzn-UniqueId", uniqueId).setMethod(com.amazon.insights.core.http.HttpClient.HttpMethod.POST);
        String s = jsonarray.toString();
        if (s == null)
        {
            return null;
        }
        Object obj4 = null;
        Object obj5 = null;
        Object obj = null;
        Object obj6 = null;
        Object obj1 = null;
        obj2 = null;
        Object obj3 = null;
        Exception exception;
        try
        {
            jsonarray = new ByteArrayOutputStream();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2)
        {
            jsonarray = obj6;
            continue; /* Loop/switch isn't completed */
        }
        finally { }
_L3:
        obj1 = new GZIPOutputStream(jsonarray);
        ((GZIPOutputStream) (obj1)).write(s.getBytes("UTF-8"));
        ((GZIPOutputStream) (obj1)).close();
        obj = jsonarray.toByteArray();
_L2:
        if (jsonarray == null)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        jsonarray.close();
        if (obj1 != null)
        {
            try
            {
                ((GZIPOutputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (JSONArray jsonarray)
            {
                logger.e("Errror closing compression streams", jsonarray);
            }
        }
        if (obj == null)
        {
            return null;
        } else
        {
            request.setPostBody(((byte []) (obj)));
            request.addHeader("Content-Encoding", "gzip");
            return request;
        }
        obj;
        logger.e("Error creating compressed String for ERS Request", ((Throwable) (obj)));
        obj = obj5;
        if (true) goto _L2; else goto _L1
_L1:
        obj2;
        obj3 = obj1;
_L6:
        obj = jsonarray;
        obj1 = obj3;
        logger.e("Error attempting to compress request contents", ((Throwable) (obj2)));
        if (jsonarray == null)
        {
            break MISSING_BLOCK_LABEL_193;
        }
        jsonarray.close();
        if (obj3 != null)
        {
            try
            {
                ((GZIPOutputStream) (obj3)).close();
            }
            // Misplaced declaration of an exception variable
            catch (JSONArray jsonarray)
            {
                logger.e("Errror closing compression streams", jsonarray);
            }
        }
        obj = obj4;
        break MISSING_BLOCK_LABEL_143;
_L4:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_244;
        }
        ((ByteArrayOutputStream) (obj)).close();
        if (obj1 != null)
        {
            try
            {
                ((GZIPOutputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                logger.e("Errror closing compression streams", ((Throwable) (obj)));
            }
        }
        throw jsonarray;
        exception;
        obj = jsonarray;
        obj1 = obj2;
        jsonarray = exception;
        continue; /* Loop/switch isn't completed */
        obj2;
        obj = jsonarray;
        jsonarray = ((JSONArray) (obj2));
        if (true) goto _L4; else goto _L3
        obj2;
        if (true) goto _L6; else goto _L5
_L5:
    }

}
