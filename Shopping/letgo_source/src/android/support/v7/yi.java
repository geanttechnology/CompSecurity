// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;

// Referenced classes of package android.support.v7:
//            yk, lo, ve

public class yi
    implements yk
{
    public static final class a extends HttpEntityEnclosingRequestBase
    {

        public String getMethod()
        {
            return "PATCH";
        }

        public a()
        {
        }

        public a(String s)
        {
            setURI(URI.create(s));
        }
    }


    protected final HttpClient a;

    public yi(HttpClient httpclient)
    {
        a = httpclient;
    }

    private static void a(HttpEntityEnclosingRequestBase httpentityenclosingrequestbase, ve ve1)
        throws lo
    {
        ve1 = ve1.o();
        if (ve1 != null)
        {
            httpentityenclosingrequestbase.setEntity(new ByteArrayEntity(ve1));
        }
    }

    private static void a(HttpUriRequest httpurirequest, Map map)
    {
        String s;
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); httpurirequest.setHeader(s, (String)map.get(s)))
        {
            s = (String)iterator.next();
        }

    }

    static HttpUriRequest b(ve ve1, Map map)
        throws lo
    {
        switch (ve1.b())
        {
        default:
            throw new IllegalStateException("Unknown request method.");

        case -1: 
            map = ve1.k();
            if (map != null)
            {
                HttpPost httppost = new HttpPost(ve1.d());
                httppost.addHeader("Content-Type", ve1.j());
                httppost.setEntity(new ByteArrayEntity(map));
                return httppost;
            } else
            {
                return new HttpGet(ve1.d());
            }

        case 0: // '\0'
            return new HttpGet(ve1.d());

        case 3: // '\003'
            return new HttpDelete(ve1.d());

        case 1: // '\001'
            map = new HttpPost(ve1.d());
            map.addHeader("Content-Type", ve1.n());
            a(map, ve1);
            return map;

        case 2: // '\002'
            map = new HttpPut(ve1.d());
            map.addHeader("Content-Type", ve1.n());
            a(map, ve1);
            return map;

        case 4: // '\004'
            return new HttpHead(ve1.d());

        case 5: // '\005'
            return new HttpOptions(ve1.d());

        case 6: // '\006'
            return new HttpTrace(ve1.d());

        case 7: // '\007'
            map = new a(ve1.d());
            map.addHeader("Content-Type", ve1.n());
            a(map, ve1);
            return map;
        }
    }

    public HttpResponse a(ve ve1, Map map)
        throws IOException, lo
    {
        HttpUriRequest httpurirequest = b(ve1, map);
        a(httpurirequest, map);
        a(httpurirequest, ve1.a());
        a(httpurirequest);
        map = httpurirequest.getParams();
        int i = ve1.r();
        HttpConnectionParams.setConnectionTimeout(map, 5000);
        HttpConnectionParams.setSoTimeout(map, i);
        return a.execute(httpurirequest);
    }

    protected void a(HttpUriRequest httpurirequest)
        throws IOException
    {
    }
}
