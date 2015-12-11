// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ai;
import android.support.v4.view.d;
import android.support.v7.widget.u;
import android.support.v7.widget.v;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

// Referenced classes of package android.support.v7.internal.widget:
//            d, s

public class ActivityChooserView extends ViewGroup
{
    public static class InnerLayout extends u
    {

        private static final int a[] = {
            0x10100d4
        };


        public InnerLayout(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
            context = s.a(context, attributeset, a);
            setBackgroundDrawable(context.a(0));
            context.b();
        }
    }

    private class a extends BaseAdapter
    {

        final ActivityChooserView a;
        private android.support.v7.internal.widget.d b;
        private int c;
        private boolean d;
        private boolean e;
        private boolean f;

        public int a()
        {
            int i1 = 0;
            int k1 = c;
            c = 0x7fffffff;
            int l1 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
            int i2 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
            int j2 = getCount();
            View view = null;
            int j1 = 0;
            for (; i1 < j2; i1++)
            {
                view = getView(i1, view, null);
                view.measure(l1, i2);
                j1 = Math.max(j1, view.getMeasuredWidth());
            }

            c = k1;
            return j1;
        }

        public void a(int i1)
        {
            if (c != i1)
            {
                c = i1;
                notifyDataSetChanged();
            }
        }

        public void a(android.support.v7.internal.widget.d d1)
        {
            android.support.v7.internal.widget.d d2 = ActivityChooserView.a(a).d();
            if (d2 != null && a.isShown())
            {
                d2.unregisterObserver(ActivityChooserView.g(a));
            }
            b = d1;
            if (d1 != null && a.isShown())
            {
                d1.registerObserver(ActivityChooserView.g(a));
            }
            notifyDataSetChanged();
        }

        public void a(boolean flag)
        {
            if (f != flag)
            {
                f = flag;
                notifyDataSetChanged();
            }
        }

        public void a(boolean flag, boolean flag1)
        {
            if (d != flag || e != flag1)
            {
                d = flag;
                e = flag1;
                notifyDataSetChanged();
            }
        }

        public ResolveInfo b()
        {
            return b.b();
        }

        public int c()
        {
            return b.a();
        }

        public android.support.v7.internal.widget.d d()
        {
            return b;
        }

        public boolean e()
        {
            return d;
        }

        public int getCount()
        {
            int j1 = b.a();
            int i1 = j1;
            if (!d)
            {
                i1 = j1;
                if (b.b() != null)
                {
                    i1 = j1 - 1;
                }
            }
            j1 = Math.min(i1, c);
            i1 = j1;
            if (f)
            {
                i1 = j1 + 1;
            }
            return i1;
        }

        public Object getItem(int i1)
        {
            int j1;
            switch (getItemViewType(i1))
            {
            default:
                throw new IllegalArgumentException();

            case 1: // '\001'
                return null;

            case 0: // '\0'
                j1 = i1;
                break;
            }
            if (!d)
            {
                j1 = i1;
                if (b.b() != null)
                {
                    j1 = i1 + 1;
                }
            }
            return b.a(j1);
        }

        public long getItemId(int i1)
        {
            return (long)i1;
        }

        public int getItemViewType(int i1)
        {
            return !f || i1 != getCount() - 1 ? 0 : 1;
        }

        public View getView(int i1, View view, ViewGroup viewgroup)
        {
            getItemViewType(i1);
            JVM INSTR tableswitch 0 1: default 28
        //                       0 107
        //                       1 36;
               goto _L1 _L2 _L3
_L1:
            throw new IllegalArgumentException();
_L3:
            if (view == null) goto _L5; else goto _L4
_L4:
            View view1 = view;
            if (view.getId() == 1) goto _L6; else goto _L5
_L5:
            view1 = LayoutInflater.from(a.getContext()).inflate(android.support.v7.a.a.h.abc_activity_chooser_view_list_item, viewgroup, false);
            view1.setId(1);
            ((TextView)view1.findViewById(android.support.v7.a.a.f.title)).setText(a.getContext().getString(android.support.v7.a.a.i.abc_activity_chooser_view_see_all));
_L6:
            return view1;
_L2:
            if (view == null) goto _L8; else goto _L7
_L7:
            view1 = view;
            if (view.getId() == android.support.v7.a.a.f.list_item) goto _L9; else goto _L8
_L8:
            view1 = LayoutInflater.from(a.getContext()).inflate(android.support.v7.a.a.h.abc_activity_chooser_view_list_item, viewgroup, false);
_L9:
            view = a.getContext().getPackageManager();
            viewgroup = (ImageView)view1.findViewById(android.support.v7.a.a.f.icon);
            ResolveInfo resolveinfo = (ResolveInfo)getItem(i1);
            viewgroup.setImageDrawable(resolveinfo.loadIcon(view));
            ((TextView)view1.findViewById(android.support.v7.a.a.f.title)).setText(resolveinfo.loadLabel(view));
            if (d && i1 == 0 && e)
            {
                ai.b(view1, true);
                return view1;
            } else
            {
                ai.b(view1, false);
                return view1;
            }
        }

