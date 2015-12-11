// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.d;

import com.j.a.e.j;
import com.j.a.g.w;
import org.json.JSONObject;

// Referenced classes of package com.j.a.d:
//            ag

class v
    implements j
{

    final ag a;

    v(ag ag)
    {
        a = ag;
        super();
    }

    public void a(Exception exception)
    {
        w.b("Posting Found Activity", exception);
    }

    public void a(JSONObject jsonobject)
    {
        w.a("Posted Found Activity");
    }
}
