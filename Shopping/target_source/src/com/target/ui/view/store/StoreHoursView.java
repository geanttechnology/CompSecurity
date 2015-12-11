// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.store;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.a.a.e;
import com.target.mothership.model.store.interfaces.StoreOperatingHours;
import com.target.mothership.util.TimeOfDay;
import com.target.ui.util.d.c;

public class StoreHoursView extends RelativeLayout
{
    private class a
    {

        TextView closedAllDay;
        View closedContainer;
        TextView closedHours;
        TextView closedLabel;
        TextView hoursDescription;
        View openContainer;
        TextView openHours;
        final StoreHoursView this$0;
        TextView todayDescription;

        public a(View view)
        {
            this$0 = StoreHoursView.this;
            super();
            hoursDescription = (TextView)view.findViewById(0x7f1005c9);
            todayDescription = (TextView)view.findViewById(0x7f1005ca);
            closedAllDay = (TextView)view.findViewById(0x7f1005cb);
            openContainer = view.findViewById(0x7f1005cc);
            closedContainer = view.findViewById(0x7f1005ce);
            openHours = (TextView)view.findViewById(0x7f1005cd);
            closedHours = (TextView)view.findViewById(0x7f1005cf);
            closedLabel = (TextView)view.findViewById(0x7f1005d0);
        }
    }


    private static final String MONDAY_TO_FRIDAY = "Monday-Friday";
    private a mViews;

    public StoreHoursView(Context context)
    {
        super(context);
        b();
    }

    public StoreHoursView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b();
    }

    public StoreHoursView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        b();
    }

    private boolean a(StoreOperatingHours storeoperatinghours)
    {
        return storeoperatinghours.f().b() && storeoperatinghours.e().b() && ((TimeOfDay)storeoperatinghours.e().c()).a((TimeOfDay)storeoperatinghours.f().c());
    }

    private void b()
    {
        inflate(getContext(), 0x7f0301fd, this);
        mViews = new a(this);
    }

    public void a()
    {
        mViews.todayDescription.setVisibility(0);
        mViews.hoursDescription.setVisibility(8);
    }

    public void setDescription(String s)
    {
        mViews.hoursDescription.setVisibility(0);
        mViews.todayDescription.setVisibility(8);
        mViews.hoursDescription.setText(s);
    }

    public void setHours(StoreOperatingHours storeoperatinghours)
    {
        if (storeoperatinghours.d())
        {
            mViews.openContainer.setVisibility(8);
            mViews.closedContainer.setVisibility(8);
            mViews.closedAllDay.setVisibility(0);
            return;
        }
        mViews.closedAllDay.setVisibility(8);
        if (storeoperatinghours.e().b())
        {
            mViews.openContainer.setVisibility(0);
            mViews.openHours.setText(c.a((TimeOfDay)storeoperatinghours.e().c(), getContext()));
        } else
        {
            mViews.openContainer.setVisibility(8);
        }
        if (storeoperatinghours.f().b())
        {
            mViews.closedContainer.setVisibility(0);
            mViews.closedHours.setText(c.a((TimeOfDay)storeoperatinghours.f().c(), getContext()));
            String s1 = getContext().getString(0x7f09026d);
            String s = s1;
            if (a(storeoperatinghours))
            {
                s = s1;
                if (!storeoperatinghours.a().equalsIgnoreCase("Monday-Friday"))
                {
                    storeoperatinghours = c.a(storeoperatinghours.a());
                    s = getContext().getString(0x7f09026e, new Object[] {
                        storeoperatinghours, s1
                    });
                }
            }
            mViews.closedLabel.setText(s);
            return;
        } else
        {
            mViews.closedContainer.setVisibility(8);
            return;
        }
    }
}
