// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.smule.android.c.aa;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.smule.pianoandroid.utils:
//            y, w, x

public class SwipeView extends HorizontalScrollView
{

    private static final String a = com/smule/pianoandroid/utils/SwipeView.getName();
    private List b;
    private GestureDetector c;
    private int d;
    private Integer e;
    private y f;
    private int g;
    private int h;
    private boolean i;

    public SwipeView(Context context)
    {
        super(context);
        b = null;
        d = -1;
        e = Integer.valueOf(0);
        h = -1;
        i = false;
    }

    public SwipeView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b = null;
        d = -1;
        e = Integer.valueOf(0);
        h = -1;
        i = false;
    }

    public SwipeView(Context context, AttributeSet attributeset, int j)
    {
        super(context, attributeset, j);
        b = null;
        d = -1;
        e = Integer.valueOf(0);
        h = -1;
        i = false;
    }

    static int a(SwipeView swipeview)
    {
        return swipeview.g;
    }

    static int a(SwipeView swipeview, int j)
    {
        swipeview.g = j;
        return j;
    }

    static String a()
    {
        return a;
    }

    private void a(int j, int k)
    {
        aa.a(a, (new StringBuilder()).append("Smooth scroll to ").append(j).append(" ").append(k).toString());
        smoothScrollTo(j - d, k);
        if (b != null && f != null)
        {
            f.a(this, Integer.valueOf(d), e);
        }
    }

    static void a(SwipeView swipeview, int j, int k)
    {
        swipeview.a(j, k);
    }

    static List b(SwipeView swipeview)
    {
        return swipeview.b;
    }

    static void b(SwipeView swipeview, int j)
    {
        swipeview.setActiveFeature(j);
    }

    static int c(SwipeView swipeview)
    {
        return swipeview.h;
    }

    static int c(SwipeView swipeview, int j)
    {
        swipeview.h = j;
        return j;
    }

    static y d(SwipeView swipeview)
    {
        return swipeview.f;
    }

    static int e(SwipeView swipeview)
    {
        return swipeview.d;
    }

    static Integer f(SwipeView swipeview)
    {
        return swipeview.e;
    }

    static GestureDetector g(SwipeView swipeview)
    {
        return swipeview.c;
    }

    private void setActiveFeature(int j)
    {
        e = Integer.valueOf(d);
        d = j;
    }

    public void a(w w1, List list)
    {
        int j = 0;
        aa.a(a, "setFeatureItems");
        b = list;
        removeAllViews();
        LinearLayout linearlayout = new LinearLayout(getContext());
        linearlayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        linearlayout.setOrientation(0);
        addView(linearlayout);
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            View view = w1.a(this, iterator.next());
            linearlayout.addView(view);
            view.post(new Runnable(j, view, list) {

                final int a;
                final int b;
                final View c;
                final List d;
                final SwipeView e;

                public void run()
                {
                    SwipeView.a(e, c.getMeasuredWidth());
                    if (a == 0)
                    {
                        DisplayMetrics displaymetrics = new DisplayMetrics();
                        ((WindowManager)e.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
                        int k = (displaymetrics.widthPixels - SwipeView.a(e)) / 2;
                        c.setPadding(k + c.getPaddingLeft(), c.getPaddingTop(), c.getPaddingRight(), c.getPaddingBottom());
                    }
                    if (a == d.size() - 1)
                    {
                        DisplayMetrics displaymetrics1 = new DisplayMetrics();
                        ((WindowManager)e.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics1);
                        int l = (displaymetrics1.widthPixels - SwipeView.a(e)) / 2;
                        c.setPadding(c.getPaddingLeft(), c.getPaddingTop(), l + c.getPaddingRight(), c.getPaddingBottom());
                        SwipeView.b(e, SwipeView.b(e).size() - 1);
                    }
                }

            
            {
                e = SwipeView.this;
                b = j;
                c = view;
                d = list;
                super();
                a = b;
            }
            });
            j++;
        }

        setOnTouchListener(new android.view.View.OnTouchListener() {

            final SwipeView a;

            public boolean onTouch(View view1, MotionEvent motionevent)
            {
                if (!SwipeView.b(a).isEmpty())
                {
                    if (SwipeView.c(a) == 0 && motionevent.getAction() == 2 && SwipeView.d(a) != null)
                    {
                        SwipeView.d(a).b(a, Integer.valueOf(SwipeView.e(a)), SwipeView.f(a));
                    }
                    SwipeView.c(a, motionevent.getAction());
                    if (SwipeView.g(a).onTouchEvent(motionevent))
                    {
                        aa.a(SwipeView.a(), "GestureDetector.onTouchEvent");
                        return true;
                    }
                    if (motionevent.getAction() == 1 || motionevent.getAction() == 3)
                    {
                        int k = a.getScrollX();
                        SwipeView.b(a, (k + SwipeView.a(a) / 2) / SwipeView.a(a));
                        k = SwipeView.e(a);
                        int l = SwipeView.a(a);
                        SwipeView.a(a, k * l, 0);
                        return true;
                    }
                }
                return false;
            }

            
            {
                a = SwipeView.this;
                super();
            }
        });
        c = new GestureDetector(getContext(), new x(this));
    }

    protected void onLayout(boolean flag, int j, int k, int l, int i1)
    {
        aa.a(a, (new StringBuilder()).append("onLayout ").append(flag).append(" mActive ").append(d).append(" mItems ").append(b).append("l ").append(j).append(" t ").append(k).append(" r ").append(l).append(" b ").append(i1).toString());
        super.onLayout(flag, j, k, l, i1);
        if (!i && b != null && !b.isEmpty() && d == b.size() - 1)
        {
            i = true;
            aa.a(a, (new StringBuilder()).append("Scroll to ").append(getRight() * b.size()).toString());
            scrollTo(getRight() * (b.size() - 1), 0);
        }
    }

    public void setSwipeListener(y y1)
    {
        f = y1;
    }

}
