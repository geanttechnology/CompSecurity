// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.groupon.db.models.BusinessSummary;
import com.groupon.util.LocationsUtil;
import com.groupon.view.widgetcards.BusinessCardView;
import java.text.DecimalFormat;

// Referenced classes of package com.groupon.view:
//            BusinessMapSlice

public class PoGSearchRecommendationCardListView extends BusinessCardView
{

    private TextView businessDistance;

    public PoGSearchRecommendationCardListView(Context context)
    {
        this(context, null, 0);
    }

    public PoGSearchRecommendationCardListView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public PoGSearchRecommendationCardListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        inflate(context, 0x7f03018d, this);
        onFinishInflate();
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        businessDistance = (TextView)findViewById(0x7f10015f);
        mapSlice.setShowMapPlaceholder(true);
    }

    public void setInfo(BusinessSummary businesssummary)
    {
        super.setInfo(businesssummary);
        businessDistance.setText((new StringBuilder()).append(decimalFormat.format(businesssummary.distance)).append(getContext().getString(0x7f08047a)).toString());
        businessLocation.setText(LocationsUtil.getLocationForBusinessSummary(businesssummary));
    }
}
