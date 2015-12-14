// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.NetworkBaseActivity;
import com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent;
import com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent;
import com.cyberlink.youcammakeup.clflurry.YMKTemplateStoreEvent;
import com.cyberlink.youcammakeup.clflurry.YMKTemplateStoreTypeClicksEvent;
import com.cyberlink.youcammakeup.clflurry.aq;
import com.cyberlink.youcammakeup.database.more.a;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.n;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.pages.moreview.ac;
import com.cyberlink.youcammakeup.pages.moreview.ad;
import com.cyberlink.youcammakeup.pages.moreview.ae;
import com.cyberlink.youcammakeup.pages.moreview.af;
import com.cyberlink.youcammakeup.pages.moreview.b;
import com.cyberlink.youcammakeup.utility.bc;
import com.cyberlink.youcammakeup.utility.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LauncherActivity, ExtraDownloadActivity, ExtraDownloadCategoryActivity

public class MoreMakeupActivity extends NetworkBaseActivity
    implements n, ae, b
{

    public static String a = "MakeupCategory";
    private static String f = com/cyberlink/youcammakeup/activity/MoreMakeupActivity.getName();
    protected FrameLayout b;
    protected ac c;
    protected ArrayList d;
    protected android.view.View.OnClickListener e;
    private TextView g;
    private FrameLayout h;
    private Map i;
    private View j;
    private com.cyberlink.youcammakeup.a.a k;
    private View l;
    private Map m;
    private android.view.View.OnClickListener n;

    public MoreMakeupActivity()
    {
        k = null;
        e = new android.view.View.OnClickListener() {

            final MoreMakeupActivity a;

            public void onClick(View view)
            {
                Globals.d().i().l(a);
                a.k();
            }

            
            {
                a = MoreMakeupActivity.this;
                super();
            }
        };
        n = new android.view.View.OnClickListener() {

            final MoreMakeupActivity a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.activity.MoreMakeupActivity.a(a).setClickable(false);
                com.cyberlink.youcammakeup.activity.MoreMakeupActivity.b(a);
            }

            
            {
                a = MoreMakeupActivity.this;
                super();
            }
        };
    }

    static View a(MoreMakeupActivity moremakeupactivity)
    {
        return moremakeupactivity.l;
    }

    private void b(long l1, ad ad1)
    {
        if (z.a("HAS_SET_SEEN_DOWNLOAD_CATEGORY", Globals.d()))
        {
            boolean flag = af.a(a, l1);
            a a1 = c.a(l1);
            if (a1 == null || !a1.b())
            {
                flag = false;
            }
            ad1.a(flag);
        }
    }

    static void b(MoreMakeupActivity moremakeupactivity)
    {
        moremakeupactivity.m();
    }

    private void m()
    {
        com.cyberlink.youcammakeup.utility.o.a(this);
        if (isTaskRoot())
        {
            startActivity(new Intent(getApplicationContext(), com/cyberlink/youcammakeup/activity/LauncherActivity));
            finish();
            overridePendingTransition(0x7f040004, 0x7f040005);
            return;
        } else
        {
            finish();
            return;
        }
    }

    private void n()
    {
        NetworkManager networkmanager = Globals.d().w();
        if (networkmanager == null)
        {
            return;
        } else
        {
            networkmanager.K().b(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeItemType.c);
            return;
        }
    }

    private void p()
    {
        NetworkManager networkmanager = Globals.d().w();
        if (networkmanager != null)
        {
            networkmanager.a(this);
        }
    }

    private void q()
    {
        NetworkManager networkmanager = Globals.d().w();
        if (networkmanager != null)
        {
            networkmanager.b(this);
        }
    }

    private void r()
    {
        g = (TextView)findViewById(0x7f0c015b);
        g.setText(0x7f070507);
        l = findViewById(0x7f0c015a);
        l.setOnClickListener(n);
        b = (FrameLayout)findViewById(0x7f0c015e);
        m = new HashMap();
        d = new ArrayList();
        k();
        t();
    }

    private void s()
    {
        if (c != null)
        {
            c.b(this);
            c.c();
            c = null;
        }
        if (d != null)
        {
            d.clear();
            d = null;
        }
        if (m != null)
        {
            m.clear();
            m = null;
        }
    }

    private void t()
    {
        if (b == null)
        {
            return;
        } else
        {
            i = new HashMap();
            i.put(Long.valueOf(0x15ab1bL), Integer.valueOf(0x7f0c015f));
            i.put(Long.valueOf(0x15ab1cL), Integer.valueOf(0x7f0c0160));
            i.put(Long.valueOf(0x15ab16L), Integer.valueOf(0x7f0c0161));
            i.put(Long.valueOf(0x15ab18L), Integer.valueOf(0x7f0c0162));
            i.put(Long.valueOf(0x15ab19L), Integer.valueOf(0x7f0c0163));
            i.put(Long.valueOf(0x15ab32L), Integer.valueOf(0x7f0c0164));
            i.put(Long.valueOf(0x15ab38L), Integer.valueOf(0x7f0c0165));
            i.put(Long.valueOf(0x15ab37L), Integer.valueOf(0x7f0c0166));
            return;
        }
    }

    public void a(long l1, int i1)
    {
        if (b == null)
        {
            return;
        } else
        {
            int j1 = ((Integer)i.get(Long.valueOf(l1))).intValue();
            b.findViewById(j1).setVisibility(i1);
            return;
        }
    }

    public void a(long l1, ad ad1)
    {
        b(l1, ad1);
    }

    public void a(ad ad1)
    {
        long l1 = ad1.b();
        long l2 = System.currentTimeMillis();
        String s1;
        Object obj;
        if (l1 == 0x15ab32L)
        {
            ad1 = CategoryType.o;
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKTemplateStoreEvent(com.cyberlink.youcammakeup.clflurry.YMKTemplateStoreEvent.Feature.e, YMKTemplateStoreEvent.b, l2));
        } else
        if (l1 == 0x15ab16L)
        {
            ad1 = CategoryType.d;
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKTemplateStoreTypeClicksEvent(com.cyberlink.youcammakeup.clflurry.YMKTemplateStoreTypeClicksEvent.TypeName.c));
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKTemplateStoreEvent(com.cyberlink.youcammakeup.clflurry.YMKTemplateStoreEvent.Feature.d, YMKTemplateStoreEvent.b, l2));
        } else
        if (l1 == 0x15ab18L)
        {
            ad1 = CategoryType.e;
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKTemplateStoreTypeClicksEvent(com.cyberlink.youcammakeup.clflurry.YMKTemplateStoreTypeClicksEvent.TypeName.d));
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKTemplateStoreEvent(com.cyberlink.youcammakeup.clflurry.YMKTemplateStoreEvent.Feature.c, YMKTemplateStoreEvent.b, l2));
        } else
        if (l1 == 0x15ab19L)
        {
            ad1 = CategoryType.f;
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKTemplateStoreTypeClicksEvent(com.cyberlink.youcammakeup.clflurry.YMKTemplateStoreTypeClicksEvent.TypeName.e));
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKTemplateStoreEvent(com.cyberlink.youcammakeup.clflurry.YMKTemplateStoreEvent.Feature.f, YMKTemplateStoreEvent.b, l2));
        } else
        if (l1 == 0x15ab1bL)
        {
            ad1 = CategoryType.b;
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKTemplateStoreTypeClicksEvent(com.cyberlink.youcammakeup.clflurry.YMKTemplateStoreTypeClicksEvent.TypeName.a));
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKTemplateStoreEvent(com.cyberlink.youcammakeup.clflurry.YMKTemplateStoreEvent.Feature.a, YMKTemplateStoreEvent.b, l2));
        } else
        if (l1 == 0x15ab38L)
        {
            ad1 = CategoryType.i;
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKTemplateStoreTypeClicksEvent(com.cyberlink.youcammakeup.clflurry.YMKTemplateStoreTypeClicksEvent.TypeName.f));
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKTemplateStoreEvent(com.cyberlink.youcammakeup.clflurry.YMKTemplateStoreEvent.Feature.h, YMKTemplateStoreEvent.b, l2));
        } else
        if (l1 == 0x15ab37L)
        {
            ad1 = CategoryType.m;
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKTemplateStoreTypeClicksEvent(com.cyberlink.youcammakeup.clflurry.YMKTemplateStoreTypeClicksEvent.TypeName.g));
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKTemplateStoreEvent(com.cyberlink.youcammakeup.clflurry.YMKTemplateStoreEvent.Feature.g, YMKTemplateStoreEvent.b, l2));
        } else
        {
            ad1 = CategoryType.c;
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKTemplateStoreTypeClicksEvent(com.cyberlink.youcammakeup.clflurry.YMKTemplateStoreTypeClicksEvent.TypeName.b));
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKTemplateStoreEvent(com.cyberlink.youcammakeup.clflurry.YMKTemplateStoreEvent.Feature.b, YMKTemplateStoreEvent.b, l2));
        }
        s1 = ((com.cyberlink.youcammakeup.database.more.makeup.a)c.e().get(Long.valueOf(l1))).b();
        obj = Globals.d().w();
        if (obj == null)
        {
            return;
        }
        ((NetworkManager) (obj)).K().b(a, l1);
        boolean flag1 = false;
        obj = (com.cyberlink.youcammakeup.database.more.makeup.b)c.a(l1);
        Long long1 = z.c(this, String.valueOf(l1), Long.valueOf(0L));
        boolean flag = flag1;
        if (obj != null)
        {
            flag = flag1;
            if (long1.longValue() < ((com.cyberlink.youcammakeup.database.more.makeup.b) (obj)).c())
            {
                flag = true;
                z.d(this, String.valueOf(l1), Long.valueOf(((com.cyberlink.youcammakeup.database.more.makeup.b) (obj)).c()));
            }
        }
        obj = new Intent(getApplicationContext(), com/cyberlink/youcammakeup/activity/ExtraDownloadActivity);
        if (l1 == 0x15ab1bL || l1 == 0x15ab1cL || l1 == 0x15ab38L || l1 == 0x15ab37L)
        {
            if (l1 == 0x15ab1bL)
            {
                YMKLooksStoreEvent.b(com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent.Source.b.a());
            } else
            if (l1 == 0x15ab1cL)
            {
                YMKLooksStoreEvent.b(com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent.Source.c.a());
            }
            ((Intent) (obj)).setClass(getApplicationContext(), com/cyberlink/youcammakeup/activity/ExtraDownloadCategoryActivity);
            ((Intent) (obj)).putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", l1);
            ((Intent) (obj)).putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_TYPE", ad1);
            ((Intent) (obj)).putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_NAME", s1);
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKLauncherEvent(com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent.TileType.c, com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent.Operation.b));
        } else
        {
            ((Intent) (obj)).setClass(getApplicationContext(), com/cyberlink/youcammakeup/activity/ExtraDownloadActivity);
            ((Intent) (obj)).putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", l1);
            ((Intent) (obj)).putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_TYPE", ad1);
            ((Intent) (obj)).putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_NAME", s1);
            ((Intent) (obj)).putExtra("KEY_EXTRA_DOWNLOAD_IS_LAST_MODIFIED_CHANGED", flag);
        }
        startActivity(((Intent) (obj)));
    }

    protected void k()
    {
        if (c != null)
        {
            c.b(this);
            c.c();
            c = null;
        }
        c = new ac(this, e, com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.a);
        c.a(this);
    }

    public void l()
    {
        for (int i1 = 0; i1 < d.size(); i1++)
        {
            long l1 = ((Long)d.get(i1)).longValue();
            if (m.containsKey(Long.valueOf(l1)))
            {
                b(l1, (ad)m.get(Long.valueOf(l1)));
            }
        }

    }

    public void o()
    {
        if (b != null && m.isEmpty() && !b())
        {
            Long long1;
            for (Iterator iterator = i.keySet().iterator(); iterator.hasNext(); d.add(long1))
            {
                long1 = (Long)iterator.next();
                int i1 = ((Integer)i.get(long1)).intValue();
                ad ad1 = new ad((RelativeLayout)b.findViewById(i1));
                ad1.a(long1.longValue());
                ad1.a(this);
                m.put(long1, ad1);
            }

            c.a(m);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        setContentView(0x7f030014);
        StatusManager.j().a("makeupCategoryActivity");
        Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.l, this);
        if (Globals.d().v() == "makeupCategoryActivity")
        {
            StatusManager.j().D();
        }
        r();
        p();
        super.onCreate(bundle);
    }

    public void onDestroy()
    {
        Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.l, null);
        q();
        if (Globals.d().f().a().booleanValue() && k != null)
        {
            k.d(j);
            k.c(h);
        }
        s();
        super.onDestroy();
    }

    public boolean onKeyUp(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && getFragmentManager().getBackStackEntryCount() == 0 && keyevent.isTracking() && !keyevent.isCanceled())
        {
            m();
            return true;
        } else
        {
            return super.onKeyUp(i1, keyevent);
        }
    }

    protected void onPause()
    {
        Globals.d().c("makeupCategoryActivity");
        StatusManager.j().C();
        z.a("HAS_SET_SEEN_DOWNLOAD_CATEGORY", Boolean.valueOf(true), Globals.d());
        if (Globals.d().f().a().booleanValue() && k != null)
        {
            k.c();
        }
        super.onPause();
    }

    public void onResume()
    {
        Globals.d().c(null);
        super.onResume();
        YMKTemplateStoreEvent.b = System.currentTimeMillis();
        com.cyberlink.youcammakeup.clflurry.b.a(new aq());
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKTemplateStoreEvent(com.cyberlink.youcammakeup.clflurry.YMKTemplateStoreEvent.Operation.a));
        n();
        StatusManager.j().C();
        l();
        if (Globals.d().f().a().booleanValue() && k != null)
        {
            k.e();
            k.b();
        }
    }

}
