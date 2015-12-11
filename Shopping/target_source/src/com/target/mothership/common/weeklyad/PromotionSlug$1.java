// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.weeklyad;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.common.weeklyad:
//            PromotionSlug

static final class 
    implements android.os.or
{

    public PromotionSlug a(Parcel parcel)
    {
        return new PromotionSlug(parcel);
    }

    public PromotionSlug[] a(int i)
    {
        return new PromotionSlug[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }

    ()
    {
    }
}
