// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.util.Log;
import org.json.JSONObject;

// Referenced classes of package com.applovin.impl.sdk:
//            p, cx, bw, AppLovinSdkImpl, 
//            cr, cq

class cy
    implements p
{

    final AppLovinSdkImpl a;
    final String b;
    final cx c;

    cy(cx cx1, AppLovinSdkImpl applovinsdkimpl, String s)
    {
        c = cx1;
        a = applovinsdkimpl;
        b = s;
        super();
    }

    public void a(int i)
    {
        boolean flag1 = true;
        boolean flag;
        if (i < 200 || i >= 500)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (i == -103)
        {
            flag1 = false;
        }
        if (flag && flag1 && cx.a(c) > 0)
        {
            long l;
            if (cx.b(c) < 0L)
            {
                l = ((Long)a.a(bw.n)).longValue();
            } else
            {
                l = cx.b(c);
            }
            Log.w(b, (new StringBuilder()).append("Unable to send request due to server failure (code ").append(i).append("). ").append(cx.a(c)).append(" attempts left, retrying in ").append((double)l / 1000D).append(" seconds...").toString());
            cx.a(c, cx.a(c) - 1);
            if (cx.a(c) == 0)
            {
                cx.c(c);
            }
            a.a().a(c, cr.b, l);
            return;
        } else
        {
            c.a(i);
            return;
        }
    }

    public void a(JSONObject jsonobject, int i)
    {
        cx.a(c, 0);
        c.a(jsonobject, i);
    }
}
