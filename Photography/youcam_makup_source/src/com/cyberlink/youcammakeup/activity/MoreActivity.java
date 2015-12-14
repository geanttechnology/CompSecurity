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
import android.widget.ImageView;
import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.a.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.n;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.pages.moreview.af;
import com.cyberlink.youcammakeup.utility.bc;
import com.cyberlink.youcammakeup.utility.bd;
import java.util.UUID;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LauncherActivity, NoticeActivity, MoreMakeupActivity, RecommendationActivity

public class MoreActivity extends BaseActivity
    implements n
{

    public static final UUID a = UUID.randomUUID();
    private static final String b = com/cyberlink/youcammakeup/kernelctrl/status/StatusManager.getName();
    private FrameLayout c;
    private View d;
    private a e;
    private android.view.View.OnClickListener f;
    private android.view.View.OnClickListener g;
    private android.view.View.OnClickListener h;
    private android.view.View.OnClickListener i;
    private android.view.View.OnClickListener j;

    public MoreActivity()
    {
        e = null;
        f = new android.view.View.OnClickListener() {

            final MoreActivity a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.activity.MoreActivity.a(a, false);
                view = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/NoticeActivity);
                view.putExtra("previousActivity", "morePage");
                a.startActivity(view);
            }

            
            {
                a = MoreActivity.this;
                super();
            }
        };
        g = new android.view.View.OnClickListener() {

            final MoreActivity a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.activity.MoreActivity.a(a, false);
                view = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/MoreMakeupActivity);
                a.startActivity(view);
            }

            
            {
                a = MoreActivity.this;
                super();
            }
        };
        h = new android.view.View.OnClickListener() {

            final MoreActivity a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.activity.MoreActivity.a(a, false);
                boolean flag = bd.a(a);
                if (flag)
                {
                    z.a("HAS_RATE_THIS_APP", Boolean.valueOf(flag), a);
                }
            }

            
            {
                a = MoreActivity.this;
                super();
            }
        };
        i = new android.view.View.OnClickListener() {

            final MoreActivity a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.activity.MoreActivity.a(a, false);
                view = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/RecommendationActivity);
                a.startActivity(view);
            }

            
            {
                a = MoreActivity.this;
                super();
            }
        };
        j = new android.view.View.OnClickListener() {

            final MoreActivity a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.activity.MoreActivity.a(a, false);
                com.cyberlink.youcammakeup.activity.MoreActivity.a(a);
            }

            
            {
                a = MoreActivity.this;
                super();
            }
        };
    }

    static void a(MoreActivity moreactivity)
    {
        moreactivity.j();
    }

    static void a(MoreActivity moreactivity, boolean flag)
    {
        moreactivity.b(flag);
    }

    private void b(boolean flag)
    {
        findViewById(0x7f0c016d).setClickable(flag);
        findViewById(0x7f0c016f).setClickable(flag);
        findViewById(0x7f0c0171).setClickable(flag);
        findViewById(0x7f0c016a).setClickable(flag);
    }

    private void j()
    {
        if (isTaskRoot())
        {
            startActivity(new Intent(getApplicationContext(), com/cyberlink/youcammakeup/activity/LauncherActivity));
        }
        finish();
    }

    private void k()
    {
        Object obj = Globals.d().w();
        if (obj != null)
        {
            obj = ((NetworkManager) (obj)).K();
            ((NewBadgeState) (obj)).b(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeItemType.a);
            ImageView imageview = (ImageView)findViewById(0x7f0c0170);
            if (imageview != null)
            {
                if (((NewBadgeState) (obj)).a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeItemType.c))
                {
                    imageview.setVisibility(0);
                } else
                {
                    imageview.setVisibility(4);
                }
            }
            imageview = (ImageView)findViewById(0x7f0c016e);
            if (imageview != null)
            {
                if (((NewBadgeState) (obj)).a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeItemType.b))
                {
                    imageview.setVisibility(0);
                    return;
                } else
                {
                    imageview.setVisibility(4);
                    return;
                }
            }
        }
    }

    public void l()
    {
        android.app.Activity activity = Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.a);
        af.a(activity, findViewById(0x7f0c016e), com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeItemType.b);
        af.a(activity, findViewById(0x7f0c0170), com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeItemType.c);
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030015);
        StatusManager.j().a("morePage");
        Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.a, this);
        if (Globals.d().v() == "morePage")
        {
            StatusManager.j().D();
        }
        findViewById(0x7f0c016d).setOnClickListener(f);
        findViewById(0x7f0c016f).setOnClickListener(g);
        findViewById(0x7f0c0171).setOnClickListener(h);
        if (z.a("SHOW_RECOMMENDATION", false, Globals.d()))
        {
            findViewById(0x7f0c0172).setOnClickListener(i);
        } else
        {
            findViewById(0x7f0c0172).setVisibility(8);
        }
        findViewById(0x7f0c016a).setOnClickListener(j);
        if (Globals.d().f().a().booleanValue())
        {
            c = (FrameLayout)findViewById(0x7f0c016c);
            d = findViewById(0x7f0c0173);
            e = new a();
            e.a(this, com.cyberlink.youcammakeup.flurry.ClickAdsEvent.SourceName.b);
            e.a(c, d, this);
            e.a(c);
            e.b(d);
        }
        if (Globals.e && !Globals.d)
        {
            if (NetworkManager.a(this));
        }
        Globals.d().b(this);
        bundle = Globals.d().w();
        if (bundle != null)
        {
            bundle.a(this);
        }
    }

    public void onDestroy()
    {
        Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.a, null);
        NetworkManager networkmanager = Globals.d().w();
        if (networkmanager != null)
        {
            networkmanager.b(this);
        }
        if (Globals.d().f().a().booleanValue() && e != null)
        {
            e.d(d);
            e.c(c);
        }
        super.onDestroy();
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
            j();
            return true;
        } else
        {
            return super.onKeyUp(i1, keyevent);
        }
    }

    protected void onPause()
    {
        if (Globals.d().f().a().booleanValue() && e != null)
        {
            e.c();
        }
        super.onPause();
        Globals.d().c("morePage");
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
    }

    protected void onResume()
    {
        super.onResume();
        Globals.d().c(null);
        b(true);
        if (Globals.d().f().a().booleanValue() && e != null)
        {
            e.e();
            e.b();
        }
        k();
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
