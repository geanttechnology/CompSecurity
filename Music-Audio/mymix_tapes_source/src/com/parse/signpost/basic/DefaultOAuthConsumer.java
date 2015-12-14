// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse.signpost.basic;

import com.parse.signpost.AbstractOAuthConsumer;
import com.parse.signpost.http.HttpRequest;
import java.net.HttpURLConnection;

// Referenced classes of package com.parse.signpost.basic:
//            HttpURLConnectionRequestAdapter

public class DefaultOAuthConsumer extends AbstractOAuthConsumer
{

    private static final long serialVersionUID = 1L;

    public DefaultOAuthConsumer(String s, String s1)
    {
        super(s, s1);
    }

    protected HttpRequest wrap(Object obj)
    {
        if (!(obj instanceof HttpURLConnection))
        {
            throw new IllegalArgumentException("The default consumer expects requests of type java.net.HttpURLConnection");
        } else
        {
            return new HttpURLConnectionRequestAdapter((HttpURLConnection)obj);
        }
    }
}
