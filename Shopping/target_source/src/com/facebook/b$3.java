// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import org.json.JSONObject;

// Referenced classes of package com.facebook:
//            b, n

class <init>
    implements hRequest.b
{

    final ct.optInt a;
    final b b;

    public void a(n n1)
    {
        n1 = n1.b();
        if (n1 == null)
        {
            return;
        } else
        {
            a.a = n1.optString("access_token");
            a.b = n1.optInt("expires_at");
            return;
        }
    }

    ct(b b1, ct ct)
    {
        b = b1;
        a = ct;
        super();
    }
}
