// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.KeyEvent;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.NetworkBaseActivity;
import com.cyberlink.youcammakeup.clflurry.YMKCostumeMakeupEvent;
import com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.f;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.g;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.h;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.i;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.pages.a.a;
import com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem;
import com.cyberlink.youcammakeup.pages.moreview.af;
import com.cyberlink.youcammakeup.pages.moreview.p;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.widgetpool.common.LockableViewPager;
import com.pf.common.utility.m;
import java.util.UUID;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LauncherActivity, LibraryPickerActivity, ExtraDownloadCategoryActivity

public class CostumeLooksPagerActivity extends NetworkBaseActivity
    implements f, g, h, i
{

    public static final UUID a = UUID.randomUUID();
    private static final String b = com/cyberlink/youcammakeup/kernelctrl/status/StatusManager.getName();
    private View c;
    private View d;
    private View e;
    private View f;
    private LockableViewPager g;
    private a h;
    private android.view.View.OnClickListener i;
    private android.view.View.OnClickListener j;
    private android.view.View.OnClickListener k;
    private android.view.View.OnClickListener l;
    private android.support.v4.view.ViewPager.OnPageChangeListener m;

    public CostumeLooksPagerActivity()
    {
        i = new android.view.View.OnClickListener() {

            final CostumeLooksPagerActivity a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.activity.CostumeLooksPagerActivity.a(a, false);
                com.cyberlink.youcammakeup.activity.CostumeLooksPagerActivity.a(a);
            }

            
            {
                a = CostumeLooksPagerActivity.this;
                super();
            }
        };
        j = new android.view.View.OnClickListener() {

            final CostumeLooksPagerActivity a;

            public void onClick(View view)
            {
                int i1 = com.cyberlink.youcammakeup.activity.CostumeLooksPagerActivity.b(a).getCurrentItem();
                com.cyberlink.youcammakeup.activity.CostumeLooksPagerActivity.b(a).setCurrentItem(i1 - 1, true);
            }

            
            {
                a = CostumeLooksPagerActivity.this;
                super();
            }
        };
        k = new android.view.View.OnClickListener() {

            final CostumeLooksPagerActivity a;

            public void onClick(View view)
            {
                int i1 = com.cyberlink.youcammakeup.activity.CostumeLooksPagerActivity.b(a).getCurrentItem();
                com.cyberlink.youcammakeup.activity.CostumeLooksPagerActivity.b(a).setCurrentItem(i1 + 1, true);
            }

            
            {
                a = CostumeLooksPagerActivity.this;
                super();
            }
        };
        l = new android.view.View.OnClickListener() {

            final CostumeLooksPagerActivity a;

            public void onClick(View view)
            {
                if (!StatusManager.j().E().booleanValue())
                {
                    return;
                } else
                {
                    YMKLooksStoreEvent.b(com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent.Source.c.a());
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKCostumeMakeupEvent(com.cyberlink.youcammakeup.clflurry.YMKCostumeMakeupEvent.Operation.c, null));
                    view = new Intent(a, com/cyberlink/youcammakeup/activity/ExtraDownloadCategoryActivity);
                    view.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", 0x15ab1cL);
                    view.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_NAME", a.getString(0x7f070502));
                    a.startActivity(view);
                    return;
                }
            }

            
            {
                a = CostumeLooksPagerActivity.this;
                super();
            }
        };
        m = new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final CostumeLooksPagerActivity a;

            public void onPageScrollStateChanged(int i1)
            {
                com.pf.common.utility.m.b("CostumeLooksPagerActivity", (new StringBuilder()).append("onPageScrollStateChanged").append(i1).toString());
                if (i1 == 1)
                {
                    com.cyberlink.youcammakeup.activity.CostumeLooksPagerActivity.b(a, true);
                } else
                if (i1 == 0)
                {
                    com.cyberlink.youcammakeup.activity.CostumeLooksPagerActivity.b(a, false);
                    return;
                }
            }

            public void onPageScrolled(int i1, float f1, int j1)
            {
                com.pf.common.utility.m.b("CostumeLooksPagerActivity", "onPageScrolled");
            }

            public void onPageSelected(int i1)
            {
                com.pf.common.utility.m.b("CostumeLooksPagerActivity", "onPageSelected");
            }

            
            {
                a = CostumeLooksPagerActivity.this;
                super();
            }
        };
    }

    static void a(CostumeLooksPagerActivity costumelookspageractivity)
    {
        costumelookspageractivity.l();
    }

    static void a(CostumeLooksPagerActivity costumelookspageractivity, boolean flag)
    {
        costumelookspageractivity.d(flag);
    }

    static LockableViewPager b(CostumeLooksPagerActivity costumelookspageractivity)
    {
        return costumelookspageractivity.g;
    }

    static void b(CostumeLooksPagerActivity costumelookspageractivity, boolean flag)
    {
        costumelookspageractivity.e(flag);
    }

    static a c(CostumeLooksPagerActivity costumelookspageractivity)
    {
        return costumelookspageractivity.h;
    }

    private DownloadGridItem d(long l1)
    {
        for (int i1 = 0; i1 < g.getChildCount(); i1++)
        {
            DownloadGridItem downloadgriditem = (DownloadGridItem)g.getChildAt(i1);
            if (((p)downloadgriditem.getTag()).b().longValue() == l1)
            {
                return (DownloadGridItem)downloadgriditem;
            }
        }

        return null;
    }

    private void d(boolean flag)
    {
        findViewById(0x7f0c00a6).setClickable(flag);
    }

    private void e(boolean flag)
    {
        if (d == null || e == null)
        {
            return;
        }
        if (flag)
        {
            d.setVisibility(4);
            e.setVisibility(4);
            return;
        }
        int i1 = g.getAdapter().getCount();
        int j1 = g.getCurrentItem();
        if (i1 <= 1)
        {
            d.setVisibility(4);
            e.setVisibility(4);
            return;
        }
        if (j1 <= 0)
        {
            d.setVisibility(4);
            e.setVisibility(0);
            return;
        }
        if (j1 >= i1 - 1)
        {
            d.setVisibility(0);
            e.setVisibility(4);
            return;
        } else
        {
            d.setVisibility(0);
            e.setVisibility(0);
            return;
        }
    }

    private void l()
    {
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKCostumeMakeupEvent(com.cyberlink.youcammakeup.clflurry.YMKCostumeMakeupEvent.Operation.d, null));
        if (isTaskRoot())
        {
            startActivity(new Intent(getApplicationContext(), com/cyberlink/youcammakeup/activity/LauncherActivity));
        }
        finish();
    }

    public void a(long l1, com.cyberlink.youcammakeup.kernelctrl.networkmanager.a a1)
    {
        DownloadGridItem downloadgriditem = d(l1);
        if (downloadgriditem != null && a1 != null)
        {
            runOnUiThread(new Runnable(downloadgriditem, a1) {

                final DownloadGridItem a;
                final com.cyberlink.youcammakeup.kernelctrl.networkmanager.a b;
                final CostumeLooksPagerActivity c;

                public void run()
                {
                    if (((p)a.getTag()).c() == com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.c)
                    {
                        a.setProgress(af.a(b));
                    }
                }

            
            {
                c = CostumeLooksPagerActivity.this;
                a = downloadgriditem;
                b = a1;
                super();
            }
            });
        }
    }

    public void a(long l1, bn bn)
    {
    }

    public void a(com.cyberlink.youcammakeup.utility.DownloadUseUtils.UseTemplate usetemplate)
    {
        LibraryPickerActivity.State state = new LibraryPickerActivity.State("editView");
        Intent intent = new Intent();
        intent.setClass(this, com/cyberlink/youcammakeup/activity/LibraryPickerActivity);
        intent.putExtra("LibraryPickerActivity_STATE", state);
        intent.putExtra("EXTRA_KEY_DOWNLOADED_TEMPLATE", usetemplate);
        startActivity(intent);
    }

    public void b(long l1)
    {
    }

    public void c(long l1)
    {
        DownloadGridItem downloadgriditem = d(l1);
        if (downloadgriditem == null || c())
        {
            return;
        } else
        {
            runOnUiThread(new Runnable(downloadgriditem) {

                final DownloadGridItem a;
                final CostumeLooksPagerActivity b;

                public void run()
                {
                    Object obj = (p)a.getTag();
                    a.setDownloadBtnState(com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.d);
                    ((p) (obj)).a(com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.d);
                    obj = CostumeLooksPagerActivity.c(b).a(((p) (obj)).a());
                    b.a(new com.cyberlink.youcammakeup.utility.DownloadUseUtils.UseTemplate(-1L, ((String) (obj)), MakeupMode.a, BeautyMode.D));
                }

            
            {
                b = CostumeLooksPagerActivity.this;
                a = downloadgriditem;
                super();
            }
            });
            return;
        }
    }

    public void c(boolean flag)
    {
        g.setPagingEnabled(flag);
        d.setEnabled(flag);
        e.setEnabled(flag);
        f.setEnabled(flag);
    }

    public void k()
    {
        e(false);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030006);
        StatusManager.j().a("costumeLooksPagerView");
        Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.m, this);
        if (Globals.d().v() == "morePage")
        {
            StatusManager.j().D();
        }
        g = (LockableViewPager)findViewById(0x7f0c00a8);
        c = findViewById(0x7f0c00a6);
        d = findViewById(0x7f0c00a9);
        e = findViewById(0x7f0c00ab);
        f = findViewById(0x7f0c00ad);
        h = new a(this);
        g.setAdapter(h);
        g.setOnPageChangeListener(m);
        c.setOnClickListener(i);
        d.setOnClickListener(j);
        e.setOnClickListener(k);
        f.setOnClickListener(l);
        e(false);
        bundle = Globals.d().w();
        if (bundle != null)
        {
            bundle.a(this);
            bundle.a(this);
            bundle.a(this);
            bundle.a(this);
        }
    }

    protected void onDestroy()
    {
        NetworkManager networkmanager = Globals.d().w();
        if (networkmanager != null)
        {
            networkmanager.b(this);
            networkmanager.b(this);
            networkmanager.b(this);
            networkmanager.b(this);
        }
        h.c();
        Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.m, null);
        super.onDestroy();
    }

    public boolean onKeyUp(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && getFragmentManager().getBackStackEntryCount() == 0 && keyevent.isTracking() && !keyevent.isCanceled())
        {
            l();
            return true;
        } else
        {
            return super.onKeyUp(i1, keyevent);
        }
    }

    protected void onPause()
    {
        super.onPause();
        Globals.d().c("costumeLooksPagerView");
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
    }

    protected void onResume()
    {
        super.onResume();
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKCostumeMakeupEvent(com.cyberlink.youcammakeup.clflurry.YMKCostumeMakeupEvent.Operation.a, null));
        Globals.d().c(null);
        d(true);
        c(true);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(b, StatusManager.j());
    }

    protected void onStart()
    {
        super.onStart();
        StatusManager.j().a("morePage");
        StatusManager.j().a(Boolean.valueOf(true));
    }

}
