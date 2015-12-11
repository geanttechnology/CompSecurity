// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;

// Referenced classes of package com.flurry.android:
//            FlurryAds, cw, AdUnit

abstract class ae
{

    static final String p = com/flurry/android/ae.getSimpleName();
    private final Context Q;
    private final FlurryAds R;
    private final cw S;
    private final AdUnit T;

    public ae(Context context, FlurryAds flurryads, cw cw, AdUnit adunit)
    {
        Q = context;
        R = flurryads;
        S = cw;
        T = adunit;
    }

    public final FlurryAds J()
    {
        return R;
    }

    public final cw K()
    {
        return S;
    }

    public final AdUnit L()
    {
        return T;
    }

    public abstract void M();

    public final Context getContext()
    {
        return Q;
    }

}
