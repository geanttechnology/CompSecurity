// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.primeupsell;

import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.OneClickConfigResponse;
import java.util.List;

// Referenced classes of package com.amazon.mShop.primeupsell:
//            PrimeUpsellHelper

private static class <init>
    implements com.amazon.mShop.control.account.t>
{

    public void onError(Exception exception, ServiceCall servicecall)
    {
        PrimeUpsellHelper.access$100();
    }

    public void onReceiveOneClickAddresses(List list)
    {
    }

    public void onReceiveOneClickConfig(OneClickConfigResponse oneclickconfigresponse)
    {
    }

    public void onRequiresUserLogin(com.amazon.mShop.model.auth. )
    {
    }

    public void onSaveOneClickStatus(boolean flag)
    {
        PrimeUpsellHelper.access$100();
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
