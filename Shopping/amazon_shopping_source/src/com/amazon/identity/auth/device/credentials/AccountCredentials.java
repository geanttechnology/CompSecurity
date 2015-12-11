// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.credentials;

import android.content.Context;
import com.amazon.identity.kcpsdk.auth.ITokenAuthProvider;

public abstract class AccountCredentials extends ITokenAuthProvider
{

    public AccountCredentials()
    {
    }

    public abstract String getPrivateKey();

    public abstract String getToken();

    public abstract boolean isStale(Context context);
}
