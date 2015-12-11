// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.accounts.AccountManagerDefinition;
import com.amazon.identity.auth.accounts.AccountManagerImplementationFactory;
import com.amazon.identity.auth.attributes.CustomerAttributeStoreDefinition;
import com.amazon.identity.auth.attributes.CustomerAttributeStoreImplementationFactory;
import com.amazon.identity.auth.attributes.CustomerAttributeStoreKeyUtils;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.utils.KeyInfo;
import com.amazon.identity.auth.device.utils.MAPArgContracts;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.platform.metric.MetricsHelper;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;
import java.util.EnumSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            Callback, MAPFuture

public final class CustomerAttributeStore
{
    public static final class GetAttributeOptions extends Enum
    {

        private static final GetAttributeOptions $VALUES[];
        public static final GetAttributeOptions ForceRefresh;
        private final String mUniqueValue;

        public static EnumSet deserializeList(JSONArray jsonarray)
        {
            EnumSet enumset = EnumSet.noneOf(com/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions);
            int i = 0;
            while (i < jsonarray.length()) 
            {
                try
                {
                    enumset.add(getOptionFromValue(jsonarray.getString(i)));
                }
                catch (JSONException jsonexception)
                {
                    MAPLog.e(CustomerAttributeStore.TAG, "Could not deseralize part of getAttribute options", jsonexception);
                }
                i++;
            }
            return enumset;
        }

        public static GetAttributeOptions getOptionFromValue(String s)
        {
            GetAttributeOptions agetattributeoptions[] = values();
            int j = agetattributeoptions.length;
            for (int i = 0; i < j; i++)
            {
                GetAttributeOptions getattributeoptions = agetattributeoptions[i];
                if (getattributeoptions.getValue().equals(s))
                {
                    return getattributeoptions;
                }
            }

            return null;
        }

        public static JSONArray serializeList(EnumSet enumset)
        {
            JSONArray jsonarray = new JSONArray();
            for (enumset = enumset.iterator(); enumset.hasNext(); jsonarray.put(((GetAttributeOptions)enumset.next()).getValue())) { }
            return jsonarray;
        }

        public static GetAttributeOptions valueOf(String s)
        {
            return (GetAttributeOptions)Enum.valueOf(com/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions, s);
        }

        public static GetAttributeOptions[] values()
        {
            return (GetAttributeOptions[])$VALUES.clone();
        }

        public String getValue()
        {
            return mUniqueValue;
        }

        static 
        {
            ForceRefresh = new GetAttributeOptions("ForceRefresh", 0, "forceRefresh");
            $VALUES = (new GetAttributeOptions[] {
                ForceRefresh
            });
        }

        private GetAttributeOptions(String s, int i, String s1)
        {
            super(s, i);
            mUniqueValue = s1;
        }
    }

    public static final class RenameDeviceError
    {

        public static final int AUTHENTICATION_FAILED = 2;
        public static final int INVALID_INPUT = 3;
        public static final int NAME_ALREADY_USED = 5;
        public static final int NETWORK_FAILURE = 1;
        public static final int NO_AMAZON_ACCOUNT = 6;
        public static final int PARSE_ERROR = 4;
        public static final int UNRECOGNIZED = 7;

        private RenameDeviceError()
        {
        }
    }


    public static final String AMAZON_ACCOUNT_PROPERTY_CHANGED_INTENT_ACTION = "com.amazon.dcp.sso.action.AmazonAccountPropertyService.property.changed";
    public static final String COR_PFM_CHANGED_INTENT_ACTION = "com.amazon.dcp.sso.broadcast.CORPFMHasChanged";
    public static final int ERROR_CODE_ACCOUNT_NOT_REGISTERED = 3;
    public static final int ERROR_CODE_GENERIC_INTERNAL_ERROR = 1;
    public static final int ERROR_CODE_KEY_NOT_FOUND = 2;
    public static final int ERROR_CODE_UNABLE_TO_GET_ATTRIBUTE_ERROR = 4;
    public static final int ERROR_CODE_UNABLE_TO_SET_ATTRIBUTE_ERROR = 5;
    public static final String KEY_DEFAULT_VALUE = "defaut_value_key";
    public static final String KEY_DEVICE_EMAIL = "com.amazon.dcp.sso.property.deviceemail";
    public static final String KEY_DEVICE_NAME = "com.amazon.dcp.sso.property.devicename";
    public static final String KEY_DIRECTED_ID = "new.account.property.changed";
    public static final String KEY_ERROR_CODE = "error_code_key";
    public static final String KEY_ERROR_MESSAGE = "error_message_key";
    public static final String KEY_NEW_DEVICE_NAME = "new_device_name";
    public static final String KEY_VALUE = "value_key";
    private static final String METRICS_COMPONENT_NAME = com/amazon/identity/auth/device/api/CustomerAttributeStore.getSimpleName();
    private static final String TAG = com/amazon/identity/auth/device/api/CustomerAttributeStore.getName();
    private static CustomerAttributeStore sTheOneAndTheOnly;
    private AccountManagerDefinition mAccountManagerCommunication;
    private final ServiceWrappingContext mContext;
    private CustomerAttributeStoreDefinition mCustomerAttributeStore;

