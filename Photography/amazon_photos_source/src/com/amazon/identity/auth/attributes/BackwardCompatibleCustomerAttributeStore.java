// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.attributes;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.MAPFuture;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.utils.KeyInfo;
import java.util.EnumSet;

// Referenced classes of package com.amazon.identity.auth.attributes:
//            CustomerAttributeStoreDefinition, CustomerAttributeStoreLogic, CentralCustomerAttributeStoreCommunication, CustomerAttributeStoreKeyUtils

public class BackwardCompatibleCustomerAttributeStore
    implements CustomerAttributeStoreDefinition
{

    private CustomerAttributeStoreDefinition mCentralCustomerAttributeStore;
    private CustomerAttributeStoreDefinition mCentralCustomerAttributeStoreCommunication;
    private final ServiceWrappingContext mContext;

    public BackwardCompatibleCustomerAttributeStore(ServiceWrappingContext servicewrappingcontext)
    {
        mContext = servicewrappingcontext;
        mCentralCustomerAttributeStore = null;
        mCentralCustomerAttributeStoreCommunication = null;
    }

    private CustomerAttributeStoreDefinition initCentralCustomerAttributeStore()
    {
        if (mCentralCustomerAttributeStore == null)
        {
            mCentralCustomerAttributeStore = new CustomerAttributeStoreLogic(mContext);
        }
        return mCentralCustomerAttributeStore;
    }

    private CustomerAttributeStoreDefinition initCentralCustomerAttributeStoreCommunication()
    {
        if (mCentralCustomerAttributeStoreCommunication == null)
        {
            mCentralCustomerAttributeStoreCommunication = new CentralCustomerAttributeStoreCommunication(mContext, (byte)0);
        }
        return mCentralCustomerAttributeStoreCommunication;
    }

    public MAPFuture getAttribute(String s, String s1, Callback callback, Bundle bundle, EnumSet enumset, Tracer tracer)
    {
        if (CustomerAttributeStoreKeyUtils.isCorPfm(KeyInfo.parseKey(s1)))
        {
            return initCentralCustomerAttributeStoreCommunication().getAttribute(s, KeyInfo.parseKey(s1).getKey(), callback, bundle, enumset, tracer);
        } else
        {
            return initCentralCustomerAttributeStore().getAttribute(s, s1, callback, bundle, enumset, tracer);
        }
    }

    public Bundle peekAttribute(String s, String s1)
    {
        if (CustomerAttributeStoreKeyUtils.isCorPfm(KeyInfo.parseKey(s1)))
        {
            return initCentralCustomerAttributeStoreCommunication().peekAttribute(s, KeyInfo.parseKey(s1).getKey());
        } else
        {
            return initCentralCustomerAttributeStore().peekAttribute(s, s1);
        }
    }

    public MAPFuture setAttribute(String s, String s1, String s2, Callback callback)
    {
        if (CustomerAttributeStoreKeyUtils.isCorPfm(KeyInfo.parseKey(s1)))
        {
            return initCentralCustomerAttributeStoreCommunication().setAttribute(s, KeyInfo.parseKey(s1).getKey(), s2, callback);
        } else
        {
            return initCentralCustomerAttributeStore().setAttribute(s, s1, s2, callback);
        }
    }
}
