// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.weeklyad.interfaces;

import android.os.Parcelable;
import com.target.mothership.common.weeklyad.PromotionSlug;
import java.util.Date;

public interface WeeklyAdPromotion
    extends Parcelable
{

    public abstract PromotionSlug a();

    public abstract Date b();

    public abstract Date c();
}
