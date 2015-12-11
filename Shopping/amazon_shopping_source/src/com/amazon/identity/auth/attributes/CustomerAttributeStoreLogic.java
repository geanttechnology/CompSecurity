// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.attributes;

import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.accounts.AccountManagerDefinition;
import com.amazon.identity.auth.accounts.SubAuthenticatorDescription;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.MAPCallbackErrorException;
import com.amazon.identity.auth.device.api.MAPFuture;
import com.amazon.identity.auth.device.callback.CallbackFuture;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.storage.BackwardsCompatiableDataStorage;
import com.amazon.identity.auth.device.storage.DataStorage;
import com.amazon.identity.auth.device.storage.LocalAppDataAwareDataStorage;
import com.amazon.identity.auth.device.storage.TokenCacheHolder;
import com.amazon.identity.auth.device.token.TokenCache;
import com.amazon.identity.auth.device.token.TokenCallbackHelpers;
import com.amazon.identity.auth.device.utils.BackwardsCompatiabilityHelper;
import com.amazon.identity.auth.device.utils.BundleUtils;
import com.amazon.identity.auth.device.utils.DeviceTypeHelpers;
import com.amazon.identity.auth.device.utils.KeyInfo;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.SecurityHelpers;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import com.amazon.identity.platform.util.PlatformUtils;
import java.io.IOException;
import java.util.EnumSet;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.amazon.identity.auth.attributes:
//            CustomerAttributeStoreDefinition, CorPfmInfo, CorPfmLogic, KindleStoreCredentialsRequestAction, 
//            CORPFMResponse, AttributeCallbackHelpers, CustomerAttributeStoreKeyUtils

