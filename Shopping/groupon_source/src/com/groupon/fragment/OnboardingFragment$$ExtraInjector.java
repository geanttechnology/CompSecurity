// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;


// Referenced classes of package com.groupon.fragment:
//            OnboardingFragment

public class 
{

    public static void inject(com.f2prateek.dart.r r, OnboardingFragment onboardingfragment, Object obj)
    {
        r = ((com.f2prateek.dart.r) (r.r(obj, "includeEmail")));
        if (r != null)
        {
            onboardingfragment.includeEmail = (Boolean)r;
        }
    }

    public ()
    {
    }
}
