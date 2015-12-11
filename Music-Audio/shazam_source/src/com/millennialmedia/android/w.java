// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

// Referenced classes of package com.millennialmedia.android:
//            al

final class w
{

    private HttpClient a;
    private HttpGet b;

    w()
    {
        BasicHttpParams basichttpparams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basichttpparams, 10000);
        a = new DefaultHttpClient(basichttpparams);
        b = new HttpGet();
    }

    w(byte byte0)
    {
        BasicHttpParams basichttpparams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basichttpparams, 10000);
        HttpConnectionParams.setSoTimeout(basichttpparams, 3000);
        a = new DefaultHttpClient(basichttpparams);
        b = new HttpGet();
    }

    static String a(InputStream inputstream)
    {
        if (inputstream == null)
        {
            throw new IOException("Stream is null.");
        }
        Object obj = new BufferedReader(new InputStreamReader(inputstream), 4096);
        inputstream = ((InputStream) (obj));
        Object obj1 = new StringBuilder();
_L2:
        inputstream = ((InputStream) (obj));
        String s = ((BufferedReader) (obj)).readLine();
        if (s == null)
        {
            break; /* Loop/switch isn't completed */
        }
        inputstream = ((InputStream) (obj));
        ((StringBuilder) (obj1)).append((new StringBuilder()).append(s).append("\n").toString());
        if (true) goto _L2; else goto _L1
        obj1;
_L6:
        inputstream = ((InputStream) (obj));
        al.a("HttpGetRequest", "Out of Memeory: ", ((Throwable) (obj1)));
        inputstream = ((InputStream) (obj));
        throw new IOException("Out of memory.");
        obj1;
        obj = inputstream;
        inputstream = ((InputStream) (obj1));
_L4:
        if (obj != null)
        {
            try
            {
                ((BufferedReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                al.a("HttpGetRequest", "Error closing file", ((Throwable) (obj)));
            }
        }
        throw inputstream;
_L1:
        try
        {
            ((BufferedReader) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            al.a("HttpGetRequest", "Error closing file", inputstream);
        }
        return ((StringBuilder) (obj1)).toString();
        inputstream;
        obj = null;
        if (true) goto _L4; else goto _L3
_L3:
        obj1;
        obj = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    static void a(String as[])
    {
        if (as != null && as.length > 0)
        {
            au.c.a(new Runnable(as) {

                final String a[];

                public final void run()
                {
                    String as1[] = a;
                    int j = as1.length;
                    int i = 0;
                    while (i < j) 
                    {
                        String s = as1[i];
                        String.format("Logging event to: %s", new Object[] {
                            s
                        });
                        al.a();
                        try
                        {
                            (new w()).a(s);
                        }
                        catch (Exception exception)
                        {
                            al.a("HttpGetRequest", "Logging request failed.", exception);
                        }
                        i++;
                    }
                }

            
            {
                a = as;
                super();
            }
            });
        }
    }

    final HttpResponse a(String s)
    {
        HttpResponse httpresponse = null;
        if (!TextUtils.isEmpty(s))
        {
            try
            {
                b.setURI(new URI(s));
                httpresponse = a.execute(b);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                al.a("HttpGetRequest", "Out of memory!", s);
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                al.a("HttpGetRequest", "Error connecting:", s);
                return null;
            }
        }
        return httpresponse;
    }
}
