// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.adapter;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.livemixtapes.ImageLoader;
import com.livemixtapes.Utils;
import com.livemixtapes.console;
import com.livemixtapes.ui.widgets.DjBadgesView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ViewPagerAdapter extends PagerAdapter
{
    public static interface PagerCallbacks
    {

        public abstract void onShowMixtape(int i, int j);
    }

    private class ReleaseTimer extends CountDownTimer
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

        public ReleaseTimer(View view, long l)
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


    private static final int DAY = 0x5265c00;
    private static final int HOUR = 0x36ee80;
    private static final int MINUTE = 60000;
    private static final int SECOND = 1000;
    private PagerCallbacks callbacks;
    Context context;
    ArrayList data;
    LayoutInflater inflater;
    private List timers;

    public ViewPagerAdapter(Context context1, ArrayList arraylist)
    {
        timers = new ArrayList();
        data = new ArrayList();
        callbacks = null;
        context = context1;
        data = arraylist;
    }

    public void cancelTimers()
    {
        Iterator iterator = timers.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                timers.clear();
                return;
            }
            ((CountDownTimer)iterator.next()).cancel();
        } while (true);
    }

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        ((ViewPager)viewgroup).removeView((LinearLayout)obj);
    }

    public int getCount()
    {
        return data.size();
    }

    public Object instantiateItem(ViewGroup viewgroup, final int position)
    {
        inflater = (LayoutInflater)context.getSystemService("layout_inflater");
        View view = inflater.inflate(0x7f030021, viewgroup, false);
        if (callbacks != null)
        {
            view.setOnClickListener(new android.view.View.OnClickListener() {

                final ViewPagerAdapter this$0;
                private final int val$position;

                public void onClick(View view1)
                {
                    callbacks.onShowMixtape(position, 0);
                }

            
            {
                this$0 = ViewPagerAdapter.this;
                position = i;
                super();
            }
            });
        }
        view.findViewById(0x7f080080).setOnClickListener(new android.view.View.OnClickListener() {

            final ViewPagerAdapter this$0;
            private final int val$position;

            public void onClick(View view1)
            {
                callbacks.onShowMixtape(position, 1);
            }

            
            {
                this$0 = ViewPagerAdapter.this;
                position = i;
                super();
            }
        });
        view.findViewById(0x7f080081).setOnClickListener(new android.view.View.OnClickListener() {

            final ViewPagerAdapter this$0;
            private final int val$position;

            public void onClick(View view1)
            {
                callbacks.onShowMixtape(position, 2);
            }

            
            {
                this$0 = ViewPagerAdapter.this;
                position = i;
                super();
            }
        });
        ImageLoader imageloader = new ImageLoader(context);
        ImageView imageview = (ImageView)view.findViewById(0x7f080078);
        imageloader.DisplayImage(((HashMap)data.get(position)).get("thumbnail").toString(), imageview);
        ((TextView)view.findViewById(0x7f08004e)).setText(Utils.getArtistAndTitle((Map)data.get(position)));
        long l = Long.parseLong(String.valueOf(((HashMap)data.get(position)).get("releaseseconds")));
        console.log(new Object[] {
            (new StringBuilder("RELEASE SECONDS: ")).append(l).toString()
        });
        ((DjBadgesView)view.findViewById(0x7f080079)).loadDjs(((HashMap)data.get(position)).get("DJ").toString().split(","), false);
        if (l > 0L)
        {
            ((LinearLayout)view.findViewById(0x7f08007a)).setVisibility(0);
            timers.add(new ReleaseTimer(view, l));
        }
        ((ViewPager)viewgroup).addView(view);
        return view;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == (LinearLayout)obj;
    }

    public void setCallbacks(PagerCallbacks pagercallbacks)
    {
        callbacks = pagercallbacks;
    }

}
