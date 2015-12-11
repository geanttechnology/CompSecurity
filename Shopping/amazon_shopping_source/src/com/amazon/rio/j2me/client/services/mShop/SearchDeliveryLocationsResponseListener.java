// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import com.amazon.rio.j2me.client.services.ResponseListener;
import com.amazon.rio.j2me.client.services.ServiceCall;

// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            Address

public interface SearchDeliveryLocationsResponseListener
    extends ResponseListener
{

    public abstract void aboutToReceiveArrayOfSize(int i, ServiceCall servicecall);

    public abstract void completed(ServiceCall servicecall);

    public abstract void receivedAddress(Address address, int i, ServiceCall servicecall);

    public abstract void receivedMessage(String s, ServiceCall servicecall);

    public abstract void receivedTotalCount(Integer integer, ServiceCall servicecall);

    public abstract void receivedType(Integer integer, ServiceCall servicecall);
}
