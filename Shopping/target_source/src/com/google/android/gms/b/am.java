// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import com.google.android.gms.ads.internal.a;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.b:
//            ai, az, ay, bb, 
//            ba, cj

public class am
    implements ai
{

    static final Map a;
    private final a b;
    private final az c;

    public am(a a1, az az1)
    {
        b = a1;
        c = az1;
    }

    public void a(cj cj, Map map)
    {
        String s = (String)map.get("a");
        int i = ((Integer)a.get(s)).intValue();
        if (i != 5 && b != null && !b.a())
        {
            b.a(null);
            return;
        }
        switch (i)
        {
        case 2: // '\002'
        default:
            com.google.android.gms.ads.internal.util.client.b.c("Unknown MRAID command called.");
            return;

        case 1: // '\001'
            c.a(map);
            return;

        case 4: // '\004'
            (new ay(cj, map)).a();
            return;

        case 3: // '\003'
            (new bb(cj, map)).a();
            return;

        case 5: // '\005'
            (new ba(cj, map)).a();
            return;

        case 6: // '\006'
            c.a(true);
            break;
        }
    }

    static 
    {
        a = new HashMap();
        a.put("resize", Integer.valueOf(1));
        a.put("playVideo", Integer.valueOf(2));
        a.put("storePicture", Integer.valueOf(3));
        a.put("createCalendarEvent", Integer.valueOf(4));
        a.put("setOrientationProperties", Integer.valueOf(5));
        a.put("closeResizedAd", Integer.valueOf(6));
    }
}
