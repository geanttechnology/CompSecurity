// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller.recycleritem;

import android.content.Context;
import android.location.Location;
import com.groupon.db.models.Option;
import com.groupon.mvc.model.AdditionalInfo;
import com.groupon.service.LocationService;
import com.groupon.util.GeoPoint;
import com.groupon.util.RedemptionUtils;
import java.util.ArrayList;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.mvc.controller.recycleritem:
//            RecyclerItemViewController

public class AdditionalInfoController extends RecyclerItemViewController
{

    private LocationService locationService;
    private Option option;
    private RedemptionUtils redemptionUtils;

    public AdditionalInfoController(Context context)
    {
        super(context);
    }

    private com.groupon.db.models.Location getClosestLocation()
    {
        Object obj2 = null;
        Object obj1 = null;
        Object obj = obj2;
        if (option != null)
        {
            ArrayList arraylist = option.getRedemptionLocations();
            obj = obj2;
            if (arraylist.size() > 0)
            {
                Location location = locationService.getLocation();
                RedemptionUtils redemptionutils = redemptionUtils;
                obj = obj1;
                if (location != null)
                {
                    obj = new GeoPoint((int)(location.getLatitude() * 1000000D), (int)(location.getLongitude() * 1000000D));
                }
                obj = (com.groupon.db.models.Location)arraylist.get(redemptionutils.findClosestLocationTo(((GeoPoint) (obj)), arraylist));
            }
        }
        return ((com.groupon.db.models.Location) (obj));
    }

    public volatile Object getCallback()
    {
        return getCallback();
    }

    public Void getCallback()
    {
        return null;
    }

    public void processData()
    {
        Object obj = getClosestLocation();
        if (obj != null)
        {
            obj = ((com.groupon.db.models.Location) (obj)).storesHtml;
        } else
        {
            obj = null;
        }
        if (Strings.isEmpty(obj))
        {
            setState(0);
            return;
        } else
        {
            model = new AdditionalInfo();
            ((AdditionalInfo)model).storesInfoHtml = ((String) (obj));
            setState(2);
            return;
        }
    }

    public void setOption(Option option1)
    {
        setState(1);
        option = option1;
    }
}
