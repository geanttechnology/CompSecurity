// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.clhorizontalgridview;

import android.content.Context;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Adapter;

// Referenced classes of package com.cyberlink.you.widgetpool.clhorizontalgridview:
//            o, r, p, s, 
//            q

public abstract class AdapterView extends ViewGroup
{

    int S;
    int T;
    int U;
    long V;
    long W;
    private int a;
    boolean aa;
    int ab;
    boolean ac;
    r ad;
    p ae;
    q af;
    boolean ag;
    int ah;
    long ai;
    int aj;
    long ak;
    int al;
    int am;
    int an;
    long ao;
    boolean ap;
    private View b;
    private boolean c;
    private boolean d;
    private s e;

    public AdapterView(Context context)
    {
        super(context);
        S = 0;
        V = 0x8000000000000000L;
        aa = false;
        ac = false;
        ah = -1;
        ai = 0x8000000000000000L;
        aj = -1;
        ak = 0x8000000000000000L;
        an = -1;
        ao = 0x8000000000000000L;
        ap = false;
    }

    public AdapterView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        S = 0;
        V = 0x8000000000000000L;
        aa = false;
        ac = false;
        ah = -1;
        ai = 0x8000000000000000L;
        aj = -1;
        ak = 0x8000000000000000L;
        an = -1;
        ao = 0x8000000000000000L;
        ap = false;
    }

    public AdapterView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        S = 0;
        V = 0x8000000000000000L;
        aa = false;
        ac = false;
        ah = -1;
        ai = 0x8000000000000000L;
        aj = -1;
        ak = 0x8000000000000000L;
        an = -1;
        ao = 0x8000000000000000L;
        ap = false;
        ViewCompat.setAccessibilityDelegate(this, new o(this));
        if (ViewCompat.getImportantForAccessibility(this) == 0)
        {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    static Parcelable a(AdapterView adapterview)
    {
        return adapterview.onSaveInstanceState();
    }

    private void a()
    {
        if (ad == null)
        {
            return;
        }
        int i = getSelectedItemPosition();
        if (i >= 0)
        {
            View view = getSelectedView();
            ad.a(this, view, i, getAdapter().getItemId(i));
            return;
        } else
        {
            ad.a(this);
            return;
        }
    }

    static void a(AdapterView adapterview, Parcelable parcelable)
    {
        adapterview.onRestoreInstanceState(parcelable);
    }

    private void a(boolean flag)
    {
        if (r())
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
            if (ag)
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
        while (!((AccessibilityManager)getContext().getSystemService("accessibility")).isEnabled() || getSelectedItemPosition() < 0) 
        {
            return;
        }
        sendAccessibilityEvent(4);
    }

    static void b(AdapterView adapterview)
    {
        adapterview.a();
    }

    static void c(AdapterView adapterview)
    {
        adapterview.b();
    }

    private boolean c()
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            Adapter adapter = getAdapter();
            flag = flag1;
            if (adapter == null)
            {
                break label0;
            }
            int i = adapter.getCount();
            flag = flag1;
            if (i <= 0)
            {
                break label0;
            }
            if (getFirstVisiblePosition() <= 0)
            {
                flag = flag1;
                if (getLastVisiblePosition() >= i - 1)
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    static boolean d(AdapterView adapterview)
    {
        return adapterview.c();
    }

    int a(int i, boolean flag)
    {
        return i;
    }

    public int a(View view)
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
                int j = getChildCount();
                for (int i = 0; i < j; i++)
                {
                    if (getChildAt(i).equals(view))
                    {
                        return i + S;
                    }
                }

                return -1;
            }
        } while (true);
    }

    public boolean a(View view, int i, long l)
    {
        boolean flag = false;
        if (ae != null)
        {
            playSoundEffect(0);
            if (view != null)
            {
                view.sendAccessibilityEvent(1);
            }
            ae.a(this, view, i, l);
            flag = true;
        }
        return flag;
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

    protected boolean canAnimate()
    {
        return super.canAnimate() && al > 0;
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

    public long e(int i)
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

    public abstract Adapter getAdapter();

    public int getCount()
    {
        return al;
    }

    public View getEmptyView()
    {
        return b;
    }

    public int getFirstVisiblePosition()
    {
        return S;
    }

    public int getLastVisiblePosition()
    {
        return (S + getChildCount()) - 1;
    }

    public final p getOnItemClickListener()
    {
        return ae;
    }

    public final q getOnItemLongClickListener()
    {
        return af;
    }

    public final r getOnItemSelectedListener()
    {
        return ad;
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
        return ai;
    }

    public int getSelectedItemPosition()
    {
        return ah;
    }

    public abstract View getSelectedView();

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        removeCallbacks(e);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        a = getHeight();
    }

    void q()
    {
        int l;
        l = al;
        if (l <= 0)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        if (!aa) goto _L2; else goto _L1
_L1:
        int i;
        aa = false;
        i = v();
        if (i < 0 || a(i, true) != i) goto _L2; else goto _L3
_L3:
        boolean flag;
        setNextSelectedPositionInt(i);
        flag = true;
_L4:
        if (!flag)
        {
            int k = getSelectedItemPosition();
            int j = k;
            if (k >= l)
            {
                j = l - 1;
            }
            k = j;
            if (j < 0)
            {
                k = 0;
            }
            j = a(k, true);
            if (j < 0)
            {
                j = a(k, false);
            }
            if (j >= 0)
            {
                setNextSelectedPositionInt(j);
                u();
                flag = true;
            }
        }
_L5:
        if (!flag)
        {
            aj = -1;
            ak = 0x8000000000000000L;
            ah = -1;
            ai = 0x8000000000000000L;
            aa = false;
            u();
        }
        return;
_L2:
        flag = false;
          goto _L4
        flag = false;
          goto _L5
    }

    boolean r()
    {
        return false;
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

    void s()
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
                if (!flag || r())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag && d)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                super.setFocusableInTouchMode(flag1);
                if (flag && c)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                super.setFocusable(flag1);
                if (b == null)
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

    public abstract void setAdapter(Adapter adapter);

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
        c = flag;
        if (!flag)
        {
            d = false;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        flag = flag2;
        if (!flag1) goto _L4; else goto _L3
_L3:
        if (!r()) goto _L2; else goto _L5
_L5:
        flag = flag2;
_L4:
        super.setFocusable(flag);
        return;
_L2:
        flag = false;
        if (true) goto _L4; else goto _L6
_L6:
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
        d = flag;
        if (flag)
        {
            c = true;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        flag = flag2;
        if (!flag1) goto _L4; else goto _L3
_L3:
        if (!r()) goto _L2; else goto _L5
_L5:
        flag = flag2;
_L4:
        super.setFocusableInTouchMode(flag);
        return;
_L2:
        flag = false;
        if (true) goto _L4; else goto _L6
_L6:
    }

    void setNextSelectedPositionInt(int i)
    {
        ah = i;
        ai = e(i);
        if (aa && ab == 0 && i >= 0)
        {
            U = i;
            V = ai;
        }
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }

    public void setOnItemClickListener(p p1)
    {
        ae = p1;
    }

    public void setOnItemLongClickListener(q q1)
    {
        if (!isLongClickable())
        {
            setLongClickable(true);
        }
        af = q1;
    }

    public void setOnItemSelectedListener(r r1)
    {
        ad = r1;
    }

    void setSelectedPositionInt(int i)
    {
        aj = i;
        ak = e(i);
    }

    public abstract void setSelection(int i);

    void t()
    {
label0:
        {
            AccessibilityManager accessibilitymanager = (AccessibilityManager)getContext().getSystemService("accessibility");
            if (ad != null || accessibilitymanager.isEnabled())
            {
                if (!ac && !ap)
                {
                    break label0;
                }
                if (e == null)
                {
                    e = new s(this);
                }
                post(e);
            }
            return;
        }
        a();
        b();
    }

    void u()
    {
        if (aj != an || ak != ao)
        {
            t();
            an = aj;
            ao = ak;
        }
    }

    int v()
    {
        int j1 = al;
        if (j1 != 0) goto _L2; else goto _L1
_L1:
        int l = -1;
_L4:
        return l;
_L2:
        Adapter adapter;
        int i;
        boolean flag;
        long l1;
        long l2;
        l1 = V;
        i = U;
        if (l1 == 0x8000000000000000L)
        {
            return -1;
        }
        i = Math.min(j1 - 1, Math.max(0, i));
        l2 = SystemClock.uptimeMillis();
        flag = false;
        adapter = getAdapter();
        if (adapter == null)
        {
            return -1;
        }
        break MISSING_BLOCK_LABEL_178;
_L6:
        int j;
        int k;
        if (l != 0 || flag && i == 0)
        {
            j++;
            flag = false;
            i = j;
        } else
        {
            k--;
            flag = true;
            i = k;
        }
_L7:
        if (SystemClock.uptimeMillis() > 100L + l2)
        {
            break; /* Loop/switch isn't completed */
        }
        l = i;
        if (adapter.getItemId(i) == l1) goto _L4; else goto _L3
_L3:
        if (j == j1 - 1)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (k == 0)
        {
            l = 1;
        } else
        {
            l = 0;
        }
        if (i == 0 || l == 0) goto _L6; else goto _L5
_L5:
        return -1;
        k = i;
        int i1 = i;
        j = i;
        i = i1;
          goto _L7
    }

    void w()
    {
label0:
        {
            if (getChildCount() > 0)
            {
                aa = true;
                W = a;
                if (aj < 0)
                {
                    break label0;
                }
                View view = getChildAt(aj - S);
                V = ai;
                U = ah;
                if (view != null)
                {
                    T = view.getLeft();
                }
                ab = 0;
            }
            return;
        }
        View view1 = getChildAt(0);
        Adapter adapter = getAdapter();
        if (S >= 0 && S < adapter.getCount())
        {
            V = adapter.getItemId(S);
        } else
        {
            V = -1L;
        }
        U = S;
        if (view1 != null)
        {
            T = view1.getLeft();
        }
        ab = 1;
    }
}
