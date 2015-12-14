// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.d;
import com.socialin.android.util.Utils;
import myobfuscated.cv.c;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            SendFeedbackActivity

public class AboutPicsartActivity extends BaseActivity
    implements android.view.View.OnClickListener
{

    public AboutPicsartActivity()
    {
    }

    public void onClick(View view)
    {
        if (view.getId() == 0x7f100118)
        {
            c.a(this);
        } else
        {
            if (view.getId() == 0x7f100119)
            {
                view = new Intent();
                view.setAction("android.intent.action.SEND");
                view.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(getString(0x7f080598)).append(" ").append(getString(0x7f0808b9)).toString());
                view.setType("text/plain");
                startActivity(view);
                return;
            }
            if (view.getId() == 0x7f10011a)
            {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(0x7f0808bf))));
                return;
            }
            if (view.getId() == 0x7f10011b)
            {
                startActivity(new Intent(this, com/socialin/android/picsart/profile/activity/SendFeedbackActivity));
                return;
            }
            if (view.getId() == 0x7f10011d)
            {
                c.d(this);
                return;
            }
            if (view.getId() == 0x7f10011e)
            {
                c.e(this);
                return;
            }
            if (view.getId() == 0x7f10011f)
            {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(0x7f0808f9))));
                return;
            }
            if (view.getId() == 0x7f100117)
            {
                onBackPressed();
                return;
            }
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030019);
        bundle = getSupportActionBar();
        if (bundle != null)
        {
            bundle.setHomeButtonEnabled(true);
            bundle.setDisplayHomeAsUpEnabled(true);
            bundle.setTitle(getString(0x7f08003d));
            findViewById(0x7f100117).setVisibility(8);
        } else
        {
            findViewById(0x7f100116).setLayoutParams(new android.widget.FrameLayout.LayoutParams((int)Utils.a(565F, this), -2));
        }
        findViewById(0x7f100118).setOnClickListener(this);
        findViewById(0x7f100119).setOnClickListener(this);
        findViewById(0x7f10011a).setOnClickListener(this);
        findViewById(0x7f10011b).setOnClickListener(this);
        findViewById(0x7f10011d).setOnClickListener(this);
        findViewById(0x7f10011e).setOnClickListener(this);
        findViewById(0x7f10011f).setOnClickListener(this);
        findViewById(0x7f100117).setOnClickListener(this);
        if (!getString(0x7f0808c8).equals(getString(0x7f0808ce)))
        {
            findViewById(0x7f100118).setVisibility(8);
            findViewById(0x7f10011f).setVisibility(8);
        }
        if (getString(0x7f0808c8).equalsIgnoreCase(getString(0x7f0808cc)))
        {
            findViewById(0x7f10011c).setVisibility(8);
            findViewById(0x7f100119).setVisibility(8);
        }
        try
        {
            bundle = getPackageManager().getPackageInfo(getPackageName(), 0);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            bundle = null;
            d.a("AboutPicsart", namenotfoundexception);
        }
        if (bundle != null)
        {
            ((TextView)findViewById(0x7f100120)).setText((new StringBuilder()).append(getString(0x7f080324)).append(" ").append(((PackageInfo) (bundle)).versionName).toString());
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            finish();
        }
        return true;
    }
}
