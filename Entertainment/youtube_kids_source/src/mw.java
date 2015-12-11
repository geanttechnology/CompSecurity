// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;

public final class mw
    implements mx
{

    private HttpClient a;

    public mw(HttpClient httpclient)
    {
        a = httpclient;
    }

    private static void a(HttpEntityEnclosingRequestBase httpentityenclosingrequestbase, me me1)
    {
        me1 = me1.h();
        if (me1 != null)
        {
            httpentityenclosingrequestbase.setEntity(new ByteArrayEntity(me1));
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

    public final HttpResponse a(me me1, Map map)
    {
        me1.a;
        JVM INSTR tableswitch -1 3: default 40
    //                   -1 50
    //                   0 161
    //                   1 191
    //                   2 221
    //                   3 176;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        throw new IllegalStateException("Unknown request method.");
_L2:
        Object obj;
        byte abyte0[] = me1.e();
        int i;
        if (abyte0 != null)
        {
            obj = new HttpPost(me1.a());
            ((HttpPost) (obj)).addHeader("Content-Type", me1.d());
            ((HttpPost) (obj)).setEntity(new ByteArrayEntity(abyte0));
        } else
        {
            obj = new HttpGet(me1.a());
        }
_L8:
        a(((HttpUriRequest) (obj)), map);
        a(((HttpUriRequest) (obj)), me1.c());
        map = ((HttpUriRequest) (obj)).getParams();
        i = me1.k_();
        HttpConnectionParams.setConnectionTimeout(map, 5000);
        HttpConnectionParams.setSoTimeout(map, i);
        return a.execute(((HttpUriRequest) (obj)));
_L3:
        obj = new HttpGet(me1.a());
        continue; /* Loop/switch isn't completed */
_L6:
        obj = new HttpDelete(me1.a());
        continue; /* Loop/switch isn't completed */
_L4:
        obj = new HttpPost(me1.a());
        ((HttpPost) (obj)).addHeader("Content-Type", me1.g());
        a(((HttpEntityEnclosingRequestBase) (obj)), me1);
        continue; /* Loop/switch isn't completed */
_L5:
        obj = new HttpPut(me1.a());
        ((HttpPut) (obj)).addHeader("Content-Type", me1.g());
        a(((HttpEntityEnclosingRequestBase) (obj)), me1);
        if (true) goto _L8; else goto _L7
_L7:
    }
}
