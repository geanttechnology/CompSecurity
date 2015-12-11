// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import android.os.Bundle;
import android.support.v4.app.k;
import android.support.v4.app.m;
import android.view.MenuItem;
import com.shazam.android.base.activities.AutoToolbarBaseAppCompatActivity;
import com.shazam.android.fragment.explore.ExploreChartFragment;
import com.shazam.android.k.f.i;
import com.shazam.android.k.f.j;
import com.shazam.model.analytics.AnalyticsInfo;
import com.shazam.model.analytics.event.DefinedEventParameterKey;

public class ExploreActivity extends AutoToolbarBaseAppCompatActivity
{

    private final j a = new j();

    public ExploreActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(null);
        setTitle(0x7f09007a);
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

    protected void onResume()
    {
        super.onResume();
        k k1 = getSupportFragmentManager();
        if (k1.a("fragmentExploreTag") == null)
        {
            android.support.v4.app.Fragment fragment = ExploreChartFragment.a(j.a(getIntent()).a().a(DefinedEventParameterKey.SCREEN_ORIGIN));
            k1.a().a(0x7f1100c3, fragment, "fragmentExploreTag").a();
        }
    }
}
