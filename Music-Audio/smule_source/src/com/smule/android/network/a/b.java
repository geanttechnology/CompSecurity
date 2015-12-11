// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.a;

import com.smule.android.network.core.k;
import com.smule.android.network.core.l;
import com.smule.android.network.core.m;
import com.smule.android.network.core.n;
import com.smule.android.network.core.o;
import java.util.HashMap;

public class b
{

    private static final String a = com/smule/android/network/a/b.getName();

    public b()
    {
    }

    public static o a()
    {
        k k1 = new k(m.a, "/v2/store/balance", l.b, n.c, null, true);
        k1.d = new HashMap();
        return com.smule.android.network.core.b.a().a(k1);
    }

}
