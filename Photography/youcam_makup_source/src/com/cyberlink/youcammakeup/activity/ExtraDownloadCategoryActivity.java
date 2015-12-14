// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ExpandableListView;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.NetworkBaseActivity;
import com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent;
import com.cyberlink.youcammakeup.database.more.makeup.MKCategoryV2Status;
import com.cyberlink.youcammakeup.database.more.makeup.b;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierManager;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.f;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.g;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.h;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.i;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ap;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.k;
import com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem;
import com.cyberlink.youcammakeup.pages.moreview.PromoteLooksDialog;
import com.cyberlink.youcammakeup.pages.moreview.af;
import com.cyberlink.youcammakeup.pages.moreview.ak;
import com.cyberlink.youcammakeup.pages.moreview.p;
import com.cyberlink.youcammakeup.pages.moreview.y;
import com.cyberlink.youcammakeup.utility.a;
import com.cyberlink.youcammakeup.utility.cc;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.dialogs.e;
import com.idunnololz.widgets.AnimatedExpandableListView;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivity, MoreMakeupActivity, ExtraDownloadActivity, LauncherActivity

public class ExtraDownloadCategoryActivity extends NetworkBaseActivity
    implements f, g, h, i
{

    public static final UUID a = UUID.randomUUID();
    private static final String c = com/cyberlink/youcammakeup/kernelctrl/status/StatusManager.getName();
    private android.widget.AbsListView.OnScrollListener A;
    protected boolean b;
    private CategoryType d;
    private View e;
    private AnimatedExpandableListView f;
    private y g;
    private Object h;
    private ag i;
    private long j;
    private boolean k;
    private View l;
    private View m;
    private View n;
    private int o;
    private PromoteLooksDialog p;
    private String q;
    private com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType r;
    private boolean s;
    private boolean t;
    private android.view.View.OnClickListener u;
    private android.view.View.OnClickListener v;
    private android.view.View.OnClickListener w;
    private android.widget.ExpandableListView.OnGroupClickListener x;
    private android.view.View.OnClickListener y;
    private android.view.View.OnClickListener z;

    public ExtraDownloadCategoryActivity()
    {
        d = null;
        k = false;
        b = false;
        o = 0;
        q = null;
        s = true;
        t = true;
        u = new android.view.View.OnClickListener() {

            final ExtraDownloadCategoryActivity a;

            public void onClick(View view)
            {
                if (com.cyberlink.youcammakeup.activity.ExtraDownloadCategoryActivity.a(a))
                {
                    com.cyberlink.youcammakeup.activity.ExtraDownloadCategoryActivity.b(a);
                } else
                {
                    a.f();
                }
                Globals.d().i();
                com.cyberlink.youcammakeup.utility.o.a(a);
            }

            
            {
                a = ExtraDownloadCategoryActivity.this;
                super();
            }
        };
        v = new android.view.View.OnClickListener() {

            final ExtraDownloadCategoryActivity a;

            public void onClick(View view)
            {
                Globals.d().i();
                com.cyberlink.youcammakeup.utility.o.a(a);
                view = new Intent(a, com/cyberlink/youcammakeup/activity/LauncherActivity);
                view.setFlags(0x10008000);
                a.startActivity(view);
                a.finish();
            }

            
            {
                a = ExtraDownloadCategoryActivity.this;
                super();
            }
        };
        w = new android.view.View.OnClickListener() {

            final ExtraDownloadCategoryActivity a;

            public void onClick(View view)
            {
                ExtraDownloadCategoryActivity.c(a).onClick(view);
            }

            
            {
                a = ExtraDownloadCategoryActivity.this;
                super();
            }
        };
        x = new android.widget.ExpandableListView.OnGroupClickListener() {

            final ExtraDownloadCategoryActivity a;

            public boolean onGroupClick(ExpandableListView expandablelistview, View view, int i1, long l1)
            {
                if (!ExtraDownloadCategoryActivity.d(a).d(i1))
                {
                    return true;
                } else
                {
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKLooksStoreEvent(com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent.Operation.b, null, ExtraDownloadCategoryActivity.d(a).c(i1)));
                    Globals.d().a(true);
                    expandablelistview = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/ExtraDownloadActivity);
                    expandablelistview.putExtra("KEY_EXTRA_DOWNLOAD_SOURCE", a.getIntent().getStringExtra("KEY_EXTRA_DOWNLOAD_SOURCE"));
                    expandablelistview.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", ExtraDownloadCategoryActivity.d(a).getGroupId(i1));
                    expandablelistview.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_TYPE", com.cyberlink.youcammakeup.activity.ExtraDownloadCategoryActivity.e(a));
                    expandablelistview.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_NAME", ExtraDownloadCategoryActivity.d(a).c(i1));
                    expandablelistview.putExtra("KEY_EXTRA_DOWNLOAD_DISPLAY_TYPE", com.cyberlink.youcammakeup.activity.ExtraDownloadCategoryActivity.f(a).ordinal());
                    expandablelistview.putExtra("KEY_EXTRA_DOWNLOAD_HIDE_TOP_NEW_TAB", true);
                    a.startActivity(expandablelistview);
                    a.finish();
                    return true;
                }
            }

            
            {
                a = ExtraDownloadCategoryActivity.this;
                super();
            }
        };
        y = new android.view.View.OnClickListener() {

            final ExtraDownloadCategoryActivity a;

            public void onClick(View view)
            {
                Globals.d().i().l(a);
                com.cyberlink.youcammakeup.activity.ExtraDownloadCategoryActivity.g(a);
            }

            
            {
                a = ExtraDownloadCategoryActivity.this;
                super();
            }
        };
        z = new android.view.View.OnClickListener() {

            final ExtraDownloadCategoryActivity a;

            public void onClick(View view)
            {
                boolean flag1 = true;
                boolean flag;
                if (view.getId() == 0x7f0c0100)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag == a.b)
                {
                    return;
                }
                a.b = flag;
                com.cyberlink.youcammakeup.activity.ExtraDownloadCategoryActivity.h(a).setSelected(flag);
                view = com.cyberlink.youcammakeup.activity.ExtraDownloadCategoryActivity.i(a);
                ExtraDownloadCategoryActivity extradownloadcategoryactivity;
                if (flag)
                {
                    flag1 = false;
                }
                view.setSelected(flag1);
                extradownloadcategoryactivity = a;
                if (flag)
                {
                    view = CategoryType.b;
                } else
                {
                    view = CategoryType.c;
                }
                com.cyberlink.youcammakeup.activity.ExtraDownloadCategoryActivity.a(extradownloadcategoryactivity, view);
                ExtraDownloadCategoryActivity.j(a);
            }

            
            {
                a = ExtraDownloadCategoryActivity.this;
                super();
            }
        };
        A = new android.widget.AbsListView.OnScrollListener() {

            final ExtraDownloadCategoryActivity a;

            public void onScroll(AbsListView abslistview, int i1, int j1, int k1)
            {
            }

            public void onScrollStateChanged(AbsListView abslistview, int i1)
            {
                com.cyberlink.youcammakeup.activity.ExtraDownloadCategoryActivity.a(a, i1);
            }

            
            {
                a = ExtraDownloadCategoryActivity.this;
                super();
            }
        };
    }

    static int a(ExtraDownloadCategoryActivity extradownloadcategoryactivity, int i1)
    {
        extradownloadcategoryactivity.o = i1;
        return i1;
    }

    static CategoryType a(ExtraDownloadCategoryActivity extradownloadcategoryactivity, CategoryType categorytype)
    {
        extradownloadcategoryactivity.d = categorytype;
        return categorytype;
    }

    static List a(ExtraDownloadCategoryActivity extradownloadcategoryactivity, long l1)
    {
        return extradownloadcategoryactivity.d(l1);
    }

    static boolean a(ExtraDownloadCategoryActivity extradownloadcategoryactivity)
    {
        return extradownloadcategoryactivity.k;
    }

    static void b(ExtraDownloadCategoryActivity extradownloadcategoryactivity)
    {
        extradownloadcategoryactivity.r();
    }

    static android.view.View.OnClickListener c(ExtraDownloadCategoryActivity extradownloadcategoryactivity)
    {
        return extradownloadcategoryactivity.u;
    }

    static y d(ExtraDownloadCategoryActivity extradownloadcategoryactivity)
    {
        return extradownloadcategoryactivity.g;
    }

    private List d(long l1)
    {
        ArrayList arraylist = new ArrayList();
        int i1 = 0;
        while (i1 < f.getChildCount()) 
        {
            ViewGroup viewgroup = (ViewGroup)f.getChildAt(i1).findViewById(0x7f0c08e0);
            if (viewgroup != null)
            {
                int j1 = 0;
                while (j1 < viewgroup.getChildCount()) 
                {
                    DownloadGridItem downloadgriditem = (DownloadGridItem)viewgroup.getChildAt(j1);
                    if (((p)downloadgriditem.getTag()).b() != null && ((p)downloadgriditem.getTag()).b().longValue() == l1)
                    {
                        arraylist.add(downloadgriditem);
                    }
                    j1++;
                }
            }
            i1++;
        }
        return arraylist;
    }

    static CategoryType e(ExtraDownloadCategoryActivity extradownloadcategoryactivity)
    {
        return extradownloadcategoryactivity.d;
    }

    static com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType f(ExtraDownloadCategoryActivity extradownloadcategoryactivity)
    {
        return extradownloadcategoryactivity.r;
    }

    static void g(ExtraDownloadCategoryActivity extradownloadcategoryactivity)
    {
        extradownloadcategoryactivity.n();
    }

    static View h(ExtraDownloadCategoryActivity extradownloadcategoryactivity)
    {
        return extradownloadcategoryactivity.l;
    }

    static View i(ExtraDownloadCategoryActivity extradownloadcategoryactivity)
    {
        return extradownloadcategoryactivity.m;
    }

    static void j(ExtraDownloadCategoryActivity extradownloadcategoryactivity)
    {
        extradownloadcategoryactivity.s();
    }

    static void k(ExtraDownloadCategoryActivity extradownloadcategoryactivity)
    {
        extradownloadcategoryactivity.m();
    }

    static void l(ExtraDownloadCategoryActivity extradownloadcategoryactivity)
    {
        extradownloadcategoryactivity.o();
    }

    private void m()
    {
        Object obj = getIntent();
        Uri uri = ((Intent) (obj)).getData();
        if (uri != null && com.cyberlink.youcammakeup.utility.a.a(uri.toString()))
        {
            YMKLooksStoreEvent.b(com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent.Source.a.a());
            q = uri.getQueryParameter("categoryId");
            com.cyberlink.youcammakeup.utility.a.a(uri.toString(), this, ((Intent) (obj)));
            StatusManager.j().a(-1L, a);
            obj = Globals.d().t();
            if (obj != null)
            {
                ((EditViewActivity) (obj)).finish();
            }
        }
        if (getIntent().getExtras() != null)
        {
            if (q())
            {
                k = true;
                BeautifierManager.a().a(StatusManager.j().l());
            }
            j = getIntent().getLongExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", 0L);
            Object obj1 = getIntent().getStringExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_NAME");
            int i1;
            if (j == 0x15ab1bL)
            {
                d = CategoryType.b;
                if (obj1 == null || ((String) (obj1)).isEmpty())
                {
                    obj1 = getString(0x7f070502);
                }
            } else
            if (j == 0x15ab1cL)
            {
                d = CategoryType.c;
                if (obj1 == null || ((String) (obj1)).isEmpty())
                {
                    obj1 = getString(0x7f070502);
                }
            } else
            if (j == 0x15ab38L)
            {
                d = CategoryType.i;
                if (obj1 == null || ((String) (obj1)).isEmpty())
                {
                    obj1 = getString(0x7f07008c);
                }
            } else
            if (j == 0x15ab37L)
            {
                d = CategoryType.m;
                if (obj1 == null || ((String) (obj1)).isEmpty())
                {
                    obj1 = getString(0x7f0704fd);
                }
            }
            ((TextView)findViewById(0x7f0c00fb)).setText(((CharSequence) (obj1)));
            n = findViewById(0x7f0c00fe);
            l = findViewById(0x7f0c0100);
            m = findViewById(0x7f0c0101);
            if (j == 0x15ab1bL)
            {
                l.setSelected(true);
                m.setSelected(false);
                b = true;
            } else
            if (j == 0x15ab1cL)
            {
                m.setSelected(true);
                l.setSelected(false);
                b = false;
            } else
            {
                n.setVisibility(8);
            }
            s = getIntent().getBooleanExtra("KEY_EXTRA_DOWNLOAD_BACK_TO_MAIN", true);
            i1 = getIntent().getIntExtra("KEY_EXTRA_DOWNLOAD_DISPLAY_TYPE", com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.a.ordinal());
            r = com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.values()[i1];
            if (r == com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.c)
            {
                n.setVisibility(8);
            }
        }
        com.pf.common.utility.m.c("ExtraDownloadCategoryActivity", "initNetworkManager");
        Globals.d().b(this);
        e = findViewById(0x7f0c0103);
        f = (AnimatedExpandableListView)findViewById(0x7f0c0102);
        i = new ag(this);
        obj1 = new k(this, null);
        obj1.g = false;
        ((k) (obj1)).a(0.15F);
        i.a(getFragmentManager(), ((k) (obj1)));
        n();
        if (Globals.e && !Globals.d && !NetworkManager.a(this))
        {
            com.pf.common.utility.m.e("ExtraDownloadCategoryActivity", "No Google Play Services.");
        }
        if (q != null)
        {
            Globals.d().i().b(this);
        }
    }

    private void n()
    {
        e.setVisibility(8);
        android.view.View.OnClickListener onclicklistener;
        if (s)
        {
            onclicklistener = null;
        } else
        {
            onclicklistener = w;
        }
        g = new y(f.getContext(), d, Boolean.valueOf(true), h, i, y, onclicklistener, r);
        f.setAdapter(g);
    }

    private void o()
    {
        findViewById(0x7f0c00fa).setOnClickListener(u);
        findViewById(0x7f0c00fd).setOnClickListener(v);
        NetworkManager networkmanager;
        int i1;
        if (Globals.d().I())
        {
            i1 = 0;
        } else
        {
            i1 = 4;
        }
        findViewById(0x7f0c00fd).setVisibility(i1);
        f.setOnGroupClickListener(x);
        l.setOnClickListener(z);
        m.setOnClickListener(z);
        f.setOnScrollListener(A);
        networkmanager = Globals.d().w();
        if (networkmanager != null)
        {
            networkmanager.a(this);
            networkmanager.a(this);
            networkmanager.a(this);
            networkmanager.a(this);
        }
    }

    private void p()
    {
        NetworkManager networkmanager = Globals.d().w();
        if (networkmanager != null)
        {
            networkmanager.b(this);
            networkmanager.b(this);
            networkmanager.b(this);
            networkmanager.b(this);
        }
    }

    private boolean q()
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

    private void r()
    {
        Intent intent = new Intent();
        intent.setClassName("com.cyberlink.youperfect", "com.cyberlink.youperfect.activity.NoticeActivity");
        startActivity(intent);
    }

    private void s()
    {
        if (o != 0)
        {
            MotionEvent motionevent = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0);
            f.dispatchTouchEvent(motionevent);
            motionevent.recycle();
        }
        Globals.d().i().l(this);
        n();
    }

    private boolean t()
    {
        boolean flag1 = false;
        Intent intent = getIntent();
        ArrayList arraylist = intent.getStringArrayListExtra("PromoLookIds");
        boolean flag = flag1;
        if (arraylist != null)
        {
            flag = flag1;
            if (arraylist.size() > 0)
            {
                long l1 = getIntent().getLongExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", 0L);
                p.setVisibility(0);
                int i1 = getIntent().getIntExtra("KEY_EXTRA_DOWNLOAD_DISPLAY_TYPE", com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.a.ordinal());
                com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType displaymakeuptype = com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.values()[i1];
                p.setDisplayMakeupType(displaymakeuptype);
                p.a(l1, arraylist, com.cyberlink.youcammakeup.Globals.ActivityType.d, new ak() {

                    final ExtraDownloadCategoryActivity a;

                    public void a()
                    {
                        if (ExtraDownloadCategoryActivity.d(a) == null)
                        {
                            com.cyberlink.youcammakeup.activity.ExtraDownloadCategoryActivity.k(a);
                            ExtraDownloadCategoryActivity.l(a);
                        }
                    }

            
            {
                a = ExtraDownloadCategoryActivity.this;
                super();
            }
                });
                intent.removeExtra("PromoLookIds");
                flag = true;
            }
        }
        return flag;
    }

    public void a(long l1, com.cyberlink.youcammakeup.kernelctrl.networkmanager.a a1)
    {
        runOnUiThread(new Runnable(l1, a1) {

            final long a;
            final com.cyberlink.youcammakeup.kernelctrl.networkmanager.a b;
            final ExtraDownloadCategoryActivity c;

            public void run()
            {
                Iterator iterator = com.cyberlink.youcammakeup.activity.ExtraDownloadCategoryActivity.a(c, a).iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    DownloadGridItem downloadgriditem = (DownloadGridItem)iterator.next();
                    if (b != null && downloadgriditem != null)
                    {
                        if (((p)downloadgriditem.getTag()).c() != com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.c && ((p)downloadgriditem.getTag()).c() != com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.d)
                        {
                            ((p)downloadgriditem.getTag()).a(com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.c);
                            downloadgriditem.setDownloadBtnState(com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.c);
                        }
                        downloadgriditem.setProgress(af.a(b));
                    }
                } while (true);
            }

            
            {
                c = ExtraDownloadCategoryActivity.this;
                a = l1;
                b = a1;
                super();
            }
        });
    }

    public void a(long l1, bn bn)
    {
        com.pf.common.utility.m.b("ExtraDownloadCategoryActivity", (new StringBuilder()).append("[onDownloadError] ").append(bn).append(" tid: ").append(l1).toString());
        runOnUiThread(new Runnable(l1) {

            final long a;
            final ExtraDownloadCategoryActivity b;

            public void run()
            {
                Iterator iterator = com.cyberlink.youcammakeup.activity.ExtraDownloadCategoryActivity.a(b, a).iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    DownloadGridItem downloadgriditem = (DownloadGridItem)iterator.next();
                    p p1 = (p)downloadgriditem.getTag();
                    if (downloadgriditem != null && p1.c() == com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.c)
                    {
                        downloadgriditem.setDownloadBtnState(com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.e);
                        p1.a(com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.e);
                    }
                } while (true);
            }

            
            {
                b = ExtraDownloadCategoryActivity.this;
                a = l1;
                super();
            }
        });
    }

    public void b(long l1)
    {
        com.pf.common.utility.m.b("ExtraDownloadCategoryActivity", (new StringBuilder()).append("[onDownloadCancel] tid: ").append(l1).toString());
        runOnUiThread(new Runnable(l1) {

            final long a;
            final ExtraDownloadCategoryActivity b;

            public void run()
            {
                Iterator iterator = com.cyberlink.youcammakeup.activity.ExtraDownloadCategoryActivity.a(b, a).iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    DownloadGridItem downloadgriditem = (DownloadGridItem)iterator.next();
                    p p1 = (p)downloadgriditem.getTag();
                    if (downloadgriditem != null && p1.c() == com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.c)
                    {
                        downloadgriditem.setDownloadBtnState(com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.b);
                        p1.a(com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.b);
                    }
                } while (true);
            }

            
            {
                b = ExtraDownloadCategoryActivity.this;
                a = l1;
                super();
            }
        });
    }

    public void c(long l1)
    {
        com.pf.common.utility.m.b("ExtraDownloadCategoryActivity", (new StringBuilder()).append("[onDownloadComplete] tid: ").append(l1).toString());
        runOnUiThread(new Runnable(l1) {

            final long a;
            final ExtraDownloadCategoryActivity b;

            public void run()
            {
                p p1;
                for (Iterator iterator = com.cyberlink.youcammakeup.activity.ExtraDownloadCategoryActivity.a(b, a).iterator(); iterator.hasNext(); p1.a(com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.d))
                {
                    DownloadGridItem downloadgriditem = (DownloadGridItem)iterator.next();
                    p1 = (p)downloadgriditem.getTag();
                    downloadgriditem.setDownloadBtnState(com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.d);
                }

            }

            
            {
                b = ExtraDownloadCategoryActivity.this;
                a = l1;
                super();
            }
        });
    }

    public boolean e()
    {
        startActivity(new Intent(getApplicationContext(), com/cyberlink/youcammakeup/activity/MoreMakeupActivity));
        return true;
    }

    public void finish()
    {
        Globals.d().w().K().b(com.cyberlink.youcammakeup.activity.MoreMakeupActivity.a, j);
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
                    if (b1.a() == j && com.cyberlink.youcammakeup.kernelctrl.z.c(this, String.valueOf(j), Long.valueOf(0L)).longValue() < b1.c())
                    {
                        com.cyberlink.youcammakeup.kernelctrl.z.d(this, String.valueOf(j), Long.valueOf(b1.c()));
                    }
                } while (true);
            }
        }
        super.finish();
    }

    public void k()
    {
        for (int i1 = 0; i1 < g.getGroupCount(); i1++)
        {
            if (!f.isGroupExpanded(i1))
            {
                f.expandGroup(i1);
            }
            if (q == null)
            {
                continue;
            }
            long l1 = Long.parseLong(q);
            if (l1 == g.getGroupId(i1))
            {
                Globals.d().i().h(this);
                x.onGroupClick(null, null, i1, l1);
            }
        }

    }

    public void l()
    {
        e.setVisibility(0);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03000b);
        StatusManager.j().a("extraDownloadCategroyPage");
        Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.d, this);
        if (Globals.d().v() == "extraDownloadCategroyPage")
        {
            StatusManager.j().D();
        }
        p = (PromoteLooksDialog)findViewById(0x7f0c0104);
        if (!t())
        {
            m();
            o();
        }
    }

    public void onDestroy()
    {
        com.pf.common.utility.m.c("ExtraDownloadCategoryActivity", "[onDestroy]");
        super.onDestroy();
        p();
        if (g != null)
        {
            g.e();
        }
        if (i != null)
        {
            i.f();
            i.h();
        }
        Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.d, null);
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
            f();
            Globals.d().i();
            com.cyberlink.youcammakeup.utility.o.a(this);
            return true;
        } else
        {
            return super.onKeyUp(i1, keyevent);
        }
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
        com.pf.common.utility.m.b("ExtraDownloadCategoryActivity", "onNewIntent enter");
        m();
    }

    protected void onPause()
    {
        com.pf.common.utility.m.c("ExtraDownloadCategoryActivity", "[onPause]");
        super.onPause();
        Globals.d().c("extraDownloadCategroyPage");
    }

    protected void onResume()
    {
        com.pf.common.utility.m.c("ExtraDownloadCategoryActivity", "[onResume]");
        super.onResume();
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKLooksStoreEvent(com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent.Operation.a, null, null));
        Globals.d().c(null);
        StatusManager.j().C();
        String s1 = cc.a();
        if (cc.d(s1))
        {
            g.f_();
            s1 = cc.e(s1);
            cc.b();
            com.cyberlink.youcammakeup.utility.o.a(this, new e(s1), "CongratulationUnlockDialog");
        }
        if (p != null && p.getVisibility() == 0 && !t)
        {
            p.a();
        }
        t = false;
        t();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(c, StatusManager.j());
    }

    protected void onStart()
    {
        com.pf.common.utility.m.c("ExtraDownloadCategoryActivity", "[onStart]");
        super.onStart();
        StatusManager.j().a("extraDownloadCategroyPage");
        StatusManager.j().a(Boolean.valueOf(true));
    }

}