        public int getViewTypeCount()
        {
            return 3;
        }
    }

    private class b
        implements android.view.View.OnClickListener, android.view.View.OnLongClickListener, android.widget.AdapterView.OnItemClickListener, android.widget.PopupWindow.OnDismissListener
    {

        final ActivityChooserView a;

        private void a()
        {
            if (ActivityChooserView.f(a) != null)
            {
                ActivityChooserView.f(a).onDismiss();
            }
        }

        public void onClick(View view)
        {
            if (view == ActivityChooserView.c(a))
            {
                a.b();
                view = ActivityChooserView.a(a).b();
                int i1 = ActivityChooserView.a(a).d().a(view);
                view = ActivityChooserView.a(a).d().b(i1);
                if (view != null)
                {
                    view.addFlags(0x80000);
                    a.getContext().startActivity(view);
                }
                return;
            }
            if (view == android.support.v7.internal.widget.ActivityChooserView.d(a))
            {
                ActivityChooserView.a(a, false);
                ActivityChooserView.a(a, ActivityChooserView.e(a));
                return;
            } else
            {
                throw new IllegalArgumentException();
            }
        }

        public void onDismiss()
        {
            a();
            if (a.a != null)
            {
                a.a.a(false);
            }
        }

        public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
        {
            ((a)adapterview.getAdapter()).getItemViewType(i1);
            JVM INSTR tableswitch 0 1: default 32
        //                       0 50
        //                       1 40;
               goto _L1 _L2 _L3
_L1:
            throw new IllegalArgumentException();
_L3:
            ActivityChooserView.a(a, 0x7fffffff);
_L5:
            return;
_L2:
            a.b();
            if (!ActivityChooserView.b(a))
            {
                break; /* Loop/switch isn't completed */
            }
            if (i1 > 0)
            {
                ActivityChooserView.a(a).d().c(i1);
                return;
            }
            if (true) goto _L5; else goto _L4
_L4:
            if (!ActivityChooserView.a(a).e())
            {
                i1++;
            }
            adapterview = ActivityChooserView.a(a).d().b(i1);
            if (adapterview != null)
            {
                adapterview.addFlags(0x80000);
                a.getContext().startActivity(adapterview);
                return;
            }
            if (true) goto _L5; else goto _L6
_L6:
        }

        public boolean onLongClick(View view)
        {
            if (view == ActivityChooserView.c(a))
            {
                if (ActivityChooserView.a(a).getCount() > 0)
                {
                    ActivityChooserView.a(a, true);
                    ActivityChooserView.a(a, ActivityChooserView.e(a));
                }
                return true;
            } else
            {
                throw new IllegalArgumentException();
            }
        }
    }


    d a;
    private final a b;
    private final b c;
    private final u d;
    private final FrameLayout e;
    private final ImageView f;
    private final FrameLayout g;
    private final int h;
    private final DataSetObserver i;
    private final android.view.ViewTreeObserver.OnGlobalLayoutListener j;
    private v k;
    private android.widget.PopupWindow.OnDismissListener l;
    private boolean m;
    private int n;
    private boolean o;
    private int p;

    static a a(ActivityChooserView activitychooserview)
    {
        return activitychooserview.b;
    }

