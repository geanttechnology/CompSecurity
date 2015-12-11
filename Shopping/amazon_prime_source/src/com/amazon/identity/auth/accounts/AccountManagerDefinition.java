// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.app.Activity;
import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.MAPFuture;
import com.amazon.identity.auth.device.api.RegistrationType;
import com.amazon.identity.auth.device.api.SigninOption;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.utils.KeyInfo;
import java.util.Set;

public interface AccountManagerDefinition
{

    public abstract void authenticateAccount(Bundle bundle, Callback callback, Tracer tracer);

    public abstract void authenticateAccountWithUI(Activity activity, SigninOption signinoption, Bundle bundle, Callback callback, Tracer tracer);

    public abstract void confirmCredential(Activity activity, String s, Bundle bundle, Callback callback, Tracer tracer);

    public abstract MAPFuture deregisterAccount(String s, Callback callback, Tracer tracer);

    public abstract MAPFuture deregisterDevice(Callback callback, Tracer tracer);

    public abstract void ensureAccountState(Activity activity, String s, Bundle bundle, Callback callback, Tracer tracer);

    public abstract String getAccount(String s);

    public abstract Set getAccounts();

    public abstract String getPrimaryAccount();

    public abstract boolean isAccountRegistered(String s);

    public abstract boolean isDeviceRegistered();

    public abstract void registerAccount(RegistrationType registrationtype, Bundle bundle, Callback callback, Tracer tracer);

    public abstract void registerAccountWithUI(Activity activity, SigninOption signinoption, Bundle bundle, Callback callback, Tracer tracer);

    public abstract MAPFuture registerChildApplication$3b8086d2(String s, String s1, Bundle bundle, Tracer tracer);

    public abstract MAPFuture renameDevice(String s, String s1, Bundle bundle, Callback callback, Tracer tracer);

    public abstract MAPFuture updateAccountWithKey$5e2b1462(String s, KeyInfo keyinfo, Tracer tracer);
}
