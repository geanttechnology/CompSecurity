// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;

// Referenced classes of package com.amazon.device.ads:
//            dt, du, at

class ax
    implements dt
{

    private String a;
    private String b;

    ax()
    {
    }

    public final String a()
    {
        return a;
    }

    void a(Context context)
    {
        a("");
    }

    public final void a(String s)
    {
        if (s != null && !s.equals(b))
        {
            b = s;
            a = (new StringBuilder()).append(s).append(" ").append(du.c()).toString();
        }
    }

    public final void b(Context context)
    {
label0:
        {
            if (a == null)
            {
                if (!at.a(7))
                {
                    break label0;
                }
                a(System.getProperty("http.agent"));
            }
            return;
        }
        a(context);
    }
}
