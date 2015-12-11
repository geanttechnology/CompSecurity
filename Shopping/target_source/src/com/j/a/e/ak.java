// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.e;

import com.j.a.d.e;
import org.json.JSONObject;

// Referenced classes of package com.j.a.e:
//            aj

class ak
    implements Runnable
{

    final JSONObject a;
    final JSONObject b;
    final aj c;

    ak(aj aj, JSONObject jsonobject, JSONObject jsonobject1)
    {
        c = aj;
        a = jsonobject;
        b = jsonobject1;
        super();
    }

    public void run()
    {
        e.e().a(a.optString("experiment_id"), b.optString("name"));
    }
}
