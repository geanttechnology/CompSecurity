// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.huewu.pla.lib.internal;

import android.content.Context;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Adapter;

// Referenced classes of package com.huewu.pla.lib.internal:
//            o, m, p, n

public abstract class PLA_AdapterView extends ViewGroup
{

    int E;
    int F;
    int G[];
    int H;
    long I;
    long J;
    boolean K;
    int L;
    boolean M;
    o N;
    m O;
    n P;
    boolean Q;
    int R;
    long S;
    int T;
    long U;
    int V;
    int W;
    private int a;
    int aa;
    long ab;
    boolean ac;
    private View b;
    private p c;

    public PLA_AdapterView(Context context)
    {
        super(context);
        E = 0;
        I = 0x8000000000000000L;
        K = false;
        M = false;
        R = -1;
        S = 0x8000000000000000L;
        T = -1;
        U = 0x8000000000000000L;
        aa = -1;
        ab = 0x8000000000000000L;
        ac = false;
    }

    public PLA_AdapterView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        E = 0;
        I = 0x8000000000000000L;
        K = false;
        M = false;
        R = -1;
        S = 0x8000000000000000L;
        T = -1;
        U = 0x8000000000000000L;
        aa = -1;
        ab = 0x8000000000000000L;
        ac = false;
    }

    public PLA_AdapterView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        E = 0;
        I = 0x8000000000000000L;
        K = false;
        M = false;
        R = -1;
        S = 0x8000000000000000L;
        T = -1;
        U = 0x8000000000000000L;
        aa = -1;
        ab = 0x8000000000000000L;
        ac = false;
    }

    static Parcelable a(PLA_AdapterView pla_adapterview)
    {
        return pla_adapterview.onSaveInstanceState();
    }

    private void a()
    {
        if (N == null)
        {
            return;
        }
        int i1 = getSelectedItemPosition();
        if (i1 >= 0)
        {
            View view = getSelectedView();
            N.a(this, view, i1, getAdapter().getItemId(i1));
            return;
        } else
        {
            N.a(this);
            return;
        }
    }

    static void a(PLA_AdapterView pla_adapterview, Parcelable parcelable)
    {
        pla_adapterview.onRestoreInstanceState(parcelable);
    }

    private void a(boolean flag)
    {
        if (i())
        {
            flag = false;
        }
        if (flag)
        {
            if (b != null)
            {
                b.setVisibility(0);
                setVisibility(8);
            } else
            {
                setVisibility(0);
            }
            if (Q)
            {
                onLayout(false, getLeft(), getTop(), getRight(), getBottom());
            }
            return;
        }
        if (b != null)
        {
            b.setVisibility(8);
        }
        setVisibility(0);
    }

    private void b()
    {
        if (getSelectedItemPosition() >= 0)
        {
            sendAccessibilityEvent(4);
        }
    }

    static void b(PLA_AdapterView pla_adapterview)
    {
        pla_adapterview.a();
    }

    static void c(PLA_AdapterView pla_adapterview)
    {
        pla_adapterview.b();
    }

    public void addView(View view)
    {
        throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    public void addView(View view, int i1)
    {
        throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    public void addView(View view, int i1, android.view.ViewGroup.LayoutParams layoutparams)
    {
        throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
    }

    public void addView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
    }

    int b(int i1, boolean flag)
    {
        return i1;
    }

    public int b(View view)
    {
        do
        {
            View view1;
            boolean flag;
            try
            {
                view1 = (View)view.getParent();
                flag = view1.equals(this);
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                return -1;
            }
            if (!flag)
            {
                view = view1;
            } else
            {
                int j1 = getChildCount();
                for (int i1 = 0; i1 < j1; i1++)
                {
                    if (getChildAt(i1).equals(view))
                    {
                        return i1 + E;
                    }
                }

                return -1;
            }
        } while (true);
    }

    public boolean b(View view, int i1, long l1)
    {
        boolean flag = false;
        if (O != null)
        {
            playSoundEffect(0);
            O.a(this, view, i1, l1);
            flag = true;
        }
        return flag;
    }

    protected boolean canAnimate()
    {
        return super.canAnimate() && V > 0;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        boolean flag = false;
        if (accessibilityevent.getEventType() == 8)
        {
            accessibilityevent.setEventType(4);
        }
        View view = getSelectedView();
        if (view != null)
        {
            flag = view.dispatchPopulateAccessibilityEvent(accessibilityevent);
        }
        if (!flag)
        {
            if (view != null)
            {
                accessibilityevent.setEnabled(view.isEnabled());
            }
            accessibilityevent.setItemCount(getCount());
            accessibilityevent.setCurrentItemIndex(getSelectedItemPosition());
        }
        return flag;
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
        return V;
    }

    public View getEmptyView()
    {
        return b;
    }

    public int getFirstVisiblePosition()
    {
        return E;
    }

    public int getLastVisiblePosition()
    {
        return (E + getChildCount()) - 1;
    }

    public final m getOnItemClickListener()
    {
        return O;
    }

    public final n getOnItemLongClickListener()
    {
        return P;
    }

    public final o getOnItemSelectedListener()
    {
        return N;
    }

    public Object getSelectedItem()
    {
        Adapter adapter = getAdapter();
        int i1 = getSelectedItemPosition();
        if (adapter != null && adapter.getCount() > 0 && i1 >= 0)
        {
            return adapter.getItem(i1);
        } else
        {
            return null;
        }
    }

    public long getSelectedItemId()
    {
        return S;
    }

    public int getSelectedItemPosition()
    {
        return R;
    }

    public abstract View getSelectedView();

    void h()
    {
        int l1;
        l1 = V;
        if (l1 <= 0)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        if (!K) goto _L2; else goto _L1
_L1:
        int i1;
        K = false;
        i1 = l();
        if (i1 < 0 || b(i1, true) != i1) goto _L2; else goto _L3
_L3:
        boolean flag;
        setNextSelectedPositionInt(i1);
        flag = true;
_L4:
        if (!flag)
        {
            int k1 = getSelectedItemPosition();
            int j1 = k1;
            if (k1 >= l1)
            {
                j1 = l1 - 1;
            }
            k1 = j1;
            if (j1 < 0)
            {
                k1 = 0;
            }
            j1 = b(k1, true);
            if (j1 < 0)
            {
                j1 = b(k1, false);
            }
            if (j1 >= 0)
            {
                setNextSelectedPositionInt(j1);
                k();
                flag = true;
            }
        }
_L5:
        if (!flag)
        {
            T = -1;
            U = 0x8000000000000000L;
            R = -1;
            S = 0x8000000000000000L;
            K = false;
            k();
        }
        return;
_L2:
        flag = false;
          goto _L4
        flag = false;
          goto _L5
    }

    boolean i()
    {
        return false;
    }

    void j()
    {
label0:
        {
            if (N != null)
            {
                if (!M && !ac)
                {
                    break label0;
                }
                if (c == null)
                {
                    c = new p(this);
                }
                post(c);
            }
            return;
        }
        a();
        b();
    }

    public long k(int i1)
    {
        Adapter adapter = getAdapter();
        if (adapter == null || i1 < 0)
        {
            return 0x8000000000000000L;
        } else
        {
            return adapter.getItemId(i1);
        }
    }

    void k()
    {
        if (T != aa || U != ab)
        {
            j();
            aa = T;
            ab = U;
        }
    }

    int l()
    {
        int j2 = V;
        if (j2 != 0) goto _L2; else goto _L1
_L1:
        int l1 = -1;
_L4:
        return l1;
_L2:
        Adapter adapter;
        int i1;
        boolean flag;
        long l2;
        long l3;
        l2 = I;
        i1 = H;
        if (l2 == 0x8000000000000000L)
        {
            return -1;
        }
        i1 = Math.min(j2 - 1, Math.max(0, i1));
        l3 = SystemClock.uptimeMillis();
        flag = false;
        adapter = getAdapter();
        if (adapter == null)
        {
            return -1;
        }
        break MISSING_BLOCK_LABEL_196;
_L6:
        int j1;
        int k1;
        boolean flag1;
        if (flag1 || flag && l1 == 0)
        {
            j1++;
            flag = false;
            i1 = j1;
        } else
        if (l1 != 0 || !flag && !flag1)
        {
            k1--;
            flag = true;
            i1 = k1;
        }
_L7:
        if (SystemClock.uptimeMillis() > l3 + 100L)
        {
            break; /* Loop/switch isn't completed */
        }
        l1 = i1;
        if (adapter.getItemId(i1) == l2) goto _L4; else goto _L3
_L3:
        if (j1 == j2 - 1)
        {
            l1 = 1;
        } else
        {
            l1 = 0;
        }
        if (k1 == 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (l1 == 0 || !flag1) goto _L6; else goto _L5
_L5:
        return -1;
        k1 = i1;
        int i2 = i1;
        j1 = i1;
        i1 = i2;
          goto _L7
    }

    void m()
    {
        if (getChildCount() > 0)
        {
            K = true;
            J = a;
            View view = getChildAt(0);
            Adapter adapter = getAdapter();
            if (E >= 0 && E < adapter.getCount())
            {
                I = S;
                H = R;
            } else
            {
                I = -1L;
            }
            H = E;
            if (view != null)
            {
                F = view.getTop();
            }
            L = 1;
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        removeCallbacks(c);
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        a = getHeight();
    }

    public void removeAllViews()
    {
        throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    public void removeView(View view)
    {
        throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    public void removeViewAt(int i1)
    {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    public abstract void setAdapter(Adapter adapter);

    public void setEmptyView(View view)
    {
        b = view;
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

    void setNextSelectedPositionInt(int i1)
    {
        R = i1;
        S = k(i1);
        if (K && L == 0 && i1 >= 0)
        {
            H = i1;
            I = S;
        }
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }

    public void setOnItemClickListener(m m1)
    {
        O = m1;
    }

    public void setOnItemLongClickListener(n n)
    {
        if (!isLongClickable())
        {
            setLongClickable(true);
        }
        P = n;
    }

    public void setOnItemSelectedListener(o o1)
    {
        N = o1;
    }

    public abstract void setSelection(int i1);
}
