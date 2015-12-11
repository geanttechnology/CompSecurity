// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.search;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.b.ds;
import com.google.android.gms.b.dt;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.internal.h;

// Referenced classes of package com.google.android.gms.search:
//            b

public class a
{

    public static final com.google.android.gms.common.api.b.c a;
    public static final b b;
    public static final com.google.android.gms.search.b c = new dt();
    private static final com.google.android.gms.common.api.b.d d;

    static 
    {
        d = new com.google.android.gms.common.api.b.d() {

            public int a()
            {
                return 0x7fffffff;
            }

            public ds a(Context context, Looper looper, h h, com.google.android.gms.common.api.b.a.b b1, com.google.android.gms.common.api.d.b b2, com.google.android.gms.common.api.d.d d1)
            {
                return new ds(context, b2, d1, h);
            }

            public com.google.android.gms.common.api.b.b a(Context context, Looper looper, h h, Object obj, com.google.android.gms.common.api.d.b b1, com.google.android.gms.common.api.d.d d1)
            {
                return a(context, looper, h, (com.google.android.gms.common.api.b.a.b)obj, b1, d1);
            }

        };
        a = new com.google.android.gms.common.api.b.c();
        b = new b("SearchAuth.API", d, a, new Scope[0]);
    }
}
