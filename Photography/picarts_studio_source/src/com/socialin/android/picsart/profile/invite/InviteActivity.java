// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.invite;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.MenuItem;
import android.view.View;
import com.appboy.Appboy;
import com.picsart.studio.view.SlidingTabLayout;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.constants.EventParam;
import com.socialin.android.picsart.profile.adapter.ap;
import com.socialin.android.picsart.profile.fragment.l;
import com.socialin.android.picsart.profile.fragment.m;
import java.util.List;
import myobfuscated.cs.d;
import myobfuscated.cy.a;

// Referenced classes of package com.socialin.android.picsart.profile.invite:
//            f, i

public class InviteActivity extends AppCompatActivity
    implements d
{

    private SharedPreferences a;
    private ViewPager b;
    private int c;
    private ActionBar d;
    private boolean e;

    public InviteActivity()
    {
        e = false;
    }

    static int a(InviteActivity inviteactivity, int j)
    {
        inviteactivity.c = j;
        return j;
    }

    private void a(Bundle bundle)
    {
        b = (ViewPager)findViewById(0x7f1009a4);
        SlidingTabLayout slidingtablayout = (SlidingTabLayout)findViewById(0x7f1009a3);
        if (bundle != null)
        {
            c = bundle.getInt("selected_tab");
        }
        slidingtablayout.setOnPageChangeListener(new android.support.v4.view.ViewPager.SimpleOnPageChangeListener() {

            private InviteActivity a;

            public final void onPageSelected(int j)
            {
                super.onPageSelected(j);
                com.socialin.android.picsart.profile.invite.InviteActivity.a(a, j);
            }

            
            {
                a = InviteActivity.this;
                super();
            }
        });
        bundle = new ap(getFragmentManager());
        l l1 = new l();
        l1.d = this;
        m m1 = new m();
        m1.d = this;
        bundle.a(l1, getString(0x7f0802bf).toUpperCase(), 0x7f100082);
        bundle.a(m1, getString(0x7f080356).toUpperCase(), 0x7f100083);
        b.setAdapter(bundle);
        b.setCurrentItem(c);
        b.setVisibility(0);
        slidingtablayout.setViewPager(b);
        slidingtablayout.a(c).setSelected(true);
    }

    public final void a(boolean flag)
    {
    }

    public final void f()
    {
        if (e)
        {
            int j = a.getInt("invite_send_count_ad_remover", 0);
            a.edit().putInt("invite_send_count_ad_remover", j + 1).apply();
            return;
        } else
        {
            SharedPreferences sharedpreferences = i.b(getApplicationContext());
            int k = sharedpreferences.getInt("invite_send_count_drawer", 0);
            sharedpreferences.edit().putInt("invite_send_count_drawer", k + 1).apply();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030211);
        a = com.socialin.android.picsart.profile.invite.i.a(getApplicationContext());
        e = "ad_remover".equals(i.e());
        TelephonyManager telephonymanager;
        boolean flag;
        if (e)
        {
            a.edit().putBoolean("invite.reminder.notification.snoozed", false).apply();
            Appboy.getInstance(this).logCustomEvent("Invite_Flow_InviteFriend_Began");
            String s = getIntent().getStringExtra("from");
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.InviteFlowInviteScreenOpenEvent(s));
        } else
        {
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.InviteFlowInviteScreenOpenEvent(EventParam.DRAWER.getName()));
        }
        if (getSupportActionBar() != null)
        {
            d = getSupportActionBar();
            d.setDisplayHomeAsUpEnabled(true);
            d.setDisplayShowHomeEnabled(false);
            d.setTitle(0x7f0802e8);
        }
        i.b(null);
        flag = i.r(this);
        telephonymanager = (TelephonyManager)getSystemService("phone");
        if (telephonymanager.getSimState() != 1 && telephonymanager.getSimState() != 0)
        {
            if (flag)
            {
                i.b("com.google.android.talk");
            }
            a(bundle);
        } else
        if (flag)
        {
            i.b("com.google.android.talk");
            a(bundle);
        } else
        {
            bundle = new l();
            bundle.d = this;
            getFragmentManager().beginTransaction().replace(0x7f10013a, bundle).commit();
        }
        myobfuscated.cy.a.c(getApplicationContext());
    }

    protected void onDestroy()
    {
        if (b != null && b.getAdapter() != null)
        {
            ap ap1 = (ap)b.getAdapter();
            ap1.a.clear();
            ap1.notifyDataSetChanged();
        }
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            if (e)
            {
                Appboy.getInstance(this).logCustomEvent("Invite_Flow_InviteFriend_Snoozed");
            }
            finish();
        }
        return true;
    }

    protected void onResume()
    {
        super.onResume();
        if (b != null && b.getAdapter() != null)
        {
            ((f)((ap)b.getAdapter()).getItem(c)).d = this;
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        Bundle bundle1;
        if (bundle != null)
        {
            bundle1 = bundle;
        } else
        {
            bundle1 = new Bundle();
        }
        bundle1.putInt("selected_tab", c);
        super.onSaveInstanceState(bundle);
    }
}
