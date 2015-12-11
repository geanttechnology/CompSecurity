// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import com.groupon.Channel;
import java.util.Date;

// Referenced classes of package com.groupon.activity:
//            MultiOptionActivity

public class 
{

    public static void inject(com.f2prateek.dart.r r, MultiOptionActivity multioptionactivity, Object obj)
    {
        Object obj1 = r.r(obj, "dealId");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'dealId' for field 'dealId' was not found. If this extra is optional add '@Optional' annotation.");
        }
        multioptionactivity.dealId = (String)obj1;
        obj1 = r.r(obj, "channel");
        if (obj1 != null)
        {
            multioptionactivity.channel = (Channel)obj1;
        }
        obj1 = r.r(obj, "next");
        if (obj1 != null)
        {
            multioptionactivity.next = (Intent)obj1;
        }
        obj1 = r.r(obj, "check_in_date");
        if (obj1 != null)
        {
            multioptionactivity.checkInDate = (Date)obj1;
        }
        obj1 = r.r(obj, "check_out_date");
        if (obj1 != null)
        {
            multioptionactivity.checkOutDate = (Date)obj1;
        }
        obj1 = r.r(obj, "mobile_only");
        if (obj1 != null)
        {
            multioptionactivity.isMobileOnly = ((Boolean)obj1).booleanValue();
        }
        obj1 = r.r(obj, "multi_option_selection");
        if (obj1 != null)
        {
            multioptionactivity.isMultiOptionSelection = ((Boolean)obj1).booleanValue();
        }
        obj1 = r.Selection(obj, "redirect_to_enter_code");
        if (obj1 != null)
        {
            multioptionactivity.redirectToEnterCode = ((Boolean)obj1).booleanValue();
        }
        obj1 = r.erCode(obj, "comingFromGifting");
        if (obj1 != null)
        {
            multioptionactivity.comingFromGifting = ((Boolean)obj1).booleanValue();
        }
        obj1 = r.ting(obj, "defaultOptionId");
        if (obj1 != null)
        {
            multioptionactivity.defaultOptionId = (String)obj1;
        }
        r = ((com.f2prateek.dart.Id) (r.Id(obj, "isDeepLinked")));
        if (r != null)
        {
            multioptionactivity.isDeepLinked = ((Boolean)r).booleanValue();
        }
    }

    public ()
    {
    }
}
