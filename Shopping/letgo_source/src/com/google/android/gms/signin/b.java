// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.signin;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.signin.internal.h;
import com.google.android.gms.signin.internal.i;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

// Referenced classes of package com.google.android.gms.signin:
//            c, e

public final class b
{

    public static final com.google.android.gms.common.api.a.d a;
    public static final com.google.android.gms.common.api.a.d b;
    public static final com.google.android.gms.common.api.a.b c;
    static final com.google.android.gms.common.api.a.b d;
    public static final Scope e = new Scope("profile");
    public static final Scope f = new Scope("email");
    public static final a g;
    public static final a h;
    public static final c i = new h();

    static 
    {
        a = new com.google.android.gms.common.api.a.d();
        b = new com.google.android.gms.common.api.a.d();
        c = new com.google.android.gms.common.api.a.b() {

            public volatile com.google.android.gms.common.api.a.c a(Context context, Looper looper, com.google.android.gms.common.internal.h h1, Object obj, com.google.android.gms.common.api.c.b b1, com.google.android.gms.common.api.c.c c1)
            {
                return a(context, looper, h1, (e)obj, b1, c1);
            }

            public i a(Context context, Looper looper, com.google.android.gms.common.internal.h h1, e e1, com.google.android.gms.common.api.c.b b1, com.google.android.gms.common.api.c.c c1)
            {
                return new i(context, looper, true, h1, e1, b1, c1, Executors.newSingleThreadExecutor());
            }

            public List a(e e1)
            {
                return Arrays.asList(new Scope[] {
                    b.e, b.f
                });
            }

            public List a(Object obj)
            {
                return a((e)obj);
            }

        };
        d = new com.google.android.gms.common.api.a.b() {

            public com.google.android.gms.common.api.a.c a(Context context, Looper looper, com.google.android.gms.common.internal.h h1, Object obj, com.google.android.gms.common.api.c.b b1, com.google.android.gms.common.api.c.c c1)
            {
                return a(context, looper, h1, (com.google.android.gms.common.api.a.a.b)obj, b1, c1);
            }

            public i a(Context context, Looper looper, com.google.android.gms.common.internal.h h1, com.google.android.gms.common.api.a.a.b b1, com.google.android.gms.common.api.c.b b2, com.google.android.gms.common.api.c.c c1)
            {
                return new i(context, looper, false, h1, com.google.android.gms.signin.e.a, b2, c1, Executors.newSingleThreadExecutor());
            }

        };
        g = new a("SignIn.API", c, a);
        h = new a("SignIn.INTERNAL_API", d, b);
    }
}
