// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.interfaces;

import android.os.Parcelable;
import com.target.mothership.common.tender.a;
import java.math.BigDecimal;

public interface AppliedPaymentCard
    extends Parcelable
{

    public abstract a a();

    public abstract BigDecimal b();

    public abstract String c();
}
