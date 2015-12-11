// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.accounts.AccountAuthenticatorResponse;
import android.os.Bundle;
import android.os.Parcel;
import com.amazon.identity.auth.device.utils.MAPLog;

public class AccountAuthenticatorResponseWrapper
{

    private static final String TAG = com/amazon/identity/auth/accounts/AccountAuthenticatorResponseWrapper.getName();
    private final AccountAuthenticatorResponse mInner;

    public AccountAuthenticatorResponseWrapper(AccountAuthenticatorResponse accountauthenticatorresponse)
    {
        mInner = accountauthenticatorresponse;
    }

    public AccountAuthenticatorResponseWrapper(Parcel parcel)
    {
        mInner = new AccountAuthenticatorResponse(parcel);
    }

    public int describeContents()
    {
        if (mInner == null)
        {
            MAPLog.e(TAG, "Account Authenticator Response is null, can't call describeContents");
            return 0;
        } else
        {
            return mInner.describeContents();
        }
    }

    public AccountAuthenticatorResponse getInner()
    {
        return mInner;
    }

    public void onError(int i, String s)
    {
        if (mInner == null)
        {
            MAPLog.e(TAG, "Account Authenticator Response is null, can't call onError");
            return;
        } else
        {
            mInner.onError(i, s);
            return;
        }
    }

    public void onRequestContinued()
    {
        if (mInner == null)
        {
            MAPLog.e(TAG, "Account Authenticator Response is null, can't call onRequestContinued");
            return;
        } else
        {
            mInner.onRequestContinued();
            return;
        }
    }

    public void onResult(Bundle bundle)
    {
        if (mInner == null)
        {
            MAPLog.e(TAG, "Account Authenticator Response is null, can't call onResult");
            return;
        } else
        {
            mInner.onResult(bundle);
            return;
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (mInner == null)
        {
            MAPLog.e(TAG, "Account Authenticator Response is null, can't call writeToParcel");
            return;
        } else
        {
            mInner.writeToParcel(parcel, i);
            return;
        }
    }

}
