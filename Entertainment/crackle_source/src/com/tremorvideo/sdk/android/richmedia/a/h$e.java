// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia.a;

import java.util.ArrayList;
import java.util.Map;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia.a:
//            h

public class a
    implements Runnable
{

    Map a;
    final h b;

    public void run()
    {
        a a1 = new <init>(b);
        h.c(b).add(a1);
        if (a.containsKey("data"))
        {
            a1.execute(new String[] {
                (String)a.get("url"), (String)a.get("type"), (String)a.get("header"), (String)a.get("data")
            });
            return;
        } else
        {
            a1.execute(new String[] {
                (String)a.get("url"), (String)a.get("type"), (String)a.get("header")
            });
            return;
        }
    }

    public (h h1, Map map)
    {
        b = h1;
        super();
        a = map;
    }
}
