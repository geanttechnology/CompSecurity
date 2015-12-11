// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.cn;
import com.paypal.android.sdk.dd;
import com.paypal.android.sdk.dz;
import com.paypal.android.sdk.ea;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.paypal.android.sdk.payments:
//            bj

abstract class bw
{

    private bj a;

    protected bw(bj bj1)
    {
        a = bj1;
    }

    private String a(ea ea1, boolean flag)
    {
        String s = (new StringBuilder()).append(dz.b).append(":").append(a()).append(":").append(ea1.a()).toString();
        ea1 = s;
        if (flag)
        {
            ea1 = (new StringBuilder()).append(s).append("|error").toString();
        }
        return ea1;
    }

    protected abstract String a();

    public final void a(ea ea1, boolean flag, String s, String s1, String s2)
    {
        cn.a();
        String s4 = Locale.getDefault().toString();
        HashMap hashmap = new HashMap();
        String s3;
        boolean flag1;
        if (!dd.a(s))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        hashmap.put("gn", a(ea1, flag1));
        hashmap.put("v31", a(ea1, flag1));
        s3 = (new StringBuilder()).append(a(ea1, flag1)).append(":").append(ea1.a(a.d(), flag)).toString();
        if (flag1)
        {
            s3 = (new StringBuilder()).append(s3).append("|error").toString();
        }
        hashmap.put("c25", s3);
        hashmap.put("v25", "D=c25");
        hashmap.put("c37", (new StringBuilder()).append(dz.a).append("::").toString());
        hashmap.put("c50", s4);
        hashmap.put("c35", "out");
        a(((Map) (hashmap)), ea1, s1, s2);
        if (s != null)
        {
            hashmap.put("c29", s);
        }
        a("2.11.1", ((Map) (hashmap)));
    }

    abstract void a(String s, Map map);

    protected void a(Map map, ea ea1, String s, String s1)
    {
    }

    protected final bj b()
    {
        return a;
    }
}
