// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.widget.v;
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
import java.util.ArrayList;

// Referenced classes of package android.support.v7.internal.view.menu:
//            l, f, p, h, 
//            ListMenuItemView

public class k
    implements l, android.view.View.OnKeyListener, android.view.ViewTreeObserver.OnGlobalLayoutListener, android.widget.AdapterView.OnItemClickListener, android.widget.PopupWindow.OnDismissListener
{
    private class a extends BaseAdapter
    {

        final k a;
        private f b;
        private int c;

        static f a(a a1)
        {
            return a1.b;
        }

        public h a(int i1)
        {
            ArrayList arraylist;
            int j1;
            if (k.a(a))
            {
                arraylist = b.l();
            } else
            {
                arraylist = b.i();
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

        void a()
        {
            h h1 = k.c(a).r();
            if (h1 != null)
            {
                ArrayList arraylist = k.c(a).l();
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

        public int getCount()
        {
            ArrayList arraylist;
            if (k.a(a))
            {
                arraylist = b.l();
            } else
            {
                arraylist = b.i();
            }
            if (c < 0)
            {
                return arraylist.size();
            } else
            {
                return arraylist.size() - 1;
            }
        }

        public Object getItem(int i1)
        {
            return a(i1);
        }

        public long getItemId(int i1)
        {
            return (long)i1;
        }

        public View getView(int i1, View view, ViewGroup viewgroup)
        {
            if (view == null)
            {
                view = k.b(a).inflate(k.a, viewgroup, false);
            }
            viewgroup = (m.a)view;
            if (a.b)
            {
                ((ListMenuItemView)view).setForceShowIcon(true);
            }
            viewgroup.a(a(i1), 0);
            return view;
        }

        public void notifyDataSetChanged()
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
    boolean b;
    private final Context c;
    private final LayoutInflater d;
    private final f e;
    private final a f;
    private final boolean g;
    private final int h;
    private final int i;
    private final int j;
    private View k;
    private v l;
    private ViewTreeObserver m;
    private l.a n;
    private ViewGroup o;
    private boolean p;
    private int q;
    private int r;

    public k(Context context, f f1, View view)
    {
        this(context, f1, view, false, android.support.v7.a.a.a.popupMenuStyle);
    }

    public k(Context context, f f1, View view, boolean flag, int i1)
    {
        this(context, f1, view, flag, i1, 0);
    }

    public k(Context context, f f1, View view, boolean flag, int i1, int j1)
    {
        r = 0;
        c = context;
        d = LayoutInflater.from(context);
        e = f1;
        f = new a(e);
        g = flag;
        i = i1;
        j = j1;
        Resources resources = context.getResources();
        h = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(android.support.v7.a.a.d.abc_config_prefDialogWidth));
        k = view;
        f1.a(this, context);
    }

    static boolean a(k k1)
    {
        return k1.g;
    }

    static LayoutInflater b(k k1)
    {
        return k1.d;
    }

    static f c(k k1)
    {
        return k1.e;
    }

    private int i()
    {
        a a1 = f;
        int i2 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        int j2 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        int k2 = a1.getCount();
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
                    l1 = a1.getItemViewType(j1);
                    if (l1 != k1)
                    {
                        k1 = l1;
                        view = null;
                    }
                    if (o == null)
                    {
                        o = new FrameLayout(c);
                    }
                    view = a1.getView(j1, view, o);
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

    public void a(int i1)
    {
        r = i1;
    }

    public void a(Context context, f f1)
    {
    }

    public void a(Parcelable parcelable)
    {
    }

    public void a(f f1, boolean flag)
    {
        if (f1 == e)
        {
            g();
            if (n != null)
            {
                n.a(f1, flag);
                return;
            }
        }
    }

    public void a(l.a a1)
    {
        n = a1;
    }

    public void a(View view)
    {
        k = view;
    }

    public void a(boolean flag)
    {
        p = false;
        if (f != null)
        {
            f.notifyDataSetChanged();
        }
    }

    public boolean a()
    {
        return false;
    }

    public boolean a(f f1, h h1)
    {
        return false;
    }

    public boolean a(p p1)
    {
        if (!p1.hasVisibleItems()) goto _L2; else goto _L1
_L1:
        k k1;
        int i1;
        int j1;
        k1 = new k(c, p1, k);
        k1.a(n);
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
        k1.b(flag);
        if (k1.f())
        {
            if (n != null)
            {
                n.a_(p1);
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

    public int b()
    {
        return 0;
    }

    public void b(boolean flag)
    {
        b = flag;
    }

    public boolean b(f f1, h h1)
    {
        return false;
    }

    public Parcelable c()
    {
        return null;
    }

    public void d()
    {
        if (!f())
        {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        } else
        {
            return;
        }
    }

    public v e()
    {
        return l;
    }

    public boolean f()
    {
        boolean flag = false;
        l = new v(c, null, i, j);
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
                q = i();
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

    public void g()
    {
        if (h())
        {
            l.a();
        }
    }

    public boolean h()
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
        if (h())
        {
            View view = k;
            if (view == null || !view.isShown())
            {
                g();
            } else
            if (h())
            {
                l.c();
                return;
            }
        }
    }

    public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
    {
        adapterview = f;
        a.a(adapterview).a(adapterview.a(i1), 0);
    }

    public boolean onKey(View view, int i1, KeyEvent keyevent)
    {
        if (keyevent.getAction() == 1 && i1 == 82)
        {
            g();
            return true;
        } else
        {
            return false;
        }
    }

    static 
    {
        a = android.support.v7.a.a.h.abc_popup_menu_item_layout;
    }
}
