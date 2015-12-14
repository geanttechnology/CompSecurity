// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.os.Bundle;
import com.amazon.identity.auth.device.callback.CallbackFuture;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            MAPLog

public final class ADPCorpusSigningCallbackHelpers
{

    public static void callbackError(CallbackFuture callbackfuture, int i, String s)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("error_code_key", i);
        bundle.putString("error_message_key", s);
        callbackfuture.onError(bundle);
    }

    public static void nullCorpusCallbackError(CallbackFuture callbackfuture, String s)
    {
        MAPLog.e(s, "Cannot sign a null corpus.");
        callbackError(callbackfuture, 3, "Cannot sign a null corpus.");
    }
}
