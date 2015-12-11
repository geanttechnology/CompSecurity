// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.d.a;

import com.google.api.a.d.z;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpRequestBase;

final class b extends z
{

    private final HttpRequestBase a;
    private final HttpResponse b;
    private final Header c[];

    b(HttpRequestBase httprequestbase, HttpResponse httpresponse)
    {
        a = httprequestbase;
        b = httpresponse;
        c = httpresponse.getAllHeaders();
    }

    public final InputStream a()
    {
        HttpEntity httpentity = b.getEntity();
        if (httpentity == null)
        {
            return null;
        } else
        {
            return httpentity.getContent();
        }
    }

    public final String a(int i)
    {
        return c[i].getName();
    }

    public final String b()
    {
        Object obj = b.getEntity();
        if (obj != null)
        {
            obj = ((HttpEntity) (obj)).getContentEncoding();
            if (obj != null)
            {
                return ((Header) (obj)).getValue();
            }
        }
        return null;
    }

    public final String b(int i)
    {
        return c[i].getValue();
    }

    public final String c()
    {
        Object obj = b.getEntity();
        if (obj != null)
        {
            obj = ((HttpEntity) (obj)).getContentType();
            if (obj != null)
            {
                return ((Header) (obj)).getValue();
            }
        }
        return null;
    }

    public final String d()
    {
        StatusLine statusline = b.getStatusLine();
        if (statusline == null)
        {
            return null;
        } else
        {
            return statusline.toString();
        }
    }

    public final int e()
    {
        StatusLine statusline = b.getStatusLine();
        if (statusline == null)
        {
            return 0;
        } else
        {
            return statusline.getStatusCode();
        }
    }

    public final String f()
    {
        StatusLine statusline = b.getStatusLine();
        if (statusline == null)
        {
            return null;
        } else
        {
            return statusline.getReasonPhrase();
        }
    }

    public final int g()
    {
        return c.length;
    }

    public final void h()
    {
        a.abort();
    }
}
