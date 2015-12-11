// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import com.parse.signpost.AbstractOAuthConsumer;
import com.parse.signpost.http.HttpRequest;

// Referenced classes of package com.parse:
//            ParseHttpRequest, ParseHttpRequestOAuthAdapter

class ParseHttpOAuthConsumer extends AbstractOAuthConsumer
{

    private static final long serialVersionUID = 1L;

    public ParseHttpOAuthConsumer(String s, String s1)
    {
        super(s, s1);
    }

    protected HttpRequest wrap(Object obj)
    {
        if (!(obj instanceof ParseHttpRequest))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("This consumer expects requests of type ").append(com/parse/ParseHttpRequest.getName()).toString());
        } else
        {
            return new ParseHttpRequestOAuthAdapter((ParseHttpRequest)obj);
        }
    }
}
