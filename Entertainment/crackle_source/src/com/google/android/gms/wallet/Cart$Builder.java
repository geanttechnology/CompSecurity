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

    final Cart Gm;

    public <init> addLineItem(LineItem lineitem)
    {
        Gm.Gl.add(lineitem);
        return this;
    }

    public Cart build()
    {
        return Gm;
    }

    public Gm setCurrencyCode(String s)
    {
        Gm.Gk = s;
        return this;
    }

    public Gm setLineItems(List list)
    {
        Gm.Gl.clear();
        Gm.Gl.addAll(list);
        return this;
    }

    public Gm setTotalPrice(String s)
    {
        Gm.Gj = s;
        return this;
    }

    private (Cart cart)
    {
        Gm = cart;
        super();
    }

    Gm(Cart cart, Gm gm)
    {
        this(cart);
    }
}
