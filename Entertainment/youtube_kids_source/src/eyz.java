// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import java.util.LinkedList;
import java.util.Queue;

public class eyz extends AdapterView
{

    private int a;
    private int b;
    public ListAdapter c;
    public int d;
    public int e;
    public Scroller f;
    private int g;
    private int h;
    private float i;
    private GestureDetector j;
    private Queue k;
    private android.widget.AdapterView.OnItemSelectedListener l;
    private android.widget.AdapterView.OnItemClickListener m;
    private android.widget.AdapterView.OnItemLongClickListener n;
    private boolean o;
    private DataSetObserver p;
    private android.view.GestureDetector.OnGestureListener q;

    public eyz(Context context)
    {
        super(context);
        a = -1;
        b = 0;
        g = 0x7fffffff;
        h = 0;
        i = -1F;
        k = new LinkedList();
        o = false;
        p = new eza(this);
        q = new ezc(this);
        a();
    }

    public eyz(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = -1;
        b = 0;
        g = 0x7fffffff;
        h = 0;
        i = -1F;
        k = new LinkedList();
        o = false;
        p = new eza(this);
        q = new ezc(this);
        a();
    }

    private void a()
    {
        this;
        JVM INSTR monitorenter ;
        a = -1;
        b = 0;
        h = 0;
        d = 0;
        e = 0;
        g = 0x7fffffff;
        f = new Scroller(getContext());
        j = new GestureDetector(getContext(), q);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void a(View view, int i1)
    {
        android.view.ViewGroup.LayoutParams layoutparams1 = view.getLayoutParams();
        android.view.ViewGroup.LayoutParams layoutparams = layoutparams1;
        if (layoutparams1 == null)
        {
            layoutparams = new android.view.ViewGroup.LayoutParams(-1, -1);
        }
        addViewInLayout(view, i1, layoutparams, true);
        int j1;
        if (layoutparams.width > 0)
        {
            i1 = android.view.View.MeasureSpec.makeMeasureSpec(layoutparams.width, 0x40000000);
        } else
        {
            i1 = android.view.View.MeasureSpec.makeMeasureSpec(getWidth(), 0x80000000);
        }
        if (layoutparams.height > 0)
        {
            j1 = android.view.View.MeasureSpec.makeMeasureSpec(layoutparams.height, 0x40000000);
        } else
        {
            j1 = android.view.View.MeasureSpec.makeMeasureSpec(getHeight(), 0x80000000);
        }
        view.measure(i1, j1);
    }

    static void a(eyz eyz1)
    {
        eyz1.b();
    }

    static boolean a(eyz eyz1, boolean flag)
    {
        eyz1.o = true;
        return true;
    }

    static android.widget.AdapterView.OnItemClickListener b(eyz eyz1)
    {
        return eyz1.m;
    }

    private void b()
    {
        this;
        JVM INSTR monitorenter ;
        a();
        removeAllViewsInLayout();
        requestLayout();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static int c(eyz eyz1)
    {
        return eyz1.a;
    }

    static android.widget.AdapterView.OnItemSelectedListener d(eyz eyz1)
    {
        return eyz1.l;
    }

    static android.widget.AdapterView.OnItemLongClickListener e(eyz eyz1)
    {
        return eyz1.n;
    }

    public void a(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        f.startScroll(e, 0, i1 - e, 0);
        requestLayout();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(ListAdapter listadapter)
    {
        if (c != null)
        {
            c.unregisterDataSetObserver(p);
        }
        c = listadapter;
        c.registerDataSetObserver(p);
        b();
    }

    protected final boolean a(float f1)
    {
        this;
        JVM INSTR monitorenter ;
        Scroller scroller;
        int i1;
        scroller = f;
        i1 = e;
        if (i != -1F)
        {
            break MISSING_BLOCK_LABEL_49;
        }
_L1:
        scroller.fling(i1, 0, (int)(-f1), 0, 0, g, 0, 0);
        this;
        JVM INSTR monitorexit ;
        requestLayout();
        return true;
        float f2 = Math.abs(f1);
        f1 *= Math.min(f2, i) / f2;
          goto _L1
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        return super.dispatchTouchEvent(motionevent) | j.onTouchEvent(motionevent);
    }

    public Adapter getAdapter()
    {
        return c;
    }

    public View getSelectedView()
    {
        return null;
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        super.onLayout(flag, i1, j1, k1, l1);
        obj = c;
        if (obj != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (o)
        {
            i1 = d;
            a();
            removeAllViewsInLayout();
            e = i1;
            o = false;
        }
        if (f.computeScrollOffset())
        {
            e = f.getCurrX();
        }
        if (e < 0 || e == 0 && f.getStartX() != 0)
        {
            e = 0;
            f.forceFinished(true);
        }
        if (e > g || e == g && f.getStartX() != g)
        {
            e = g;
            f.forceFinished(true);
        }
        j1 = d - e;
        obj = getChildAt(0);
_L3:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_251;
        }
        if (((View) (obj)).getRight() + j1 > 0)
        {
            break MISSING_BLOCK_LABEL_251;
        }
        h = h + ((View) (obj)).getMeasuredWidth();
        k.offer(obj);
        removeViewInLayout(((View) (obj)));
        a = a + 1;
        obj = getChildAt(0);
          goto _L3
_L5:
        obj = getChildAt(getChildCount() - 1);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_320;
        }
        if (((View) (obj)).getLeft() + j1 < getWidth())
        {
            break MISSING_BLOCK_LABEL_320;
        }
        k.offer(obj);
        removeViewInLayout(((View) (obj)));
        b = b - 1;
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
        i1 = h;
        exception = getChildAt(getChildCount() - 1);
        if (exception == null)
        {
            break MISSING_BLOCK_LABEL_351;
        }
        i1 = exception.getRight();
        while (i1 + j1 < getWidth() && b < c.getCount()) 
        {
            exception = c.getView(b, (View)k.poll(), this);
            a(exception, -1);
            i1 = exception.getMeasuredWidth() + i1;
            if (b == c.getCount() - 1)
            {
                g = (d + i1) - getWidth();
            }
            if (g < 0)
            {
                g = 0;
            }
            b = b + 1;
        }
        i1 = h;
        exception = getChildAt(0);
        if (exception == null)
        {
            break MISSING_BLOCK_LABEL_504;
        }
        i1 = exception.getLeft();
_L7:
        if (i1 + j1 <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (a < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        View view = c.getView(a, (View)k.poll(), this);
        a(view, 0);
        k1 = view.getMeasuredWidth();
        a = a - 1;
        h = h - view.getMeasuredWidth();
        i1 -= k1;
        if (true) goto _L7; else goto _L6
_L6:
        if (getChildCount() <= 0) goto _L9; else goto _L8
_L8:
        h = h + j1;
        j1 = h;
        i1 = 0;
_L10:
        if (i1 >= getChildCount())
        {
            break; /* Loop/switch isn't completed */
        }
        View view1 = getChildAt(i1);
        k1 = view1.getMeasuredWidth();
        view1.layout(j1, 0, j1 + k1, view1.getMeasuredHeight());
        j1 += view1.getPaddingRight() + k1;
        i1++;
        if (true) goto _L10; else goto _L9
_L9:
        d = e;
        if (!f.isFinished())
        {
            post(new ezb(this));
        }
          goto _L1
    }

    public void setAdapter(Adapter adapter)
    {
        a((ListAdapter)adapter);
    }

    public void setOnItemClickListener(android.widget.AdapterView.OnItemClickListener onitemclicklistener)
    {
        m = onitemclicklistener;
    }

    public void setOnItemLongClickListener(android.widget.AdapterView.OnItemLongClickListener onitemlongclicklistener)
    {
        n = onitemlongclicklistener;
    }

    public void setOnItemSelectedListener(android.widget.AdapterView.OnItemSelectedListener onitemselectedlistener)
    {
        l = onitemselectedlistener;
    }

    public void setSelection(int i1)
    {
    }
}
