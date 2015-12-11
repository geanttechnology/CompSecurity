// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.content.Context;
import android.view.View;
import com.groupon.view.widgetcards.TrackingWidgetHeaderCard;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            Mapping

public class TrackingWidgetHeaderCardMapping extends Mapping
{

    public TrackingWidgetHeaderCardMapping()
    {
        super(com/groupon/v3/adapter/mapping/TrackingWidgetHeaderCardMapping);
    }

    public View createView(Context context)
    {
        return new TrackingWidgetHeaderCard(context);
    }

    public boolean getSpanAllColumns()
    {
        return true;
    }
}
