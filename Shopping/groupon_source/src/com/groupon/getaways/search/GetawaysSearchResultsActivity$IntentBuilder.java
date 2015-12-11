// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.search;

import android.content.Context;
import android.content.Intent;
import com.groupon.models.hotel.Destination;
import java.util.Date;

// Referenced classes of package com.groupon.getaways.search:
//            GetawaysSearchResultsActivity

public static class context
{

    private Date checkInDate;
    private Date checkOutDate;
    private final Context context;
    private Destination destination;

    public Intent build()
    {
        if (checkInDate == null && checkOutDate != null || checkInDate != null && checkOutDate == null)
        {
            throw new IllegalStateException("checkInDate and checkOutDate may not be null");
        }
        Intent intent = new Intent(context, com/groupon/getaways/search/GetawaysSearchResultsActivity);
        if (destination != null)
        {
            intent.putExtra("destination_id", destination.uuid);
            intent.putExtra("destination_name", destination.name);
        } else
        {
            intent.putExtra("destination_name", context.getString(0x7f080118));
        }
        intent.putExtra("check_in_date", checkInDate);
        intent.putExtra("check_out_date", checkOutDate);
        return intent;
    }

    public checkOutDate dates(Date date, Date date1)
    {
        checkInDate = date;
        checkOutDate = date1;
        return this;
    }

    public checkOutDate destination(Destination destination1)
    {
        destination = destination1;
        return this;
    }

    public (Context context1)
    {
        context = context1;
    }
}
