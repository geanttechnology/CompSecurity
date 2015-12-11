// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;

// Referenced classes of package com.flurry.android:
//            m, ft, FlurryAds, cw, 
//            AdUnit, p

final class dx
    implements m
{

    dx()
    {
        this((byte)0);
    }

    private dx(byte byte0)
    {
    }

    public final p b(Context context, FlurryAds flurryads, cw cw, AdUnit adunit)
    {
        return new ft(context, flurryads, cw, adunit, 0);
    }
}
