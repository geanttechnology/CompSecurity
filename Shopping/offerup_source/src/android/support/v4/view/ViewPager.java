// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.widget.ab;
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
import java.util.List;

// Referenced classes of package android.support.v4.view:
//            cg, ch, cr, ck, 
//            ci, bb, cl, co, 
//            bi, at, bv, cm, 
//            cj, w, be, cp, 
//            cn

public class ViewPager extends ViewGroup
{

    private static final int a[] = {
        0x10100b3
    };
    private static final cr ab = new cr();
    private static final Comparator c = new cg();
    private static final Interpolator d = new ch();
    private boolean A;
    private int B;
    private int C;
    private int D;
    private float E;
    private float F;
    private float G;
    private float H;
    private int I;
    private VelocityTracker J;
    private int K;
    private int L;
    private int M;
    private int N;
    private ab O;
    private ab P;
    private boolean Q;
    private boolean R;
    private int S;
    private List T;
    private co U;
    private cn V;
    private Method W;
    private ArrayList aa;
    private final Runnable ac;
    private int ad;
    private int b;
    private final ArrayList e;
    private final ck f;
    private final Rect g;
    private bb h;
    private int i;
    private int j;
    private Parcelable k;
    private ClassLoader l;
    private Scroller m;
    private cp n;
    private int o;
    private Drawable p;
    private int q;
    private int r;
    private float s;
    private float t;
    private int u;
    private boolean v;
    private boolean w;
    private boolean x;
    private int y;
    private boolean z;

    public ViewPager(Context context)
    {
        super(context);
        e = new ArrayList();
        f = new ck();
        g = new Rect();
        j = -1;
        k = null;
        l = null;
        s = -3.402823E+38F;
        t = 3.402823E+38F;
        y = 1;
        I = -1;
        Q = true;
        ac = new ci(this);
        ad = 0;
        d();
    }

    public ViewPager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        e = new ArrayList();
        f = new ck();
        g = new Rect();
        j = -1;
        k = null;
        l = null;
        s = -3.402823E+38F;
        t = 3.402823E+38F;
        y = 1;
        I = -1;
        Q = true;
        ac = new ci(this);
        ad = 0;
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

    static bb a(ViewPager viewpager)
    {
        return viewpager.h;
    }

    private ck a(int i1, int j1)
    {
        ck ck1 = new ck();
        ck1.b = i1;
        ck1.a = h.a(this, i1);
        ck1.d = 1.0F;
        if (j1 < 0 || j1 >= e.size())
        {
            e.add(ck1);
            return ck1;
        } else
        {
            e.add(j1, ck1);
            return ck1;
        }
    }

    private ck a(View view)
    {
        for (int i1 = 0; i1 < e.size(); i1++)
        {
            ck ck1 = (ck)e.get(i1);
            if (h.a(view, ck1.a))
            {
                return ck1;
            }
        }

        return null;
    }

