// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.a;

import com.cyberlink.youcammakeup.utility.ad;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.database.a:
//            a

public class b
{

    final a a;
    private String b;
    private int c;
    private String d;

    public b(a a1, JSONObject jsonobject)
    {
        a = a1;
        super();
        b = jsonobject.optString("adUnitID");
        c = ad.b(jsonobject, "rotationPeriod");
        d = jsonobject.optString("adUnitVersion");
    }

    public String a()
    {
        return b;
    }
}
