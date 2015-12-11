// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.modules;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.k;
import android.support.v4.app.m;
import android.view.MenuItem;
import android.view.View;
import com.shazam.android.base.activities.AutoToolbarBaseAppCompatActivity;
import com.shazam.android.fragment.discography.DiscographyFragment;
import com.shazam.android.fragment.musicdetails.a;
import com.shazam.android.k.f.r;
import com.shazam.android.persistence.e.d;
import com.shazam.android.util.h.h;
import com.shazam.i.b.ah.c.b;

public class DiscographyActivity extends AutoToolbarBaseAppCompatActivity
    implements a
{

    private final d b = com.shazam.i.b.ah.c.b.a();
    private View c;
    private View d;

    public DiscographyActivity()
    {
    }

    private boolean c()
    {
        return com.shazam.android.activities.a.a.a(getIntent()) == null;
    }

    public final void a()
    {
        android.support.v7.a.a a1 = getSupportActionBar();
        if (a1.e())
        {
            a1.d();
        }
    }

    public final void b()
    {
        android.support.v7.a.a a1 = getSupportActionBar();
        if (!a1.e())
        {
            a1.c();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03001c);
        c = findViewById(0x7f1100c3);
        d = findViewById(0x7f1100c4);
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
            com.shazam.android.activities.b.b.a(this, getIntent(), "startup");
            finish();
        }
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

    protected void onPause()
    {
        super.onPause();
        c.setBackgroundResource(0x7f0f0083);
        d.setVisibility(0);
        k k1 = getSupportFragmentManager();
        DiscographyFragment discographyfragment = (DiscographyFragment)k1.a("DISCOGRAPHY_FRAGMENT");
        k1.a().a(discographyfragment).b();
        h.a(discographyfragment.getView());
    }

    protected void onResume()
    {
        super.onResume();
        DiscographyFragment discographyfragment = DiscographyFragment.a(getIntent().getExtras(), getIntent().getData(), r.a(com.shazam.android.activities.a.a.a(getIntent())));
        getSupportFragmentManager().a().b(0x7f1100c5, discographyfragment, "DISCOGRAPHY_FRAGMENT").b();
        d.setVisibility(8);
        c.setBackgroundResource(0x106000d);
    }
}
