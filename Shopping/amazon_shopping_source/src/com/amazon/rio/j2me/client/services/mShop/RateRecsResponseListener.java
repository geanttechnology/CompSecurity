// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import com.amazon.rio.j2me.client.services.ResponseListener;
import com.amazon.rio.j2me.client.services.ServiceCall;

// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            RateRecsResponse

public interface RateRecsResponseListener
    extends ResponseListener
{

    public abstract void completed(RateRecsResponse raterecsresponse, ServiceCall servicecall);
}
