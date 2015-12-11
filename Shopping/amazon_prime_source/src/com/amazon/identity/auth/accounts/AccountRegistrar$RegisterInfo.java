// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountRegistrar

private static class error
{

    public com.amazon.identity.auth.device.api.Error error;
    public Bundle userData;

    private String commonGetUserDataAttribute(String s)
    {
        if (userData == null)
        {
            return null;
        } else
        {
            return userData.getString(s);
        }
    }

    public String getDirectedId()
    {
        return commonGetUserDataAttribute("com.amazon.dcp.sso.property.account.acctId");
    }

    public String getUserName()
    {
        return commonGetUserDataAttribute("com.amazon.dcp.sso.property.username");
    }

    public onError()
    {
    }

    public onError(Bundle bundle)
    {
        userData = bundle;
    }

    public onError(com.amazon.identity.auth.device.api.Error error1)
    {
        error = error1;
    }
}
