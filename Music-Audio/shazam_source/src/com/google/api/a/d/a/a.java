// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.d.a;

import com.google.api.a.d.y;
import com.google.api.a.d.z;
import com.google.api.a.g.w;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.RequestLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.params.HttpConnectionParams;

// Referenced classes of package com.google.api.a.d.a:
//            d, b

final class a extends y
{

    private final HttpClient e;
    private final HttpRequestBase f;

    a(HttpClient httpclient, HttpRequestBase httprequestbase)
    {
        e = httpclient;
        f = httprequestbase;
    }

    public final z a()
    {
        if (super.d != null)
        {
            w.a(f instanceof HttpEntityEnclosingRequest, "Apache HTTP client does not support %s requests with content.", new Object[] {
                f.getRequestLine().getMethod()
            });
            d d1 = new d(super.a, super.d);
            d1.setContentEncoding(super.b);
            d1.setContentType(super.c);
            ((HttpEntityEnclosingRequest)f).setEntity(d1);
        }
        return new b(f, e.execute(f));
    }

    public final void a(int i, int j)
    {
        org.apache.http.params.HttpParams httpparams = f.getParams();
        ConnManagerParams.setTimeout(httpparams, i);
        HttpConnectionParams.setConnectionTimeout(httpparams, i);
        HttpConnectionParams.setSoTimeout(httpparams, j);
    }

    public final void a(String s, String s1)
    {
        f.addHeader(s, s1);
    }
}
