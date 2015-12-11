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
import com.wishabi.flipp.b.p;

// Referenced classes of package com.wishabi.flipp.app:
//            dm, FlippApplication, n, e, 
//            BarcodeActivity, z, CouponHelpActivity, dl

public class CouponDetailsActivity extends Activity
    implements dm
{

    public CouponDetailsActivity()
    {
    }

    public static Intent a(Bundle bundle)
    {
        Object obj;
        if (bundle != null)
        {
            if ((obj = FlippApplication.b()) != null)
            {
                obj = new Intent(((android.content.Context) (obj)), com/wishabi/flipp/app/CouponDetailsActivity);
                ((Intent) (obj)).putExtra("coupon_details_fragment_params", bundle);
                return ((Intent) (obj));
            }
        }
        return null;
    }

    public static Intent a(int ai[], boolean flag, p p)
    {
        return a(n.a(ai, flag, p));
    }

    public final void a(Class class1, Bundle bundle)
    {
        Object obj = null;
        if (class1 == com/wishabi/flipp/app/e)
        {
            bundle = BarcodeActivity.a(bundle);
        } else
        {
            bundle = obj;
            if (class1 == com/wishabi/flipp/app/z)
            {
                bundle = new Intent(this, com/wishabi/flipp/app/CouponHelpActivity);
            }
        }
        if (bundle == null)
        {
            return;
        } else
        {
            startActivity(bundle);
            overridePendingTransition(0x7f040001, 0x7f040002);
            return;
        }
    }

    public final void a(String s)
    {
        setTitle(s);
    }

    public final boolean a()
    {
        return false;
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        overridePendingTransition(0x7f040000, 0x7f040003);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(new FrameLayout(this), new android.view.ViewGroup.LayoutParams(-1, -1));
        FragmentManager fragmentmanager = getFragmentManager();
        n n1 = (n)fragmentmanager.findFragmentByTag("coupon_details_fragment");
        bundle = n1;
        if (n1 == null)
        {
            bundle = n.a(getIntent().getBundleExtra("coupon_details_fragment_params"));
            fragmentmanager.beginTransaction().add(0x1020002, bundle, "coupon_details_fragment").commit();
        }
        bundle.b = this;
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
                overridePendingTransition(0x7f040000, 0x7f040003);
            }
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }
}
