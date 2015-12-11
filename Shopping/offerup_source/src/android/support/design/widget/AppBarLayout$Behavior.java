// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.at;
import android.support.v4.view.bi;
import android.support.v4.widget.au;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.List;

// Referenced classes of package android.support.design.widget:
//            bz, AppBarLayout, h, g, 
//            CoordinatorLayout, cb, a, bk, 
//            d, e

public class l extends bz
{

    private int a;
    private boolean b;
    private Runnable c;
    private au d;
    private bk e;
    private int f;
    private boolean g;
    private float h;
    private boolean i;
    private int j;
    private int k;
    private int l;
    private WeakReference m;

    private int a(CoordinatorLayout coordinatorlayout, AppBarLayout appbarlayout, int i1, int j1, int k1)
    {
        return b(coordinatorlayout, appbarlayout, a() - i1, j1, k1);
    }

    static au a(a a1)
    {
        return a1.d;
    }

    private void a(AppBarLayout appbarlayout)
    {
        List list = AppBarLayout.a(appbarlayout);
        int j1 = list.size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            h h1 = (h)list.get(i1);
            if (h1 != null)
            {
                h1.a(appbarlayout, super.b());
            }
        }

    }

    private int b(CoordinatorLayout coordinatorlayout, AppBarLayout appbarlayout, int i1, int j1, int k1)
    {
        int l1;
        boolean flag;
        int i2;
        int j2;
        i2 = 0;
        flag = false;
        j2 = a();
        l1 = i2;
        if (j1 == 0) goto _L2; else goto _L1
_L1:
        l1 = i2;
        if (j2 < j1) goto _L2; else goto _L3
_L3:
        l1 = i2;
        if (j2 > k1) goto _L2; else goto _L4
_L4:
        float f1;
        View view;
        g g1;
        Interpolator interpolator;
        boolean flag1;
        if (i1 < j1)
        {
            i1 = j1;
        } else
        if (i1 > k1)
        {
            i1 = k1;
        }
        l1 = i2;
        if (j2 == i1) goto _L2; else goto _L5
_L5:
        if (!appbarlayout.a)
        {
            break MISSING_BLOCK_LABEL_347;
        }
        l1 = Math.abs(i1);
        k1 = appbarlayout.getChildCount();
        j1 = 0;
_L12:
        if (j1 >= k1) goto _L7; else goto _L6
_L6:
        view = appbarlayout.getChildAt(j1);
        g1 = (g)view.getLayoutParams();
        interpolator = g1.b;
        if (l1 < view.getTop() || l1 > view.getBottom()) goto _L9; else goto _L8
_L8:
        if (interpolator == null) goto _L7; else goto _L10
_L10:
        i2 = g1.a;
        j1 = ((flag) ? 1 : 0);
        if ((i2 & 1) != 0)
        {
            j1 = view.getHeight();
            k1 = g1.topMargin;
            k1 = g1.bottomMargin + (j1 + k1) + 0;
            j1 = k1;
            if ((i2 & 2) != 0)
            {
                j1 = k1 - bi.p(view);
            }
        }
        if (j1 <= 0) goto _L7; else goto _L11
_L11:
        k1 = view.getTop();
        f1 = j1;
        j1 = Math.round(interpolator.getInterpolation((float)(l1 - k1) / (float)j1) * f1);
        k1 = Integer.signum(i1);
        j1 = (j1 + view.getTop()) * k1;
_L13:
        flag1 = super.a(j1);
        l1 = j2 - i1;
        a = i1 - j1;
        if (!flag1 && appbarlayout.a)
        {
            coordinatorlayout.a(appbarlayout);
        }
        a(appbarlayout);
_L2:
        return l1;
_L9:
        j1++;
          goto _L12
_L7:
        j1 = i1;
          goto _L13
        j1 = i1;
          goto _L13
    }

    private void b(CoordinatorLayout coordinatorlayout, AppBarLayout appbarlayout, int i1)
    {
        if (e == null)
        {
            e = cb.a();
            e.a(a.b);
            e.a(new d(this, coordinatorlayout, appbarlayout));
        } else
        {
            e.d();
        }
        e.a(a(), i1);
        e.a();
    }

    private boolean c()
    {
        if (m != null)
        {
            View view = (View)m.get();
            return view != null && view.isShown() && !bi.b(view, -1);
        } else
        {
            return false;
        }
    }

    final int a()
    {
        return super.b() + a;
    }

    final int a(CoordinatorLayout coordinatorlayout, AppBarLayout appbarlayout, int i1)
    {
        return b(coordinatorlayout, appbarlayout, i1, 0x80000000, 0x7fffffff);
    }

    public final Parcelable a(CoordinatorLayout coordinatorlayout, View view)
    {
        boolean flag = false;
        view = (AppBarLayout)view;
        Parcelable parcelable = super.a(coordinatorlayout, view);
        int j1 = super.b();
        int k1 = view.getChildCount();
        for (int i1 = 0; i1 < k1; i1++)
        {
            coordinatorlayout = view.getChildAt(i1);
            int l1 = coordinatorlayout.getBottom() + j1;
            if (coordinatorlayout.getTop() + j1 <= 0 && l1 >= 0)
            {
                class SavedState extends android.view.View.BaseSavedState
                {

                    public static final android.os.Parcelable.Creator CREATOR = new f();
                    int a;
                    float b;
                    boolean c;

                    public void writeToParcel(Parcel parcel, int i2)
                    {
                        super.writeToParcel(parcel, i2);
                        parcel.writeInt(a);
                        parcel.writeFloat(b);
                        if (c)
                        {
                            i2 = 1;
                        } else
                        {
                            i2 = 0;
                        }
                        parcel.writeByte((byte)i2);
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

                view = new SavedState(parcelable);
                view.a = i1;
                if (l1 == bi.p(coordinatorlayout))
                {
                    flag = true;
                }
                view.c = flag;
                view.b = (float)l1 / (float)coordinatorlayout.getHeight();
                return view;
            }
        }

        return parcelable;
    }

    public final void a(CoordinatorLayout coordinatorlayout, View view, Parcelable parcelable)
    {
        view = (AppBarLayout)view;
        if (parcelable instanceof SavedState)
        {
            parcelable = (SavedState)parcelable;
            super.a(coordinatorlayout, view, parcelable.getSuperState());
            f = ((SavedState) (parcelable)).a;
            h = ((SavedState) (parcelable)).b;
            g = ((SavedState) (parcelable)).c;
            return;
        } else
        {
            super.a(coordinatorlayout, view, parcelable);
            f = -1;
            return;
        }
    }

    public final void a(CoordinatorLayout coordinatorlayout, View view, View view1)
    {
        b = false;
        m = new WeakReference(view1);
    }

    public final void a(CoordinatorLayout coordinatorlayout, View view, View view1, int i1, int j1, int k1, int l1)
    {
        view = (AppBarLayout)view;
        if (l1 < 0)
        {
            a(coordinatorlayout, ((AppBarLayout) (view)), l1, -view.getDownNestedScrollRange(), 0);
            b = true;
            return;
        } else
        {
            b = false;
            return;
        }
    }

    public final void a(CoordinatorLayout coordinatorlayout, View view, View view1, int i1, int j1, int ai[])
    {
        view = (AppBarLayout)view;
        if (j1 != 0 && !b)
        {
            int k1;
            if (j1 < 0)
            {
                i1 = -view.getTotalScrollRange();
                k1 = i1 + view.getDownNestedPreScrollRange();
            } else
            {
                i1 = -view.getUpNestedPreScrollRange();
                k1 = 0;
            }
            ai[1] = a(coordinatorlayout, ((AppBarLayout) (view)), j1, i1, k1);
        }
    }

    public final volatile boolean a(int i1)
    {
        return super.a(i1);
    }

    public final boolean a(CoordinatorLayout coordinatorlayout, View view, int i1)
    {
        view = (AppBarLayout)view;
        boolean flag = super.a(coordinatorlayout, view, i1);
        int j1 = view.getPendingAction();
        if (j1 != 0)
        {
            if ((j1 & 4) != 0)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            if ((j1 & 2) != 0)
            {
                j1 = -view.getUpNestedPreScrollRange();
                if (i1 != 0)
                {
                    b(coordinatorlayout, view, j1);
                } else
                {
                    a(coordinatorlayout, ((AppBarLayout) (view)), j1);
                }
            } else
            if ((j1 & 1) != 0)
            {
                if (i1 != 0)
                {
                    b(coordinatorlayout, view, 0);
                } else
                {
                    a(coordinatorlayout, ((AppBarLayout) (view)), 0);
                }
            }
            view.a();
        } else
        if (f >= 0)
        {
            coordinatorlayout = view.getChildAt(f);
            i1 = -coordinatorlayout.getBottom();
            if (g)
            {
                i1 = bi.p(coordinatorlayout) + i1;
            } else
            {
                i1 = Math.round((float)coordinatorlayout.getHeight() * h) + i1;
            }
            super.a(i1);
            f = -1;
        }
        a(((AppBarLayout) (view)));
        return flag;
    }

    public final boolean a(CoordinatorLayout coordinatorlayout, View view, MotionEvent motionevent)
    {
        int i1;
        int j1;
        boolean flag1;
        flag1 = false;
        view = (AppBarLayout)view;
        if (l < 0)
        {
            l = ViewConfiguration.get(coordinatorlayout.getContext()).getScaledTouchSlop();
        }
        i1 = (int)motionevent.getX();
        j1 = (int)motionevent.getY();
        at.a(motionevent);
        JVM INSTR tableswitch 0 3: default 76
    //                   0 82
    //                   1 254
    //                   2 127
    //                   3 254;
           goto _L1 _L2 _L3 _L4 _L3
_L1:
        boolean flag = true;
_L6:
        return flag;
_L2:
        flag = flag1;
        if (!coordinatorlayout.a(view, i1, j1)) goto _L6; else goto _L5
_L5:
        flag = flag1;
        if (!c()) goto _L6; else goto _L7
_L7:
        k = j1;
        j = at.b(motionevent, 0);
        continue; /* Loop/switch isn't completed */
_L4:
        i1 = at.a(motionevent, j);
        flag = flag1;
        if (i1 == -1) goto _L6; else goto _L8
_L8:
        int l1 = (int)at.d(motionevent, i1);
        int k1 = k - l1;
        i1 = k1;
        if (!i)
        {
            i1 = k1;
            if (Math.abs(k1) > l)
            {
                i = true;
                if (k1 > 0)
                {
                    i1 = k1 - l;
                } else
                {
                    i1 = k1 + l;
                }
            }
        }
        if (i)
        {
            k = l1;
            a(coordinatorlayout, ((AppBarLayout) (view)), i1, -view.getDownNestedScrollRange(), 0);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        i = false;
        j = -1;
        if (true) goto _L1; else goto _L9
_L9:
    }

    public final boolean a(CoordinatorLayout coordinatorlayout, View view, View view1, float f1, float f2, boolean flag)
    {
        view = (AppBarLayout)view;
        if (!flag)
        {
            int i1 = -view.getTotalScrollRange();
            f1 = -f2;
            if (c != null)
            {
                view.removeCallbacks(c);
            }
            if (d == null)
            {
                d = au.a(view.getContext());
            }
            d.a(0, a(), 0, Math.round(f1), 0, 0, i1, 0);
            if (d.g())
            {
                c = new e(this, coordinatorlayout, view);
                bi.a(view, c);
                return true;
            } else
            {
                c = null;
                return false;
            }
        }
        if (f2 >= 0.0F) goto _L2; else goto _L1
_L1:
        int j1;
        int k1;
        k1 = -view.getTotalScrollRange() + view.getDownNestedPreScrollRange();
        j1 = k1;
        if (a() <= k1) goto _L4; else goto _L3
_L3:
        return false;
_L2:
        j1 = -view.getUpNestedPreScrollRange();
        if (a() < j1)
        {
            continue; /* Loop/switch isn't completed */
        }
_L4:
        if (a() != j1)
        {
            b(coordinatorlayout, view, j1);
            return true;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public final boolean a(CoordinatorLayout coordinatorlayout, View view, View view1, View view2, int i1)
    {
        boolean flag;
        flag = true;
        view = (AppBarLayout)view;
        if ((i1 & 2) == 0) goto _L2; else goto _L1
_L1:
        if (view.getTotalScrollRange() != 0)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 == 0 || coordinatorlayout.getHeight() - view1.getHeight() > view.getHeight()) goto _L2; else goto _L3
_L3:
        if (flag && e != null)
        {
            e.d();
        }
        m = null;
        return flag;
_L2:
        flag = false;
        if (true) goto _L3; else goto _L4
_L4:
    }

    public final volatile int b()
    {
        return super.b();
    }

    public final boolean b(CoordinatorLayout coordinatorlayout, View view, MotionEvent motionevent)
    {
        view = (AppBarLayout)view;
        if (l < 0)
        {
            l = ViewConfiguration.get(coordinatorlayout.getContext()).getScaledTouchSlop();
        }
        if (motionevent.getAction() == 2 && i)
        {
            return true;
        }
        at.a(motionevent);
        JVM INSTR tableswitch 0 3: default 76
    //                   0 147
    //                   1 203
    //                   2 81
    //                   3 203;
           goto _L1 _L2 _L3 _L4 _L3
_L1:
        return i;
_L4:
        int i1 = j;
        if (i1 != -1)
        {
            i1 = at.a(motionevent, i1);
            if (i1 != -1)
            {
                i1 = (int)at.d(motionevent, i1);
                if (Math.abs(i1 - k) > l)
                {
                    i = true;
                    k = i1;
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        i = false;
        int j1 = (int)motionevent.getX();
        int k1 = (int)motionevent.getY();
        if (coordinatorlayout.a(view, j1, k1) && c())
        {
            k = k1;
            j = at.b(motionevent, 0);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        i = false;
        j = -1;
        if (true) goto _L1; else goto _L5
_L5:
    }

    public SavedState()
    {
        f = -1;
        j = -1;
        l = -1;
    }

    public l(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        f = -1;
        j = -1;
        l = -1;
    }
}
