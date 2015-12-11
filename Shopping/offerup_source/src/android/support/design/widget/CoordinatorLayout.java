// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.design.a;
import android.support.v4.view.at;
import android.support.v4.view.az;
import android.support.v4.view.bi;
import android.support.v4.view.dn;
import android.support.v4.view.s;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import e.c.g;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package android.support.design.widget:
//            x, y, p, q, 
//            t, r, u, bu, 
//            s, v

public class CoordinatorLayout extends ViewGroup
    implements az
{

    private static String a = android/support/design/widget/CoordinatorLayout.getPackage().getName();
    private static Class b[] = {
        android/content/Context, android/util/AttributeSet
    };
    private static ThreadLocal c = new ThreadLocal();
    private static Comparator e;
    private static y f;
    private Comparator d;
    private final List g;
    private final List h;
    private final List i;
    private final Rect j;
    private final Rect k;
    private final Rect l;
    private final int m[];
    private boolean n;
    private int o[];
    private View p;
    private View q;
    private v r;
    private boolean s;
    private dn t;
    private boolean u;
    private Drawable v;
    private android.view.ViewGroup.OnHierarchyChangeListener w;
    private final g x;

    public CoordinatorLayout(Context context)
    {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeset, int i1)
    {
        boolean flag = false;
        super(context, attributeset, i1);
        d = new p(this);
        g = new ArrayList();
        h = new ArrayList();
        i = new ArrayList();
        j = new Rect();
        k = new Rect();
        l = new Rect();
        m = new int[2];
        x = new g(this);
        attributeset = context.obtainStyledAttributes(attributeset, a.z, i1, 0x7f0c0193);
        i1 = attributeset.getResourceId(a.G, 0);
        if (i1 != 0)
        {
            context = context.getResources();
            o = context.getIntArray(i1);
            float f1 = context.getDisplayMetrics().density;
            int j1 = o.length;
            for (i1 = ((flag) ? 1 : 0); i1 < j1; i1++)
            {
                context = o;
                context[i1] = (int)((float)context[i1] * f1);
            }

        }
        v = attributeset.getDrawable(a.H);
        attributeset.recycle();
        if (f != null)
        {
            f.a(this, new q(this));
        }
        super.setOnHierarchyChangeListener(new t(this));
    }

    private int a(int i1)
    {
        if (o == null)
        {
            Log.e("CoordinatorLayout", (new StringBuilder("No keylines defined for ")).append(this).append(" - attempted index lookup ").append(i1).toString());
            return 0;
        }
        if (i1 < 0 || i1 >= o.length)
        {
            Log.e("CoordinatorLayout", (new StringBuilder("Keyline index ")).append(i1).append(" out of range for ").append(this).toString());
            return 0;
        } else
        {
            return o[i1];
        }
    }

    static r a(Context context, AttributeSet attributeset, String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            return null;
        }
        String s2;
        Constructor constructor;
        Constructor constructor1;
        if (s1.startsWith("."))
        {
            s2 = (new StringBuilder()).append(context.getPackageName()).append(s1).toString();
        } else
        {
            s2 = s1;
            if (s1.indexOf('.') < 0)
            {
                s2 = (new StringBuilder()).append(a).append('.').append(s1).toString();
            }
        }
        try
        {
            s1 = (Map)c.get();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new RuntimeException((new StringBuilder("Could not inflate Behavior subclass ")).append(s2).toString(), context);
        }
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        s1 = new HashMap();
        c.set(s1);
        constructor1 = (Constructor)s1.get(s2);
        constructor = constructor1;
        if (constructor1 != null)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        constructor = Class.forName(s2, true, context.getClassLoader()).getConstructor(b);
        constructor.setAccessible(true);
        s1.put(s2, constructor);
        context = (r)constructor.newInstance(new Object[] {
            context, attributeset
        });
        return context;
    }

    static android.view.ViewGroup.OnHierarchyChangeListener a(CoordinatorLayout coordinatorlayout)
    {
        return coordinatorlayout.w;
    }

    private void a()
    {
        int i1 = 0;
        if (p != null)
        {
            r r1 = ((u)p.getLayoutParams()).a;
            if (r1 != null)
            {
                long l1 = SystemClock.uptimeMillis();
                MotionEvent motionevent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
                r1.a(this, p, motionevent);
                motionevent.recycle();
            }
            p = null;
        }
        for (int j1 = getChildCount(); i1 < j1; i1++)
        {
            ((u)getChildAt(i1).getLayoutParams()).b();
        }

    }

    static void a(CoordinatorLayout coordinatorlayout, dn dn1)
    {
        coordinatorlayout.setWindowInsets(dn1);
    }

    private void a(View view, int i1, Rect rect, Rect rect1)
    {
        u u1;
        int j1;
        int i2;
        int j2;
        int k2;
        u1 = (u)view.getLayoutParams();
        int k1 = u1.c;
        j1 = k1;
        if (k1 == 0)
        {
            j1 = 17;
        }
        k2 = android.support.v4.view.s.a(j1, i1);
        j1 = android.support.v4.view.s.a(b(u1.d), i1);
        i2 = view.getMeasuredWidth();
        j2 = view.getMeasuredHeight();
        j1 & 7;
        JVM INSTR lookupswitch 2: default 96
    //                   1: 326
    //                   5: 318;
           goto _L1 _L2 _L3
_L1:
        i1 = rect.left;
_L13:
        j1 & 0x70;
        JVM INSTR lookupswitch 2: default 132
    //                   16: 352
    //                   80: 343;
           goto _L4 _L5 _L6
_L4:
        j1 = rect.top;
_L14:
        int l1 = i1;
        k2 & 7;
        JVM INSTR lookupswitch 2: default 172
    //                   1: 368
    //                   5: 178;
           goto _L7 _L8 _L9
_L9:
        break; /* Loop/switch isn't completed */
_L7:
        l1 = i1 - i2;
_L15:
        i1 = j1;
        k2 & 0x70;
        JVM INSTR lookupswitch 2: default 212
    //                   16: 379
    //                   80: 218;
           goto _L10 _L11 _L12
_L12:
        break; /* Loop/switch isn't completed */
_L10:
        i1 = j1 - j2;
_L16:
        int l2 = getWidth();
        j1 = getHeight();
        l1 = Math.max(getPaddingLeft() + u1.leftMargin, Math.min(l1, l2 - getPaddingRight() - i2 - u1.rightMargin));
        i1 = Math.max(getPaddingTop() + u1.topMargin, Math.min(i1, j1 - getPaddingBottom() - j2 - u1.bottomMargin));
        rect1.set(l1, i1, l1 + i2, i1 + j2);
        return;
_L3:
        i1 = rect.right;
          goto _L13
_L2:
        i1 = rect.left;
        i1 = rect.width() / 2 + i1;
          goto _L13
_L6:
        j1 = rect.bottom;
          goto _L14
_L5:
        j1 = rect.top + rect.height() / 2;
          goto _L14
_L8:
        l1 = i1 - i2 / 2;
          goto _L15
_L11:
        i1 = j1 - j2 / 2;
          goto _L16
    }

    private void a(View view, boolean flag, Rect rect)
    {
        if (view.isLayoutRequested() || view.getVisibility() == 8)
        {
            rect.set(0, 0, 0, 0);
            return;
        }
        if (flag)
        {
            android.support.design.widget.bu.a(this, view, rect);
            return;
        } else
        {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            return;
        }
    }

    private boolean a(MotionEvent motionevent, int i1)
    {
        MotionEvent motionevent1;
        List list;
        int j1;
        int l1;
        int i2;
        int j2;
        boolean flag1;
        flag1 = false;
        boolean flag = false;
        i2 = at.a(motionevent);
        list = h;
        list.clear();
        boolean flag2 = isChildrenDrawingOrderEnabled();
        j2 = getChildCount();
        j1 = j2 - 1;
        while (j1 >= 0) 
        {
            int k1;
            if (flag2)
            {
                k1 = getChildDrawingOrder(j2, j1);
            } else
            {
                k1 = j1;
            }
            list.add(getChildAt(k1));
            j1--;
        }
        if (e != null)
        {
            Collections.sort(list, e);
        }
        j2 = list.size();
        l1 = 0;
        motionevent1 = null;
        j1 = ((flag) ? 1 : 0);
_L9:
        if (l1 >= j2) goto _L2; else goto _L1
_L1:
        View view;
        r r1;
        u u1;
        view = (View)list.get(l1);
        u1 = (u)view.getLayoutParams();
        r1 = u1.a;
        if (!flag1 && !j1 || i2 == 0) goto _L4; else goto _L3
_L3:
        if (r1 == null) goto _L6; else goto _L5
_L5:
        if (motionevent1 == null)
        {
            long l2 = SystemClock.uptimeMillis();
            motionevent1 = MotionEvent.obtain(l2, l2, 3, 0.0F, 0.0F, 0);
        }
        i1;
        JVM INSTR tableswitch 0 1: default 228
    //                   0 237
    //                   1 250;
           goto _L6 _L7 _L8
_L6:
        l1++;
          goto _L9
_L7:
        r1.b(this, view, motionevent1);
          goto _L6
_L8:
        r1.a(this, view, motionevent1);
          goto _L6
_L4:
        boolean flag3 = flag1;
        if (flag1) goto _L11; else goto _L10
_L10:
        flag3 = flag1;
        if (r1 == null) goto _L11; else goto _L12
_L12:
        i1;
        JVM INSTR tableswitch 0 1: default 304
    //                   0 374
    //                   1 388;
           goto _L13 _L14 _L15
_L13:
        break; /* Loop/switch isn't completed */
_L15:
        break MISSING_BLOCK_LABEL_388;
_L16:
        flag3 = flag1;
        if (flag1)
        {
            p = view;
            flag3 = flag1;
        }
_L11:
        flag1 = flag3;
        flag3 = u1.a();
        boolean flag4 = u1.a(this, view);
        if (flag4 && !flag3)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (flag4)
        {
            flag3 = flag1;
            if (!j1)
            {
                break MISSING_BLOCK_LABEL_412;
            }
        }
          goto _L6
_L14:
        flag1 = r1.b(this, view, motionevent);
          goto _L16
        flag1 = r1.a(this, view, motionevent);
          goto _L16
_L2:
        flag3 = flag1;
        list.clear();
        return flag3;
          goto _L6
    }

    private static int b(int i1)
    {
        int j1 = i1;
        if (i1 == 0)
        {
            j1 = 0x800033;
        }
        return j1;
    }

    private static int c(int i1)
    {
        int j1 = i1;
        if (i1 == 0)
        {
            j1 = 0x800035;
        }
        return j1;
    }

    private static u c(View view)
    {
        u u1 = (u)view.getLayoutParams();
        if (!u1.b)
        {
            Class class1 = view.getClass();
            view = null;
            View view1;
            do
            {
                view1 = view;
                if (class1 == null)
                {
                    break;
                }
                view = (android.support.design.widget.s)class1.getAnnotation(android/support/design/widget/s);
                view1 = view;
                if (view != null)
                {
                    break;
                }
                class1 = class1.getSuperclass();
            } while (true);
            if (view1 != null)
            {
                try
                {
                    u1.a((r)view1.a().newInstance());
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    Log.e("CoordinatorLayout", (new StringBuilder("Default behavior class ")).append(view1.a().getName()).append(" could not be instantiated. Did you forget a default constructor?").toString(), view);
                }
            }
            u1.b = true;
        }
        return u1;
    }

    private void setWindowInsets(dn dn1)
    {
        boolean flag1 = true;
        int i1 = 0;
        if (t != dn1)
        {
            t = dn1;
            boolean flag;
            if (dn1 != null && dn1.b() > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            u = flag;
            if (!u && getBackground() == null)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            setWillNotDraw(flag);
            if (!dn1.e())
            {
                for (int j1 = getChildCount(); i1 < j1;)
                {
                    View view = getChildAt(i1);
                    dn dn2 = dn1;
                    if (bi.v(view))
                    {
                        if (((u)view.getLayoutParams()).a != null && dn1.e())
                        {
                            break;
                        }
                        dn2 = bi.b(view, dn1);
                        if (dn2.e())
                        {
                            break;
                        }
                    }
                    i1++;
                    dn1 = dn2;
                }

            }
            requestLayout();
        }
    }

    public final void a(View view)
    {
        int j1 = g.size();
        int i1 = 0;
        boolean flag = false;
        while (i1 < j1) 
        {
            View view1 = (View)g.get(i1);
            if (view1 == view)
            {
                flag = true;
            } else
            if (flag)
            {
                u u1 = (u)view1.getLayoutParams();
                r r1 = u1.a;
                if (r1 != null && u1.a(this, view1, view))
                {
                    r1.c(this, view1, view);
                }
            }
            i1++;
        }
    }

    public final void a(View view, int i1)
    {
        Object obj;
        obj = (u)view.getLayoutParams();
        boolean flag;
        if (((u) (obj)).g == null && ((u) (obj)).f != -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        if (((u) (obj)).g != null)
        {
            obj = ((u) (obj)).g;
            view.getLayoutParams();
            Rect rect = j;
            Rect rect2 = k;
            android.support.design.widget.bu.a(this, ((View) (obj)), rect);
            a(view, i1, rect, rect2);
            view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
            return;
        }
        if (((u) (obj)).e < 0) goto _L2; else goto _L1
_L1:
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int l1 = ((u) (obj)).e;
        obj = (u)view.getLayoutParams();
        i3 = android.support.v4.view.s.a(c(((u) (obj)).c), i1);
        l2 = getWidth();
        k2 = getHeight();
        i2 = view.getMeasuredWidth();
        j2 = view.getMeasuredHeight();
        int j1 = l1;
        if (i1 == 1)
        {
            j1 = l2 - l1;
        }
        i1 = a(j1) - i2;
        i3 & 7;
        JVM INSTR lookupswitch 2: default 236
    //                   1: 362
    //                   5: 354;
           goto _L3 _L4 _L5
_L3:
        i3 & 0x70;
        JVM INSTR lookupswitch 2: default 268
    //                   16: 381
    //                   80: 372;
           goto _L6 _L7 _L8
_L6:
        int k1 = 0;
_L9:
        i1 = Math.max(getPaddingLeft() + ((u) (obj)).leftMargin, Math.min(i1, l2 - getPaddingRight() - i2 - ((u) (obj)).rightMargin));
        k1 = Math.max(getPaddingTop() + ((u) (obj)).topMargin, Math.min(k1, k2 - getPaddingBottom() - j2 - ((u) (obj)).bottomMargin));
        view.layout(i1, k1, i1 + i2, k1 + j2);
        return;
_L5:
        i1 += i2;
        continue; /* Loop/switch isn't completed */
_L4:
        i1 += i2 / 2;
        continue; /* Loop/switch isn't completed */
_L8:
        k1 = j2 + 0;
        continue; /* Loop/switch isn't completed */
_L7:
        k1 = j2 / 2 + 0;
        if (true) goto _L9; else goto _L2
_L2:
        u u1 = (u)view.getLayoutParams();
        Rect rect1 = j;
        rect1.set(getPaddingLeft() + u1.leftMargin, getPaddingTop() + u1.topMargin, getWidth() - getPaddingRight() - u1.rightMargin, getHeight() - getPaddingBottom() - u1.bottomMargin);
        if (t != null && bi.v(this) && !bi.v(view))
        {
            rect1.left = rect1.left + t.a();
            rect1.top = rect1.top + t.b();
            rect1.right = rect1.right - t.c();
            rect1.bottom = rect1.bottom - t.d();
        }
        Rect rect3 = k;
        android.support.v4.view.s.a(b(u1.c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect1, rect3, i1);
        view.layout(rect3.left, rect3.top, rect3.right, rect3.bottom);
        return;
        if (true) goto _L3; else goto _L10
_L10:
    }

    public final void a(View view, int i1, int j1, int k1, int l1)
    {
        measureChildWithMargins(view, i1, j1, k1, l1);
    }

    final void a(boolean flag)
    {
        int i1;
        int l1;
        int i2;
        l1 = bi.h(this);
        i2 = g.size();
        i1 = 0;
_L7:
        if (i1 >= i2) goto _L2; else goto _L1
_L1:
        View view;
        int k1;
        view = (View)g.get(i1);
        Object obj = (u)view.getLayoutParams();
        for (int j1 = 0; j1 < i1; j1++)
        {
            Object obj1 = (View)g.get(j1);
            if (((u) (obj)).h != obj1)
            {
                continue;
            }
            obj1 = (u)view.getLayoutParams();
            if (((u) (obj1)).g == null)
            {
                continue;
            }
            Object obj2 = j;
            Rect rect1 = k;
            Rect rect2 = l;
            android.support.design.widget.bu.a(this, ((u) (obj1)).g, ((Rect) (obj2)));
            a(view, false, rect1);
            a(view, l1, ((Rect) (obj2)), rect2);
            int j2 = rect2.left - rect1.left;
            int k2 = rect2.top - rect1.top;
            if (j2 != 0)
            {
                view.offsetLeftAndRight(j2);
            }
            if (k2 != 0)
            {
                view.offsetTopAndBottom(k2);
            }
            if (j2 == 0 && k2 == 0)
            {
                continue;
            }
            obj2 = ((u) (obj1)).a;
            if (obj2 != null)
            {
                ((r) (obj2)).c(this, view, ((u) (obj1)).g);
            }
        }

        obj = j;
        Rect rect = k;
        ((Rect) (obj)).set(((u)view.getLayoutParams()).i);
        a(view, true, rect);
        if (((Rect) (obj)).equals(rect))
        {
            continue; /* Loop/switch isn't completed */
        }
        ((u)view.getLayoutParams()).i.set(rect);
        k1 = i1 + 1;
_L4:
        View view1;
        u u1;
        r r1;
        if (k1 >= i2)
        {
            continue; /* Loop/switch isn't completed */
        }
        view1 = (View)g.get(k1);
        u1 = (u)view1.getLayoutParams();
        r1 = u1.a;
        if (r1 != null && r1.b(this, view1, view))
        {
            if (flag || !u1.e())
            {
                break; /* Loop/switch isn't completed */
            }
            u1.f();
        }
_L5:
        k1++;
        if (true) goto _L4; else goto _L3
_L3:
        boolean flag1 = r1.c(this, view1, view);
        if (flag)
        {
            u1.b(flag1);
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
        i1++;
          goto _L7
_L2:
    }

    public final boolean a(View view, int i1, int j1)
    {
        Rect rect = j;
        android.support.design.widget.bu.a(this, view, rect);
        return rect.contains(i1, j1);
    }

    public final boolean a(View view, View view1)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (view.getVisibility() == 0)
        {
            flag = flag1;
            if (view1.getVisibility() == 0)
            {
                Rect rect = j;
                if (view.getParent() != this)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                a(view, flag, rect);
                view = k;
                if (view1.getParent() != this)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                a(view1, flag, ((Rect) (view)));
                flag = flag1;
                if (rect.left <= ((Rect) (view)).right)
                {
                    flag = flag1;
                    if (rect.top <= ((Rect) (view)).bottom)
                    {
                        flag = flag1;
                        if (rect.right >= ((Rect) (view)).left)
                        {
                            flag = flag1;
                            if (rect.bottom >= ((Rect) (view)).top)
                            {
                                flag = true;
                            }
                        }
                    }
                }
            }
        }
        return flag;
    }

    public final List b(View view)
    {
        u u1 = (u)view.getLayoutParams();
        List list = i;
        list.clear();
        int j1 = getChildCount();
        for (int i1 = 0; i1 < j1; i1++)
        {
            View view1 = getChildAt(i1);
            if (view1 != view && u1.a(this, view, view1))
            {
                list.add(view1);
            }
        }

        return list;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return (layoutparams instanceof u) && super.checkLayoutParams(layoutparams);
    }

    protected boolean drawChild(Canvas canvas, View view, long l1)
    {
        view.getLayoutParams();
        return super.drawChild(canvas, view, l1);
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new u(-2, -2);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new u(getContext(), attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (layoutparams instanceof u)
        {
            return new u((u)layoutparams);
        }
        if (layoutparams instanceof android.view.ViewGroup.MarginLayoutParams)
        {
            return new u((android.view.ViewGroup.MarginLayoutParams)layoutparams);
        } else
        {
            return new u(layoutparams);
        }
    }

    public int getNestedScrollAxes()
    {
        return x.a();
    }

    public Drawable getStatusBarBackground()
    {
        return v;
    }

    protected int getSuggestedMinimumHeight()
    {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    protected int getSuggestedMinimumWidth()
    {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        a();
        if (s)
        {
            if (r == null)
            {
                r = new v(this);
            }
            getViewTreeObserver().addOnPreDrawListener(r);
        }
        if (t == null && bi.v(this))
        {
            bi.u(this);
        }
        n = true;
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        a();
        if (s && r != null)
        {
            getViewTreeObserver().removeOnPreDrawListener(r);
        }
        if (q != null)
        {
            onStopNestedScroll(q);
        }
        n = false;
    }

    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (u && v != null)
        {
            int i1;
            if (t != null)
            {
                i1 = t.b();
            } else
            {
                i1 = 0;
            }
            if (i1 > 0)
            {
                v.setBounds(0, 0, getWidth(), i1);
                v.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i1 = at.a(motionevent);
        if (i1 == 0)
        {
            a();
        }
        boolean flag = a(motionevent, 0);
        if (i1 == 1 || i1 == 3)
        {
            a();
        }
        return flag;
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        j1 = bi.h(this);
        k1 = g.size();
        for (i1 = 0; i1 < k1; i1++)
        {
            View view = (View)g.get(i1);
            r r1 = ((u)view.getLayoutParams()).a;
            if (r1 == null || !r1.a(this, view, j1))
            {
                a(view, j1);
            }
        }

    }

    protected void onMeasure(int i1, int j1)
    {
        int i2;
        int j2;
        j2 = getChildCount();
        boolean flag;
        if (g.size() != j2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        for (i2 = 0; i2 < j2; i2++)
        {
            View view = getChildAt(i2);
            u u1 = c(view);
            if (flag);
            u1.b(this, view);
        }

        if (flag)
        {
            g.clear();
            for (int k1 = 0; k1 < j2; k1++)
            {
                g.add(getChildAt(k1));
            }

            Collections.sort(g, d);
        }
        j2 = getChildCount();
        i2 = 0;
_L15:
        View view1;
        u u2;
        if (i2 >= j2)
        {
            break MISSING_BLOCK_LABEL_865;
        }
        view1 = getChildAt(i2);
        u2 = (u)view1.getLayoutParams();
        if (u2.g == null) goto _L2; else goto _L1
_L1:
        int l1 = 1;
_L13:
        if (l1 == 0) goto _L4; else goto _L3
_L3:
        boolean flag2 = true;
_L19:
        int l2;
        int i3;
        int j3;
        int k3;
        int l3;
        int i4;
        int k6;
        Object obj;
        boolean flag1;
        int k2;
        int j4;
        int k4;
        int l4;
        int i5;
        int j5;
        int k5;
        int l5;
        int i6;
        int j6;
        int l6;
        if (flag2 != s)
        {
            if (flag2)
            {
                if (n)
                {
                    if (r == null)
                    {
                        r = new v(this);
                    }
                    getViewTreeObserver().addOnPreDrawListener(r);
                }
                s = true;
            } else
            {
                if (n && r != null)
                {
                    getViewTreeObserver().removeOnPreDrawListener(r);
                }
                s = false;
            }
        }
        i4 = getPaddingLeft();
        j4 = getPaddingTop();
        k4 = getPaddingRight();
        l4 = getPaddingBottom();
        i5 = bi.h(this);
        if (i5 == 1)
        {
            i2 = 1;
        } else
        {
            i2 = 0;
        }
        j5 = android.view.View.MeasureSpec.getMode(i1);
        k5 = android.view.View.MeasureSpec.getSize(i1);
        l5 = android.view.View.MeasureSpec.getMode(j1);
        i6 = android.view.View.MeasureSpec.getSize(j1);
        j3 = getSuggestedMinimumWidth();
        i3 = getSuggestedMinimumHeight();
        if (t != null && bi.v(this))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        j6 = g.size();
        k2 = 0;
        l2 = 0;
_L12:
        if (k2 >= j6) goto _L6; else goto _L5
_L5:
        view1 = (View)g.get(k2);
        u2 = (u)view1.getLayoutParams();
        k3 = 0;
        l1 = k3;
        if (u2.e < 0) goto _L8; else goto _L7
_L7:
        l1 = k3;
        if (j5 == 0) goto _L8; else goto _L9
_L9:
        l3 = a(u2.e);
        k6 = android.support.v4.view.s.a(c(u2.c), i5) & 7;
        if ((k6 != 3 || i2 != 0) && (k6 != 5 || i2 == 0)) goto _L11; else goto _L10
_L10:
        l1 = Math.max(0, k5 - k4 - l3);
_L8:
        if (flag1 && !bi.v(view1))
        {
            k3 = t.a();
            l6 = t.c();
            l3 = t.b();
            k6 = t.d();
            k3 = android.view.View.MeasureSpec.makeMeasureSpec(k5 - (k3 + l6), j5);
            l3 = android.view.View.MeasureSpec.makeMeasureSpec(i6 - (l3 + k6), l5);
        } else
        {
            l3 = j1;
            k3 = i1;
        }
        obj = u2.a;
        if (obj == null || !((r) (obj)).a(this, view1, k3, l1, l3, 0))
        {
            a(view1, k3, l1, l3, 0);
        }
        j3 = Math.max(j3, view1.getMeasuredWidth() + (i4 + k4) + u2.leftMargin + u2.rightMargin);
        i3 = Math.max(i3, view1.getMeasuredHeight() + (j4 + l4) + u2.topMargin + u2.bottomMargin);
        l2 = bi.a(l2, bi.j(view1));
        k2++;
          goto _L12
_L2:
        k2 = getChildCount();
        l1 = 0;
_L14:
label0:
        {
            if (l1 >= k2)
            {
                break MISSING_BLOCK_LABEL_724;
            }
            obj = getChildAt(l1);
            if (obj == view1 || !u2.a(this, view1, ((View) (obj))))
            {
                break label0;
            }
            l1 = 1;
        }
          goto _L13
        l1++;
          goto _L14
        l1 = 0;
          goto _L13
_L4:
        i2++;
          goto _L15
_L11:
        if (k6 == 5 && i2 == 0) goto _L17; else goto _L16
_L16:
        l1 = k3;
        if (k6 != 3) goto _L8; else goto _L18
_L18:
        l1 = k3;
        if (i2 == 0) goto _L8; else goto _L17
_L17:
        l1 = Math.max(0, l3 - i4);
          goto _L8
_L6:
        setMeasuredDimension(bi.a(j3, i1, 0xff000000 & l2), bi.a(i3, j1, l2 << 16));
        return;
        flag2 = false;
          goto _L19
    }

    public boolean onNestedFling(View view, float f1, float f2, boolean flag)
    {
        int j1 = getChildCount();
        int i1 = 0;
        boolean flag1 = false;
        for (; i1 < j1; i1++)
        {
            View view1 = getChildAt(i1);
            Object obj = (u)view1.getLayoutParams();
            if (!((u) (obj)).d())
            {
                continue;
            }
            obj = ((u) (obj)).a;
            if (obj != null)
            {
                flag1 = ((r) (obj)).a(this, view1, view, f1, f2, flag) | flag1;
            }
        }

        if (flag1)
        {
            a(true);
        }
        return flag1;
    }

    public boolean onNestedPreFling(View view, float f1, float f2)
    {
        int j1 = getChildCount();
        for (int i1 = 0; i1 < j1; i1++)
        {
            getChildAt(i1).getLayoutParams();
        }

        return false;
    }

    public void onNestedPreScroll(View view, int i1, int j1, int ai[])
    {
        int k1;
        int l1;
        int i2;
        int j2;
        int i3;
        l1 = 0;
        k1 = 0;
        i2 = 0;
        i3 = getChildCount();
        j2 = 0;
_L2:
        if (j2 >= i3)
        {
            break; /* Loop/switch isn't completed */
        }
        View view1 = getChildAt(j2);
        Object obj = (u)view1.getLayoutParams();
        if (!((u) (obj)).d())
        {
            break MISSING_BLOCK_LABEL_221;
        }
        obj = ((u) (obj)).a;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_221;
        }
        int ai1[] = m;
        m[1] = 0;
        ai1[0] = 0;
        ((r) (obj)).a(this, view1, view, i1, j1, m);
        int k2;
        if (i1 > 0)
        {
            l1 = Math.max(l1, m[0]);
        } else
        {
            l1 = Math.min(l1, m[0]);
        }
        if (j1 > 0)
        {
            k1 = Math.max(k1, m[1]);
        } else
        {
            k1 = Math.min(k1, m[1]);
        }
        k2 = 1;
        i2 = k1;
        k1 = k2;
_L3:
        k2 = j2 + 1;
        j2 = i2;
        i2 = k1;
        k1 = j2;
        j2 = k2;
        if (true) goto _L2; else goto _L1
_L1:
        ai[0] = l1;
        ai[1] = k1;
        if (i2 != 0)
        {
            a(true);
        }
        return;
        int l2 = k1;
        k1 = i2;
        i2 = l2;
          goto _L3
    }

    public void onNestedScroll(View view, int i1, int j1, int k1, int l1)
    {
        int j2 = getChildCount();
        boolean flag = false;
        for (int i2 = 0; i2 < j2; i2++)
        {
            View view1 = getChildAt(i2);
            Object obj = (u)view1.getLayoutParams();
            if (!((u) (obj)).d())
            {
                continue;
            }
            obj = ((u) (obj)).a;
            if (obj != null)
            {
                ((r) (obj)).a(this, view1, view, i1, j1, k1, l1);
                flag = true;
            }
        }

        if (flag)
        {
            a(true);
        }
    }

    public void onNestedScrollAccepted(View view, View view1, int i1)
    {
        x.a(i1);
        q = view1;
        int j1 = getChildCount();
        for (i1 = 0; i1 < j1; i1++)
        {
            getChildAt(i1).getLayoutParams();
        }

    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        parcelable = ((SavedState) (parcelable)).a;
        int j1 = getChildCount();
        for (int i1 = 0; i1 < j1; i1++)
        {
            View view = getChildAt(i1);
            int k1 = view.getId();
            r r1 = c(view).a;
            if (k1 == -1 || r1 == null)
            {
                continue;
            }
            Parcelable parcelable1 = (Parcelable)parcelable.get(k1);
            if (parcelable1 != null)
            {
                r1.a(this, view, parcelable1);
            }
        }

    }

    protected Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        SparseArray sparsearray = new SparseArray();
        int j1 = getChildCount();
        for (int i1 = 0; i1 < j1; i1++)
        {
            Object obj = getChildAt(i1);
            int k1 = ((View) (obj)).getId();
            r r1 = ((u)((View) (obj)).getLayoutParams()).a;
            if (k1 == -1 || r1 == null)
            {
                continue;
            }
            obj = r1.a(this, ((View) (obj)));
            if (obj != null)
            {
                sparsearray.append(k1, obj);
            }
        }

        savedstate.a = sparsearray;
        return savedstate;
    }

    public boolean onStartNestedScroll(View view, View view1, int i1)
    {
        int k1 = getChildCount();
        int j1 = 0;
        boolean flag = false;
        while (j1 < k1) 
        {
            View view2 = getChildAt(j1);
            u u1 = (u)view2.getLayoutParams();
            r r1 = u1.a;
            if (r1 != null)
            {
                boolean flag1 = r1.a(this, view2, view, view1, i1);
                flag |= flag1;
                u1.a(flag1);
            } else
            {
                u1.a(false);
            }
            j1++;
        }
        return flag;
    }

    public void onStopNestedScroll(View view)
    {
        x.b();
        int j1 = getChildCount();
        for (int i1 = 0; i1 < j1; i1++)
        {
            View view1 = getChildAt(i1);
            u u1 = (u)view1.getLayoutParams();
            if (!u1.d())
            {
                continue;
            }
            r r1 = u1.a;
            if (r1 != null)
            {
                r1.a(this, view1, view);
            }
            u1.c();
            u1.f();
        }

        q = null;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i1 = at.a(motionevent);
        if (p != null) goto _L2; else goto _L1
_L1:
        boolean flag1 = a(motionevent, 1);
        if (!flag1) goto _L4; else goto _L3
_L3:
        boolean flag;
        r r1 = ((u)p.getLayoutParams()).a;
        long l1;
        if (r1 != null)
        {
            flag = r1.a(this, p, motionevent);
        } else
        {
            flag = false;
        }
_L5:
        if (p == null)
        {
            flag |= super.onTouchEvent(motionevent);
            motionevent = null;
        } else
        if (flag1)
        {
            l1 = SystemClock.uptimeMillis();
            motionevent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
            super.onTouchEvent(motionevent);
        } else
        {
            motionevent = null;
        }
        if (motionevent != null)
        {
            motionevent.recycle();
        }
        if (i1 == 1 || i1 == 3)
        {
            a();
        }
        return flag;
_L4:
        flag = false;
        if (true) goto _L5; else goto _L2
_L2:
        flag1 = false;
        if (true) goto _L3; else goto _L6
_L6:
    }

    public void requestDisallowInterceptTouchEvent(boolean flag)
    {
        super.requestDisallowInterceptTouchEvent(flag);
        if (flag)
        {
            a();
        }
    }

    public void setOnHierarchyChangeListener(android.view.ViewGroup.OnHierarchyChangeListener onhierarchychangelistener)
    {
        w = onhierarchychangelistener;
    }

    public void setStatusBarBackground(Drawable drawable)
    {
        v = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i1)
    {
        setStatusBarBackground(new ColorDrawable(i1));
    }

    public void setStatusBarBackgroundResource(int i1)
    {
        Drawable drawable;
        if (i1 != 0)
        {
            drawable = android.support.v4.b.a.a(getContext(), i1);
        } else
        {
            drawable = null;
        }
        setStatusBarBackground(drawable);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            e = new x();
            f = new y();
        } else
        {
            e = null;
            f = null;
        }
    }

    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new w();
        SparseArray a;

        public void writeToParcel(Parcel parcel, int i1)
        {
            int k1 = 0;
            super.writeToParcel(parcel, i1);
            int ai[];
            Parcelable aparcelable[];
            int j1;
            if (a != null)
            {
                j1 = a.size();
            } else
            {
                j1 = 0;
            }
            parcel.writeInt(j1);
            ai = new int[j1];
            aparcelable = new Parcelable[j1];
            for (; k1 < j1; k1++)
            {
                ai[k1] = a.keyAt(k1);
                aparcelable[k1] = (Parcelable)a.valueAt(k1);
            }

            parcel.writeIntArray(ai);
            parcel.writeParcelableArray(aparcelable, i1);
        }


        public SavedState(Parcel parcel)
        {
            super(parcel);
            int j1 = parcel.readInt();
            int ai[] = new int[j1];
            parcel.readIntArray(ai);
            parcel = parcel.readParcelableArray(android/support/design/widget/CoordinatorLayout.getClassLoader());
            a = new SparseArray(j1);
            for (int i1 = 0; i1 < j1; i1++)
            {
                a.append(ai[i1], parcel[i1]);
            }

        }

        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

}
