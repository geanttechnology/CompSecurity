// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics;

import com.h.b.q;
import com.target.mothership.services.j;
import com.target.ui.analytics.c.a;

// Referenced classes of package com.target.ui.analytics:
//            e, b

public class c
{

    public static final String TAG = com/target/ui/analytics/c.getSimpleName();
    private static b sControllerInstance;

    public c()
    {
    }

    public static j a(com.target.mothership.services.f.b.a a1)
    {
        return com.target.ui.analytics.e.a(new com.target.ui.analytics.d.c(a1));
    }

    public static b a()
    {
        return sControllerInstance;
    }

    public static void a(com.target.a.a.a a1)
    {
        sControllerInstance = new a(a1);
    }

    public static q b()
    {
        return com.target.ui.analytics.d.a.a();
    }

}