    private void a(int i1)
    {
        float f1;
        float f2;
        float f3;
        Object obj;
        android.content.res.Resources.NotFoundException notfoundexception;
        Object obj1;
        Object obj2;
        Object obj3;
        int j1;
        byte byte1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        if (i != i1)
        {
            byte byte0;
            if (i < i1)
            {
                byte0 = 66;
            } else
            {
                byte0 = 17;
            }
            obj1 = b(i);
            i = i1;
            byte1 = byte0;
        } else
        {
            obj1 = null;
            byte1 = 2;
        }
        break MISSING_BLOCK_LABEL_39;
_L13:
        do
        {
            return;
        } while (h == null || x || getWindowToken() == null);
        i1 = y;
        l2 = Math.max(0, i - i1);
        j2 = h.b();
        k2 = Math.min(j2 - 1, i1 + i);
        if (j2 != b)
        {
            try
            {
                obj = getResources().getResourceName(getId());
            }
            // Misplaced declaration of an exception variable
            catch (android.content.res.Resources.NotFoundException notfoundexception)
            {
                notfoundexception = Integer.toHexString(getId());
            }
            throw new IllegalStateException((new StringBuilder("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ")).append(b).append(", found: ").append(j2).append(" Pager id: ").append(((String) (obj))).append(" Pager class: ").append(getClass()).append(" Problematic adapter: ").append(h.getClass()).toString());
        }
        i1 = 0;
_L10:
        if (i1 >= e.size())
        {
            break MISSING_BLOCK_LABEL_1249;
        }
        notfoundexception = (ck)e.get(i1);
        if (((ck) (notfoundexception)).b < i) goto _L2; else goto _L1
_L1:
        if (((ck) (notfoundexception)).b != i)
        {
            break MISSING_BLOCK_LABEL_1249;
        }
_L18:
        if (notfoundexception == null && j2 > 0)
        {
            obj2 = a(i, i1);
        } else
        {
            obj2 = notfoundexception;
        }
        if (obj2 == null) goto _L4; else goto _L3
_L3:
        i2 = i1 - 1;
        if (i2 >= 0)
        {
            notfoundexception = (ck)e.get(i2);
        } else
        {
            notfoundexception = null;
        }
        i3 = getClientWidth();
        if (i3 <= 0)
        {
            f2 = 0.0F;
        } else
        {
            f2 = (2.0F - ((ck) (obj2)).d) + (float)getPaddingLeft() / (float)i3;
        }
        j1 = i;
        f3 = 0.0F;
        l1 = j1 - 1;
        k1 = i1;
        obj3 = notfoundexception;
        if (l1 < 0) goto _L6; else goto _L5
_L5:
        if (f3 < f2 || l1 >= l2) goto _L8; else goto _L7
_L7:
        if (obj3 == null) goto _L6; else goto _L9
_L9:
        notfoundexception = ((android.content.res.Resources.NotFoundException) (obj3));
        i1 = i2;
        f1 = f3;
        j1 = k1;
        if (l1 == ((ck) (obj3)).b)
        {
            notfoundexception = ((android.content.res.Resources.NotFoundException) (obj3));
            i1 = i2;
            f1 = f3;
            j1 = k1;
            if (!((ck) (obj3)).c)
            {
                e.remove(i2);
                h.a(this, l1, ((ck) (obj3)).a);
                i1 = i2 - 1;
                j1 = k1 - 1;
                if (i1 >= 0)
                {
                    notfoundexception = (ck)e.get(i1);
                    f1 = f3;
                } else
                {
                    notfoundexception = null;
                    f1 = f3;
                }
            }
        }
_L11:
        l1--;
        obj3 = notfoundexception;
        i2 = i1;
        f3 = f1;
        k1 = j1;
        break MISSING_BLOCK_LABEL_359;
_L2:
        i1++;
          goto _L10
_L8:
        if (obj3 != null && l1 == ((ck) (obj3)).b)
        {
            f1 = f3 + ((ck) (obj3)).d;
            i1 = i2 - 1;
            if (i1 >= 0)
            {
                notfoundexception = (ck)e.get(i1);
                j1 = k1;
            } else
            {
                notfoundexception = null;
                j1 = k1;
            }
        } else
        {
            f1 = f3 + a(l1, i2 + 1).d;
            j1 = k1 + 1;
            if (i2 >= 0)
            {
                notfoundexception = (ck)e.get(i2);
                i1 = i2;
            } else
            {
                notfoundexception = null;
                i1 = i2;
            }
        }
          goto _L11
_L6:
label0:
        {
            f1 = ((ck) (obj2)).d;
            i1 = k1 + 1;
            if (f1 >= 2.0F)
            {
                break label0;
            }
            if (i1 < e.size())
            {
                notfoundexception = (ck)e.get(i1);
            } else
            {
                notfoundexception = null;
            }
            if (i3 <= 0)
            {
                f2 = 0.0F;
            } else
            {
                f2 = (float)getPaddingRight() / (float)i3 + 2.0F;
            }
            j1 = i;
            j1++;
            do
            {
                if (j1 >= j2)
                {
                    break label0;
                }
                if (f1 >= f2 && j1 > k2)
                {
                    if (notfoundexception == null)
                    {
                        break label0;
                    }
                    if (j1 == ((ck) (notfoundexception)).b && !((ck) (notfoundexception)).c)
                    {
                        e.remove(i1);
                        h.a(this, j1, ((ck) (notfoundexception)).a);
                        if (i1 < e.size())
                        {
                            notfoundexception = (ck)e.get(i1);
                        } else
                        {
                            notfoundexception = null;
                        }
                    }
                } else
                if (notfoundexception != null && j1 == ((ck) (notfoundexception)).b)
                {
                    f3 = ((ck) (notfoundexception)).d;
                    i1++;
                    if (i1 < e.size())
                    {
                        notfoundexception = (ck)e.get(i1);
                    } else
                    {
                        notfoundexception = null;
                    }
                    f1 += f3;
                } else
                {
                    notfoundexception = a(j1, i1);
                    i1++;
                    f3 = ((ck) (notfoundexception)).d;
                    if (i1 < e.size())
                    {
                        notfoundexception = (ck)e.get(i1);
                    } else
                    {
                        notfoundexception = null;
                    }
                    f1 += f3;
                }
                j1++;
            } while (true);
        }
        a(((ck) (obj2)), k1, ((ck) (obj1)));
_L4:
        obj1 = h;
        i1 = i;
        if (obj2 != null)
        {
            notfoundexception = ((android.content.res.Resources.NotFoundException) (((ck) (obj2)).a));
        } else
        {
            notfoundexception = null;
        }
        ((bb) (obj1)).b(this, i1, notfoundexception);
        h.a(this);
        j1 = getChildCount();
        for (i1 = 0; i1 < j1; i1++)
        {
            obj1 = getChildAt(i1);
            notfoundexception = (cl)((View) (obj1)).getLayoutParams();
            notfoundexception.f = i1;
            if (((cl) (notfoundexception)).a || ((cl) (notfoundexception)).c != 0.0F)
            {
                continue;
            }
            obj1 = a(((View) (obj1)));
            if (obj1 != null)
            {
                notfoundexception.c = ((ck) (obj1)).d;
                notfoundexception.e = ((ck) (obj1)).b;
            }
        }

        if (!hasFocus()) goto _L13; else goto _L12
_L12:
        notfoundexception = findFocus();
        if (notfoundexception != null)
        {
            notfoundexception = b(notfoundexception);
        } else
        {
            notfoundexception = null;
        }
        if (notfoundexception != null && ((ck) (notfoundexception)).b == i) goto _L13; else goto _L14
_L14:
        i1 = 0;
_L17:
        if (i1 >= getChildCount()) goto _L13; else goto _L15
_L15:
        notfoundexception = getChildAt(i1);
        obj1 = a(((View) (notfoundexception)));
        if (obj1 != null && ((ck) (obj1)).b == i && notfoundexception.requestFocus(byte1)) goto _L13; else goto _L16
_L16:
        i1++;
          goto _L17
        notfoundexception = null;
          goto _L18
    }

