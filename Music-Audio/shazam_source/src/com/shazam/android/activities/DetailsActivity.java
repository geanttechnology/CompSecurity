// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.k;
import android.support.v4.app.m;
import android.view.MenuItem;
import android.view.View;
import com.shazam.android.af.a.a;
import com.shazam.android.base.activities.BaseAppCompatActivity;
import com.shazam.android.fragment.secondarydetails.DetailsFragment;
import com.shazam.android.k.f.r;
import com.shazam.android.persistence.e.d;
import com.shazam.android.util.h.h;
import com.shazam.android.widget.n;
import com.shazam.i.b.ah.c.b;

// Referenced classes of package com.shazam.android.activities:
//            g

public class DetailsActivity extends BaseAppCompatActivity
    implements a, com.shazam.android.fragment.musicdetails.a
{

    private final d b = com.shazam.i.b.ah.c.b.a();
    private final n c = com.shazam.i.b.ay.a.a();
    private View d;
    private View e;
    private com.shazam.android.fragment.musicdetails.a f;

    public DetailsActivity()
    {
    }

    private void a(Configuration configuration)
    {
        if (configuration.orientation == 2)
        {
            c.a(d, getResources().getDrawable(0x7f0f0083));
            return;
        } else
        {
            c.a(d);
            return;
        }
    }

    private boolean c()
    {
        return com.shazam.android.activities.a.a.a(getIntent()) == null;
    }

    public final View a(View view)
    {
        View view1 = view.findViewById(0x7f1100e2);
        if (view1 == null)
        {
            return view;
        } else
        {
            return view1;
        }
    }

    public final void a()
    {
        f.a();
    }

    public final void b()
    {
        f.b();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        a(configuration);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030034);
        f = new g(this);
        d = findViewById(0x7f1100e2);
        e = findViewById(0x7f1100c4);
        boolean flag;
        if (c() && b.a())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            com.shazam.android.activities.b.b.a(this, getIntent());
            finish();
        }
    }

    public void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            if (c())
            {
                com.shazam.android.activities.b.a.a(this, false);
                finish();
            } else
            {
                onBackPressed();
            }
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    public void onPause()
    {
        super.onPause();
        d.setBackgroundResource(0x7f0f0083);
        e.setVisibility(0);
        k k1 = getSupportFragmentManager();
        DetailsFragment detailsfragment = (DetailsFragment)k1.a("DETAILS_FRAGMENT");
        k1.a().a(detailsfragment).b();
        h.a(detailsfragment.a);
    }

    public void onResume()
    {
        super.onResume();
        DetailsFragment detailsfragment = DetailsFragment.a(getIntent().getData(), r.a(com.shazam.android.activities.a.a.a(getIntent())));
        getSupportFragmentManager().a().b(0x7f1100c5, detailsfragment, "DETAILS_FRAGMENT").a();
        e.setVisibility(8);
        a(getResources().getConfiguration());
    }
}
