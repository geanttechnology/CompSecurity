// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.common;

import com.target.mothership.common.tender.PaymentTender;
import java.math.BigDecimal;

public interface AppliedGiftCardTender
    extends PaymentTender
{

    public abstract String b();

    public abstract String c();

    public abstract BigDecimal d();
}
