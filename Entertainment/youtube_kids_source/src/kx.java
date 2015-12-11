// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

public final class kx
{

    private static Method g;
    public PopupWindow a;
    public la b;
    public int c;
    int d;
    public View e;
    public android.widget.AdapterView.OnItemClickListener f;
    private Context h;
    private ListAdapter i;
    private int j;
    private int k;
    private int l;
    private int m;
    private boolean n;
    private boolean o;
    private boolean p;
    private int q;
    private DataSetObserver r;
    private final li s = new li(this);
    private final lh t = new lh(this);
    private final lg u = new lg(this);
    private final le v = new le(this);
    private Handler w;
    private Rect x;
    private boolean y;

    public kx(Context context, AttributeSet attributeset, int i1, int j1)
    {
        j = -2;
        k = -2;
        c = 0;
        o = false;
        p = false;
        d = 0x7fffffff;
        q = 0;
        w = new Handler();
        x = new Rect();
        h = context;
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, gl.i, i1, j1);
        l = typedarray.getDimensionPixelOffset(0, 0);
        m = typedarray.getDimensionPixelOffset(1, 0);
        if (m != 0)
        {
            n = true;
        }
        typedarray.recycle();
        a = new hq(context, attributeset, i1);
        a.setInputMethodMode(1);
        cy.a(h.getResources().getConfiguration().locale);
    }

    static la a(kx kx1)
    {
        return kx1.b;
    }

    static PopupWindow b(kx kx1)
    {
        return kx1.a;
    }

    static li c(kx kx1)
    {
        return kx1.s;
    }

    static Handler d(kx kx1)
    {
        return kx1.w;
    }

    public final void a()
    {
        int i1;
        int j1;
        int k1;
        int l1;
        int l2;
        if (b == null)
        {
            Object obj = h;
            new ky(this);
            boolean flag;
            if (!y)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            b = new la(((Context) (obj)), flag);
            b.setAdapter(i);
            b.setOnItemClickListener(f);
            b.setFocusable(true);
            b.setFocusableInTouchMode(true);
            b.setOnItemSelectedListener(new kz(this));
            b.setOnScrollListener(u);
            obj = b;
            a.setContentView(((View) (obj)));
        } else
        {
            a.getContentView();
        }
        l1 = 0;
        obj = a.getBackground();
        if (obj != null)
        {
            ((Drawable) (obj)).getPadding(x);
            i1 = x.top + x.bottom;
            l1 = i1;
            if (!n)
            {
                m = -x.top;
                l1 = i1;
            }
        } else
        {
            x.setEmpty();
        }
        a.getInputMethodMode();
        l2 = a.getMaxAvailableHeight(e, m);
        if (j != -1) goto _L2; else goto _L1
_L1:
        i1 = l1 + l2;
_L16:
        j1 = 0;
        flag = d();
        if (!a.isShowing()) goto _L4; else goto _L3
_L3:
        int k2;
        if (k == -1)
        {
            j1 = -1;
        } else
        if (k == -2)
        {
            j1 = e.getWidth();
        } else
        {
            j1 = k;
        }
        if (j == -1)
        {
            if (!flag)
            {
                i1 = -1;
            }
            if (flag)
            {
                obj = a;
                Object obj1;
                la la1;
                ListAdapter listadapter;
                android.view.ViewGroup.LayoutParams layoutparams;
                int i2;
                int j2;
                int i3;
                if (k == -1)
                {
                    k1 = -1;
                } else
                {
                    k1 = 0;
                }
                ((PopupWindow) (obj)).setWindowLayoutMode(k1, 0);
            } else
            {
                PopupWindow popupwindow = a;
                if (k == -1)
                {
                    k1 = -1;
                } else
                {
                    k1 = 0;
                }
                popupwindow.setWindowLayoutMode(k1, -1);
            }
        } else
        if (j != -2)
        {
            i1 = j;
        }
        a.setOutsideTouchable(true);
        a.update(e, l, m, j1, i1);
_L14:
        return;
_L2:
        k;
        JVM INSTR tableswitch -2 -1: default 388
    //                   -2 475
    //                   -1 515;
           goto _L5 _L6 _L7
_L5:
        j1 = android.view.View.MeasureSpec.makeMeasureSpec(k, 0x40000000);
_L10:
        la1 = b;
        i1 = la1.getListPaddingTop();
        k1 = la1.getListPaddingBottom();
        la1.getListPaddingLeft();
        la1.getListPaddingRight();
        i2 = la1.getDividerHeight();
        obj1 = la1.getDivider();
        listadapter = la1.getAdapter();
        if (listadapter != null) goto _L9; else goto _L8
_L8:
        k1 += i1;
_L11:
        Exception exception;
        if (k1 > 0)
        {
            i1 = l1 + 0;
        } else
        {
            i1 = 0;
        }
        i1 += k1;
        continue; /* Loop/switch isn't completed */
_L6:
        j1 = android.view.View.MeasureSpec.makeMeasureSpec(h.getResources().getDisplayMetrics().widthPixels - (x.left + x.right), 0x80000000);
          goto _L10
_L7:
        j1 = android.view.View.MeasureSpec.makeMeasureSpec(h.getResources().getDisplayMetrics().widthPixels - (x.left + x.right), 0x40000000);
          goto _L10
_L9:
        i1 = k1 + i1;
        if (i2 <= 0 || obj1 == null)
        {
            i2 = 0;
        }
        obj1 = null;
        k2 = 0;
        i3 = listadapter.getCount();
        j2 = 0;
_L12:
        k1 = i1;
        if (j2 < i3)
        {
label0:
            {
                k1 = listadapter.getItemViewType(j2);
                if (k1 != k2)
                {
                    obj1 = null;
                } else
                {
                    k1 = k2;
                }
                obj1 = listadapter.getView(j2, ((View) (obj1)), la1);
                layoutparams = ((View) (obj1)).getLayoutParams();
                if (layoutparams != null && layoutparams.height > 0)
                {
                    k2 = android.view.View.MeasureSpec.makeMeasureSpec(layoutparams.height, 0x40000000);
                } else
                {
                    k2 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
                }
                ((View) (obj1)).measure(j1, k2);
                if (j2 > 0)
                {
                    i1 += i2;
                }
                i1 = ((View) (obj1)).getMeasuredHeight() + i1;
                if (i1 < l2)
                {
                    break label0;
                }
                k1 = l2;
            }
        }
          goto _L11
        j2++;
        k2 = k1;
          goto _L12
_L4:
        if (k == -1)
        {
            j1 = -1;
        } else
        if (k == -2)
        {
            a.setWidth(e.getWidth());
        } else
        {
            a.setWidth(k);
        }
        if (j == -1)
        {
            i1 = -1;
        } else
        if (j == -2)
        {
            a.setHeight(i1);
            i1 = 0;
        } else
        {
            a.setHeight(j);
            i1 = 0;
        }
        a.setWindowLayoutMode(j1, i1);
        if (g != null)
        {
            try
            {
                g.invoke(a, new Object[] {
                    Boolean.valueOf(true)
                });
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        }
        a.setOutsideTouchable(true);
        a.setTouchInterceptor(t);
        fo.a(a, e, l, m, c);
        b.setSelection(-1);
        if (!y || b.isInTouchMode())
        {
            c();
        }
        if (y) goto _L14; else goto _L13
_L13:
        w.post(v);
        return;
        if (true) goto _L16; else goto _L15
_L15:
    }

    public final void a(int i1)
    {
        Drawable drawable = a.getBackground();
        if (drawable != null)
        {
            drawable.getPadding(x);
            k = x.left + x.right + i1;
            return;
        } else
        {
            k = i1;
            return;
        }
    }

    public final void a(ListAdapter listadapter)
    {
        if (r != null) goto _L2; else goto _L1
_L1:
        r = new lf(this);
_L4:
        i = listadapter;
        if (i != null)
        {
            listadapter.registerDataSetObserver(r);
        }
        if (b != null)
        {
            b.setAdapter(i);
        }
        return;
_L2:
        if (i != null)
        {
            i.unregisterDataSetObserver(r);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(android.widget.PopupWindow.OnDismissListener ondismisslistener)
    {
        a.setOnDismissListener(ondismisslistener);
    }

    public final void a(boolean flag)
    {
        y = true;
        a.setFocusable(true);
    }

    public final void b()
    {
        a.dismiss();
        a.setContentView(null);
        b = null;
        w.removeCallbacks(s);
    }

    public final void c()
    {
        la la1 = b;
        if (la1 != null)
        {
            la.a(la1, true);
            la1.requestLayout();
        }
    }

    public final boolean d()
    {
        return a.getInputMethodMode() == 2;
    }

    static 
    {
        try
        {
            g = android/widget/PopupWindow.getDeclaredMethod("setClipToScreenEnabled", new Class[] {
                Boolean.TYPE
            });
        }
        catch (NoSuchMethodException nosuchmethodexception) { }
    }
}
