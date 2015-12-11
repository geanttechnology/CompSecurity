// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ac;
import android.support.v4.view.ah;
import android.support.v4.view.bf;
import android.support.v4.widget.o;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.support.design.widget:
//            n, l, a, g, 
//            d, CoordinatorLayout

public class AppBarLayout extends LinearLayout
{
    public static class Behavior extends l
    {

        private int a;
        private boolean b;
        private Runnable c;
        private o d;
        private g e;
        private int f;
        private boolean g;
        private float h;

        private int a(AppBarLayout appbarlayout, int i)
        {
            int i1 = Math.abs(i);
            int j1 = appbarlayout.getChildCount();
            int j = 0;
            do
            {
label0:
                {
                    int k = i;
                    if (j < j1)
                    {
                        View view = appbarlayout.getChildAt(j);
                        LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
                        Interpolator interpolator = layoutparams.b();
                        if (i1 < view.getTop() || i1 > view.getBottom())
                        {
                            break label0;
                        }
                        k = i;
                        if (interpolator != null)
                        {
                            int k1 = layoutparams.a();
                            if ((k1 & 1) != 0)
                            {
                                k = view.getHeight() + 0;
                                j = k;
                                if ((k1 & 2) != 0)
                                {
                                    j = k - ah.p(view);
                                }
                            } else
                            {
                                j = 0;
                            }
                            k = i;
                            if (j > 0)
                            {
                                k = view.getTop();
                                float f1 = j;
                                j = Math.round(interpolator.getInterpolation((float)(i1 - k) / (float)j) * f1);
                                k = Integer.signum(i) * (j + view.getTop());
                            }
                        }
                    }
                    return k;
                }
                j++;
            } while (true);
        }

        static o a(Behavior behavior)
        {
            return behavior.d;
        }

        private void a(AppBarLayout appbarlayout)
        {
            List list = AppBarLayout.a(appbarlayout);
            int j = list.size();
            int i = 0;
            while (i < j) 
            {
                Object obj = (WeakReference)list.get(i);
                if (obj != null)
                {
                    obj = (a)((WeakReference) (obj)).get();
                } else
                {
                    obj = null;
                }
                if (obj != null)
                {
                    ((a) (obj)).a(appbarlayout, b());
                }
                i++;
            }
        }

        private boolean a(CoordinatorLayout coordinatorlayout, AppBarLayout appbarlayout, int i, int j, float f1)
        {
            if (c != null)
            {
                appbarlayout.removeCallbacks(c);
            }
            if (d == null)
            {
                d = o.a(appbarlayout.getContext());
            }
            d.a(0, a(), 0, Math.round(f1), 0, 0, i, j);
            if (d.g())
            {
                c = new a(this, coordinatorlayout, appbarlayout);
                ah.a(appbarlayout, c);
                return true;
            } else
            {
                c = null;
                return false;
            }
        }

        private int b(CoordinatorLayout coordinatorlayout, AppBarLayout appbarlayout, int i, int j, int k)
        {
            return a(coordinatorlayout, appbarlayout, a() - i, j, k);
        }

        private void c(CoordinatorLayout coordinatorlayout, AppBarLayout appbarlayout, int i)
        {
            if (e == null)
            {
                e = n.a();
                e.a(android.support.design.widget.a.c);
                e.a(new g.c(this, coordinatorlayout, appbarlayout) {

                    final CoordinatorLayout a;
                    final AppBarLayout b;
                    final Behavior c;

                    public void a(g g1)
                    {
                        c.b(a, b, g1.b());
                    }

            
            {
                c = behavior;
                a = coordinatorlayout;
                b = appbarlayout;
                super();
            }
                });
            } else
            {
                e.c();
            }
            e.a(a(), i);
            e.a();
        }

        final int a()
        {
            return b() + a;
        }

