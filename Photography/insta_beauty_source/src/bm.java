// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.support.v7.widget.ListPopupWindow;
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

public class bm
    implements android.view.View.OnKeyListener, android.view.ViewTreeObserver.OnGlobalLayoutListener, android.widget.AdapterView.OnItemClickListener, android.widget.PopupWindow.OnDismissListener, bo
{

    static final int a;
    boolean b;
    private final Context c;
    private final LayoutInflater d;
    private final MenuBuilder e;
    private final bn f;
    private final boolean g;
    private final int h;
    private final int i;
    private final int j;
    private View k;
    private ListPopupWindow l;
    private ViewTreeObserver m;
    private bp n;
    private ViewGroup o;
    private boolean p;
    private int q;
    private int r;

    public bm(Context context, MenuBuilder menubuilder, View view)
    {
        this(context, menubuilder, view, false, r.popupMenuStyle);
    }

    public bm(Context context, MenuBuilder menubuilder, View view, boolean flag, int i1)
    {
        this(context, menubuilder, view, flag, i1, 0);
    }

    public bm(Context context, MenuBuilder menubuilder, View view, boolean flag, int i1, int j1)
    {
        r = 0;
        c = context;
        d = LayoutInflater.from(context);
        e = menubuilder;
        f = new bn(this, e);
        g = flag;
        i = i1;
        j = j1;
        Resources resources = context.getResources();
        h = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(u.abc_config_prefDialogWidth));
        k = view;
        menubuilder.a(this, context);
    }

    static boolean a(bm bm1)
    {
        return bm1.g;
    }

    static LayoutInflater b(bm bm1)
    {
        return bm1.d;
    }

    static MenuBuilder c(bm bm1)
    {
        return bm1.e;
    }

    private int g()
    {
        bn bn1 = f;
        int i2 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        int j2 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        int k2 = bn1.getCount();
        int j1 = 0;
        int k1 = 0;
        View view = null;
        int i1 = 0;
        do
        {
            int l1;
label0:
            {
                l1 = i1;
                if (j1 < k2)
                {
                    l1 = bn1.getItemViewType(j1);
                    if (l1 != k1)
                    {
                        k1 = l1;
                        view = null;
                    }
                    if (o == null)
                    {
                        o = new FrameLayout(c);
                    }
                    view = bn1.getView(j1, view, o);
                    view.measure(i2, j2);
                    l1 = view.getMeasuredWidth();
                    if (l1 < h)
                    {
                        break label0;
                    }
                    l1 = h;
                }
                return l1;
            }
            if (l1 > i1)
            {
                i1 = l1;
            }
            j1++;
        } while (true);
    }

    public void a()
    {
        if (!d())
        {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        } else
        {
            return;
        }
    }

    public void a(int i1)
    {
        r = i1;
    }

    public void a(Context context, MenuBuilder menubuilder)
    {
    }

    public void a(MenuBuilder menubuilder, boolean flag)
    {
        if (menubuilder == e)
        {
            e();
            if (n != null)
            {
                n.a(menubuilder, flag);
                return;
            }
        }
    }

    public void a(View view)
    {
        k = view;
    }

    public void a(bp bp1)
    {
        n = bp1;
    }

    public void a(boolean flag)
    {
        p = false;
        if (f != null)
        {
            f.notifyDataSetChanged();
        }
    }

    public boolean a(MenuBuilder menubuilder, MenuItemImpl menuitemimpl)
    {
        return false;
    }

    public boolean a(SubMenuBuilder submenubuilder)
    {
        if (!submenubuilder.hasVisibleItems()) goto _L2; else goto _L1
_L1:
        bm bm1;
        int i1;
        int j1;
        bm1 = new bm(c, submenubuilder, k);
        bm1.a(n);
        j1 = submenubuilder.size();
        i1 = 0;
_L5:
        MenuItem menuitem;
        if (i1 >= j1)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        menuitem = submenubuilder.getItem(i1);
        if (!menuitem.isVisible() || menuitem.getIcon() == null) goto _L4; else goto _L3
_L3:
        boolean flag = true;
_L6:
        bm1.b(flag);
        if (bm1.d())
        {
            if (n != null)
            {
                n.a(submenubuilder);
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

    public void b(boolean flag)
    {
        b = flag;
    }

    public boolean b()
    {
        return false;
    }

    public boolean b(MenuBuilder menubuilder, MenuItemImpl menuitemimpl)
    {
        return false;
    }

    public ListPopupWindow c()
    {
        return l;
    }

    public boolean d()
    {
        boolean flag = false;
        l = new ListPopupWindow(c, null, i, j);
        l.a(this);
        l.a(this);
        l.a(f);
        l.a(true);
        View view = k;
        if (view != null)
        {
            if (m == null)
            {
                flag = true;
            }
            m = view.getViewTreeObserver();
            if (flag)
            {
                m.addOnGlobalLayoutListener(this);
            }
            l.a(view);
            l.b(r);
            if (!p)
            {
                q = g();
                p = true;
            }
            l.d(q);
            l.e(2);
            l.c();
            l.g().setOnKeyListener(this);
            return true;
        } else
        {
            return false;
        }
    }

    public void e()
    {
        if (f())
        {
            l.a();
        }
    }

    public boolean f()
    {
        return l != null && l.b();
    }

    public void onDismiss()
    {
        l = null;
        e.close();
        if (m != null)
        {
            if (!m.isAlive())
            {
                m = k.getViewTreeObserver();
            }
            m.removeGlobalOnLayoutListener(this);
            m = null;
        }
    }

    public void onGlobalLayout()
    {
        if (f())
        {
            View view = k;
            if (view == null || !view.isShown())
            {
                e();
            } else
            if (f())
            {
                l.c();
                return;
            }
        }
    }

    public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
    {
        adapterview = f;
        bn.a(adapterview).a(adapterview.a(i1), 0);
    }

    public boolean onKey(View view, int i1, KeyEvent keyevent)
    {
        if (keyevent.getAction() == 1 && i1 == 82)
        {
            e();
            return true;
        } else
        {
            return false;
        }
    }

    static 
    {
        a = y.abc_popup_menu_item_layout;
    }
}
