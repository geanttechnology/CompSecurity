// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.rest.account;

import com.amazon.gallery.foundation.utils.DebugAssert;

// Referenced classes of package com.amazon.gallery.framework.network.http.rest.account:
//            HttpConfig, Endpoint

public class ProdHttpConfig
    implements HttpConfig
{

    protected static final String ENDPOINTS[] = {
        "http://www.amazon.com/photos/api/", "http://www.amazon.co.uk/photos/api/", "http://www.amazon.co.jp/photos/api/", "http://www.amazon.cn/photos/api/"
    };

    public ProdHttpConfig()
    {
    }

    public Endpoint getDefaultEndpoint(String s, int i)
    {
        boolean flag;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        DebugAssert.assertTrue(flag);
        i--;
        if (i < ENDPOINTS.length)
        {
            return new Endpoint(ENDPOINTS[i], true);
        } else
        {
            return null;
        }
    }

    public boolean isDefaultEndpointSticky()
    {
        return false;
    }

}
