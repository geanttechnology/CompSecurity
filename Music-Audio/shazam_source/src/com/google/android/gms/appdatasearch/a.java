// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.d.hv;
import com.google.android.gms.d.hw;

// Referenced classes of package com.google.android.gms.appdatasearch:
//            k

public final class a
{

    public static final com.google.android.gms.common.api.c a;
    public static final com.google.android.gms.common.api.a b;
    public static final k c = new hw();
    private static final com.google.android.gms.common.api.a d;

    static 
    {
        a = new com.google.android.gms.common.api.c();
        d = new com.google.android.gms.common.api.a() {

            public final com.google.android.gms.common.api.b a(Context context, Looper looper, h h, Object obj, com.google.android.gms.common.api.c.b b1, com.google.android.gms.common.api.c.c c1)
            {
                return new hv(context, looper, h, b1, c1);
            }

        };
        b = new com.google.android.gms.common.api.a("AppDataSearch.LIGHTWEIGHT_API", d, a);
    }
}
