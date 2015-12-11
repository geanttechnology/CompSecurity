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
//            dm, FlippApplication, fu, dl

public class WebViewActivity extends Activity
    implements dm
{

    public WebViewActivity()
    {
    }

    public static Intent a(Bundle bundle)
    {
        Object obj;
        if (bundle != null)
        {
            if ((obj = FlippApplication.b()) != null)
            {
                obj = new Intent(((android.content.Context) (obj)), com/wishabi/flipp/app/WebViewActivity);
                ((Intent) (obj)).putExtra("webview_fragment_params", bundle);
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
        fu fu1 = (fu)getFragmentManager().findFragmentByTag("webview");
        bundle = fu1;
        if (fu1 == null)
        {
            Bundle bundle1 = getIntent().getBundleExtra("webview_fragment_params");
            bundle = new fu();
            bundle.setArguments(bundle1);
            getFragmentManager().beginTransaction().add(0x1020002, bundle, "webview").commit();
        }
        if (getActionBar() != null)
        {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
        bundle.b = this;
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
