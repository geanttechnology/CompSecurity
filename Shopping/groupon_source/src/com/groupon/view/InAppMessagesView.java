// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.groupon.db.models.InAppMessage;
import com.groupon.util.Dates;

public class InAppMessagesView extends ViewPager
{
    public static interface OnMessageClickedListener
    {

        public abstract void onMessageClicked(InAppMessage inappmessage, int i);
    }


    private int readColor;
    private int unreadColor;

    public InAppMessagesView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        setPageMargin(getContext().getResources().getDimensionPixelOffset(0x7f0b0171));
        setPageMarginDrawable(getContext().getResources().getDrawable(0x7f02023b));
        readColor = context.getResources().getColor(0x7f0e00f4);
        unreadColor = context.getResources().getColor(0x7f0e010b);
    }

    public void updateCurrentItemTimeStamp(long l)
    {
        View view = findViewWithTag(Integer.valueOf(getCurrentItem()));
        if (view != null)
        {
            ((TextView)view.findViewById(0x7f100414)).setText(Dates.getTimeStampString(getContext(), l));
        }
    }

    public void updateCurrentItemViewState(boolean flag)
    {
        Object obj = findViewWithTag(Integer.valueOf(getCurrentItem()));
        if (obj != null)
        {
            obj = (TextView)((View) (obj)).findViewById(0x7f100413);
            int i;
            if (flag)
            {
                i = readColor;
            } else
            {
                i = unreadColor;
            }
            ((TextView) (obj)).setTextColor(i);
        }
    }
}
