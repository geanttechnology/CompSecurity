// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package oauth.signpost.commonshttp;

import java.io.InputStream;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.RequestLine;
import org.apache.http.client.methods.HttpUriRequest;

public class a
    implements oauth.signpost.http.a
{

    private HttpUriRequest a;
    private HttpEntity b;

    public a(HttpUriRequest httpurirequest)
    {
        a = httpurirequest;
        if (httpurirequest instanceof HttpEntityEnclosingRequest)
        {
            b = ((HttpEntityEnclosingRequest)httpurirequest).getEntity();
        }
    }

    public String a()
    {
        return a.getRequestLine().getMethod();
    }

    public String a(String s)
    {
        s = a.getFirstHeader(s);
        if (s == null)
        {
            return null;
        } else
        {
            return s.getValue();
        }
    }

    public void a(String s, String s1)
    {
        a.setHeader(s, s1);
    }

    public String b()
    {
        return a.getURI().toString();
    }

    public InputStream c()
    {
        if (b == null)
        {
            return null;
        } else
        {
            return b.getContent();
        }
    }

    public String d()
    {
        Header header;
        if (b != null)
        {
            if ((header = b.getContentType()) != null)
            {
                return header.getValue();
            }
        }
        return null;
    }

    public Object f()
    {
        return a;
    }
}
