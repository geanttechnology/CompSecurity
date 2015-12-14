// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.adapter;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.livemixtapes.adapter:
//            ViewPagerAdapter

private class start extends CountDownTimer
{

    private long dayValue;
    private TextView days;
    private long hourValue;
    private TextView hours;
    private TextView mins;
    private long minuteValue;
    private long secondValue;
    private TextView secs;
    final ViewPagerAdapter this$0;

    public void onFinish()
    {
    }

    public void onTick(long l)
    {
        long l1 = l / 0x5265c00L;
        long l2 = l / 0x36ee80L - 24L * l1;
        long l3 = l / 60000L - 60L * l2 - 24L * l1 * 60L;
        l = l / 1000L - 60L * l3 - 60L * l2 * 60L - 24L * l1 * 60L * 60L;
        if (l1 != dayValue)
        {
            days.setText(String.format("%02d", new Object[] {
                Long.valueOf(l1)
            }));
            dayValue = l1;
        }
        if (l2 != hourValue)
        {
            hours.setText(String.format("%02d", new Object[] {
                Long.valueOf(l2)
            }));
            hourValue = l2;
        }
        if (l3 != minuteValue)
        {
            mins.setText(String.format("%02d", new Object[] {
                Long.valueOf(l3)
            }));
            minuteValue = l3;
        }
        if (l != secondValue)
        {
            secs.setText(String.format("%02d", new Object[] {
                Long.valueOf(l)
            }));
            secondValue = l;
        }
    }

    public (View view, long l)
    {
        this$0 = ViewPagerAdapter.this;
        super(l * 1000L, 1000L);
        days = (TextView)view.findViewById(0x7f08007b);
        hours = (TextView)view.findViewById(0x7f08007c);
        mins = (TextView)view.findViewById(0x7f08007d);
        secs = (TextView)view.findViewById(0x7f08007e);
        start();
    }
}
