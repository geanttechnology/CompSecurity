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
import com.amazon.identity.auth.device.framework.SecureContentResolver;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.utils.BackwardsCompatiabilityHelper;
import com.amazon.identity.auth.device.utils.DBUtils;
import com.amazon.identity.auth.device.utils.KeyInfo;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.ParcelUtils;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import com.amazon.identity.platform.util.PlatformUtils;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.ExecutionException;
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
    public static final String COLUMN_BUNDLE_VALUE = "bundle_value";
    public static final String COMMAND_KEY = "command";
    public static final Uri CUSTOMER_ATTRIBUTE_STORE_URI = Uri.parse("content://amazon_customer_attribute_store");
    public static final String GET_ATTRIBUTE_COMMAND = "getAttribute";
    public static final String KEY_ACCOUNT_NAME = "accountName";
    public static final String KEY_ACCOUNT_TYPE = "accountType";
    public static final String KEY_BUNDLE_INFO = "bundleInfo";
    public static final String KEY_CUSTOMER_ATTRIBUTE_NAME = "key";
    public static final String KEY_DIRECTED_ID = "directedId";
    public static final String KEY_GET_OPTIONS_ARRAY = "getOptions";
    public static final String PEEK_ATTRIBUTE_COMMAND = "peekAttribute";
    public static final String SET_ATTRIBUTE_COMMAND = "setAttribute";
    private static final String TAG = com/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication.getName();
    private final ServiceWrappingContext mContext;
    private final PlatformWrapper mPlatform;
    private final SecureContentResolver mSecureContentResolver;

    public CentralCustomerAttributeStoreCommunication(ServiceWrappingContext servicewrappingcontext)
    {
        this(servicewrappingcontext, (PlatformWrapper)servicewrappingcontext.getSystemService("sso_platform"), new SecureContentResolver(servicewrappingcontext));
    }

    public CentralCustomerAttributeStoreCommunication(ServiceWrappingContext servicewrappingcontext, PlatformWrapper platformwrapper, SecureContentResolver securecontentresolver)
    {
        mContext = servicewrappingcontext;
        mPlatform = platformwrapper;
        mSecureContentResolver = securecontentresolver;
    }

    private JSONObject getJsonCommandInfo(String s, String s1, String s2, Bundle bundle, EnumSet enumset)
    {
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        jsonobject.put("command", s);
        jsonobject.put("directedId", s1);
        if (!mPlatform.isNewIdentiyMobilePlatformSSO()) goto _L2; else goto _L1
_L1:
        s = null;
_L8:
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        jsonobject.put("accountType", ((Account) (s)).type);
        jsonobject.put("accountName", ((Account) (s)).name);
        if (!PlatformUtils.isPostMergeDevice(mContext)) goto _L4; else goto _L3
_L3:
        jsonobject.put("key", s2);
        jsonobject.put("bundleInfo", ParcelUtils.bundleToString(bundle));
        s = jsonobject;
        if (enumset == null) goto _L6; else goto _L5
_L5:
        jsonobject.put("getOptions", com.amazon.identity.auth.device.api.CustomerAttributeStore.GetAttributeOptions.serializeList(enumset));
        return jsonobject;
_L2:
        try
        {
            s = BackwardsCompatiabilityHelper.getAccountWithDirectedId(mContext, s1);
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, "Error creating Customer Attribute IPC Command", s);
            s = null;
        }
          goto _L6
_L4:
        s2 = KeyInfo.parseKey(s2).getKey();
          goto _L3
_L6:
        return s;
        if (true) goto _L8; else goto _L7
_L7:
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
        throws ExecutionException
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
                    CentralCustomerAttributeStoreCommunication.access$200(CentralCustomerAttributeStoreCommunication.this, key, callbackFuture, ((Bundle) (obj)), 2, String.format("Key %s not supported", new Object[] {
                        key
                    }));
                    return;
                }
                catch (ExecutionException executionexception)
                {
                    MAPLog.e(CentralCustomerAttributeStoreCommunication.TAG, "Failed to call getAttribute", executionexception);
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
            break MISSING_BLOCK_LABEL_46;
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
                CentralCustomerAttributeStoreCommunication.access$200(CentralCustomerAttributeStoreCommunication.this, key, callbackFuture, bundle, 5, String.format("Unable to set the attribute for key: %s.", new Object[] {
                    key
                }));
                return;
                ExecutionException executionexception;
                executionexception;
                MAPLog.e(CentralCustomerAttributeStoreCommunication.TAG, "Failed to setAttribute in central customer attribute store", executionexception);
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
    static void access$200(CentralCustomerAttributeStoreCommunication centralcustomerattributestorecommunication, String s, CallbackFuture callbackfuture, Bundle bundle, int i, String s1)
    {
        if (bundle == null)
        {
            AttributeCallbackHelpers.callbackWithError(callbackfuture, i, s1);
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
