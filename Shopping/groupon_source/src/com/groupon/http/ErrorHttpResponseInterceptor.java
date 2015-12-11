// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.http;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import roboguice.util.Ln;

public class ErrorHttpResponseInterceptor
    implements Interceptor
{

    public ErrorHttpResponseInterceptor()
    {
    }

    public Response intercept(com.squareup.okhttp.Interceptor.Chain chain)
        throws IOException
    {
        Response response = chain.proceed(chain.request());
        int i = response.code();
        if (i < 200 || i >= 400)
        {
            Headers headers = null;
            Object obj = chain.request();
            try
            {
                chain = ((Request) (obj)).uri();
            }
            // Misplaced declaration of an exception variable
            catch (com.squareup.okhttp.Interceptor.Chain chain)
            {
                Ln.e("Impossible to retrieve request URI from response", new Object[] {
                    chain
                });
                chain = headers;
            }
            headers = ((Request) (obj)).headers();
            Ln.w("Displaying headers for failed %s uri: %s", new Object[] {
                Integer.valueOf(i), chain
            });
            String s1;
            for (obj = headers.names().iterator(); ((Iterator) (obj)).hasNext(); Ln.w("REQUEST %s: %s", new Object[] {
    s1, headers.get(s1)
}))
            {
                s1 = (String)((Iterator) (obj)).next();
            }

            obj = response.headers();
            Ln.w("Displaying headers for failed %s uri: %s", new Object[] {
                Integer.valueOf(i), chain
            });
            chain = headers.names().iterator();
            while (chain.hasNext()) 
            {
                String s = (String)chain.next();
                Ln.w("REQUEST %s: %s", new Object[] {
                    s, ((Headers) (obj)).get(s)
                });
            }
        }
        return response;
    }
}
