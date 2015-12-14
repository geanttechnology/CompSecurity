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

    final Cart zzaWe;

    public <init> addLineItem(LineItem lineitem)
    {
        zzaWe.zzaWd.add(lineitem);
        return this;
    }

    public Cart build()
    {
        return zzaWe;
    }

    public zzaWe setCurrencyCode(String s)
    {
        zzaWe.zzaWc = s;
        return this;
    }

    public zzaWe setLineItems(List list)
    {
        zzaWe.zzaWd.clear();
        zzaWe.zzaWd.addAll(list);
        return this;
    }

    public zzaWe setTotalPrice(String s)
    {
        zzaWe.zzaWb = s;
        return this;
    }

    private (Cart cart)
    {
        zzaWe = cart;
        super();
    }

    zzaWe(Cart cart, zzaWe zzawe)
    {
        this(cart);
    }
}
