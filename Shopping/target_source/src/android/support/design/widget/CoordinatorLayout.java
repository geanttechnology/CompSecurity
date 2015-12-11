// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.a.a;
import android.support.v4.view.aa;
import android.support.v4.view.ai;
import android.support.v4.view.bh;
import android.support.v4.view.e;
import android.support.v4.view.z;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package android.support.design.widget:
//            c, j, b

public class CoordinatorLayout extends ViewGroup
    implements z
{
    protected static class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new _cls1();
        SparseArray a;

        public void writeToParcel(Parcel parcel, int i1)
        {
            int k1 = 0;
            super.writeToParcel(parcel, i1);
            int ai1[];
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
            ai1 = new int[j1];
            aparcelable = new Parcelable[j1];
            for (; k1 < j1; k1++)
            {
                ai1[k1] = a.keyAt(k1);
                aparcelable[k1] = (Parcelable)a.valueAt(k1);
            }

            parcel.writeIntArray(ai1);
            parcel.writeParcelableArray(aparcelable, i1);
        }


        public SavedState(Parcel parcel)
        {
            super(parcel);
            int j1 = parcel.readInt();
            int ai1[] = new int[j1];
            parcel.readIntArray(ai1);
            parcel = parcel.readParcelableArray(android/support/design/widget/CoordinatorLayout.getClassLoader());
            a = new SparseArray(j1);
            for (int i1 = 0; i1 < j1; i1++)
            {
                a.append(ai1[i1], parcel[i1]);
            }

        }

        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }

        /* block-local class not found */
        class _cls1 {}

    }

    public static abstract class a
    {

        public Parcelable a(CoordinatorLayout coordinatorlayout, View view)
        {
            return android.view.View.BaseSavedState.EMPTY_STATE;
        }

        public bh a(CoordinatorLayout coordinatorlayout, View view, bh bh1)
        {
            return bh1;
        }

        public void a(CoordinatorLayout coordinatorlayout, View view, Parcelable parcelable)
        {
        }

        public void a(CoordinatorLayout coordinatorlayout, View view, View view1)
        {
        }

        public void a(CoordinatorLayout coordinatorlayout, View view, View view1, int i1, int j1, int k1, int l1)
        {
        }

        public void a(CoordinatorLayout coordinatorlayout, View view, View view1, int i1, int j1, int ai1[])
        {
        }

        public boolean a(CoordinatorLayout coordinatorlayout, View view, int i1)
        {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorlayout, View view, int i1, int j1, int k1, int l1)
        {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorlayout, View view, MotionEvent motionevent)
        {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorlayout, View view, View view1, float f1, float f2)
        {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorlayout, View view, View view1, float f1, float f2, boolean flag)
        {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorlayout, View view, View view1, View view2, int i1)
        {
            return false;
        }

        public final int b(CoordinatorLayout coordinatorlayout, View view)
        {
            return 0xff000000;
        }

        public void b(CoordinatorLayout coordinatorlayout, View view, View view1, View view2, int i1)
        {
        }

        public boolean b(CoordinatorLayout coordinatorlayout, View view, MotionEvent motionevent)
        {
            return false;
        }

        public boolean b(CoordinatorLayout coordinatorlayout, View view, View view1)
        {
            return false;
        }

        public final float c(CoordinatorLayout coordinatorlayout, View view)
        {
            return 0.0F;
        }

        public boolean c(CoordinatorLayout coordinatorlayout, View view, View view1)
        {
            return false;
        }

        public boolean d(CoordinatorLayout coordinatorlayout, View view)
        {
            return c(coordinatorlayout, view) > 0.0F;
        }

        public boolean e(CoordinatorLayout coordinatorlayout, View view)
        {
            return false;
        }

        public a()
        {
        }
    }

    public static interface b
        extends Annotation
    {

        public abstract Class a();
    }

    public static class c extends android.view.ViewGroup.MarginLayoutParams
    {

        a a;
        boolean b;
        public int c;
        public int d;
        public int e;
        int f;
        View g;
        View h;
        final Rect i;
        Object j;
        private boolean k;
        private boolean l;
        private boolean m;

        private void a(View view, CoordinatorLayout coordinatorlayout)
        {
            g = coordinatorlayout.findViewById(f);
            if (g != null)
            {
                View view1 = g;
                for (ViewParent viewparent = g.getParent(); viewparent != coordinatorlayout && viewparent != null; viewparent = viewparent.getParent())
                {
                    if (viewparent == view)
                    {
                        if (coordinatorlayout.isInEditMode())
                        {
                            h = null;
                            g = null;
                            return;
                        } else
                        {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    if (viewparent instanceof View)
                    {
                        view1 = (View)viewparent;
                    }
                }

                h = view1;
                return;
            }
            if (coordinatorlayout.isInEditMode())
            {
                h = null;
                g = null;
                return;
            } else
            {
                throw new IllegalStateException((new StringBuilder()).append("Could not find CoordinatorLayout descendant view with id ").append(coordinatorlayout.getResources().getResourceName(f)).append(" to anchor view ").append(view).toString());
            }
        }

        private boolean b(View view, CoordinatorLayout coordinatorlayout)
        {
            if (g.getId() != f)
            {
                return false;
            }
            View view1 = g;
            for (ViewParent viewparent = g.getParent(); viewparent != coordinatorlayout; viewparent = viewparent.getParent())
            {
                if (viewparent == null || viewparent == view)
                {
                    h = null;
                    g = null;
                    return false;
                }
                if (viewparent instanceof View)
                {
                    view1 = (View)viewparent;
                }
            }

            h = view1;
            return true;
        }

        public a a()
        {
            return a;
        }

        void a(Rect rect)
        {
            i.set(rect);
        }

        public void a(a a1)
        {
            if (a != a1)
            {
                a = a1;
                j = null;
                b = true;
            }
        }

        void a(boolean flag)
        {
            l = flag;
        }

        boolean a(CoordinatorLayout coordinatorlayout, View view)
        {
            if (k)
            {
                return true;
            }
            boolean flag1 = k;
            boolean flag;
            if (a != null)
            {
                flag = a.d(coordinatorlayout, view);
            } else
            {
                flag = false;
            }
            flag |= flag1;
            k = flag;
            return flag;
        }

        boolean a(CoordinatorLayout coordinatorlayout, View view, View view1)
        {
            return view1 == h || a != null && a.b(coordinatorlayout, view, view1);
        }

        Rect b()
        {
            return i;
        }

        View b(CoordinatorLayout coordinatorlayout, View view)
        {
            if (f == -1)
            {
                h = null;
                g = null;
                return null;
            }
            if (g == null || !b(view, coordinatorlayout))
            {
                a(view, coordinatorlayout);
            }
            return g;
        }

        void b(boolean flag)
        {
            m = flag;
        }

        boolean c()
        {
            return g == null && f != -1;
        }

        boolean c(CoordinatorLayout coordinatorlayout, View view)
        {
            return a != null && a.e(coordinatorlayout, view);
        }

        boolean d()
        {
            if (a == null)
            {
                k = false;
            }
            return k;
        }

        void e()
        {
            k = false;
        }

        void f()
        {
            l = false;
        }

        boolean g()
        {
            return l;
        }

        boolean h()
        {
            return m;
        }

        void i()
        {
            m = false;
        }

        public c(int i1, int j1)
        {
            super(i1, j1);
            b = false;
            c = 0;
            d = 0;
            e = -1;
            f = -1;
            i = new Rect();
        }

        c(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
            b = false;
            c = 0;
            d = 0;
            e = -1;
            f = -1;
            i = new Rect();
            TypedArray typedarray = context.obtainStyledAttributes(attributeset, android.support.design.a.f.CoordinatorLayout_LayoutParams);
            c = typedarray.getInteger(android.support.design.a.f.CoordinatorLayout_LayoutParams_android_layout_gravity, 0);
            f = typedarray.getResourceId(android.support.design.a.f.CoordinatorLayout_LayoutParams_layout_anchor, -1);
            d = typedarray.getInteger(android.support.design.a.f.CoordinatorLayout_LayoutParams_layout_anchorGravity, 0);
            e = typedarray.getInteger(android.support.design.a.f.CoordinatorLayout_LayoutParams_layout_keyline, -1);
            b = typedarray.hasValue(android.support.design.a.f.CoordinatorLayout_LayoutParams_layout_behavior);
            if (b)
            {
                a = android.support.design.widget.CoordinatorLayout.a(context, attributeset, typedarray.getString(android.support.design.a.f.CoordinatorLayout_LayoutParams_layout_behavior));
            }
            typedarray.recycle();
        }

        public c(c c1)
        {
            super(c1);
            b = false;
            c = 0;
            d = 0;
            e = -1;
            f = -1;
            i = new Rect();
        }

        public c(android.view.ViewGroup.LayoutParams layoutparams)
        {
            super(layoutparams);
            b = false;
            c = 0;
            d = 0;
            e = -1;
            f = -1;
            i = new Rect();
        }

        public c(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
        {
            super(marginlayoutparams);
            b = false;
            c = 0;
            d = 0;
            e = -1;
            f = -1;
            i = new Rect();
        }
    }

    class d
        implements android.view.ViewTreeObserver.OnPreDrawListener
    {

        final CoordinatorLayout a;

        public boolean onPreDraw()
        {
            a.a(false);
            return true;
        }

        d()
        {
            a = CoordinatorLayout.this;
            super();
        }
    }

    static class e
        implements Comparator
    {

        public int a(View view, View view1)
        {
            float f1 = ai.B(view);
            float f2 = ai.B(view1);
            if (f1 > f2)
            {
                return -1;
            }
            return f1 >= f2 ? 0 : 1;
        }

        public int compare(Object obj, Object obj1)
        {
            return a((View)obj, (View)obj1);
        }

        e()
        {
        }
    }


    static final String a = android/support/design/widget/CoordinatorLayout.getPackage().getName();
    static final Class b[] = {
        android/content/Context, android/util/AttributeSet
    };
    static final ThreadLocal c = new ThreadLocal();
    static final Comparator e;
    static final android.support.design.widget.b f;
    final Comparator d;
    private final List g;
    private final List h;
    private final Rect i;
    private final Rect j;
    private final Rect k;
    private final int l[];
    private Paint m;
    private boolean n;
    private int o[];
    private View p;
    private View q;
    private View r;
    private d s;
    private boolean t;
    private bh u;
    private boolean v;
    private Drawable w;
    private final aa x;

    private int a(int i1)
    {
        if (o == null)
        {
            Log.e("CoordinatorLayout", (new StringBuilder()).append("No keylines defined for ").append(this).append(" - attempted index lookup ").append(i1).toString());
            return 0;
        }
        if (i1 < 0 || i1 >= o.length)
        {
            Log.e("CoordinatorLayout", (new StringBuilder()).append("Keyline index ").append(i1).append(" out of range for ").append(this).toString());
            return 0;
        } else
        {
            return o[i1];
        }
    }

    static a a(Context context, AttributeSet attributeset, String s1)
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
            throw new RuntimeException((new StringBuilder()).append("Could not inflate Behavior subclass ").append(s2).toString(), context);
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
            break MISSING_BLOCK_LABEL_117;
        }
        constructor = Class.forName(s2, true, context.getClassLoader()).getConstructor(b);
        s1.put(s2, constructor);
        context = (a)constructor.newInstance(new Object[] {
            context, attributeset
        });
        return context;
    }

    private void a(bh bh1)
    {
        if (!bh1.e()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i1;
        int j1;
        j1 = getChildCount();
        i1 = 0;
_L6:
        if (i1 >= j1) goto _L1; else goto _L3
_L3:
        Object obj;
        View view;
        view = getChildAt(i1);
        obj = bh1;
        if (!ai.w(view))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = ((c)view.getLayoutParams()).a();
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        bh1 = ((a) (obj)).a(this, view, bh1);
        if (bh1.e()) goto _L1; else goto _L4
_L4:
        obj = ai.b(view, bh1);
        if (((bh) (obj)).e()) goto _L1; else goto _L5
_L5:
        i1++;
        bh1 = ((bh) (obj));
          goto _L6
    }

    private void a(View view, View view1, int i1)
    {
        Object obj = (c)view.getLayoutParams();
        obj = i;
        Rect rect = j;
        a(view1, ((Rect) (obj)));
        a(view, i1, ((Rect) (obj)), rect);
        view.layout(rect.left, rect.top, rect.right, rect.bottom);
    }

    private void a(List list)
    {
        list.clear();
        boolean flag = isChildrenDrawingOrderEnabled();
        int k1 = getChildCount();
        int i1 = k1 - 1;
        while (i1 >= 0) 
        {
            int j1;
            if (flag)
            {
                j1 = getChildDrawingOrder(k1, i1);
            } else
            {
                j1 = i1;
            }
            list.add(getChildAt(j1));
            i1--;
        }
        if (e != null)
        {
            Collections.sort(list, e);
        }
    }

    private boolean a(MotionEvent motionevent)
    {
label0:
        {
            boolean flag2 = false;
            boolean flag = false;
            Object obj = null;
            int j1 = motionevent.getActionMasked();
            List list = h;
            a(list);
            int k1 = list.size();
            int i1 = 0;
label1:
            do
            {
                {
                    if (i1 >= k1)
                    {
                        break label0;
                    }
                    Object obj1 = (View)list.get(i1);
                    c c1 = (c)((View) (obj1)).getLayoutParams();
                    a a1 = c1.a();
                    if (!flag2 && !flag || j1 == 0)
                    {
                        break label1;
                    }
                    boolean flag1;
                    boolean flag3;
                    boolean flag4;
                    if (a1 != null)
                    {
                        if (obj != null)
                        {
                            long l1 = SystemClock.uptimeMillis();
                            obj = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
                        }
                        a1.a(this, ((View) (obj1)), ((MotionEvent) (obj)));
                        flag3 = flag2;
                        obj1 = obj;
                    } else
                    {
                        obj1 = obj;
                        flag3 = flag2;
                    }
                }
                i1++;
                flag2 = flag3;
                obj = obj1;
            } while (true);
            if (!flag2 && a1 != null)
            {
                flag2 = a1.a(this, ((View) (obj1)), motionevent);
                if (flag2)
                {
                    p = ((View) (obj1));
                }
            }
            flag3 = c1.d();
            flag4 = c1.a(this, ((View) (obj1)));
            if (flag4 && !flag3)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            flag = flag1;
            obj1 = obj;
            flag3 = flag2;
            if (!flag4)
            {
                break MISSING_BLOCK_LABEL_130;
            }
            flag = flag1;
            obj1 = obj;
            flag3 = flag2;
            if (flag1)
            {
                break MISSING_BLOCK_LABEL_130;
            }
        }
        list.clear();
        return flag2;
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

    private void b(View view, int i1, int j1)
    {
        c c1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        c1 = (c)view.getLayoutParams();
        l2 = android.support.v4.view.e.a(c(c1.c), j1);
        k2 = getWidth();
        j2 = getHeight();
        l1 = view.getMeasuredWidth();
        i2 = view.getMeasuredHeight();
        int k1 = i1;
        if (j1 == 1)
        {
            k1 = k2 - i1;
        }
        i1 = a(k1) - l1;
        j1 = 0;
        l2 & 7;
        JVM INSTR lookupswitch 2: default 104
    //                   1: 227
    //                   5: 219;
           goto _L1 _L2 _L3
_L1:
        l2 & 0x70;
        JVM INSTR lookupswitch 2: default 136
    //                   16: 245
    //                   80: 237;
           goto _L4 _L5 _L6
_L4:
        i1 = Math.max(getPaddingLeft() + c1.leftMargin, Math.min(i1, k2 - getPaddingRight() - l1 - c1.rightMargin));
        j1 = Math.max(getPaddingTop() + c1.topMargin, Math.min(j1, j2 - getPaddingBottom() - i2 - c1.bottomMargin));
        view.layout(i1, j1, i1 + l1, j1 + i2);
        return;
_L3:
        i1 += l1;
          goto _L1
_L2:
        i1 += l1 / 2;
          goto _L1
_L6:
        j1 = 0 + i2;
          goto _L4
_L5:
        j1 = 0 + i2 / 2;
          goto _L4
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

    private void c(View view, int i1)
    {
        c c1 = (c)view.getLayoutParams();
        Rect rect = i;
        rect.set(getPaddingLeft() + c1.leftMargin, getPaddingTop() + c1.topMargin, getWidth() - getPaddingRight() - c1.rightMargin, getHeight() - getPaddingBottom() - c1.bottomMargin);
        if (u != null && ai.w(this) && !ai.w(view))
        {
            rect.left = rect.left + u.a();
            rect.top = rect.top + u.b();
            rect.right = rect.right - u.c();
            rect.bottom = rect.bottom - u.d();
        }
        Rect rect1 = j;
        android.support.v4.view.e.a(b(c1.c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect1, i1);
        view.layout(rect1.left, rect1.top, rect1.right, rect1.bottom);
    }

    private static int d(int i1)
    {
        int j1 = i1;
        if (i1 == 0)
        {
            j1 = 17;
        }
        return j1;
    }

    private void e()
    {
        int i1 = 0;
        if (p != null)
        {
            a a1 = ((c)p.getLayoutParams()).a();
            if (a1 != null)
            {
                long l1 = SystemClock.uptimeMillis();
                MotionEvent motionevent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
                a1.b(this, p, motionevent);
                motionevent.recycle();
            }
            p = null;
        }
        for (int j1 = getChildCount(); i1 < j1; i1++)
        {
            ((c)getChildAt(i1).getLayoutParams()).e();
        }

    }

    private void f()
    {
        boolean flag2 = false;
        int k1 = getChildCount();
        boolean flag;
        int j1;
        if (g.size() != k1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        for (j1 = 0; j1 < k1;)
        {
            View view = getChildAt(j1);
            c c1 = a(view);
            boolean flag1 = flag;
            if (!flag)
            {
                flag1 = flag;
                if (c1.c(this, view))
                {
                    flag1 = true;
                }
            }
            c1.b(this, view);
            j1++;
            flag = flag1;
        }

        if (flag)
        {
            g.clear();
            for (int i1 = ((flag2) ? 1 : 0); i1 < k1; i1++)
            {
                g.add(getChildAt(i1));
            }

            Collections.sort(g, d);
        }
    }

    private void setWindowInsets(bh bh1)
    {
        boolean flag1 = true;
        if (u != bh1)
        {
            u = bh1;
            boolean flag;
            if (bh1 != null && bh1.b() > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            v = flag;
            if (!v && getBackground() == null)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            setWillNotDraw(flag);
            a(bh1);
            requestLayout();
        }
    }

    public c a(AttributeSet attributeset)
    {
        return new c(getContext(), attributeset);
    }

    c a(View view)
    {
        c c1 = (c)view.getLayoutParams();
        if (!c1.b)
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
                view = (b)class1.getAnnotation(android/support/design/widget/CoordinatorLayout$b);
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
                    c1.a((a)view1.a().newInstance());
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    Log.e("CoordinatorLayout", (new StringBuilder()).append("Default behavior class ").append(view1.a().getName()).append(" could not be instantiated. Did you forget a default constructor?").toString(), view);
                }
            }
            c1.b = true;
        }
        return c1;
    }

    protected c a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (layoutparams instanceof c)
        {
            return new c((c)layoutparams);
        }
        if (layoutparams instanceof android.view.ViewGroup.MarginLayoutParams)
        {
            return new c((android.view.ViewGroup.MarginLayoutParams)layoutparams);
        } else
        {
            return new c(layoutparams);
        }
    }

    void a()
    {
        boolean flag1 = false;
        int j1 = getChildCount();
        int i1 = 0;
label0:
        do
        {
label1:
            {
                boolean flag = flag1;
                if (i1 < j1)
                {
                    if (!c(getChildAt(i1)))
                    {
                        break label1;
                    }
                    flag = true;
                }
                if (flag != t)
                {
                    if (!flag)
                    {
                        break label0;
                    }
                    b();
                }
                return;
            }
            i1++;
        } while (true);
        c();
    }

    public void a(View view, int i1)
    {
        c c1 = (c)view.getLayoutParams();
        if (c1.c())
        {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        if (c1.g != null)
        {
            a(view, c1.g, i1);
            return;
        }
        if (c1.e >= 0)
        {
            b(view, c1.e, i1);
            return;
        } else
        {
            c(view, i1);
            return;
        }
    }

    public void a(View view, int i1, int j1, int k1, int l1)
    {
        measureChildWithMargins(view, i1, j1, k1, l1);
    }

    void a(View view, int i1, Rect rect, Rect rect1)
    {
        c c1;
        int j1;
        int l1;
        int i2;
        int j2;
        c1 = (c)view.getLayoutParams();
        j2 = android.support.v4.view.e.a(d(c1.c), i1);
        j1 = android.support.v4.view.e.a(b(c1.d), i1);
        l1 = view.getMeasuredWidth();
        i2 = view.getMeasuredHeight();
        j1 & 7;
        JVM INSTR lookupswitch 2: default 80
    //                   1: 310
    //                   5: 302;
           goto _L1 _L2 _L3
_L1:
        i1 = rect.left;
_L13:
        j1 & 0x70;
        JVM INSTR lookupswitch 2: default 116
    //                   16: 336
    //                   80: 327;
           goto _L4 _L5 _L6
_L4:
        j1 = rect.top;
_L14:
        int k1 = i1;
        j2 & 7;
        JVM INSTR lookupswitch 2: default 156
    //                   1: 352
    //                   5: 162;
           goto _L7 _L8 _L9
_L9:
        break; /* Loop/switch isn't completed */
_L7:
        k1 = i1 - l1;
_L15:
        i1 = j1;
        j2 & 0x70;
        JVM INSTR lookupswitch 2: default 196
    //                   16: 363
    //                   80: 202;
           goto _L10 _L11 _L12
_L12:
        break; /* Loop/switch isn't completed */
_L10:
        i1 = j1 - i2;
_L16:
        int k2 = getWidth();
        j1 = getHeight();
        k1 = Math.max(getPaddingLeft() + c1.leftMargin, Math.min(k1, k2 - getPaddingRight() - l1 - c1.rightMargin));
        i1 = Math.max(getPaddingTop() + c1.topMargin, Math.min(i1, j1 - getPaddingBottom() - i2 - c1.bottomMargin));
        rect1.set(k1, i1, k1 + l1, i1 + i2);
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
        k1 = i1 - l1 / 2;
          goto _L15
_L11:
        i1 = j1 - i2 / 2;
          goto _L16
    }

    void a(View view, Rect rect)
    {
        android.support.design.widget.j.b(this, view, rect);
    }

    void a(View view, boolean flag, Rect rect)
    {
        if (view.isLayoutRequested() || view.getVisibility() == 8)
        {
            rect.set(0, 0, 0, 0);
            return;
        }
        if (flag)
        {
            a(view, rect);
            return;
        } else
        {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            return;
        }
    }

    void a(boolean flag)
    {
        int l1 = ai.h(this);
        int i2 = g.size();
        int i1 = 0;
        while (i1 < i2) 
        {
            View view = (View)g.get(i1);
            Object obj = (c)view.getLayoutParams();
            for (int j1 = 0; j1 < i1; j1++)
            {
                View view2 = (View)g.get(j1);
                if (((c) (obj)).h == view2)
                {
                    b(view, l1);
                }
            }

            obj = i;
            Rect rect = j;
            c(view, ((Rect) (obj)));
            a(view, true, rect);
            if (!((Rect) (obj)).equals(rect))
            {
                b(view, rect);
                int k1 = i1 + 1;
                while (k1 < i2) 
                {
                    View view1 = (View)g.get(k1);
                    c c1 = (c)view1.getLayoutParams();
                    a a1 = c1.a();
                    if (a1 != null && a1.b(this, view1, view))
                    {
                        if (!flag && c1.h())
                        {
                            c1.i();
                        } else
                        {
                            boolean flag1 = a1.c(this, view1, view);
                            if (flag)
                            {
                                c1.b(flag1);
                            }
                        }
                    }
                    k1++;
                }
            }
            i1++;
        }
    }

    public boolean a(View view, int i1, int j1)
    {
        Rect rect = i;
        a(view, rect);
        return rect.contains(i1, j1);
    }

    void b()
    {
        if (n)
        {
            if (s == null)
            {
                s = new d();
            }
            getViewTreeObserver().addOnPreDrawListener(s);
        }
        t = true;
    }

    public void b(View view)
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
                c c1 = (c)view1.getLayoutParams();
                a a1 = c1.a();
                if (a1 != null && c1.a(this, view1, view))
                {
                    a1.c(this, view1, view);
                }
            }
            i1++;
        }
    }

    void b(View view, int i1)
    {
        c c1 = (c)view.getLayoutParams();
        if (c1.g != null)
        {
            Rect rect = i;
            Rect rect1 = j;
            Rect rect2 = k;
            a(c1.g, rect);
            a(view, false, rect1);
            a(view, i1, rect, rect2);
            i1 = rect2.left - rect1.left;
            int j1 = rect2.top - rect1.top;
            if (i1 != 0)
            {
                view.offsetLeftAndRight(i1);
            }
            if (j1 != 0)
            {
                view.offsetTopAndBottom(j1);
            }
            if (i1 != 0 || j1 != 0)
            {
                a a1 = c1.a();
                if (a1 != null)
                {
                    a1.c(this, view, c1.g);
                }
            }
        }
    }

    void b(View view, Rect rect)
    {
        ((c)view.getLayoutParams()).a(rect);
    }

    void c()
    {
        if (n && s != null)
        {
            getViewTreeObserver().removeOnPreDrawListener(s);
        }
        t = false;
    }

    void c(View view, Rect rect)
    {
        rect.set(((c)view.getLayoutParams()).b());
    }

    boolean c(View view)
    {
        c c1;
        int i1;
        int j1;
        c1 = (c)view.getLayoutParams();
        if (c1.g != null)
        {
            return true;
        }
        j1 = getChildCount();
        i1 = 0;
_L3:
        View view1;
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        view1 = getChildAt(i1);
          goto _L1
_L5:
        i1++;
        if (true) goto _L3; else goto _L2
_L1:
        if (view1 == view || !c1.a(this, view, view1)) goto _L5; else goto _L4
_L4:
        return true;
_L2:
        return false;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return (layoutparams instanceof c) && super.checkLayoutParams(layoutparams);
    }

    protected c d()
    {
        return new c(-2, -2);
    }

    protected boolean drawChild(Canvas canvas, View view, long l1)
    {
        c c1 = (c)view.getLayoutParams();
        if (c1.a != null && c1.a.c(this, view) > 0.0F)
        {
            if (m == null)
            {
                m = new Paint();
            }
            m.setColor(c1.a.b(this, view));
            canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), m);
        }
        return super.drawChild(canvas, view, l1);
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return d();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return a(attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return a(layoutparams);
    }

    public int getNestedScrollAxes()
    {
        return x.a();
    }

    public Drawable getStatusBarBackground()
    {
        return w;
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
        e();
        if (t)
        {
            if (s == null)
            {
                s = new d();
            }
            getViewTreeObserver().addOnPreDrawListener(s);
        }
        n = true;
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        e();
        if (t && s != null)
        {
            getViewTreeObserver().removeOnPreDrawListener(s);
        }
        if (r != null)
        {
            onStopNestedScroll(r);
        }
        n = false;
    }

    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (v && w != null)
        {
            int i1;
            if (u != null)
            {
                i1 = u.b();
            } else
            {
                i1 = 0;
            }
            if (i1 > 0)
            {
                w.setBounds(0, 0, getWidth(), i1);
                w.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i1 = motionevent.getActionMasked();
        if (i1 == 0)
        {
            e();
        }
        boolean flag = a(motionevent);
        if (false)
        {
            throw new NullPointerException();
        }
        if (i1 == 1 || i1 == 3)
        {
            e();
        }
        return flag;
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        j1 = ai.h(this);
        k1 = g.size();
        for (i1 = 0; i1 < k1; i1++)
        {
            View view = (View)g.get(i1);
            a a1 = ((c)view.getLayoutParams()).a();
            if (a1 == null || !a1.a(this, view, j1))
            {
                a(view, j1);
            }
        }

    }

    protected void onMeasure(int i1, int j1)
    {
        int k1;
        boolean flag;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int l5;
        f();
        a();
        j3 = getPaddingLeft();
        int k3 = getPaddingTop();
        int l3 = getPaddingRight();
        int i4 = getPaddingBottom();
        int j4 = ai.h(this);
        View view;
        c c1;
        a a1;
        boolean flag1;
        int l1;
        int k4;
        int l4;
        int i5;
        int j5;
        int k5;
        int i6;
        if (j4 == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        k4 = android.view.View.MeasureSpec.getMode(i1);
        l4 = android.view.View.MeasureSpec.getSize(i1);
        i5 = android.view.View.MeasureSpec.getMode(j1);
        j5 = android.view.View.MeasureSpec.getSize(j1);
        k2 = getSuggestedMinimumWidth();
        j2 = getSuggestedMinimumHeight();
        if (u != null && ai.w(this))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        k5 = g.size();
        l1 = 0;
        i2 = 0;
_L6:
        if (l1 >= k5)
        {
            break MISSING_BLOCK_LABEL_490;
        }
        view = (View)g.get(l1);
        c1 = (c)view.getLayoutParams();
        l2 = 0;
        k1 = l2;
        if (c1.e < 0) goto _L2; else goto _L1
_L1:
        k1 = l2;
        if (k4 == 0) goto _L2; else goto _L3
_L3:
        i3 = a(c1.e);
        l5 = android.support.v4.view.e.a(c(c1.c), j4) & 7;
        if ((l5 != 3 || flag) && (l5 != 5 || !flag)) goto _L5; else goto _L4
_L4:
        k1 = Math.max(0, l4 - l3 - i3);
_L2:
        if (flag1 && !ai.w(view))
        {
            l2 = u.a();
            i6 = u.c();
            i3 = u.b();
            l5 = u.d();
            l2 = android.view.View.MeasureSpec.makeMeasureSpec(l4 - (l2 + i6), k4);
            i3 = android.view.View.MeasureSpec.makeMeasureSpec(j5 - (i3 + l5), i5);
        } else
        {
            i3 = j1;
            l2 = i1;
        }
        a1 = c1.a();
        if (a1 == null || !a1.a(this, view, l2, k1, i3, 0))
        {
            a(view, l2, k1, i3, 0);
        }
        k2 = Math.max(k2, view.getMeasuredWidth() + (j3 + l3) + c1.leftMargin + c1.rightMargin);
        j2 = Math.max(j2, view.getMeasuredHeight() + (k3 + i4) + c1.topMargin + c1.bottomMargin);
        i2 = ai.a(i2, ai.l(view));
        l1++;
        if (true) goto _L6; else goto _L5
_L5:
        if (l5 == 5 && !flag) goto _L8; else goto _L7
_L7:
        k1 = l2;
        if (l5 != 3) goto _L2; else goto _L9
_L9:
        k1 = l2;
        if (!flag) goto _L2; else goto _L8
_L8:
        k1 = Math.max(0, i3 - j3);
          goto _L2
        setMeasuredDimension(ai.a(k2, i1, 0xff000000 & i2), ai.a(j2, j1, i2 << 16));
        return;
    }

    public boolean onNestedFling(View view, float f1, float f2, boolean flag)
    {
        int j1 = getChildCount();
        int i1 = 0;
        boolean flag1 = false;
        while (i1 < j1) 
        {
            View view1 = getChildAt(i1);
            Object obj = (c)view1.getLayoutParams();
            if (((c) (obj)).g())
            {
                obj = ((c) (obj)).a();
                if (obj != null)
                {
                    flag1 = ((a) (obj)).a(this, view1, view, f1, f2, flag) | flag1;
                }
            }
            i1++;
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
        int i1 = 0;
        boolean flag = false;
        while (i1 < j1) 
        {
            View view1 = getChildAt(i1);
            Object obj = (c)view1.getLayoutParams();
            if (((c) (obj)).g())
            {
                obj = ((c) (obj)).a();
                if (obj != null)
                {
                    flag = ((a) (obj)).a(this, view1, view, f1, f2) | flag;
                }
            }
            i1++;
        }
        return flag;
    }

    public void onNestedPreScroll(View view, int i1, int j1, int ai1[])
    {
        int l1 = 0;
        int k1 = 0;
        int i2 = 0;
        int j3 = getChildCount();
        int j2 = 0;
        while (j2 < j3) 
        {
            View view1 = getChildAt(j2);
            Object obj = (c)view1.getLayoutParams();
            int l2;
            if (!((c) (obj)).g())
            {
                int k2 = i2;
                i2 = l1;
                l1 = k1;
                k1 = k2;
            } else
            {
                obj = ((c) (obj)).a();
                if (obj != null)
                {
                    int ai2[] = l;
                    l[1] = 0;
                    ai2[0] = 0;
                    ((a) (obj)).a(this, view1, view, i1, j1, l);
                    if (i1 > 0)
                    {
                        i2 = Math.max(l1, l[0]);
                    } else
                    {
                        i2 = Math.min(l1, l[0]);
                    }
                    if (j1 > 0)
                    {
                        k1 = Math.max(k1, l[1]);
                    } else
                    {
                        k1 = Math.min(k1, l[1]);
                    }
                    l1 = k1;
                    k1 = 1;
                } else
                {
                    int i3 = i2;
                    i2 = l1;
                    l1 = k1;
                    k1 = i3;
                }
            }
            l2 = j2 + 1;
            j2 = i2;
            i2 = k1;
            k1 = l1;
            l1 = j2;
            j2 = l2;
        }
        ai1[0] = l1;
        ai1[1] = k1;
        if (i2 != 0)
        {
            a(true);
        }
    }

    public void onNestedScroll(View view, int i1, int j1, int k1, int l1)
    {
        int j2 = getChildCount();
        boolean flag = false;
        int i2 = 0;
        while (i2 < j2) 
        {
            View view1 = getChildAt(i2);
            Object obj = (c)view1.getLayoutParams();
            if (((c) (obj)).g())
            {
                obj = ((c) (obj)).a();
                if (obj != null)
                {
                    ((a) (obj)).a(this, view1, view, i1, j1, k1, l1);
                    flag = true;
                }
            }
            i2++;
        }
        if (flag)
        {
            a(true);
        }
    }

    public void onNestedScrollAccepted(View view, View view1, int i1)
    {
        x.a(view, view1, i1);
        q = view;
        r = view1;
        int k1 = getChildCount();
        int j1 = 0;
        while (j1 < k1) 
        {
            View view2 = getChildAt(j1);
            Object obj = (c)view2.getLayoutParams();
            if (((c) (obj)).g())
            {
                obj = ((c) (obj)).a();
                if (obj != null)
                {
                    ((a) (obj)).b(this, view2, view, view1, i1);
                }
            }
            j1++;
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
            a a1 = a(view).a();
            if (k1 == -1 || a1 == null)
            {
                continue;
            }
            Parcelable parcelable1 = (Parcelable)parcelable.get(k1);
            if (parcelable1 != null)
            {
                a1.a(this, view, parcelable1);
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
            a a1 = ((c)((View) (obj)).getLayoutParams()).a();
            if (k1 == -1 || a1 == null)
            {
                continue;
            }
            obj = a1.a(this, ((View) (obj)));
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
            c c1 = (c)view2.getLayoutParams();
            a a1 = c1.a();
            if (a1 != null)
            {
                boolean flag1 = a1.a(this, view2, view, view1, i1);
                flag |= flag1;
                c1.a(flag1);
            } else
            {
                c1.a(false);
            }
            j1++;
        }
        return flag;
    }

    public void onStopNestedScroll(View view)
    {
        x.a(view);
        int j1 = getChildCount();
        int i1 = 0;
        while (i1 < j1) 
        {
            View view1 = getChildAt(i1);
            c c1 = (c)view1.getLayoutParams();
            if (c1.g())
            {
                a a1 = c1.a();
                if (a1 != null)
                {
                    a1.a(this, view1, view);
                }
                c1.f();
                c1.i();
            }
            i1++;
        }
        q = null;
        r = null;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        Object obj;
        int i1;
        boolean flag2;
        flag2 = false;
        obj = null;
        i1 = motionevent.getActionMasked();
        if (p != null) goto _L2; else goto _L1
_L1:
        boolean flag = a(motionevent);
        if (!flag) goto _L4; else goto _L3
_L3:
        boolean flag1;
        a a1 = ((c)p.getLayoutParams()).a();
        flag1 = flag;
        if (a1 != null)
        {
            a1.b(this, p, motionevent);
            flag1 = flag;
        }
_L8:
        if (p != null) goto _L6; else goto _L5
_L5:
        flag = false | super.onTouchEvent(motionevent);
        motionevent = obj;
_L7:
        if (!flag)
        {
            if (i1 != 0);
        }
        if (motionevent != null)
        {
            motionevent.recycle();
        }
        if (i1 == 1 || i1 == 3)
        {
            e();
        }
        return flag;
_L6:
        motionevent = obj;
        flag = flag2;
        if (flag1)
        {
            if (false)
            {
                long l1 = SystemClock.uptimeMillis();
                motionevent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
            } else
            {
                motionevent = null;
            }
            super.onTouchEvent(motionevent);
            flag = flag2;
        }
        if (true) goto _L7; else goto _L4
_L4:
        flag1 = flag;
        if (true) goto _L8; else goto _L2
_L2:
        flag = false;
        if (true) goto _L3; else goto _L9
_L9:
    }

    public void requestDisallowInterceptTouchEvent(boolean flag)
    {
        super.requestDisallowInterceptTouchEvent(flag);
        if (flag)
        {
            e();
        }
    }

    public void setStatusBarBackground(Drawable drawable)
    {
        w = drawable;
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
            drawable = android.support.v4.a.a.a(getContext(), i1);
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
            e = new e();
            f = new android.support.design.widget.c();
        } else
        {
            e = null;
            f = null;
        }
    }
}
