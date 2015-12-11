// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.widgetcards;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.groupon.db.models.WidgetSummary;
import com.groupon.util.LoggingUtils;

// Referenced classes of package com.groupon.view.widgetcards:
//            WidgetHeaderCard, ImpressionLogging

public class DealDetailsWidgetHeaderCard extends WidgetHeaderCard
    implements ImpressionLogging
{

    private TextView titleView;
    private WidgetSummary widgetSummary;

    public DealDetailsWidgetHeaderCard(Context context)
    {
        this(context, null);
    }

    public DealDetailsWidgetHeaderCard(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        inflate(context, 0x7f0300ca, this);
        init();
    }

    public void init()
    {
        super.init();
        titleView = (TextView)findViewById(0x7f10007a);
    }

    public void logImpression(LoggingUtils loggingutils)
    {
        loggingutils.logWidgetImpression(widgetSummary, "Unused");
    }

    public void setInfo(WidgetSummary widgetsummary)
    {
        widgetSummary = widgetsummary;
        setOnTouchListener(new android.view.View.OnTouchListener() {

            final DealDetailsWidgetHeaderCard this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                this$0 = DealDetailsWidgetHeaderCard.this;
                super();
            }
        });
        titleView.setText(widgetsummary.displayName);
    }
}
