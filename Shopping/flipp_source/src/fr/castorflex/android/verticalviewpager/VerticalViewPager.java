// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package fr.castorflex.android.verticalviewpager;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.view.ae;
import android.support.v4.view.ak;
import android.support.v4.view.ap;
import android.support.v4.view.bg;
import android.support.v4.view.cd;
import android.support.v4.view.ce;
import android.support.v4.view.s;
import android.support.v4.view.z;
import android.support.v4.widget.n;
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

// Referenced classes of package fr.castorflex.android.verticalviewpager:
//            a, b, k, e, 
//            c, f, g, d, 
//            i, h

public class VerticalViewPager extends ViewGroup
{

    private static final int a[] = {
        0x10100b3
    };
    private static final k ag = new k();
    private static final Comparator c = new fr.castorflex.android.verticalviewpager.a();
    private static final Interpolator d = new b();
    private boolean A;
    private boolean B;
    private int C;
    private int D;
    private int E;
    private float F;
    private float G;
    private float H;
    private float I;
    private int J;
    private VelocityTracker K;
    private int L;
    private int M;
    private int N;
    private int O;
    private boolean P;
    private n Q;
    private n R;
    private boolean S;
    private boolean T;
    private boolean U;
    private int V;
    private cd W;
    private cd aa;
    private h ab;
    private ce ac;
    private Method ad;
    private int ae;
    private ArrayList af;
    private final Runnable ah;
    private int ai;
    private int b;
    private final ArrayList e;
    private final e f;
    private final Rect g;
    private ae h;
    private int i;
    private int j;
    private Parcelable k;
    private ClassLoader l;
    private Scroller m;
    private i n;
    private int o;
    private Drawable p;
    private int q;
    private int r;
    private float s;
    private float t;
    private int u;
    private int v;
    private boolean w;
    private boolean x;
    private boolean y;
    private int z;

    public VerticalViewPager(Context context)
    {
        super(context);
        e = new ArrayList();
        f = new e();
        g = new Rect();
        j = -1;
        k = null;
        l = null;
        s = -3.402823E+38F;
        t = 3.402823E+38F;
        z = 1;
        J = -1;
        S = true;
        T = false;
        ah = new c(this);
        ai = 0;
        d();
    }

    public VerticalViewPager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        e = new ArrayList();
        f = new e();
        g = new Rect();
        j = -1;
        k = null;
        l = null;
        s = -3.402823E+38F;
        t = 3.402823E+38F;
        z = 1;
        J = -1;
        S = true;
        T = false;
        ah = new c(this);
        ai = 0;
        d();
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

    private e a(int i1, int j1)
    {
        e e1 = new e();
        e1.b = i1;
        e1.a = h.a(this, i1);
        e1.d = 1.0F;
        if (j1 < 0 || j1 >= e.size())
        {
            e.add(e1);
            return e1;
        } else
        {
            e.add(j1, e1);
            return e1;
        }
    }

    private e a(View view)
    {
        for (int i1 = 0; i1 < e.size(); i1++)
        {
            e e1 = (e)e.get(i1);
            if (h.a(view, e1.a))
            {
                return e1;
            }
        }

        return null;
    }

