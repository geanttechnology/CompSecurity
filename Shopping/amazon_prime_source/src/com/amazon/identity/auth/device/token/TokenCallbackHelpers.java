// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import android.os.Bundle;
import android.util.SparseIntArray;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.utils.MAPLog;

public final class TokenCallbackHelpers
{

    private static final SparseIntArray ACCOUNT_MANAGER_ERRORS_TO_MAP_ERRORS;
    private static final String TAG = com/amazon/identity/auth/device/token/TokenCallbackHelpers.getName();

    private TokenCallbackHelpers()
    {
    }

    public static void callbackError(Callback callback, int i, String s)
    {
        if (callback == null)
        {
            MAPLog.e(TAG, "Cannot callback success because no callback was given");
            return;
        } else
        {
            callback.onError(getErrorBundle(i, s));
            return;
        }
    }

    public static void callbackSuccess(Callback callback, String s)
    {
        if (callback == null)
        {
            MAPLog.e(TAG, "Cannot callback success because no callback was given");
            return;
        } else
        {
            Bundle bundle = new Bundle();
            bundle.putString("value_key", s);
            callback.onSuccess(bundle);
            return;
        }
    }

    public static Bundle getErrorBundle(int i, String s)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("com.amazon.dcp.sso.ErrorCode", i);
        bundle.putString("com.amazon.dcp.sso.ErrorMessage", s);
        return bundle;
    }

    public static Bundle getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError registrationerror, String s)
    {
        return getErrorBundle(registrationerror.value(), s);
    }

    public static void onAccountManagerError(Callback callback, int i, String s)
    {
        if (callback == null)
        {
            return;
        }
        int j = ACCOUNT_MANAGER_ERRORS_TO_MAP_ERRORS.get(i, 0x80000000);
        Object obj;
        Bundle bundle;
        if (j == 0x80000000)
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(j);
        }
        bundle = new Bundle();
        if (obj != null)
        {
            obj = getErrorBundle(((Integer) (obj)).intValue(), s);
        } else
        {
            obj = bundle;
        }
        ((Bundle) (obj)).putInt("errorCode", i);
        ((Bundle) (obj)).putString("errorMessage", s);
        callback.onError(((Bundle) (obj)));
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
