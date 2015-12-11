// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.wallet:
//            Cart

public final class <init>
{

    final Cart zzaQi;

    public Cart build()
    {
        return zzaQi;
    }

    public zzaQi setCurrencyCode(String s)
    {
        zzaQi.zzaQg = s;
        return this;
    }

    public zzaQi setLineItems(List list)
    {
        zzaQi.zzaQh.clear();
        zzaQi.zzaQh.addAll(list);
        return this;
    }

    public zzaQi setTotalPrice(String s)
    {
        zzaQi.zzaQf = s;
        return this;
    }

    private (Cart cart)
    {
        zzaQi = cart;
        super();
    }

    zzaQi(Cart cart, zzaQi zzaqi)
    {
        this(cart);
    }
}
