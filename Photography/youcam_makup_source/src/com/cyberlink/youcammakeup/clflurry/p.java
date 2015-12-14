// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;


// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            YMKApplyEvent

public class p extends YMKApplyEvent
{

    public static String d = "";
    public static String e = "";

    public p(YMKApplyEvent.FeatureName featurename)
    {
        super(featurename);
        a("YMK_Apply_LiveMakeup");
    }

    public static String f()
    {
        return d;
    }

    public static void l(String s)
    {
        if (s != null)
        {
            d = s;
        }
    }

}
