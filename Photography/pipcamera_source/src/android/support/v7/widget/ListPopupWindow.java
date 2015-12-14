// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.text.TextUtilsCompat;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.internal.widget.AppCompatPopupWindow;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import da;
import db;
import de;
import df;
import dg;
import dh;
import di;
import java.lang.reflect.Method;

public class ListPopupWindow
{

    private static Method a;
    private Handler A;
    private Rect B;
    private boolean C;
    private int D;
    public int b;
    private Context c;
    private PopupWindow d;
    private ListAdapter e;
    private da f;
    private int g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private int l;
    private boolean m;
    private boolean n;
    private View o;
    private int p;
    private DataSetObserver q;
    private View r;
    private Drawable s;
    private android.widget.AdapterView.OnItemClickListener t;
    private android.widget.AdapterView.OnItemSelectedListener u;
    private final di v;
    private final dh w;
    private final dg x;
    private final de y;
    private Runnable z;

    public ListPopupWindow(Context context)
    {
        this(context, null, android.support.v7.appcompat.R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, android.support.v7.appcompat.R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeset, int i1)
    {
        this(context, attributeset, i1, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeset, int i1, int j1)
    {
        g = -2;
        h = -2;
        l = 0;
        m = false;
        n = false;
        b = 0x7fffffff;
        p = 0;
        v = new di(this);
        w = new dh(this);
        x = new dg(this);
        y = new de(this);
        A = new Handler();
        B = new Rect();
        c = context;
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, android.support.v7.appcompat.R.styleable.ListPopupWindow, i1, j1);
        i = typedarray.getDimensionPixelOffset(android.support.v7.appcompat.R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        j = typedarray.getDimensionPixelOffset(android.support.v7.appcompat.R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (j != 0)
        {
            k = true;
        }
        typedarray.recycle();
        d = new AppCompatPopupWindow(context, attributeset, i1);
        d.setInputMethodMode(1);
        D = TextUtilsCompat.getLayoutDirectionFromLocale(c.getResources().getConfiguration().locale);
    }

    public static da a(ListPopupWindow listpopupwindow)
    {
        return listpopupwindow.f;
    }

    public static PopupWindow b(ListPopupWindow listpopupwindow)
    {
        return listpopupwindow.d;
    }

    private void b(boolean flag)
    {
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        a.invoke(d, new Object[] {
            Boolean.valueOf(flag)
        });
        return;
        Exception exception;
        exception;
        Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
        return;
    }

    public static di c(ListPopupWindow listpopupwindow)
    {
        return listpopupwindow.v;
    }

    public static Handler d(ListPopupWindow listpopupwindow)
    {
        return listpopupwindow.A;
    }

    private void h()
    {
        if (o != null)
        {
            android.view.ViewParent viewparent = o.getParent();
            if (viewparent instanceof ViewGroup)
            {
                ((ViewGroup)viewparent).removeView(o);
            }
        }
    }

    private int i()
    {
        if (f != null) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        View view;
        android.widget.LinearLayout.LayoutParams layoutparams;
        int i1;
        int j1;
        int l1;
        obj1 = c;
        z = new Runnable() {

            final ListPopupWindow a;

            public void run()
            {
                View view1 = a.d();
                if (view1 != null && view1.getWindowToken() != null)
                {
                    a.c();
                }
            }

            
            {
                a = ListPopupWindow.this;
                super();
            }
        };
        boolean flag;
        if (!C)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f = new da(((Context) (obj1)), flag);
        if (s != null)
        {
            f.setSelector(s);
        }
        f.setAdapter(e);
        f.setOnItemClickListener(t);
        f.setFocusable(true);
        f.setFocusableInTouchMode(true);
        f.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {

            final ListPopupWindow a;

            public void onItemSelected(AdapterView adapterview, View view1, int i2, long l2)
            {
                if (i2 != -1)
                {
                    adapterview = ListPopupWindow.a(a);
                    if (adapterview != null)
                    {
                        da.a(adapterview, false);
                    }
                }
            }

            public void onNothingSelected(AdapterView adapterview)
            {
            }

            
            {
                a = ListPopupWindow.this;
                super();
            }
        });
        f.setOnScrollListener(x);
        if (u != null)
        {
            f.setOnItemSelectedListener(u);
        }
        obj = f;
        view = o;
        if (view == null) goto _L4; else goto _L3
_L3:
        obj1 = new LinearLayout(((Context) (obj1)));
        ((LinearLayout) (obj1)).setOrientation(1);
        layoutparams = new android.widget.LinearLayout.LayoutParams(-1, 0, 1.0F);
        p;
        JVM INSTR tableswitch 0 1: default 216
    //                   0 429
    //                   1 414;
           goto _L5 _L6 _L7
_L5:
        Log.e("ListPopupWindow", (new StringBuilder()).append("Invalid hint position ").append(p).toString());
_L9:
        view.measure(android.view.View.MeasureSpec.makeMeasureSpec(h, 0x80000000), 0);
        obj = (android.widget.LinearLayout.LayoutParams)view.getLayoutParams();
        i1 = view.getMeasuredHeight();
        j1 = ((android.widget.LinearLayout.LayoutParams) (obj)).topMargin;
        i1 = ((android.widget.LinearLayout.LayoutParams) (obj)).bottomMargin + (i1 + j1);
        obj = obj1;
_L15:
        d.setContentView(((View) (obj)));
_L10:
        obj = d.getBackground();
        if (obj != null)
        {
            ((Drawable) (obj)).getPadding(B);
            j1 = B.top + B.bottom;
            if (!k)
            {
                j = -B.top;
            }
        } else
        {
            B.setEmpty();
            j1 = 0;
        }
        if (d.getInputMethodMode() != 2);
        l1 = d.getMaxAvailableHeight(d(), j);
        if (m || g == -1)
        {
            return l1 + j1;
        }
          goto _L8
_L7:
        ((LinearLayout) (obj1)).addView(((View) (obj)), layoutparams);
        ((LinearLayout) (obj1)).addView(view);
          goto _L9
_L6:
        ((LinearLayout) (obj1)).addView(view);
        ((LinearLayout) (obj1)).addView(((View) (obj)), layoutparams);
          goto _L9
_L2:
        obj = (ViewGroup)d.getContentView();
        obj = o;
        int k1;
        if (obj != null)
        {
            obj1 = (android.widget.LinearLayout.LayoutParams)((View) (obj)).getLayoutParams();
            i1 = ((View) (obj)).getMeasuredHeight();
            j1 = ((android.widget.LinearLayout.LayoutParams) (obj1)).topMargin;
            i1 = ((android.widget.LinearLayout.LayoutParams) (obj1)).bottomMargin + (i1 + j1);
        } else
        {
            i1 = 0;
        }
          goto _L10
_L8:
        h;
        JVM INSTR tableswitch -2 -1: default 540
    //                   -2 593
    //                   -1 633;
           goto _L11 _L12 _L13
_L11:
        k1 = android.view.View.MeasureSpec.makeMeasureSpec(h, 0x40000000);
_L14:
        l1 = f.measureHeightOfChildrenCompat(k1, 0, -1, l1 - i1, -1);
        k1 = i1;
        if (l1 > 0)
        {
            k1 = i1 + j1;
        }
        return l1 + k1;
_L12:
        k1 = android.view.View.MeasureSpec.makeMeasureSpec(c.getResources().getDisplayMetrics().widthPixels - (B.left + B.right), 0x80000000);
        continue; /* Loop/switch isn't completed */
_L13:
        k1 = android.view.View.MeasureSpec.makeMeasureSpec(c.getResources().getDisplayMetrics().widthPixels - (B.left + B.right), 0x40000000);
        if (true) goto _L14; else goto _L4
_L4:
        i1 = 0;
          goto _L15
    }

    public void a()
    {
        d.dismiss();
        h();
        d.setContentView(null);
        f = null;
        A.removeCallbacks(v);
    }

    public void a(int i1)
    {
        p = i1;
    }

    public void a(Drawable drawable)
    {
        d.setBackgroundDrawable(drawable);
    }

    public void a(View view)
    {
        r = view;
    }

    public void a(android.widget.AdapterView.OnItemClickListener onitemclicklistener)
    {
        t = onitemclicklistener;
    }

    public void a(ListAdapter listadapter)
    {
        if (q != null) goto _L2; else goto _L1
_L1:
        q = new df(this);
_L4:
        e = listadapter;
        if (e != null)
        {
            listadapter.registerDataSetObserver(q);
        }
        if (f != null)
        {
            f.setAdapter(e);
        }
        return;
_L2:
        if (e != null)
        {
            e.unregisterDataSetObserver(q);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(android.widget.PopupWindow.OnDismissListener ondismisslistener)
    {
        d.setOnDismissListener(ondismisslistener);
    }

    public void a(boolean flag)
    {
        C = flag;
        d.setFocusable(flag);
    }

    public void b(int i1)
    {
        l = i1;
    }

    public boolean b()
    {
        return d.isShowing();
    }

    public void c()
    {
        int j1;
        byte byte1;
        boolean flag;
        boolean flag1;
        boolean flag2;
        flag = true;
        flag1 = false;
        byte1 = -1;
        j1 = i();
        flag2 = f();
        if (!d.isShowing()) goto _L2; else goto _L1
_L1:
        int i1;
        if (h == -1)
        {
            i1 = -1;
        } else
        if (h == -2)
        {
            i1 = d().getWidth();
        } else
        {
            i1 = h;
        }
        if (g != -1) goto _L4; else goto _L3
_L3:
        if (!flag2)
        {
            j1 = -1;
        }
        if (flag2)
        {
            PopupWindow popupwindow = d;
            if (h != -1)
            {
                byte1 = 0;
            }
            popupwindow.setWindowLayoutMode(byte1, 0);
        } else
        {
            PopupWindow popupwindow1 = d;
            byte byte2;
            if (h == -1)
            {
                byte2 = -1;
            } else
            {
                byte2 = 0;
            }
            popupwindow1.setWindowLayoutMode(byte2, -1);
        }
_L8:
        popupwindow = d;
        flag = flag1;
        if (!n)
        {
            flag = flag1;
            if (!m)
            {
                flag = true;
            }
        }
        popupwindow.setOutsideTouchable(flag);
        d.update(d(), i, j, i1, j1);
_L6:
        return;
_L4:
        if (g != -2)
        {
            j1 = g;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        PopupWindow popupwindow2;
        byte byte0;
        if (h == -1)
        {
            byte0 = -1;
        } else
        if (h == -2)
        {
            d.setWidth(d().getWidth());
            byte0 = 0;
        } else
        {
            d.setWidth(h);
            byte0 = 0;
        }
        if (g == -1)
        {
            j1 = -1;
        } else
        if (g == -2)
        {
            d.setHeight(j1);
            j1 = 0;
        } else
        {
            d.setHeight(g);
            j1 = 0;
        }
        d.setWindowLayoutMode(byte0, j1);
        b(true);
        popupwindow2 = d;
        if (n || m)
        {
            flag = false;
        }
        popupwindow2.setOutsideTouchable(flag);
        d.setTouchInterceptor(w);
        PopupWindowCompat.showAsDropDown(d, d(), i, j, l);
        f.setSelection(-1);
        if (!C || f.isInTouchMode())
        {
            e();
        }
        if (C) goto _L6; else goto _L5
_L5:
        A.post(y);
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void c(int i1)
    {
        h = i1;
    }

    public View d()
    {
        return r;
    }

    public void d(int i1)
    {
        Drawable drawable = d.getBackground();
        if (drawable != null)
        {
            drawable.getPadding(B);
            h = B.left + B.right + i1;
            return;
        } else
        {
            c(i1);
            return;
        }
    }

    public void e()
    {
        da da1 = f;
        if (da1 != null)
        {
            da.a(da1, true);
            da1.requestLayout();
        }
    }

    public void e(int i1)
    {
        d.setInputMethodMode(i1);
    }

    public boolean f()
    {
        return d.getInputMethodMode() == 2;
    }

    public ListView g()
    {
        return f;
    }

    static 
    {
        try
        {
            a = android/widget/PopupWindow.getDeclaredMethod("setClipToScreenEnabled", new Class[] {
                Boolean.TYPE
            });
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
    }

    // Unreferenced inner class android/support/v7/widget/ListPopupWindow$1

/* anonymous class */
    public class _cls1 extends db
    {

        final ListPopupWindow a;

        public ListPopupWindow a()
        {
            return a;
        }
    }

}
