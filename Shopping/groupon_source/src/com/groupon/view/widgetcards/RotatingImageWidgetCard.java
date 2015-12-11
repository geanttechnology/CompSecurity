// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.widgetcards;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.groupon.db.models.DealSummary;
import com.groupon.db.models.WidgetSummary;
import com.groupon.util.ImageUrl;
import com.groupon.view.DealSetCallbacks;
import com.groupon.view.RotatingUrlImageView;
import java.util.Collection;
import roboguice.util.Strings;

public class RotatingImageWidgetCard extends RelativeLayout
{

    private static final String ANIMATION_SHOWN = "ns:AnimationShown";
    private static int MAX_IMAGES_TO_ROTATE = 4;
    private TextView primaryText;
    private RotatingUrlImageView rotatingImageView;
    private TextView secondaryText;
    private RelativeLayout seeAllButton;
    private DealSummary summaries[];
    private ImageUrl uris[];

    public RotatingImageWidgetCard(Context context)
    {
        this(context, null);
    }

    public RotatingImageWidgetCard(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        inflate(context, 0x7f030225, this);
        seeAllButton = (RelativeLayout)findViewById(0x7f100585);
        primaryText = (TextView)seeAllButton.findViewById(0x7f100586);
        secondaryText = (TextView)seeAllButton.findViewById(0x7f100587);
        rotatingImageView = (RotatingUrlImageView)findViewById(0x7f100121);
    }

    public void resetAnimation()
    {
        rotatingImageView.reset();
    }

    public void setInfo(final WidgetSummary widget, final DealSetCallbacks dealSetCallbacks)
    {
        summaries = (DealSummary[])widget.dealSummaries.toArray(new DealSummary[0]);
        int j = Math.min(widget.dealSummaries.size(), MAX_IMAGES_TO_ROTATE);
        uris = new ImageUrl[j];
        int i = 0;
        while (i < j) 
        {
            if (Strings.notEmpty(summaries[i].derivedImageUrl))
            {
                uris[i] = new ImageUrl(summaries[i].derivedImageUrl, true);
            } else
            {
                uris[i] = new ImageUrl(summaries[i].largeImageUrl, false);
            }
            i++;
        }
        boolean flag = widget.getBooleanAttr("ns:AnimationShown", Boolean.valueOf(false)).booleanValue();
        rotatingImageView.setImageUrls(uris, flag);
        if (!flag)
        {
            widget.putAttr("ns:AnimationShown", Boolean.valueOf(true));
        }
        primaryText.setText(widget.displayName);
        i = widget.moreAssetsDealsCount;
        if (i == -1)
        {
            secondaryText.setText(getResources().getText(0x7f08034e));
        } else
        {
            secondaryText.setText(getResources().getQuantityString(0x7f0c001a, i, new Object[] {
                Integer.valueOf(i)
            }));
        }
        seeAllButton.setOnClickListener(new android.view.View.OnClickListener() {

            final RotatingImageWidgetCard this$0;
            final DealSetCallbacks val$dealSetCallbacks;
            final WidgetSummary val$widget;

            public void onClick(View view)
            {
                dealSetCallbacks.onSubsetClick(widget);
            }

            
            {
                this$0 = RotatingImageWidgetCard.this;
                dealSetCallbacks = dealsetcallbacks;
                widget = widgetsummary;
                super();
            }
        });
        seeAllButton.setOnTouchListener(new android.view.View.OnTouchListener() {

            final RotatingImageWidgetCard this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                switch (motionevent.getAction())
                {
                default:
                    return false;

                case 0: // '\0'
                    primaryText.setPressed(true);
                    break;
                }
                secondaryText.setPressed(true);
                return false;
            }

            
            {
                this$0 = RotatingImageWidgetCard.this;
                super();
            }
        });
        setOnClickListener(new android.view.View.OnClickListener() {

            final RotatingImageWidgetCard this$0;

            public void onClick(View view)
            {
            }

            
            {
                this$0 = RotatingImageWidgetCard.this;
                super();
            }
        });
    }



}
