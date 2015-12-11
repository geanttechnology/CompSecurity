// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.pi_blackfriday_deals;

import android.os.Parcelable;
import com.target.mothership.common.product.Dpci;
import java.math.BigDecimal;

public interface PiBaseProduct
    extends Parcelable
{

    public abstract String a();

    public abstract Dpci b();

    public abstract String c();

    public abstract BigDecimal d();
}
