// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            cd

final class do
{

    int a;
    int b;

    public do(int i, int j)
    {
        a = i;
        b = j;
    }

    public do(String s)
    {
        int i;
        i = 0;
        super();
        if (s == null) goto _L2; else goto _L1
_L1:
        s = s.split("x");
        if (s == null || s.length != 2) goto _L2; else goto _L3
_L3:
        int j;
        j = Math.max(a(s[0]), 0);
        i = Math.max(a(s[1]), 0);
_L5:
        a = j;
        b = i;
        return;
_L2:
        j = 0;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private static int a(String s)
    {
        int i;
        try
        {
            i = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return 0;
        }
        return i;
    }

    public final JSONObject a()
    {
        JSONObject jsonobject = new JSONObject();
        cd.b(jsonobject, "width", a);
        cd.b(jsonobject, "height", b);
        return jsonobject;
    }

    public final String toString()
    {
        return (new StringBuilder()).append(a).append("x").append(b).toString();
    }
}
