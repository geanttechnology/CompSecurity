// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.utils;

import android.os.Bundle;

// Referenced classes of package com.tencent.open.utils:
//            g, HttpUtils, n, m

class a extends Thread
{

    final Bundle a;
    final g b;

    public void run()
    {
        try
        {
            org.json.JSONObject jsonobject = m.d(HttpUtils.a(g.a(b), "http://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", "GET", a).a);
            g.a(b, jsonobject);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        g.a(b, 0);
    }

    Utils(g g1, Bundle bundle)
    {
        b = g1;
        a = bundle;
        super();
    }
}
