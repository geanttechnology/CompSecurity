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
import com.groupon.view.DealSetCallbacks;
import java.util.Collection;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.view.widgetcards:
//            WidgetHeaderCard

public class LimitedListWidgetHeaderCard extends WidgetHeaderCard
{

    protected TextView headerTitle;
    protected TextView subTitleButton;

    public LimitedListWidgetHeaderCard(Context context)
    {
        this(context, null);
    }

    public LimitedListWidgetHeaderCard(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        inflate(context, 0x7f03014c, this);
        init();
    }

    public void bind(Object obj, String s, String s1, android.view.View.OnClickListener onclicklistener, boolean flag)
    {
        setOnTouchListener(new android.view.View.OnTouchListener() {

            final LimitedListWidgetHeaderCard this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                this$0 = LimitedListWidgetHeaderCard.this;
                super();
            }
        });
        if (headerTitle != null && !Strings.equals(s, headerTitle.getText()))
        {
            headerTitle.setText(s);
        }
        if (onclicklistener != null && subTitleButton != null && !flag)
        {
            subTitleButton.setTag(0x7f100001, obj);
            subTitleButton.setOnClickListener(onclicklistener);
            subTitleButton.setVisibility(0);
            if (Strings.notEmpty(s1))
            {
                subTitleButton.setText(s1);
            }
            return;
        } else
        {
            subTitleButton.setTag(0x7f100001, null);
            subTitleButton.setOnClickListener(null);
            subTitleButton.setVisibility(8);
            return;
        }
    }

    public void init()
    {
        super.init();
        headerTitle = (TextView)findViewById(0x7f1003d5);
        subTitleButton = (TextView)findViewById(0x7f1003d4);
    }

    public void setInfo(final WidgetSummary widget, final DealSetCallbacks dealSetCallbacks, boolean flag)
    {
        setOnTouchListener(new android.view.View.OnTouchListener() {

            final LimitedListWidgetHeaderCard this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                this$0 = LimitedListWidgetHeaderCard.this;
                super();
            }
        });
        String s = widget.displayName;
        if (headerTitle != null && !Strings.equals(s, headerTitle.getText()))
        {
            headerTitle.setText(s);
        }
        if (dealSetCallbacks != null && subTitleButton != null && widget.dealSummaries.size() > 0 && !Strings.isEmpty(widget.moreAssetsDealsUrl) && !flag)
        {
            subTitleButton.setOnClickListener(new android.view.View.OnClickListener() {

                final LimitedListWidgetHeaderCard this$0;
                final DealSetCallbacks val$dealSetCallbacks;
                final WidgetSummary val$widget;

                public void onClick(View view)
                {
                    dealSetCallbacks.onSubsetClick(widget);
                }

            
            {
                this$0 = LimitedListWidgetHeaderCard.this;
                dealSetCallbacks = dealsetcallbacks;
                widget = widgetsummary;
                super();
            }
            });
            subTitleButton.setVisibility(0);
            return;
        } else
        {
            subTitleButton.setOnClickListener(null);
            subTitleButton.setVisibility(8);
            return;
        }
    }

    public void setInfo(String s)
    {
        if (headerTitle != null && !Strings.equals(s, headerTitle.getText()))
        {
            headerTitle.setText(s);
        }
        subTitleButton.setVisibility(8);
    }
}
