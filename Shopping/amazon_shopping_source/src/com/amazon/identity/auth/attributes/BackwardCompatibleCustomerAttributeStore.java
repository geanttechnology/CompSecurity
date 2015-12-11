// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.attributes;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.MAPFuture;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.utils.CentralApkUtils;
import com.amazon.identity.auth.device.utils.KeyInfo;
import com.amazon.identity.platform.util.PlatformUtils;
import java.util.EnumSet;

// Referenced classes of package com.amazon.identity.auth.attributes:
//            CustomerAttributeStoreDefinition, CustomerAttributeStoreLogic, CentralCustomerAttributeStoreCommunication, CustomerAttributeStoreKeyUtils

public class BackwardCompatibleCustomerAttributeStore
    implements CustomerAttributeStoreDefinition
{

    private CustomerAttributeStoreDefinition mCentralCustomerAttributeStore;
    private CustomerAttributeStoreDefinition mCentralCustomerAttributeStoreCommunication;
    private final ServiceWrappingContext mContext;
    private Boolean mHasCentralAPK;
    private Boolean mIsNewIdentiyMobilePlatformSSO;
    private Boolean mIsPlatformHasCustomerAttributeStoreProvider;

    public BackwardCompatibleCustomerAttributeStore(ServiceWrappingContext servicewrappingcontext)
    {
        mContext = servicewrappingcontext;
        mIsNewIdentiyMobilePlatformSSO = null;
        mHasCentralAPK = null;
        mCentralCustomerAttributeStore = null;
        mCentralCustomerAttributeStoreCommunication = null;
        mIsPlatformHasCustomerAttributeStoreProvider = null;
    }

    public BackwardCompatibleCustomerAttributeStore(ServiceWrappingContext servicewrappingcontext, boolean flag, boolean flag1, boolean flag2, CustomerAttributeStoreDefinition customerattributestoredefinition, CustomerAttributeStoreDefinition customerattributestoredefinition1)
    {
        mContext = servicewrappingcontext;
        mIsPlatformHasCustomerAttributeStoreProvider = Boolean.valueOf(flag);
        mIsNewIdentiyMobilePlatformSSO = Boolean.valueOf(flag1);
        mHasCentralAPK = Boolean.valueOf(flag2);
        mCentralCustomerAttributeStore = customerattributestoredefinition;
        mCentralCustomerAttributeStoreCommunication = customerattributestoredefinition1;
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
            mCentralCustomerAttributeStoreCommunication = new CentralCustomerAttributeStoreCommunication(mContext);
        }
        return mCentralCustomerAttributeStoreCommunication;
    }

    private boolean shouldReadAttributeFromLocalCentralCAS(String s)
    {
        boolean flag1;
        flag1 = false;
        if (mHasCentralAPK == null)
        {
            mHasCentralAPK = Boolean.valueOf(CentralApkUtils.hasCentralAPK(mContext));
        }
        if (!mHasCentralAPK.booleanValue()) goto _L2; else goto _L1
_L1:
        if (mIsPlatformHasCustomerAttributeStoreProvider == null)
        {
            mIsPlatformHasCustomerAttributeStoreProvider = Boolean.valueOf(PlatformUtils.unSecureCheckHasContentProviderWithAuthority(mContext, CentralCustomerAttributeStoreCommunication.CUSTOMER_ATTRIBUTE_STORE_URI));
        }
        if (mIsPlatformHasCustomerAttributeStoreProvider.booleanValue()) goto _L3; else goto _L2
_L2:
        boolean flag = true;
_L5:
        return flag;
_L3:
        flag = flag1;
        if (!CustomerAttributeStoreKeyUtils.isCorPfm(KeyInfo.parseKey(s)))
        {
            if (mIsNewIdentiyMobilePlatformSSO == null)
            {
                mIsNewIdentiyMobilePlatformSSO = Boolean.valueOf(PlatformUtils.isPostMergeDevice(mContext));
            }
            flag = flag1;
            if (!mIsNewIdentiyMobilePlatformSSO.booleanValue())
            {
                return true;
            }
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public MAPFuture getAttribute(String s, String s1, Callback callback, Bundle bundle, EnumSet enumset, Tracer tracer)
    {
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        if (enumset == null)
        {
            enumset = EnumSet.noneOf(com/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions);
        }
        if (shouldReadAttributeFromLocalCentralCAS(s1))
        {
            return initCentralCustomerAttributeStore().getAttribute(s, s1, callback, bundle, enumset, tracer);
        } else
        {
            return initCentralCustomerAttributeStoreCommunication().getAttribute(s, s1, callback, bundle, enumset, tracer);
        }
    }

    public Bundle peekAttribute(String s, String s1)
    {
        if (shouldReadAttributeFromLocalCentralCAS(s1))
        {
            return initCentralCustomerAttributeStore().peekAttribute(s, s1);
        } else
        {
            return initCentralCustomerAttributeStoreCommunication().peekAttribute(s, s1);
        }
    }

    public MAPFuture setAttribute(String s, String s1, String s2, Callback callback)
    {
        if (shouldReadAttributeFromLocalCentralCAS(s1))
        {
            return initCentralCustomerAttributeStore().setAttribute(s, s1, s2, callback);
        } else
        {
            return initCentralCustomerAttributeStoreCommunication().setAttribute(s, s1, s2, callback);
        }
    }
}
