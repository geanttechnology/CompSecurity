// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.c;

// Referenced classes of package com.tencent.mm.sdk.openapi:
//            a

public class h extends a
{

    public String b;
    public String c;

    public h()
    {
    }

    public int a()
    {
        return 1;
    }

    public void a(Bundle bundle)
    {
        super.a(bundle);
        bundle.putString("_wxapi_sendauth_req_scope", b);
        bundle.putString("_wxapi_sendauth_req_state", c);
    }

    public void b(Bundle bundle)
    {
        super.b(bundle);
        b = bundle.getString("_wxapi_sendauth_req_scope");
        c = bundle.getString("_wxapi_sendauth_req_state");
    }

    final boolean b()
    {
        if (b == null || b.length() == 0 || b.length() > 1024)
        {
            com.tencent.mm.sdk.platformtools.c.a("MicroMsg.SDK.SendAuth.Req", "checkArgs fail, scope is invalid");
            return false;
        }
        if (c != null && c.length() > 1024)
        {
            com.tencent.mm.sdk.platformtools.c.a("MicroMsg.SDK.SendAuth.Req", "checkArgs fail, state is invalid");
            return false;
        } else
        {
            return true;
        }
    }
}
