// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.promotion.interfaces;

import android.os.Parcelable;
import com.target.mothership.common.product.Tcin;

public interface PromotionStatus
    extends Parcelable
{

    public abstract boolean a(Tcin tcin);

    public abstract boolean a(String s);
}