    private void a(int i1)
    {
        if (b.d() == null)
        {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(j);
        v v1;
        int j1;
        int k1;
        boolean flag;
        if (g.getVisibility() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        k1 = b.c();
        if (flag)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (i1 != 0x7fffffff && k1 > j1 + i1)
        {
            b.a(true);
            b.a(i1 - 1);
        } else
        {
            b.a(false);
            b.a(i1);
        }
        v1 = getListPopupWindow();
        if (!v1.b())
        {
            if (m || !flag)
            {
                b.a(true, flag);
            } else
            {
                b.a(false, false);
            }
            v1.d(Math.min(b.a(), h));
            v1.c();
            if (a != null)
            {
                a.a(true);
            }
            v1.g().setContentDescription(getContext().getString(android.support.v7.a.a.i.abc_activitychooserview_choose_application));
        }
    }

    static void a(ActivityChooserView activitychooserview, int i1)
    {
        activitychooserview.a(i1);
    }

    static boolean a(ActivityChooserView activitychooserview, boolean flag)
    {
        activitychooserview.m = flag;
        return flag;
    }

    static boolean b(ActivityChooserView activitychooserview)
    {
        return activitychooserview.m;
    }

    static FrameLayout c(ActivityChooserView activitychooserview)
    {
        return activitychooserview.g;
    }

    static FrameLayout d(ActivityChooserView activitychooserview)
    {
        return activitychooserview.e;
    }

    static int e(ActivityChooserView activitychooserview)
    {
        return activitychooserview.n;
    }

    static android.widget.PopupWindow.OnDismissListener f(ActivityChooserView activitychooserview)
    {
        return activitychooserview.l;
    }

    static DataSetObserver g(ActivityChooserView activitychooserview)
    {
        return activitychooserview.i;
    }

    private v getListPopupWindow()
    {
        if (k == null)
        {
            k = new v(getContext());
            k.a(b);
            k.a(this);
            k.a(true);
            k.a(c);
            k.a(c);
        }
        return k;
    }

    public boolean a()
    {
        if (c() || !o)
        {
            return false;
        } else
        {
            m = false;
            a(n);
            return true;
        }
    }

    public boolean b()
    {
        if (c())
        {
            getListPopupWindow().a();
            ViewTreeObserver viewtreeobserver = getViewTreeObserver();
            if (viewtreeobserver.isAlive())
            {
                viewtreeobserver.removeGlobalOnLayoutListener(j);
            }
        }
        return true;
    }

    public boolean c()
    {
        return getListPopupWindow().b();
    }

    public android.support.v7.internal.widget.d getDataModel()
    {
        return b.d();
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        android.support.v7.internal.widget.d d1 = b.d();
        if (d1 != null)
        {
            d1.registerObserver(i);
        }
        o = true;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        Object obj = b.d();
        if (obj != null)
        {
            ((android.support.v7.internal.widget.d) (obj)).unregisterObserver(i);
        }
        obj = getViewTreeObserver();
        if (((ViewTreeObserver) (obj)).isAlive())
        {
            ((ViewTreeObserver) (obj)).removeGlobalOnLayoutListener(j);
        }
        if (c())
        {
            b();
        }
        o = false;
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        d.layout(0, 0, k1 - i1, l1 - j1);
        if (!c())
        {
            b();
        }
    }

    protected void onMeasure(int i1, int j1)
    {
        u u1 = d;
        int k1 = j1;
        if (g.getVisibility() != 0)
        {
            k1 = android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.MeasureSpec.getSize(j1), 0x40000000);
        }
        measureChild(u1, i1, k1);
        setMeasuredDimension(u1.getMeasuredWidth(), u1.getMeasuredHeight());
    }

    public void setActivityChooserModel(android.support.v7.internal.widget.d d1)
    {
        b.a(d1);
        if (c())
        {
            b();
            a();
        }
    }

    public void setDefaultActionButtonContentDescription(int i1)
    {
        p = i1;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i1)
    {
        String s = getContext().getString(i1);
        f.setContentDescription(s);
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable)
    {
        f.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i1)
    {
        n = i1;
    }

    public void setOnDismissListener(android.widget.PopupWindow.OnDismissListener ondismisslistener)
    {
        l = ondismisslistener;
    }

    public void setProvider(d d1)
    {
        a = d1;
    }
}
