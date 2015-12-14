// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.openapi;

import android.os.Bundle;

// Referenced classes of package com.tencent.mm.sdk.openapi:
//            b

public class i extends b
{

    public String d;
    public String e;
    public int f;
    public String g;

    public i()
    {
    }

    public i(Bundle bundle)
    {
        a(bundle);
    }

    public void a(Bundle bundle)
    {
        super.a(bundle);
        d = bundle.getString("_wxapi_sendauth_resp_userName");
        e = bundle.getString("_wxapi_sendauth_resp_token");
        f = bundle.getInt("_wxapi_sendauth_resp_expireDate", 0);
        g = bundle.getString("_wxapi_sendauth_resp_state");
    }
}
