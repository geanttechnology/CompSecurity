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

// Referenced classes of package com.wishabi.flipp.app:
//            dm, bx, FlippApplication, fu, 
//            WebViewActivity, dl

public class FlyerInfoActivity extends Activity
    implements dm
{

    public FlyerInfoActivity()
    {
    }

    public static Intent a(int i, String s, boolean flag, boolean flag1)
    {
        s = bx.a(i, s, flag, flag1);
        Object obj = FlippApplication.b();
        if (obj == null)
        {
            return null;
        } else
        {
            obj = new Intent(((android.content.Context) (obj)), com/wishabi/flipp/app/FlyerInfoActivity);
            ((Intent) (obj)).putExtra("flyer_info_fragment_params", s);
            return ((Intent) (obj));
        }
    }

    public final void a(Class class1, Bundle bundle)
    {
        Intent intent = null;
        if (class1 == com/wishabi/flipp/app/fu)
        {
            intent = WebViewActivity.a(bundle);
        }
        if (intent == null)
        {
            return;
        } else
        {
            startActivity(intent);
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
        bx bx1 = (bx)getFragmentManager().findFragmentByTag("flyer_info");
        bundle = bx1;
        if (bx1 == null)
        {
            Bundle bundle1 = getIntent().getBundleExtra("flyer_info_fragment_params");
            bundle = new bx();
            bundle.setArguments(bundle1);
            getFragmentManager().beginTransaction().add(0x1020002, bundle, "flyer_info").commit();
        }
        bundle.b = this;
        if (getActionBar() != null)
        {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            if (bd.a(this, bd.a(this)))
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
