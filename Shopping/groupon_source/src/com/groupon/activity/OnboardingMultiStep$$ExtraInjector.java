// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;


// Referenced classes of package com.groupon.activity:
//            OnboardingMultiStep

public class 
{

    public static void inject(com.f2prateek.dart.r r, OnboardingMultiStep onboardingmultistep, Object obj)
    {
        r = ((com.f2prateek.dart.r) (r.r(obj, "includeEmail")));
        if (r == null)
        {
            throw new IllegalStateException("Required extra with key 'includeEmail' for field 'includeEmail' was not found. If this extra is optional add '@Optional' annotation.");
        } else
        {
            onboardingmultistep.includeEmail = (Boolean)r;
            return;
        }
    }

    public ()
    {
    }
}
