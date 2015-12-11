// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.SharedPreferences;
import android.widget.TextView;
import com.groupon.models.LocationsContainer;
import com.groupon.models.dealbreakdown.DealBreakdownAddress;
import com.groupon.service.ShippingService;
import com.groupon.util.Function1;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            Thanks

class this._cls0
    implements Function1
{

    final Thanks this$0;

    public void execute(LocationsContainer locationscontainer)
    {
        locationscontainer = locationscontainer.getLocations();
        String s1 = Thanks.access$200(Thanks.this).getString("preferredShippingLocationId", "");
        Iterator iterator = locationscontainer.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            locationscontainer = (DealBreakdownAddress)iterator.next();
            if (Strings.equals(((DealBreakdownAddress) (locationscontainer)).id, s1))
            {
                String s = Thanks.access$300(Thanks.this).getAsJoin(locationscontainer);
                Thanks thanks = Thanks.this;
                locationscontainer = s;
                if (s.startsWith(", "))
                {
                    locationscontainer = s.replaceFirst(", ", "");
                }
                Thanks.access$402(thanks, locationscontainer);
                shippingAddress.setText(Thanks.access$400(Thanks.this));
                Thanks.access$500(Thanks.this);
            }
        } while (true);
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((LocationsContainer)obj);
    }

    ntainer()
    {
        this$0 = Thanks.this;
        super();
    }
}
