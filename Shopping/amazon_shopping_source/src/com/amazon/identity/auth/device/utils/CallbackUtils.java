// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.MAPFuture;
import com.amazon.identity.auth.device.callback.CallbackFuture;

public final class CallbackUtils
{

    private CallbackUtils()
    {
    }

    public static MAPFuture callbackSuccessAndReturnResult(Callback callback, Bundle bundle)
    {
        callback = new CallbackFuture(callback);
        callback.onSuccess(bundle);
        return callback;
    }
}
