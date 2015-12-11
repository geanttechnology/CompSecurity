// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.Channel;

// Referenced classes of package com.groupon.fragment:
//            BaseSignUpFragment

public class 
{

    public static void inject(com.f2prateek.dart.r r, BaseSignUpFragment basesignupfragment, Object obj)
    {
        Object obj1 = r.r(obj, "comingFromCheckout");
        if (obj1 != null)
        {
            basesignupfragment.isComingFromCheckout = (Boolean)obj1;
        }
        obj1 = r.heckout(obj, "channel");
        if (obj1 != null)
        {
            basesignupfragment.channel = (Channel)obj1;
        }
        r = ((com.f2prateek.dart.heckout) (r.heckout(obj, "FROM_ONBOARDING")));
        if (r != null)
        {
            basesignupfragment.isComingFromOnboarding = ((Boolean)r).booleanValue();
        }
    }

    public ()
    {
    }
}
