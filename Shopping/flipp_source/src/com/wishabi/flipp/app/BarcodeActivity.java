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
//            dm, FlippApplication, e, dl

public class BarcodeActivity extends Activity
    implements dm
{

    public BarcodeActivity()
    {
    }

    public static Intent a(Bundle bundle)
    {
        Object obj;
        if (bundle != null)
        {
            if ((obj = FlippApplication.b()) != null)
            {
                obj = new Intent(((android.content.Context) (obj)), com/wishabi/flipp/app/BarcodeActivity);
                ((Intent) (obj)).putExtra("barcode_fragment_params", bundle);
                return ((Intent) (obj));
            }
        }
        return null;
    }

    public final void a(Class class1, Bundle bundle)
    {
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
        e e1 = (e)fragmentmanager.findFragmentByTag("barcode_fragment");
        bundle = e1;
        if (e1 == null)
        {
            bundle = e.a(getIntent().getBundleExtra("barcode_fragment_params"));
            fragmentmanager.beginTransaction().add(0x1020002, bundle, "barcode_fragment").commit();
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
