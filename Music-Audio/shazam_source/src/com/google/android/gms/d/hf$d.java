// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.d:
//            ce, hf, he

private final class <init>
    implements ce
{

    final hf a;

    public final void a(he he, Map map)
    {
        if (map.keySet().contains("start"))
        {
            hf.a(a);
        } else
        {
            if (map.keySet().contains("stop"))
            {
                hf.b(a);
                return;
            }
            if (map.keySet().contains("cancel"))
            {
                hf.c(a);
                return;
            }
        }
    }

    private (hf hf1)
    {
        a = hf1;
        super();
    }

    a(hf hf1, byte byte0)
    {
        this(hf1);
    }
}
