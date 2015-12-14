// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.openapi;

import android.content.Context;

// Referenced classes of package com.tencent.mm.sdk.openapi:
//            WXApiImplV10, IWXAPI

public class WXAPIFactory
{

    private static WXAPIFactory Q = null;

    private WXAPIFactory()
    {
    }

    public static IWXAPI createWXAPI(Context context, String s)
    {
        if (Q == null)
        {
            Q = new WXAPIFactory();
        }
        return new WXApiImplV10(context, s);
    }

    public static IWXAPI createWXAPI(Context context, String s, boolean flag)
    {
        if (Q == null)
        {
            Q = new WXAPIFactory();
        }
        return new WXApiImplV10(context, s, flag);
    }

}
