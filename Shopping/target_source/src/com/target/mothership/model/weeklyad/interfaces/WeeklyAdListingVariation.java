// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.weeklyad.interfaces;

import android.os.Parcelable;
import com.target.mothership.common.weeklyad.c;

// Referenced classes of package com.target.mothership.model.weeklyad.interfaces:
//            WeeklyAdListingVariationItem

public interface WeeklyAdListingVariation
    extends Parcelable
{

    public abstract c a();

    public abstract WeeklyAdListingVariationItem a(String s);

    public abstract WeeklyAdListingVariationItem a(String s, String s1);

    public abstract WeeklyAdListingVariationItem b(String s);
}
