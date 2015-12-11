// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.data;

import android.content.Context;
import org.json.JSONObject;

// Referenced classes of package cn.jpush.android.data:
//            d, b

public final class a extends d
{

    public JSONObject a;

    public a()
    {
    }

    public static d a(a a1)
    {
        b b1 = new b();
        b1.n = a1.n;
        b1.m = a1.m;
        b1.i = a1.i;
        b1.j = a1.j;
        b1.k = a1.k;
        b1.l = a1.l;
        b1.c = a1.c;
        b1.d = a1.d;
        b1.T = a1.T;
        b1.V = a1.V;
        b1.a(a1.f());
        return b1;
    }

    public final void a(Context context)
    {
    }

    protected final boolean a(Context context, JSONObject jsonobject)
    {
        return false;
    }
}
