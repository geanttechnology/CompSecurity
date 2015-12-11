// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.attributes;

import android.content.Context;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.CentralApkUtils;
import com.amazon.identity.platform.util.PlatformUtils;

// Referenced classes of package com.amazon.identity.auth.attributes:
//            CentralCustomerAttributeStoreCommunication, BackwardCompatibleCustomerAttributeStore, CustomerAttributeStoreLogic, CustomerAttributeStoreDefinition

public final class CustomerAttributeStoreImplementationFactory
{

    public static CustomerAttributeStoreDefinition getCustomerAttributeStoreImplementation(Context context)
    {
        if (PlatformUtils.unSecureCheckHasContentProviderWithAuthority(context, CentralCustomerAttributeStoreCommunication.CUSTOMER_ATTRIBUTE_STORE_URI) && CentralApkUtils.hasCentralAPK(context))
        {
            if (PlatformUtils.isPostMergeDevice(context))
            {
                return new CentralCustomerAttributeStoreCommunication(ServiceWrappingContext.create(context));
            } else
            {
                return new BackwardCompatibleCustomerAttributeStore(ServiceWrappingContext.create(context));
            }
        } else
        {
            return new CustomerAttributeStoreLogic(ServiceWrappingContext.create(context));
        }
    }
}
