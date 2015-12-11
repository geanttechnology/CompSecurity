// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.stores;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import lu;
import nb;

// Referenced classes of package com.bestbuy.android.activities.stores:
//            StoreDetailsFragment

public class StoresDetailsActivity extends BBYBaseFragmentActivity
{

    private String a;
    private nb b;

    public StoresDetailsActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030101);
        getActionBar().setBackgroundDrawable(new ColorDrawable(0xff00385f));
        getActionBar().setHomeAsUpIndicator(0x7f020002);
        b = nb.a();
        b.c("Foreground");
        Bundle bundle1 = getIntent().getExtras();
        if (bundle1 != null && bundle1.containsKey("STORE"))
        {
            a = bundle1.getString("STORE");
        }
        if (bundle == null)
        {
            bundle = new StoreDetailsFragment(a, false);
            getSupportFragmentManager().beginTransaction().add(0x7f0c0182, bundle).commit();
        }
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
        if (getSupportFragmentManager().getBackStackEntryCount() == 0)
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
}
