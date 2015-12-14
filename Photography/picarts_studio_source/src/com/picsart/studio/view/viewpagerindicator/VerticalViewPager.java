// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view.viewpagerindicator;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Referenced classes of package com.picsart.studio.view.viewpagerindicator:
//            i, f, g, e, 
//            h

public class VerticalViewPager extends ViewGroup
{

    private static final i ad = new i();
    private static final int n[] = {
        0x10100b3
    };
    private static final Comparator p = new Comparator() {

        public final volatile int compare(Object obj, Object obj1)
        {
            obj = (f)obj;
            obj1 = (f)obj1;
            return ((f) (obj)).b - ((f) (obj1)).b;
        }

    };
    private static final Interpolator q = new Interpolator() {

        public final float getInterpolation(float f1)
        {
            f1--;
            return f1 * (f1 * f1 * f1 * f1) + 1.0F;
        }

    };
    private Drawable A;
    private int B;
    private int C;
    private int D;
    private boolean E;
    private boolean F;
    private int G;
    private boolean H;
    private int I;
    private int J;
    private int K;
    private float L;
    private float M;
    private int N;
    private int O;
    private int P;
    private EdgeEffectCompat Q;
    private EdgeEffectCompat R;
    private boolean S;
    private boolean T;
    private int U;
    private android.support.v4.view.ViewPager.OnPageChangeListener V;
    private android.support.v4.view.ViewPager.PageTransformer W;
    final ArrayList a;
    private Method aa;
    private int ab;
    private ArrayList ac;
    private final Runnable ae;
    private int af;
    PagerAdapter b;
    float c;
    float d;
    boolean e;
    boolean f;
    float g;
    float h;
    int i;
    VelocityTracker j;
    int k;
    boolean l;
    long m;
    private int o;
    private final f r;
    private final Rect s;
    private int t;
    private int u;
    private Parcelable v;
    private ClassLoader w;
    private Scroller x;
    private h y;
    private int z;

    public VerticalViewPager(Context context)
    {
        super(context);
        a = new ArrayList();
        r = new f();
        s = new Rect();
        u = -1;
        v = null;
        w = null;
        c = -3.402823E+38F;
        d = 3.402823E+38F;
        G = 1;
        i = -1;
        S = true;
        ae = new Runnable() {

            private VerticalViewPager a;

            public final void run()
            {
                VerticalViewPager.a(a);
                a.c();
            }

            
            {
                a = VerticalViewPager.this;
                super();
            }
        };
        af = 0;
        g();
    }