        final int a(CoordinatorLayout coordinatorlayout, AppBarLayout appbarlayout, int i, int j, int k)
        {
            int j1 = a();
            boolean flag = false;
            int i1 = ((flag) ? 1 : 0);
            if (j != 0)
            {
                i1 = ((flag) ? 1 : 0);
                if (j1 >= j)
                {
                    i1 = ((flag) ? 1 : 0);
                    if (j1 <= k)
                    {
                        j = android.support.design.widget.d.a(i, j, k);
                        i1 = ((flag) ? 1 : 0);
                        if (j1 != j)
                        {
                            boolean flag1;
                            if (appbarlayout.b())
                            {
                                i = a(appbarlayout, j);
                            } else
                            {
                                i = j;
                            }
                            flag1 = a(i);
                            a = j - i;
                            if (!flag1 && appbarlayout.b())
                            {
                                coordinatorlayout.b(appbarlayout);
                            }
                            a(appbarlayout);
                            i1 = j1 - j;
                        }
                    }
                }
            }
            return i1;
        }

        public Parcelable a(CoordinatorLayout coordinatorlayout, AppBarLayout appbarlayout)
        {
            boolean flag = false;
            Parcelable parcelable = super.a(coordinatorlayout, appbarlayout);
            int j = b();
            int k = appbarlayout.getChildCount();
            for (int i = 0; i < k; i++)
            {
                coordinatorlayout = appbarlayout.getChildAt(i);
                int i1 = coordinatorlayout.getBottom() + j;
                if (coordinatorlayout.getTop() + j <= 0 && i1 >= 0)
                {
                    appbarlayout = new SavedState(parcelable);
                    appbarlayout.a = i;
                    if (i1 == ah.p(coordinatorlayout))
                    {
                        flag = true;
                    }
                    appbarlayout.c = flag;
                    appbarlayout.b = (float)i1 / (float)coordinatorlayout.getHeight();
                    return appbarlayout;
                }
            }

            return parcelable;
        }

        public volatile Parcelable a(CoordinatorLayout coordinatorlayout, View view)
        {
            return a(coordinatorlayout, (AppBarLayout)view);
        }

        public void a(CoordinatorLayout coordinatorlayout, AppBarLayout appbarlayout, Parcelable parcelable)
        {
            if (parcelable instanceof SavedState)
            {
                parcelable = (SavedState)parcelable;
                super.a(coordinatorlayout, appbarlayout, parcelable.getSuperState());
                f = ((SavedState) (parcelable)).a;
                h = ((SavedState) (parcelable)).b;
                g = ((SavedState) (parcelable)).c;
                return;
            } else
            {
                super.a(coordinatorlayout, appbarlayout, parcelable);
                f = -1;
                return;
            }
        }

        public void a(CoordinatorLayout coordinatorlayout, AppBarLayout appbarlayout, View view)
        {
            b = false;
        }

        public void a(CoordinatorLayout coordinatorlayout, AppBarLayout appbarlayout, View view, int i, int j, int k, int i1)
        {
            if (i1 < 0)
            {
                b(coordinatorlayout, appbarlayout, i1, -appbarlayout.getDownNestedScrollRange(), 0);
                b = true;
                return;
            } else
            {
                b = false;
                return;
            }
        }

        public void a(CoordinatorLayout coordinatorlayout, AppBarLayout appbarlayout, View view, int i, int j, int ai[])
        {
            if (j != 0 && !b)
            {
                int k;
                if (j < 0)
                {
                    i = -appbarlayout.getTotalScrollRange();
                    k = i + appbarlayout.getDownNestedPreScrollRange();
                } else
                {
                    i = -appbarlayout.getUpNestedPreScrollRange();
                    k = 0;
                }
                ai[1] = b(coordinatorlayout, appbarlayout, j, i, k);
            }
        }

        public volatile void a(CoordinatorLayout coordinatorlayout, View view, Parcelable parcelable)
        {
            a(coordinatorlayout, (AppBarLayout)view, parcelable);
        }

        public volatile void a(CoordinatorLayout coordinatorlayout, View view, View view1)
        {
            a(coordinatorlayout, (AppBarLayout)view, view1);
        }

        public volatile void a(CoordinatorLayout coordinatorlayout, View view, View view1, int i, int j, int k, int i1)
        {
            a(coordinatorlayout, (AppBarLayout)view, view1, i, j, k, i1);
        }

