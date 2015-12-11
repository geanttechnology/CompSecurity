// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;

public class chf
    implements che
{

    private static final String a = chf.getCanonicalName();
    private final HttpClient b = a.y();
    private final chh c;

    public chf(chh chh1)
    {
        c = chh1;
    }

    static String a()
    {
        return a;
    }

    public final volatile Object a(Object obj)
    {
        return a((Collection)obj);
    }

    public final Map a(Collection collection)
    {
        HttpResponse httpresponse;
        Object obj1;
        Object obj3;
        if (collection == null || collection.isEmpty())
        {
            return Collections.emptyMap();
        }
        obj3 = c.b(collection);
        obj1 = null;
        collection = null;
        httpresponse = null;
        Object obj2 = b.execute(((org.apache.http.client.methods.HttpUriRequest) (obj3)));
        httpresponse = ((HttpResponse) (obj2));
        obj1 = obj2;
        collection = ((Collection) (obj2));
        int i = ((HttpResponse) (obj2)).getStatusLine().getStatusCode();
        if (i == 200)
        {
            break MISSING_BLOCK_LABEL_305;
        }
        httpresponse = ((HttpResponse) (obj2));
        obj1 = obj2;
        collection = ((Collection) (obj2));
        Object obj4 = a;
        httpresponse = ((HttpResponse) (obj2));
        obj1 = obj2;
        collection = ((Collection) (obj2));
        Object obj5 = String.valueOf(((HttpPost) (obj3)).getURI());
        httpresponse = ((HttpResponse) (obj2));
        obj1 = obj2;
        collection = ((Collection) (obj2));
        Log.w(((String) (obj4)), (new StringBuilder(String.valueOf(obj5).length() + 43)).append("POST ").append(((String) (obj5))).append(" failed. Response code is: ").append(i).toString());
        httpresponse = ((HttpResponse) (obj2));
        obj1 = obj2;
        collection = ((Collection) (obj2));
        obj5 = new ByteArrayOutputStream();
        httpresponse = ((HttpResponse) (obj2));
        obj1 = obj2;
        collection = ((Collection) (obj2));
        ((HttpResponse) (obj2)).getEntity().writeTo(((java.io.OutputStream) (obj5)));
        httpresponse = ((HttpResponse) (obj2));
        obj1 = obj2;
        collection = ((Collection) (obj2));
        obj4 = a;
        httpresponse = ((HttpResponse) (obj2));
        obj1 = obj2;
        collection = ((Collection) (obj2));
        obj5 = String.valueOf(obj5);
        httpresponse = ((HttpResponse) (obj2));
        obj1 = obj2;
        collection = ((Collection) (obj2));
        Log.w(((String) (obj4)), (new StringBuilder(String.valueOf(obj5).length() + 19)).append("Error from server: ").append(((String) (obj5))).toString());
        httpresponse = ((HttpResponse) (obj2));
        obj1 = obj2;
        collection = ((Collection) (obj2));
        obj4 = Collections.emptyMap();
        a.a(((HttpResponse) (obj2)));
        return ((Map) (obj4));
        httpresponse = ((HttpResponse) (obj2));
        obj1 = obj2;
        collection = ((Collection) (obj2));
        obj4 = (new chg(this, (new BasicResponseHandler()).handleResponse(((HttpResponse) (obj2))))).a();
        a.a(((HttpResponse) (obj2)));
        return ((Map) (obj4));
        obj1;
        collection = httpresponse;
        obj2 = a;
        collection = httpresponse;
        obj3 = String.valueOf(((HttpPost) (obj3)).getURI());
        collection = httpresponse;
        Log.e(((String) (obj2)), (new StringBuilder(String.valueOf(obj3).length() + 17)).append("Error posting to ").append(((String) (obj3))).toString(), ((Throwable) (obj1)));
        a.a(httpresponse);
_L2:
        return Collections.emptyMap();
        Object obj;
        obj;
        collection = ((Collection) (obj1));
        Log.e(a, "Error loading screen status.", ((Throwable) (obj)));
        a.a(((HttpResponse) (obj1)));
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        a.a(collection);
        throw obj;
    }

}
