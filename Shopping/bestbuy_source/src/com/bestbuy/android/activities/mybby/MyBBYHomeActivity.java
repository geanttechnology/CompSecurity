// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.mybby;

import android.app.ActionBar;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.view.MenuItem;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import com.bestbuy.android.base.BBYApplication;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import java.util.HashMap;
import lu;
import nb;

// Referenced classes of package com.bestbuy.android.activities.mybby:
//            CIALoginFragment

public class MyBBYHomeActivity extends BBYBaseFragmentActivity
{

    private String a;
    private nb b;
    private boolean c;
    private BroadcastReceiver d;

    public MyBBYHomeActivity()
    {
        c = true;
        d = null;
    }

    public void onBackPressed()
    {
        Object obj = getSupportFragmentManager();
        android.support.v4.app.Fragment fragment = ((FragmentManager) (obj)).findFragmentById(0x7f0c0182);
        if (fragment instanceof CIALoginFragment)
        {
            obj = (CIALoginFragment)fragment;
            if (((CIALoginFragment) (obj)).b())
            {
                ((CIALoginFragment) (obj)).c();
                return;
            } else
            {
                overridePendingTransition(0x7f040005, 0x7f040008);
                finish();
                return;
            }
        }
        if (((FragmentManager) (obj)).getBackStackEntryCount() > 1)
        {
            ((FragmentManager) (obj)).popBackStack();
            return;
        } else
        {
            overridePendingTransition(0x7f040005, 0x7f040008);
            finish();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030101);
        b = nb.a();
        b.i(true);
        getActionBar().setBackgroundDrawable(new ColorDrawable(0xff00385f));
        getActionBar().setTitle("");
        getActionBar().setDisplayShowHomeEnabled(false);
        bundle = getIntent().getExtras();
        if (bundle != null && bundle.containsKey("FragmentName"))
        {
            a = bundle.getString("FragmentName");
        }
        bundle = getSupportFragmentManager().beginTransaction();
        if (a == null || a.equals("MyBBYLoginFragment"))
        {
            CIALoginFragment cialoginfragment = new CIALoginFragment();
            getActionBar().hide();
            HashMap hashmap = new HashMap();
            hashmap.put(lu.bo, "profile,login");
            hashmap.put(lu.bp, "GSI");
            lu.b(lu.v, hashmap);
            bundle.add(0x7f0c0182, cialoginfragment, "MyBBYLoginFragment");
            bundle.addToBackStack(null);
            bundle.commit();
        }
        d = new BroadcastReceiver() {

            final MyBBYHomeActivity a;

            public void onReceive(Context context, Intent intent)
            {
            }

            
            {
                a = MyBBYHomeActivity.this;
                super();
            }
        };
        LocalBroadcastManager.getInstance(this).registerReceiver(d, new IntentFilter("loginOkay"));
    }

    public void onDestroy()
    {
        super.onDestroy();
        b.i(false);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(d);
        if (!isFinishing());
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        Object obj = null;
        String s = obj;
        if ("com.bestbuy.android.NOTIFICATION".equals(intent.getAction()))
        {
            intent = intent.getExtras();
            s = obj;
            if (intent != null)
            {
                s = obj;
                if (intent.containsKey("IS_CALLED_FROM_NOTIFICATION"))
                {
                    intent.getBoolean("IS_CALLED_FROM_NOTIFICATION", false);
                    intent.getString("TAB_NAME", "");
                    s = obj;
                    if (intent.containsKey(getResources().getString(0x7f080055)))
                    {
                        s = intent.getString(getResources().getString(0x7f080055));
                    }
                }
            }
        }
        intent = new Intent(this, com/bestbuy/android/activities/home/HomeActivity);
        intent.setAction("com.bestbuy.android.NOTIFICATION");
        intent.putExtra("IS_CALLED_FROM_NOTIFICATION", true);
        intent.putExtra("TAB_NAME", "ProductTab");
        intent.setFlags(0x10000000);
        intent.addFlags(0x20000);
        intent.putExtra(getResources().getString(0x7f080055), s);
        intent.putExtra("isDod", true);
        startActivity(intent);
        finish();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            break;
        }
        if (getSupportFragmentManager().getBackStackEntryCount() <= 1)
        {
            return super.onOptionsItemSelected(menuitem);
        }
        menuitem = getSupportFragmentManager().findFragmentById(0x7f0c0182);
        if (menuitem instanceof MdotWebFragment)
        {
            menuitem = (MdotWebFragment)menuitem;
            if (menuitem.d())
            {
                menuitem.e();
            } else
            {
                getSupportFragmentManager().popBackStack();
            }
        } else
        {
            getSupportFragmentManager().popBackStack();
        }
        return true;
    }

    protected void onPause()
    {
        super.onPause();
        lu.a();
    }

    public void onResume()
    {
        super.onResume();
        lu.a(this);
    }

    public void onWindowFocusChanged(boolean flag)
    {
        if (flag && !c)
        {
            ((BBYApplication)getApplication()).setLoginOkay(false);
        }
        c = flag;
    }
}
