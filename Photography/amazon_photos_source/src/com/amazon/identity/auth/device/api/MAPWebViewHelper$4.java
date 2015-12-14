// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.app.Activity;
import android.os.Bundle;
import com.amazon.identity.auth.device.token.TokenCallbackHelpers;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            Callback, MAPWebViewHelper, MAPWebViewEventHelper

class val.activity
    implements Callback
{

    final MAPWebViewHelper this$0;
    final Activity val$activity;

    public void onError(Bundle bundle)
    {
        MAPWebViewEventHelper.setError(bundle, MAPWebViewHelper.access$400(MAPWebViewHelper.this));
    }

    public void onSuccess(Bundle bundle)
    {
        bundle = bundle.getStringArray("com.amazon.identity.auth.device.api.cookiekeys.all");
        if (bundle != null && bundle.length != 0)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        MAPWebViewHelper.access$700();
        MAPWebViewHelper.access$800(MAPWebViewHelper.this, val$activity);
        return;
        bundle;
        MAPWebViewHelper.access$700();
        (new StringBuilder("Android Resource error: ")).append(bundle.getMessage()).toString();
        MAPWebViewEventHelper.setError(TokenCallbackHelpers.getErrorBundle(egistrationError.BAD_REQUEST.value(), "NoSuchFieldError: Check your resources."), MAPWebViewHelper.access$400(MAPWebViewHelper.this));
        return;
    }

    ers()
    {
        this$0 = final_mapwebviewhelper;
        val$activity = Activity.this;
        super();
    }
}
