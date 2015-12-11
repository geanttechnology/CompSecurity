// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.s;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.internal.view.menu:
//            l, f, p, h, 
//            ListMenuItemView

public class k
    implements l, android.view.View.OnKeyListener, android.view.ViewTreeObserver.OnGlobalLayoutListener, android.widget.AdapterView.OnItemClickListener, android.widget.PopupWindow.OnDismissListener
{
    private final class a extends BaseAdapter
    {

        final k a;
        private f b;
        private int c;

        static f a(a a1)
        {
            return a1.b;
        }

        private void a()
        {
            h h1 = k.c(a).j;
            if (h1 != null)
            {
                ArrayList arraylist = k.c(a).j();
                int j1 = arraylist.size();
                for (int i1 = 0; i1 < j1; i1++)
                {
                    if ((h)arraylist.get(i1) == h1)
                    {
                        c = i1;
                        return;
                    }
                }

            }
            c = -1;
        }

        public final h a(int i1)
        {
            ArrayList arraylist;
            int j1;
            if (k.a(a))
            {
                arraylist = b.j();
            } else
            {
                arraylist = b.h();
            }
            j1 = i1;
            if (c >= 0)
            {
                j1 = i1;
                if (i1 >= c)
                {
                    j1 = i1 + 1;
                }
            }
            return (h)arraylist.get(j1);
        }

        public final int getCount()
        {
            ArrayList arraylist;
            if (k.a(a))
            {
                arraylist = b.j();
            } else
            {
                arraylist = b.h();
            }
            if (c < 0)
            {
                return arraylist.size();
            } else
            {
                return arraylist.size() - 1;
            }
        }

        public final Object getItem(int i1)
        {
            return a(i1);
        }

        public final long getItemId(int i1)
        {
            return (long)i1;
        }

        public final View getView(int i1, View view, ViewGroup viewgroup)
        {
            if (view == null)
            {
                view = k.b(a).inflate(k.a, viewgroup, false);
            }
            viewgroup = (m.a)view;
            if (a.e)
            {
                ((ListMenuItemView)view).setForceShowIcon(true);
            }
            viewgroup.a(a(i1));
            return view;
        }

        public final void notifyDataSetChanged()
        {
            a();
            super.notifyDataSetChanged();
        }

        public a(f f1)
        {
            a = k.this;
            super();
            c = -1;
            b = f1;
            a();
        }
    }


    static final int a;
    public View b;
    public s c;
    public l.a d;
    public boolean e;
    public int f;
    private final Context g;
    private final LayoutInflater h;
    private final f i;
    private final a j;
    private final boolean k;
    private final int l;
    private final int m;
    private final int n;
    private ViewTreeObserver o;
    private ViewGroup p;
    private boolean q;
    private int r;

    private k(Context context, f f1, View view)
    {
        this(context, f1, view, false, android.support.v7.b.a.a.popupMenuStyle);
    }

    public k(Context context, f f1, View view, boolean flag, int i1)
    {
        this(context, f1, view, flag, i1, (byte)0);
    }

    private k(Context context, f f1, View view, boolean flag, int i1, byte byte0)
    {
        f = 0;
        g = context;
        h = LayoutInflater.from(context);
        i = f1;
        j = new a(i);
        k = flag;
        m = i1;
        n = 0;
        Resources resources = context.getResources();
        l = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(android.support.v7.b.a.d.abc_config_prefDialogWidth));
        b = view;
        f1.a(this, context);
    }

    static boolean a(k k1)
    {
        return k1.k;
    }

    static LayoutInflater b(k k1)
    {
        return k1.h;
    }

    static f c(k k1)
    {
        return k1.i;
    }

    public final void a(Context context, f f1)
    {
    }

    public final void a(f f1, boolean flag)
    {
        if (f1 == i)
        {
            c();
            if (d != null)
            {
                d.a(f1, flag);
                return;
            }
        }
    }

    public final boolean a()
    {
        return false;
    }

    public final boolean a(p p1)
    {
        if (!p1.hasVisibleItems()) goto _L2; else goto _L1
_L1:
        k k1;
        int i1;
        int j1;
        k1 = new k(g, p1, b);
        k1.d = d;
        j1 = p1.size();
        i1 = 0;
_L5:
        MenuItem menuitem;
        if (i1 >= j1)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        menuitem = p1.getItem(i1);
        if (!menuitem.isVisible() || menuitem.getIcon() == null) goto _L4; else goto _L3
_L3:
        boolean flag = true;
_L6:
        k1.e = flag;
        if (k1.b())
        {
            if (d != null)
            {
                d.a(p1);
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

    public final void b(boolean flag)
    {
        q = false;
        if (j != null)
        {
            j.notifyDataSetChanged();
        }
    }

    public final boolean b()
    {
        View view;
        int l1;
        l1 = 0;
        c = new s(g, null, m, n);
        c.a(this);
        c.h = this;
        c.a(j);
        c.d();
        view = b;
        if (view == null) goto _L2; else goto _L1
_L1:
        int i1;
        int j1;
        a a1;
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
        c.g = view;
        c.d = f;
        if (q) goto _L4; else goto _L3
_L3:
        a1 = j;
        i2 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        j2 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        k2 = a1.getCount();
        j1 = 0;
        k1 = 0;
        view = null;
        i1 = l1;
_L10:
        l1 = i1;
        if (j1 >= k2) goto _L6; else goto _L5
_L5:
        l1 = a1.getItemViewType(j1);
        if (l1 != k1)
        {
            k1 = l1;
            view = null;
        }
        if (p == null)
        {
            p = new FrameLayout(g);
        }
        view = a1.getView(j1, view, p);
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
        c.b.setInputMethodMode(2);
        c.c();
        c.c.setOnKeyListener(this);
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

    public final boolean b(h h1)
    {
        return false;
    }

    public final void c()
    {
        if (d())
        {
            c.a();
        }
    }

    public final boolean c(h h1)
    {
        return false;
    }

    public final boolean d()
    {
        return c != null && c.b.isShowing();
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
                c.c();
                return;
            }
        }
    }

    public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
    {
        adapterview = j;
        a.a(adapterview).a(adapterview.a(i1), null, 0);
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

    static 
    {
        a = android.support.v7.b.a.h.abc_popup_menu_item_layout;
    }
}
