// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.NetworkBaseActivity;
import com.cyberlink.youcammakeup.clflurry.YMKLooksCategoryEvent;
import com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent;
import com.cyberlink.youcammakeup.database.more.makeup.MKCategoryV2Status;
import com.cyberlink.youcammakeup.database.more.makeup.b;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.database.more.types.OrderType;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierManager;
import com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.f;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.g;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.h;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.i;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.q;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.r;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.s;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.t;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ap;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.n;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.o;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.k;
import com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem;
import com.cyberlink.youcammakeup.pages.moreview.aa;
import com.cyberlink.youcammakeup.pages.moreview.ab;
import com.cyberlink.youcammakeup.pages.moreview.af;
import com.cyberlink.youcammakeup.pages.moreview.p;
import com.cyberlink.youcammakeup.pages.moreview.v;
import com.cyberlink.youcammakeup.pages.moreview.w;
import com.cyberlink.youcammakeup.utility.a;
import com.cyberlink.youcammakeup.utility.cc;
import com.cyberlink.youcammakeup.widgetpool.dialogs.e;
import com.idunnololz.widgets.AnimatedExpandableListView;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivity, MoreMakeupActivity, ExtraDownloadCategoryActivity, LauncherActivity

public class ExtraDownloadActivity extends NetworkBaseActivity
    implements f, g, h, i, q, r, s, t
{

    public static final UUID a = UUID.randomUUID();
    private static final String b = com/cyberlink/youcammakeup/kernelctrl/status/StatusManager.getName();
    private android.view.View.OnClickListener A;
    private android.widget.AbsListView.OnScrollListener B;
    private android.widget.ExpandableListView.OnGroupClickListener C;
    private android.widget.ExpandableListView.OnGroupClickListener D;
    private android.view.View.OnClickListener E;
    private com.cyberlink.youcammakeup.pages.moreview.t F;
    private android.view.View.OnClickListener G;
    private CategoryType c;
    private View d;
    private View e;
    private boolean f;
    private AnimatedExpandableListView g;
    private GridView h;
    private aa i;
    private ab j;
    private int k;
    private DownloadGridItem l;
    private ag m;
    private String n;
    private long o;
    private TextView p;
    private Object q;
    private boolean r;
    private boolean s;
    private boolean t;
    private View u;
    private com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType v;
    private v w;
    private View x;
    private android.view.View.OnClickListener y;
    private android.view.View.OnClickListener z;

    public ExtraDownloadActivity()
    {
        c = null;
        f = false;
        k = 0;
        r = false;
        s = true;
        t = false;
        y = new android.view.View.OnClickListener() {

            final ExtraDownloadActivity a;

            public void onClick(View view)
            {
                boolean flag1 = true;
                boolean flag;
                if (view.getId() == 0x7f0c00f3)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag == ExtraDownloadActivity.d(a))
                {
                    return;
                }
                com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.a(a, flag);
                if (com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.e(a) != null)
                {
                    com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.e(a).setSelected(flag);
                }
                if (com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.f(a) != null)
                {
                    view = com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.f(a);
                    if (!flag)
                    {
                        flag = flag1;
                    } else
                    {
                        flag = false;
                    }
                    view.setSelected(flag);
                }
                com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.g(a);
            }

            
            {
                a = ExtraDownloadActivity.this;
                super();
            }
        };
        z = new android.view.View.OnClickListener() {

            final ExtraDownloadActivity a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.h(a);
            }

            
            {
                a = ExtraDownloadActivity.this;
                super();
            }
        };
        A = new android.view.View.OnClickListener() {

            final ExtraDownloadActivity a;

            public void onClick(View view)
            {
                view = new Intent(a, com/cyberlink/youcammakeup/activity/LauncherActivity);
                view.setFlags(0x10008000);
                a.startActivity(view);
                Globals.d().i();
                com.cyberlink.youcammakeup.utility.o.a(a);
                a.finish();
            }

            
            {
                a = ExtraDownloadActivity.this;
                super();
            }
        };
        B = new android.widget.AbsListView.OnScrollListener() {

            final ExtraDownloadActivity a;

            public void onScroll(AbsListView abslistview, int i1, int j1, int k1)
            {
                com.pf.common.utility.m.b("sean", "sean list view onScroll!!");
            }

            public void onScrollStateChanged(AbsListView abslistview, int i1)
            {
                com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.a(a, i1);
            }

            
            {
                a = ExtraDownloadActivity.this;
                super();
            }
        };
        C = new android.widget.ExpandableListView.OnGroupClickListener() {

            final ExtraDownloadActivity a;

            public boolean onGroupClick(ExpandableListView expandablelistview, View view, int i1, long l1)
            {
                if (com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.a(a).isGroupExpanded(i1))
                {
                    com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.a(a).b(i1);
                } else
                {
                    int k1 = i1 + 1;
                    for (int j1 = 0; j1 < i1;)
                    {
                        int i2 = k1;
                        if (com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.a(a).isGroupExpanded(j1))
                        {
                            i2 = k1 + com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.i(a).getChildrenCount(j1);
                        }
                        j1++;
                        k1 = i2;
                    }

                    com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.a(a).a(i1);
                    com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.a(a).smoothScrollToPosition(k1);
                }
                return true;
            }

            
            {
                a = ExtraDownloadActivity.this;
                super();
            }
        };
        D = new android.widget.ExpandableListView.OnGroupClickListener() {

            final ExtraDownloadActivity a;

            public boolean onGroupClick(ExpandableListView expandablelistview, View view, int i1, long l1)
            {
                return true;
            }

            
            {
                a = ExtraDownloadActivity.this;
                super();
            }
        };
        E = new android.view.View.OnClickListener() {

            final ExtraDownloadActivity a;

            public void onClick(View view)
            {
                Globals.d().i().l(a);
                ExtraDownloadActivity.j(a);
            }

            
            {
                a = ExtraDownloadActivity.this;
                super();
            }
        };
        F = new com.cyberlink.youcammakeup.pages.moreview.t() {

            final ExtraDownloadActivity a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.b(a, true);
                com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.a(a, (DownloadGridItem)view);
                view = (p)view.getTag();
                view = com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.i(a).a(view.a());
                if (view != null)
                {
                    view = view.b();
                    com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.n(a).a(view, com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.k(a), ExtraDownloadActivity.l(a), com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.m(a));
                    com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.n(a).a(new w(this) {

                        final _cls6 a;

                        public void a()
                        {
                            com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.n(a.a).a(null);
                            com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.a(a.a, null);
                            com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.b(a.a, false);
                        }

            
            {
                a = _pcls6;
                super();
            }
                    });
                }
            }

            
            {
                a = ExtraDownloadActivity.this;
                super();
            }
        };
        G = new android.view.View.OnClickListener() {

            final ExtraDownloadActivity a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.h(a);
            }

            
            {
                a = ExtraDownloadActivity.this;
                super();
            }
        };
    }

    static int a(ExtraDownloadActivity extradownloadactivity, int i1)
    {
        extradownloadactivity.k = i1;
        return i1;
    }

    static DownloadGridItem a(ExtraDownloadActivity extradownloadactivity, DownloadGridItem downloadgriditem)
    {
        extradownloadactivity.l = downloadgriditem;
        return downloadgriditem;
    }

    static AnimatedExpandableListView a(ExtraDownloadActivity extradownloadactivity)
    {
        return extradownloadactivity.g;
    }

    static boolean a(ExtraDownloadActivity extradownloadactivity, boolean flag)
    {
        extradownloadactivity.f = flag;
        return flag;
    }

    static long b(ExtraDownloadActivity extradownloadactivity)
    {
        return extradownloadactivity.o;
    }

    static boolean b(ExtraDownloadActivity extradownloadactivity, boolean flag)
    {
        extradownloadactivity.t = flag;
        return flag;
    }

    static TextView c(ExtraDownloadActivity extradownloadactivity)
    {
        return extradownloadactivity.p;
    }

    private DownloadGridItem d(long l1)
    {
        int j1;
        boolean flag = false;
        int i1 = 0;
        do
        {
            j1 = ((flag) ? 1 : 0);
            if (i1 >= g.getChildCount())
            {
                break;
            }
            Object obj = g.getChildAt(i1);
            if (obj instanceof DownloadGridItem)
            {
                obj = (DownloadGridItem)obj;
            } else
            {
                obj = null;
            }
            if (obj != null && ((p)((DownloadGridItem) (obj)).getTag()).b() != null && ((p)((DownloadGridItem) (obj)).getTag()).b().longValue() == l1)
            {
                return ((DownloadGridItem) (obj));
            }
            i1++;
        } while (true);
_L3:
        DownloadGridItem downloadgriditem;
        if (j1 < h.getChildCount())
        {
            if ((downloadgriditem = (DownloadGridItem)h.getChildAt(j1)) != null && ((p)downloadgriditem.getTag()).b() != null && ((p)downloadgriditem.getTag()).b().longValue() == l1)
            {
                return downloadgriditem;
            }
        } else
        {
            return null;
        }
        if (true) goto _L2; else goto _L1
_L2:
        j1++;
        if (true) goto _L3; else goto _L1
_L1:
    }

    static boolean d(ExtraDownloadActivity extradownloadactivity)
    {
        return extradownloadactivity.f;
    }

    static View e(ExtraDownloadActivity extradownloadactivity)
    {
        return extradownloadactivity.d;
    }

    static View f(ExtraDownloadActivity extradownloadactivity)
    {
        return extradownloadactivity.e;
    }

    static void g(ExtraDownloadActivity extradownloadactivity)
    {
        extradownloadactivity.u();
    }

    static void h(ExtraDownloadActivity extradownloadactivity)
    {
        extradownloadactivity.t();
    }

    static aa i(ExtraDownloadActivity extradownloadactivity)
    {
        return extradownloadactivity.i;
    }

    static void j(ExtraDownloadActivity extradownloadactivity)
    {
        extradownloadactivity.n();
    }

    static DownloadGridItem k(ExtraDownloadActivity extradownloadactivity)
    {
        return extradownloadactivity.l;
    }

    static ag l(ExtraDownloadActivity extradownloadactivity)
    {
        return extradownloadactivity.m;
    }

    static com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType m(ExtraDownloadActivity extradownloadactivity)
    {
        return extradownloadactivity.v;
    }

    private void m()
    {
        Object obj = getIntent();
        Uri uri = ((Intent) (obj)).getData();
        if (uri != null && com.cyberlink.youcammakeup.utility.a.a(uri.toString()))
        {
            YMKLooksStoreEvent.b(com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent.Source.a.a());
            com.cyberlink.youcammakeup.utility.a.a(uri.toString(), this, ((Intent) (obj)));
            StatusManager.j().a(-1L, a);
            obj = Globals.d().t();
            if (obj != null)
            {
                ((EditViewActivity) (obj)).finish();
            }
        }
        if (getIntent().getExtras() == null) goto _L2; else goto _L1
_L1:
        Object obj2;
        long l1;
        if (r())
        {
            r = true;
            BeautifierManager.a().a(StatusManager.j().l());
        }
        l1 = getIntent().getLongExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", 0L);
        obj2 = getIntent().getStringExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_NAME");
        c = (CategoryType)getIntent().getSerializableExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_TYPE");
        if (l1 != 0x15ab1bL) goto _L4; else goto _L3
_L3:
        Object obj1;
label0:
        {
            if (obj2 != null)
            {
                obj1 = obj2;
                if (!((String) (obj2)).isEmpty())
                {
                    break label0;
                }
            }
            obj1 = getString(0x7f070502);
        }
_L6:
        obj2 = (TextView)findViewById(0x7f0c00ee);
        ((TextView) (obj2)).setText(((CharSequence) (obj1)));
        o = l1;
        p = ((TextView) (obj2));
        s = getIntent().getBooleanExtra("KEY_EXTRA_DOWNLOAD_BACK_TO_MAIN", true);
        int i1 = getIntent().getIntExtra("KEY_EXTRA_DOWNLOAD_DISPLAY_TYPE", com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.a.ordinal());
        v = com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.values()[i1];
_L2:
        d = findViewById(0x7f0c00f3);
        e = findViewById(0x7f0c00f4);
        if (e != null)
        {
            e.setSelected(true);
        }
        f = false;
        Globals.d().b(this);
        g = (AnimatedExpandableListView)findViewById(0x7f0c00f5);
        h = (GridView)findViewById(0x7f0c00f6);
        m = new ag(this);
        obj1 = new k(this, null);
        obj1.g = false;
        ((k) (obj1)).a(0.15F);
        m.a(getFragmentManager(), ((k) (obj1)));
        u = findViewById(0x7f0c00f7);
        n();
        boolean flag;
        if (n != null && !n.equals(com.cyberlink.youcammakeup.kernelctrl.z.c("")))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            q();
        }
        if (Globals.e && !Globals.d)
        {
            if (NetworkManager.a(this));
        }
        w = new v(findViewById(0x7f0c057f));
        x = findViewById(0x7f0c0107);
        if (x != null)
        {
            x.setOnTouchListener(new android.view.View.OnTouchListener() {

                final ExtraDownloadActivity a;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    boolean flag2;
label0:
                    {
label1:
                        {
                            boolean flag3 = false;
                            boolean flag1 = false;
                            flag2 = flag3;
                            if (com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.a(a) == null)
                            {
                                break label0;
                            }
                            flag2 = flag3;
                            if (com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.a(a).getVisibility() != 0)
                            {
                                break label0;
                            }
                            if (motionevent.getAction() == 0 || motionevent.getAction() == 5)
                            {
                                int j1 = 0;
                                while (j1 < com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.a(a).getChildCount()) 
                                {
                                    view = com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.a(a).getChildAt(j1);
                                    if (view instanceof DownloadGridItem)
                                    {
                                        view = (DownloadGridItem)view;
                                    } else
                                    {
                                        view = null;
                                    }
                                    if (view != null && !view.a(motionevent.getRawX(), motionevent.getRawY()))
                                    {
                                        view.setLookTemplateMenuVisibility(4);
                                    }
                                    j1++;
                                }
                            }
                            int k1 = ((flag1) ? 1 : 0);
                            if (motionevent.getAction() != 2)
                            {
                                if (motionevent.getAction() != 8)
                                {
                                    break label1;
                                }
                                k1 = ((flag1) ? 1 : 0);
                            }
                            while (k1 < com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.a(a).getChildCount()) 
                            {
                                view = com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.a(a).getChildAt(k1);
                                if (view instanceof DownloadGridItem)
                                {
                                    view = (DownloadGridItem)view;
                                } else
                                {
                                    view = null;
                                }
                                if (view != null)
                                {
                                    view.setLookTemplateMenuVisibility(4);
                                }
                                k1++;
                            }
                        }
                        com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.a(a).dispatchTouchEvent(motionevent);
                        flag2 = true;
                    }
                    return flag2;
                }

            
            {
                a = ExtraDownloadActivity.this;
                super();
            }
            });
        }
        return;
