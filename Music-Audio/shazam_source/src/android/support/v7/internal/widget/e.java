// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Adapter;

public abstract class android.support.v7.internal.widget.e extends ViewGroup
{
    final class a extends DataSetObserver
    {

        final android.support.v7.internal.widget.e a;
        private Parcelable b;

        public final void onChanged()
        {
            a.v = true;
            a.B = a.A;
            a.A = a.getAdapter().getCount();
            if (!a.getAdapter().hasStableIds() || b == null || a.B != 0 || a.A <= 0) goto _L2; else goto _L1
_L1:
            android.support.v7.internal.widget.e.a(a, b);
            b = null;
_L4:
            a.b();
            a.requestLayout();
            return;
_L2:
            android.support.v7.internal.widget.e e1 = a;
            if (e1.getChildCount() > 0)
            {
                e1.o = true;
                e1.n = e1.q;
                if (e1.y >= 0)
                {
                    View view = e1.getChildAt(e1.y - e1.j);
                    e1.m = e1.x;
                    e1.l = e1.w;
                    if (view != null)
                    {
                        e1.k = view.getTop();
                    }
                    e1.p = 0;
                } else
                {
                    View view1 = e1.getChildAt(0);
                    Adapter adapter = e1.getAdapter();
                    if (e1.j >= 0 && e1.j < adapter.getCount())
                    {
                        e1.m = adapter.getItemId(e1.j);
                    } else
                    {
                        e1.m = -1L;
                    }
                    e1.l = e1.j;
                    if (view1 != null)
                    {
                        e1.k = view1.getTop();
                    }
                    e1.p = 1;
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public final void onInvalidated()
        {
            a.v = true;
            if (a.getAdapter().hasStableIds())
            {
                b = android.support.v7.internal.widget.e.a(a);
            }
            a.B = a.A;
            a.A = 0;
            a.y = -1;
            a.z = 0x8000000000000000L;
            a.w = -1;
            a.x = 0x8000000000000000L;
            a.o = false;
            a.b();
            a.requestLayout();
        }

        a()
        {
            a = android.support.v7.internal.widget.e.this;
            super();
            b = null;
        }
    }

    public static interface b
    {
    }

    public static interface c
    {
    }

    public static interface d
    {
    }

    private final class e
        implements Runnable
    {

        final android.support.v7.internal.widget.e a;

        public final void run()
        {
            if (a.v)
            {
                if (a.getAdapter() != null)
                {
                    a.post(this);
                }
                return;
            } else
            {
                android.support.v7.internal.widget.e.b(a);
                return;
            }
        }

        private e()
        {
            a = android.support.v7.internal.widget.e.this;
            super();
        }

        e(byte byte0)
        {
            this();
        }
    }


    int A;
    int B;
    int C;
    long D;
    boolean E;
    private View a;
    private boolean b;
    private boolean c;
    private e d;
    int j;
    int k;
    int l;
    long m;
    long n;
    boolean o;
    int p;
    int q;
    boolean r;
    d s;
    b t;
    c u;
    boolean v;
    int w;
    long x;
    int y;
    long z;

    android.support.v7.internal.widget.e(Context context, int i)
    {
        super(context, null, i);
        j = 0;
        m = 0x8000000000000000L;
        o = false;
        r = false;
        w = -1;
        x = 0x8000000000000000L;
        y = -1;
        z = 0x8000000000000000L;
        C = -1;
        D = 0x8000000000000000L;
        E = false;
    }

    private long a(int i)
    {
        Adapter adapter = getAdapter();
        if (adapter == null || i < 0)
        {
            return 0x8000000000000000L;
        } else
        {
            return adapter.getItemId(i);
        }
    }

    static Parcelable a(android.support.v7.internal.widget.e e1)
    {
        return e1.onSaveInstanceState();
    }

    private void a()
    {
        int i;
        if (s != null)
        {
            if ((i = getSelectedItemPosition()) >= 0)
            {
                getSelectedView();
                getAdapter().getItemId(i);
                return;
            }
        }
    }

    static void a(android.support.v7.internal.widget.e e1, Parcelable parcelable)
    {
        e1.onRestoreInstanceState(parcelable);
    }

    private void a(boolean flag)
    {
        if (flag)
        {
            if (a != null)
            {
                a.setVisibility(0);
                setVisibility(8);
            } else
            {
                setVisibility(0);
            }
            if (v)
            {
                onLayout(false, getLeft(), getTop(), getRight(), getBottom());
            }
            return;
        }
        if (a != null)
        {
            a.setVisibility(8);
        }
        setVisibility(0);
    }

    static void b(android.support.v7.internal.widget.e e1)
    {
        e1.a();
    }

    public final boolean a(View view)
    {
        if (t != null)
        {
            playSoundEffect(0);
            if (view != null)
            {
                view.sendAccessibilityEvent(1);
            }
            return true;
        } else
        {
            return false;
        }
    }

    public void addView(View view)
    {
        throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    public void addView(View view, int i)
    {
        throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutparams)
    {
        throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
    }

    public void addView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
    }

    final void b()
    {
label0:
        {
label1:
            {
                boolean flag2 = false;
                Adapter adapter = getAdapter();
                boolean flag;
                boolean flag1;
                if (adapter == null || adapter.getCount() == 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag && c)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                super.setFocusableInTouchMode(flag1);
                if (flag && b)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                super.setFocusable(flag1);
                if (a == null)
                {
                    break label0;
                }
                if (adapter != null)
                {
                    flag1 = flag2;
                    if (!adapter.isEmpty())
                    {
                        break label1;
                    }
                }
                flag1 = true;
            }
            a(flag1);
        }
    }

    final void c()
    {
        int l1;
        l1 = A;
        if (l1 <= 0)
        {
            break MISSING_BLOCK_LABEL_339;
        }
        if (!o) goto _L2; else goto _L1
_L1:
        int i2;
        o = false;
        i2 = A;
        if (i2 == 0) goto _L4; else goto _L3
_L3:
        int i;
        long l2;
        l2 = m;
        i = l;
        if (l2 == 0x8000000000000000L) goto _L4; else goto _L5
_L5:
        Adapter adapter;
        int i1;
        boolean flag;
        long l3;
        i1 = Math.min(i2 - 1, Math.max(0, i));
        l3 = SystemClock.uptimeMillis();
        flag = false;
        adapter = getAdapter();
        if (adapter == null) goto _L4; else goto _L6
_L6:
        int j1;
        int k1;
        j1 = i1;
        i = i1;
        k1 = i1;
        i1 = ((flag) ? 1 : 0);
_L12:
        if (SystemClock.uptimeMillis() > 100L + l3) goto _L4; else goto _L7
_L7:
        if (adapter.getItemId(i) != l2) goto _L9; else goto _L8
_L8:
        if (i < 0) goto _L2; else goto _L10
_L10:
        setNextSelectedPositionInt(i);
        i = 1;
_L13:
        i1 = i;
        if (i == 0)
        {
            j1 = getSelectedItemPosition();
            i1 = j1;
            if (j1 >= l1)
            {
                i1 = l1 - 1;
            }
            j1 = i1;
            if (i1 < 0)
            {
                j1 = 0;
            }
            if (j1 >= 0);
            i1 = i;
            if (j1 >= 0)
            {
                setNextSelectedPositionInt(j1);
                d();
                i1 = 1;
            }
        }
_L14:
        if (i1 == 0)
        {
            y = -1;
            z = 0x8000000000000000L;
            w = -1;
            x = 0x8000000000000000L;
            o = false;
            d();
        }
        return;
_L9:
        boolean flag1;
        if (k1 == i2 - 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (j1 == 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag && flag1) goto _L4; else goto _L11
_L11:
        if (flag1 || i1 != 0 && !flag)
        {
            k1++;
            i1 = 0;
            i = k1;
        } else
        if (flag || i1 == 0 && !flag1)
        {
            j1--;
            i1 = 1;
            i = j1;
        }
          goto _L12
_L4:
        i = -1;
          goto _L8
_L2:
        i = 0;
          goto _L13
        i1 = 0;
          goto _L14
    }

    protected boolean canAnimate()
    {
        return super.canAnimate() && A > 0;
    }

    final void d()
    {
        if (y != C || z != D)
        {
            if (s != null)
            {
                if (r || E)
                {
                    if (d == null)
                    {
                        d = new e((byte)0);
                    }
                    post(d);
                } else
                {
                    a();
                }
            }
            if (y != -1 && isShown() && !isInTouchMode())
            {
                sendAccessibilityEvent(4);
            }
            C = y;
            D = z;
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        View view = getSelectedView();
        return view != null && view.getVisibility() == 0 && view.dispatchPopulateAccessibilityEvent(accessibilityevent);
    }

    protected void dispatchRestoreInstanceState(SparseArray sparsearray)
    {
        dispatchThawSelfOnly(sparsearray);
    }

    protected void dispatchSaveInstanceState(SparseArray sparsearray)
    {
        dispatchFreezeSelfOnly(sparsearray);
    }

    public abstract Adapter getAdapter();

    public int getCount()
    {
        return A;
    }

    public View getEmptyView()
    {
        return a;
    }

    public int getFirstVisiblePosition()
    {
        return j;
    }

    public int getLastVisiblePosition()
    {
        return (j + getChildCount()) - 1;
    }

    public final b getOnItemClickListener()
    {
        return t;
    }

    public final c getOnItemLongClickListener()
    {
        return u;
    }

    public final d getOnItemSelectedListener()
    {
        return s;
    }

    public Object getSelectedItem()
    {
        Adapter adapter = getAdapter();
        int i = getSelectedItemPosition();
        if (adapter != null && adapter.getCount() > 0 && i >= 0)
        {
            return adapter.getItem(i);
        } else
        {
            return null;
        }
    }

    public long getSelectedItemId()
    {
        return x;
    }

    public int getSelectedItemPosition()
    {
        return w;
    }

    public abstract View getSelectedView();

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        removeCallbacks(d);
    }

    protected void onLayout(boolean flag, int i, int i1, int j1, int k1)
    {
        q = getHeight();
    }

    public void removeAllViews()
    {
        throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    public void removeView(View view)
    {
        throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    public void removeViewAt(int i)
    {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    public abstract void setAdapter(Adapter adapter);

    public void setEmptyView(View view)
    {
        a = view;
        view = getAdapter();
        boolean flag;
        if (view == null || view.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a(flag);
    }

    public void setFocusable(boolean flag)
    {
        boolean flag2 = true;
        Adapter adapter = getAdapter();
        boolean flag1;
        if (adapter == null || adapter.getCount() == 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        b = flag;
        if (!flag)
        {
            c = false;
        }
        if (flag && !flag1)
        {
            flag = flag2;
        } else
        {
            flag = false;
        }
        super.setFocusable(flag);
    }

    public void setFocusableInTouchMode(boolean flag)
    {
        boolean flag2 = true;
        Adapter adapter = getAdapter();
        boolean flag1;
        if (adapter == null || adapter.getCount() == 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        c = flag;
        if (flag)
        {
            b = true;
        }
        if (flag && !flag1)
        {
            flag = flag2;
        } else
        {
            flag = false;
        }
        super.setFocusableInTouchMode(flag);
    }

    void setNextSelectedPositionInt(int i)
    {
        w = i;
        x = a(i);
        if (o && p == 0 && i >= 0)
        {
            l = i;
            m = x;
        }
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }

    public void setOnItemClickListener(b b1)
    {
        t = b1;
    }

    public void setOnItemLongClickListener(c c1)
    {
        if (!isLongClickable())
        {
            setLongClickable(true);
        }
        u = c1;
    }

    public void setOnItemSelectedListener(d d1)
    {
        s = d1;
    }

    void setSelectedPositionInt(int i)
    {
        y = i;
        z = a(i);
    }

    public abstract void setSelection(int i);
}