    public VerticalViewPager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = new ArrayList();
        r = new f();
        s = new Rect();
        u = -1;
        v = null;
        w = null;
        c = -3.402823E+38F;
        d = 3.402823E+38F;
        G = 1;
        i = -1;
        S = true;
        ae = new _cls3();
        af = 0;
        g();
    }

    private Rect a(Rect rect, View view)
    {
        if (rect == null)
        {
            rect = new Rect();
        }
        if (view == null)
        {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        for (view = view.getParent(); (view instanceof ViewGroup) && view != this; view = view.getParent())
        {
            view = (ViewGroup)view;
            rect.left = rect.left + view.getLeft();
            rect.right = rect.right + view.getRight();
            rect.top = rect.top + view.getTop();
            rect.bottom = rect.bottom + view.getBottom();
        }

        return rect;
    }

    private f a(int i1, int j1)
    {
        f f1 = new f();
        f1.b = i1;
        f1.a = b.instantiateItem(this, i1);
        f1.d = b.getPageWidth(i1);
        if (j1 < 0 || j1 >= a.size())
        {
            a.add(f1);
            return f1;
        } else
        {
            a.add(j1, f1);
            return f1;
        }
    }

    private f a(View view)
    {
        for (int i1 = 0; i1 < a.size(); i1++)
        {
            f f1 = (f)a.get(i1);
            if (b.isViewFromObject(view, f1.a))
            {
                return f1;
            }
        }

        return null;
    }

    private void a(int i1, float f1, int j1)
    {
        if (U <= 0) goto _L2; else goto _L1
_L1:
        int k1;
        int l1;
        int l2;
        int i3;
        int j3;
        int k3;
        i3 = getScrollY();
        k1 = getPaddingTop();
        l1 = getPaddingBottom();
        j3 = getHeight();
        k3 = getChildCount();
        l2 = 0;
_L8:
        if (l2 >= k3) goto _L2; else goto _L3
_L3:
        View view;
        LayoutParams layoutparams;
        view = getChildAt(l2);
        layoutparams = (LayoutParams)view.getLayoutParams();
        if (!layoutparams.a)
        {
            break MISSING_BLOCK_LABEL_395;
        }
        layoutparams.b & 0x70;
        JVM INSTR lookupswitch 3: default 116
    //                   16: 219
    //                   48: 190
    //                   80: 251;
           goto _L4 _L5 _L6 _L7
_L4:
        int i2;
        i2 = k1;
        int j2 = l1;
        l1 = k1;
        k1 = j2;
_L9:
        int k2;
        int l3 = (i2 + i3) - view.getTop();
        i2 = k1;
        k2 = l1;
        if (l3 != 0)
        {
            view.offsetTopAndBottom(l3);
            k2 = l1;
            i2 = k1;
        }
_L10:
        l2++;
        k1 = k2;
        l1 = i2;
          goto _L8
_L6:
        i2 = view.getHeight();
        k2 = i2 + k1;
        i2 = k1;
        k1 = l1;
        l1 = k2;
          goto _L9
_L5:
        i2 = Math.max((j3 - view.getMeasuredHeight()) / 2, k1);
        k2 = k1;
        k1 = l1;
        l1 = k2;
          goto _L9
_L7:
        i2 = j3 - l1 - view.getMeasuredHeight();
        int i4 = view.getMeasuredHeight();
        k2 = k1;
        k1 = l1 + i4;
        l1 = k2;
          goto _L9
_L2:
        if (V != null)
        {
            V.onPageScrolled(i1, f1, j1);
        }
        if (W != null)
        {
            j1 = getScrollY();
            k1 = getChildCount();
            for (i1 = 0; i1 < k1; i1++)
            {
                View view1 = getChildAt(i1);
                if (!((LayoutParams)view1.getLayoutParams()).a)
                {
                    f1 = (float)(view1.getTop() - j1) / (float)a();
                    W.transformPage(view1, f1);
                }
            }

        }
        T = true;
        return;
        i2 = l1;
        k2 = k1;
          goto _L10
    }

    private void a(int i1, int j1, int k1, int l1)
    {
        if (j1 > 0 && !a.isEmpty())
        {
            int i2 = getPaddingTop();
            int j2 = getPaddingBottom();
            int k2 = getPaddingTop();
            int l2 = getPaddingBottom();
            float f1 = (float)getScrollY() / (float)((j1 - k2 - l2) + l1);
            j1 = (int)((float)((i1 - i2 - j2) + k1) * f1);
            scrollTo(getScrollX(), j1);
            if (!x.isFinished())
            {
                k1 = x.getDuration();
                l1 = x.timePassed();
                f f3 = e(t);
                x.startScroll(0, j1, 0, (int)(f3.e * (float)i1), k1 - l1);
            }
        } else
        {
            f f4 = e(t);
            float f2;
            if (f4 != null)
            {
                f2 = Math.min(f4.e, d);
            } else
            {
                f2 = 0.0F;
            }
            i1 = (int)(f2 * (float)(i1 - getPaddingTop() - getPaddingBottom()));
            if (i1 != getScrollY())
            {
                a(false);
                scrollTo(getScrollX(), i1);
                return;
            }
        }
    }

    private void a(int i1, boolean flag, int j1, boolean flag1)
    {
        f f6 = e(i1);
        int k1 = 0;
        if (f6 != null)
        {
            k1 = (int)((float)a() * Math.max(c, Math.min(f6.e, d)));
        }
        if (flag)
        {
            if (getChildCount() == 0)
            {
                b(false);
            } else
            {
                int l1 = getScrollX();
                int i2 = getScrollY();
                int j2 = 0 - l1;
                k1 -= i2;
                if (j2 == 0 && k1 == 0)
                {
                    a(false);
                    c();
                    a(0);
                } else
                {
                    b(true);
                    a(2);
                    int k2 = a();
                    int l2 = k2 / 2;
                    float f5 = Math.min(1.0F, (1.0F * (float)Math.abs(j2)) / (float)k2);
                    float f1 = l2;
                    float f3 = l2;
                    f5 = (float)Math.sin((float)((double)(f5 - 0.5F) * 0.4712389167638204D));
                    j1 = Math.abs(j1);
                    if (j1 > 0)
                    {
                        j1 = Math.round(1000F * Math.abs((f3 * f5 + f1) / (float)j1)) * 4;
                    } else
                    {
                        float f2 = k2;
                        float f4 = b.getPageWidth(t);
                        j1 = (int)(((float)Math.abs(j2) / (f2 * f4 + (float)z) + 1.0F) * 100F);
                    }
                    j1 = Math.min(j1, 600);
                    x.startScroll(l1, i2, j2, k1, j1);
                    ViewCompat.postInvalidateOnAnimation(this);
                }
            }
        } else
        {
            if (flag1 && V != null)
            {
                V.onPageSelected(i1);
            }
            a(false);
            scrollTo(0, k1);
            b(k1);
            return;
        }
        if (flag1 && V != null)
        {
            V.onPageSelected(i1);
        }
        if (!flag1);
    }

    private void a(int i1, boolean flag, boolean flag1)
    {
        a(i1, flag, flag1, 0);
    }

    private void a(MotionEvent motionevent)
    {
        int i1 = MotionEventCompat.getActionIndex(motionevent);
        if (MotionEventCompat.getPointerId(motionevent, i1) == i)
        {
            if (i1 == 0)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            g = MotionEventCompat.getY(motionevent, i1);
            i = MotionEventCompat.getPointerId(motionevent, i1);
            if (j != null)
            {
                j.clear();
            }
        }
    }

    static void a(VerticalViewPager verticalviewpager)
    {
        verticalviewpager.a(0);
    }

    private void a(f f1, int i1, f f2)
    {
        int j2 = b.getCount();
        int j1 = a();
        float f6;
        if (j1 > 0)
        {
            f6 = (float)z / (float)j1;
        } else
        {
            f6 = 0.0F;
        }
        if (f2 != null)
        {
            j1 = f2.b;
            if (j1 < f1.b)
            {
                float f3 = f2.e;
                float f7 = f2.d;
                int k1 = 0;
                f3 = f3 + f7 + f6;
                for (j1++; j1 <= f1.b && k1 < a.size(); j1++)
                {
                    for (f2 = (f)a.get(k1); j1 > f2.b && k1 < a.size() - 1; f2 = (f)a.get(k1))
                    {
                        k1++;
                    }

                    while (j1 < f2.b) 
                    {
                        float f8 = b.getPageWidth(j1);
                        j1++;
                        f3 = f8 + f6 + f3;
                    }
                    f2.e = f3;
                    f3 += f2.d + f6;
                }

            } else
            if (j1 > f1.b)
            {
                int l1 = a.size();
                float f4 = f2.e;
                l1--;
                for (j1--; j1 >= f1.b && l1 >= 0; j1--)
                {
                    for (f2 = (f)a.get(l1); j1 < f2.b && l1 > 0; f2 = (f)a.get(l1))
                    {
                        l1--;
                    }

                    while (j1 > f2.b) 
                    {
                        float f9 = b.getPageWidth(j1);
                        j1--;
                        f4 -= f9 + f6;
                    }
                    f4 -= f2.d + f6;
                    f2.e = f4;
                }

            }
        }
        int k2 = a.size();
        float f10 = f1.e;
        j1 = f1.b - 1;
        float f5;
        int i2;
        if (f1.b == 0)
        {
            f5 = f1.e;
        } else
        {
            f5 = -3.402823E+38F;
        }
        c = f5;
        if (f1.b == j2 - 1)
        {
            f5 = (f1.e + f1.d) - 1.0F;
        } else
        {
            f5 = 3.402823E+38F;
        }
        d = f5;
        i2 = i1 - 1;
        f5 = f10;
        for (; i2 >= 0; i2--)
        {
            for (f2 = (f)a.get(i2); j1 > f2.b; j1--)
            {
                f5 -= b.getPageWidth(j1) + f6;
            }

            f5 -= f2.d + f6;
            f2.e = f5;
            if (f2.b == 0)
            {
                c = f5;
            }
            j1--;
        }

        f5 = f1.e + f1.d + f6;
        i2 = f1.b + 1;
        j1 = i1 + 1;
        i1 = i2;
        for (; j1 < k2; j1++)
        {
            for (f1 = (f)a.get(j1); i1 < f1.b; i1++)
            {
                f5 += b.getPageWidth(i1) + f6;
            }

            if (f1.b == j2 - 1)
            {
                d = (f1.d + f5) - 1.0F;
            }
            f1.e = f5;
            f5 += f1.d + f6;
            i1++;
        }

    }

    private void a(boolean flag)
    {
label0:
        {
            int i1;
            boolean flag1;
            boolean flag2;
            if (af == 2)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            if (i1 != 0)
            {
                b(false);
                x.abortAnimation();
                int j1 = getScrollX();
                int k1 = getScrollY();
                int l1 = x.getCurrX();
                int i2 = x.getCurrY();
                if (j1 != l1 || k1 != i2)
                {
                    scrollTo(l1, i2);
                }
            }
            e = false;
            flag2 = false;
            flag1 = i1;
            for (i1 = ((flag2) ? 1 : 0); i1 < a.size(); i1++)
            {
                f f1 = (f)a.get(i1);
                if (f1.c)
                {
                    f1.c = false;
                    flag1 = true;
                }
            }

            if (flag1)
            {
                if (!flag)
                {
                    break label0;
                }
                ViewCompat.postOnAnimation(this, ae);
            }
            return;
        }
        ae.run();
    }

    private boolean a(float f1)
    {
        boolean flag1 = true;
        boolean flag3 = false;
        boolean flag2 = false;
        float f2 = g;
        g = f1;
        float f3 = (float)getScrollY() + (f2 - f1);
        int i1 = a();
        f1 = (float)i1 * c;
        f2 = i1;
        float f4 = d;
        f f5 = (f)a.get(0);
        f f6 = (f)a.get(a.size() - 1);
        boolean flag;
        if (f5.b != 0)
        {
            f1 = f5.e * (float)i1;
            flag = false;
        } else
        {
            flag = true;
        }
        if (f6.b != b.getCount() - 1)
        {
            f2 = f6.e * (float)i1;
            flag1 = false;
        } else
        {
            f2 *= f4;
        }
        if (f3 >= f1) goto _L2; else goto _L1
_L1:
        f2 = f1;
        if (flag)
        {
            flag2 = Q.onPull(Math.abs(f1 - f3) / (float)i1);
            f2 = f1;
        }
_L4:
        L = L + (f2 - (float)(int)f2);
        scrollTo(getScrollX(), (int)f2);
        b((int)f2);
        return flag2;
_L2:
        if (f3 > f2)
        {
            flag2 = flag3;
            if (flag1)
            {
                flag2 = R.onPull(Math.abs(f3 - f2) / (float)i1);
            }
        } else
        {
            f2 = f3;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private boolean a(View view, boolean flag, int i1, int j1, int k1)
    {
        if (!(view instanceof ViewGroup)) goto _L2; else goto _L1
_L1:
        ViewGroup viewgroup;
        int l1;
        int i2;
        int j2;
        viewgroup = (ViewGroup)view;
        i2 = view.getScrollX();
        j2 = view.getScrollY();
        l1 = viewgroup.getChildCount() - 1;
_L8:
        if (l1 < 0) goto _L2; else goto _L3
_L3:
        View view1 = viewgroup.getChildAt(l1);
        if (k1 + j2 < view1.getTop() || k1 + j2 >= view1.getBottom() || j1 + i2 < view1.getLeft() || j1 + i2 >= view1.getRight() || !a(view1, true, i1, (j1 + i2) - view1.getLeft(), (k1 + j2) - view1.getTop())) goto _L5; else goto _L4
_L4:
        return true;
_L5:
        l1--;
        continue; /* Loop/switch isn't completed */
_L2:
        if (flag && ViewCompat.canScrollVertically(view, -i1)) goto _L4; else goto _L6
_L6:
        return false;
        if (true) goto _L8; else goto _L7
_L7:
    }

    static PagerAdapter b(VerticalViewPager verticalviewpager)
    {
        return verticalviewpager.b;
    }

    private f b(View view)
    {
        do
        {
            ViewParent viewparent = view.getParent();
            if (viewparent != this)
            {
                if (viewparent == null || !(viewparent instanceof View))
                {
                    return null;
                }
                view = (View)viewparent;
            } else
            {
                return a(view);
            }
        } while (true);
    }

    private void b(boolean flag)
    {
        if (F != flag)
        {
            F = flag;
        }
    }

    static int c(VerticalViewPager verticalviewpager)
    {
        return verticalviewpager.t;
    }

    private void d(int i1)
    {
        float f1;
        float f5;
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        int j1;
        char c2;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        if (t != i1)
        {
            char c1;
            if (t < i1)
            {
                c1 = '\202';
            } else
            {
                c1 = '!';
            }
            obj1 = e(t);
            t = i1;
            c2 = c1;
        } else
        {
            obj1 = null;
            c2 = '\002';
        }
        if (b != null) goto _L2; else goto _L1
_L1:
        h();
_L4:
        return;
_L2:
        if (e)
        {
            h();
            return;
        }
        if (getWindowToken() == null) goto _L4; else goto _L3
_L3:
        b.startUpdate(this);
        i1 = G;
        j3 = Math.max(0, t - i1);
        l2 = b.getCount();
        i3 = Math.min(l2 - 1, i1 + t);
        if (l2 != o)
        {
            String s1;
            try
            {
                s1 = getResources().getResourceName(getId());
            }
            catch (android.content.res.Resources.NotFoundException notfoundexception)
            {
                notfoundexception = Integer.toHexString(getId());
            }
            throw new IllegalStateException((new StringBuilder("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ")).append(o).append(", found: ").append(l2).append(" Pager id: ").append(s1).append(" Pager class: ").append(getClass()).append(" Problematic adapter: ").append(b.getClass()).toString());
        }
        i1 = 0;
_L14:
        if (i1 >= a.size())
        {
            break MISSING_BLOCK_LABEL_1271;
        }
        obj = (f)a.get(i1);
        if (((f) (obj)).b < t) goto _L6; else goto _L5
_L5:
        if (((f) (obj)).b != t)
        {
            break MISSING_BLOCK_LABEL_1271;
        }
_L21:
        if (obj == null && l2 > 0)
        {
            obj2 = a(t, i1);
        } else
        {
            obj2 = obj;
        }
        if (obj2 == null) goto _L8; else goto _L7
_L7:
        k2 = i1 - 1;
        float f3;
        if (k2 >= 0)
        {
            obj = (f)a.get(k2);
        } else
        {
            obj = null;
        }
        k3 = a();
        if (k3 <= 0)
        {
            f3 = 0.0F;
        } else
        {
            f3 = (2.0F - ((f) (obj2)).d) + (float)getPaddingLeft() / (float)k3;
        }
        j1 = t;
        f5 = 0.0F;
        j2 = j1 - 1;
        i2 = i1;
        obj3 = obj;
        if (j2 < 0) goto _L10; else goto _L9
_L9:
        if (f5 < f3 || j2 >= j3) goto _L12; else goto _L11
_L11:
        if (obj3 == null) goto _L10; else goto _L13
_L13:
        obj = obj3;
        i1 = k2;
        f1 = f5;
        j1 = i2;
        if (j2 == ((f) (obj3)).b)
        {
            obj = obj3;
            i1 = k2;
            f1 = f5;
            j1 = i2;
            if (!((f) (obj3)).c)
            {
                a.remove(k2);
                b.destroyItem(this, j2, ((f) (obj3)).a);
                i1 = k2 - 1;
                j1 = i2 - 1;
                if (i1 >= 0)
                {
                    obj = (f)a.get(i1);
                    f1 = f5;
                } else
                {
                    obj = null;
                    f1 = f5;
                }
            }
        }
_L15:
        j2--;
        obj3 = obj;
        k2 = i1;
        f5 = f1;
        i2 = j1;
        break MISSING_BLOCK_LABEL_377;
_L6:
        i1++;
          goto _L14
_L12:
        if (obj3 != null && j2 == ((f) (obj3)).b)
        {
            f1 = f5 + ((f) (obj3)).d;
            i1 = k2 - 1;
            if (i1 >= 0)
            {
                obj = (f)a.get(i1);
                j1 = i2;
            } else
            {
                obj = null;
                j1 = i2;
            }
        } else
        {
            f1 = f5 + a(j2, k2 + 1).d;
            j1 = i2 + 1;
            if (k2 >= 0)
            {
                obj = (f)a.get(k2);
                i1 = k2;
            } else
            {
                obj = null;
                i1 = k2;
            }
        }
          goto _L15
_L10:
label0:
        {
            float f2 = ((f) (obj2)).d;
            i1 = i2 + 1;
            if (f2 >= 2.0F)
            {
                break label0;
            }
            float f4;
            int k1;
            if (i1 < a.size())
            {
                obj = (f)a.get(i1);
            } else
            {
                obj = null;
            }
            if (k3 <= 0)
            {
                f4 = 0.0F;
            } else
            {
                f4 = (float)getPaddingRight() / (float)k3 + 2.0F;
            }
            k1 = t;
            k1++;
            do
            {
                if (k1 >= l2)
                {
                    break label0;
                }
                if (f2 >= f4 && k1 > i3)
                {
                    if (obj == null)
                    {
                        break label0;
                    }
                    if (k1 == ((f) (obj)).b && !((f) (obj)).c)
                    {
                        a.remove(i1);
                        b.destroyItem(this, k1, ((f) (obj)).a);
                        if (i1 < a.size())
                        {
                            obj = (f)a.get(i1);
                        } else
                        {
                            obj = null;
                        }
                    }
                } else
                if (obj != null && k1 == ((f) (obj)).b)
                {
                    float f6 = ((f) (obj)).d;
                    i1++;
                    if (i1 < a.size())
                    {
                        obj = (f)a.get(i1);
                    } else
                    {
                        obj = null;
                    }
                    f2 += f6;
                } else
                {
                    obj = a(k1, i1);
                    i1++;
                    float f7 = ((f) (obj)).d;
                    if (i1 < a.size())
                    {
                        obj = (f)a.get(i1);
                    } else
                    {
                        obj = null;
                    }
                    f2 += f7;
                }
                k1++;
            } while (true);
        }
        a(((f) (obj2)), i2, ((f) (obj1)));
_L8:
        obj1 = b;
        i1 = t;
        int l1;
        if (obj2 != null)
        {
            obj = ((f) (obj2)).a;
        } else
        {
            obj = null;
        }
        ((PagerAdapter) (obj1)).setPrimaryItem(this, i1, obj);
        b.finishUpdate(this);
        l1 = getChildCount();
        for (i1 = 0; i1 < l1; i1++)
        {
            obj1 = getChildAt(i1);
            obj = (LayoutParams)((View) (obj1)).getLayoutParams();
            obj.f = i1;
            if (((LayoutParams) (obj)).a || ((LayoutParams) (obj)).c != 0.0F)
            {
                continue;
            }
            obj1 = a(((View) (obj1)));
            if (obj1 != null)
            {
                obj.c = ((f) (obj1)).d;
                obj.e = ((f) (obj1)).b;
            }
        }

        h();
        if (!hasFocus()) goto _L4; else goto _L16
_L16:
        obj = findFocus();
        if (obj != null)
        {
            obj = b(((View) (obj)));
        } else
        {
            obj = null;
        }
        if (obj != null && ((f) (obj)).b == t) goto _L4; else goto _L17
_L17:
        i1 = 0;
_L20:
        if (i1 >= getChildCount()) goto _L4; else goto _L18
_L18:
        obj = getChildAt(i1);
        obj1 = a(((View) (obj)));
        if (obj1 != null && ((f) (obj1)).b == t && ((View) (obj)).requestFocus(c2)) goto _L4; else goto _L19
_L19:
        i1++;
          goto _L20
        obj = null;
          goto _L21
    }

    private f e(int i1)
    {
        for (int j1 = 0; j1 < a.size(); j1++)
        {
            f f1 = (f)a.get(j1);
            if (f1.b == i1)
            {
                return f1;
            }
        }

        return null;
    }

    private boolean f(int i1)
    {
        View view = findFocus();
        if (view != this) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L13:
        view = FocusFinder.getInstance().findNextFocus(this, ((View) (obj)), i1);
        if (view == null || view == obj) goto _L4; else goto _L3
_L3:
        if (i1 != 33) goto _L6; else goto _L5
_L5:
        int j1;
        boolean flag;
        j1 = a(s, view).top;
        int k1 = a(s, ((View) (obj))).top;
        StringBuilder stringbuilder;
        if (obj != null && j1 >= k1)
        {
            flag = j();
        } else
        {
            flag = view.requestFocus();
        }
_L18:
        if (flag)
        {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i1));
        }
        return flag;
_L2:
        if (view == null) goto _L8; else goto _L7
_L7:
        obj = view.getParent();
_L12:
        if (!(obj instanceof ViewGroup))
        {
            break MISSING_BLOCK_LABEL_349;
        }
        if (obj != this) goto _L10; else goto _L9
_L9:
        j1 = 1;
_L19:
        if (j1 != 0) goto _L8; else goto _L11
_L10:
        obj = ((ViewParent) (obj)).getParent();
          goto _L12
_L11:
        stringbuilder = new StringBuilder();
        stringbuilder.append(view.getClass().getSimpleName());
        for (obj = view.getParent(); obj instanceof ViewGroup; obj = ((ViewParent) (obj)).getParent())
        {
            stringbuilder.append(" => ").append(obj.getClass().getSimpleName());
        }

        Log.e("VerticalViewPager", (new StringBuilder("arrowScroll tried to find focus based on non-child current focused view ")).append(stringbuilder.toString()).toString());
        obj = null;
          goto _L13
_L6:
        if (i1 != 130) goto _L15; else goto _L14
_L14:
        int l1;
        j1 = a(s, view).bottom;
        l1 = a(s, ((View) (obj))).bottom;
        if (obj != null && j1 <= l1) goto _L17; else goto _L16
_L16:
        flag = view.requestFocus();
          goto _L18
_L4:
label0:
        {
            if (i1 != 33 && i1 != 1)
            {
                break label0;
            }
            flag = j();
        }
          goto _L18
        if (i1 != 130 && i1 != 2) goto _L15; else goto _L17
_L17:
        flag = k();
          goto _L18
_L15:
        flag = false;
          goto _L18
_L8:
        obj = view;
          goto _L13
        j1 = 0;
          goto _L19
    }

    static int[] f()
    {
        return n;
    }

    private void g()
    {
        setWillNotDraw(false);
        setDescendantFocusability(0x40000);
        setFocusable(true);
        Context context = getContext();
        x = new Scroller(context, q);
        ViewConfiguration viewconfiguration = ViewConfiguration.get(context);
        float f1 = context.getResources().getDisplayMetrics().density;
        K = ViewConfigurationCompat.getScaledPagingTouchSlop(viewconfiguration);
        N = (int)(400F * f1);
        k = viewconfiguration.getScaledMaximumFlingVelocity();
        Q = new EdgeEffectCompat(context);
        R = new EdgeEffectCompat(context);
        O = (int)(25F * f1);
        P = (int)(2.0F * f1);
        I = (int)(16F * f1);
        ViewCompat.setAccessibilityDelegate(this, new g(this));
        if (ViewCompat.getImportantForAccessibility(this) == 0)
        {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    private void h()
    {
        if (ab != 0)
        {
            int j1;
            if (ac == null)
            {
                ac = new ArrayList();
            } else
            {
                ac.clear();
            }
            j1 = getChildCount();
            for (int i1 = 0; i1 < j1; i1++)
            {
                View view = getChildAt(i1);
                ac.add(view);
            }

            Collections.sort(ac, ad);
        }
    }

    private void i()
    {
        ViewParent viewparent = getParent();
        if (viewparent != null)
        {
            viewparent.requestDisallowInterceptTouchEvent(true);
        }
    }

    private boolean j()
    {
        if (t > 0)
        {
            setCurrentItem(t - 1, true);
            return true;
        } else
        {
            return false;
        }
    }

    private boolean k()
    {
        if (b != null && t < b.getCount() - 1)
        {
            setCurrentItem(t + 1, true);
            return true;
        } else
        {
            return false;
        }
    }

    final int a()
    {
        return getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    }

    final int a(int i1, float f1, int j1, int k1)
    {
        if (Math.abs(k1) > O && Math.abs(j1) > N)
        {
            if (j1 <= 0)
            {
                i1++;
            }
        } else
        {
            float f2;
            if (i1 >= t)
            {
                f2 = 0.4F;
            } else
            {
                f2 = 0.6F;
            }
            i1 = (int)(f2 + ((float)i1 + f1));
        }
        j1 = i1;
        if (a.size() > 0)
        {
            f f3 = (f)a.get(0);
            f f4 = (f)a.get(a.size() - 1);
            j1 = Math.max(f3.b, Math.min(i1, f4.b));
        }
        return j1;
    }

    final void a(int i1)
    {
        if (af != i1)
        {
            af = i1;
            if (W != null)
            {
                boolean flag;
                int j1;
                int k1;
                if (i1 != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                k1 = getChildCount();
                j1 = 0;
                while (j1 < k1) 
                {
                    byte byte0;
                    if (flag)
                    {
                        byte0 = 2;
                    } else
                    {
                        byte0 = 0;
                    }
                    ViewCompat.setLayerType(getChildAt(j1), byte0, null);
                    j1++;
                }
            }
            if (V != null)
            {
                V.onPageScrollStateChanged(i1);
                return;
            }
        }
    }

    final void a(int i1, boolean flag, boolean flag1, int j1)
    {
        boolean flag2;
        flag2 = false;
        if (b == null || b.getCount() <= 0)
        {
            b(false);
            return;
        }
        if (!flag1 && t == i1 && a.size() != 0)
        {
            b(false);
            return;
        }
        if (i1 >= 0) goto _L2; else goto _L1
_L1:
        int k1 = 0;
_L4:
        i1 = G;
        if (k1 > t + i1 || k1 < t - i1)
        {
            for (i1 = 0; i1 < a.size(); i1++)
            {
                ((f)a.get(i1)).c = true;
            }

        }
        break; /* Loop/switch isn't completed */
_L2:
        k1 = i1;
        if (i1 >= b.getCount())
        {
            k1 = b.getCount() - 1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        flag1 = flag2;
        if (t != k1)
        {
            flag1 = true;
        }
        if (S)
        {
            t = k1;
            if (flag1 && V != null)
            {
                V.onPageSelected(k1);
            }
            requestLayout();
            return;
        } else
        {
            d(k1);
            a(k1, flag, j1, flag1);
            return;
        }
    }

    public void addFocusables(ArrayList arraylist, int i1, int j1)
    {
        int l1 = arraylist.size();
        int i2 = getDescendantFocusability();
        if (i2 != 0x60000)
        {
            for (int k1 = 0; k1 < getChildCount(); k1++)
            {
                View view = getChildAt(k1);
                if (view.getVisibility() == 0)
                {
                    f f1 = a(view);
                    if (f1 != null && f1.b == t)
                    {
                        view.addFocusables(arraylist, i1, j1);
                    }
                }
            }

        }
        while (i2 == 0x40000 && l1 != arraylist.size() || !isFocusable() || (j1 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode() || arraylist == null) 
        {
            return;
        }
        arraylist.add(this);
    }

    public void addTouchables(ArrayList arraylist)
    {
        for (int i1 = 0; i1 < getChildCount(); i1++)
        {
            View view = getChildAt(i1);
            if (view.getVisibility() != 0)
            {
                continue;
            }
            f f1 = a(view);
            if (f1 != null && f1.b == t)
            {
                view.addTouchables(arraylist);
            }
        }

    }

    public void addView(View view, int i1, android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (!checkLayoutParams(layoutparams))
        {
            layoutparams = generateLayoutParams(layoutparams);
        }
        LayoutParams layoutparams1 = (LayoutParams)layoutparams;
        layoutparams1.a = layoutparams1.a | (view instanceof e);
        if (E)
        {
            if (layoutparams1 != null && layoutparams1.a)
            {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            } else
            {
                layoutparams1.d = true;
                addViewInLayout(view, i1, layoutparams);
                return;
            }
        } else
        {
            super.addView(view, i1, layoutparams);
            return;
        }
    }

    final void b()
    {
        Object obj;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int l2 = b.getCount();
        o = l2;
        int j2;
        if (a.size() < G * 2 + 1 && a.size() < l2)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        j1 = t;
        k1 = 0;
        i2 = 0;
        l1 = i1;
        i1 = j1;
        j1 = k1;
        k1 = i2;
        if (k1 >= a.size())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (f)a.get(k1);
        i2 = b.getItemPosition(((f) (obj)).a);
        if (i2 == -1)
        {
            break MISSING_BLOCK_LABEL_369;
        }
        if (i2 == -2)
        {
            a.remove(k1);
            l1 = k1 - 1;
            k1 = j1;
            if (j1 == 0)
            {
                b.startUpdate(this);
                k1 = 1;
            }
            b.destroyItem(this, ((f) (obj)).b, ((f) (obj)).a);
            int k2;
            if (t == ((f) (obj)).b)
            {
                j1 = Math.max(0, Math.min(t, l2 - 1));
                i1 = k1;
                k1 = 1;
            } else
            {
                j1 = i1;
                boolean flag = true;
                i1 = k1;
                k1 = ((flag) ? 1 : 0);
            }
        } else
        {
            if (((f) (obj)).b == i2)
            {
                break MISSING_BLOCK_LABEL_369;
            }
            if (((f) (obj)).b == t)
            {
                i1 = i2;
            }
            obj.b = i2;
            i2 = i1;
            k2 = 1;
            l1 = k1;
            i1 = j1;
            j1 = i2;
            k1 = k2;
        }
        i2 = k1;
        j2 = j1;
        k1 = l1 + 1;
        j1 = i1;
        i1 = j2;
        l1 = i2;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_70;
_L1:
        if (j1 != 0)
        {
            b.finishUpdate(this);
        }
        Collections.sort(a, p);
        if (l1 != 0)
        {
            k1 = getChildCount();
            for (j1 = 0; j1 < k1; j1++)
            {
                obj = (LayoutParams)getChildAt(j1).getLayoutParams();
                if (!((LayoutParams) (obj)).a)
                {
                    obj.c = 0.0F;
                }
            }

            a(i1, false, true);
            requestLayout();
        }
        return;
        i2 = i1;
        k2 = l1;
        l1 = k1;
        i1 = j1;
        j1 = i2;
        k1 = k2;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_204;
        }
    }

    final boolean b(int i1)
    {
        boolean flag = false;
        if (a.size() == 0)
        {
            T = false;
            a(0, 0.0F, 0);
            if (!T)
            {
                throw new IllegalStateException("onPageScrolled did not call superclass implementation");
            }
        } else
        {
            f f2 = d();
            int k1 = a();
            int l1 = z;
            float f1 = (float)z / (float)k1;
            int j1 = f2.b;
            f1 = ((float)i1 / (float)k1 - f2.e) / (f2.d + f1);
            i1 = (int)((float)(l1 + k1) * f1);
            T = false;
            a(j1, f1, i1);
            if (!T)
            {
                throw new IllegalStateException("onPageScrolled did not call superclass implementation");
            }
            flag = true;
        }
        return flag;
    }

    final void c()
    {
        d(t);
    }

    public final boolean c(int i1)
    {
        if (b != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int j1;
        int k1;
        j1 = a();
        k1 = getScrollY();
        if (i1 >= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (k1 <= (int)((float)j1 * c)) goto _L1; else goto _L3
_L3:
        return true;
        if (i1 <= 0 || k1 >= (int)((float)j1 * d)) goto _L1; else goto _L4
_L4:
        return true;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return (layoutparams instanceof LayoutParams) && super.checkLayoutParams(layoutparams);
    }

    public void computeScroll()
    {
        if (!x.isFinished() && x.computeScrollOffset())
        {
            int i1 = getScrollX();
            int j1 = getScrollY();
            int k1 = x.getCurrX();
            int l1 = x.getCurrY();
            if (i1 != k1 || j1 != l1)
            {
                scrollTo(k1, l1);
                if (!b(l1))
                {
                    x.abortAnimation();
                    scrollTo(k1, 0);
                }
            }
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        } else
        {
            a(true);
            return;
        }
    }

    final f d()
    {
        int i1 = a();
        float f1;
        float f2;
        float f3;
        float f4;
        f f6;
        boolean flag;
        int j1;
        if (i1 > 0)
        {
            f1 = (float)getScrollY() / (float)i1;
        } else
        {
            f1 = 0.0F;
        }
        if (i1 > 0)
        {
            f2 = (float)z / (float)i1;
        } else
        {
            f2 = 0.0F;
        }
        f4 = 0.0F;
        f3 = 0.0F;
        j1 = -1;
        i1 = 0;
        flag = true;
        f6 = null;
        do
        {
            f f5;
label0:
            {
                f f7;
label1:
                {
                    f7 = f6;
                    if (i1 >= a.size())
                    {
                        break label1;
                    }
                    f5 = (f)a.get(i1);
                    if (!flag && f5.b != j1 + 1)
                    {
                        f5 = r;
                        f5.e = f4 + f3 + f2;
                        f5.b = j1 + 1;
                        f5.d = b.getPageWidth(f5.b);
                        i1--;
                    }
                    f3 = f5.e;
                    f4 = f5.d;
                    if (!flag)
                    {
                        f7 = f6;
                        if (f1 < f3)
                        {
                            break label1;
                        }
                    }
                    if (f1 >= f4 + f3 + f2 && i1 != a.size() - 1)
                    {
                        break label0;
                    }
                    f7 = f5;
                }
                return f7;
            }
            j1 = f5.b;
            f4 = f5.d;
            flag = false;
            i1++;
            f6 = f5;
        } while (true);
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        boolean flag1 = false;
        if (super.dispatchKeyEvent(keyevent)) goto _L2; else goto _L1
_L1:
        if (keyevent.getAction() != 0) goto _L4; else goto _L3
_L3:
        keyevent.getKeyCode();
        JVM INSTR lookupswitch 3: default 56
    //                   21: 66
    //                   22: 76
    //                   61: 86;
           goto _L4 _L5 _L6 _L7
_L4:
        boolean flag = false;
_L9:
        if (!flag) goto _L8; else goto _L2
_L2:
        flag1 = true;
_L8:
        return flag1;
_L5:
        flag = f(17);
          goto _L9
_L6:
        flag = f(66);
          goto _L9
_L7:
        if (android.os.Build.VERSION.SDK_INT < 11) goto _L4; else goto _L10
_L10:
        if (!KeyEventCompat.hasNoModifiers(keyevent))
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = f(2);
          goto _L9
        if (!KeyEventCompat.hasModifiers(keyevent, 1)) goto _L4; else goto _L11
_L11:
        flag = f(1);
          goto _L9
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        boolean flag1 = false;
        if (accessibilityevent.getEventType() != 4096) goto _L2; else goto _L1
_L1:
        boolean flag = super.dispatchPopulateAccessibilityEvent(accessibilityevent);
_L4:
        return flag;
_L2:
        int j1 = getChildCount();
        int i1 = 0;
        do
        {
            flag = flag1;
            if (i1 >= j1)
            {
                continue;
            }
            View view = getChildAt(i1);
            if (view.getVisibility() == 0)
            {
                f f1 = a(view);
                if (f1 != null && f1.b == t && view.dispatchPopulateAccessibilityEvent(accessibilityevent))
                {
                    return true;
                }
            }
            i1++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        int j1 = 0;
        int i1 = 0;
        int k1 = ViewCompat.getOverScrollMode(this);
        if (k1 == 0 || k1 == 1 && b != null && b.getCount() > 1)
        {
            if (!Q.isFinished())
            {
                j1 = canvas.save();
                i1 = getHeight();
                int l1 = getWidth();
                int j2 = getPaddingLeft();
                int l2 = getPaddingRight();
                canvas.translate(getPaddingLeft(), c * (float)i1);
                Q.setSize(l1 - j2 - l2, i1);
                i1 = Q.draw(canvas) | false;
                canvas.restoreToCount(j1);
            }
            j1 = i1;
            if (!R.isFinished())
            {
                int i2 = canvas.save();
                j1 = getHeight();
                int k2 = getWidth() - getPaddingLeft() - getPaddingRight();
                canvas.rotate(180F);
                canvas.translate(-k2 - getPaddingLeft(), -(d + 1.0F) * (float)j1);
                R.setSize(k2, j1);
                j1 = i1 | R.draw(canvas);
                canvas.restoreToCount(i2);
            }
        } else
        {
            Q.finish();
            R.finish();
        }
        if (j1 != 0)
        {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        Drawable drawable = A;
        if (drawable != null && drawable.isStateful())
        {
            drawable.setState(getDrawableState());
        }
    }

    final void e()
    {
        f = false;
        H = false;
        if (j != null)
        {
            j.recycle();
            j = null;
        }
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new LayoutParams();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new LayoutParams(getContext(), attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return generateDefaultLayoutParams();
    }

    protected int getChildDrawingOrder(int i1, int j1)
    {
        int k1 = j1;
        if (ab == 2)
        {
            k1 = i1 - 1 - j1;
        }
        return ((LayoutParams)((View)ac.get(k1)).getLayoutParams()).f;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        S = true;
    }

    protected void onDetachedFromWindow()
    {
        removeCallbacks(ae);
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (z > 0 && A != null && a.size() > 0 && b != null)
        {
            int k1 = getScrollY();
            int l1 = getHeight();
            float f3 = (float)z / (float)l1;
            Object obj = (f)a.get(0);
            float f1 = ((f) (obj)).e;
            int i2 = a.size();
            int i1 = ((f) (obj)).b;
            int j2 = ((f)a.get(i2 - 1)).b;
            int j1 = 0;
            do
            {
                if (i1 >= j2)
                {
                    break;
                }
                for (; i1 > ((f) (obj)).b && j1 < i2; obj = (f)((ArrayList) (obj)).get(j1))
                {
                    obj = a;
                    j1++;
                }

                float f2;
                if (i1 == ((f) (obj)).b)
                {
                    f2 = (((f) (obj)).e + ((f) (obj)).d) * (float)l1;
                    f1 = ((f) (obj)).e + ((f) (obj)).d + f3;
                } else
                {
                    float f4 = b.getPageWidth(i1);
                    f2 = (f1 + f4) * (float)l1;
                    f1 += f4 + f3;
                }
                if ((float)z + f2 > (float)k1)
                {
                    A.setBounds(B, (int)f2, C, (int)((float)z + f2 + 0.5F));
                    A.draw(canvas);
                }
                if (f2 > (float)(k1 + l1))
                {
                    break;
                }
                i1++;
            } while (true);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i1 = motionevent.getAction() & 0xff;
        if (i1 != 3 && i1 != 1) goto _L2; else goto _L1
_L1:
        f = false;
        H = false;
        i = -1;
        if (j != null)
        {
            j.recycle();
            j = null;
        }
_L4:
        return false;
_L2:
        if (i1 == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (f)
        {
            return true;
        }
        if (H) goto _L4; else goto _L3
_L3:
        i1;
        JVM INSTR lookupswitch 3: default 116
    //                   0: 427
    //                   2: 143
    //                   6: 558;
           goto _L5 _L6 _L7 _L8
_L5:
        if (j == null)
        {
            j = VelocityTracker.obtain();
        }
        j.addMovement(motionevent);
        return f;
_L7:
        float f1;
        float f3;
        float f4;
        float f5;
        float f6;
        int j1 = i;
        if (j1 == -1)
        {
            continue; /* Loop/switch isn't completed */
        }
        j1 = MotionEventCompat.findPointerIndex(motionevent, j1);
        f3 = MotionEventCompat.getY(motionevent, j1);
        f1 = f3 - g;
        f5 = Math.abs(f1);
        f4 = MotionEventCompat.getX(motionevent, j1);
        f6 = Math.abs(f4 - M);
        if (f1 != 0.0F)
        {
            float f7 = g;
            boolean flag;
            if (f7 < (float)J && f1 > 0.0F || f7 > (float)(getHeight() - J) && f1 < 0.0F)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag && a(this, false, (int)f1, (int)f4, (int)f3))
            {
                L = f4;
                g = f3;
                H = true;
                return false;
            }
        }
        if (f5 <= (float)K || 0.5F * f5 <= f6) goto _L10; else goto _L9
_L9:
        f = true;
        i();
        a(1);
        if (f1 > 0.0F)
        {
            f1 = h + (float)K;
        } else
        {
            f1 = h - (float)K;
        }
        g = f1;
        L = f4;
        b(true);
_L11:
        if (f && a(f3))
        {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        continue; /* Loop/switch isn't completed */
_L10:
        if (f6 > (float)K)
        {
            H = true;
        }
        if (true) goto _L11; else goto _L6
_L6:
        float f2 = motionevent.getX();
        M = f2;
        L = f2;
        f2 = motionevent.getY();
        h = f2;
        g = f2;
        i = MotionEventCompat.getPointerId(motionevent, 0);
        H = false;
        x.computeScrollOffset();
        if (af == 2 && Math.abs(x.getFinalY() - x.getCurrY()) > P)
        {
            x.abortAnimation();
            e = false;
            c();
            f = true;
            i();
            a(1);
        } else
        {
            a(false);
            f = false;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        a(motionevent);
        if (true) goto _L5; else goto _L12
_L12:
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        int j2;
        int j3;
        int i5;
        int j5;
        int k5;
        int l5;
        i5 = getChildCount();
        j5 = k1 - i1;
        k5 = l1 - j1;
        j1 = getPaddingLeft();
        i1 = getPaddingTop();
        l1 = getPaddingRight();
        k1 = getPaddingBottom();
        l5 = getScrollY();
        j2 = 0;
        j3 = 0;
_L14:
        if (j3 >= i5) goto _L2; else goto _L1
_L1:
        View view = getChildAt(j3);
        if (view.getVisibility() == 8) goto _L4; else goto _L3
_L3:
        LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
        if (!layoutparams.a) goto _L4; else goto _L5
_L5:
        int i2;
        int i6;
        i2 = layoutparams.b;
        i6 = layoutparams.b;
        i2 & 7;
        JVM INSTR tableswitch 1 5: default 148
    //                   1 296
    //                   2 148
    //                   3 277
    //                   4 148
    //                   5 318;
           goto _L6 _L7 _L6 _L8 _L6 _L9
_L6:
        int k2;
        i2 = j1;
        k2 = j1;
_L15:
        i6 & 0x70;
        JVM INSTR lookupswitch 3: default 192
    //                   16: 386
    //                   48: 359
    //                   80: 414;
           goto _L10 _L11 _L12 _L13
_L10:
        int l3 = i1;
        j1 = i1;
        i1 = k1;
        k1 = l3;
_L16:
        k1 += l5;
        view.layout(i2, k1, view.getMeasuredWidth() + i2, view.getMeasuredHeight() + k1);
        j2++;
        k1 = k2;
        i2 = i1;
        i1 = j2;
_L17:
        j3++;
        k2 = k1;
        j2 = i1;
        i1 = j1;
        k1 = i2;
        j1 = k2;
          goto _L14
_L8:
        k2 = view.getMeasuredWidth();
        i2 = j1;
        k2 += j1;
          goto _L15
_L7:
        i2 = Math.max((j5 - view.getMeasuredWidth()) / 2, j1);
        k2 = j1;
          goto _L15
_L9:
        k2 = view.getMeasuredWidth();
        i2 = l1 + view.getMeasuredWidth();
        int i4 = j5 - l1 - k2;
        l1 = i2;
        k2 = j1;
        i2 = i4;
          goto _L15
_L12:
        int j4 = view.getMeasuredHeight();
        j1 = k1;
        j4 += i1;
        k1 = i1;
        i1 = j1;
        j1 = j4;
          goto _L16
_L11:
        int k4 = Math.max((k5 - view.getMeasuredHeight()) / 2, i1);
        j1 = i1;
        i1 = k1;
        k1 = k4;
          goto _L16
_L13:
        int l4 = k5 - k1 - view.getMeasuredHeight();
        int j6 = view.getMeasuredHeight();
        j1 = i1;
        i1 = k1 + j6;
        k1 = l4;
          goto _L16
_L2:
        i2 = k5 - i1 - k1;
        for (k1 = 0; k1 < i5; k1++)
        {
            View view1 = getChildAt(k1);
            if (view1.getVisibility() == 8)
            {
                continue;
            }
            LayoutParams layoutparams1 = (LayoutParams)view1.getLayoutParams();
            if (layoutparams1.a)
            {
                continue;
            }
            f f3 = a(view1);
            if (f3 == null)
            {
                continue;
            }
            float f1 = i2;
            int l2 = (int)(f3.e * f1) + i1;
            if (layoutparams1.d)
            {
                layoutparams1.d = false;
                int k3 = android.view.View.MeasureSpec.makeMeasureSpec(j5 - j1 - l1, 0x40000000);
                float f2 = i2;
                view1.measure(k3, android.view.View.MeasureSpec.makeMeasureSpec((int)(layoutparams1.c * f2), 0x40000000));
            }
            view1.layout(j1, l2, view1.getMeasuredWidth() + j1, view1.getMeasuredHeight() + l2);
        }

        B = j1;
        C = j5 - l1;
        U = j2;
        if (S)
        {
            a(t, false, 0, false);
        }
        S = false;
        return;
_L4:
        i2 = j2;
        j2 = i1;
        int i3 = j1;
        i1 = i2;
        i2 = k1;
        j1 = j2;
        k1 = i3;
          goto _L17
    }

    protected void onMeasure(int i1, int j1)
    {
label0:
        {
            setMeasuredDimension(getDefaultSize(0, i1), getDefaultSize(0, j1));
            j1 = getMeasuredHeight();
            J = Math.min(j1 / 10, I);
            i1 = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
            j1 = j1 - getPaddingTop() - getPaddingBottom();
            int j3 = getChildCount();
            int i2 = 0;
            while (i2 < j3) 
            {
label1:
                {
                    {
                        View view = getChildAt(i2);
                        int k1 = i1;
                        int l1 = j1;
                        if (view.getVisibility() == 8)
                        {
                            break label1;
                        }
                        LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
                        k1 = i1;
                        l1 = j1;
                        if (layoutparams == null)
                        {
                            break label1;
                        }
                        k1 = i1;
                        l1 = j1;
                        if (!layoutparams.a)
                        {
                            break label1;
                        }
                        k1 = layoutparams.b & 7;
                        int j2 = layoutparams.b & 0x70;
                        int k2 = 0x80000000;
                        l1 = 0x80000000;
                        boolean flag;
                        boolean flag1;
                        if (j2 == 48 || j2 == 80)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        if (k1 == 3 || k1 == 5)
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        if (flag)
                        {
                            k1 = 0x40000000;
                        } else
                        {
                            k1 = k2;
                            if (flag1)
                            {
                                l1 = 0x40000000;
                                k1 = k2;
                            }
                        }
                        if (layoutparams.width != -2)
                        {
                            k2 = 0x40000000;
                            float f1;
                            int l2;
                            int i3;
                            if (layoutparams.width != -1)
                            {
                                k1 = layoutparams.width;
                            } else
                            {
                                k1 = i1;
                            }
                        } else
                        {
                            k2 = k1;
                            k1 = i1;
                        }
                        if (layoutparams.height == -2)
                        {
                            break label0;
                        }
                        l2 = 0x40000000;
                        l1 = l2;
                        if (layoutparams.height == -1)
                        {
                            break label0;
                        }
                        i3 = layoutparams.height;
                        l1 = l2;
                        l2 = i3;
                    }
                    view.measure(android.view.View.MeasureSpec.makeMeasureSpec(k1, k2), android.view.View.MeasureSpec.makeMeasureSpec(l2, l1));
                    if (flag)
                    {
                        l1 = j1 - view.getMeasuredHeight();
                        k1 = i1;
                    } else
                    {
                        k1 = i1;
                        l1 = j1;
                        if (flag1)
                        {
                            k1 = i1 - view.getMeasuredWidth();
                            l1 = j1;
                        }
                    }
                }
                i2++;
                i1 = k1;
                j1 = l1;
            }
            D = android.view.View.MeasureSpec.makeMeasureSpec(i1, 0x40000000);
            android.view.View.MeasureSpec.makeMeasureSpec(j1, 0x40000000);
            E = true;
            c();
            E = false;
            k1 = getChildCount();
            for (i1 = 0; i1 < k1; i1++)
            {
                view = getChildAt(i1);
                if (view.getVisibility() == 8)
                {
                    continue;
                }
                layoutparams = (LayoutParams)view.getLayoutParams();
                if (layoutparams == null || !layoutparams.a)
                {
                    f1 = j1;
                    l1 = android.view.View.MeasureSpec.makeMeasureSpec((int)(layoutparams.c * f1), 0x40000000);
                    view.measure(D, l1);
                }
            }

            return;
        }
        l2 = j1;
        break MISSING_BLOCK_LABEL_282;
    }

    protected boolean onRequestFocusInDescendants(int i1, Rect rect)
    {
        byte byte0 = -1;
        int k1 = getChildCount();
        int j1;
        if ((i1 & 2) != 0)
        {
            byte0 = 1;
            j1 = 0;
        } else
        {
            j1 = k1 - 1;
            k1 = -1;
        }
        for (; j1 != k1; j1 += byte0)
        {
            View view = getChildAt(j1);
            if (view.getVisibility() != 0)
            {
                continue;
            }
            f f1 = a(view);
            if (f1 != null && f1.b == t && view.requestFocus(i1, rect))
            {
                return true;
            }
        }

        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        if (!(parcelable instanceof SavedState))
        {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        if (b != null)
        {
            b.restoreState(((SavedState) (parcelable)).b, null);
            a(((SavedState) (parcelable)).a, false, true);
            return;
        } else
        {
            u = ((SavedState) (parcelable)).a;
            v = ((SavedState) (parcelable)).b;
            w = null;
            return;
        }
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.a = t;
        if (b != null)
        {
            savedstate.b = b.saveState();
        }
        return savedstate;
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        if (j1 != l1)
        {
            a(j1, l1, z, z);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i1;
        int j1;
        j1 = 0;
        if (l)
        {
            return true;
        }
        if (motionevent.getAction() == 0 && motionevent.getEdgeFlags() != 0)
        {
            return false;
        }
        if (b == null || b.getCount() == 0)
        {
            return false;
        }
        if (j == null)
        {
            j = VelocityTracker.obtain();
        }
        j.addMovement(motionevent);
        i1 = j1;
        motionevent.getAction() & 0xff;
        JVM INSTR tableswitch 0 6: default 124
    //                   0 139
    //                   1 391
    //                   2 201
    //                   3 545
    //                   4 128
    //                   5 600
    //                   6 633;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L6:
        break; /* Loop/switch isn't completed */
_L1:
        i1 = j1;
_L10:
        if (i1 != 0)
        {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        return true;
_L2:
        x.abortAnimation();
        e = false;
        c();
        float f1 = motionevent.getX();
        M = f1;
        L = f1;
        f1 = motionevent.getY();
        h = f1;
        g = f1;
        i = MotionEventCompat.getPointerId(motionevent, 0);
        i1 = j1;
        continue; /* Loop/switch isn't completed */
_L4:
        if (!f)
        {
            i1 = MotionEventCompat.findPointerIndex(motionevent, i);
            float f2 = MotionEventCompat.getY(motionevent, i1);
            float f4 = Math.abs(f2 - g);
            float f3 = MotionEventCompat.getX(motionevent, i1);
            float f5 = Math.abs(f3 - L);
            if (f4 > (float)K && f4 > f5)
            {
                f = true;
                i();
                ViewParent viewparent;
                if (f2 - h > 0.0F)
                {
                    f2 = h + (float)K;
                } else
                {
                    f2 = h - (float)K;
                }
                g = f2;
                L = f3;
                a(1);
                b(true);
                viewparent = getParent();
                if (viewparent != null)
                {
                    viewparent.requestDisallowInterceptTouchEvent(true);
                }
            }
        }
        i1 = j1;
        if (f)
        {
            i1 = a(MotionEventCompat.getY(motionevent, MotionEventCompat.findPointerIndex(motionevent, i))) | false;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        i1 = j1;
        if (f)
        {
            Object obj = j;
            ((VelocityTracker) (obj)).computeCurrentVelocity(1000, k);
            i1 = (int)VelocityTrackerCompat.getYVelocity(((VelocityTracker) (obj)), i);
            e = true;
            j1 = a();
            int k1 = getScrollY();
            obj = d();
            a(a(((f) (obj)).b, ((float)k1 / (float)j1 - ((f) (obj)).e) / ((f) (obj)).d, i1, (int)(MotionEventCompat.getY(motionevent, MotionEventCompat.findPointerIndex(motionevent, i)) - h)), true, true, i1);
            i = -1;
            e();
            boolean flag = Q.onRelease();
            i1 = R.onRelease() | flag;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        i1 = j1;
        if (f)
        {
            a(t, true, 0, false);
            i = -1;
            e();
            boolean flag1 = Q.onRelease();
            i1 = R.onRelease() | flag1;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        i1 = MotionEventCompat.getActionIndex(motionevent);
        g = MotionEventCompat.getY(motionevent, i1);
        i = MotionEventCompat.getPointerId(motionevent, i1);
        i1 = j1;
        continue; /* Loop/switch isn't completed */
_L8:
        a(motionevent);
        g = MotionEventCompat.getY(motionevent, MotionEventCompat.findPointerIndex(motionevent, i));
        i1 = j1;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void removeView(View view)
    {
        if (E)
        {
            removeViewInLayout(view);
            return;
        } else
        {
            super.removeView(view);
            return;
        }
    }

    public void setAdapter(PagerAdapter pageradapter)
    {
        boolean flag;
label0:
        {
            if (b != null)
            {
                b.unregisterDataSetObserver(y);
                b.startUpdate(this);
                for (int i1 = 0; i1 < a.size(); i1++)
                {
                    f f1 = (f)a.get(i1);
                    b.destroyItem(this, f1.b, f1.a);
                }

                b.finishUpdate(this);
                a.clear();
                int k1;
                for (int j1 = 0; j1 < getChildCount(); j1 = k1 + 1)
                {
                    k1 = j1;
                    if (!((LayoutParams)getChildAt(j1).getLayoutParams()).a)
                    {
                        removeViewAt(j1);
                        k1 = j1 - 1;
                    }
                }

                t = 0;
                scrollTo(0, 0);
            }
            b = pageradapter;
            o = 0;
            if (b != null)
            {
                if (y == null)
                {
                    y = new h(this, (byte)0);
                }
                b.registerDataSetObserver(y);
                e = false;
                flag = S;
                S = true;
                o = b.getCount();
                if (u < 0)
                {
                    break label0;
                }
                b.restoreState(v, null);
                a(u, false, true);
                u = -1;
                v = null;
                w = null;
            }
            return;
        }
        if (!flag)
        {
            c();
            return;
        } else
        {
            requestLayout();
            return;
        }
    }

    public void setCurrentItem(int i1)
    {
        e = false;
        boolean flag;
        if (!S)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a(i1, flag, false);
    }

    public void setCurrentItem(int i1, boolean flag)
    {
        e = false;
        a(i1, flag, false);
    }

    public void setOffscreenPageLimit(int i1)
    {
        int j1 = i1;
        if (i1 <= 0)
        {
            Log.w("VerticalViewPager", (new StringBuilder("Requested offscreen page limit ")).append(i1).append(" too small; defaulting to 1").toString());
            j1 = 1;
        }
        if (j1 != G)
        {
            G = j1;
            c();
        }
    }

    public void setOnPageChangeListener(android.support.v4.view.ViewPager.OnPageChangeListener onpagechangelistener)
    {
        V = onpagechangelistener;
    }

    public void setPageMargin(int i1)
    {
        int j1 = z;
        z = i1;
        int k1 = getHeight();
        a(k1, k1, i1, j1);
        requestLayout();
    }

    public void setPageMarginDrawable(int i1)
    {
        setPageMarginDrawable(getContext().getResources().getDrawable(i1));
    }

    public void setPageMarginDrawable(Drawable drawable)
    {
        A = drawable;
        if (drawable != null)
        {
            refreshDrawableState();
        }
        boolean flag;
        if (drawable == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setWillNotDraw(flag);
        invalidate();
    }

    public void setPageTransformer(boolean flag, android.support.v4.view.ViewPager.PageTransformer pagetransformer)
    {
        int i1 = 1;
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            boolean flag1;
            boolean flag2;
            boolean flag3;
            if (pagetransformer != null)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (W != null)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            if (flag2 != flag3)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            W = pagetransformer;
            if (android.os.Build.VERSION.SDK_INT >= 7)
            {
                if (aa == null)
                {
                    try
                    {
                        aa = android/view/ViewGroup.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[] {
                            Boolean.TYPE
                        });
                    }
                    // Misplaced declaration of an exception variable
                    catch (android.support.v4.view.ViewPager.PageTransformer pagetransformer)
                    {
                        Log.e("VerticalViewPager", "Can't find setChildrenDrawingOrderEnabled", pagetransformer);
                    }
                }
                try
                {
                    aa.invoke(this, new Object[] {
                        Boolean.valueOf(flag2)
                    });
                }
                // Misplaced declaration of an exception variable
                catch (android.support.v4.view.ViewPager.PageTransformer pagetransformer)
                {
                    Log.e("VerticalViewPager", "Error changing children drawing order", pagetransformer);
                }
            }
            if (flag2)
            {
                if (flag)
                {
                    i1 = 2;
                }
                ab = i1;
            } else
            {
                ab = 0;
            }
            if (flag1)
            {
                c();
            }
        }
    }

    protected boolean verifyDrawable(Drawable drawable)
    {
        return super.verifyDrawable(drawable) || drawable == A;
    }


    private class LayoutParams extends android.view.ViewGroup.LayoutParams
    {

        public boolean a;
        public int b;
        float c;
        boolean d;
        int e;
        int f;

        public LayoutParams()
        {
            super(-1, -1);
            c = 0.0F;
        }

        public LayoutParams(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
            c = 0.0F;
            context = context.obtainStyledAttributes(attributeset, VerticalViewPager.f());
            b = context.getInteger(0, 48);
            context.recycle();
        }
    }


    private class SavedState extends android.view.View.BaseSavedState
    {

        int a;
        Parcelable b;

        public String toString()
        {
            return (new StringBuilder("FragmentPager.SavedState{")).append(Integer.toHexString(System.identityHashCode(this))).append(" position=").append(a).append("}").toString();
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            super.writeToParcel(parcel, i1);
            parcel.writeInt(a);
            parcel.writeParcelable(b, i1);
        }

        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

}
