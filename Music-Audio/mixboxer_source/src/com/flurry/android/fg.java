// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;

// Referenced classes of package com.flurry.android:
//            ba, ag, FlurryAds, cw, 
//            AdUnit, ae

final class fg
    implements ba
{

    fg()
    {
        this((byte)0);
    }

    private fg(byte byte0)
    {
    }

    public final ae a(Context context, FlurryAds flurryads, cw cw, AdUnit adunit)
    {
        return new ag(context, flurryads, cw, adunit);
    }
}
