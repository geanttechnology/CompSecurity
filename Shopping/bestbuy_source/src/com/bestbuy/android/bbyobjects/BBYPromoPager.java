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
import kg;
import kh;
import ki;
import nb;
import ng;
import nh;

public class BBYPromoPager extends RelativeLayout
    implements nh
{

    private static boolean f = true;
    private kh a;
    private ki b;
    private Handler c;
    private Runnable d;
    private ViewPager e;

    public BBYPromoPager(Context context)
    {
        super(context);
    }

    public BBYPromoPager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public BBYPromoPager(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    static ViewPager a(BBYPromoPager bbypromopager)
    {
        return bbypromopager.e;
    }

    static boolean a()
    {
        return f;
    }

    public static boolean a(boolean flag)
    {
        f = flag;
        return flag;
    }

    static Runnable b(BBYPromoPager bbypromopager)
    {
        return bbypromopager.d;
    }

    static Handler c(BBYPromoPager bbypromopager)
    {
        return bbypromopager.c;
    }

    static kh d(BBYPromoPager bbypromopager)
    {
        return bbypromopager.a;
    }

    public Object a(Context context, View view, int i, List list)
    {
        ImageView imageview = new ImageView(context);
        imageview.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        if (((Offer)list.get(i)).getImageUrl() != null && !((Offer)list.get(i)).getImageUrl().isEmpty())
        {
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
                ng.a(context, imageview, false, this, i, null);
            }
        }
        imageview.setOnClickListener(new android.view.View.OnClickListener(list, i) {

            final List a;
            final int b;
            final BBYPromoPager c;

            public void onClick(View view1)
            {
                BBYPromoPager.d(c).a((Offer)a.get(b), b);
            }

            
            {
                c = BBYPromoPager.this;
                a = list;
                b = i;
                super();
            }
        });
        ((ViewPager)view).addView(imageview, 0);
        return imageview;
    }

    public void a(int i, RelativeLayout relativelayout)
    {
        b.c();
    }

    public void a(Context context, List list, ScrollView scrollview)
    {
        f = true;
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        e = new ViewPager(context);
        context = new kg(this, context, e, list);
        e.setAdapter(context);
        e.setCurrentItem(1);
        addView(e, layoutparams);
        e.setOnTouchListener(new android.view.View.OnTouchListener(scrollview) {

            final ScrollView a;
            final BBYPromoPager b;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 2 && a != null)
                {
                    a.requestDisallowInterceptTouchEvent(true);
                }
                return false;
            }

            
            {
                b = BBYPromoPager.this;
                a = scrollview;
                super();
            }
        });
        c = new Handler();
        if (list.size() == 1)
        {
            e.setCurrentItem(0);
            return;
        } else
        {
            d = new Runnable() {

                final BBYPromoPager a;

                public void run()
                {
                    if (BBYPromoPager.a())
                    {
                        BBYPromoPager.a(a).setCurrentItem(BBYPromoPager.a(a).getCurrentItem() + 1);
                        BBYPromoPager.c(a).postDelayed(BBYPromoPager.b(a), 3000L);
                    }
                }

            
            {
                a = BBYPromoPager.this;
                super();
            }
            };
            c.postDelayed(d, 3000L);
            return;
        }
    }

    public void setPromoPagerListener(kh kh)
    {
        a = kh;
    }

    public void setShowPullDownListener(ki ki1)
    {
        b = ki1;
    }

}
