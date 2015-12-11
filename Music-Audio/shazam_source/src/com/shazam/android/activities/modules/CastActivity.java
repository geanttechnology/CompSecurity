// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.modules;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.k;
import android.support.v4.app.m;
import android.view.MenuItem;
import com.shazam.android.activities.a.a;
import com.shazam.android.base.activities.AutoToolbarBaseAppCompatActivity;
import com.shazam.android.fragment.cast.CastFragment;

public class CastActivity extends AutoToolbarBaseAppCompatActivity
{

    public CastActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setDefaultContentView();
        if (bundle == null)
        {
            bundle = CastFragment.a(getIntent().getExtras(), a.a(getIntent()));
            getSupportFragmentManager().a().b(0x7f1100c3, bundle, "CAST_FRAGMENT").b();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            onBackPressed();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }
}
