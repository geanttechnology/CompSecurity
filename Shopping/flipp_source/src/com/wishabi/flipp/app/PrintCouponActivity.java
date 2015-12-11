// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.bd;
import android.support.v4.app.dd;
import android.view.MenuItem;
import android.widget.FrameLayout;

// Referenced classes of package com.wishabi.flipp.app:
//            FlippApplication, PrintCouponFragment

public class PrintCouponActivity extends Activity
{

    public PrintCouponActivity()
    {
    }

    public static Intent a()
    {
        android.content.Context context = FlippApplication.b();
        if (context == null)
        {
            return null;
        } else
        {
            return new Intent(context, com/wishabi/flipp/app/PrintCouponActivity);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(5);
        setContentView(new FrameLayout(this), new android.view.ViewGroup.LayoutParams(-1, -1));
        setTitle(0x7f0e0105);
        bundle = getFragmentManager();
        if ((PrintCouponFragment)bundle.findFragmentByTag("print_coupon_fragment") == null)
        {
            PrintCouponFragment printcouponfragment = PrintCouponFragment.a();
            bundle.beginTransaction().add(0x1020002, printcouponfragment, "print_coupon_fragment").commit();
        }
        bundle = getActionBar();
        if (bundle != null)
        {
            bundle.setDisplayHomeAsUpEnabled(true);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            menuitem = bd.a(this);
            if (android.os.Build.VERSION.SDK_INT >= 16 && bd.a(this, menuitem))
            {
                dd.a(this).a(this).a();
            } else
            {
                finish();
            }
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }
}
