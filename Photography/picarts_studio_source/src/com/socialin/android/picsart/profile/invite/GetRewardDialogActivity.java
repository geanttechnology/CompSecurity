// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.invite;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.appboy.Appboy;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.request.e;
import com.socialin.android.activity.AdBaseActivity;
import com.socialin.android.ads.SocialinAdManager;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.apiv3.util.Inventory;
import com.socialin.android.constants.EventParam;
import com.socialin.android.util.Utils;
import com.socialin.android.util.f;
import myobfuscated.cs.d;

// Referenced classes of package com.socialin.android.picsart.profile.invite:
//            i

public class GetRewardDialogActivity extends AdBaseActivity
    implements android.view.View.OnClickListener, d
{

    private static boolean c = false;
    private static boolean d = false;
    private SharedPreferences a;
    private e b;
    private String e;
    private f f;

    public GetRewardDialogActivity()
    {
        e = EventParam.MAIN_DIALOG.getName();
    }

    private void a()
    {
        if (!c)
        {
            if (!a.contains("invite.redeem.suspend.start.time"))
            {
                com.socialin.android.picsart.profile.invite.i.d(this);
            } else
            if (!d)
            {
                AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.InviteFlowLaterEvent());
                return;
            }
        }
    }

    private void b()
    {
        if (SocialinV3.getInstance().isRegistered())
        {
            if (!Inventory.isAdsEnabled() || !Inventory.isEditorAdsEnabled())
            {
                com.socialin.android.picsart.profile.invite.i.e(this);
                a(true);
                return;
            } else
            {
                findViewById(0x7f1006a1).setEnabled(false);
                i.a(this, e, this);
                return;
            }
        } else
        {
            i.a(this, 1122, com.socialin.android.constants.CommonConstants.InviteMode.AD_REMOVER, EventParam.MAIN_DIALOG.getName());
            return;
        }
    }

    public final void a(boolean flag)
    {
        if (flag)
        {
            c = true;
            setResult(-1, new Intent());
            finish();
            return;
        } else
        {
            findViewById(0x7f1006a1).setEnabled(true);
            return;
        }
    }

    public final void f()
    {
    }

    protected ViewGroup getAdLayout()
    {
        return (FrameLayout)findViewById(0x7f100128);
    }

    protected boolean initAd()
    {
        ViewGroup viewgroup;
        boolean flag;
label0:
        {
            viewgroup = getAdLayout();
            if (viewgroup != null)
            {
                if (!Inventory.isEditorAdsEnabled())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (Inventory.isAdsEnabled())
                {
                    break label0;
                }
                viewgroup.setVisibility(8);
            }
            return false;
        }
        if (flag)
        {
            hideAdWithAnimation();
            return false;
        } else
        {
            viewgroup.setVisibility(0);
            SocialinAdManager.a(viewgroup, this, getString(0x7f08094a), false);
            return true;
        }
    }

    protected void onActivityResult(int j, int k, Intent intent)
    {
        super.onActivityResult(j, k, intent);
        if (k == -1 && j == 1122 || k == 126 || k == 150)
        {
            b();
        }
    }

    public void onBackPressed()
    {
        a();
        super.onBackPressed();
    }

    public void onClick(View view)
    {
        if (view.getId() == 0x7f10069f)
        {
            d = true;
            a();
            finish();
        } else
        if (view.getId() == 0x7f1006a1)
        {
            b();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getWindow().setFlags(32, 32);
        getWindow().setFlags(0x40000, 0x40000);
        setContentView(0x7f030140);
        d = false;
        c = false;
        Appboy.getInstance(this).logCustomEvent("Invite_Flow_Notified");
        a = i.a(getApplicationContext());
        bundle = a.edit();
        bundle.putBoolean("invite.redeem.reminder.notification.snoozed", false);
        bundle.putBoolean("redeem_reminder_worked", false);
        bundle.putBoolean("invite_reminder_worked", false);
        bundle.remove("invite.flow.snoozed");
        bundle.apply();
        TextView textview;
        Object obj;
        Object obj1;
        boolean flag;
        boolean flag1;
        if (a.contains("invite.redeem.suspend.start.time") || a.contains("invite_new_user_snoozed"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            a.edit().putLong("invite.flow.start.time", System.currentTimeMillis()).apply();
        }
        if (getIntent() != null)
        {
            flag1 = getIntent().getBooleanExtra("new_user_flow", false);
        } else
        {
            flag1 = false;
        }
        obj = findViewById(0x7f10069f);
        bundle = (Button)findViewById(0x7f1006a1);
        textview = (TextView)findViewById(0x7f10069d);
        findViewById(0x7f10069a).setVisibility(8);
        f = new f(getApplicationContext());
        obj1 = findViewById(0x7f10069e);
        if (Utils.m(this) || flag1)
        {
            ((View) (obj1)).setVisibility(8);
            findViewById(0x7f1006a0).setVisibility(8);
            bundle.setText(0x7f0803c4);
            textview.setText(0x7f0803a3);
            findViewById(0x7f1006a2).setPadding(0, 0, (int)Utils.a(160F, this), 0);
        } else
        {
            if (flag)
            {
                ((View) (obj1)).setVisibility(8);
                findViewById(0x7f1006a0).setVisibility(8);
                bundle.setText(0x7f0803c5);
                findViewById(0x7f1006a2).setPadding(0, 0, (int)Utils.a(160F, this), 0);
                e = EventParam.REMINDER_DIALOG.getName();
            } else
            {
                ((View) (obj1)).setVisibility(0);
                findViewById(0x7f1006a0).setVisibility(0);
                bundle.setText(0x7f0803c2);
                ((View) (obj)).setOnClickListener(this);
            }
            if (a.getLong("inviter_id", -1L) > 0L)
            {
                if (b == null)
                {
                    b = (e)((e)com.bumptech.glide.request.e.b(l.e).b(0x7f020669)).a(0x7f020669);
                }
                findViewById(0x7f10069a).setVisibility(0);
                obj = a.getString("inviter_name", "");
                obj1 = a.getString("inviter_image", "");
                if (obj != null)
                {
                    ((TextView)findViewById(0x7f10069c)).setText(((CharSequence) (obj)));
                }
                if (obj1 != null)
                {
                    f.a(((String) (obj1)), (ImageView)findViewById(0x7f10069b), b, null);
                }
                textview.setText(0x7f0803a3);
            }
            textview.setText(0x7f0803a4);
        }
        bundle.setOnClickListener(this);
        initAd();
    }

    public void onFragmentFinishWithResultOK(int j)
    {
        super.onFragmentFinishWithResultOK(j);
        if (j == 150 || j == 126)
        {
            b();
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (4 == motionevent.getAction())
        {
            a();
            finish();
            return true;
        } else
        {
            return super.onTouchEvent(motionevent);
        }
    }

}
