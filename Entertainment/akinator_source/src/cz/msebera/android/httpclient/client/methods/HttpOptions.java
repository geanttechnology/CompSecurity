// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.methods;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.util.Args;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package cz.msebera.android.httpclient.client.methods:
//            HttpRequestBase

public class HttpOptions extends HttpRequestBase
{

    public static final String METHOD_NAME = "OPTIONS";

    public HttpOptions()
    {
    }

    public HttpOptions(String s)
    {
        setURI(URI.create(s));
    }

    public HttpOptions(URI uri)
    {
        setURI(uri);
    }

    public Set getAllowedMethods(HttpResponse httpresponse)
    {
        Args.notNull(httpresponse, "HTTP response");
        httpresponse = httpresponse.headerIterator("Allow");
        HashSet hashset = new HashSet();
        while (httpresponse.hasNext()) 
        {
            HeaderElement aheaderelement[] = httpresponse.nextHeader().getElements();
            int j = aheaderelement.length;
            int i = 0;
            while (i < j) 
            {
                hashset.add(aheaderelement[i].getName());
                i++;
            }
        }
        return hashset;
    }

    public String getMethod()
    {
        return "OPTIONS";
    }
}
