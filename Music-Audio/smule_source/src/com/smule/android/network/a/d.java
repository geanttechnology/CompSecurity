// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.a;

import com.smule.android.network.core.b;
import com.smule.android.network.core.k;
import com.smule.android.network.core.l;
import com.smule.android.network.core.m;
import com.smule.android.network.core.n;
import com.smule.android.network.core.o;
import java.util.HashMap;

public class d
{

    private static final String a = com/smule/android/network/a/d.getName();

    public d()
    {
    }

    public static o a()
    {
        Object obj = new HashMap();
        obj = new k(m.a, "/v2/device/setting", l.b, n.c, ((java.util.Map) (obj)), false);
        obj.i = true;
        return b.a().a(((k) (obj)));
    }

}
