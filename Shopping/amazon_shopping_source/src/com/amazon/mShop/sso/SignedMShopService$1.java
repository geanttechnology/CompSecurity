// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import com.amazon.rio.j2me.client.trans.IServiceConnection;
import com.amazon.rio.j2me.client.trans.ServerConnectionFactory;

// Referenced classes of package com.amazon.mShop.sso:
//            SignedMShopService

class onnection
    implements ServerConnectionFactory
{

    public IServiceConnection getServerConnection()
    {
        throw new RuntimeException("signed requests must always go over SSL");
    }

    onnection()
    {
    }
}
