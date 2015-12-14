// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.b;

import android.os.SystemClock;
import com.tencent.open.utils.m;
import com.tencent.tauth.b;
import com.tencent.tauth.d;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.connect.b:
//            e

class g
    implements b
{

    String a;
    String b;
    final e c;
    private String d;
    private b e;

    public g(e e1, String s, String s1, String s2, b b1)
    {
        c = e1;
        super();
        d = s;
        a = s1;
        b = s2;
        e = b1;
    }

    static void a(g g1, String s)
    {
        g1.a(s);
    }

    private void a(String s)
    {
        try
        {
            a(m.d(s));
            return;
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
        }
        a(new d(-4, "\u670D\u52A1\u5668\u8FD4\u56DE\u6570\u636E\u683C\u5F0F\u6709\u8BEF!", s));
    }

    public void a()
    {
        if (e != null)
        {
            e.a();
            e = null;
        }
    }

    public void a(d d1)
    {
        String s;
        if (d1.b != null)
        {
            s = (new StringBuilder()).append(d1.b).append(a).toString();
        } else
        {
            s = a;
        }
        com.tencent.open.b.g.a().a((new StringBuilder()).append(d).append("_H5").toString(), SystemClock.elapsedRealtime(), 0L, 0L, d1.a, s, false);
        com.tencent.connect.b.e.a(c, s);
        if (e != null)
        {
            e.a(d1);
            e = null;
        }
    }

    public void a(Object obj)
    {
        obj = (JSONObject)obj;
        com.tencent.open.b.g.a().a((new StringBuilder()).append(d).append("_H5").toString(), SystemClock.elapsedRealtime(), 0L, 0L, ((JSONObject) (obj)).optInt("ret", -6), a, false);
        if (e != null)
        {
            e.a(obj);
            e = null;
        }
    }
}
