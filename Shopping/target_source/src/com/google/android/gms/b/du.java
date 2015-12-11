// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.b;
import com.google.android.gms.signin.internal.g;
import com.google.android.gms.signin.internal.h;
import java.util.concurrent.Executors;

// Referenced classes of package com.google.android.gms.b:
//            dv, dx

public final class du
{

    public static final com.google.android.gms.common.api.b.c a;
    public static final com.google.android.gms.common.api.b.c b;
    public static final com.google.android.gms.common.api.b.d c;
    static final com.google.android.gms.common.api.b.d d;
    public static final b e;
    public static final b f;
    public static final dv g = new g();

    static 
    {
        a = new com.google.android.gms.common.api.b.c();
        b = new com.google.android.gms.common.api.b.c();
        c = new com.google.android.gms.common.api.b.d() {

            public int a()
            {
                return 0x7fffffff;
            }

            public volatile com.google.android.gms.common.api.b.b a(Context context, Looper looper, com.google.android.gms.common.internal.h h1, Object obj, com.google.android.gms.common.api.d.b b1, com.google.android.gms.common.api.d.d d1)
            {
                return a(context, looper, h1, (dx)obj, b1, d1);
            }

            public h a(Context context, Looper looper, com.google.android.gms.common.internal.h h1, dx dx1, com.google.android.gms.common.api.d.b b1, com.google.android.gms.common.api.d.d d1)
            {
                if (dx1 == null)
                {
                    dx1 = dx.a;
                }
                return new h(context, looper, true, h1, dx1, b1, d1, Executors.newSingleThreadExecutor());
            }

        };
        d = new com.google.android.gms.common.api.b.d() {

            public int a()
            {
                return 0x7fffffff;
            }

            public com.google.android.gms.common.api.b.b a(Context context, Looper looper, com.google.android.gms.common.internal.h h1, Object obj, com.google.android.gms.common.api.d.b b1, com.google.android.gms.common.api.d.d d1)
            {
                return a(context, looper, h1, (com.google.android.gms.common.api.b.a.b)obj, b1, d1);
            }

            public h a(Context context, Looper looper, com.google.android.gms.common.internal.h h1, com.google.android.gms.common.api.b.a.b b1, com.google.android.gms.common.api.d.b b2, com.google.android.gms.common.api.d.d d1)
            {
                return new h(context, looper, false, h1, dx.a, b2, d1, Executors.newSingleThreadExecutor());
            }

        };
        e = new b("SignIn.API", c, a, new Scope[0]);
        f = new b("SignIn.INTERNAL_API", d, b, new Scope[0]);
    }
}
