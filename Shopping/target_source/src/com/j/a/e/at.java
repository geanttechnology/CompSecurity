// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.e;

import org.json.JSONArray;

// Referenced classes of package com.j.a.e:
//            j, a

class at
    implements com.a.a.o.b
{

    final j a;
    final a b;

    at(a a1, j j1)
    {
        b = a1;
        a = j1;
        super();
    }

    public void a(JSONArray jsonarray)
    {
        jsonarray = jsonarray.optJSONObject(0);
        a.a(jsonarray);
    }

    public void onResponse(Object obj)
    {
        a((JSONArray)obj);
    }
}
