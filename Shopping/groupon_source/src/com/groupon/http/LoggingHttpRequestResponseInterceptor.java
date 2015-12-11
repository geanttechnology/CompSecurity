// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.http;

import android.content.SharedPreferences;
import com.google.inject.Provider;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.HttpUtil;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import roboguice.util.Ln;
import roboguice.util.Strings;

public class LoggingHttpRequestResponseInterceptor
    implements Interceptor
{

    private static final int MAX_SERVER_ERROR_LOG_MESSAGE_SIZE = 2048;
    private Provider loggerProvider;
    protected SharedPreferences prefs;

    public LoggingHttpRequestResponseInterceptor()
    {
    }

    private String suppressPersonalData(Object obj)
    {
        obj = Strings.toString(obj);
        for (Iterator iterator = com.groupon.Constants.Http.hiddenList.iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            obj = ((String) (obj)).replaceAll((new StringBuilder()).append(s).append("\\s*=\\s*[^&]+").toString(), (new StringBuilder()).append(s).append("=HIDDEN").toString());
        }

        return ((String) (obj));
    }

    private String truncateString(String s, int i)
    {
        if (s.length() <= i)
        {
            return s;
        } else
        {
            return s.substring(0, i);
        }
    }

    public Response intercept(com.squareup.okhttp.Interceptor.Chain chain)
        throws IOException
    {
        boolean flag = prefs.getBoolean("includeApiLogs", false);
        Request request = chain.request();
        if (flag)
        {
            Ln.i(suppressPersonalData(request), new Object[0]);
        }
        Object obj;
        if (Ln.isDebugEnabled() && flag)
        {
            Ln.v(request.headers(), new Object[0]);
            obj = request.body();
            if (obj != null)
            {
                String s = Strings.toString(((RequestBody) (obj)).contentType()).toLowerCase();
                if (!s.contains("binary") && !s.contains("multipart/form-data"))
                {
                    Object obj1 = new Buffer();
                    long l;
                    try
                    {
                        ((RequestBody) (obj)).writeTo(((okio.BufferedSink) (obj1)));
                        Ln.v(((Buffer) (obj1)).readUtf8(), new Object[0]);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        Ln.d("Impossible to log request body", new Object[] {
                            obj
                        });
                    }
                }
            }
        }
        l = System.currentTimeMillis();
        chain = chain.proceed(request);
        obj = chain.body();
        if (Ln.isDebugEnabled() && flag && obj != null && Strings.toString(((ResponseBody) (obj)).contentType()).toLowerCase().contains("utf-8"))
        {
            Ln.v(chain, new Object[0]);
            Ln.v(chain.headers(), new Object[0]);
            Ln.v(responseAsString(chain), new Object[0]);
        }
        obj1 = request.urlString();
        obj = chain;
        if (HttpUtil.isExceptionResponseCode(chain.code()))
        {
            obj = chain;
            if (!((String) (obj1)).contains("logging.groupon.com"))
            {
                obj = chain;
                if (!HttpUtil.isUrlTrackerImage(((String) (obj1))))
                {
                    obj1 = chain.body().contentType();
                    if (!HttpUtil.isContentTypeBinary(((com.squareup.okhttp.MediaType) (obj1))) && !Strings.equalsIgnoreCase("gzip", chain.header("Content-Encoding")))
                    {
                        obj = chain.body().string();
                        chain = chain.newBuilder().body(ResponseBody.create(((com.squareup.okhttp.MediaType) (obj1)), ((String) (obj)))).build();
                    } else
                    {
                        obj = "";
                    }
                    logServerError(chain, ((String) (obj)), request, l);
                    obj = chain;
                }
            }
        }
        return ((Response) (obj));
    }

    public void logServerError(Response response, String s, Request request, long l)
    {
        try
        {
            String s1 = suppressPersonalData(request.urlString());
            String s2 = truncateString(request.headers().toString(), 2048);
            String s3 = suppressPersonalData(HttpUtil.getRequestBodyString(request.body(), 2048));
            int i = response.code();
            response = truncateString(response.headers().toString(), 2048);
            s = suppressPersonalData(truncateString(s, 2048));
            ((Logger)loggerProvider.get()).logServerError(request.method(), s1, l, s2, s3, i, response, s, "", "");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Response response)
        {
            Ln.e(response);
        }
    }

    public String responseAsString(Response response)
        throws IOException
    {
        return ByteString.of(response.body().source().buffer().clone().readByteArray()).toString();
    }
}
