// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.amazon.identity.auth.device.api.Callback;

public final class AccountsCallbackHelpers
{

    private static final SparseIntArray ACCOUNT_MANAGER_ERRORS_TO_MAP_ERRORS;

    public static Bundle getAccountAlreadyExistsErrorBundle(String s)
    {
        Bundle bundle = getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.ACCOUNT_ALREADY_EXISTS.value(), "Account has already been registered on this device");
        if (!TextUtils.isEmpty(s))
        {
            bundle.putString("com.amazon.dcp.sso.property.account.acctId", s);
        }
        return bundle;
    }

    public static Bundle getAccountManagerErrorBundle(int i, String s)
    {
        int j = ACCOUNT_MANAGER_ERRORS_TO_MAP_ERRORS.get(i, 0x80000000);
        Integer integer;
        Bundle bundle;
        if (j == 0x80000000)
        {
            integer = null;
        } else
        {
            integer = Integer.valueOf(j);
        }
        bundle = new Bundle();
        if (integer != null)
        {
            bundle = getErrorBundle(integer.intValue(), s);
        }
        bundle.putInt("errorCode", i);
        bundle.putString("errorMessage", s);
        return bundle;
    }

    public static Bundle getErrorBundle(int i, String s)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("com.amazon.dcp.sso.ErrorCode", i);
        bundle.putString("com.amazon.dcp.sso.ErrorMessage", s);
        return bundle;
    }

    public static boolean hasError(Bundle bundle)
    {
        while (bundle == null || !bundle.containsKey("com.amazon.dcp.sso.ErrorCode") && !bundle.containsKey("errorCode")) 
        {
            return false;
        }
        return true;
    }

    public static void onAccountAlreadyExistsError(Callback callback, String s)
    {
        if (callback == null)
        {
            return;
        } else
        {
            callback.onError(getAccountAlreadyExistsErrorBundle(s));
            return;
        }
    }

    public static void onAccountManagerError(Callback callback, int i, String s)
    {
        if (callback == null)
        {
            return;
        } else
        {
            callback.onError(getAccountManagerErrorBundle(i, s));
            return;
        }
    }

    public static void onError(Callback callback, int i, String s, Bundle bundle)
    {
        if (callback == null)
        {
            return;
        }
        s = getErrorBundle(i, s);
        if (bundle != null)
        {
            s.putAll(bundle);
        }
        callback.onError(s);
    }

    public static void resultToSuccessOrError(Callback callback, Bundle bundle)
    {
        if (callback == null)
        {
            return;
        }
        if (hasError(bundle))
        {
            callback.onError(bundle);
            return;
        } else
        {
            callback.onSuccess(bundle);
            return;
        }
    }

    static 
    {
        SparseIntArray sparseintarray = new SparseIntArray();
        ACCOUNT_MANAGER_ERRORS_TO_MAP_ERRORS = sparseintarray;
        sparseintarray.append(7, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST.value());
        ACCOUNT_MANAGER_ERRORS_TO_MAP_ERRORS.append(8, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST.value());
        ACCOUNT_MANAGER_ERRORS_TO_MAP_ERRORS.append(4, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.REGISTER_FAILED.value());
        ACCOUNT_MANAGER_ERRORS_TO_MAP_ERRORS.append(5, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.PARSE_ERROR.value());
        ACCOUNT_MANAGER_ERRORS_TO_MAP_ERRORS.append(3, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.NETWORK_FAILURE.value());
        ACCOUNT_MANAGER_ERRORS_TO_MAP_ERRORS.append(1, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.REGISTER_FAILED.value());
        ACCOUNT_MANAGER_ERRORS_TO_MAP_ERRORS.append(6, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED.value());
    }
}