    private void a(int i1, float f1, int j1)
    {
        if (S <= 0) goto _L2; else goto _L1
_L1:
        int k1;
        int l1;
        int l2;
        int i3;
        int j3;
        int k3;
        i3 = getScrollX();
        k1 = getPaddingLeft();
        l1 = getPaddingRight();
        j3 = getWidth();
        k3 = getChildCount();
        l2 = 0;
_L8:
        if (l2 >= k3) goto _L2; else goto _L3
_L3:
        View view;
        cl cl1;
        view = getChildAt(l2);
        cl1 = (cl)view.getLayoutParams();
        if (!cl1.a)
        {
            break MISSING_BLOCK_LABEL_382;
        }
        cl1.b & 7;
        JVM INSTR tableswitch 1 5: default 116
    //                   1 219
    //                   2 116
    //                   3 190
    //                   4 116
    //                   5 251;
           goto _L4 _L5 _L4 _L6 _L4 _L7
_L4:
        int i2;
        i2 = k1;
        int j2 = l1;
        l1 = k1;
        k1 = j2;
_L9:
        int k2;
        int l3 = (i2 + i3) - view.getLeft();
        i2 = k1;
        k2 = l1;
        if (l3 != 0)
        {
            view.offsetLeftAndRight(l3);
            k2 = l1;
            i2 = k1;
        }
_L10:
        l2++;
        k1 = k2;
        l1 = i2;
          goto _L8
_L6:
        i2 = view.getWidth();
        k2 = i2 + k1;
        i2 = k1;
        k1 = l1;
        l1 = k2;
          goto _L9
_L5:
        i2 = Math.max((j3 - view.getMeasuredWidth()) / 2, k1);
        k2 = k1;
        k1 = l1;
        l1 = k2;
          goto _L9
_L7:
        i2 = j3 - l1 - view.getMeasuredWidth();
        int i4 = view.getMeasuredWidth();
        k2 = k1;
        k1 = l1 + i4;
        l1 = k2;
          goto _L9
_L2:
        if (U != null)
        {
            U.a(i1, f1, j1);
        }
        if (T != null)
        {
            l1 = T.size();
            for (k1 = 0; k1 < l1; k1++)
            {
                co co1 = (co)T.get(k1);
                if (co1 != null)
                {
                    co1.a(i1, f1, j1);
                }
            }

        }
        R = true;
        return;
        i2 = l1;
        k2 = k1;
          goto _L10
    }

    private void a(int i1, int j1, int k1, int l1)
    {
        if (j1 > 0 && !e.isEmpty())
        {
            int i2 = getPaddingLeft();
            int j2 = getPaddingRight();
            int k2 = getPaddingLeft();
            int l2 = getPaddingRight();
            float f1 = (float)getScrollX() / (float)((j1 - k2 - l2) + l1);
            j1 = (int)((float)((i1 - i2 - j2) + k1) * f1);
            scrollTo(j1, getScrollY());
            if (!m.isFinished())
            {
                k1 = m.getDuration();
                l1 = m.timePassed();
                ck ck1 = b(i);
                m.startScroll(j1, 0, (int)(ck1.e * (float)i1), 0, k1 - l1);
            }
        } else
        {
            ck ck2 = b(i);
            float f2;
            if (ck2 != null)
            {
                f2 = Math.min(ck2.e, t);
            } else
            {
                f2 = 0.0F;
            }
            i1 = (int)(f2 * (float)(i1 - getPaddingLeft() - getPaddingRight()));
            if (i1 != getScrollX())
            {
                a(false);
                scrollTo(i1, getScrollY());
                return;
            }
        }
    }

    private void a(int i1, boolean flag)
    {
        x = false;
        a(i1, true, false);
    }

