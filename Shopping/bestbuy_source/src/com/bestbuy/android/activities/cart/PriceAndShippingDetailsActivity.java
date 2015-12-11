// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.cart;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import lu;
import nb;

public class PriceAndShippingDetailsActivity extends BBYBaseFragmentActivity
{

    private String a;
    private nb b;
    private ImageView c;

    public PriceAndShippingDetailsActivity()
    {
    }

    public void onBackPressed()
    {
        FragmentManager fragmentmanager = getSupportFragmentManager();
        if (fragmentmanager.getBackStackEntryCount() > 1)
        {
            fragmentmanager.popBackStack();
            return;
        } else
        {
            finish();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300c4);
        c = (ImageView)findViewById(0x7f0c0067);
        c.setOnClickListener(new android.view.View.OnClickListener() {

            final PriceAndShippingDetailsActivity a;

            public void onClick(View view)
            {
                a.finish();
                a.overridePendingTransition(0x7f040005, 0x7f040008);
            }

            
            {
                a = PriceAndShippingDetailsActivity.this;
                super();
            }
        });
        b = nb.a();
        getActionBar().setBackgroundDrawable(new ColorDrawable(0xff00385f));
        getActionBar().setTitle("");
        getActionBar().setHomeAsUpIndicator(0x7f020002);
        getActionBar().setDisplayShowHomeEnabled(false);
        Object obj = getIntent().getExtras();
        if (obj != null && ((Bundle) (obj)).containsKey("FragmentName"))
        {
            a = ((Bundle) (obj)).getString("FragmentName");
        }
        bundle = getSupportFragmentManager().beginTransaction();
        if (a.equals("MdotWebFragment") && ((Bundle) (obj)).containsKey("lowPrice"))
        {
            obj = new MdotWebFragment();
            Bundle bundle1 = new Bundle();
            bundle1.putString("mDotURL", b.i());
            ((BBYBaseFragment) (obj)).setArguments(bundle1);
            getActionBar().hide();
            bundle.add(0x7f0c0182, ((android.support.v4.app.Fragment) (obj)), "MdotWebFragment");
            bundle.addToBackStack(null);
            bundle.commit();
        } else
        if (a.equals("MdotWebFragment") && ((Bundle) (obj)).containsKey("freeShip"))
        {
            MdotWebFragment mdotwebfragment = new MdotWebFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putString("mDotURL", b.j());
            mdotwebfragment.setArguments(bundle2);
            getActionBar().hide();
            bundle.add(0x7f0c0182, mdotwebfragment, "MdotWebFragment");
            bundle.addToBackStack(null);
            bundle.commit();
            return;
        }
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