    private void a(int i1, int j1, int k1, int l1)
    {
        if (j1 > 0 && !e.isEmpty())
        {
            int i2 = getPaddingTop();
            int j2 = getPaddingBottom();
            int k2 = getPaddingTop();
            int l2 = getPaddingBottom();
            float f1 = (float)getScrollY() / (float)((j1 - k2 - l2) + l1);
            j1 = (int)((float)((i1 - i2 - j2) + k1) * f1);
            scrollTo(getScrollX(), j1);
            if (!m.isFinished())
            {
                k1 = m.getDuration();
                l1 = m.timePassed();
                e e1 = c(i);
                m.startScroll(0, j1, 0, (int)(e1.e * (float)i1), k1 - l1);
            }
        } else
        {
            e e2 = c(i);
            float f2;
            if (e2 != null)
            {
                f2 = Math.min(e2.e, t);
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
        e e1 = c(i1);
        int k1 = 0;
        if (e1 != null)
        {
            k1 = (int)((float)getClientHeight() * Math.max(s, Math.min(e1.e, t)));
        }
        if (flag)
        {
            if (getChildCount() == 0)
            {
                setScrollingCacheEnabled(false);
            } else
            {
                int l1 = getScrollX();
                int i2 = getScrollY();
                int j2 = 0 - l1;
                k1 -= i2;
                if (j2 == 0 && k1 == 0)
                {
                    a(false);
                    b();
                    setScrollState(0);
                } else
                {
                    setScrollingCacheEnabled(true);
                    setScrollState(2);
                    int k2 = getClientHeight();
                    int l2 = k2 / 2;
                    float f4 = Math.min(1.0F, (1.0F * (float)Math.abs(j2)) / (float)k2);
                    float f1 = l2;
                    float f3 = l2;
                    f4 = (float)Math.sin((float)((double)(f4 - 0.5F) * 0.4712389167638204D));
                    j1 = Math.abs(j1);
                    if (j1 > 0)
                    {
                        j1 = Math.round(1000F * Math.abs((f3 * f4 + f1) / (float)j1)) * 4;
                    } else
                    {
                        float f2 = k2;
                        j1 = (int)(((float)Math.abs(j2) / (f2 * 1.0F + (float)o) + 1.0F) * 100F);
                    }
                    j1 = Math.min(j1, 600);
                    m.startScroll(l1, i2, j2, k1, j1);
                    ap.d(this);
                }
            }
        } else
        {
            if (flag1 && W != null)
            {
                W.a(i1);
            }
            if (flag1 && aa != null)
            {
                aa.a(i1);
            }
            a(false);
            scrollTo(0, k1);
            f();
            return;
        }
        if (flag1 && W != null)
        {
            W.a(i1);
        }
        if (flag1 && aa != null)
        {
            aa.a(i1);
        }
    }

    private void a(int i1, boolean flag, boolean flag1)
    {
        a(i1, flag, flag1, 0);
    }

    private void a(int i1, boolean flag, boolean flag1, int j1)
    {
        boolean flag2;
        flag2 = false;
        if (h == null || h.c() <= 0)
        {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!flag1 && i == i1 && e.size() != 0)
        {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i1 >= 0) goto _L2; else goto _L1
_L1:
        int k1 = 0;
_L4:
        i1 = z;
        if (k1 > i + i1 || k1 < i - i1)
        {
            for (i1 = 0; i1 < e.size(); i1++)
            {
                ((e)e.get(i1)).c = true;
            }

        }
        break; /* Loop/switch isn't completed */
_L2:
        k1 = i1;
        if (i1 >= h.c())
        {
            k1 = h.c() - 1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        flag1 = flag2;
        if (i != k1)
        {
            flag1 = true;
        }
        if (S)
        {
            i = k1;
            if (flag1 && W != null)
            {
                W.a(k1);
            }
            if (flag1 && aa != null)
            {
                aa.a(k1);
            }
            requestLayout();
            return;
        } else
        {
            b(k1);
            a(k1, flag, j1, flag1);
            return;
        }
    }

    private void a(MotionEvent motionevent)
    {
        int i1 = android.support.v4.view.z.b(motionevent);
        if (android.support.v4.view.z.b(motionevent, i1) == J)
        {
            if (i1 == 0)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            G = android.support.v4.view.z.d(motionevent, i1);
            J = android.support.v4.view.z.b(motionevent, i1);
            if (K != null)
            {
                K.clear();
            }
        }
    }

    static void a(VerticalViewPager verticalviewpager)
    {
        verticalviewpager.setScrollState(0);
    }

    private void a(e e1, int i1, e e2)
    {
        int j2 = h.c();
        int j1 = getClientHeight();
        float f4;
        if (j1 > 0)
        {
            f4 = (float)o / (float)j1;
        } else
        {
            f4 = 0.0F;
        }
        if (e2 != null)
        {
            j1 = e2.b;
            if (j1 < e1.b)
            {
                float f1 = e2.e + e2.d + f4;
                int k1 = 0;
                for (j1++; j1 <= e1.b && k1 < e.size(); j1++)
                {
                    for (e2 = (e)e.get(k1); j1 > e2.b && k1 < e.size() - 1; e2 = (e)e.get(k1))
                    {
                        k1++;
                    }

                    while (j1 < e2.b) 
                    {
                        j1++;
                        f1 = 1.0F + f4 + f1;
                    }
                    e2.e = f1;
                    f1 += e2.d + f4;
                }

            } else
            if (j1 > e1.b)
            {
                int l1 = e.size();
                float f2 = e2.e;
                l1--;
                for (j1--; j1 >= e1.b && l1 >= 0; j1--)
                {
                    for (e2 = (e)e.get(l1); j1 < e2.b && l1 > 0; e2 = (e)e.get(l1))
                    {
                        l1--;
                    }

                    while (j1 > e2.b) 
                    {
                        j1--;
                        f2 -= 1.0F + f4;
                    }
                    f2 -= e2.d + f4;
                    e2.e = f2;
                }

            }
        }
        int k2 = e.size();
        float f5 = e1.e;
        j1 = e1.b - 1;
        float f3;
        int i2;
        if (e1.b == 0)
        {
            f3 = e1.e;
        } else
        {
            f3 = -3.402823E+38F;
        }
        s = f3;
        if (e1.b == j2 - 1)
        {
            f3 = (e1.e + e1.d) - 1.0F;
        } else
        {
            f3 = 3.402823E+38F;
        }
        t = f3;
        i2 = i1 - 1;
        f3 = f5;
        for (; i2 >= 0; i2--)
        {
            for (e2 = (e)e.get(i2); j1 > e2.b;)
            {
                j1--;
                f3 -= 1.0F + f4;
            }

            f3 -= e2.d + f4;
            e2.e = f3;
            if (e2.b == 0)
            {
                s = f3;
            }
            j1--;
        }

        f3 = e1.e + e1.d + f4;
        i2 = e1.b + 1;
        j1 = i1 + 1;
        i1 = i2;
        for (; j1 < k2; j1++)
        {
            for (e1 = (e)e.get(j1); i1 < e1.b;)
            {
                i1++;
                f3 += 1.0F + f4;
            }

            if (e1.b == j2 - 1)
            {
                t = (e1.d + f3) - 1.0F;
            }
            e1.e = f3;
            f3 += e1.d + f4;
            i1++;
        }

        T = false;
    }

    private void a(boolean flag)
    {
label0:
        {
            int i1;
            boolean flag1;
            boolean flag2;
            if (ai == 2)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            if (i1 != 0)
            {
                setScrollingCacheEnabled(false);
                m.abortAnimation();
                int j1 = getScrollX();
                int k1 = getScrollY();
                int l1 = m.getCurrX();
                int i2 = m.getCurrY();
                if (j1 != l1 || k1 != i2)
                {
                    scrollTo(l1, i2);
                }
            }
            y = false;
            flag2 = false;
            flag1 = i1;
            for (i1 = ((flag2) ? 1 : 0); i1 < e.size(); i1++)
            {
                e e1 = (e)e.get(i1);
                if (e1.c)
                {
                    e1.c = false;
                    flag1 = true;
                }
            }

            if (flag1)
            {
                if (!flag)
                {
                    break label0;
                }
                ap.a(this, ah);
            }
            return;
        }
        ah.run();
    }

    private boolean a(float f1)
    {
        boolean flag1 = true;
        boolean flag3 = false;
        boolean flag2 = false;
        float f2 = G;
        G = f1;
        float f3 = (float)getScrollY() + (f2 - f1);
        int i1 = getClientHeight();
        f1 = (float)i1 * s;
        f2 = i1;
        float f4 = t;
        e e1 = (e)e.get(0);
        e e2 = (e)e.get(e.size() - 1);
        boolean flag;
        if (e1.b != 0)
        {
            f1 = e1.e * (float)i1;
            flag = false;
        } else
        {
            flag = true;
        }
        if (e2.b != h.c() - 1)
        {
            f2 = e2.e * (float)i1;
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
            flag2 = Q.a(Math.abs(f1 - f3) / (float)i1);
            f2 = f1;
        }
_L4:
        F = F + (f2 - (float)(int)f2);
        scrollTo(getScrollX(), (int)f2);
        f();
        return flag2;
_L2:
        if (f3 > f2)
        {
            flag2 = flag3;
            if (flag1)
            {
                flag2 = R.a(Math.abs(f3 - f2) / (float)i1);
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
        if (flag && ap.b(view, -i1)) goto _L4; else goto _L6
_L6:
        return false;
        if (true) goto _L8; else goto _L7
_L7:
    }

    static ae b(VerticalViewPager verticalviewpager)
    {
        return verticalviewpager.h;
    }

    private e b(View view)
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

    private void b(int i1)
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
        if (i != i1)
        {
            char c1;
            if (i < i1)
            {
                c1 = '\202';
            } else
            {
                c1 = '!';
            }
            obj1 = c(i);
            i = i1;
            c2 = c1;
        } else
        {
            obj1 = null;
            c2 = '\002';
        }
        if (h != null) goto _L2; else goto _L1
_L1:
        e();
_L4:
        return;
_L2:
        if (y)
        {
            e();
            return;
        }
        if (getWindowToken() == null) goto _L4; else goto _L3
_L3:
        i1 = z;
        j3 = Math.max(0, i - i1);
        l2 = h.c();
        i3 = Math.min(l2 - 1, i1 + i);
        if (l2 != b)
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
            throw new IllegalStateException((new StringBuilder("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ")).append(b).append(", found: ").append(l2).append(" Pager id: ").append(s1).append(" Pager class: ").append(getClass()).append(" Problematic adapter: ").append(h.getClass()).toString());
        }
        i1 = 0;
_L14:
        if (i1 >= e.size())
        {
            break MISSING_BLOCK_LABEL_1253;
        }
        obj = (e)e.get(i1);
        if (((e) (obj)).b < i) goto _L6; else goto _L5
_L5:
        if (((e) (obj)).b != i)
        {
            break MISSING_BLOCK_LABEL_1253;
        }
_L21:
        if (obj == null && l2 > 0)
        {
            obj2 = a(i, i1);
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
            obj = (e)e.get(k2);
        } else
        {
            obj = null;
        }
        k3 = getClientHeight();
        if (k3 <= 0)
        {
            f3 = 0.0F;
        } else
        {
            f3 = (2.0F - ((e) (obj2)).d) + (float)getPaddingLeft() / (float)k3;
        }
        j1 = i;
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
        if (j2 == ((e) (obj3)).b)
        {
            obj = obj3;
            i1 = k2;
            f1 = f5;
            j1 = i2;
            if (!((e) (obj3)).c)
            {
                e.remove(k2);
                h.a(j2, ((e) (obj3)).a);
                i1 = k2 - 1;
                j1 = i2 - 1;
                if (i1 >= 0)
                {
                    obj = (e)e.get(i1);
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
        break MISSING_BLOCK_LABEL_369;
_L6:
        i1++;
          goto _L14
_L12:
        if (obj3 != null && j2 == ((e) (obj3)).b)
        {
            f1 = f5 + ((e) (obj3)).d;
            i1 = k2 - 1;
            if (i1 >= 0)
            {
                obj = (e)e.get(i1);
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
                obj = (e)e.get(k2);
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
            float f2 = ((e) (obj2)).d;
            i1 = i2 + 1;
            if (f2 >= 2.0F)
            {
                break label0;
            }
            float f4;
            int k1;
            if (i1 < e.size())
            {
                obj = (e)e.get(i1);
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
            k1 = i;
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
                    if (k1 == ((e) (obj)).b && !((e) (obj)).c)
                    {
                        e.remove(i1);
                        h.a(k1, ((e) (obj)).a);
                        if (i1 < e.size())
                        {
                            obj = (e)e.get(i1);
                        } else
                        {
                            obj = null;
                        }
                    }
                } else
                if (obj != null && k1 == ((e) (obj)).b)
                {
                    float f6 = ((e) (obj)).d;
                    i1++;
                    if (i1 < e.size())
                    {
                        obj = (e)e.get(i1);
                    } else
                    {
                        obj = null;
                    }
                    f2 += f6;
                } else
                {
                    obj = a(k1, i1);
                    i1++;
                    float f7 = ((e) (obj)).d;
                    if (i1 < e.size())
                    {
                        obj = (e)e.get(i1);
                    } else
                    {
                        obj = null;
                    }
                    f2 += f7;
                }
                k1++;
            } while (true);
        }
        a(((e) (obj2)), i2, ((e) (obj1)));
_L8:
        obj1 = h;
        int l1;
        if (obj2 != null)
        {
            obj = ((e) (obj2)).a;
        } else
        {
            obj = null;
        }
        ((ae) (obj1)).a(obj);
        h.a();
        l1 = getChildCount();
        for (i1 = 0; i1 < l1; i1++)
        {
            obj1 = getChildAt(i1);
            obj = (f)((View) (obj1)).getLayoutParams();
            obj.f = i1;
            if (((f) (obj)).a || ((f) (obj)).c != 0.0F)
            {
                continue;
            }
            obj1 = a(((View) (obj1)));
            if (obj1 != null)
            {
                obj.c = ((e) (obj1)).d;
                obj.e = ((e) (obj1)).b;
            }
        }

        e();
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
        if (obj != null && ((e) (obj)).b == i) goto _L4; else goto _L17
_L17:
        i1 = 0;
_L20:
        if (i1 >= getChildCount()) goto _L4; else goto _L18
_L18:
        obj = getChildAt(i1);
        obj1 = a(((View) (obj)));
        if (obj1 != null && ((e) (obj1)).b == i && ((View) (obj)).requestFocus(c2)) goto _L4; else goto _L19
_L19:
        i1++;
          goto _L20
        obj = null;
          goto _L21
    }

    static int c(VerticalViewPager verticalviewpager)
    {
        return verticalviewpager.i;
    }

    private e c(int i1)
    {
        for (int j1 = 0; j1 < e.size(); j1++)
        {
            e e1 = (e)e.get(j1);
            if (e1.b == i1)
            {
                return e1;
            }
        }

        return null;
    }

    static int[] c()
    {
        return a;
    }

    private void d()
    {
        setWillNotDraw(false);
        setDescendantFocusability(0x40000);
        setFocusable(true);
        Context context = getContext();
        m = new Scroller(context, d);
        ViewConfiguration viewconfiguration = ViewConfiguration.get(context);
        float f1 = context.getResources().getDisplayMetrics().density;
        E = bg.a(viewconfiguration);
        L = (int)(400F * f1);
        M = viewconfiguration.getScaledMaximumFlingVelocity();
        Q = new n(context);
        R = new n(context);
        N = (int)(25F * f1);
        O = (int)(2.0F * f1);
        C = (int)(16F * f1);
        ap.a(this, new g(this));
        if (ap.e(this) == 0)
        {
            ap.c(this, 1);
        }
    }

    private boolean d(int i1)
    {
        View view;
        boolean flag;
        flag = false;
        view = findFocus();
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
        j1 = a(g, view).top;
        int k1 = a(g, ((View) (obj))).top;
        StringBuilder stringbuilder;
        if (obj != null && j1 >= k1)
        {
            flag = k();
        } else
        {
            flag = view.requestFocus();
        }
_L15:
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
            break MISSING_BLOCK_LABEL_382;
        }
        if (obj != this) goto _L10; else goto _L9
_L9:
        j1 = 1;
_L20:
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

        Log.e("ViewPager", (new StringBuilder("arrowScroll tried to find focus based on non-child current focused view ")).append(stringbuilder.toString()).toString());
        obj = null;
          goto _L13
_L6:
        if (i1 != 130) goto _L15; else goto _L14
_L14:
        int l1;
        j1 = a(g, view).bottom;
        l1 = a(g, ((View) (obj))).bottom;
        if (obj != null && j1 <= l1) goto _L17; else goto _L16
_L16:
        flag = view.requestFocus();
          goto _L15
_L4:
        if (i1 != 33 && i1 != 1) goto _L19; else goto _L18
_L18:
        flag = k();
          goto _L15
_L19:
        if (i1 != 130 && i1 != 2) goto _L15; else goto _L17
_L17:
        if (h != null && i < h.c() - 1)
        {
            setCurrentItem$2563266(i + 1);
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L15
_L8:
        obj = view;
          goto _L13
        j1 = 0;
          goto _L20
    }

    private void e()
    {
        if (ae != 0)
        {
            int j1;
            if (af == null)
            {
                af = new ArrayList();
            } else
            {
                af.clear();
            }
            j1 = getChildCount();
            for (int i1 = 0; i1 < j1; i1++)
            {
                View view = getChildAt(i1);
                af.add(view);
            }

            Collections.sort(af, ag);
        }
    }

    private boolean f()
    {
        boolean flag = false;
        if (e.size() == 0)
        {
            U = false;
            g();
            if (!U)
            {
                throw new IllegalStateException("onPageScrolled did not call superclass implementation");
            }
        } else
        {
            i();
            getClientHeight();
            U = false;
            g();
            if (!U)
            {
                throw new IllegalStateException("onPageScrolled did not call superclass implementation");
            }
            flag = true;
        }
        return flag;
    }

    private void g()
    {
        if (V <= 0) goto _L2; else goto _L1
_L1:
        int i1;
        int j1;
        int j2;
        int k2;
        int l2;
        int i3;
        k2 = getScrollY();
        i1 = getPaddingTop();
        j1 = getPaddingBottom();
        l2 = getHeight();
        i3 = getChildCount();
        j2 = 0;
_L8:
        if (j2 >= i3) goto _L2; else goto _L3
_L3:
        View view;
        f f1;
        view = getChildAt(j2);
        f1 = (f)view.getLayoutParams();
        if (!f1.a)
        {
            break MISSING_BLOCK_LABEL_361;
        }
        f1.b & 0x70;
        JVM INSTR lookupswitch 3: default 108
    //                   16: 199
    //                   48: 174
    //                   80: 227;
           goto _L4 _L5 _L6 _L7
_L4:
        int k1;
        k1 = i1;
        int l1 = j1;
        j1 = i1;
        i1 = l1;
_L9:
        int i2;
        int j3 = (k1 + k2) - view.getTop();
        k1 = i1;
        i2 = j1;
        if (j3 != 0)
        {
            view.offsetTopAndBottom(j3);
            i2 = j1;
            k1 = i1;
        }
_L10:
        j2++;
        i1 = i2;
        j1 = k1;
          goto _L8
_L6:
        k1 = view.getHeight();
        i2 = k1 + i1;
        k1 = i1;
        i1 = j1;
        j1 = i2;
          goto _L9
_L5:
        k1 = Math.max((l2 - view.getMeasuredHeight()) / 2, i1);
        i2 = i1;
        i1 = j1;
        j1 = i2;
          goto _L9
_L7:
        k1 = l2 - j1 - view.getMeasuredHeight();
        int k3 = view.getMeasuredHeight();
        i2 = i1;
        i1 = j1 + k3;
        j1 = i2;
          goto _L9
_L2:
        if (W != null)
        {
            W.a();
        }
        if (aa != null)
        {
            aa.a();
        }
        if (ac != null)
        {
            getScrollY();
            j1 = getChildCount();
            for (i1 = 0; i1 < j1; i1++)
            {
                View view1 = getChildAt(i1);
                if (!((f)view1.getLayoutParams()).a)
                {
                    view1.getTop();
                    getClientHeight();
                }
            }

        }
        U = true;
        return;
        k1 = j1;
        i2 = i1;
          goto _L10
    }

    private int getClientHeight()
    {
        return getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    }

    private void h()
    {
        ViewParent viewparent = getParent();
        if (viewparent != null)
        {
            viewparent.requestDisallowInterceptTouchEvent(true);
        }
    }

    private e i()
    {
        int i1 = getClientHeight();
        float f1;
        float f2;
        float f3;
        float f4;
        e e2;
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
            f2 = (float)o / (float)i1;
        } else
        {
            f2 = 0.0F;
        }
        f4 = 0.0F;
        f3 = 0.0F;
        j1 = -1;
        i1 = 0;
        flag = true;
        e2 = null;
        do
        {
            e e1;
label0:
            {
                e e3;
label1:
                {
                    e3 = e2;
                    if (i1 >= e.size())
                    {
                        break label1;
                    }
                    e1 = (e)e.get(i1);
                    if (!flag && e1.b != j1 + 1)
                    {
                        e1 = f;
                        e1.e = f4 + f3 + f2;
                        e1.b = j1 + 1;
                        e1.d = 1.0F;
                        i1--;
                    }
                    f3 = e1.e;
                    f4 = e1.d;
                    if (!flag)
                    {
                        e3 = e2;
                        if (f1 < f3)
                        {
                            break label1;
                        }
                    }
                    if (f1 >= f4 + f3 + f2 && i1 != e.size() - 1)
                    {
                        break label0;
                    }
                    e3 = e1;
                }
                return e3;
            }
            j1 = e1.b;
            f4 = e1.d;
            flag = false;
            i1++;
            e2 = e1;
        } while (true);
    }

    private void j()
    {
        A = false;
        B = false;
        if (K != null)
        {
            K.recycle();
            K = null;
        }
    }

    private boolean k()
    {
        if (i > 0)
        {
            setCurrentItem$2563266(i - 1);
            return true;
        } else
        {
            return false;
        }
    }

    private void setCurrentItem$2563266(int i1)
    {
        y = false;
        a(i1, true, false);
    }

    private void setScrollState(int i1)
    {
        if (ai != i1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        ai = i1;
        if (ac != null)
        {
            int j1;
            int k1;
            if (i1 != 0)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            k1 = getChildCount();
            j1 = 0;
            while (j1 < k1) 
            {
                byte byte0;
                if (i1 != 0)
                {
                    byte0 = 2;
                } else
                {
                    byte0 = 0;
                }
                ap.a(getChildAt(j1), byte0, null);
                j1++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private void setScrollingCacheEnabled(boolean flag)
    {
        if (x != flag)
        {
            x = flag;
        }
    }

    final void a()
    {
        int i1 = h.c();
        b = i1;
        boolean flag;
        int i2;
        if (e.size() < z * 2 + 1 && e.size() < i1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i2 = i;
        for (int k1 = 0; k1 < e.size(); k1++)
        {
            e.get(k1);
        }

        Collections.sort(e, c);
        if (flag)
        {
            int l1 = getChildCount();
            for (int j1 = 0; j1 < l1; j1++)
            {
                f f1 = (f)getChildAt(j1).getLayoutParams();
                if (!f1.a)
                {
                    f1.c = 0.0F;
                }
            }

            a(i2, false, true);
            requestLayout();
        }
    }

    public final boolean a(int i1)
    {
        if (h != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int j1;
        int k1;
        j1 = getClientHeight();
        k1 = getScrollY();
        if (i1 >= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (k1 <= (int)((float)j1 * s)) goto _L1; else goto _L3
_L3:
        return true;
        if (i1 <= 0 || k1 >= (int)((float)j1 * t)) goto _L1; else goto _L4
_L4:
        return true;
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
                    e e1 = a(view);
                    if (e1 != null && e1.b == i)
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
            e e1 = a(view);
            if (e1 != null && e1.b == i)
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
        f f1 = (f)layoutparams;
        f1.a = f1.a | (view instanceof d);
        if (w)
        {
            if (f1 != null && f1.a)
            {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            } else
            {
                f1.d = true;
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
        b(i);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return (layoutparams instanceof f) && super.checkLayoutParams(layoutparams);
    }

    public void computeScroll()
    {
        if (!m.isFinished() && m.computeScrollOffset())
        {
            int i1 = getScrollX();
            int j1 = getScrollY();
            int k1 = m.getCurrX();
            int l1 = m.getCurrY();
            if (i1 != k1 || j1 != l1)
            {
                scrollTo(k1, l1);
                if (!f())
                {
                    m.abortAnimation();
                    scrollTo(k1, 0);
                }
            }
            ap.d(this);
            return;
        } else
        {
            a(true);
            return;
        }
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
        flag = d(17);
          goto _L9
_L6:
        flag = d(66);
          goto _L9
_L7:
        if (android.os.Build.VERSION.SDK_INT < 11) goto _L4; else goto _L10
_L10:
        if (!android.support.v4.view.s.b(keyevent))
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = d(2);
          goto _L9
        if (!android.support.v4.view.s.a(keyevent)) goto _L4; else goto _L11
_L11:
        flag = d(1);
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
                e e1 = a(view);
                if (e1 != null && e1.b == i && view.dispatchPopulateAccessibilityEvent(accessibilityevent))
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
        int k1 = ap.a(this);
        if (k1 == 0 || k1 == 1 && h != null && h.c() > 1)
        {
            if (!Q.a())
            {
                j1 = canvas.save();
                i1 = getHeight();
                int l1 = getWidth();
                int j2 = getPaddingLeft();
                int l2 = getPaddingRight();
                canvas.translate(getPaddingLeft(), s * (float)i1);
                Q.a(l1 - j2 - l2, i1);
                i1 = Q.a(canvas) | false;
                canvas.restoreToCount(j1);
            }
            j1 = i1;
            if (!R.a())
            {
                int i2 = canvas.save();
                j1 = getHeight();
                int k2 = getWidth() - getPaddingLeft() - getPaddingRight();
                canvas.rotate(180F);
                canvas.translate(-k2 - getPaddingLeft(), -(t + 1.0F) * (float)j1);
                R.a(k2, j1);
                j1 = i1 | R.a(canvas);
                canvas.restoreToCount(i2);
            }
        } else
        {
            Q.b();
            R.b();
        }
        if (j1 != 0)
        {
            ap.d(this);
        }
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        Drawable drawable = p;
        if (drawable != null && drawable.isStateful())
        {
            drawable.setState(getDrawableState());
        }
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new f();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new f(getContext(), attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return generateDefaultLayoutParams();
    }

    public ae getAdapter()
    {
        return h;
    }

    protected int getChildDrawingOrder(int i1, int j1)
    {
        int k1 = j1;
        if (ae == 2)
        {
            k1 = i1 - 1 - j1;
        }
        return ((f)((View)af.get(k1)).getLayoutParams()).f;
    }

    public int getCurrentItem()
    {
        return i;
    }

    public int getOffscreenPageLimit()
    {
        return z;
    }

    public int getPageMargin()
    {
        return o;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        S = true;
    }

    protected void onDetachedFromWindow()
    {
        removeCallbacks(ah);
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (o > 0 && p != null && e.size() > 0 && h != null)
        {
            int k1 = getScrollY();
            int l1 = getHeight();
            float f3 = (float)o / (float)l1;
            Object obj = (e)e.get(0);
            float f1 = ((e) (obj)).e;
            int i2 = e.size();
            int i1 = ((e) (obj)).b;
            int j2 = ((e)e.get(i2 - 1)).b;
            int j1 = 0;
            do
            {
                if (i1 >= j2)
                {
                    break;
                }
                for (; i1 > ((e) (obj)).b && j1 < i2; obj = (e)((ArrayList) (obj)).get(j1))
                {
                    obj = e;
                    j1++;
                }

                float f2;
                if (i1 == ((e) (obj)).b)
                {
                    f2 = (((e) (obj)).e + ((e) (obj)).d) * (float)l1;
                    f1 = ((e) (obj)).e + ((e) (obj)).d + f3;
                } else
                {
                    f2 = (1.0F + f1) * (float)l1;
                    f1 += 1.0F + f3;
                }
                if ((float)o + f2 > (float)k1)
                {
                    p.setBounds(q, (int)f2, r, (int)((float)o + f2 + 0.5F));
                    p.draw(canvas);
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
        A = false;
        B = false;
        J = -1;
        if (K != null)
        {
            K.recycle();
            K = null;
        }
_L4:
        return false;
_L2:
        if (i1 == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (A)
        {
            return true;
        }
        if (B) goto _L4; else goto _L3
_L3:
        i1;
        JVM INSTR lookupswitch 3: default 116
    //                   0: 427
    //                   2: 143
    //                   6: 558;
           goto _L5 _L6 _L7 _L8
_L5:
        if (K == null)
        {
            K = VelocityTracker.obtain();
        }
        K.addMovement(motionevent);
        return A;
_L7:
        float f1;
        float f3;
        float f4;
        float f5;
        float f6;
        int j1 = J;
        if (j1 == -1)
        {
            continue; /* Loop/switch isn't completed */
        }
        j1 = android.support.v4.view.z.a(motionevent, j1);
        f3 = android.support.v4.view.z.d(motionevent, j1);
        f1 = f3 - G;
        f5 = Math.abs(f1);
        f4 = android.support.v4.view.z.c(motionevent, j1);
        f6 = Math.abs(f4 - H);
        if (f1 != 0.0F)
        {
            float f7 = G;
            boolean flag;
            if (f7 < (float)D && f1 > 0.0F || f7 > (float)(getHeight() - D) && f1 < 0.0F)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag && a(this, false, (int)f1, (int)f4, (int)f3))
            {
                F = f4;
                G = f3;
                B = true;
                return false;
            }
        }
        if (f5 <= (float)E || 0.5F * f5 <= f6) goto _L10; else goto _L9
_L9:
        A = true;
        h();
        setScrollState(1);
        if (f1 > 0.0F)
        {
            f1 = I + (float)E;
        } else
        {
            f1 = I - (float)E;
        }
        G = f1;
        F = f4;
        setScrollingCacheEnabled(true);
_L11:
        if (A && a(f3))
        {
            ap.d(this);
        }
        continue; /* Loop/switch isn't completed */
_L10:
        if (f6 > (float)E)
        {
            B = true;
        }
        if (true) goto _L11; else goto _L6
_L6:
        float f2 = motionevent.getX();
        H = f2;
        F = f2;
        f2 = motionevent.getY();
        I = f2;
        G = f2;
        J = android.support.v4.view.z.b(motionevent, 0);
        B = false;
        m.computeScrollOffset();
        if (ai == 2 && Math.abs(m.getFinalY() - m.getCurrY()) > O)
        {
            m.abortAnimation();
            y = false;
            b();
            A = true;
            h();
            setScrollState(1);
        } else
        {
            a(false);
            A = false;
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
        f f3 = (f)view.getLayoutParams();
        if (!f3.a) goto _L4; else goto _L5
_L5:
        int i2;
        int i6;
        i2 = f3.b;
        i6 = f3.b;
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
            f f4 = (f)view1.getLayoutParams();
            if (f4.a)
            {
                continue;
            }
            e e1 = a(view1);
            if (e1 == null)
            {
                continue;
            }
            float f1 = i2;
            int l2 = (int)(e1.e * f1) + i1;
            if (f4.d)
            {
                f4.d = false;
                int k3 = android.view.View.MeasureSpec.makeMeasureSpec(j5 - j1 - l1, 0x40000000);
                float f2 = i2;
                view1.measure(k3, android.view.View.MeasureSpec.makeMeasureSpec((int)(f4.c * f2), 0x40000000));
            }
            view1.layout(j1, l2, view1.getMeasuredWidth() + j1, view1.getMeasuredHeight() + l2);
        }

        q = j1;
        r = j5 - l1;
        V = j2;
        if (S)
        {
            a(i, false, 0, false);
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
            D = Math.min(j1 / 10, C);
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
                        f f2 = (f)view.getLayoutParams();
                        k1 = i1;
                        l1 = j1;
                        if (f2 == null)
                        {
                            break label1;
                        }
                        k1 = i1;
                        l1 = j1;
                        if (!f2.a)
                        {
                            break label1;
                        }
                        k1 = f2.b & 7;
                        int j2 = f2.b & 0x70;
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
                        if (f2.width != -2)
                        {
                            k2 = 0x40000000;
                            float f1;
                            int l2;
                            int i3;
                            if (f2.width != -1)
                            {
                                k1 = f2.width;
                            } else
                            {
                                k1 = i1;
                            }
                        } else
                        {
                            k2 = k1;
                            k1 = i1;
                        }
                        if (f2.height == -2)
                        {
                            break label0;
                        }
                        l2 = 0x40000000;
                        l1 = l2;
                        if (f2.height == -1)
                        {
                            break label0;
                        }
                        i3 = f2.height;
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
            u = android.view.View.MeasureSpec.makeMeasureSpec(i1, 0x40000000);
            v = android.view.View.MeasureSpec.makeMeasureSpec(j1, 0x40000000);
            w = true;
            b();
            w = false;
            k1 = getChildCount();
            for (i1 = 0; i1 < k1; i1++)
            {
                view = getChildAt(i1);
                if (view.getVisibility() == 8)
                {
                    continue;
                }
                f2 = (f)view.getLayoutParams();
                if (f2 == null || !f2.a)
                {
                    f1 = j1;
                    l1 = android.view.View.MeasureSpec.makeMeasureSpec((int)(f2.c * f1), 0x40000000);
                    view.measure(u, l1);
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
            e e1 = a(view);
            if (e1 != null && e1.b == i && view.requestFocus(i1, rect))
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
        if (h != null)
        {
            h.a(((SavedState) (parcelable)).b, ((SavedState) (parcelable)).c);
            a(((SavedState) (parcelable)).a, false, true);
            return;
        } else
        {
            j = ((SavedState) (parcelable)).a;
            k = ((SavedState) (parcelable)).b;
            l = ((SavedState) (parcelable)).c;
            return;
        }
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.a = i;
        if (h != null)
        {
            savedstate.b = h.b();
        }
        return savedstate;
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        if (j1 != l1)
        {
            a(j1, l1, o, o);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i1;
        int j1;
        j1 = 0;
        if (P)
        {
            return true;
        }
        if (motionevent.getAction() == 0 && motionevent.getEdgeFlags() != 0)
        {
            return false;
        }
        if (h == null || h.c() == 0)
        {
            return false;
        }
        if (K == null)
        {
            K = VelocityTracker.obtain();
        }
        K.addMovement(motionevent);
        i1 = j1;
        motionevent.getAction() & 0xff;
        JVM INSTR tableswitch 0 6: default 124
    //                   0 139
    //                   1 391
    //                   2 201
    //                   3 675
    //                   4 128
    //                   5 726
    //                   6 759;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L6:
        break; /* Loop/switch isn't completed */
_L1:
        i1 = j1;
_L10:
        if (i1 != 0)
        {
            ap.d(this);
        }
        return true;
_L2:
        m.abortAnimation();
        y = false;
        b();
        float f1 = motionevent.getX();
        H = f1;
        F = f1;
        f1 = motionevent.getY();
        I = f1;
        G = f1;
        J = android.support.v4.view.z.b(motionevent, 0);
        i1 = j1;
        continue; /* Loop/switch isn't completed */
_L4:
        if (!A)
        {
            i1 = android.support.v4.view.z.a(motionevent, J);
            float f2 = android.support.v4.view.z.d(motionevent, i1);
            float f6 = Math.abs(f2 - G);
            float f4 = android.support.v4.view.z.c(motionevent, i1);
            float f7 = Math.abs(f4 - F);
            if (f6 > (float)E && f6 > f7)
            {
                A = true;
                h();
                ViewParent viewparent;
                if (f2 - I > 0.0F)
                {
                    f2 = I + (float)E;
                } else
                {
                    f2 = I - (float)E;
                }
                G = f2;
                F = f4;
                setScrollState(1);
                setScrollingCacheEnabled(true);
                viewparent = getParent();
                if (viewparent != null)
                {
                    viewparent.requestDisallowInterceptTouchEvent(true);
                }
            }
        }
        i1 = j1;
        if (A)
        {
            i1 = a(android.support.v4.view.z.d(motionevent, android.support.v4.view.z.a(motionevent, J))) | false;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        i1 = j1;
        if (A)
        {
            Object obj = K;
            ((VelocityTracker) (obj)).computeCurrentVelocity(1000, M);
            int k1 = (int)ak.b(((VelocityTracker) (obj)), J);
            y = true;
            j1 = getClientHeight();
            int l1 = getScrollY();
            obj = i();
            i1 = ((e) (obj)).b;
            float f5 = ((float)l1 / (float)j1 - ((e) (obj)).e) / ((e) (obj)).d;
            if (Math.abs((int)(android.support.v4.view.z.d(motionevent, android.support.v4.view.z.a(motionevent, J)) - I)) > N && Math.abs(k1) > L)
            {
                if (k1 <= 0)
                {
                    i1++;
                }
            } else
            {
                float f3;
                if (i1 >= i)
                {
                    f3 = 0.4F;
                } else
                {
                    f3 = 0.6F;
                }
                i1 = (int)((float)i1 + f5 + f3);
            }
            j1 = i1;
            if (e.size() > 0)
            {
                motionevent = (e)e.get(0);
                e e1 = (e)e.get(e.size() - 1);
                j1 = Math.max(((e) (motionevent)).b, Math.min(i1, e1.b));
            }
            a(j1, true, true, k1);
            J = -1;
            j();
            i1 = Q.c() | R.c();
        }
        continue; /* Loop/switch isn't completed */
_L5:
        i1 = j1;
        if (A)
        {
            a(i, true, 0, false);
            J = -1;
            j();
            i1 = Q.c() | R.c();
        }
        continue; /* Loop/switch isn't completed */
_L7:
        i1 = android.support.v4.view.z.b(motionevent);
        G = android.support.v4.view.z.d(motionevent, i1);
        J = android.support.v4.view.z.b(motionevent, i1);
        i1 = j1;
        continue; /* Loop/switch isn't completed */
_L8:
        a(motionevent);
        G = android.support.v4.view.z.d(motionevent, android.support.v4.view.z.a(motionevent, J));
        i1 = j1;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void removeView(View view)
    {
        if (w)
        {
            removeViewInLayout(view);
            return;
        } else
        {
            super.removeView(view);
            return;
        }
    }

    public void setAdapter(ae ae1)
    {
        boolean flag;
label0:
        {
            if (h != null)
            {
                h.b(n);
                for (int i1 = 0; i1 < e.size(); i1++)
                {
                    e e1 = (e)e.get(i1);
                    h.a(e1.b, e1.a);
                }

                h.a();
                e.clear();
                int k1;
                for (int j1 = 0; j1 < getChildCount(); j1 = k1 + 1)
                {
                    k1 = j1;
                    if (!((f)getChildAt(j1).getLayoutParams()).a)
                    {
                        removeViewAt(j1);
                        k1 = j1 - 1;
                    }
                }

                i = 0;
                scrollTo(0, 0);
            }
            h = ae1;
            b = 0;
            if (h != null)
            {
                if (n == null)
                {
                    n = new i(this, (byte)0);
                }
                h.a(n);
                y = false;
                flag = S;
                S = true;
                b = h.c();
                if (j < 0)
                {
                    break label0;
                }
                h.a(k, l);
                a(j, false, true);
                j = -1;
                k = null;
                l = null;
            }
            return;
        }
        if (!flag)
        {
            b();
            return;
        } else
        {
            requestLayout();
            return;
        }
    }

    void setChildrenDrawingOrderEnabledCompat(boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT < 7)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        if (ad == null)
        {
            try
            {
                ad = android/view/ViewGroup.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[] {
                    Boolean.TYPE
                });
            }
            catch (NoSuchMethodException nosuchmethodexception)
            {
                Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", nosuchmethodexception);
            }
        }
        ad.invoke(this, new Object[] {
            Boolean.valueOf(flag)
        });
        return;
        Exception exception;
        exception;
        Log.e("ViewPager", "Error changing children drawing order", exception);
        return;
    }

    public void setCurrentItem(int i1)
    {
        y = false;
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

    public void setOffscreenPageLimit(int i1)
    {
        int j1 = i1;
        if (i1 <= 0)
        {
            Log.w("ViewPager", (new StringBuilder("Requested offscreen page limit ")).append(i1).append(" too small; defaulting to 1").toString());
            j1 = 1;
        }
        if (j1 != z)
        {
            z = j1;
            b();
        }
    }

    void setOnAdapterChangeListener(h h1)
    {
        ab = h1;
    }

    public void setOnPageChangeListener(cd cd1)
    {
        W = cd1;
    }

    public void setPageMargin(int i1)
    {
        int j1 = o;
        o = i1;
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
        p = drawable;
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

    protected boolean verifyDrawable(Drawable drawable)
    {
        return super.verifyDrawable(drawable) || drawable == p;
    }


    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = android.support.v4.b.a.a(new j());
        int a;
        Parcelable b;
        ClassLoader c;

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


        SavedState(Parcel parcel, ClassLoader classloader)
        {
            super(parcel);
            ClassLoader classloader1 = classloader;
            if (classloader == null)
            {
                classloader1 = getClass().getClassLoader();
            }
            a = parcel.readInt();
            b = parcel.readParcelable(classloader1);
            c = classloader1;
        }

        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

}
