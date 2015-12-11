// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia.a;

import java.util.ArrayList;
import java.util.Map;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia.a:
//            c, g

public class b
    implements Runnable
{

    Map a;
    c b;
    final c c;

    public void run()
    {
        g g1 = new g(b);
        com.tremorvideo.sdk.android.richmedia.a.c.a(c).add(g1);
        if (a.containsKey("data"))
        {
            g1.execute(new String[] {
                (String)a.get("url"), (String)a.get("type"), (String)a.get("header"), (String)a.get("data")
            });
            return;
        } else
        {
            g1.execute(new String[] {
                (String)a.get("url"), (String)a.get("type"), (String)a.get("header")
            });
            return;
        }
    }

    public (c c1, Map map, c c2)
    {
        c = c1;
        super();
        a = map;
        b = c2;
    }
}
