// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.widgetcards;

import android.content.Context;
import android.view.View;
import com.groupon.Channel;
import com.groupon.db.models.DealSummary;
import com.groupon.util.GeoPoint;
import com.groupon.util.LoggingUtils;
import com.groupon.view.DealSetCallbacks;
import com.groupon.view.dealcards.DealCardBase;

// Referenced classes of package com.groupon.view.widgetcards:
//            ImpressionLogging

public class DealWidgetCard extends DealCardBase
    implements ImpressionLogging
{

    private DealSummary dealSummary;

    public DealWidgetCard(Context context, int i)
    {
        super(context, i);
    }

    public void logImpression(LoggingUtils loggingutils)
    {
        loggingutils.logWidgetDealImpression(loggingutils.getOriginatingNstChannel().toString(), dealSummary, "unused");
    }

    public void setInfo(final DealSummary dealSummary, final DealSetCallbacks dealSetCallbacks, GeoPoint geopoint)
    {
        super.setInfoWithPlace(dealSummary, geopoint);
        this.dealSummary = dealSummary;
        setOnClickListener(new android.view.View.OnClickListener() {

            final DealWidgetCard this$0;
            final DealSetCallbacks val$dealSetCallbacks;
            final DealSummary val$dealSummary;

            public void onClick(View view)
            {
                dealSetCallbacks.onMemberClick(view, dealSummary);
            }

            
            {
                this$0 = DealWidgetCard.this;
                dealSetCallbacks = dealsetcallbacks;
                dealSummary = dealsummary;
                super();
            }
        });
    }
}
