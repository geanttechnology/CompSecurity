// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.oauth.signpost.commonshttpandroid;

import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.client.methods.HttpUriRequest;
import oauth.signpost.AbstractOAuthConsumer;

// Referenced classes of package com.comcast.cim.oauth.signpost.commonshttpandroid:
//            HttpRequestAdapter

public class CommonsHttpOAuthConsumer extends AbstractOAuthConsumer
{

    public CommonsHttpOAuthConsumer(String s, String s1)
    {
        super(s, s1);
    }

    protected oauth.signpost.http.HttpRequest wrap(Object obj)
    {
        if (!(obj instanceof HttpRequest))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("This consumer expects requests of type ").append(com/comcast/cim/httpcomponentsandroid/HttpRequest.getCanonicalName()).toString());
        } else
        {
            return new HttpRequestAdapter((HttpUriRequest)obj);
        }
    }
}
