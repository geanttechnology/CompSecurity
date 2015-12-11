// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


// Referenced classes of package com.flurry.android:
//            fp, FlurryAds

final class ci extends fp
{

    private FlurryAds du;

    ci(FlurryAds flurryads)
    {
        du = flurryads;
        super();
    }

    public final void c()
    {
        du.B("/postAdLog.do");
    }
}
