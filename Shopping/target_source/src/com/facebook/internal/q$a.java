// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.f;

// Referenced classes of package com.facebook.internal:
//            q, o, p

public static class a
{

    private Context a;
    private String b;
    private String c;
    private int d;
    private e e;
    private Bundle f;
    private AccessToken g;

    private void a(Context context, String s, Bundle bundle)
    {
        a = context;
        c = s;
        if (bundle != null)
        {
            f = bundle;
            return;
        } else
        {
            f = new Bundle();
            return;
        }
    }

    public f a(int i)
    {
        d = i;
        return this;
    }

    public d a(d d1)
    {
        e = d1;
        return this;
    }

    public q a()
    {
        if (g != null)
        {
            f.putString("app_id", g.h());
            f.putString("access_token", g.b());
        } else
        {
            f.putString("app_id", b);
        }
        return new q(a, c, f, d, e);
    }

    public String b()
    {
        return b;
    }

    public Context c()
    {
        return a;
    }

    public int d()
    {
        return d;
    }

    public Bundle e()
    {
        return f;
    }

    public f f()
    {
        return e;
    }

    public (Context context, String s, Bundle bundle)
    {
label0:
        {
            super();
            d = 0x1030010;
            g = AccessToken.a();
            if (g == null)
            {
                String s1 = o.a(context);
                if (s1 == null)
                {
                    break label0;
                }
                b = s1;
            }
            a(context, s, bundle);
            return;
        }
        throw new f("Attempted to create a builder without a valid access token or a valid default Application ID.");
    }

    public a(Context context, String s, String s1, Bundle bundle)
    {
        d = 0x1030010;
        String s2 = s;
        if (s == null)
        {
            s2 = o.a(context);
        }
        p.a(s2, "applicationId");
        b = s2;
        a(context, s1, bundle);
    }
}
