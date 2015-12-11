// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.d;

import com.j.a.e.j;
import com.j.a.g.w;
import org.json.JSONObject;

// Referenced classes of package com.j.a.d:
//            j

class k
    implements j
{

    final com.j.a.d.j a;

    k(com.j.a.d.j j1)
    {
        a = j1;
        super();
    }

    public void a(Exception exception)
    {
        w.b("Getting Properties From Server", exception);
    }

    public void a(JSONObject jsonobject)
    {
        w.a("Got Properties Response!");
    }
}
