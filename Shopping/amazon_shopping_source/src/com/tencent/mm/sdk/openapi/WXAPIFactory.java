// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.openapi;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.Log;

// Referenced classes of package com.tencent.mm.sdk.openapi:
//            WXApiImplV10, IWXAPI

public class WXAPIFactory
{

    private WXAPIFactory()
    {
        throw new RuntimeException((new StringBuilder()).append(getClass().getSimpleName()).append(" should not be instantiated").toString());
    }

    public static IWXAPI createWXAPI(Context context, String s, boolean flag)
    {
        Log.d("MicroMsg.PaySdk.WXFactory", (new StringBuilder()).append("createWXAPI, appId = ").append(s).append(", checkSignature = ").append(flag).toString());
        return new WXApiImplV10(context, s, flag);
    }
}
