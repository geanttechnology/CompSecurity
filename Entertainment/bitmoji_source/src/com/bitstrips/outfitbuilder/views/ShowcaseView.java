// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.outfitbuilder.views;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bitstrips.outfitbuilder.models.OBShowcaseItem;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ShowcaseView extends RelativeLayout
{
    private class ShowcaseImageArrayAdapter extends PagerAdapter
    {

        ArrayList items;
        final ShowcaseView this$0;

        public void destroyItem(ViewGroup viewgroup, int i, Object obj)
        {
            viewgroup.removeView((View)obj);
        }

        public int getCount()
        {
            return items.size() != 0 ? 500 : 0;
        }

        public int getStartPage()
        {
            if (items.size() == 0)
            {
                return 0;
            } else
            {
                return (250 / items.size()) * items.size();
            }
        }

        public Object instantiateItem(ViewGroup viewgroup, int i)
        {
            Context context = getContext();
            String s = ((OBShowcaseItem)items.get(i % items.size())).getImageURL();
            ImageView imageview = new ImageView(context);
            imageview.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
            Picasso.with(context).load(s).fit().into(imageview);
            viewgroup.addView(imageview);
            return imageview;
        }

        public boolean isViewFromObject(View view, Object obj)
        {
            return view == obj;
        }

        public ShowcaseImageArrayAdapter(List list)
        {
            this$0 = ShowcaseView.this;
            super();
            items = new ArrayList();
            for (showcaseview = list.iterator(); hasNext(); items.add(list))
            {
                list = (OBShowcaseItem)next();
            }

        }
    }

    class ShowcaseTimer extends TimerTask
    {

        final ShowcaseView this$0;

        public void run()
        {
            Activity activity = (Activity)weakActivity.get();
            if (activity == null)
            {
                return;
            } else
            {
                activity.runOnUiThread(new Runnable() {

                    final ShowcaseTimer this$1;

                    public void run()
                    {
                        if (adapter.getCount() == 0)
                        {
                            return;
                        } else
                        {
                            ViewPager viewpager = viewPager;
                            ShowcaseView showcaseview = _fld0;
                            int i = showcaseview.pageCounter;
                            showcaseview.pageCounter = i + 1;
                            viewpager.setCurrentItem(i % adapter.getCount());
                            return;
                        }
                    }

            
            {
                this$1 = ShowcaseTimer.this;
                super();
            }
                });
                return;
            }
        }

        ShowcaseTimer()
        {
            this$0 = ShowcaseView.this;
            super();
        }
    }


    private static final int CAROUSEL_SPEED_IN_MILLIS = 4000;
    private static final int MAX_PAGES = 500;
    ShowcaseImageArrayAdapter adapter;
    int pageCounter;
    Timer timer;
    ViewPager viewPager;
    final WeakReference weakActivity = new WeakReference((Activity)getContext());

    public ShowcaseView(Context context)
    {
        super(context);
        ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(com.bitstrips.outfitbuilder.R.layout.showcase, this, true);
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        timer = new Timer();
        timer.scheduleAtFixedRate(new ShowcaseTimer(), 0L, 4000L);
        viewPager.setAdapter(adapter);
        pageCounter = adapter.getStartPage();
        viewPager.setOnTouchListener(new android.view.View.OnTouchListener() {

            final ShowcaseView this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                timer.cancel();
                return false;
            }

            
            {
                this$0 = ShowcaseView.this;
                super();
            }
        });
    }

    protected void onDetachedFromWindow()
    {
        timer.cancel();
        viewPager.setAdapter(null);
        viewPager.setOnTouchListener(null);
        super.onDetachedFromWindow();
    }

    public void setCatalog(List list)
    {
        viewPager = (ViewPager)findViewById(com.bitstrips.outfitbuilder.R.id.showcase_carousel);
        adapter = new ShowcaseImageArrayAdapter(list);
        if (list.size() == 0)
        {
            viewPager.setVisibility(8);
        }
    }
}
