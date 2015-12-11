// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.request;

import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.d.ce;
import com.google.android.gms.d.cj;
import com.google.android.gms.d.he;
import java.util.Map;

// Referenced classes of package com.google.android.gms.ads.internal.request:
//            m

public static final class b
    implements ce
{

    public final void a(he he, Map map)
    {
        he = (String)map.get("request_id");
        map.get("errors");
        b.a(5);
        m.c().a(he);
    }

    public b()
    {
    }
}
