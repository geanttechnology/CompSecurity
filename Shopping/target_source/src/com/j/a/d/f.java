// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.d;

import android.util.Log;
import com.j.a.c.b;
import com.j.a.e.j;
import com.j.a.g.w;
import org.json.JSONObject;

// Referenced classes of package com.j.a.d:
//            e

class f
    implements j
{

    final e a;

    f(e e1)
    {
        a = e1;
        super();
    }

    public void a(Exception exception)
    {
        w.b("git tag error", exception);
    }

    public void a(JSONObject jsonobject)
    {
        w.a((new StringBuilder()).append("Got tag response: ").append(jsonobject).toString());
        if (jsonobject != null && jsonobject != JSONObject.NULL && jsonobject.length() > 0 && jsonobject.has("tag_name"))
        {
            e.a(a, e.a(a, new b(jsonobject.optString("tag_name"))));
            if (e.d(a))
            {
                Log.d(w.b(), "A Taplytics SDK update is available. Please update to ensure best functionality");
            }
        }
    }
}
