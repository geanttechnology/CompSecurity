// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.interfaces;

import com.target.mothership.model.product.interfaces.Product;

public interface OrderSummaryProduct
    extends Product
{

    public abstract String a(int j)
        throws IllegalArgumentException;

    public abstract String c();

    public abstract int i();
}
