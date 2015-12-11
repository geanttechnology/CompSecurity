// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import com.google.android.gms.ads.internal.util.client.b;
import java.util.Map;

// Referenced classes of package com.google.android.gms.d:
//            ce, cb, he

public final class ca
    implements ce
{

    private final cb a;

    public ca(cb cb1)
    {
        a = cb1;
    }

    public final void a(he he, Map map)
    {
        he = (String)map.get("name");
        if (he == null)
        {
            b.a(5);
            return;
        } else
        {
            a.a(he, (String)map.get("info"));
            return;
        }
    }
}
