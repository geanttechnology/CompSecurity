// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.x;
import com.google.android.gms.location.internal.d;
import com.google.android.gms.location.internal.e;
import com.google.android.gms.location.internal.j;
import com.google.android.gms.location.internal.o;

// Referenced classes of package com.google.android.gms.location:
//            e, g, o

public class m
{
    public static abstract class a extends com.google.android.gms.common.api.k.a
    {

        public a(c c1)
        {
            super(com.google.android.gms.location.m.a(), c1);
        }
    }


    public static final com.google.android.gms.common.api.a a;
    public static final com.google.android.gms.location.e b = new d();
    public static final g c = new e();
    public static final com.google.android.gms.location.o d = new o();
    private static final com.google.android.gms.common.api.a.d e;
    private static final com.google.android.gms.common.api.a.b f;

    static com.google.android.gms.common.api.a.d a()
    {
        return e;
    }

    public static j a(c c1)
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
        x.b(flag, "GoogleApiClient parameter is required.");
        c1 = (j)c1.a(e);
        if (c1 != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        x.a(flag, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return c1;
    }

    static 
    {
        e = new com.google.android.gms.common.api.a.d();
        f = new com.google.android.gms.common.api.a.b() {

            public com.google.android.gms.common.api.a.c a(Context context, Looper looper, h h, Object obj, com.google.android.gms.common.api.c.b b1, com.google.android.gms.common.api.c.c c1)
            {
                return a(context, looper, h, (com.google.android.gms.common.api.a.a.b)obj, b1, c1);
            }

            public j a(Context context, Looper looper, h h, com.google.android.gms.common.api.a.a.b b1, com.google.android.gms.common.api.c.b b2, com.google.android.gms.common.api.c.c c1)
            {
                return new j(context, looper, b2, c1, "locationServices", h);
            }

        };
        a = new com.google.android.gms.common.api.a("LocationServices.API", f, e);
    }
}
