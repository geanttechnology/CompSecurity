// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


// Referenced classes of package com.flurry.android:
//            FlurryAds, cw, AdCreative, AdSpaceLayout

final class ct
{

    private ct()
    {
    }

    static cw a(FlurryAds flurryads, String s)
    {
        long l = flurryads.aJ();
        flurryads.bh();
        s = new cw(l, s);
        flurryads.a(s);
        return s;
    }

    static AdCreative b(AdSpaceLayout adspacelayout)
    {
        return new AdCreative(adspacelayout.getAdHeight().intValue(), adspacelayout.getAdWidth().intValue(), adspacelayout.getFormat().toString(), adspacelayout.getFix().toString(), adspacelayout.getAlignment().toString());
    }
}
