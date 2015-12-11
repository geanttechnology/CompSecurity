// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.e;

import com.j.a.d.ag;
import com.j.a.d.e;
import org.json.JSONObject;

// Referenced classes of package com.j.a.e:
//            l

class m
    implements Runnable
{

    final JSONObject a;
    final String b;
    final String c;
    final l d;

    m(l l, JSONObject jsonobject, String s, String s1)
    {
        d = l;
        a = jsonobject;
        b = s;
        c = s1;
        super();
    }

    public void run()
    {
        e.e().a(a.optString("experiment_id"), a.optString("variation_id"), b, c);
        ag.c().a(true);
        ag.c().f();
    }
}
