// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.a;

import com.j.a.g.ad;
import com.j.a.g.w;
import org.json.JSONObject;

// Referenced classes of package com.j.a.a:
//            b

class c
    implements ad
{

    final b a;

    c(b b1)
    {
        a = b1;
        super();
    }

    public void a(JSONObject jsonobject, Exception exception)
    {
        if (exception != null)
        {
            w.b("Reading User Attributes from disk", exception);
        } else
        if (jsonobject != null)
        {
            b.a(a, jsonobject);
            b.a(a, null);
            return;
        }
    }
}
