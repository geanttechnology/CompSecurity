// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.rio.j2me.client.trans.IServiceConnection;
import com.amazon.rio.j2me.client.trans.ServerConnectionFactory;

// Referenced classes of package com.amazon.mShop.sso:
//            SignedMShopService, SignedHttpServerConnection

class onnection
    implements ServerConnectionFactory
{

    public IServiceConnection getServerConnection()
    {
        return new SignedHttpServerConnection(AndroidPlatform.getInstance().getSecureServiceUrl());
    }

    onnection()
    {
    }
}