    CustomerAttributeStore(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mAccountManagerCommunication = null;
    }

    private CustomerAttributeStoreDefinition getCustomerAttributeStore()
    {
        this;
        JVM INSTR monitorenter ;
        CustomerAttributeStoreDefinition customerattributestoredefinition;
        if (mCustomerAttributeStore == null)
        {
            mCustomerAttributeStore = CustomerAttributeStoreImplementationFactory.getCustomerAttributeStoreImplementation(mContext);
        }
        customerattributestoredefinition = mCustomerAttributeStore;
        this;
        JVM INSTR monitorexit ;
        return customerattributestoredefinition;
        Exception exception;
        exception;
        throw exception;
    }

    public static CustomerAttributeStore getInstance(Context context)
    {
        com/amazon/identity/auth/device/api/CustomerAttributeStore;
        JVM INSTR monitorenter ;
        MAPArgContracts.throwIfNull(context, "context");
        if (sTheOneAndTheOnly == null)
        {
            sTheOneAndTheOnly = new CustomerAttributeStore(context.getApplicationContext());
        }
        context = sTheOneAndTheOnly;
        com/amazon/identity/auth/device/api/CustomerAttributeStore;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public static String getValueOrAttributeDefault(Bundle bundle)
    {
        MAPArgContracts.throwIfNull(bundle, "attributeResult");
        String s = bundle.getString("value_key");
        if (s != null)
        {
            return s;
        } else
        {
            return bundle.getString("defaut_value_key");
        }
    }

    private void validateArguments(String s, String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            throw new IllegalArgumentException("Key cannot be null or empty");
        }
        if (s == null && !CustomerAttributeStoreKeyUtils.isCorPfm(KeyInfo.parseKey(s1)))
        {
            throw new IllegalArgumentException("Account cannot be null");
        } else
        {
            return;
        }
    }

    public MAPFuture getAttribute(String s, String s1, Callback callback)
    {
        return getAttribute(s, s1, callback, EnumSet.noneOf(com/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions));
    }

    public MAPFuture getAttribute(String s, String s1, Callback callback, Bundle bundle, EnumSet enumset)
    {
        Tracer tracer = Tracer.getNewTracer("CustomerAttributeStore:GetAttribute");
        validateArguments(s, s1);
        PlatformMetricsTimer platformmetricstimer = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "getAttribute");
        Bundle bundle1 = bundle;
        if (bundle == null)
        {
            bundle1 = new Bundle();
        }
        bundle = enumset;
        if (enumset == null)
        {
            bundle = EnumSet.noneOf(com/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions);
        }
        return getCustomerAttributeStore().getAttribute(s, s1, MetricsHelper.wrapCallback(tracer, platformmetricstimer, callback), bundle1, bundle, tracer);
    }

    public MAPFuture getAttribute(String s, String s1, Callback callback, EnumSet enumset)
    {
        return getAttribute(s, s1, callback, new Bundle(), enumset);
    }

    public Bundle peekAttribute(String s, String s1)
    {
        PlatformMetricsTimer platformmetricstimer;
        validateArguments(s, s1);
        platformmetricstimer = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "peekAttribute");
        s = getCustomerAttributeStore().peekAttribute(s, s1);
        platformmetricstimer.stop();
        return s;
        s;
        platformmetricstimer.stop();
        throw s;
    }

    public MAPFuture renameDevice(String s, String s1, Bundle bundle, Callback callback)
    {
        Tracer tracer = Tracer.getNewTracer("RenameDevice");
        MAPLog.formattedInfo(TAG, "renameDevice called by %s", new Object[] {
            mContext.getPackageName()
        });
        PlatformMetricsTimer platformmetricstimer = tracer.startTimer("Time");
        if (mAccountManagerCommunication == null)
        {
            mAccountManagerCommunication = AccountManagerImplementationFactory.getAccountManagerImplementation(mContext);
        }
        return mAccountManagerCommunication.renameDevice(s, s1, bundle, MetricsHelper.wrapCallback(tracer, platformmetricstimer, callback), tracer);
    }

    public MAPFuture setAttribute(String s, String s1, String s2, Callback callback)
    {
        validateArguments(s, s1);
        PlatformMetricsTimer platformmetricstimer = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "setAttribute");
        return getCustomerAttributeStore().setAttribute(s, s1, s2, MetricsHelper.wrapCallback(platformmetricstimer, callback));
    }


}
