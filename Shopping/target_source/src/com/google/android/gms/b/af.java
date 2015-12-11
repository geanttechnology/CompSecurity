// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import com.google.android.gms.ads.internal.util.client.b;
import java.util.Map;

// Referenced classes of package com.google.android.gms.b:
//            ai, ag, cj

public final class af
    implements ai
{

    private final ag a;

    public af(ag ag1)
    {
        a = ag1;
    }

    public void a(cj cj, Map map)
    {
        cj = (String)map.get("name");
        if (cj == null)
        {
            b.e("App event with no name parameter.");
            return;
        } else
        {
            a.a(cj, (String)map.get("info"));
            return;
        }
    }
}
