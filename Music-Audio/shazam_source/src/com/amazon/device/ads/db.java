// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            cd

final class db
{

    final JSONObject a = new JSONObject();
    final Boolean b;
    private final String c = "top-right";

    public db()
    {
        b = Boolean.TRUE;
        JSONObject jsonobject = a;
        getClass();
        cd.b(jsonobject, "customClosePosition", "top-right");
        cd.b(a, "allowOffscreen", b.booleanValue());
    }

    public final int a()
    {
        return cd.a(a, "width", 0);
    }

    public final int b()
    {
        return cd.a(a, "height", 0);
    }
}
