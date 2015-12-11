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
import android.view.Window;

// Referenced classes of package com.wishabi.flipp.app:
//            dm, fr, FlippApplication, dl

public class WebVideoActivity extends Activity
    implements dm
{

    public WebVideoActivity()
    {
    }

    public static Intent a(String s, String s1)
    {
        s = fr.a(s, s1);
        s1 = FlippApplication.b();
        if (s1 == null)
        {
            return null;
        } else
        {
            s1 = new Intent(s1, com/wishabi/flipp/app/WebVideoActivity);
            s1.putExtra("web_video_fragment_params", s);
            return s1;
        }
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
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        getWindow().addFlags(128);
        FragmentManager fragmentmanager = getFragmentManager();
        fr fr1 = (fr)fragmentmanager.findFragmentByTag("web_video_fragment");
        bundle = fr1;
        if (fr1 == null)
        {
            bundle = fr.a(getIntent().getBundleExtra("web_video_fragment_params"));
            fragmentmanager.beginTransaction().add(0x1020002, bundle, "web_video_fragment").commit();
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
