// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.attributes;

import android.accounts.Account;
import android.content.ContentProviderClient;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.MAPFuture;
import com.amazon.identity.auth.device.callback.CallbackFuture;
import com.amazon.identity.auth.device.framework.ContentProviderClientCallback;
import com.amazon.identity.auth.device.framework.PlatformWrapper;
import com.amazon.identity.auth.device.framework.RemoteMAPException;
import com.amazon.identity.auth.device.framework.SecureContentResolver;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.utils.BackwardsCompatiabilityHelper;
import com.amazon.identity.auth.device.utils.DBUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.ParcelUtils;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.identity.auth.attributes:
//            CustomerAttributeStoreDefinition, AttributeCallbackHelpers

public class CentralCustomerAttributeStoreCommunication
    implements CustomerAttributeStoreDefinition
{

    public static final List COLUMNS = Arrays.asList(new String[] {
        "bundle_value"
    });
    public static final Uri CUSTOMER_ATTRIBUTE_STORE_URI = Uri.parse("content://amazon_customer_attribute_store");
    private static final String TAG = com/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication.getName();
    private final boolean mBackwardsCompatible;
    private final ServiceWrappingContext mContext;
    private final PlatformWrapper mPlatform;
    private final SecureContentResolver mSecureContentResolver;

    public CentralCustomerAttributeStoreCommunication(ServiceWrappingContext servicewrappingcontext)
    {
        this(servicewrappingcontext, (PlatformWrapper)servicewrappingcontext.getSystemService("sso_platform"), new SecureContentResolver(servicewrappingcontext), false);
    }

    public CentralCustomerAttributeStoreCommunication(ServiceWrappingContext servicewrappingcontext, byte byte0)
    {
        this(servicewrappingcontext, (PlatformWrapper)servicewrappingcontext.getSystemService("sso_platform"), new SecureContentResolver(servicewrappingcontext), true);
    }

    public CentralCustomerAttributeStoreCommunication(ServiceWrappingContext servicewrappingcontext, PlatformWrapper platformwrapper, SecureContentResolver securecontentresolver, boolean flag)
    {
        mContext = servicewrappingcontext;
        mPlatform = platformwrapper;
        mSecureContentResolver = securecontentresolver;
        mBackwardsCompatible = flag;
    }

    private JSONObject getJsonCommandInfo(String s, String s1, String s2, Bundle bundle, EnumSet enumset)
    {
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        jsonobject.put("command", s);
        jsonobject.put("directedId", s1);
        if (!mBackwardsCompatible)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        s = BackwardsCompatiabilityHelper.getAccountWithDirectedId(mContext, s1);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        jsonobject.put("accountType", ((Account) (s)).type);
        jsonobject.put("accountName", ((Account) (s)).name);
        jsonobject.put("key", s2);
        jsonobject.put("bundleInfo", ParcelUtils.bundleToString(bundle));
        if (enumset != null)
        {
            try
            {
                jsonobject.put("getOptions", com.amazon.identity.auth.device.api.CustomerAttributeStore.GetAttributeOptions.serializeList(enumset));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                MAPLog.e(TAG, "Error creating Customer Attribute IPC Command", s);
                return null;
            }
        }
        return jsonobject;
    }

    public static Bundle parseCursor(Cursor cursor, String s)
    {
        if (cursor == null || !cursor.moveToFirst())
        {
            cursor = TAG;
            String.format("No results found from central store: %s", new Object[] {
                s
            });
            return null;
        }
        cursor = DBUtils.getString(cursor, "bundle_value");
        if (cursor == null)
        {
            cursor = TAG;
            return null;
        } else
        {
            return ParcelUtils.stringToBundle(cursor);
        }
    }

    private Bundle queryCentralStore(final JSONObject command)
        throws RemoteMAPException
    {
        command = command.toString();
        return (Bundle)mSecureContentResolver.acquireContentProviderClient(CUSTOMER_ATTRIBUTE_STORE_URI, new ContentProviderClientCallback() {

            final CentralCustomerAttributeStoreCommunication this$0;
            final String val$command;

            public Bundle useContentProviderClient(ContentProviderClient contentproviderclient)
                throws RemoteException
            {
                contentproviderclient = contentproviderclient.query(CentralCustomerAttributeStoreCommunication.CUSTOMER_ATTRIBUTE_STORE_URI, (String[])CentralCustomerAttributeStoreCommunication.COLUMNS.toArray(new String[0]), command, null, null);
                Bundle bundle = CentralCustomerAttributeStoreCommunication.parseCursor(contentproviderclient, command);
                if (contentproviderclient != null)
                {
                    contentproviderclient.close();
                }
                return bundle;
                Exception exception;
                exception;
                if (contentproviderclient != null)
                {
                    contentproviderclient.close();
                }
                throw exception;
            }

            public volatile Object useContentProviderClient(ContentProviderClient contentproviderclient)
                throws Exception
            {
                return useContentProviderClient(contentproviderclient);
            }

            
            {
                this$0 = CentralCustomerAttributeStoreCommunication.this;
                command = s;
                super();
            }
        });
    }

    public MAPFuture getAttribute(final String directedId, final String key, final Callback callbackFuture, final Bundle info, final EnumSet options, Tracer tracer)
    {
        callbackFuture = new CallbackFuture(callbackFuture);
        ThreadUtils.submitToBackgroundThread(new Runnable() {

            final CentralCustomerAttributeStoreCommunication this$0;
            final CallbackFuture val$callbackFuture;
            final String val$directedId;
            final Bundle val$info;
            final String val$key;
            final EnumSet val$options;

            public void run()
            {
                Object obj = getJsonCommandInfo("getAttribute", directedId, key, info, options);
                if (obj == null)
                {
                    AttributeCallbackHelpers.callbackWithError(callbackFuture, 1, "Cannot construct command");
                    return;
                }
                try
                {
                    obj = queryCentralStore(((JSONObject) (obj)));
                    Object obj1 = CentralCustomerAttributeStoreCommunication.this;
                    obj1 = key;
                    CentralCustomerAttributeStoreCommunication.access$200$556cb143$6c7269f3(callbackFuture, ((Bundle) (obj)), 2, String.format("Key %s not supported", new Object[] {
                        key
                    }));
                    return;
                }
                catch (RemoteMAPException remotemapexception)
                {
                    MAPLog.e(CentralCustomerAttributeStoreCommunication.TAG, "Failed to call getAttribute", remotemapexception);
                }
                AttributeCallbackHelpers.callbackWithError(callbackFuture, 4, "Failed to call getAttribute");
            }

            
            {
                this$0 = CentralCustomerAttributeStoreCommunication.this;
                directedId = s;
                key = s1;
                info = bundle;
                options = enumset;
                callbackFuture = callbackfuture;
                super();
            }
        });
        return callbackFuture;
    }

    public Bundle peekAttribute(String s, String s1)
    {
        s = getJsonCommandInfo("peekAttribute", s, s1, null, null);
        if (s == null)
        {
            MAPLog.e(TAG, "Failed to construct peek attribute command");
            return null;
        }
        try
        {
            s = queryCentralStore(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, "Failed to call peekAttribute", s);
            return AttributeCallbackHelpers.createErrorResult(4, "Failed to call peekAttribute");
        }
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        s = AttributeCallbackHelpers.createErrorResult(4, "CustomerAttributeStore returned null");
        return s;
        return s;
    }

    public MAPFuture setAttribute(final String directedId, final String key, final String value, final Callback callbackFuture)
    {
        callbackFuture = new CallbackFuture(callbackFuture);
        ThreadUtils.submitToBackgroundThread(new Runnable() {

            final CentralCustomerAttributeStoreCommunication this$0;
            final CallbackFuture val$callbackFuture;
            final String val$directedId;
            final String val$key;
            final String val$value;

            public void run()
            {
                Bundle bundle;
                Object obj;
                bundle = new Bundle();
                bundle.putString(key, value);
                obj = getJsonCommandInfo("setAttribute", directedId, key, bundle, null);
                if (obj == null)
                {
                    AttributeCallbackHelpers.callbackWithError(callbackFuture, 1, "Cannot construct command");
                    return;
                }
                bundle = null;
                obj = queryCentralStore(((JSONObject) (obj)));
                bundle = ((Bundle) (obj));
_L2:
                Object obj1 = CentralCustomerAttributeStoreCommunication.this;
                obj1 = key;
                CentralCustomerAttributeStoreCommunication.access$200$556cb143$6c7269f3(callbackFuture, bundle, 5, String.format("Unable to set the attribute for key: %s.", new Object[] {
                    key
                }));
                return;
                RemoteMAPException remotemapexception;
                remotemapexception;
                MAPLog.e(CentralCustomerAttributeStoreCommunication.TAG, "Failed to setAttribute in central customer attribute store", remotemapexception);
                if (true) goto _L2; else goto _L1
_L1:
            }

            
            {
                this$0 = CentralCustomerAttributeStoreCommunication.this;
                key = s;
                value = s1;
                directedId = s2;
                callbackFuture = callbackfuture;
                super();
            }
        });
        return callbackFuture;
    }





/*
    static void access$200$556cb143$6c7269f3(CallbackFuture callbackfuture, Bundle bundle, int i, String s)
    {
        if (bundle == null)
        {
            AttributeCallbackHelpers.callbackWithError(callbackfuture, i, s);
            return;
        }
        if (bundle.containsKey("error_code_key"))
        {
            callbackfuture.onError(bundle);
            return;
        } else
        {
            callbackfuture.onSuccess(bundle);
            return;
        }
    }

*/

}