        public volatile void a(CoordinatorLayout coordinatorlayout, View view, View view1, int i, int j, int ai[])
        {
            a(coordinatorlayout, (AppBarLayout)view, view1, i, j, ai);
        }

        public volatile boolean a(int i)
        {
            return super.a(i);
        }

        public boolean a(CoordinatorLayout coordinatorlayout, AppBarLayout appbarlayout, int i)
        {
            boolean flag = super.a(coordinatorlayout, appbarlayout, i);
            if (f >= 0)
            {
                coordinatorlayout = appbarlayout.getChildAt(f);
                i = -coordinatorlayout.getBottom();
                if (g)
                {
                    i = ah.p(coordinatorlayout) + i;
                } else
                {
                    i = Math.round((float)coordinatorlayout.getHeight() * h) + i;
                }
                a(i);
                f = -1;
            }
            a(appbarlayout);
            return flag;
        }

        public boolean a(CoordinatorLayout coordinatorlayout, AppBarLayout appbarlayout, View view, float f1, float f2, boolean flag)
        {
            boolean flag1 = false;
            if (flag) goto _L2; else goto _L1
_L1:
            flag = a(coordinatorlayout, appbarlayout, -appbarlayout.getTotalScrollRange(), 0, -f2);
_L4:
            return flag;
_L2:
            int i;
            if (f2 >= 0.0F)
            {
                break; /* Loop/switch isn't completed */
            }
            i = -appbarlayout.getTotalScrollRange() + appbarlayout.getDownNestedPreScrollRange();
            flag = flag1;
            if (a() > i)
            {
                continue; /* Loop/switch isn't completed */
            }
_L5:
            flag = flag1;
            if (a() != i)
            {
                c(coordinatorlayout, appbarlayout, i);
                return true;
            }
            if (true) goto _L4; else goto _L3
_L3:
            int j = -appbarlayout.getUpNestedPreScrollRange();
            i = j;
            if (a() < j)
            {
                return false;
            }
              goto _L5
            if (true) goto _L4; else goto _L6
_L6:
        }

        public boolean a(CoordinatorLayout coordinatorlayout, AppBarLayout appbarlayout, View view, View view1, int i)
        {
            boolean flag;
            if ((i & 2) != 0 && appbarlayout.c())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && e != null)
            {
                e.c();
            }
            return flag;
        }

        public volatile boolean a(CoordinatorLayout coordinatorlayout, View view, int i)
        {
            return a(coordinatorlayout, (AppBarLayout)view, i);
        }

        public volatile boolean a(CoordinatorLayout coordinatorlayout, View view, View view1, float f1, float f2, boolean flag)
        {
            return a(coordinatorlayout, (AppBarLayout)view, view1, f1, f2, flag);
        }

        public volatile boolean a(CoordinatorLayout coordinatorlayout, View view, View view1, View view2, int i)
        {
            return a(coordinatorlayout, (AppBarLayout)view, view1, view2, i);
        }

        public volatile int b()
        {
            return super.b();
        }

