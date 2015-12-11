// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.cookie;

import com.comcast.cim.httpcomponentsandroid.cookie.CookieSpec;
import com.comcast.cim.httpcomponentsandroid.cookie.CookieSpecFactory;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import java.util.Collection;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.cookie:
//            NetscapeDraftSpec

public class NetscapeDraftSpecFactory
    implements CookieSpecFactory
{

    public NetscapeDraftSpecFactory()
    {
    }

    public CookieSpec newInstance(HttpParams httpparams)
    {
        if (httpparams != null)
        {
            Object obj = null;
            Collection collection = (Collection)httpparams.getParameter("http.protocol.cookie-datepatterns");
            httpparams = obj;
            if (collection != null)
            {
                httpparams = (String[])collection.toArray(new String[collection.size()]);
            }
            return new NetscapeDraftSpec(httpparams);
        } else
        {
            return new NetscapeDraftSpec();
        }
    }
}
