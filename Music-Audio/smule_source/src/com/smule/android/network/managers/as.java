// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import android.app.Activity;
import com.smule.android.c.aa;
import com.smule.android.d.c;
import com.smule.android.d.f;
import com.smule.android.d.g;
import com.smule.android.f.r;
import com.smule.android.f.s;

// Referenced classes of package com.smule.android.network.managers:
//            ar

class as
    implements c
{

    private g a;
    private Activity b;

    public as(Activity activity)
    {
        a = new g();
        b = activity;
    }

    public void a()
    {
        if (a != null)
        {
            a.a(b, this);
        }
    }

    public void a(f f1)
    {
    }

    public void a(f f1, String s1)
    {
    }

    public void a(boolean flag)
    {
        if (flag && a != null)
        {
            a.b();
        }
    }

    public void a(boolean flag, String s1)
    {
    }

    public void b(f f1)
    {
        aa.a(ar.a, (new StringBuilder()).append("doRestorePurchases returned with responseCode: ").append(f1.name()).toString());
        if (f1 == f.a)
        {
            ar.a(Boolean.valueOf(false), b);
        } else
        {
            aa.b(ar.a, "Error requesting purchase restore, will try again later!");
            r.a(b, ar.a("subscription_purchase_error"), s.a);
        }
        if (a != null)
        {
            a.c();
            a = null;
        }
    }
}
