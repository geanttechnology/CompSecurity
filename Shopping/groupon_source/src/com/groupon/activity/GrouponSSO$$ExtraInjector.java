// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import com.groupon.sso.UserCredential;

// Referenced classes of package com.groupon.activity:
//            GrouponSSO

public class 
{

    public static void inject(com.f2prateek.dart.r r, GrouponSSO grouponsso, Object obj)
    {
        Object obj1 = r.r(obj, "next");
        if (obj1 != null)
        {
            grouponsso.next = (Intent)obj1;
        }
        obj1 = r.r(obj, "dealId");
        if (obj1 != null)
        {
            grouponsso.dealId = (String)obj1;
        }
        obj1 = r.r(obj, "optionId");
        if (obj1 != null)
        {
            grouponsso.optionId = (String)obj1;
        }
        obj1 = r.r(obj, "credential");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'credential' for field 'userCredentialWrapper' was not found. If this extra is optional add '@Optional' annotation.");
        }
        grouponsso.userCredentialWrapper = (UserCredential)obj1;
        obj1 = r.lWrapper(obj, "comingFromCheckout");
        if (obj1 != null)
        {
            grouponsso.isComingFromCheckout = (Boolean)obj1;
        }
        r = ((com.f2prateek.dart.heckout) (r.heckout(obj, "goToCarouselOnUpOrBackPress")));
        if (r != null)
        {
            grouponsso.shouldGoToCarousel = ((Boolean)r).booleanValue();
        }
    }

    public ()
    {
    }
}
