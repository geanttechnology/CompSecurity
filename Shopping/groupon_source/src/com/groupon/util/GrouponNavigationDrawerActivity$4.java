// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import com.groupon.models.LocationsContainer;
import com.groupon.models.dealbreakdown.DealBreakdownAddress;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.groupon.util:
//            Function1, GrouponNavigationDrawerActivity

class this._cls0
    implements Function1
{

    final GrouponNavigationDrawerActivity this$0;

    public void execute(LocationsContainer locationscontainer)
    {
        locationscontainer = locationscontainer.getLocations();
        if (locationscontainer != null && locationscontainer.size() > 0)
        {
            locationscontainer = locationscontainer.iterator();
            do
            {
                if (!locationscontainer.hasNext())
                {
                    break;
                }
                DealBreakdownAddress dealbreakdownaddress = (DealBreakdownAddress)locationscontainer.next();
                if (dealbreakdownaddress.isMaster())
                {
                    GrouponNavigationDrawerActivity.access$002(GrouponNavigationDrawerActivity.this, dealbreakdownaddress);
                }
            } while (true);
        }
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((LocationsContainer)obj);
    }

    ss()
    {
        this$0 = GrouponNavigationDrawerActivity.this;
        super();
    }
}
