// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import com.amazon.identity.auth.request.AuthenticatedUrlConnectionAdapter;
import java.net.HttpURLConnection;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            AuthenticatedURLConnection

static final class r extends AuthenticatedUrlConnectionAdapter
{

    public byte[] getBody()
    {
        return new byte[0];
    }

    r(HttpURLConnection httpurlconnection)
    {
        super(httpurlconnection);
    }
}
