// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.r;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            YMKApplyEvent

public class ar extends YMKApplyEvent
{

    public ar()
    {
        super(null);
        a("YMK_Save");
    }

    public static void a(YMKApplyEvent.FeatureName featurename, r r, ar ar1)
    {
        ar1.a(featurename);
        YMKApplyEvent.a(featurename, r, ar1);
        ar1.a(null);
    }
}