_L4:
        if (l1 == 0x15ab1cL)
        {
            if (obj2 != null)
            {
                obj1 = obj2;
                if (!((String) (obj2)).isEmpty())
                {
                    continue; /* Loop/switch isn't completed */
                }
            }
            obj1 = getString(0x7f0703e1);
            continue; /* Loop/switch isn't completed */
        }
        if (l1 == 0x15ab32L)
        {
            if (obj2 != null)
            {
                obj1 = obj2;
                if (!((String) (obj2)).isEmpty())
                {
                    continue; /* Loop/switch isn't completed */
                }
            }
            obj1 = getString(0x7f070501);
            continue; /* Loop/switch isn't completed */
        }
        if (l1 == 0x15ab16L)
        {
            if (obj2 != null)
            {
                obj1 = obj2;
                if (!((String) (obj2)).isEmpty())
                {
                    continue; /* Loop/switch isn't completed */
                }
            }
            obj1 = getString(0x7f07033c);
            continue; /* Loop/switch isn't completed */
        }
        if (l1 == 0x15ab18L)
        {
            if (obj2 != null)
            {
                obj1 = obj2;
                if (!((String) (obj2)).isEmpty())
                {
                    continue; /* Loop/switch isn't completed */
                }
            }
            obj1 = getString(0x7f07033b);
            continue; /* Loop/switch isn't completed */
        }
        if (l1 == 0x15ab19L)
        {
            if (obj2 != null)
            {
                obj1 = obj2;
                if (!((String) (obj2)).isEmpty())
                {
                    continue; /* Loop/switch isn't completed */
                }
            }
            obj1 = getString(0x7f07033a);
            continue; /* Loop/switch isn't completed */
        }
        if (l1 == 0x15ab38L)
        {
            if (obj2 != null)
            {
                obj1 = obj2;
                if (!((String) (obj2)).isEmpty())
                {
                    continue; /* Loop/switch isn't completed */
                }
            }
            obj1 = getString(0x7f07008c);
            continue; /* Loop/switch isn't completed */
        }
        if (l1 == 0x15ab3aL)
        {
            if (obj2 != null)
            {
                obj1 = obj2;
                if (!((String) (obj2)).isEmpty())
                {
                    continue; /* Loop/switch isn't completed */
                }
            }
            obj1 = getString(0x7f07008d);
            continue; /* Loop/switch isn't completed */
        }
        if (l1 == 0x15ab3bL)
        {
            if (obj2 != null)
            {
                obj1 = obj2;
                if (!((String) (obj2)).isEmpty())
                {
                    continue; /* Loop/switch isn't completed */
                }
            }
            obj1 = getString(0x7f07008e);
            continue; /* Loop/switch isn't completed */
        }
        obj1 = obj2;
        if (l1 != 0x15ab39L)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (obj2 != null)
        {
            obj1 = obj2;
            if (!((String) (obj2)).isEmpty())
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        obj1 = getString(0x7f07008b);
        if (true) goto _L6; else goto _L5
_L5:
    }

    static v n(ExtraDownloadActivity extradownloadactivity)
    {
        return extradownloadactivity.w;
    }

    private void n()
    {
        if (u != null)
        {
            u.setVisibility(8);
        }
        OrderType ordertype;
        android.view.View.OnClickListener onclicklistener;
        CategoryType categorytype;
        if (f)
        {
            ordertype = OrderType.c;
        } else
        {
            ordertype = OrderType.b;
        }
        categorytype = c;
        if (i != null)
        {
            i.e();
            i = null;
        }
        if (j != null)
        {
            j.c();
            j = null;
        }
        if (s)
        {
            onclicklistener = null;
        } else
        {
            onclicklistener = G;
        }
        if (c == CategoryType.e || c == CategoryType.f || c == CategoryType.i || c == CategoryType.m || c == CategoryType.j || c == CategoryType.k || c == CategoryType.l)
        {
            j = new ab(this, categorytype, o, ordertype, E, onclicklistener, q, m, v);
            h.setNumColumns(2);
            h.setAdapter(j);
            h.setVisibility(0);
            g.setVisibility(8);
            return;
        } else
        {
            i = new aa(this, categorytype, o, ordertype, E, F, onclicklistener, q, m, v);
            i.a(C);
            g.setOnGroupClickListener(D);
            g.setAdapter(i);
            g.setVisibility(0);
            h.setVisibility(8);
            return;
        }
    }

    private void o()
    {
        if (d != null)
        {
            d.setOnClickListener(y);
        }
        if (e != null)
        {
            e.setOnClickListener(y);
        }
        findViewById(0x7f0c00ed).setOnClickListener(z);
        findViewById(0x7f0c00f0).setOnClickListener(A);
        NetworkManager networkmanager;
        int i1;
        if (Globals.d().I())
        {
            i1 = 0;
        } else
        {
            i1 = 4;
        }
        findViewById(0x7f0c00f0).setVisibility(i1);
        g.setOnScrollListener(B);
        networkmanager = Globals.d().w();
        if (networkmanager != null)
        {
            networkmanager.a(this);
            networkmanager.a(this);
            networkmanager.a(this);
            networkmanager.a(this);
            networkmanager.a(this);
            networkmanager.a(this);
            networkmanager.a(this);
            networkmanager.a(this);
        }
    }

    private void p()
    {
        if (d != null)
        {
            d.setOnClickListener(null);
        }
        if (e != null)
        {
            e.setOnClickListener(null);
        }
        findViewById(0x7f0c00ed).setOnClickListener(null);
        findViewById(0x7f0c00f0).setOnClickListener(null);
        g.setOnScrollListener(null);
        NetworkManager networkmanager = Globals.d().w();
        if (networkmanager != null)
        {
            networkmanager.b(this);
            networkmanager.b(this);
            networkmanager.b(this);
            networkmanager.b(this);
            networkmanager.b(this);
            networkmanager.b(this);
            networkmanager.b(this);
            networkmanager.b(this);
        }
    }

    private void q()
    {
        NetworkManager networkmanager = Globals.d().w();
        MakeupItemTreeManager makeupitemtreemanager = MakeupItemTreeManager.a();
        ArrayList arraylist = new ArrayList();
        arraylist.add(makeupitemtreemanager.c(com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.a, o));
        networkmanager.a(new o(networkmanager, arraylist, new com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.p() {

            final ExtraDownloadActivity a;

            public void a(bn bn1)
            {
                if (bn1 != null)
                {
                    com.pf.common.utility.m.b("ExtraDownloadActivity", (new StringBuilder()).append("[GetCategoryTask] error ").append(bn1.toString()).toString());
                }
            }

            public void a(n n1)
            {
                if (n1 != null && n1.a() != null) goto _L2; else goto _L1
_L1:
                return;
_L2:
                n1 = n1.a().iterator();
_L5:
                if (!n1.hasNext()) goto _L1; else goto _L3
_L3:
                com.cyberlink.youcammakeup.database.more.makeup.a a1 = (com.cyberlink.youcammakeup.database.more.makeup.a)n1.next();
                if (Long.valueOf(a1.a()).longValue() != com.cyberlink.youcammakeup.activity.ExtraDownloadActivity.b(a)) goto _L5; else goto _L4
_L4:
                Activity activity = Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.c);
                if (activity == null) goto _L1; else goto _L6
_L6:
                activity.runOnUiThread(new Runnable(this, a1.b()) {

                    final String a;
                    final _cls8 b;

                    public void run()
                    {
                        ExtraDownloadActivity.c(b.a).setText(a);
                    }

            
            {
                b = _pcls8;
                a = s1;
                super();
            }
                });
                  goto _L5
            }

            public volatile void a(Object obj)
            {
                a((n)obj);
            }

            public void a(Void void1)
            {
                com.pf.common.utility.m.b("ExtraDownloadActivity", "[GetCategoryTask] cancel");
            }

            public void b(Object obj)
            {
                a((bn)obj);
            }

            public void c(Object obj)
            {
                a((Void)obj);
            }

            
            {
                a = ExtraDownloadActivity.this;
                super();
            }
        }), com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.TaskPriority.b);
    }

    private boolean r()
    {
        if (getIntent().getExtras() != null)
        {
            String s1 = getIntent().getStringExtra("KEY_EXTRA_DOWNLOAD_SOURCE");
            if (s1 != null && s1.equalsIgnoreCase("com.cyberlink.youperfect"))
            {
                return true;
            }
        }
        return false;
    }

    private void s()
    {
        Intent intent = new Intent();
        intent.setClassName("com.cyberlink.youperfect", "com.cyberlink.youperfect.activity.NoticeActivity");
        startActivity(intent);
    }

    private void t()
    {
        if (t)
        {
            w.a();
            return;
        }
        if (r)
        {
            s();
            return;
        }
        if (isTaskRoot())
        {
            startActivity(new Intent(getApplicationContext(), com/cyberlink/youcammakeup/activity/MoreMakeupActivity));
            Globals.d().i();
            com.cyberlink.youcammakeup.utility.o.a(this);
            finish();
            return;
        }
        Intent intent = new Intent(getApplicationContext(), com/cyberlink/youcammakeup/activity/ExtraDownloadCategoryActivity);
        intent.putExtra("KEY_EXTRA_DOWNLOAD_DISPLAY_TYPE", v.ordinal());
        long l1;
        if (c == CategoryType.b || c == CategoryType.c)
        {
            if (c == CategoryType.b)
            {
                l1 = 0x15ab1bL;
            } else
            {
                l1 = 0x15ab1cL;
            }
            intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", l1);
            startActivity(intent);
        }
        if (c == CategoryType.i || c == CategoryType.m)
        {
            if (c == CategoryType.i)
            {
                l1 = 0x15ab38L;
            } else
            {
                l1 = 0x15ab37L;
            }
            intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", l1);
            startActivity(intent);
        }
        Globals.d().i();
        com.cyberlink.youcammakeup.utility.o.a(this);
        finish();
    }

    private void u()
    {
        if (k != 0)
        {
            MotionEvent motionevent = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0);
            g.dispatchTouchEvent(motionevent);
            motionevent.recycle();
        }
        Globals.d().i().l(this);
        n();
    }

    public void a(long l1, com.cyberlink.youcammakeup.kernelctrl.networkmanager.a a1)
    {
        DownloadGridItem downloadgriditem = d(l1);
        if (a1 != null && downloadgriditem != null && ((p)downloadgriditem.getTag()).c() == com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.c)
        {
            runOnUiThread(new Runnable(downloadgriditem, af.a(a1)) {

                final DownloadGridItem a;
                final int b;
                final ExtraDownloadActivity c;

                public void run()
                {
                    a.setProgress(b);
                }

            
            {
                c = ExtraDownloadActivity.this;
                a = downloadgriditem;
                b = i1;
                super();
            }
            });
        }
    }

    public void a(long l1, bn bn)
    {
        bn = d(l1);
        if (bn != null && ((p)bn.getTag()).c() == com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.c)
        {
            runOnUiThread(new Runnable(bn, (p)bn.getTag()) {

                final DownloadGridItem a;
                final p b;
                final ExtraDownloadActivity c;

                public void run()
                {
                    a.setDownloadBtnState(com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.e);
                    b.a(com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.e);
                }

            
            {
                c = ExtraDownloadActivity.this;
                a = downloadgriditem;
                b = p1;
                super();
            }
            });
        }
    }

    public void b(long l1)
    {
        DownloadGridItem downloadgriditem = d(l1);
        if (downloadgriditem != null && ((p)downloadgriditem.getTag()).c() == com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.c)
        {
            runOnUiThread(new Runnable(downloadgriditem, (p)downloadgriditem.getTag()) {

                final DownloadGridItem a;
                final p b;
                final ExtraDownloadActivity c;

                public void run()
                {
                    a.setDownloadBtnState(com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.b);
                    b.a(com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.b);
                }

            
            {
                c = ExtraDownloadActivity.this;
                a = downloadgriditem;
                b = p1;
                super();
            }
            });
        }
    }

    public void c(long l1)
    {
        DownloadGridItem downloadgriditem = d(l1);
        if (downloadgriditem != null)
        {
            runOnUiThread(new Runnable(downloadgriditem, (p)downloadgriditem.getTag()) {

                final DownloadGridItem a;
                final p b;
                final ExtraDownloadActivity c;

                public void run()
                {
                    a.setDownloadBtnState(com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.d);
                    b.a(com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.d);
                }

            
            {
                c = ExtraDownloadActivity.this;
                a = downloadgriditem;
                b = p1;
                super();
            }
            });
        }
    }

    public void finish()
    {
        Globals.d().w().K().b(com.cyberlink.youcammakeup.activity.MoreMakeupActivity.a, o);
        Object obj = Globals.d().K();
        if (obj != null && ((Pair) (obj)).second != null)
        {
            obj = ((ap)((Pair) (obj)).second).i().b();
            if (obj != null)
            {
                obj = ((Collection) (obj)).iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    b b1 = (b)((Iterator) (obj)).next();
                    if (b1.a() == o && com.cyberlink.youcammakeup.kernelctrl.z.c(this, String.valueOf(o), Long.valueOf(0L)).longValue() < b1.c())
                    {
                        com.cyberlink.youcammakeup.kernelctrl.z.d(this, String.valueOf(o), Long.valueOf(b1.c()));
                    }
                } while (true);
            }
        }
        super.finish();
    }

    public void k()
    {
        if (g.getVisibility() == 0)
        {
            g.invalidateViews();
        } else
        if (h.getVisibility() == 0)
        {
            h.invalidateViews();
            return;
        }
    }

    public void l()
    {
        if (u != null)
        {
            u.setVisibility(0);
        }
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
    }

    protected void onCreate(Bundle bundle)
    {
        boolean flag = false;
        if (r())
        {
            Globals.d().H();
        }
        super.onCreate(bundle);
        if (getIntent().getExtras() != null)
        {
            flag = getIntent().getBooleanExtra("KEY_EXTRA_DOWNLOAD_HIDE_TOP_NEW_TAB", false);
        }
        int i1;
        if (flag)
        {
            i1 = 0x7f03000c;
        } else
        {
            i1 = 0x7f03000a;
        }
        setContentView(i1);
        StatusManager.j().a("extraDownloadPage");
        Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.c, this);
        if (Globals.d().v() == "extraDownloadPage")
        {
            StatusManager.j().D();
        }
        if (bundle != null && bundle.containsKey("PREV_LANGUAGE"))
        {
            n = bundle.getString("PREV_LANGUAGE");
        }
        m();
        o();
    }

    public void onDestroy()
    {
        super.onDestroy();
        p();
        if (i != null)
        {
            i.e();
            i = null;
        }
        if (j != null)
        {
            j.c();
            j = null;
        }
        Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.c, null);
        m.b(true);
        m.f();
        m.h();
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && keyevent.getRepeatCount() == 0)
        {
            keyevent.startTracking();
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    public boolean onKeyUp(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && getFragmentManager().getBackStackEntryCount() == 0 && keyevent.isTracking() && !keyevent.isCanceled())
        {
            t();
            return true;
        } else
        {
            return super.onKeyUp(i1, keyevent);
        }
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        if (intent == null)
        {
            com.pf.common.utility.m.b("ExtraDownloadActivity", "[onNewIntent] intent is null or intent extras is null, not valid");
            return;
        }
        if (intent.getExtras() == null && intent.getData() == null)
        {
            com.pf.common.utility.m.b("ExtraDownloadActivity", "[onNewIntent] intent is null or intent extras is null, not valid");
            return;
        } else
        {
            setIntent(intent);
            com.pf.common.utility.m.b("ExtraDownloadActivity", "onNewIntent enter");
            m();
            return;
        }
    }

    protected void onPause()
    {
        super.onPause();
        if (r)
        {
            r = false;
        }
        Globals.d().c("extraDownloadPage");
        m.c(true);
        m.g();
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
    }

    protected void onResume()
    {
        super.onResume();
        if (c == CategoryType.c || c == CategoryType.b)
        {
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKLooksCategoryEvent(com.cyberlink.youcammakeup.clflurry.YMKLooksCategoryEvent.Operation.a, p.getText().toString(), o));
        }
        Globals.d().c(null);
        m.c(false);
        StatusManager.j().C();
        String s1 = cc.a();
        if (cc.d(s1))
        {
            i.notifyDataSetChanged();
            s1 = cc.e(s1);
            cc.b();
            com.cyberlink.youcammakeup.utility.o.a(this, new e(s1), "CongratulationUnlockDialog");
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(b, StatusManager.j());
        bundle.putString("PREV_LANGUAGE", com.cyberlink.youcammakeup.kernelctrl.z.c(""));
    }

    protected void onStart()
    {
        super.onStart();
        StatusManager.j().a("extraDownloadPage");
        StatusManager.j().a(Boolean.valueOf(true));
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getAction() == 0 || motionevent.getAction() == 5)
        {
            com.pf.common.utility.m.b("sean", "sean extra dwonload page touch down");
        }
        return true;
    }

}
