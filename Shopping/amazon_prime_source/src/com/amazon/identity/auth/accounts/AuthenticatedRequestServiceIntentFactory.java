// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.amazon.identity.auth.device.framework.SSOIntentFactory;

public class AuthenticatedRequestServiceIntentFactory extends SSOIntentFactory
{

    public AuthenticatedRequestServiceIntentFactory(ComponentName componentname)
    {
        super(componentname);
    }

    public static AuthenticatedRequestServiceIntentFactory findAuthRequestService(Context context)
    {
        context = findSSOComponent(context, "com.amazon.dcp.sso.AuthenticatedRequestService", SERVICE_FINDER);
        if (context == null)
        {
            return null;
        } else
        {
            return new AuthenticatedRequestServiceIntentFactory(context);
        }
    }

    public Intent buildIntentForService()
    {
        return buildIntent("com.amazon.dcp.sso.action.GET_DEVICE_CREDENTIALS");
    }
}
