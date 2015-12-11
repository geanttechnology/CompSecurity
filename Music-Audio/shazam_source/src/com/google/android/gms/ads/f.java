// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.a;
import com.google.android.gms.ads.internal.client.ab;

// Referenced classes of package com.google.android.gms.ads:
//            c, a

public final class f
{

    public final ab a;

    public f(Context context)
    {
        a = new ab(context);
    }

    public final void a(com.google.android.gms.ads.a a1)
    {
        a.a(a1);
        if (a1 != null && (a1 instanceof a))
        {
            a.a((a)a1);
        } else
        if (a1 == null)
        {
            a.a(null);
            return;
        }
    }

    public final void a(c c1)
    {
        a.a(c1.b);
    }

    public final void a(String s)
    {
        a.a(s);
    }

    public final boolean a()
    {
        return a.a();
    }

    public final void b()
    {
        a.b();
    }
}
