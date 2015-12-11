// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

public class gw
    implements android.view.View.OnKeyListener, android.view.ViewTreeObserver.OnGlobalLayoutListener, android.widget.AdapterView.OnItemClickListener, android.widget.PopupWindow.OnDismissListener, gy
{

    static final int a = 0x7f04000f;
    public View b;
    public kx c;
    public gz d;
    public boolean e;
    public int f;
    private final Context g;
    private final LayoutInflater h;
    private final gt i;
    private final gx j;
    private final boolean k;
    private final int l;
    private final int m;
    private final int n;
    private ViewTreeObserver o;
    private ViewGroup p;
    private boolean q;
    private int r;

    private gw(Context context, gt gt1, View view)
    {
        this(context, gt1, view, false, 0x7f0100b6);
    }

    public gw(Context context, gt gt1, View view, boolean flag, int i1)
    {
        this(context, gt1, view, flag, i1, 0);
    }

    private gw(Context context, gt gt1, View view, boolean flag, int i1, int j1)
    {
        f = 0;
        g = context;
        h = LayoutInflater.from(context);
        i = gt1;
        j = new gx(this, i);
        k = flag;
        m = i1;
        n = 0;
        Resources resources = context.getResources();
        l = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(0x7f0a003e));
        b = view;
        gt1.f.add(new WeakReference(this));
        a(context, gt1);
        gt1.e = true;
    }

    static boolean a(gw gw1)
    {
        return gw1.k;
    }

    static LayoutInflater b(gw gw1)
    {
        return gw1.h;
    }

    static gt c(gw gw1)
    {
        return gw1.i;
    }

    public final void a(Context context, gt gt1)
    {
    }

    public final void a(gt gt1, boolean flag)
    {
        if (gt1 == i)
        {
            c();
            if (d != null)
            {
                d.a(gt1, flag);
                return;
            }
        }
    }

    public final void a(boolean flag)
    {
        q = false;
        gx gx1 = j;
        j.notifyDataSetChanged();
    }

    public final boolean a()
    {
        return false;
    }

    public final boolean a(gv gv)
    {
        return false;
    }

    public final boolean a(hb hb1)
    {
        if (!hb1.hasVisibleItems()) goto _L2; else goto _L1
_L1:
        gw gw1;
        int i1;
        int j1;
        gw1 = new gw(g, hb1, b);
        gw1.d = d;
        j1 = hb1.size();
        i1 = 0;
_L5:
        MenuItem menuitem;
        if (i1 >= j1)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        menuitem = hb1.getItem(i1);
        if (!menuitem.isVisible() || menuitem.getIcon() == null) goto _L4; else goto _L3
_L3:
        boolean flag = true;
_L6:
        gw1.e = flag;
        if (gw1.b())
        {
            if (d != null)
            {
                d.a(hb1);
            }
            return true;
        }
          goto _L2
_L4:
        i1++;
          goto _L5
_L2:
        return false;
        flag = false;
          goto _L6
    }

    public final boolean b()
    {
        View view;
        int l1;
        l1 = 0;
        c = new kx(g, null, m, n);
        c.a(this);
        c.f = this;
        c.a(j);
        c.a(true);
        view = b;
        if (view == null) goto _L2; else goto _L1
_L1:
        int i1;
        int j1;
        gx gx1;
        int k1;
        int i2;
        int j2;
        int k2;
        if (o == null)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        o = view.getViewTreeObserver();
        if (i1 != 0)
        {
            o.addOnGlobalLayoutListener(this);
        }
        c.e = view;
        c.c = f;
        if (q) goto _L4; else goto _L3
_L3:
        gx1 = j;
        i2 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        j2 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        k2 = gx1.getCount();
        j1 = 0;
        k1 = 0;
        view = null;
        i1 = l1;
_L10:
        l1 = i1;
        if (j1 >= k2) goto _L6; else goto _L5
_L5:
        l1 = gx1.getItemViewType(j1);
        if (l1 != k1)
        {
            k1 = l1;
            view = null;
        }
        if (p == null)
        {
            p = new FrameLayout(g);
        }
        view = gx1.getView(j1, view, p);
        view.measure(i2, j2);
        l1 = view.getMeasuredWidth();
        if (l1 < l) goto _L8; else goto _L7
_L7:
        l1 = l;
_L6:
        r = l1;
        q = true;
_L4:
        c.a(r);
        c.a.setInputMethodMode(2);
        c.a();
        c.b.setOnKeyListener(this);
        return true;
_L2:
        return false;
_L8:
        if (l1 > i1)
        {
            i1 = l1;
        }
        j1++;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public final boolean b(gv gv)
    {
        return false;
    }

    public final void c()
    {
        if (d())
        {
            c.b();
        }
    }

    public final boolean d()
    {
        return c != null && c.a.isShowing();
    }

    public void onDismiss()
    {
        c = null;
        i.close();
        if (o != null)
        {
            if (!o.isAlive())
            {
                o = b.getViewTreeObserver();
            }
            o.removeGlobalOnLayoutListener(this);
            o = null;
        }
    }

    public void onGlobalLayout()
    {
        if (d())
        {
            View view = b;
            if (view == null || !view.isShown())
            {
                c();
            } else
            if (d())
            {
                c.a();
                return;
            }
        }
    }

    public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
    {
        adapterview = j;
        gx.a(adapterview).a(adapterview.a(i1), 0);
    }

    public boolean onKey(View view, int i1, KeyEvent keyevent)
    {
        if (keyevent.getAction() == 1 && i1 == 82)
        {
            c();
            return true;
        } else
        {
            return false;
        }
    }

}