    private void a(int i1, boolean flag, int j1, boolean flag1)
    {
        ck ck1 = b(i1);
        int k1 = 0;
        if (ck1 != null)
        {
            k1 = (int)((float)getClientWidth() * Math.max(s, Math.min(ck1.e, t)));
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
                k1 -= l1;
                int j2 = 0 - i2;
                if (k1 == 0 && j2 == 0)
                {
                    a(false);
                    b();
                    setScrollState(0);
                } else
                {
                    setScrollingCacheEnabled(true);
                    setScrollState(2);
                    int k2 = getClientWidth();
                    int l2 = k2 / 2;
                    float f4 = Math.min(1.0F, (1.0F * (float)Math.abs(k1)) / (float)k2);
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
                        j1 = (int)(((float)Math.abs(k1) / (f2 + (float)o) + 1.0F) * 100F);
                    }
                    j1 = Math.min(j1, 600);
                    m.startScroll(l1, i2, k1, j2, j1);
                    bi.d(this);
                }
            }
        } else
        {
            if (flag1)
            {
                d(i1);
            }
            a(false);
            scrollTo(k1, 0);
            c(k1);
            return;
        }
        if (flag1)
        {
            d(i1);
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
        if (h == null || h.b() <= 0)
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
        i1 = y;
        if (k1 > i + i1 || k1 < i - i1)
        {
            for (i1 = 0; i1 < e.size(); i1++)
            {
                ((ck)e.get(i1)).c = true;
            }

        }
        break; /* Loop/switch isn't completed */
_L2:
        k1 = i1;
        if (i1 >= h.b())
        {
            k1 = h.b() - 1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        flag1 = flag2;
        if (i != k1)
        {
            flag1 = true;
        }
        if (Q)
        {
            i = k1;
            if (flag1)
            {
                d(k1);
            }
            requestLayout();
            return;
        } else
        {
            a(k1);
            a(k1, flag, j1, flag1);
            return;
        }
    }

    static void a(ViewPager viewpager, int i1)
    {
        viewpager.setScrollState(0);
    }

    private void a(ck ck1, int i1, ck ck2)
    {
        int j2 = h.b();
        int j1 = getClientWidth();
        float f4;
        if (j1 > 0)
        {
            f4 = (float)o / (float)j1;
        } else
        {
            f4 = 0.0F;
        }
        if (ck2 != null)
        {
            j1 = ck2.b;
            if (j1 < ck1.b)
            {
                float f1 = ck2.e;
                float f5 = ck2.d;
                int k1 = 0;
                f1 = f1 + f5 + f4;
                for (j1++; j1 <= ck1.b && k1 < e.size(); j1++)
                {
                    for (ck2 = (ck)e.get(k1); j1 > ck2.b && k1 < e.size() - 1; ck2 = (ck)e.get(k1))
                    {
                        k1++;
                    }

                    while (j1 < ck2.b) 
                    {
                        j1++;
                        f1 = f4 + 1.0F + f1;
                    }
                    ck2.e = f1;
                    f1 += ck2.d + f4;
                }

            } else
            if (j1 > ck1.b)
            {
                int l1 = e.size();
                float f2 = ck2.e;
                l1--;
                for (j1--; j1 >= ck1.b && l1 >= 0; j1--)
                {
                    for (ck2 = (ck)e.get(l1); j1 < ck2.b && l1 > 0; ck2 = (ck)e.get(l1))
                    {
                        l1--;
                    }

                    while (j1 > ck2.b) 
                    {
                        j1--;
                        f2 -= f4 + 1.0F;
                    }
                    f2 -= ck2.d + f4;
                    ck2.e = f2;
                }

            }
        }
        int k2 = e.size();
        float f6 = ck1.e;
        j1 = ck1.b - 1;
        float f3;
        int i2;
        if (ck1.b == 0)
        {
            f3 = ck1.e;
        } else
        {
            f3 = -3.402823E+38F;
        }
        s = f3;
        if (ck1.b == j2 - 1)
        {
            f3 = (ck1.e + ck1.d) - 1.0F;
        } else
        {
            f3 = 3.402823E+38F;
        }
        t = f3;
        i2 = i1 - 1;
        f3 = f6;
        for (; i2 >= 0; i2--)
        {
            for (ck2 = (ck)e.get(i2); j1 > ck2.b;)
            {
                j1--;
                f3 -= f4 + 1.0F;
            }

            f3 -= ck2.d + f4;
            ck2.e = f3;
            if (ck2.b == 0)
            {
                s = f3;
            }
            j1--;
        }

        f3 = ck1.e + ck1.d + f4;
        i2 = ck1.b + 1;
        j1 = i1 + 1;
        i1 = i2;
        for (; j1 < k2; j1++)
        {
            for (ck1 = (ck)e.get(j1); i1 < ck1.b;)
            {
                i1++;
                f3 += f4 + 1.0F;
            }

            if (ck1.b == j2 - 1)
            {
                t = (ck1.d + f3) - 1.0F;
            }
            ck1.e = f3;
            f3 += ck1.d + f4;
            i1++;
        }

    }

    private void a(MotionEvent motionevent)
    {
        int i1 = at.b(motionevent);
        if (at.b(motionevent, i1) == I)
        {
            if (i1 == 0)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            E = at.c(motionevent, i1);
            I = at.b(motionevent, i1);
            if (J != null)
            {
                J.clear();
            }
        }
    }

    private void a(boolean flag)
    {
label0:
        {
            int i1;
            boolean flag1;
            boolean flag2;
            if (ad == 2)
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
                    if (l1 != j1)
                    {
                        c(l1);
                    }
                }
            }
            x = false;
            flag2 = false;
            flag1 = i1;
            for (i1 = ((flag2) ? 1 : 0); i1 < e.size(); i1++)
            {
                ck ck1 = (ck)e.get(i1);
                if (ck1.c)
                {
                    ck1.c = false;
                    flag1 = true;
                }
            }

            if (flag1)
            {
                if (!flag)
                {
                    break label0;
                }
                bi.a(this, ac);
            }
            return;
        }
        ac.run();
    }

    private boolean a(float f1)
    {
        boolean flag1 = true;
        boolean flag3 = false;
        boolean flag2 = false;
        float f2 = E;
        E = f1;
        float f3 = (float)getScrollX() + (f2 - f1);
        int i1 = getClientWidth();
        f1 = (float)i1 * s;
        f2 = i1;
        float f4 = t;
        ck ck1 = (ck)e.get(0);
        ck ck2 = (ck)e.get(e.size() - 1);
        boolean flag;
        if (ck1.b != 0)
        {
            f1 = ck1.e * (float)i1;
            flag = false;
        } else
        {
            flag = true;
        }
        if (ck2.b != h.b() - 1)
        {
            f2 = ck2.e * (float)i1;
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
            flag2 = O.a(Math.abs(f1 - f3) / (float)i1);
            f2 = f1;
        }
_L4:
        E = E + (f2 - (float)(int)f2);
        scrollTo((int)f2, getScrollY());
        c((int)f2);
        return flag2;
_L2:
        if (f3 > f2)
        {
            flag2 = flag3;
            if (flag1)
            {
                flag2 = P.a(Math.abs(f3 - f2) / (float)i1);
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
        if (j1 + i2 < view1.getLeft() || j1 + i2 >= view1.getRight() || k1 + j2 < view1.getTop() || k1 + j2 >= view1.getBottom() || !a(view1, true, i1, (j1 + i2) - view1.getLeft(), (k1 + j2) - view1.getTop())) goto _L5; else goto _L4
_L4:
        return true;
_L5:
        l1--;
        continue; /* Loop/switch isn't completed */
_L2:
        if (flag && bi.a(view, -i1)) goto _L4; else goto _L6
_L6:
        return false;
        if (true) goto _L8; else goto _L7
_L7:
    }

    static int b(ViewPager viewpager)
    {
        return viewpager.i;
    }

    private ck b(int i1)
    {
        for (int j1 = 0; j1 < e.size(); j1++)
        {
            ck ck1 = (ck)e.get(j1);
            if (ck1.b == i1)
            {
                return ck1;
            }
        }

        return null;
    }

    private ck b(View view)
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
        ViewParent viewparent = getParent();
        if (viewparent != null)
        {
            viewparent.requestDisallowInterceptTouchEvent(true);
        }
    }

    private boolean c(int i1)
    {
        boolean flag = false;
        if (e.size() == 0)
        {
            R = false;
            a(0, 0.0F, 0);
            if (!R)
            {
                throw new IllegalStateException("onPageScrolled did not call superclass implementation");
            }
        } else
        {
            ck ck1 = e();
            int k1 = getClientWidth();
            int l1 = o;
            float f1 = (float)o / (float)k1;
            int j1 = ck1.b;
            f1 = ((float)i1 / (float)k1 - ck1.e) / (ck1.d + f1);
            i1 = (int)((float)(l1 + k1) * f1);
            R = false;
            a(j1, f1, i1);
            if (!R)
            {
                throw new IllegalStateException("onPageScrolled did not call superclass implementation");
            }
            flag = true;
        }
        return flag;
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
        D = bv.a(viewconfiguration);
        K = (int)(400F * f1);
        L = viewconfiguration.getScaledMaximumFlingVelocity();
        O = new ab(context);
        P = new ab(context);
        M = (int)(25F * f1);
        N = (int)(2.0F * f1);
        B = (int)(16F * f1);
        bi.a(this, new cm(this));
        if (bi.e(this) == 0)
        {
            bi.c(this, 1);
        }
    }

    private void d(int i1)
    {
        if (U != null)
        {
            U.a(i1);
        }
        if (T != null)
        {
            int k1 = T.size();
            for (int j1 = 0; j1 < k1; j1++)
            {
                co co1 = (co)T.get(j1);
                if (co1 != null)
                {
                    co1.a(i1);
                }
            }

        }
    }

    private ck e()
    {
        int i1 = getClientWidth();
        float f1;
        float f2;
        float f3;
        float f4;
        ck ck2;
        boolean flag;
        int j1;
        if (i1 > 0)
        {
            f1 = (float)getScrollX() / (float)i1;
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
        ck2 = null;
        do
        {
            ck ck1;
label0:
            {
                ck ck3;
label1:
                {
                    ck3 = ck2;
                    if (i1 >= e.size())
                    {
                        break label1;
                    }
                    ck1 = (ck)e.get(i1);
                    if (!flag && ck1.b != j1 + 1)
                    {
                        ck1 = f;
                        ck1.e = f4 + f3 + f2;
                        ck1.b = j1 + 1;
                        ck1.d = 1.0F;
                        i1--;
                    }
                    f3 = ck1.e;
                    f4 = ck1.d;
                    if (!flag)
                    {
                        ck3 = ck2;
                        if (f1 < f3)
                        {
                            break label1;
                        }
                    }
                    if (f1 >= f4 + f3 + f2 && i1 != e.size() - 1)
                    {
                        break label0;
                    }
                    ck3 = ck1;
                }
                return ck3;
            }
            j1 = ck1.b;
            f4 = ck1.d;
            flag = false;
            i1++;
            ck2 = ck1;
        } while (true);
    }

    private boolean e(int i1)
    {
        View view = findFocus();
        if (view != this) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L13:
        view = FocusFinder.getInstance().findNextFocus(this, ((View) (obj)), i1);
        if (view == null || view == obj) goto _L4; else goto _L3
_L3:
        if (i1 != 17) goto _L6; else goto _L5
_L5:
        int j1;
        boolean flag;
        j1 = a(g, view).left;
        int k1 = a(g, ((View) (obj))).left;
        StringBuilder stringbuilder;
        if (obj != null && j1 >= k1)
        {
            flag = g();
        } else
        {
            flag = view.requestFocus();
        }
_L16:
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
            break MISSING_BLOCK_LABEL_356;
        }
        if (obj != this) goto _L10; else goto _L9
_L9:
        j1 = 1;
_L18:
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
        if (i1 != 66) goto _L15; else goto _L14
_L14:
        j1 = a(g, view).left;
        int l1 = a(g, ((View) (obj))).left;
        if (obj != null && j1 <= l1)
        {
            flag = h();
        } else
        {
            flag = view.requestFocus();
        }
          goto _L16
_L4:
label0:
        {
            if (i1 != 17 && i1 != 1)
            {
                break label0;
            }
            flag = g();
        }
          goto _L16
        if (i1 != 66 && i1 != 2) goto _L15; else goto _L17
_L17:
        flag = h();
          goto _L16
_L15:
        flag = false;
          goto _L16
_L8:
        obj = view;
          goto _L13
        j1 = 0;
          goto _L18
    }

    private void f()
    {
        z = false;
        A = false;
        if (J != null)
        {
            J.recycle();
            J = null;
        }
    }

    private boolean g()
    {
        if (i > 0)
        {
            a(i - 1, true);
            return true;
        } else
        {
            return false;
        }
    }

    private int getClientWidth()
    {
        return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
    }

    private boolean h()
    {
        if (h != null && i < h.b() - 1)
        {
            a(i + 1, true);
            return true;
        } else
        {
            return false;
        }
    }

    private void setScrollState(int i1)
    {
        if (ad != i1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        ad = i1;
        if (U != null)
        {
            U.b(i1);
        }
        if (T != null)
        {
            int k1 = T.size();
            int j1 = 0;
            while (j1 < k1) 
            {
                co co1 = (co)T.get(j1);
                if (co1 != null)
                {
                    co1.b(i1);
                }
                j1++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private void setScrollingCacheEnabled(boolean flag)
    {
        if (w != flag)
        {
            w = flag;
        }
    }

    final void a()
    {
        int i1 = h.b();
        b = i1;
        boolean flag;
        int i2;
        if (e.size() < (y << 1) + 1 && e.size() < i1)
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
                cl cl1 = (cl)getChildAt(j1).getLayoutParams();
                if (!cl1.a)
                {
                    cl1.c = 0.0F;
                }
            }

            a(i2, false, true);
            requestLayout();
        }
    }

    public final void a(co co1)
    {
        if (T == null)
        {
            T = new ArrayList();
        }
        T.add(co1);
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
                    ck ck1 = a(view);
                    if (ck1 != null && ck1.b == i)
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
            ck ck1 = a(view);
            if (ck1 != null && ck1.b == i)
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
        cl cl1 = (cl)layoutparams;
        cl1.a = cl1.a | (view instanceof cj);
        if (v)
        {
            if (cl1 != null && cl1.a)
            {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            } else
            {
                cl1.d = true;
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
        a(i);
    }

    public boolean canScrollHorizontally(int i1)
    {
        if (h != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int j1;
        int k1;
        j1 = getClientWidth();
        k1 = getScrollX();
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

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return (layoutparams instanceof cl) && super.checkLayoutParams(layoutparams);
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
                if (!c(k1))
                {
                    m.abortAnimation();
                    scrollTo(0, l1);
                }
            }
            bi.d(this);
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
        flag = e(17);
          goto _L9
_L6:
        flag = e(66);
          goto _L9
_L7:
        if (android.os.Build.VERSION.SDK_INT < 11) goto _L4; else goto _L10
_L10:
        if (!android.support.v4.view.w.a(keyevent))
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = e(2);
          goto _L9
        if (!android.support.v4.view.w.a(keyevent, 1)) goto _L4; else goto _L11
_L11:
        flag = e(1);
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
                ck ck1 = a(view);
                if (ck1 != null && ck1.b == i && view.dispatchPopulateAccessibilityEvent(accessibilityevent))
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
        int k1 = bi.a(this);
        if (k1 == 0 || k1 == 1 && h != null && h.b() > 1)
        {
            if (!O.a())
            {
                j1 = canvas.save();
                i1 = getHeight() - getPaddingTop() - getPaddingBottom();
                int l1 = getWidth();
                canvas.rotate(270F);
                canvas.translate(-i1 + getPaddingTop(), s * (float)l1);
                O.a(i1, l1);
                i1 = O.a(canvas) | false;
                canvas.restoreToCount(j1);
            }
            j1 = i1;
            if (!P.a())
            {
                int i2 = canvas.save();
                j1 = getWidth();
                int j2 = getHeight();
                int k2 = getPaddingTop();
                int l2 = getPaddingBottom();
                canvas.rotate(90F);
                canvas.translate(-getPaddingTop(), -(t + 1.0F) * (float)j1);
                P.a(j2 - k2 - l2, j1);
                j1 = i1 | P.a(canvas);
                canvas.restoreToCount(i2);
            }
        } else
        {
            O.b();
            P.b();
        }
        if (j1 != 0)
        {
            bi.d(this);
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
        return new cl();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new cl(getContext(), attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return generateDefaultLayoutParams();
    }

    public bb getAdapter()
    {
        return h;
    }

    protected int getChildDrawingOrder(int i1, int j1)
    {
        return ((cl)((View)aa.get(j1)).getLayoutParams()).f;
    }

    public int getCurrentItem()
    {
        return i;
    }

    public int getOffscreenPageLimit()
    {
        return y;
    }

    public int getPageMargin()
    {
        return o;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        Q = true;
    }

    protected void onDetachedFromWindow()
    {
        removeCallbacks(ac);
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (o > 0 && p != null && e.size() > 0 && h != null)
        {
            int k1 = getScrollX();
            int l1 = getWidth();
            float f3 = (float)o / (float)l1;
            Object obj = (ck)e.get(0);
            float f1 = ((ck) (obj)).e;
            int i2 = e.size();
            int i1 = ((ck) (obj)).b;
            int j2 = ((ck)e.get(i2 - 1)).b;
            int j1 = 0;
            do
            {
                if (i1 >= j2)
                {
                    break;
                }
                for (; i1 > ((ck) (obj)).b && j1 < i2; obj = (ck)((ArrayList) (obj)).get(j1))
                {
                    obj = e;
                    j1++;
                }

                float f2;
                if (i1 == ((ck) (obj)).b)
                {
                    f2 = (((ck) (obj)).e + ((ck) (obj)).d) * (float)l1;
                    f1 = ((ck) (obj)).e + ((ck) (obj)).d + f3;
                } else
                {
                    f2 = (1.0F + f1) * (float)l1;
                    f1 += 1.0F + f3;
                }
                if ((float)o + f2 > (float)k1)
                {
                    p.setBounds((int)f2, q, (int)((float)o + f2 + 0.5F), r);
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
        z = false;
        A = false;
        I = -1;
        if (J != null)
        {
            J.recycle();
            J = null;
        }
_L4:
        return false;
_L2:
        if (i1 == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (z)
        {
            return true;
        }
        if (A) goto _L4; else goto _L3
_L3:
        i1;
        JVM INSTR lookupswitch 3: default 116
    //                   0: 428
    //                   2: 143
    //                   6: 560;
           goto _L5 _L6 _L7 _L8
_L5:
        if (J == null)
        {
            J = VelocityTracker.obtain();
        }
        J.addMovement(motionevent);
        return z;
_L7:
        float f1;
        float f3;
        float f4;
        float f5;
        float f6;
        int j1 = I;
        if (j1 == -1)
        {
            continue; /* Loop/switch isn't completed */
        }
        j1 = at.a(motionevent, j1);
        f3 = at.c(motionevent, j1);
        f1 = f3 - E;
        f5 = Math.abs(f1);
        f4 = at.d(motionevent, j1);
        f6 = Math.abs(f4 - H);
        if (f1 != 0.0F)
        {
            float f7 = E;
            boolean flag;
            if (f7 < (float)C && f1 > 0.0F || f7 > (float)(getWidth() - C) && f1 < 0.0F)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag && a(this, false, (int)f1, (int)f3, (int)f4))
            {
                E = f3;
                F = f4;
                A = true;
                return false;
            }
        }
        if (f5 <= (float)D || 0.5F * f5 <= f6) goto _L10; else goto _L9
_L9:
        z = true;
        b(true);
        setScrollState(1);
        if (f1 > 0.0F)
        {
            f1 = G + (float)D;
        } else
        {
            f1 = G - (float)D;
        }
        E = f1;
        F = f4;
        setScrollingCacheEnabled(true);
_L11:
        if (z && a(f3))
        {
            bi.d(this);
        }
        continue; /* Loop/switch isn't completed */
_L10:
        if (f6 > (float)D)
        {
            A = true;
        }
        if (true) goto _L11; else goto _L6
_L6:
        float f2 = motionevent.getX();
        G = f2;
        E = f2;
        f2 = motionevent.getY();
        H = f2;
        F = f2;
        I = at.b(motionevent, 0);
        A = false;
        m.computeScrollOffset();
        if (ad == 2 && Math.abs(m.getFinalX() - m.getCurrX()) > N)
        {
            m.abortAnimation();
            x = false;
            b();
            z = true;
            b(true);
            setScrollState(1);
        } else
        {
            a(false);
            z = false;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        a(motionevent);
        if (true) goto _L5; else goto _L12
_L12:
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        int i2;
        int j2;
        int j3;
        int l4;
        int i5;
        int j5;
        int k5;
        l4 = getChildCount();
        j5 = k1 - i1;
        i5 = l1 - j1;
        j1 = getPaddingLeft();
        i1 = getPaddingTop();
        i2 = getPaddingRight();
        k1 = getPaddingBottom();
        k5 = getScrollX();
        j2 = 0;
        j3 = 0;
_L14:
        if (j3 >= l4) goto _L2; else goto _L1
_L1:
        View view = getChildAt(j3);
        if (view.getVisibility() == 8) goto _L4; else goto _L3
_L3:
        cl cl1 = (cl)view.getLayoutParams();
        if (!cl1.a) goto _L4; else goto _L5
_L5:
        int l5;
        l1 = cl1.b;
        l5 = cl1.b;
        l1 & 7;
        JVM INSTR tableswitch 1 5: default 148
    //                   1 304
    //                   2 148
    //                   3 285
    //                   4 148
    //                   5 326;
           goto _L6 _L7 _L6 _L8 _L6 _L9
_L6:
        int k2;
        l1 = j1;
        k2 = j1;
_L15:
        l5 & 0x70;
        JVM INSTR lookupswitch 3: default 192
    //                   16: 394
    //                   48: 367
    //                   80: 422;
           goto _L10 _L11 _L12 _L13
_L10:
        int k3 = i1;
        j1 = i1;
        i1 = k1;
        k1 = k3;
_L16:
        l1 += k5;
        view.layout(l1, k1, view.getMeasuredWidth() + l1, view.getMeasuredHeight() + k1);
        j2++;
        l1 = i2;
        k1 = k2;
        i2 = i1;
        i1 = j2;
_L17:
        j3++;
        k2 = k1;
        j2 = i1;
        i1 = j1;
        k1 = i2;
        i2 = l1;
        j1 = k2;
          goto _L14
_L8:
        k2 = view.getMeasuredWidth();
        l1 = j1;
        k2 += j1;
          goto _L15
_L7:
        l1 = Math.max((j5 - view.getMeasuredWidth()) / 2, j1);
        k2 = j1;
          goto _L15
_L9:
        k2 = view.getMeasuredWidth();
        l1 = i2 + view.getMeasuredWidth();
        int l3 = j5 - i2 - k2;
        i2 = l1;
        k2 = j1;
        l1 = l3;
          goto _L15
_L12:
        int i4 = view.getMeasuredHeight();
        j1 = k1;
        i4 += i1;
        k1 = i1;
        i1 = j1;
        j1 = i4;
          goto _L16
_L11:
        int j4 = Math.max((i5 - view.getMeasuredHeight()) / 2, i1);
        j1 = i1;
        i1 = k1;
        k1 = j4;
          goto _L16
_L13:
        int k4 = i5 - k1 - view.getMeasuredHeight();
        int i6 = view.getMeasuredHeight();
        j1 = i1;
        i1 = k1 + i6;
        k1 = k4;
          goto _L16
_L2:
        i2 = j5 - j1 - i2;
        for (l1 = 0; l1 < l4; l1++)
        {
            View view1 = getChildAt(l1);
            if (view1.getVisibility() == 8)
            {
                continue;
            }
            cl cl2 = (cl)view1.getLayoutParams();
            if (cl2.a)
            {
                continue;
            }
            ck ck1 = a(view1);
            if (ck1 == null)
            {
                continue;
            }
            float f1 = i2;
            int l2 = (int)(ck1.e * f1) + j1;
            if (cl2.d)
            {
                cl2.d = false;
                float f2 = i2;
                view1.measure(android.view.View.MeasureSpec.makeMeasureSpec((int)(cl2.c * f2), 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(i5 - i1 - k1, 0x40000000));
            }
            view1.layout(l2, i1, view1.getMeasuredWidth() + l2, view1.getMeasuredHeight() + i1);
        }

        q = i1;
        r = i5 - k1;
        S = j2;
        if (Q)
        {
            a(i, false, 0, false);
        }
        Q = false;
        return;
_L4:
        l1 = j2;
        j2 = i1;
        int i3 = j1;
        i1 = l1;
        l1 = i2;
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
            i1 = getMeasuredWidth();
            C = Math.min(i1 / 10, B);
            i1 = i1 - getPaddingLeft() - getPaddingRight();
            j1 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
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
                        cl cl1 = (cl)view.getLayoutParams();
                        k1 = i1;
                        l1 = j1;
                        if (cl1 == null)
                        {
                            break label1;
                        }
                        k1 = i1;
                        l1 = j1;
                        if (!cl1.a)
                        {
                            break label1;
                        }
                        k1 = cl1.b & 7;
                        int j2 = cl1.b & 0x70;
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
                        if (cl1.width != -2)
                        {
                            k2 = 0x40000000;
                            float f1;
                            int l2;
                            int i3;
                            if (cl1.width != -1)
                            {
                                k1 = cl1.width;
                            } else
                            {
                                k1 = i1;
                            }
                        } else
                        {
                            k2 = k1;
                            k1 = i1;
                        }
                        if (cl1.height == -2)
                        {
                            break label0;
                        }
                        l2 = 0x40000000;
                        l1 = l2;
                        if (cl1.height == -1)
                        {
                            break label0;
                        }
                        i3 = cl1.height;
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
            android.view.View.MeasureSpec.makeMeasureSpec(i1, 0x40000000);
            u = android.view.View.MeasureSpec.makeMeasureSpec(j1, 0x40000000);
            v = true;
            b();
            v = false;
            k1 = getChildCount();
            for (j1 = 0; j1 < k1; j1++)
            {
                view = getChildAt(j1);
                if (view.getVisibility() == 8)
                {
                    continue;
                }
                cl1 = (cl)view.getLayoutParams();
                if (cl1 == null || !cl1.a)
                {
                    f1 = i1;
                    view.measure(android.view.View.MeasureSpec.makeMeasureSpec((int)(cl1.c * f1), 0x40000000), u);
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
            ck ck1 = a(view);
            if (ck1 != null && ck1.b == i && view.requestFocus(i1, rect))
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
            savedstate.b = h.a();
        }
        return savedstate;
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        if (i1 != k1)
        {
            a(i1, k1, o, o);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i1;
        int j1;
        j1 = 0;
        if (motionevent.getAction() == 0 && motionevent.getEdgeFlags() != 0)
        {
            return false;
        }
        if (h == null || h.b() == 0)
        {
            return false;
        }
        if (J == null)
        {
            J = VelocityTracker.obtain();
        }
        J.addMovement(motionevent);
        i1 = j1;
        motionevent.getAction() & 0xff;
        JVM INSTR tableswitch 0 6: default 116
    //                   0 131
    //                   1 384
    //                   2 193
    //                   3 668
    //                   4 120
    //                   5 719
    //                   6 752;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L6:
        break; /* Loop/switch isn't completed */
_L1:
        i1 = j1;
_L10:
        if (i1 != 0)
        {
            bi.d(this);
        }
        return true;
_L2:
        m.abortAnimation();
        x = false;
        b();
        float f1 = motionevent.getX();
        G = f1;
        E = f1;
        f1 = motionevent.getY();
        H = f1;
        F = f1;
        I = at.b(motionevent, 0);
        i1 = j1;
        continue; /* Loop/switch isn't completed */
_L4:
        if (!z)
        {
            i1 = android.support.v4.view.at.a(motionevent, I);
            float f2 = at.c(motionevent, i1);
            float f6 = Math.abs(f2 - E);
            float f4 = at.d(motionevent, i1);
            float f7 = Math.abs(f4 - F);
            if (f6 > (float)D && f6 > f7)
            {
                z = true;
                b(true);
                ViewParent viewparent;
                if (f2 - G > 0.0F)
                {
                    f2 = G + (float)D;
                } else
                {
                    f2 = G - (float)D;
                }
                E = f2;
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
        if (z)
        {
            i1 = a(at.c(motionevent, android.support.v4.view.at.a(motionevent, I))) | false;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        i1 = j1;
        if (z)
        {
            Object obj = J;
            ((VelocityTracker) (obj)).computeCurrentVelocity(1000, L);
            int k1 = (int)android.support.v4.view.be.a(((VelocityTracker) (obj)), I);
            x = true;
            j1 = getClientWidth();
            int l1 = getScrollX();
            obj = e();
            i1 = ((ck) (obj)).b;
            float f5 = ((float)l1 / (float)j1 - ((ck) (obj)).e) / ((ck) (obj)).d;
            if (Math.abs((int)(at.c(motionevent, android.support.v4.view.at.a(motionevent, I)) - G)) > M && Math.abs(k1) > K)
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
                motionevent = (ck)e.get(0);
                ck ck1 = (ck)e.get(e.size() - 1);
                j1 = Math.max(((ck) (motionevent)).b, Math.min(i1, ck1.b));
            }
            a(j1, true, true, k1);
            I = -1;
            f();
            i1 = O.c() | P.c();
        }
        continue; /* Loop/switch isn't completed */
_L5:
        i1 = j1;
        if (z)
        {
            a(i, true, 0, false);
            I = -1;
            f();
            i1 = O.c() | P.c();
        }
        continue; /* Loop/switch isn't completed */
_L7:
        i1 = at.b(motionevent);
        E = at.c(motionevent, i1);
        I = at.b(motionevent, i1);
        i1 = j1;
        continue; /* Loop/switch isn't completed */
_L8:
        a(motionevent);
        E = at.c(motionevent, android.support.v4.view.at.a(motionevent, I));
        i1 = j1;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void removeView(View view)
    {
        if (v)
        {
            removeViewInLayout(view);
            return;
        } else
        {
            super.removeView(view);
            return;
        }
    }

    public void setAdapter(bb bb1)
    {
        boolean flag;
label0:
        {
            if (h != null)
            {
                h.b(n);
                for (int i1 = 0; i1 < e.size(); i1++)
                {
                    ck ck1 = (ck)e.get(i1);
                    h.a(this, ck1.b, ck1.a);
                }

                h.a(this);
                e.clear();
                int k1;
                for (int j1 = 0; j1 < getChildCount(); j1 = k1 + 1)
                {
                    k1 = j1;
                    if (!((cl)getChildAt(j1).getLayoutParams()).a)
                    {
                        removeViewAt(j1);
                        k1 = j1 - 1;
                    }
                }

                i = 0;
                scrollTo(0, 0);
            }
            h = bb1;
            b = 0;
            if (h != null)
            {
                if (n == null)
                {
                    n = new cp(this, (byte)0);
                }
                h.a(n);
                x = false;
                flag = Q;
                Q = true;
                b = h.b();
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
        if (W == null)
        {
            try
            {
                W = android/view/ViewGroup.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[] {
                    Boolean.TYPE
                });
            }
            catch (NoSuchMethodException nosuchmethodexception)
            {
                Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", nosuchmethodexception);
            }
        }
        W.invoke(this, new Object[] {
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
        x = false;
        boolean flag;
        if (!Q)
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
        if (j1 != y)
        {
            y = j1;
            b();
        }
    }

    void setOnAdapterChangeListener(cn cn)
    {
        V = cn;
    }

    public void setOnPageChangeListener(co co1)
    {
        U = co1;
    }

    public void setPageMargin(int i1)
    {
        int j1 = o;
        o = i1;
        int k1 = getWidth();
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

        public static final android.os.Parcelable.Creator CREATOR = android.support.v4.e.a.a(new cq());
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
