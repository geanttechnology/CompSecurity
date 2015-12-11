// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.framework.GenericIPCSender;
import com.amazon.identity.auth.device.framework.IPCCommand;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.MAPLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            MultipleAccountDefinition

public class MultipleAccountsCommunication
    implements MultipleAccountDefinition
{
    public static class DoesAccountHaveMappingAction
        implements IPCCommand
    {

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

        public DoesAccountHaveMappingAction()
        {
        }
    }

    public static class GetAccountForMappingsUserAction
        implements IPCCommand
    {

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

        public GetAccountForMappingsUserAction()
        {
        }
    }

    public static class RemoveAccountMappingsUserAction
        implements IPCCommand
    {

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

        public RemoveAccountMappingsUserAction()
        {
        }
    }

    public static class SetAccountMappingsUserAction
        implements IPCCommand
    {

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

        public SetAccountMappingsUserAction()
        {
        }
    }


    private static final String TAG = com/amazon/identity/auth/accounts/MultipleAccountsCommunication.getName();
    private final Context mContext;
    private final GenericIPCSender mGenericIpcSender;

    public MultipleAccountsCommunication(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mGenericIpcSender = new GenericIPCSender(mContext, "com.amazon.dcp.sso.ErrorCode", "com.amazon.dcp.sso.ErrorMessage", Integer.valueOf(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.REGISTER_FAILED.value()));
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
        s = DoesAccountHaveMappingAction.parametersToBundle(s, accountmappingtype);
        return DoesAccountHaveMappingAction.getResult(mGenericIpcSender.call(com/amazon/identity/auth/accounts/MultipleAccountsCommunication$DoesAccountHaveMappingAction, s));
    }

    public transient String getAccountForMapping(com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType aaccountmappingtype[])
    {
        aaccountmappingtype = GetAccountForMappingsUserAction.parametersToBundle(aaccountmappingtype);
        return GetAccountForMappingsUserAction.getResult(mGenericIpcSender.call(com/amazon/identity/auth/accounts/MultipleAccountsCommunication$GetAccountForMappingsUserAction, aaccountmappingtype));
    }

    public transient boolean removeAccountMappings(String s, com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType aaccountmappingtype[])
    {
        s = RemoveAccountMappingsUserAction.parametersToBundle(s, aaccountmappingtype);
        return RemoveAccountMappingsUserAction.getResult(mGenericIpcSender.call(com/amazon/identity/auth/accounts/MultipleAccountsCommunication$RemoveAccountMappingsUserAction, s));
    }

    public transient boolean setAccountMappings(String s, com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType aaccountmappingtype[])
    {
        s = SetAccountMappingsUserAction.parametersToBundle(s, aaccountmappingtype);
        return SetAccountMappingsUserAction.getResult(mGenericIpcSender.call(com/amazon/identity/auth/accounts/MultipleAccountsCommunication$SetAccountMappingsUserAction, s));
    }


}
