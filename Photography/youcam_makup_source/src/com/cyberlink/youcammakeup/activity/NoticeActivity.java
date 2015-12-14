// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ExpandableListView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.NetworkBaseActivity;
import com.cyberlink.youcammakeup.clflurry.ap;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.flurry.YMKPageViewNoticeEvent;
import com.cyberlink.youcammakeup.flurry.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.o;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.p;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.pages.moreview.af;
import com.cyberlink.youcammakeup.pages.moreview.ah;
import java.util.UUID;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LauncherActivity

public class NoticeActivity extends NetworkBaseActivity
    implements o, p
{

    public static final UUID a = UUID.randomUUID();
    private static final String b = com/cyberlink/youcammakeup/kernelctrl/status/StatusManager.getName();
    private ExpandableListView c;
    private ah d;
    private android.view.View.OnClickListener e;

    public NoticeActivity()
    {
        e = new android.view.View.OnClickListener() {

            final NoticeActivity a;

            public void onClick(View view)
            {
                af.a(com.cyberlink.youcammakeup.Globals.ActivityType.b);
                com.cyberlink.youcammakeup.activity.NoticeActivity.b(a);
            }

            
            {
                a = NoticeActivity.this;
                super();
            }
        };
    }

    static boolean a(NoticeActivity noticeactivity)
    {
        return noticeactivity.n();
    }

    static void b(NoticeActivity noticeactivity)
    {
        noticeactivity.m();
    }

    private void k()
    {
        NetworkManager networkmanager = Globals.d().w();
        if (networkmanager != null)
        {
            networkmanager.a(this);
            networkmanager.a(this);
        }
        findViewById(0x7f0c0176).setOnClickListener(new android.view.View.OnClickListener() {

            final NoticeActivity a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.activity.NoticeActivity.a(a);
            }

            
            {
                a = NoticeActivity.this;
                super();
            }
        });
    }

    private void l()
    {
        NetworkManager networkmanager = Globals.d().w();
        if (networkmanager != null)
        {
            networkmanager.b(this);
            networkmanager.b(this);
        }
    }

    private void m()
    {
        d = new ah(this, e);
        c.setAdapter(d);
    }

    private boolean n()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (getIntent().getExtras() != null)
        {
            flag = flag1;
            if (getIntent().getExtras().containsKey("previousActivity"))
            {
                flag = flag1;
                if (getIntent().getExtras().getString("previousActivity").equals("morePage"))
                {
                    flag = true;
                }
            }
        }
        if (!flag)
        {
            Object obj = getResources().getString(0x7f070729);
            obj = (Class)getIntent().getSerializableExtra(((String) (obj)));
            if (obj != null)
            {
                startActivity(new Intent(getApplicationContext(), ((Class) (obj))));
                return true;
            } else
            {
                startActivity(new Intent(getApplicationContext(), com/cyberlink/youcammakeup/activity/LauncherActivity));
                finish();
                return true;
            }
        } else
        {
            finish();
            return true;
        }
    }

    private void o()
    {
        NetworkManager networkmanager = Globals.d().w();
        if (networkmanager != null)
        {
            networkmanager.K().b(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeItemType.b);
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030016);
        StatusManager.j().a("noticePage");
        Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.b, this);
        if (Globals.d().v() == "noticePage")
        {
            StatusManager.j().D();
        }
        if (Globals.e && !Globals.d)
        {
            if (NetworkManager.a(this));
        }
        Globals.d().b(this);
        c = (ExpandableListView)findViewById(0x7f0c0178);
        m();
        k();
    }

    public void onDestroy()
    {
        Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.b, null);
        af.a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeViewType.a);
        l();
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
            return n();
        } else
        {
            return super.onKeyUp(i, keyevent);
        }
    }

    protected void onPause()
    {
        super.onPause();
        Globals.d().c("noticePage");
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
    }

    protected void onResume()
    {
        super.onResume();
        com.cyberlink.youcammakeup.clflurry.b.a(new ap());
        com.cyberlink.youcammakeup.flurry.a.a(new YMKPageViewNoticeEvent());
        Globals.d().c(null);
        af.e(com.cyberlink.youcammakeup.Globals.ActivityType.c);
        o();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(b, StatusManager.j());
    }

    protected void onStart()
    {
        super.onStart();
        StatusManager.j().a("noticePage");
        StatusManager.j().a(Boolean.valueOf(true));
    }

}
