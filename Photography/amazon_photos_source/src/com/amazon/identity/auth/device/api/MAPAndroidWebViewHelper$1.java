// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.app.Activity;
import android.os.Bundle;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            Callback, MAPAndroidWebViewHelper, MAPAccountManager

class val.directedId
    implements Callback
{

    final MAPAndroidWebViewHelper this$0;
    final Activity val$activity;
    final String val$directedId;

    public void onError(Bundle bundle)
    {
        MAPAndroidWebViewHelper.access$100();
        (new StringBuilder("getCookies call failed with error ")).append(bundle.getString("com.amazon.dcp.sso.ErrorMessage")).toString();
        if (!MAPAndroidWebViewHelper.access$300(MAPAndroidWebViewHelper.this).isAccountRegistered(val$directedId))
        {
            MAPAndroidWebViewHelper.access$100();
            (new StringBuilder("account ")).append(val$directedId).append(" is not registered").toString();
            MAPAndroidWebViewHelper.access$200(MAPAndroidWebViewHelper.this, val$activity);
            return;
        } else
        {
            onEvent("ON_UNABLE_TO_GET_COOKIES", bundle);
            return;
        }
    }

    public void onSuccess(Bundle bundle)
    {
        bundle = bundle.getStringArray("com.amazon.identity.auth.device.api.cookiekeys.all");
        if (bundle == null || bundle.length == 0)
        {
            MAPAndroidWebViewHelper.access$100();
            MAPAndroidWebViewHelper.access$200(MAPAndroidWebViewHelper.this, val$activity);
        }
    }

    ()
    {
        this$0 = final_mapandroidwebviewhelper;
        val$activity = activity1;
        val$directedId = String.this;
        super();
    }
}
