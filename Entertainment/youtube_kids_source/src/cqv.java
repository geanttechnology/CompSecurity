// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpUriRequest;

public final class cqv extends cqn
    implements android.content.SharedPreferences.OnSharedPreferenceChangeListener
{

    private static Boolean e = null;
    private final HttpClient c;
    private boolean d;

    public cqv(HttpClient httpclient, cot cot, coo coo)
    {
        super(cot, coo);
        d = false;
        c = (HttpClient)b.a(httpclient);
    }

    private static void a(HttpResponse httpresponse)
    {
        httpresponse = httpresponse.getEntity();
        if (httpresponse != null)
        {
            httpresponse.consumeContent();
        }
    }

    protected final void a(Object obj, Object obj1, bhv bhv1, Exception exception)
    {
        obj1 = (HttpUriRequest)obj1;
        if (exception instanceof HttpResponseException)
        {
            Object obj2 = (HttpResponseException)exception;
            String s = String.valueOf(((HttpUriRequest) (obj1)).getURI());
            bmo.e((new StringBuilder(String.valueOf(s).length() + 22)).append("Http error: request=[").append(s).append("]").toString());
            int i = ((HttpResponseException) (obj2)).getStatusCode();
            obj2 = String.valueOf(exception.getMessage());
            bmo.b((new StringBuilder(String.valueOf(obj2).length() + 39)).append("Http error: status=[").append(i).append("] msg=[").append(((String) (obj2))).append("]").toString());
        }
        super.a(obj, obj1, bhv1, exception);
    }

    protected final void b(Object obj, bhv bhv1)
    {
        HttpResponse httpresponse1;
        HttpResponse httpresponse2;
        HttpResponse httpresponse3;
        HttpUriRequest httpurirequest;
        httpurirequest = (HttpUriRequest)obj;
        b.a(httpurirequest);
        if (Boolean.TRUE.equals(e))
        {
            bmo.e(a.a(httpurirequest));
        }
        httpresponse2 = null;
        obj = null;
        httpresponse3 = null;
        httpresponse1 = null;
        HttpResponse httpresponse = c.execute(httpurirequest);
        httpresponse1 = httpresponse;
        httpresponse2 = httpresponse;
        obj = httpresponse;
        httpresponse3 = httpresponse;
        bhv1.a(httpurirequest, httpresponse);
        if (httpresponse == null)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        a(httpresponse);
_L2:
        return;
        obj;
        bmo.b("Error consuming content response", ((Throwable) (obj)));
        return;
        IllegalStateException illegalstateexception;
        illegalstateexception;
        obj = httpresponse1;
        bhv1.a(httpurirequest, illegalstateexception);
        if (httpresponse1 == null) goto _L2; else goto _L1
_L1:
        try
        {
            a(httpresponse1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            bmo.b("Error consuming content response", ((Throwable) (obj)));
        }
        return;
        bhv1;
        obj = httpresponse2;
        httpurirequest.abort();
        obj = httpresponse2;
        throw bhv1;
        bhv1;
        Exception exception;
        if (obj != null)
        {
            try
            {
                a(((HttpResponse) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                bmo.b("Error consuming content response", ((Throwable) (obj)));
            }
        }
        throw bhv1;
        exception;
        obj = httpresponse3;
        bhv1.a(httpurirequest, exception);
        if (httpresponse3 != null)
        {
            try
            {
                a(httpresponse3);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                bmo.b("Error consuming content response", ((Throwable) (obj)));
            }
            return;
        }
          goto _L2
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedpreferences, String s)
    {
        if ("api_request_logging".equals(s))
        {
            e = Boolean.valueOf(sharedpreferences.getBoolean(s, false));
        }
    }

}
