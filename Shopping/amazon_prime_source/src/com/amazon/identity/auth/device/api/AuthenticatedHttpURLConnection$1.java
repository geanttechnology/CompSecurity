// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import com.amazon.identity.auth.request.AuthenticatedUrlConnectionAdapter;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            AuthenticatedHttpURLConnection

class nit> extends AuthenticatedUrlConnectionAdapter
{

    final AuthenticatedHttpURLConnection this$0;

    public byte[] getBody()
    {
        return ((AuthenticatedHttpURLConnection)getUrlConnection()).getCurrentBody();
    }

    (AuthenticatedHttpURLConnection authenticatedhttpurlconnection1)
    {
        this$0 = AuthenticatedHttpURLConnection.this;
        super(authenticatedhttpurlconnection1);
    }
}
