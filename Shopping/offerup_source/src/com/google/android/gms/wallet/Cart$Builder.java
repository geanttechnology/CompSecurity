// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.wallet:
//            Cart, LineItem

public final class <init>
{

    final Cart zzbcl;

    public final <init> addLineItem(LineItem lineitem)
    {
        zzbcl.zzbck.add(lineitem);
        return this;
    }

    public final Cart build()
    {
        return zzbcl;
    }

    public final zzbcl setCurrencyCode(String s)
    {
        zzbcl.zzbcj = s;
        return this;
    }

    public final zzbcl setLineItems(List list)
    {
        zzbcl.zzbck.clear();
        zzbcl.zzbck.addAll(list);
        return this;
    }

    public final zzbcl setTotalPrice(String s)
    {
        zzbcl.zzbci = s;
        return this;
    }

    private (Cart cart)
    {
        zzbcl = cart;
        super();
    }

    zzbcl(Cart cart, zzbcl zzbcl1)
    {
        this(cart);
    }
}
