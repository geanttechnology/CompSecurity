// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.events;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;

// Referenced classes of package com.ebay.mobile.events:
//            EventViewModel, EventTimeLeftHelper

public class EventViewHolder extends ViewHolder
{

    protected static boolean isTablet;
    private final TextView description;
    private final View eventTextLayout;
    public final RemoteImageView imageView;
    private final Resources resources;
    private final TextView timeLeft;
    private final TextView title;

    public EventViewHolder(View view)
    {
        super(view);
        View view1 = itemView.findViewById(0x7f100110);
        if (view1 != null)
        {
            view1.setOnClickListener(this);
        } else
        {
            itemView.setOnClickListener(this);
        }
        title = (TextView)itemView.findViewById(0x7f100108);
        description = (TextView)itemView.findViewById(0x7f100243);
        imageView = (RemoteImageView)itemView.findViewById(0x7f1000fc);
        timeLeft = (TextView)itemView.findViewById(0x7f100241);
        resources = view.getResources();
        isTablet = view.getContext().getResources().getBoolean(0x7f0b0006);
        eventTextLayout = itemView.findViewById(0x7f100242);
    }

    public static boolean isValidModel(ViewModel viewmodel, boolean flag, boolean flag1)
    {
        return viewmodel instanceof EventViewModel;
    }

    public void bind(ViewModel viewmodel)
    {
        super.bind(viewmodel);
        if (viewmodel instanceof EventViewModel)
        {
            viewmodel = (EventViewModel)viewmodel;
            title.setText(((EventViewModel) (viewmodel)).title);
            if (((EventViewModel) (viewmodel)).showTimer)
            {
                timeLeft.setVisibility(0);
                timeLeft.setText(EventTimeLeftHelper.getEndsInTimeMaxUnitString(resources, EventTimeLeftHelper.getRemainingDuration(((EventViewModel) (viewmodel)).endDate), true));
            } else
            {
                timeLeft.setVisibility(8);
            }
            description.setVisibility(8);
            if (((EventViewModel) (viewmodel)).rppEvent.description != null)
            {
                description.setText(((EventViewModel) (viewmodel)).rppEvent.description);
                if (!TextUtils.isEmpty(((EventViewModel) (viewmodel)).rppEvent.description))
                {
                    description.setVisibility(0);
                    eventTextLayout.getLayoutParams().height = resources.getDimensionPixelSize(0x7f09009f);
                }
            }
            imageView.setRemoteImageUrl(((EventViewModel) (viewmodel)).image);
        }
    }
}
