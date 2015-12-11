// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.interfaces;

import android.os.Parcelable;
import java.math.BigDecimal;
import java.util.Currency;

public interface CartSummary
    extends Parcelable
{

    public abstract String a();

    public abstract int b();

    public abstract BigDecimal c();

    public abstract Currency d();

    public abstract BigDecimal e();

    public abstract BigDecimal f();

    public abstract BigDecimal g();

    public abstract BigDecimal h();

    public abstract BigDecimal i();

    public abstract Currency j();
}
