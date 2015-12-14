// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.timeline;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.amazon.gallery.framework.gallery.utils.TimelineMonthResources;

// Referenced classes of package com.amazon.gallery.framework.kindle.timeline:
//            TimelineMarker, TimelineMarkerContainer

public class TimelineViewHolder
{

    private final int defaultTextColor;
    private final int highlightTextColor;
    private ImageView image;
    private boolean isContainerHighlighted;
    private boolean isLabelHighlighted;
    private final float monthTextSize;
    private final int rightPadding;
    private String textlabel;
    protected TextView titleLabel;
    private View view;
    private final float yearTextSize;

    public TimelineViewHolder(Context context, float f)
    {
        textlabel = "";
        isLabelHighlighted = false;
        isContainerHighlighted = false;
        view = LayoutInflater.from(context).inflate(0x7f0300ed, null);
        titleLabel = (TextView)view.findViewById(0x7f0c0202);
        image = (ImageView)view.findViewById(0x7f0c0203);
        rightPadding = context.getResources().getDimensionPixelSize(0x7f0a01e2);
        monthTextSize = context.getResources().getDimension(0x7f0a01e1);
        yearTextSize = context.getResources().getDimension(0x7f0a01e4);
        defaultTextColor = context.getResources().getColor(0x106000b);
        highlightTextColor = context.getResources().getColor(0x7f0900da);
        android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
        context = layoutparams;
        if (layoutparams == null)
        {
            context = new android.widget.AbsListView.LayoutParams(-1, (int)f);
        }
        context.height = (int)f;
        view.setLayoutParams(context);
        view.setTag(this);
    }

    public void baseSetup(TimelineMarker timelinemarker, Context context)
    {
        textlabel = timelinemarker.getLabel();
        isContainerHighlighted = timelinemarker.isContainerHighlighted();
        if (timelinemarker instanceof TimelineMarkerContainer)
        {
            view.setContentDescription(textlabel);
            return;
        } else
        {
            view.setContentDescription(context.getResources().getString(TimelineMonthResources.MONTHS_FULL[timelinemarker.getMonth()]));
            return;
        }
    }

    public View getView()
    {
        return view;
    }

    public void imageSetup(TimelineMarker timelinemarker, Context context)
    {
        isLabelHighlighted = timelinemarker.isContainerHighlighted();
        baseSetup(timelinemarker, context);
        titleLabel.setVisibility(8);
        image.setVisibility(0);
        timelinemarker = context.getResources();
        view.setPadding(0, 0, 0, (int)(timelinemarker.getDisplayMetrics().density * 20F));
        if (isContainerHighlighted)
        {
            image.setImageDrawable(timelinemarker.getDrawable(0x7f0201d6));
            return;
        } else
        {
            image.setImageDrawable(timelinemarker.getDrawable(0x7f0201d5));
            return;
        }
    }

    public void setup(TimelineMarker timelinemarker, Context context)
    {
        if (timelinemarker.isNoDate())
        {
            imageSetup(timelinemarker, context);
            return;
        } else
        {
            textSetup(timelinemarker, context);
            return;
        }
    }

    public void textSetup(TimelineMarker timelinemarker, Context context)
    {
        isLabelHighlighted = timelinemarker.isLabelHighlighted();
        baseSetup(timelinemarker, context);
        image.setVisibility(8);
        titleLabel.setVisibility(0);
        titleLabel.setText(textlabel);
        titleLabel.setTextColor(context.getResources().getColor(0x7f0900db));
        int j = 0x7f0900dd;
        int i = 0;
        int k = 0;
        if (timelinemarker.getMonth() == -1)
        {
            i = j;
            j = k;
            if (isContainerHighlighted)
            {
                i = 0x7f0900da;
                j = 1;
            }
            titleLabel.setTextSize(0, yearTextSize);
            titleLabel.setGravity(17);
            titleLabel.setPadding(0, 0, 0, 0);
            k = j;
            j = i;
        } else
        {
            k = defaultTextColor;
            if (isLabelHighlighted)
            {
                i = 1;
                k = highlightTextColor;
            }
            titleLabel.setTextColor(k);
            titleLabel.setTextSize(0, monthTextSize);
            titleLabel.setGravity(21);
            titleLabel.setPadding(0, 0, rightPadding, 0);
            k = i;
        }
        titleLabel.setTypeface(null, k);
        titleLabel.setBackgroundResource(j);
    }
}
