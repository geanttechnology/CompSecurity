// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import com.amazon.mShop.net.MShopRioEventListener;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.rio.j2me.client.rsc.AsynchronousServiceCallInvoker;
import com.amazon.rio.j2me.client.rsc.ServiceCallInvoker;
import com.amazon.rio.j2me.client.services.RioEventListener;
import com.amazon.rio.j2me.client.services.mShop.MShopServiceImpl;
import com.amazon.rio.j2me.client.trans.IServiceConnection;
import com.amazon.rio.j2me.client.trans.ServerConnectionFactory;

// Referenced classes of package com.amazon.mShop.sso:
//            SignedHttpServerConnection

public class SignedMShopService extends MShopServiceImpl
{

    public SignedMShopService()
    {
        this(AndroidPlatform.getInstance().getApplicationId(), ((ServiceCallInvoker) (new AsynchronousServiceCallInvoker(new ServerConnectionFactory() {

            public IServiceConnection getServerConnection()
            {
                throw new RuntimeException("signed requests must always go over SSL");
            }

        }, new ServerConnectionFactory() {

            public IServiceConnection getServerConnection()
            {
                return new SignedHttpServerConnection(AndroidPlatform.getInstance().getSecureServiceUrl());
            }

        }))), MShopRioEventListener.getRioEventListener());
    }

    private SignedMShopService(String s, ServiceCallInvoker servicecallinvoker, RioEventListener rioeventlistener)
    {
        super(s, servicecallinvoker, rioeventlistener);
    }
}
