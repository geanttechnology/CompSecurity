// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.io.InputStream;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            co, cn, cd, dq

class dc
{

    private static final String a = com/amazon/device/ads/dc.getSimpleName();
    private final cn b;
    private final InputStream c;
    private boolean d;

    dc(InputStream inputstream)
    {
        new co();
        b = co.a(a);
        d = false;
        c = inputstream;
    }

    public void a(String s)
    {
        if (s == null)
        {
            b.g(a);
            return;
        } else
        {
            b.g((new StringBuilder()).append(a).append(" ").append(s).toString());
            return;
        }
    }

    public void a(boolean flag)
    {
        d = flag;
    }

    public JSONObject b()
    {
        return cd.a(c());
    }

    public String c()
    {
        String s = dq.a(c);
        if (d)
        {
            b.b("Response Body: %s", new Object[] {
                s
            });
        }
        return s;
    }

    public InputStream d()
    {
        return c;
    }

}
