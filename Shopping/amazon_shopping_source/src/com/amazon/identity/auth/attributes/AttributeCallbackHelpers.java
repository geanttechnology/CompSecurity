// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.attributes;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;

public final class AttributeCallbackHelpers
{

    private AttributeCallbackHelpers()
    {
    }

    public static void callbackWithError(Callback callback, int i, String s)
    {
        if (callback == null)
        {
            return;
        } else
        {
            callback.onError(createErrorResult(i, s));
            return;
        }
    }

    public static Bundle createErrorResult(int i, String s)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("error_code_key", i);
        bundle.putString("error_message_key", s);
        return bundle;
    }
}
