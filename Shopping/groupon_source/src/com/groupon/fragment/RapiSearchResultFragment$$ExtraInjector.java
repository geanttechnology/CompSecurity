// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.Channel;
import com.groupon.models.Place;
import com.groupon.util.RapiRequestProperties;

// Referenced classes of package com.groupon.fragment:
//            RapiSearchResultFragment

public class 
{

    public static void inject(com.f2prateek.dart.r r, RapiSearchResultFragment rapisearchresultfragment, Object obj)
    {
        Object obj1 = r.r(obj, "channel");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'channel' for field 'searchSourceChannel' was not found. If this extra is optional add '@Optional' annotation.");
        }
        rapisearchresultfragment.searchSourceChannel = (Channel)obj1;
        obj1 = r.hannel(obj, "selected_place");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'selected_place' for field 'searchPlace' was not found. If this extra is optional add '@Optional' annotation.");
        }
        rapisearchresultfragment.searchPlace = (Place)obj1;
        obj1 = r.hannel(obj, "BUNDLE_SEARCH_PROPERTIES");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'BUNDLE_SEARCH_PROPERTIES' for field 'searchProperties' was not found. If this extra is optional add '@Optional' annotation.");
        }
        rapisearchresultfragment.searchProperties = (RapiRequestProperties)obj1;
        r = ((com.f2prateek.dart.ies) (r.ies(obj, "date_time_initial_toggle_state")));
        if (r != null)
        {
            rapisearchresultfragment.initialDateTimeToggleState = ((Boolean)r).booleanValue();
        }
    }

    public ()
    {
    }
}
