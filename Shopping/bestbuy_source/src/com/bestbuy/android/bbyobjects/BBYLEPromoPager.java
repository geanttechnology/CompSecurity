// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.bbyobjects;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.bestbuy.android.api.lib.models.offers.Offer;
import java.util.List;
import kd;
import ke;
import nb;
import ng;

public class BBYLEPromoPager extends RelativeLayout
{

    private static boolean e = true;
    private ke a;
    private Handler b;
    private Runnable c;
    private ViewPager d;

    public BBYLEPromoPager(Context context)
    {
        super(context);
    }

    public BBYLEPromoPager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public BBYLEPromoPager(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    static ViewPager a(BBYLEPromoPager bbylepromopager)
    {
        return bbylepromopager.d;
    }

    static boolean a()
    {
        return e;
    }

    public static boolean a(boolean flag)
    {
        e = flag;
        return flag;
    }

    static Runnable b(BBYLEPromoPager bbylepromopager)
    {
        return bbylepromopager.c;
    }

    static Handler c(BBYLEPromoPager bbylepromopager)
    {
        return bbylepromopager.b;
    }

    static ke d(BBYLEPromoPager bbylepromopager)
    {
        return bbylepromopager.a;
    }

    public Object a(Context context, View view, int i, List list)
    {
        ImageView imageview = new ImageView(context);
        imageview.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        context = ((Offer)list.get(i)).getImageUrl();
        if (nb.a().u() > 640)
        {
            context = (new StringBuilder()).append(context).append("=s640").toString();
        } else
        {
            context = (new StringBuilder()).append(context).append("=s").append(nb.a().u()).toString();
        }
        if (context != null && context.length() > 0)
        {
            ng.a(context, imageview, false);
        }
        imageview.setOnClickListener(new android.view.View.OnClickListener(list, i) {

            final List a;
            final int b;
            final BBYLEPromoPager c;

            public void onClick(View view1)
            {
                BBYLEPromoPager.d(c).a((Offer)a.get(b));
            }

            
            {
                c = BBYLEPromoPager.this;
                a = list;
                b = i;
                super();
            }
        });
        ((ViewPager)view).addView(imageview, 0);
        return imageview;
    }

    public void a(Context context, List list, ScrollView scrollview)
    {
        e = true;
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        d = new ViewPager(context);
        context = new kd(this, context, d, list);
        d.setAdapter(context);
        d.setCurrentItem(1);
        addView(d, layoutparams);
        d.setOnTouchListener(new android.view.View.OnTouchListener(scrollview) {

            final ScrollView a;
            final BBYLEPromoPager b;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 2 && a != null)
                {
                    a.requestDisallowInterceptTouchEvent(true);
                }
                return false;
            }

            
            {
                b = BBYLEPromoPager.this;
                a = scrollview;
                super();
            }
        });
        b = new Handler();
        if (list.size() == 1)
        {
            d.setCurrentItem(0);
            return;
        } else
        {
            c = new Runnable() {

                final BBYLEPromoPager a;

                public void run()
                {
                    if (BBYLEPromoPager.a())
                    {
                        BBYLEPromoPager.a(a).setCurrentItem(BBYLEPromoPager.a(a).getCurrentItem() + 1);
                        BBYLEPromoPager.c(a).postDelayed(BBYLEPromoPager.b(a), 3000L);
                    }
                }

            
            {
                a = BBYLEPromoPager.this;
                super();
            }
            };
            b.postDelayed(c, 3000L);
            return;
        }
    }

    public void setPromoPagerListener(ke ke)
    {
        a = ke;
    }

}