public class CustomerAttributeStoreLogic
    implements CustomerAttributeStoreDefinition
{

    private static final String TAG = com/amazon/identity/auth/attributes/CustomerAttributeStoreLogic.getName();
    private final AccountManagerDefinition mAccountManagerDefinition;
    private final Context mContext;
    private final CorPfmInfo mCorPfmInfo;
    private final CorPfmLogic mCorPfmLogic;
    private final LocalAppDataAwareDataStorage mCustomerAttributeDataStorage;
    private final DataStorage mDataStorage;
    private final KindleStoreCredentialsRequestAction mKindleStoreCredentialsRequestAction;

    CustomerAttributeStoreLogic(Context context, DataStorage datastorage, CorPfmInfo corpfminfo, CorPfmLogic corpfmlogic, LocalAppDataAwareDataStorage localappdataawaredatastorage, AccountManagerDefinition accountmanagerdefinition, KindleStoreCredentialsRequestAction kindlestorecredentialsrequestaction)
    {
        mContext = context;
        mDataStorage = datastorage;
        mCorPfmInfo = corpfminfo;
        mCorPfmLogic = corpfmlogic;
        mCustomerAttributeDataStorage = localappdataawaredatastorage;
        mAccountManagerDefinition = accountmanagerdefinition;
        mKindleStoreCredentialsRequestAction = kindlestorecredentialsrequestaction;
    }

    public CustomerAttributeStoreLogic(ServiceWrappingContext servicewrappingcontext)
    {
        this(servicewrappingcontext, servicewrappingcontext.getDataStorage());
    }

    public CustomerAttributeStoreLogic(ServiceWrappingContext servicewrappingcontext, DataStorage datastorage)
    {
        mContext = servicewrappingcontext;
        mDataStorage = datastorage;
        mCorPfmInfo = new CorPfmInfo(servicewrappingcontext);
        mCorPfmLogic = CorPfmLogic.getInstance(mContext);
        servicewrappingcontext = new BackwardsCompatiableDataStorage(mContext);
        mCustomerAttributeDataStorage = new LocalAppDataAwareDataStorage(mContext, servicewrappingcontext);
        mAccountManagerDefinition = (AccountManagerDefinition)mContext.getSystemService("sso_map_account_manager_communicator");
        mKindleStoreCredentialsRequestAction = new KindleStoreCredentialsRequestAction(mContext);
    }

    private void callbackWithValueDefaultBundleResult(Callback callback, String s, String s1)
    {
        callback.onSuccess(createValueDefaultBundle(s, s1));
    }

    private Bundle createUnknownAttributeKeyError(String s)
    {
        s = String.format("The attribute %s is not currently supported", new Object[] {
            s
        });
        MAPLog.e(TAG, s);
        return AttributeCallbackHelpers.createErrorResult(2, s);
    }

    private Bundle createValueDefaultBundle(String s, String s1)
    {
        Bundle bundle = new Bundle();
        bundle.putString("value_key", s);
        bundle.putString("defaut_value_key", s1);
        return bundle;
    }

    private String getKindleDeviceEmailFromTokenCache(String s)
    {
        try
        {
            MAPLog.i(TAG, "Using backwards compatabile way to get device email");
            s = BackwardsCompatiabilityHelper.getAccountWithDirectedId(mContext, s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, "OperationCanceledException: ", s);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, "AuthenticatorException: ", s);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, "IOException: ", s);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, "IllegalArgumentException:", s);
            return null;
        }
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        s = TAG;
        return null;
        s = TokenCacheHolder.getInstance(mContext).getTokenCache(s).blockingFetchToken(SubAuthenticatorDescription.getDMSDeviceEmailFromPackageName("com.amazon.kindle"));
        return s;
    }

    private Bundle peekKeyDirectlyFromUserData(String s, KeyInfo keyinfo)
    {
        return createValueDefaultBundle(mCustomerAttributeDataStorage.peekUserData(s, keyinfo.getRawKey()), null);
    }

    private Bundle unableToGetAttribute(String s)
    {
        s = String.format("Unable to retrive attribute %s", new Object[] {
            s
        });
        MAPLog.w(TAG, s);
        return AttributeCallbackHelpers.createErrorResult(4, s);
    }

    private boolean updatePackageCredentials(String s, KeyInfo keyinfo, Tracer tracer)
    {
        if (!PlatformUtils.isPostCongoAmazonDevice(mContext) && DeviceTypeHelpers.isPackageUsingCentralDeviceType(mContext, keyinfo.getPackageName()))
        {
            MAPLog.i(TAG, String.format("Forcing a refresh of attribute %s is not supported on the platform before Otter_Congo.", new Object[] {
                keyinfo.getRawKey()
            }));
            return true;
        }
        MAPLog.i(TAG, String.format("Forcing a refresh of attribute %s", new Object[] {
            keyinfo.getRawKey()
        }));
        s = (Bundle)mAccountManagerDefinition.updateAccountWithKey(s, keyinfo, null, null, tracer).get();
        return s != null;
        s;
        MAPLog.e(TAG, (new StringBuilder("Got MAPCallbackErrorException while trying to update credentials. Error Bundle: ")).append(BundleUtils.toString(s.getErrorBundle())).toString(), s);
_L2:
        return false;
        s;
        MAPLog.e(TAG, "Got InterruptedException while trying to update credentials", s);
        continue; /* Loop/switch isn't completed */
        s;
        MAPLog.e(TAG, "Got ExecutionException while trying to update credentials", s);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public MAPFuture getAttribute(final String directedId, final String key, final Callback callbackFuture, Bundle bundle, final EnumSet options, final Tracer tracer)
    {
        callbackFuture = new CallbackFuture(callbackFuture);
        if (options.contains(com.amazon.identity.auth.device.api.CustomerAttributeStore.GetAttributeOptions.ForceRefresh))
        {
            bundle = mContext.getPackageManager().getPackagesForUid(Binder.getCallingUid());
            MAPLog.w(TAG, "Packages %s is force refreshing key %s", new Object[] {
                TextUtils.join(", ", bundle), key
            });
        }
        ThreadUtils.submitToBackgroundThread(new Runnable() {

            final CustomerAttributeStoreLogic this$0;
            final CallbackFuture val$callbackFuture;
            final String val$directedId;
            final String val$key;
            final EnumSet val$options;
            final Tracer val$tracer;

            public void run()
            {
                KeyInfo keyinfo = KeyInfo.parseKey(key);
                if (CustomerAttributeStoreKeyUtils.isCorPfm(keyinfo))
                {
                    CustomerAttributeStoreLogic.access$000(CustomerAttributeStoreLogic.this, callbackFuture, directedId, keyinfo.getKey(), options);
                    return;
                }
                if (CustomerAttributeStoreKeyUtils.isCustomerProfileAttributeKey(keyinfo))
                {
                    CustomerAttributeStoreLogic.access$100(CustomerAttributeStoreLogic.this, callbackFuture, directedId, keyinfo, options, tracer);
                    return;
                }
                if (CustomerAttributeStoreKeyUtils.isXMainAndXACBCookies(keyinfo))
                {
                    keyinfo = keyinfo.getPackagelessKeyInfo();
                    String s1 = 
// JavaClassFileOutputException: get_constant: invalid tag

            
            {
                this$0 = CustomerAttributeStoreLogic.this;
                key = s;
                callbackFuture = callbackfuture;
                directedId = s1;
                options = enumset;
                tracer = tracer1;
                super();
            }
        });
        return callbackFuture;
    }

    public Bundle peekAttribute(String s, String s1)
    {
        KeyInfo keyinfo = KeyInfo.parseKey(s1);
        if (CustomerAttributeStoreKeyUtils.isCorPfm(keyinfo))
        {
            s1 = keyinfo.getKey();
            if ("COR".equals(s1))
            {
                return createValueDefaultBundle(mDataStorage.getUserData(s, "com.amazon.dcp.sso.property.account.cor"), mCorPfmInfo.getDeviceDefaultCor());
            }
            if ("PFM".equals(s1))
            {
                return createValueDefaultBundle(mDataStorage.getUserData(s, "com.amazon.dcp.sso.property.account.pfm"), mCorPfmInfo.getDeviceDefaultPfm());
            } else
            {
                throw new IllegalStateException(String.format("Key %s not recognized as COR/PFM value", new Object[] {
                    s1
                }));
            }
        }
        if (CustomerAttributeStoreKeyUtils.isCustomerProfileAttributeKey(keyinfo))
        {
            return peekKeyDirectlyFromUserData(s, keyinfo);
        }
        if (CustomerAttributeStoreKeyUtils.isXMainAndXACBCookies(keyinfo))
        {
            return peekKeyDirectlyFromUserData(s, keyinfo.getPackagelessKeyInfo());
        }
        if (CustomerAttributeStoreKeyUtils.isXFSNCookie(keyinfo))
        {
            return createValueDefaultBundle(mCustomerAttributeDataStorage.peekToken(s, keyinfo.getRawKey()), null);
        } else
        {
            return createUnknownAttributeKeyError(s1);
        }
    }

    public MAPFuture setAttribute(final String directedId, final String key, final String value, Callback callback)
    {
        final CallbackFuture callbackFuture;
        KeyInfo keyinfo;
        int i;
        callbackFuture = new CallbackFuture(callback);
        keyinfo = KeyInfo.parseKey(key);
        if (keyinfo == null)
        {
            i = 0;
        } else
        if (!keyinfo.getKey().startsWith("com.amazon.dcp.sso.property.account.extratokens."))
        {
            MAPLog.e(TAG, String.format("The key: %s does not have a valid prefix.", new Object[] {
                key
            }));
            i = 0;
        } else
        {
label0:
            {
                if (keyinfo.getPackageName() != null)
                {
                    break label0;
                }
                i = 1;
            }
        }
_L3:
        String as[];
        int j;
        boolean flag;
        if (i == 0)
        {
            directedId = String.format("Not authorized to setAttribute for key: %s.", new Object[] {
                key
            });
            MAPLog.e(TAG, directedId);
            AttributeCallbackHelpers.callbackWithError(callback, 5, directedId);
            return callbackFuture;
        } else
        {
            ThreadUtils.submitToBackgroundThread(new Runnable() {

                final CustomerAttributeStoreLogic this$0;
                final CallbackFuture val$callbackFuture;
                final String val$directedId;
                final String val$key;
                final String val$value;

                public void run()
                {
                    KeyInfo keyinfo1 = KeyInfo.parseKey(key);
                    MAPLog.i(CustomerAttributeStoreLogic.TAG, String.format("Setting the attribute for key: %s", new Object[] {
                        keyinfo1.getRawKey()
                    }));
                    mCustomerAttributeDataStorage.setUserData(directedId, keyinfo1.getRawKey(), value);
                    callbackWithValueDefaultBundleResult(callbackFuture, value, null);
                }

            
            {
                this$0 = CustomerAttributeStoreLogic.this;
                key = s;
                directedId = s1;
                value = s2;
                callbackFuture = callbackfuture;
                super();
            }
            });
            return callbackFuture;
        }
        as = SecurityHelpers.getCallingPackages(mContext);
        j = as.length;
        i = 0;
_L4:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_233;
        }
        if (!TextUtils.equals(as[i], keyinfo.getPackageName())) goto _L2; else goto _L1
_L1:
        flag = true;
_L5:
        i = ((flag) ? 1 : 0);
        if (!flag)
        {
            MAPLog.e(TAG, String.format("Cannot set the key: %s in package: %s.", new Object[] {
                key, mContext.getPackageName()
            }));
            i = ((flag) ? 1 : 0);
        }
          goto _L3
_L2:
        i++;
          goto _L4
        flag = false;
          goto _L5
    }



/*
    static void access$000(CustomerAttributeStoreLogic customerattributestorelogic, Callback callback, String s, String s1, EnumSet enumset)
    {
        if (enumset.contains(com.amazon.identity.auth.device.api.CustomerAttributeStore.GetAttributeOptions.ForceRefresh))
        {
            MAPLog.i(TAG, String.format("Forcing a refresh of attribute %s", new Object[] {
                s1
            }));
            s = customerattributestorelogic.mCorPfmLogic.fetchCorPfm(s);
        } else
        {
            s = customerattributestorelogic.mCorPfmLogic.fetchCorPfmIfNotSet(s);
        }
        if (s == null)
        {
            callback.onError(customerattributestorelogic.unableToGetAttribute(s1));
            return;
        }
        if ("COR".equals(s1))
        {
            customerattributestorelogic.callbackWithValueDefaultBundleResult(callback, s.getCustomerProvidedCOR(), customerattributestorelogic.mCorPfmInfo.getDeviceDefaultCor());
            return;
        }
        if ("PFM".equals(s1))
        {
            customerattributestorelogic.callbackWithValueDefaultBundleResult(callback, s.getCustomerProvidedPFM(), customerattributestorelogic.mCorPfmInfo.getDeviceDefaultPfm());
            return;
        } else
        {
            throw new IllegalStateException(String.format("Key %s not recognized as COR/PFM value", new Object[] {
                s1
            }));
        }
    }

*/


/*
    static void access$100(CustomerAttributeStoreLogic customerattributestorelogic, Callback callback, String s, KeyInfo keyinfo, EnumSet enumset, Tracer tracer)
    {
        if (enumset.contains(com.amazon.identity.auth.device.api.CustomerAttributeStore.GetAttributeOptions.ForceRefresh) && !customerattributestorelogic.updatePackageCredentials(s, keyinfo, tracer))
        {
            callback.onError(AttributeCallbackHelpers.createErrorResult(1, "Was unable to successfully refresh the credentials on a platform that supports it"));
            return;
        }
        tracer = customerattributestorelogic.mCustomerAttributeDataStorage.getUserData(s, keyinfo.getRawKey());
        enumset = tracer;
        if (tracer == null)
        {
            enumset = tracer;
            if (!PlatformUtils.isPostMergeDevice(customerattributestorelogic.mContext))
            {
                if (DeviceTypeHelpers.arePackagesUsingTheSameDeviceType(customerattributestorelogic.mContext, keyinfo.getPackageName(), "com.amazon.kindle") && "com.amazon.dcp.sso.property.deviceemail".equals(keyinfo.getKey()))
                {
                    enumset = customerattributestorelogic.getKindleDeviceEmailFromTokenCache(s);
                } else
                {
                    enumset = null;
                }
            }
        }
        customerattributestorelogic.callbackWithValueDefaultBundleResult(callback, enumset, null);
        return;
    }

*/


/*
    static void access$200(CustomerAttributeStoreLogic customerattributestorelogic, Callback callback, String s, KeyInfo keyinfo, EnumSet enumset, Tracer tracer)
    {
        String s1 = customerattributestorelogic.mCustomerAttributeDataStorage.getUserData(s, keyinfo.getRawKey());
        if (s1 == null || enumset.contains(com.amazon.identity.auth.device.api.CustomerAttributeStore.GetAttributeOptions.ForceRefresh))
        {
            boolean flag;
            if (PlatformUtils.isOtter(customerattributestorelogic.mContext))
            {
                flag = customerattributestorelogic.mKindleStoreCredentialsRequestAction.updateStoreCredentialCookies(s);
            } else
            {
                flag = customerattributestorelogic.updatePackageCredentials(s, keyinfo, tracer);
            }
            if (!flag)
            {
                callback.onError(customerattributestorelogic.unableToGetAttribute(keyinfo.getKey()));
                return;
            }
            s1 = customerattributestorelogic.mCustomerAttributeDataStorage.getUserData(s, keyinfo.getRawKey());
        }
        customerattributestorelogic.callbackWithValueDefaultBundleResult(callback, s1, null);
        return;
    }

*/





}
