// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.interfaces;

import com.target.mothership.model.common.OrderProductImage;
import com.target.mothership.model.product.interfaces.Product;
import java.math.BigDecimal;

public interface SaveForLaterProduct
    extends Product
{

    public abstract OrderProductImage a();

    public abstract String b();

    public abstract BigDecimal c();

    public abstract boolean i();
}
