// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.content.Context;
import android.net.Uri;
import com.amazon.identity.auth.device.callback.CallbackFuture;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.io.IOException;
import java.util.Map;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            AuthenticationMethod, AuthenticationType, MAPFuture

class DefaultAuthenticationMethod extends AuthenticationMethod
{

    private static final String TAG = com/amazon/identity/auth/device/api/DefaultAuthenticationMethod.getName();

    DefaultAuthenticationMethod(Context context, String s)
    {
        super(context, s, AuthenticationType.None);
    }

    MAPFuture getAuthenticationBundle(Uri uri, String s, Map map, byte abyte0[], CallbackFuture callbackfuture)
        throws IOException
    {
        MAPLog.w(TAG, "The AuthenticationType is not supported, so using DefaultAuthenticationMethod but doing nothing.");
        if (callbackfuture != null)
        {
            callbackError(callbackfuture, 5, "Probably you are passing non-exist authentication type. Please check AuthenticationType");
        }
        return callbackfuture;
    }

}
