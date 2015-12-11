// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;


// Referenced classes of package com.groupon.activity:
//            Carousel

public class 
{

    public static void inject(com.f2prateek.dart.r r, Carousel carousel, Object obj)
    {
        r = ((com.f2prateek.dart.r) (r.r(obj, "FROM_ONBOARDING")));
        if (r != null)
        {
            carousel.fromOnboarding = ((Boolean)r).booleanValue();
        }
    }

    public ()
    {
    }
}
