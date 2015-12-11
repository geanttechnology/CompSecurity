// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.e;

import com.j.a.d.ag;
import org.json.JSONObject;

// Referenced classes of package com.j.a.e:
//            am

class an
    implements Runnable
{

    final JSONObject a;
    final am b;

    an(am am, JSONObject jsonobject)
    {
        b = am;
        a = jsonobject;
        super();
    }

    public void run()
    {
        ag.c().a(a);
    }
}
