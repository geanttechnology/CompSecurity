// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.AuthenticatedURLConnection;
import com.amazon.identity.auth.device.api.AuthenticationAwareHttpClient;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.utils.KeyInfo;

// Referenced classes of package com.amazon.identity.auth.device.token:
//            TokenManagementLogic, TokenCallbackHelpers

class val.tracer
    implements Runnable
{

    final TokenManagementLogic this$0;
    final Callback val$callback;
    final String val$directedId;
    final Bundle val$options;
    final String val$token;
    final Tracer val$tracer;

    public void run()
    {
        KeyInfo keyinfo = KeyInfo.parseKey(val$token);
        if (TokenManagementLogic.access$000$21e8abb6(keyinfo))
        {
            if (TokenManagementLogic.access$100(TokenManagementLogic.this, keyinfo, val$options))
            {
                TokenCallbackHelpers.onAccountManagerError(val$callback, 7, String.format("Apps using the central device type are not permitted to retrieve the central ADP token. Please use %s or %s instead to authenticate a request with ADP.", new Object[] {
                    com/amazon/identity/auth/device/api/AuthenticatedURLConnection.getName(), com/amazon/identity/auth/device/api/AuthenticationAwareHttpClient.getName()
                }));
                return;
            } else
            {
                TokenManagementLogic.access$200(TokenManagementLogic.this, val$directedId, keyinfo, val$tracer);
                TokenManagementLogic.access$300(TokenManagementLogic.this, val$directedId, keyinfo, val$callback);
                return;
            }
        }
        if (TokenManagementLogic.access$400$21e8abb6(keyinfo))
        {
            TokenManagementLogic.access$500(TokenManagementLogic.this, val$directedId, keyinfo, val$options, val$callback, val$tracer);
            return;
        }
        if (TokenManagementLogic.access$600$21e8abb6(keyinfo))
        {
            TokenManagementLogic.access$700(TokenManagementLogic.this, val$directedId, keyinfo, val$callback);
            return;
        } else
        {
            TokenManagementLogic.access$800(TokenManagementLogic.this, val$directedId, val$token, val$callback, keyinfo);
            return;
        }
    }

    ient()
    {
        this$0 = final_tokenmanagementlogic;
        val$token = s;
        val$options = bundle;
        val$callback = callback1;
        val$directedId = s1;
        val$tracer = Tracer.this;
        super();
    }
}
