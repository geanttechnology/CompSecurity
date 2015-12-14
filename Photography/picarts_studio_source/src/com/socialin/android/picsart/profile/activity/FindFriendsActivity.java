// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.d;
import com.socialin.android.picsart.profile.fragment.NavigationFragment;
import com.socialin.android.picsart.profile.fragment.x;
import com.socialin.android.picsart.profile.util.m;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            d, SearchActivity

public class FindFriendsActivity extends BaseActivity
    implements android.widget.RadioGroup.OnCheckedChangeListener
{

    private static final String a = com/socialin/android/picsart/profile/activity/FindFriendsActivity.getSimpleName();
    private ActionBarDrawerToggle b;
    private DrawerLayout c;
    private Runnable d;
    private m e;
    private Toolbar f;
    private boolean g;

    public FindFriendsActivity()
    {
        c = null;
        g = false;
    }

    static Toolbar a(FindFriendsActivity findfriendsactivity)
    {
        return findfriendsactivity.f;
    }

    private x a(String s)
    {
        getIntent().putExtra("friendType", s);
        FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
        Fragment fragment = getFragmentManager().findFragmentByTag("findFriendsFragmentTag");
        if (fragment != null && fragment.isAdded())
        {
            fragmenttransaction.show(fragment);
            s = (x)fragment;
            s.k();
        } else
        {
            x x1 = x.g();
            Bundle bundle = new Bundle();
            bundle.putString("friendType", s);
            x1.setArguments(bundle);
            fragmenttransaction.add(0x7f10092f, x1, "findFriendsFragmentTag");
            x1.b(findViewById(0x7f10092e));
            s = x1;
        }
        fragmenttransaction.commit();
        return s;
    }

    static Runnable b(FindFriendsActivity findfriendsactivity)
    {
        return findfriendsactivity.d;
    }

    private void b(String s)
    {
        getIntent().putExtra("friendType", s);
        Fragment fragment = getFragmentManager().findFragmentByTag("findFriendsFragmentTag");
        if (fragment != null && fragment.isAdded())
        {
            s = (x)fragment;
        } else
        {
            s = a(s);
        }
        s.k();
    }

    static Runnable c(FindFriendsActivity findfriendsactivity)
    {
        findfriendsactivity.d = null;
        return null;
    }

    public void closeNavigationBar(Runnable runnable)
    {
        if (c != null)
        {
            c.closeDrawers();
        }
        d = runnable;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        Fragment fragment;
        try
        {
            fragment = getFragmentManager().findFragmentByTag("findFriendsFragmentTag");
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            com.socialin.android.d.a(a, intent);
            return;
        }
        if (fragment == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        if (fragment instanceof x)
        {
            ((x)fragment).onActivityResult(i, j, intent);
        }
    }

    public void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        radiogroup = e.a(i);
        if (!TextUtils.isEmpty(radiogroup))
        {
            b(radiogroup);
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (b != null)
        {
            b.onConfigurationChanged(configuration);
        }
    }

    public void onCreate(Bundle bundle)
    {
        boolean flag = false;
        super.onCreate(bundle);
        setContentView(0x7f030202);
        e = new m(this);
        if (getIntent() != null)
        {
            flag = getIntent().getBooleanExtra("isTotourMode", false);
        }
        g = flag;
        ((RadioGroup)findViewById(0x7f100927)).setOnCheckedChangeListener(this);
        bundle = e.a();
        getIntent().putExtra("friendType", bundle);
        Object obj;
        FragmentTransaction fragmenttransaction;
        if (!getIntent().hasExtra("instagram_browser_action"))
        {
            obj = getFragmentManager().findFragmentByTag("findFriendsFragmentTag");
            if (obj != null && ((Fragment) (obj)).isAdded())
            {
                ((x)obj).k();
            } else
            {
                a(bundle);
            }
        }
        f = (Toolbar)findViewById(0x7f10017b);
        setSupportActionBar(f);
        bundle = getSupportActionBar();
        bundle.setHomeButtonEnabled(true);
        bundle.setDisplayHomeAsUpEnabled(true);
        bundle.setTitle(getString(0x7f0805b4));
        findViewById(0x7f1006cf).setOnTouchListener(new android.view.View.OnTouchListener() {

            public final boolean onTouch(View view, MotionEvent motionevent)
            {
                return false;
            }

        });
        bundle = getFragmentManager();
        fragmenttransaction = bundle.beginTransaction();
        obj = (NavigationFragment)bundle.findFragmentByTag("left.fragment");
        if (obj != null && ((NavigationFragment) (obj)).isAdded())
        {
            fragmenttransaction.show(((Fragment) (obj)));
            bundle = ((Bundle) (obj));
        } else
        {
            bundle = ((Bundle) (obj));
            if (obj == null)
            {
                bundle = NavigationFragment.a();
            }
            fragmenttransaction.add(0x7f1006cf, bundle, "left.fragment");
        }
        fragmenttransaction.commitAllowingStateLoss();
        bundle.a(11);
        c = (DrawerLayout)findViewById(0x7f100167);
        b = new com.socialin.android.picsart.profile.activity.d(this, this, c, 0x7f080319, 0x7f0802a4);
        c.setDrawerListener(b);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.clear();
        menu.add(0, 1, 0, getString(0x7f080343)).setIcon(0x7f020613).setShowAsAction(2);
        if (g)
        {
            String s;
            if (getSharedPreferences((new StringBuilder("sinPref_2131232944")).toString(), 0).getBoolean("find.friends.follow.done", false))
            {
                s = getString(0x7f08030a);
            } else
            {
                s = getString(0x7f08034c);
            }
            menu.add(0, 2, 0, s).setShowAsAction(2);
        }
        return true;
    }

    protected void onDestroy()
    {
        try
        {
            getSharedPreferences((new StringBuilder("sinPref_2131232944")).toString(), 0).edit().putBoolean("find.friends.follow.done", false).apply();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        super.onDestroy();
    }

    public void onFragmentFinishWithResultOK(int i)
    {
        super.onFragmentFinishWithResultOK(i);
        if ((i == 126 || i == 166 || i == 150) && !SocialinV3.getInstance().isRegistered())
        {
            finish();
        }
    }

    public void onInstagramTokenResult()
    {
        m m1 = e;
        boolean flag = m1.c.isChecked();
        if (!flag)
        {
            m1.c.setChecked(true);
        } else
        {
            m1.d.setText(m1.b.getString(0x7f0802e2));
            m1.a = 1;
        }
        if (flag)
        {
            b("instagram");
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            if (getFragmentManager().findFragmentByTag("findFriendsFragmentTag") != null)
            {
                setResult(0, new Intent());
            }
            finish();
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        int i = menuitem.getItemId();
        if (i != 0x102002c) goto _L2; else goto _L1
_L1:
        if (!c.isDrawerOpen(0x800003)) goto _L4; else goto _L3
_L3:
        c.closeDrawer(0x800003);
_L6:
        return true;
_L4:
        c.openDrawer(0x800003);
        return true;
_L2:
        if (i == 1)
        {
            menuitem = new Intent(this, com/socialin/android/picsart/profile/activity/SearchActivity);
            menuitem.putExtra("source", "find_friends");
            startActivity(menuitem);
            return true;
        }
        if (i == 2)
        {
            setResult(0);
            finish();
            return true;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void onPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
        if (b != null)
        {
            b.syncState();
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (!SocialinV3.getInstance().isRegistered())
        {
            finish();
        }
    }

}
