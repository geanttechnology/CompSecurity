// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.platform;

import com.amazon.mShop.iface.client.trans.AndroidHttpServerConnection;
import com.amazon.rio.j2me.client.trans.IServiceConnection;
import com.amazon.rio.j2me.client.trans.ServerConnection;
import com.amazon.rio.j2me.client.trans.ServerConnectionFactory;

// Referenced classes of package com.amazon.mShop.platform:
//            AndroidPlatform

class this._cls0
    implements ServerConnectionFactory
{

    final AndroidPlatform this$0;

    public volatile IServiceConnection getServerConnection()
    {
        return getServerConnection();
    }

    public ServerConnection getServerConnection()
    {
        return new AndroidHttpServerConnection(getServiceUrl());
    }

    ction()
    {
        this$0 = AndroidPlatform.this;
        super();
    }
}
