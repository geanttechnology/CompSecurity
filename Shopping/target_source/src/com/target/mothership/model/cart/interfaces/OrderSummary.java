// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.interfaces;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart.interfaces:
//            CartSummary, InitiatedCheckout

public interface OrderSummary
    extends CartSummary, InitiatedCheckout
{

    public abstract boolean q();

    public abstract String r();

    public abstract List s();

    public abstract BigDecimal t();

    public abstract Currency u();

    public abstract BigDecimal v();

    public abstract BigDecimal w();

    public abstract Currency x();

    public abstract String y();
}