        final int b(CoordinatorLayout coordinatorlayout, AppBarLayout appbarlayout, int i)
        {
            return a(coordinatorlayout, appbarlayout, i, 0x80000000, 0x7fffffff);
        }
    }

    protected static class Behavior.SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public Behavior.SavedState a(Parcel parcel)
            {
                return new Behavior.SavedState(parcel);
            }

            public Behavior.SavedState[] a(int i)
            {
                return new Behavior.SavedState[i];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int i)
            {
                return a(i);
            }

        };
        int a;
        float b;
        boolean c;

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeInt(a);
            parcel.writeFloat(b);
            if (c)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel.writeByte((byte)i);
        }


        public Behavior.SavedState(Parcel parcel)
        {
            super(parcel);
            a = parcel.readInt();
            b = parcel.readFloat();
            boolean flag;
            if (parcel.readByte() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            c = flag;
        }

        public Behavior.SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

    private class Behavior.a
    {

        final Behavior a;
        private final CoordinatorLayout b;
        private final AppBarLayout c;

        public void a()
        {
            if (c != null && Behavior.a(a) != null && Behavior.a(a).g())
            {
                a.b(b, c, Behavior.a(a).c());
                ah.a(c, this);
            }
        }

        Behavior.a(Behavior behavior, CoordinatorLayout coordinatorlayout, AppBarLayout appbarlayout)
        {
            a = behavior;
            super();
            b = coordinatorlayout;
            c = appbarlayout;
        }
    }

    public static class LayoutParams extends android.widget.LinearLayout.LayoutParams
    {

        int a;
        Interpolator b;

        public int a()
        {
            return a;
        }

        public Interpolator b()
        {
            return b;
        }

        public LayoutParams(int i, int j)
        {
            super(i, j);
            a = 1;
        }

        public LayoutParams(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
            a = 1;
            attributeset = context.obtainStyledAttributes(attributeset, android.support.v7.a.g.AppBarLayout_LayoutParams);
            a = attributeset.getInt(android.support.v7.a.g.AppBarLayout_LayoutParams_layout_scrollFlags, 0);
            if (attributeset.hasValue(android.support.v7.a.g.AppBarLayout_LayoutParams_layout_scrollInterpolator))
            {
                b = AnimationUtils.loadInterpolator(context, attributeset.getResourceId(android.support.v7.a.g.AppBarLayout_LayoutParams_layout_scrollInterpolator, 0));
            }
            attributeset.recycle();
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
        {
            super(layoutparams);
            a = 1;
        }

        public LayoutParams(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
        {
            super(marginlayoutparams);
            a = 1;
        }

        public LayoutParams(android.widget.LinearLayout.LayoutParams layoutparams)
        {
            super(layoutparams);
            a = 1;
        }
    }

    public static interface a
    {

        public abstract void a(AppBarLayout appbarlayout, int i);
    }


    boolean a;
    private int b;
    private int c;
    private int d;
    private float e;
    private bf f;
    private final List g;

    public AppBarLayout(Context context)
    {
        this(context, null);
    }

    public AppBarLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b = -1;
        c = -1;
        d = -1;
        setOrientation(1);
        context = context.obtainStyledAttributes(attributeset, android.support.v7.a.g.AppBarLayout, 0, android.support.v7.a.f.Widget_Design_AppBarLayout);
        e = context.getDimensionPixelSize(android.support.v7.a.g.AppBarLayout_elevation, 0);
        setBackgroundDrawable(context.getDrawable(android.support.v7.a.g.AppBarLayout_android_background));
        context.recycle();
        n.a(this);
        g = new ArrayList();
        ah.f(this, e);
        ah.a(this, new ac() {

            final AppBarLayout a;

            public bf a(View view, bf bf1)
            {
                AppBarLayout.a(a, bf1);
                return bf1.f();
            }

            
            {
                a = AppBarLayout.this;
                super();
            }
        });
    }

    static List a(AppBarLayout appbarlayout)
    {
        return appbarlayout.g;
    }

    static void a(AppBarLayout appbarlayout, bf bf1)
    {
        appbarlayout.setWindowInsets(bf1);
    }

    private void setWindowInsets(bf bf1)
    {
        b = -1;
        f = bf1;
        int i = 0;
        int j = getChildCount();
        do
        {
label0:
            {
                if (i < j)
                {
                    bf1 = ah.b(getChildAt(i), bf1);
                    if (!bf1.e())
                    {
                        break label0;
                    }
                }
                return;
            }
            i++;
        } while (true);
    }

    protected LayoutParams a()
    {
        return new LayoutParams(-1, -2);
    }

    public LayoutParams a(AttributeSet attributeset)
    {
        return new LayoutParams(getContext(), attributeset);
    }

    protected LayoutParams a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (layoutparams instanceof android.widget.LinearLayout.LayoutParams)
        {
            return new LayoutParams((android.widget.LinearLayout.LayoutParams)layoutparams);
        }
        if (layoutparams instanceof android.view.ViewGroup.MarginLayoutParams)
        {
            return new LayoutParams((android.view.ViewGroup.MarginLayoutParams)layoutparams);
        } else
        {
            return new LayoutParams(layoutparams);
        }
    }

    final boolean b()
    {
        return a;
    }

    final boolean c()
    {
        return getTotalScrollRange() != 0;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return layoutparams instanceof LayoutParams;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return a();
    }

    protected android.widget.LinearLayout.LayoutParams generateDefaultLayoutParams()
    {
        return a();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return a(attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return a(layoutparams);
    }

    public android.widget.LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return a(attributeset);
    }

    protected android.widget.LinearLayout.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return a(layoutparams);
    }

    final int getDownNestedPreScrollRange()
    {
        int i;
        int j;
        if (c != -1)
        {
            return c;
        }
        i = 0;
        j = getChildCount() - 1;
_L5:
        if (j < 0) goto _L2; else goto _L1
_L1:
        int k;
        View view = getChildAt(j);
        LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
        int l;
        if (ah.z(view))
        {
            k = view.getHeight();
        } else
        {
            k = view.getMeasuredHeight();
        }
        l = layoutparams.a;
        if ((l & 5) != 5) goto _L4; else goto _L3
_L3:
        if ((l & 8) != 0)
        {
            i = ah.p(view) + i;
        } else
        {
            i += k;
        }
_L6:
        j--;
          goto _L5
_L4:
        if (i <= 0) goto _L6; else goto _L2
_L2:
        c = i;
        return i;
    }

    final int getDownNestedScrollRange()
    {
        if (d != -1)
        {
            return d;
        }
        int j = 0;
        int i = getChildCount() - 1;
        do
        {
            if (i < 0)
            {
                break;
            }
            View view = getChildAt(i);
            LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
            int k;
            int l;
            if (ah.z(view))
            {
                k = view.getHeight();
            } else
            {
                k = view.getMeasuredHeight();
            }
            l = layoutparams.a;
            if ((l & 1) == 0)
            {
                break;
            }
            j += k;
            if ((l & 2) != 0)
            {
                return j - ah.p(view);
            }
            i--;
        } while (true);
        d = j;
        return j;
    }

    final int getMinimumHeightForVisibleOverlappingContent()
    {
        int j = 0;
        int i;
        int k;
        if (f != null)
        {
            i = f.b();
        } else
        {
            i = 0;
        }
        k = ah.p(this);
        if (k != 0)
        {
            j = k * 2 + i;
        } else
        {
            int l = getChildCount();
            if (l >= 1)
            {
                return ah.p(getChildAt(l - 1)) * 2 + i;
            }
        }
        return j;
    }

    public float getTargetElevation()
    {
        return e;
    }

    public final int getTotalScrollRange()
    {
        if (b != -1)
        {
            return b;
        }
        int l = getChildCount();
        int j = 0;
        int i = 0;
        do
        {
label0:
            {
                if (j < l)
                {
                    View view = getChildAt(j);
                    LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
                    int k;
                    int i1;
                    if (ah.z(view))
                    {
                        k = view.getHeight();
                    } else
                    {
                        k = view.getMeasuredHeight();
                    }
                    i1 = layoutparams.a;
                    if ((i1 & 1) != 0)
                    {
                        i += k;
                        if ((i1 & 2) == 0)
                        {
                            break label0;
                        }
                        i -= ah.p(view);
                    }
                }
                if (f != null)
                {
                    j = f.b();
                } else
                {
                    j = 0;
                }
                i -= j;
                b = i;
                return i;
            }
            j++;
        } while (true);
    }

    final int getUpNestedPreScrollRange()
    {
        return getTotalScrollRange();
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        b = -1;
        c = -1;
        c = -1;
        a = false;
        j = getChildCount();
        i = 0;
        do
        {
label0:
            {
                if (i < j)
                {
                    if (((LayoutParams)getChildAt(i).getLayoutParams()).b() == null)
                    {
                        break label0;
                    }
                    a = true;
                }
                return;
            }
            i++;
        } while (true);
    }

    public void setOrientation(int i)
    {
        if (i != 1)
        {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        } else
        {
            super.setOrientation(i);
            return;
        }
    }

    public void setTargetElevation(float f1)
    {
        e = f1;
    }
}
