// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.TokenKeys;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.utils.KeyInfo;

// Referenced classes of package com.amazon.identity.auth.device.token:
//            TokenManagementLogic

class val.tracer
    implements Runnable
{

    final TokenManagementLogic this$0;
    final String val$directedId;
    final KeyInfo val$keyInfo;
    final Tracer val$tracer;

    public void run()
    {
        getToken(val$directedId, TokenKeys.getAccessTokenKeyForPackage(val$keyInfo.getPackageName()), new Bundle(), TokenManagementLogic.access$1000(TokenManagementLogic.this), val$tracer);
    }

    ()
    {
        this$0 = final_tokenmanagementlogic;
        val$directedId = s;
        val$keyInfo = keyinfo;
        val$tracer = Tracer.this;
        super();
    }
}
