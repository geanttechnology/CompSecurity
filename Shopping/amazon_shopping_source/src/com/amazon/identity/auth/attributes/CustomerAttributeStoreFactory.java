// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.attributes;

import com.amazon.identity.auth.device.framework.ServiceWrappingContext;

// Referenced classes of package com.amazon.identity.auth.attributes:
//            BackwardCompatibleCustomerAttributeStore, CustomerAttributeStoreDefinition

public class CustomerAttributeStoreFactory
{

    private final ServiceWrappingContext mContext;

    public CustomerAttributeStoreFactory(ServiceWrappingContext servicewrappingcontext)
    {
        mContext = servicewrappingcontext;
    }

    public CustomerAttributeStoreDefinition createCustomerAttributeStore()
    {
        return new BackwardCompatibleCustomerAttributeStore(mContext);
    }
}
