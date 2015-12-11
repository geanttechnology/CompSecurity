// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ah;
import android.support.v4.widget.o;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.List;

// Referenced classes of package android.support.design.widget:
//            l, AppBarLayout, n, a, 
//            g, d, CoordinatorLayout

public static class _cls1.b extends l
{
    protected static class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState a(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public SavedState[] a(int i)
            {
                return new SavedState[i];
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


        public SavedState(Parcel parcel)
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

        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

    private class a
    {

        final AppBarLayout.Behavior a;
        private final CoordinatorLayout b;
        private final AppBarLayout c;

        public void a()
        {
            if (c != null && AppBarLayout.Behavior.a(a) != null && AppBarLayout.Behavior.a(a).g())
            {
                a.b(b, c, AppBarLayout.Behavior.a(a).c());
                ah.a(c, this);
            }
        }

        a(CoordinatorLayout coordinatorlayout, AppBarLayout appbarlayout)
        {
            a = AppBarLayout.Behavior.this;
            super();
            b = coordinatorlayout;
            c = appbarlayout;
        }
    }


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
                    ams ams = (ams)view.getLayoutParams();
                    Interpolator interpolator = ams.b();
                    if (i1 < view.getTop() || i1 > view.getBottom())
                    {
                        break label0;
                    }
                    k = i;
                    if (interpolator != null)
                    {
                        int k1 = ams.a();
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

    static o a( )
    {
        return .d;
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
                obj = (d)((WeakReference) (obj)).get();
            } else
            {
                obj = null;
            }
            if (obj != null)
            {
                ((d) (obj)).d(appbarlayout, b());
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
            c = new a(coordinatorlayout, appbarlayout);
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
            e.a(new g.c(coordinatorlayout, appbarlayout) {

                final CoordinatorLayout a;
                final AppBarLayout b;
                final AppBarLayout.Behavior c;

                public void a(g g1)
                {
                    c.b(a, b, g1.b());
                }

            
            {
                c = AppBarLayout.Behavior.this;
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
