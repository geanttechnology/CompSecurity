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
import java.util.List;
import java.util.Map;

public class a
{

    static final String a = com/smule/android/network/a/a.getName();
    protected static a b = null;

    private a()
    {
    }

    public static a a()
    {
        if (b == null)
        {
            b = new a();
        }
        return b;
    }

    public o a(List list)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("settingsIds", list);
        list = new k(m.a, "/v2/settings", l.b, n.c, hashmap, true);
        list.i = true;
        return com.smule.android.network.core.b.a().a(list);
    }

}
