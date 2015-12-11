// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.framework.GenericIPCSender;
import com.amazon.identity.auth.device.framework.IPCCommand;
import com.amazon.identity.auth.device.framework.PlatformWrapper;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.StringConversionHelpers;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            MultipleAccountDefinition, MultipleAccountsLogic

public class MultipleAccountsCommunication
    implements MultipleAccountDefinition
{
    public static class DoesAccountHaveMappingAction
        implements IPCCommand
    {

        public static final String KEY_ACCOUNT_MAPPING = "mapping";
        public static final String KEY_DIRECTED_ID = "directedId";
        public static final String KEY_VALUE = "value";

        public static boolean getResult(Bundle bundle)
        {
            return bundle.getBoolean("value");
        }

        public static Bundle parametersToBundle(String s, com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType accountmappingtype)
        {
            Bundle bundle = new Bundle();
            bundle.putString("directedId", s);
            bundle.putString("mapping", MultipleAccountsCommunication.serialize(new com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType[] {
                accountmappingtype
            }));
            return bundle;
        }

        public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
        {
            boolean flag;
            if (bundle == null)
            {
                bundle = new Bundle();
            }
            callback = bundle.getString("directedId");
            bundle = MultipleAccountsCommunication.deserialize(bundle.getString("mapping"));
            if (bundle != null && bundle.length == 1)
            {
                flag = MultipleAccountsLogic.getInstance(context).doesAccountHaveMapping(callback, bundle[0]);
            } else
            {
                MAPLog.e(MultipleAccountsCommunication.TAG, "Did not specify the mappings properly");
                flag = false;
            }
            context = new Bundle();
            context.putBoolean("value", flag);
            return context;
        }

        public DoesAccountHaveMappingAction()
        {
        }
    }

    public static class GetAccountForMappingsUserAction
        implements IPCCommand
    {

        public static final String KEY_ACCOUNT_MAPPINGS = "mappings";
        public static final String KEY_VALUE = "value";

        public static String getResult(Bundle bundle)
        {
            return bundle.getString("value");
        }

        public static transient Bundle parametersToBundle(com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType aaccountmappingtype[])
        {
            Bundle bundle = new Bundle();
            bundle.putString("mappings", MultipleAccountsCommunication.serialize(aaccountmappingtype));
            return bundle;
        }

        public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
        {
            if (bundle == null)
            {
                bundle = new Bundle();
            }
            bundle = MultipleAccountsCommunication.deserialize(bundle.getString("mappings"));
            context = MultipleAccountsLogic.getInstance(context).getAccountForMapping(bundle);
            bundle = new Bundle();
            bundle.putString("value", context);
            return bundle;
        }

        public GetAccountForMappingsUserAction()
        {
        }
    }

    public static class RemoveAccountMappingsUserAction
        implements IPCCommand
    {

        public static final String KEY_ACCOUNT_MAPPINGS = "mappings";
        public static final String KEY_DIRECTED_ID = "directedId";
        public static final String KEY_VALUE = "value";

        public static boolean getResult(Bundle bundle)
        {
            return bundle.getBoolean("value");
        }

        public static transient Bundle parametersToBundle(String s, com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType aaccountmappingtype[])
        {
            Bundle bundle = new Bundle();
            bundle.putString("directedId", s);
            bundle.putString("mappings", MultipleAccountsCommunication.serialize(aaccountmappingtype));
            return bundle;
        }

        public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
        {
            boolean flag;
            if (bundle == null)
            {
                bundle = new Bundle();
            }
            callback = bundle.getString("directedId");
            bundle = MultipleAccountsCommunication.deserialize(bundle.getString("mappings"));
            flag = MultipleAccountsLogic.getInstance(context).removeAccountMappings(callback, bundle);
            context = new Bundle();
            context.putBoolean("value", flag);
            return context;
        }

        public RemoveAccountMappingsUserAction()
        {
        }
    }

    public static class SetAccountMappingsUserAction
        implements IPCCommand
    {

        public static final String KEY_ACCOUNT_MAPPINGS = "mappings";
        public static final String KEY_DIRECTED_ID = "directedId";
        public static final String KEY_VALUE = "value";

        public static boolean getResult(Bundle bundle)
        {
            return bundle.getBoolean("value");
        }

        public static transient Bundle parametersToBundle(String s, com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType aaccountmappingtype[])
        {
            Bundle bundle = new Bundle();
            bundle.putString("directedId", s);
            bundle.putString("mappings", MultipleAccountsCommunication.serialize(aaccountmappingtype));
            return bundle;
        }

        public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
        {
            boolean flag;
            if (bundle == null)
            {
                bundle = new Bundle();
            }
            callback = bundle.getString("directedId");
            bundle = MultipleAccountsCommunication.deserialize(bundle.getString("mappings"));
            flag = MultipleAccountsLogic.getInstance(context).setAccountMappings(callback, bundle);
            context = new Bundle();
            context.putBoolean("value", flag);
            return context;
        }

        public SetAccountMappingsUserAction()
        {
        }
    }


    private static final String TAG = com/amazon/identity/auth/accounts/MultipleAccountsCommunication.getName();
    private final Context mContext;
    private final GenericIPCSender mGenericIpcSender;
    private final PlatformWrapper mPlatformWrapper;

    public MultipleAccountsCommunication(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mPlatformWrapper = (PlatformWrapper)mContext.getSystemService("sso_platform");
        mGenericIpcSender = new GenericIPCSender(mContext, "com.amazon.dcp.sso.ErrorCode", "com.amazon.dcp.sso.ErrorMessage", Integer.valueOf(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.REGISTER_FAILED.value()));
    }

    private static com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType[] deserialize(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        return s;
_L2:
        com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType aaccountmappingtype[];
        Object obj;
        String s1;
        int i;
        JSONArray jsonarray;
        try
        {
            jsonarray = (new JSONObject(s)).getJSONArray("mappings");
            aaccountmappingtype = new com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType[jsonarray.length()];
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, "Could not deseralize all mappings", s);
            return null;
        }
        i = 0;
_L5:
        s = aaccountmappingtype;
        if (i >= jsonarray.length()) goto _L4; else goto _L3
_L3:
        s = jsonarray.getJSONObject(i);
        obj = s.getString("type");
        s1 = s.getString("value");
        s = null;
        if ("com.amazon.dcp.sso.property.sessionuser".equals(obj))
        {
            s = new com.amazon.identity.auth.device.api.MultipleAccountManager.SessionUserMappingType();
            break MISSING_BLOCK_LABEL_215;
        }
        if (!"com.amazon.dcp.sso.property.account.extratokens.account_profiles".equals(obj))
        {
            break MISSING_BLOCK_LABEL_154;
        }
        obj = StringConversionHelpers.toInteger(s1);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        s = new com.amazon.identity.auth.device.api.MultipleAccountManager.ProfileMappingType(((Integer) (obj)).intValue());
        break MISSING_BLOCK_LABEL_215;
        MAPLog.e(TAG, "%s is not a valid profile id", new Object[] {
            s1
        });
        break MISSING_BLOCK_LABEL_215;
        if ("com.amazon.dcp.sso.property.account.extratokens.account_packages".equals(obj))
        {
            s = new com.amazon.identity.auth.device.api.MultipleAccountManager.PackageMappingType(s1);
            break MISSING_BLOCK_LABEL_215;
        }
        if ("com.amazon.dcp.sso.property.account.extratokens.custom_keys".equals(obj))
        {
            s = new com.amazon.identity.auth.device.api.MultipleAccountManager.CustomKeyMappingType(s1);
            break MISSING_BLOCK_LABEL_215;
        }
        if ("primary_account_type".equals(obj))
        {
            s = new com.amazon.identity.auth.device.api.MultipleAccountManager.PrimaryUserMappingType();
        }
        if (s != null)
        {
            aaccountmappingtype[i] = s;
        }
        i++;
          goto _L5
    }

    private static transient String serialize(com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType aaccountmappingtype[])
    {
        JSONObject jsonobject;
        JSONArray jsonarray;
        com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType accountmappingtype;
        JSONObject jsonobject1;
        int i;
        int j;
        try
        {
            jsonobject = new JSONObject();
            jsonarray = new JSONArray();
            j = aaccountmappingtype.length;
        }
        // Misplaced declaration of an exception variable
        catch (com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType aaccountmappingtype[])
        {
            MAPLog.e(TAG, "Could not seralize all mappings", aaccountmappingtype);
            return null;
        }
        i = 0;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        accountmappingtype = aaccountmappingtype[i];
        jsonobject1 = new JSONObject();
        jsonobject1.put("type", accountmappingtype.getAccountMappingType());
        jsonobject1.put("value", accountmappingtype.getAccountMappingValue());
        jsonarray.put(jsonobject1);
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_23;
_L1:
        jsonobject.put("mappings", jsonarray);
        aaccountmappingtype = jsonobject.toString();
        return aaccountmappingtype;
    }

    public boolean doesAccountHaveMapping(String s, com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType accountmappingtype)
    {
        if (mPlatformWrapper.isNewIdentiyMobilePlatformSSO())
        {
            s = DoesAccountHaveMappingAction.parametersToBundle(s, accountmappingtype);
            return DoesAccountHaveMappingAction.getResult(mGenericIpcSender.call(com/amazon/identity/auth/accounts/MultipleAccountsCommunication$DoesAccountHaveMappingAction, s));
        } else
        {
            return MultipleAccountsLogic.getInstance(mContext).doesAccountHaveMapping(s, accountmappingtype);
        }
    }

    public transient String getAccountForMapping(com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType aaccountmappingtype[])
    {
        if (mPlatformWrapper.isNewIdentiyMobilePlatformSSO())
        {
            aaccountmappingtype = GetAccountForMappingsUserAction.parametersToBundle(aaccountmappingtype);
            return GetAccountForMappingsUserAction.getResult(mGenericIpcSender.call(com/amazon/identity/auth/accounts/MultipleAccountsCommunication$GetAccountForMappingsUserAction, aaccountmappingtype));
        } else
        {
            return MultipleAccountsLogic.getInstance(mContext).getAccountForMapping(aaccountmappingtype);
        }
    }

    public transient boolean removeAccountMappings(String s, com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType aaccountmappingtype[])
    {
        if (mPlatformWrapper.isNewIdentiyMobilePlatformSSO())
        {
            s = RemoveAccountMappingsUserAction.parametersToBundle(s, aaccountmappingtype);
            return RemoveAccountMappingsUserAction.getResult(mGenericIpcSender.call(com/amazon/identity/auth/accounts/MultipleAccountsCommunication$RemoveAccountMappingsUserAction, s));
        } else
        {
            return MultipleAccountsLogic.getInstance(mContext).removeAccountMappings(s, aaccountmappingtype);
        }
    }

    public transient boolean setAccountMappings(String s, com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType aaccountmappingtype[])
    {
        if (mPlatformWrapper.isNewIdentiyMobilePlatformSSO())
        {
            s = SetAccountMappingsUserAction.parametersToBundle(s, aaccountmappingtype);
            return SetAccountMappingsUserAction.getResult(mGenericIpcSender.call(com/amazon/identity/auth/accounts/MultipleAccountsCommunication$SetAccountMappingsUserAction, s));
        } else
        {
            return MultipleAccountsLogic.getInstance(mContext).setAccountMappings(s, aaccountmappingtype);
        }
    }




}
