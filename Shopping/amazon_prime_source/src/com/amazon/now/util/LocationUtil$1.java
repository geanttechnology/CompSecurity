// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.util;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.mobile.mash.error.MASHError;
import com.amazon.now.AmazonActivity;
import org.apache.cordova.CallbackContext;

// Referenced classes of package com.amazon.now.util:
//            LocationUtil

static final class val.callbackContext
    implements Callback
{

    final AmazonActivity val$activity;
    final CallbackContext val$callbackContext;

    public void onError(Bundle bundle)
    {
        val$callbackContext.error(MASHError.INVALID_ARGUMENTS.toJSONObejct());
    }

    public void onSuccess(Bundle bundle)
    {
        LocationUtil.access$000(val$activity, val$callbackContext);
    }

    ror(AmazonActivity amazonactivity, CallbackContext callbackcontext)
    {
        val$activity = amazonactivity;
        val$callbackContext = callbackcontext;
        super();
    }
}
