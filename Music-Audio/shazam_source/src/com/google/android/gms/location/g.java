// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.location.internal.c;
import com.google.android.gms.location.internal.d;
import com.google.android.gms.location.internal.i;
import com.google.android.gms.location.internal.n;

// Referenced classes of package com.google.android.gms.location:
//            c, d, h

public final class g
{

    public static final a a;
    public static final com.google.android.gms.location.c b = new c();
    public static final com.google.android.gms.location.d c = new d();
    public static final com.google.android.gms.location.h d = new n();
    private static final com.google.android.gms.common.api.a.c e;
    private static final com.google.android.gms.common.api.a.a f;

    public static i a(com.google.android.gms.common.api.c c1)
    {
        boolean flag1 = true;
        boolean flag;
        if (c1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        w.b(flag, "GoogleApiClient parameter is required.");
        c1 = (i)c1.a(e);
        if (c1 != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        w.a(flag, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return c1;
    }

    static 
    {
        e = new com.google.android.gms.common.api.a.c();
        f = new com.google.android.gms.common.api.a.a() {

            public final com.google.android.gms.common.api.a.b a(Context context, Looper looper, h h, Object obj, com.google.android.gms.common.api.c.b b1, com.google.android.gms.common.api.c.c c1)
            {
                return new i(context, looper, b1, c1, "locationServices", h);
            }

        };
        a = new a("LocationServices.API", f, e);
    }
}
