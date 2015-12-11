// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bestbuy.android.activities.browseproduct.pdp.PDPHeaderListView;

public class bx
    implements android.widget.AbsListView.OnScrollListener
{

    final PDPHeaderListView a;
    private int b;
    private int c;
    private int d;
    private boolean e;
    private boolean f;
    private int g;
    private int h;
    private int i;
    private View j;
    private View k;
    private AlphaAnimation l;
    private boolean m;
    private boolean n;

    private bx(PDPHeaderListView pdpheaderlistview)
    {
        a = pdpheaderlistview;
        super();
        b = -1;
        c = 0;
        d = 0;
        e = false;
        f = false;
        g = -1;
        l = new AlphaAnimation(1.0F, 0.0F);
        m = false;
        n = false;
    }

    public bx(PDPHeaderListView pdpheaderlistview, com.bestbuy.android.activities.browseproduct.pdp.PDPHeaderListView._cls1 _pcls1)
    {
        this(pdpheaderlistview);
    }

    private void a()
    {
        e = true;
        f = false;
        g = -1;
    }

    private void a(int i1)
    {
        e = false;
        b(i1);
        PDPHeaderListView.c(a).requestLayout();
        g = i1;
    }

    private void a(int i1, int j1)
    {
        boolean flag1 = false;
        if (c > 0)
        {
            boolean flag;
            if (i1 >= j1)
            {
                i1 = PDPHeaderListView.b(a).getChildAt(i1 - j1).getMeasuredHeight();
            } else
            {
                i1 = 0;
            }
            h = i1;
        }
        j = PDPHeaderListView.c(a).getChildAt(0);
        if (j != null)
        {
            i1 = j.getMeasuredHeight();
        } else
        {
            i1 = PDPHeaderListView.c(a).getHeight();
        }
        i = i1;
        if (c < 0)
        {
            if (g != d - 1)
            {
                b(Math.max(0, d - 1));
                k = PDPHeaderListView.c(a).getChildAt(0);
            }
            if (PDPHeaderListView.c(a).getChildCount() > 0)
            {
                i1 = PDPHeaderListView.c(a).getChildAt(0).getMeasuredHeight();
            } else
            {
                i1 = 0;
            }
            h = i1;
            PDPHeaderListView.c(a).scrollTo(0, i);
        }
        flag = flag1;
        if (j != null)
        {
            flag = flag1;
            if (i > 0)
            {
                flag = flag1;
                if (h > 0)
                {
                    flag = true;
                }
            }
        }
        f = flag;
    }

    private int b(int i1, int j1)
    {
        int k1 = 0;
        if (j1 == 0)
        {
            return -1;
        }
        for (int l1 = PDPHeaderListView.b(a).getChildAt(0).getTop(); k1 < j1 && l1 < PDPHeaderListView.c(a).getHeight(); k1++)
        {
            l1 += PDPHeaderListView.b(a).getChildAt(k1).getHeight();
        }

        return Math.max(i1, (i1 + k1) - 1);
    }

    private void b()
    {
        int j1;
        int k1;
        int l1;
label0:
        {
            if (PDPHeaderListView.c(a) != null && PDPHeaderListView.b(a) != null && PDPHeaderListView.d(a) != null)
            {
                j1 = PDPHeaderListView.b(a).computeVerticalScrollOffset();
                k1 = PDPHeaderListView.b(a).computeVerticalScrollRange();
                l1 = PDPHeaderListView.b(a).computeVerticalScrollExtent();
                FrameLayout framelayout = PDPHeaderListView.d(a);
                byte byte0;
                if (l1 >= k1)
                {
                    byte0 = 4;
                } else
                {
                    byte0 = 0;
                }
                framelayout.setVisibility(byte0);
                if (l1 < k1)
                {
                    break label0;
                }
            }
            return;
        }
        int i1;
        if (k1 == 0)
        {
            i1 = PDPHeaderListView.b(a).getHeight();
        } else
        {
            i1 = (PDPHeaderListView.b(a).getHeight() * j1) / k1;
        }
        if (k1 == 0)
        {
            j1 = 0;
        } else
        {
            j1 = PDPHeaderListView.b(a).getHeight() - ((j1 + l1) * PDPHeaderListView.b(a).getHeight()) / k1;
        }
        PDPHeaderListView.d(a).setPadding(0, i1, 0, j1);
        l.reset();
        l.setFillBefore(true);
        l.setFillAfter(true);
        l.setStartOffset(1000L);
        l.setDuration(2000L);
        PDPHeaderListView.d(a).clearAnimation();
        PDPHeaderListView.d(a).startAnimation(l);
    }

    private void b(int i1)
    {
        if (PDPHeaderListView.c(a).getChildAt(0) != null)
        {
            PDPHeaderListView.c(a).removeViewAt(0);
        }
        if (PDPHeaderListView.a(a).b(i1))
        {
            View view = PDPHeaderListView.a(a).a(i1, null, null);
            view.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -2));
            view.measure(android.view.View.MeasureSpec.makeMeasureSpec(PDPHeaderListView.c(a).getWidth(), 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
            PDPHeaderListView.c(a).getLayoutParams().height = view.getMeasuredHeight();
            view.scrollTo(0, 0);
            PDPHeaderListView.c(a).scrollTo(0, 0);
            PDPHeaderListView.c(a).addView(view, 0);
        } else
        {
            PDPHeaderListView.c(a).getLayoutParams().height = 0;
            PDPHeaderListView.c(a).scrollTo(0, 0);
        }
        PDPHeaderListView.d(a).bringToFront();
    }

    public void onScroll(AbsListView abslistview, int i1, int j1, int k1)
    {
        if (n)
        {
            int l1 = i1 - PDPHeaderListView.b(a).getHeaderViewsCount();
            if (l1 < 0)
            {
                PDPHeaderListView.c(a).removeAllViews();
                return;
            }
            b();
            if (j1 > 0 && l1 == 0 && PDPHeaderListView.c(a).getChildAt(0) == null)
            {
                b(0);
                g = 0;
            }
            int i2 = b(l1, j1);
            if (k1 > 0 && b != i2)
            {
                c = i2 - b;
                d = PDPHeaderListView.a(a).e(i2);
                boolean flag = PDPHeaderListView.a(a).g(i2);
                boolean flag1 = PDPHeaderListView.a(a).b(d - 1);
                boolean flag2 = PDPHeaderListView.a(a).b(d + 1);
                boolean flag3 = PDPHeaderListView.a(a).b(d);
                if (PDPHeaderListView.a(a).f(i2) == PDPHeaderListView.a(a).a(d) - 1)
                {
                    j1 = 1;
                } else
                {
                    j1 = 0;
                }
                if (PDPHeaderListView.a(a).a(d - 1) > 0)
                {
                    i1 = 1;
                } else
                {
                    i1 = 0;
                }
                if (PDPHeaderListView.a(a).f(i2) == 0)
                {
                    k1 = 1;
                } else
                {
                    k1 = 0;
                }
                if (k1 != 0 && !flag3 && flag1 && i2 != l1)
                {
                    k1 = 1;
                } else
                {
                    k1 = 0;
                }
                if (j1 != 0 && flag3 && !flag2 && i2 == l1 && Math.abs(PDPHeaderListView.b(a).getChildAt(0).getTop()) >= PDPHeaderListView.b(a).getChildAt(0).getHeight() / 2)
                {
                    j1 = 1;
                } else
                {
                    j1 = 0;
                }
                m = false;
                if (flag && !flag1 && l1 >= 0)
                {
                    int j2;
                    if (c < 0)
                    {
                        i1 = d - 1;
                    } else
                    {
                        i1 = d;
                    }
                    a(i1);
                } else
                if (flag && l1 > 0 || k1 != 0)
                {
                    if (i1 == 0)
                    {
                        a(d - 1);
                    }
                    a();
                } else
                if (j1 != 0)
                {
                    m = true;
                } else
                if (g != d)
                {
                    a(d);
                }
                b = i2;
            }
            if (e)
            {
                if (i2 >= l1)
                {
                    i1 = PDPHeaderListView.b(a).getChildAt(i2 - l1).getTop();
                } else
                {
                    i1 = 0;
                }
                if (!f)
                {
                    a(i2, l1);
                }
                if (f)
                {
                    k1 = i;
                    l1 = h;
                    i2 = c;
                    j2 = Math.abs(i1);
                    if (c < 0)
                    {
                        j1 = h;
                    } else
                    {
                        j1 = i;
                    }
                    k1 = (j2 * ((k1 - l1) * i2)) / j1;
                    if (c > 0)
                    {
                        j1 = h;
                    } else
                    {
                        j1 = i;
                    }
                    j1 += k1;
                } else
                {
                    j1 = 0;
                }
                PDPHeaderListView.c(a).scrollTo(0, -Math.min(0, i1 - j1));
                if (f && j1 != PDPHeaderListView.c(a).getLayoutParams().height)
                {
                    if (c < 0)
                    {
                        abslistview = k.getLayoutParams();
                    } else
                    {
                        abslistview = j.getLayoutParams();
                    }
                    abslistview = (android.widget.RelativeLayout.LayoutParams)(android.widget.RelativeLayout.LayoutParams)abslistview;
                    abslistview.topMargin = j1 - ((android.widget.RelativeLayout.LayoutParams) (abslistview)).height;
                    PDPHeaderListView.c(a).getLayoutParams().height = j1;
                    PDPHeaderListView.c(a).requestLayout();
                }
            }
            if (m)
            {
                if (g != d)
                {
                    b(d);
                    g = d + 1;
                }
                PDPHeaderListView.c(a).scrollTo(0, PDPHeaderListView.c(a).getLayoutParams().height - (PDPHeaderListView.b(a).getChildAt(0).getHeight() + PDPHeaderListView.b(a).getChildAt(0).getTop()));
                return;
            }
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i1)
    {
        n = true;
    }
}
