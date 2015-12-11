// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            do, cd

final class cv
{

    do a;
    int b;
    int c;

    public cv()
    {
        a = new do(0, 0);
        b = 0;
        c = 0;
    }

    public cv(do do1, int i, int j)
    {
        a = do1;
        b = i;
        c = j;
    }

    public final JSONObject a()
    {
        JSONObject jsonobject = a.a();
        cd.b(jsonobject, "x", b);
        cd.b(jsonobject, "y", c);
        return jsonobject;
    }
}
