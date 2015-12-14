// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.clflurry.YMKPageViewMakeupTipeEvent;
import com.cyberlink.youcammakeup.clflurry.ah;
import com.cyberlink.youcammakeup.flurry.PopularityOfVideoCategoriesEvent;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.n;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.pages.moreview.BeautyCategoryItem;
import com.cyberlink.youcammakeup.pages.moreview.a;
import com.cyberlink.youcammakeup.pages.moreview.af;
import com.cyberlink.youcammakeup.pages.moreview.b;
import com.cyberlink.youcammakeup.pages.moreview.c;
import com.cyberlink.youcammakeup.pages.moreview.f;
import com.cyberlink.youcammakeup.pages.moreview.j;
import java.util.ArrayList;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            CategoryBaseActivity, BeautyTipFilmActivity, LauncherActivity

public class BeautyTipCategoryActivity extends CategoryBaseActivity
    implements n, b, c
{

    public static String a = "BeautyCategory";

    public BeautyTipCategoryActivity()
    {
    }

    private void b(long l1, BeautyCategoryItem beautycategoryitem)
    {
        Globals.d(new Runnable(l1, beautycategoryitem) {

            final long a;
            final BeautyCategoryItem b;
            final BeautyTipCategoryActivity c;

            public void run()
            {
                if (c.b == null)
                {
                    return;
                }
                boolean flag = af.a(com.cyberlink.youcammakeup.activity.BeautyTipCategoryActivity.a, a);
                com.cyberlink.youcammakeup.database.more.a.a a1 = (com.cyberlink.youcammakeup.database.more.a.a)c.b.a(a);
                if (a1 == null || !a1.b())
                {
                    flag = false;
                }
                b.a(flag);
            }

            
            {
                c = BeautyTipCategoryActivity.this;
                a = l1;
                b = beautycategoryitem;
                super();
            }
        });
    }

    private com.cyberlink.youcammakeup.clflurry.YMKPageViewMakeupTipeEvent.SourceName p()
    {
        Intent intent = (Intent)getIntent().getParcelableExtra(getResources().getString(0x7f07072a));
        if (intent != null && intent.getData() != null && intent.getData().getScheme().equalsIgnoreCase(getResources().getString(0x7f070791)))
        {
            return com.cyberlink.youcammakeup.clflurry.YMKPageViewMakeupTipeEvent.SourceName.b;
        } else
        {
            return com.cyberlink.youcammakeup.clflurry.YMKPageViewMakeupTipeEvent.SourceName.a;
        }
    }

    private void q()
    {
        NetworkManager networkmanager = Globals.d().w();
        if (networkmanager == null)
        {
            return;
        } else
        {
            networkmanager.K().b(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeItemType.d);
            return;
        }
    }

    private void r()
    {
        NetworkManager networkmanager = Globals.d().w();
        if (networkmanager != null)
        {
            networkmanager.a(this);
        }
    }

    private void s()
    {
        NetworkManager networkmanager = Globals.d().w();
        if (networkmanager != null)
        {
            networkmanager.b(this);
        }
    }

    protected void a(long l1, BeautyCategoryItem beautycategoryitem)
    {
        b(l1, beautycategoryitem);
    }

    protected void a(View view)
    {
        f();
    }

    public void a(BeautyCategoryItem beautycategoryitem)
    {
        long l1 = beautycategoryitem.getCategoryItemId();
        beautycategoryitem = ((j)b.d().get(Long.valueOf(l1))).c();
        com.cyberlink.youcammakeup.flurry.a.a(new PopularityOfVideoCategoriesEvent(String.valueOf(l1)));
        com.cyberlink.youcammakeup.clflurry.b.a(new ah(l1));
        Object obj = Globals.d().w();
        if (obj == null)
        {
            return;
        }
        ((NetworkManager) (obj)).K().b(a, l1);
        boolean flag1 = false;
        obj = (com.cyberlink.youcammakeup.database.more.a.a)b.a(l1);
        Long long1 = z.a(this, String.valueOf(l1), Long.valueOf(0L));
        boolean flag = flag1;
        if (obj != null)
        {
            flag = flag1;
            if (long1.longValue() < ((com.cyberlink.youcammakeup.database.more.a.a) (obj)).c())
            {
                flag = true;
                z.b(this, String.valueOf(l1), Long.valueOf(((com.cyberlink.youcammakeup.database.more.a.a) (obj)).c()));
            }
        }
        obj = new Intent(getApplicationContext(), com/cyberlink/youcammakeup/activity/BeautyTipFilmActivity);
        ((Intent) (obj)).putExtra("previousActivity", "beautyTipCategoryPage");
        ((Intent) (obj)).putExtra("categoryId", l1);
        ((Intent) (obj)).putExtra("categoryName", beautycategoryitem);
        ((Intent) (obj)).putExtra("lastModifiedChanged", flag);
        startActivity(((Intent) (obj)));
    }

    protected void b(View view)
    {
        af.a(com.cyberlink.youcammakeup.Globals.ActivityType.i);
    }

    public boolean d()
    {
        Intent intent = getIntent();
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        Class class1 = (Class)intent.getSerializableExtra(getResources().getString(0x7f070729));
        if (class1 == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        startActivity(new Intent(getApplicationContext(), class1));
        return true;
        intent = (Intent)intent.getParcelableExtra(getResources().getString(0x7f07072a));
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        startActivity(intent);
        return true;
        Exception exception;
        exception;
        exception.printStackTrace();
        return false;
    }

    public boolean e()
    {
        startActivity(new Intent(getApplicationContext(), com/cyberlink/youcammakeup/activity/LauncherActivity));
        return true;
    }

    protected void k()
    {
        if (b != null)
        {
            b.b(this);
            b.b();
            b = null;
        }
        b = new f(this, f);
        b.a(this);
        if (NetworkManager.L())
        {
            b.f();
        }
    }

    public void l()
    {
        for (int i = 0; i < d.size(); i++)
        {
            long l1 = ((Long)d.get(i)).longValue();
            if (e.containsKey(Long.valueOf(l1)))
            {
                b(l1, (BeautyCategoryItem)e.get(Long.valueOf(l1)));
            }
        }

    }

    protected View m()
    {
        return findViewById(0x7f0c0080);
    }

    protected FrameLayout n()
    {
        return (FrameLayout)findViewById(0x7f0c0082);
    }

    protected void onCreate(Bundle bundle)
    {
        setContentView(0x7f030003);
        StatusManager.j().a("beautyTipCategoryPage");
        Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.i, this);
        r();
        super.onCreate(bundle);
    }

    public void onDestroy()
    {
        Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.i, null);
        af.a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeViewType.b);
        s();
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4 && keyevent.getRepeatCount() == 0)
        {
            keyevent.startTracking();
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        if (i == 4 && getFragmentManager().getBackStackEntryCount() == 0 && keyevent.isTracking() && !keyevent.isCanceled())
        {
            f();
            return true;
        } else
        {
            return super.onKeyUp(i, keyevent);
        }
    }

    protected void onPause()
    {
        Globals.d().c("beautyTipCategoryActivity");
        StatusManager.j().C();
        super.onPause();
    }

    public void onResume()
    {
        Globals.d().c(null);
        super.onResume();
        af.e(com.cyberlink.youcammakeup.Globals.ActivityType.i);
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKPageViewMakeupTipeEvent(p()));
        o();
        q();
        if (d != null && d.size() > 0)
        {
            for (int i = 0; i < d.size(); i++)
            {
                long l1 = ((Long)d.get(i)).longValue();
                if (e.containsKey(Long.valueOf(l1)))
                {
                    b(l1, (BeautyCategoryItem)e.get(Long.valueOf(l1)));
                }
            }

        }
    }

}
